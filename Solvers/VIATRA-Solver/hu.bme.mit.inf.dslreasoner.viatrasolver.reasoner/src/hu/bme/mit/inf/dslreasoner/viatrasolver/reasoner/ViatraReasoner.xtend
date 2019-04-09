package hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner

import com.google.common.collect.ImmutableList
import com.google.common.collect.Lists
import hu.bme.mit.inf.dslreasoner.logic.model.builder.DocumentationLevel
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicReasoner
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicReasonerException
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicSolverConfiguration
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguagePackage
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicproblemPackage
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.LogicresultFactory
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.ModelResult
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.ModelGenerationMethodProvider
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.ScopePropagator
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.PartialInterpretationInitialiser
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialinterpretationPackage
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.IdentifierBasedStateCoderFactory
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.NeighbourhoodBasedStateCoderFactory
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.BestFirstStrategyForModelGeneration
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.DiversityChecker
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.LoggerSolutionFoundHandler
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.ModelGenerationCompositeObjective
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.PartialModelAsLogicInterpretation
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.ScopeObjective
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.SurelyViolatedObjectiveGlobalConstraint
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.UnfinishedMultiplicityObjective
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.ViatraReasonerSolutionSaver
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.dse.WF2ObjectiveConverter
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.optimization.ThreeValuedCostElement
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.optimization.ThreeValuedCostObjective
import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.viatra.dse.api.DesignSpaceExplorer
import org.eclipse.viatra.dse.api.DesignSpaceExplorer.DseLoggingLevel
import org.eclipse.viatra.dse.solutionstore.SolutionStore
import org.eclipse.viatra.dse.statecode.IStateCoderFactory

class ViatraReasoner extends LogicReasoner {
	val PartialInterpretationInitialiser initialiser = new PartialInterpretationInitialiser()
	val ModelGenerationMethodProvider modelGenerationMethodProvider = new ModelGenerationMethodProvider
	val extension LogicresultFactory factory = LogicresultFactory.eINSTANCE
	val WF2ObjectiveConverter wf2ObjectiveConverter = new WF2ObjectiveConverter

	override solve(LogicProblem problem, LogicSolverConfiguration configuration,
		ReasonerWorkspace workspace) throws LogicReasonerException {
		val viatraConfig = configuration.asConfig

		if (viatraConfig.debugConfiguration.logging) {
			DesignSpaceExplorer.turnOnLogging(DseLoggingLevel.VERBOSE_FULL)
		} else {
			DesignSpaceExplorer.turnOnLogging(DseLoggingLevel.WARN)
		}

		val DesignSpaceExplorer dse = new DesignSpaceExplorer();

		dse.addMetaModelPackage(LogiclanguagePackage.eINSTANCE)
		dse.addMetaModelPackage(LogicproblemPackage.eINSTANCE)
		dse.addMetaModelPackage(PartialinterpretationPackage.eINSTANCE)

		val transformationStartTime = System.nanoTime

		val emptySolution = initialiser.initialisePartialInterpretation(problem, viatraConfig.typeScopes).output
		if ((viatraConfig.documentationLevel == DocumentationLevel::FULL ||
			viatraConfig.documentationLevel == DocumentationLevel::NORMAL) && workspace !== null) {
			workspace.writeModel(emptySolution, "init.partialmodel")
		}
		emptySolution.problemConainer = problem

		val ScopePropagator scopePropagator = new ScopePropagator(emptySolution)
		scopePropagator.propagateAllScopeConstraints

		val method = modelGenerationMethodProvider.createModelGenerationMethod(
			problem,
			emptySolution,
			workspace,
			viatraConfig.nameNewElements,
			viatraConfig.typeInferenceMethod,
			scopePropagator,
			viatraConfig.documentationLevel
		)

		dse.addObjective(new ModelGenerationCompositeObjective(
			new ScopeObjective,
			method.unfinishedMultiplicities.map[new UnfinishedMultiplicityObjective(it)],
			wf2ObjectiveConverter.createCompletenessObjective(method.unfinishedWF)
		))

		val extremalObjectives = Lists.newArrayListWithExpectedSize(viatraConfig.costObjectives.size)
		for (entry : viatraConfig.costObjectives.indexed) {
			val objectiveName = '''costObjective«entry.key»'''
			val objectiveConfig = entry.value
			val elementsBuilder = ImmutableList.builder
			for (elementConfig : objectiveConfig.elements) {
				val relationName = elementConfig.patternQualifiedName
				val modalQueries = method.modalRelationQueries.get(relationName)
				if (modalQueries === null) {
					throw new IllegalArgumentException("Unknown relation: " + relationName)
				}
				elementsBuilder.add(new ThreeValuedCostElement(
					modalQueries.currentQuery,
					modalQueries.mayQuery,
					modalQueries.mustQuery,
					elementConfig.weight
				))
			}
			val costElements = elementsBuilder.build
			val costObjective = new ThreeValuedCostObjective(objectiveName, costElements, objectiveConfig.kind,
				objectiveConfig.threshold, 3)
			dse.addObjective(costObjective)
			if (objectiveConfig.findExtremum) {
				extremalObjectives += costObjective
			}
		}

		val numberOfRequiredSolutions = configuration.solutionScope.numberOfRequiredSolutions
		val solutionStore = if (extremalObjectives.empty) {
				new SolutionStore(numberOfRequiredSolutions)
			} else {
				new SolutionStore()
			}
		solutionStore.registerSolutionFoundHandler(new LoggerSolutionFoundHandler(viatraConfig))
		val diversityChecker = DiversityChecker.of(viatraConfig.diversityRequirement)
		val solutionSaver = new ViatraReasonerSolutionSaver(newArrayList(extremalObjectives), numberOfRequiredSolutions,
			diversityChecker)
		val solutionCopier = solutionSaver.solutionCopier
		solutionStore.withSolutionSaver(solutionSaver)
		dse.solutionStore = solutionStore

		dse.addGlobalConstraint(wf2ObjectiveConverter.createInvalidationGlobalConstraint(method.invalidWF))
		dse.addGlobalConstraint(new SurelyViolatedObjectiveGlobalConstraint(solutionSaver))
		for (additionalConstraint : viatraConfig.searchSpaceConstraints.additionalGlobalConstraints) {
			dse.addGlobalConstraint(additionalConstraint.apply(method))
		}

		dse.setInitialModel(emptySolution, false)

		val IStateCoderFactory statecoder = if (viatraConfig.stateCoderStrategy == StateCoderStrategy.Neighbourhood) {
				new NeighbourhoodBasedStateCoderFactory
			} else {
				new IdentifierBasedStateCoderFactory
			}
		dse.stateCoderFactory = statecoder

		dse.maxNumberOfThreads = 1

		for (rule : method.relationRefinementRules) {
			dse.addTransformationRule(rule)
		}
		for (rule : method.objectRefinementRules) {
			dse.addTransformationRule(rule)
		}

		val strategy = new BestFirstStrategyForModelGeneration(workspace, viatraConfig, method)
		viatraConfig.progressMonitor.workedForwardTransformation

		val transformationTime = System.nanoTime - transformationStartTime
		val solverStartTime = System.nanoTime

		var boolean stoppedByTimeout
		try {
			stoppedByTimeout = dse.startExplorationWithTimeout(strategy, configuration.runtimeLimit * 1000);
		} catch (NullPointerException npe) {
			stoppedByTimeout = false
		}
		val solverTime = System.nanoTime - solverStartTime
		viatraConfig.progressMonitor.workedSearchFinished

		// additionalMatches = strategy.solutionStoreWithCopy.additionalMatches
		val statistics = createStatistics => [
			// it.solverTime = viatraConfig.runtimeLimit
			it.solverTime = (solverTime / 1000000) as int
			it.transformationTime = (transformationTime / 1000000) as int
			for (pair : solutionCopier.getAllCopierRuntimes(true).indexed) {
				it.entries += createIntStatisticEntry => [
					it.name = '''_Solution«pair.key»FoundAt'''
					it.value = (pair.value / 1000000) as int
				]
			}
			it.entries += createIntStatisticEntry => [
				it.name = "TransformationExecutionTime"
				it.value = (method.statistics.transformationExecutionTime / 1000000) as int
			]
			it.entries += createIntStatisticEntry => [
				it.name = "TypeAnalysisTime"
				it.value = (method.statistics.PreliminaryTypeAnalisisTime / 1000000) as int
			]
			it.entries += createIntStatisticEntry => [
				it.name = "StateCoderTime"
				it.value = (statecoder.runtime / 1000000) as int
			]
			it.entries += createIntStatisticEntry => [
				it.name = "StateCoderFailCount"
				it.value = strategy.numberOfStatecoderFail
			]
			it.entries += createIntStatisticEntry => [
				it.name = "SolutionCopyTime"
				it.value = (solutionCopier.getTotalCopierRuntime / 1000000) as int
			]
			if (diversityChecker.isActive) {
				it.entries += createIntStatisticEntry => [
					it.name = "SolutionDiversityCheckTime"
					it.value = (diversityChecker.totalRuntime / 1000000) as int
				]
				it.entries += createRealStatisticEntry => [
					it.name = "SolutionDiversitySuccessRate"
					it.value = diversityChecker.successRate
				]
			}
		]

		viatraConfig.progressMonitor.workedBackwardTransformationFinished

		if (stoppedByTimeout) {
			return createInsuficientResourcesResult => [
				it.problem = problem
				it.resourceName = "time"
				it.representation += solutionCopier.getPartialInterpretations(true)
				it.statistics = statistics
			]
		} else {
			if (solutionStore.solutions.empty) {
				return createInconsistencyResult => [
					it.problem = problem
					it.representation += solutionCopier.getPartialInterpretations(true)
					it.statistics = statistics
				]
			} else {
				return createModelResult => [
					it.problem = problem
					it.trace = solutionCopier.getTraces(true)
					it.representation += solutionCopier.getPartialInterpretations(true)
					it.statistics = statistics
				]
			}
		}
	}

	private def dispatch long runtime(NeighbourhoodBasedStateCoderFactory sc) {
		sc.sumStatecoderRuntime
	}

	private def dispatch long runtime(IdentifierBasedStateCoderFactory sc) {
		sc.sumStatecoderRuntime
	}

	override getInterpretations(ModelResult modelResult) {
		val indexes = 0 ..< modelResult.representation.size
		val traces = modelResult.trace as List<Map<EObject, EObject>>;
		val res = indexes.map [ i |
			new PartialModelAsLogicInterpretation(modelResult.representation.get(i) as PartialInterpretation,
				traces.get(i))
		].toList
		return res
	}

	private def ViatraReasonerConfiguration asConfig(LogicSolverConfiguration configuration) {
		if (configuration instanceof ViatraReasonerConfiguration) {
			return configuration
		} else
			throw new IllegalArgumentException('''Wrong configuration. Expected: «ViatraReasonerConfiguration.name», but got: «configuration.class.name»"''')
	}
}
