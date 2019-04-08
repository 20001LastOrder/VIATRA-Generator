package hu.bme.mit.inf.dslreasoner.application.execution

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.AlloySolver
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.AlloySolverConfiguration
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.CostObjectiveFunction
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ObjectiveEntry
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.OptimizationEntry
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.Solver
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ThresholdEntry
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicSolverConfiguration
import hu.bme.mit.inf.dslreasoner.smt.reasoner.SMTSolver
import hu.bme.mit.inf.dslreasoner.smt.reasoner.SmtSolverConfiguration
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.CostObjectiveConfiguration
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.CostObjectiveElementConfiguration
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.DiversityDescriptor
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.ViatraReasoner
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.ViatraReasonerConfiguration
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.optimization.ObjectiveKind
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.optimization.ObjectiveThreshold
import hu.bme.mit.inf.dslreasoner.visualisation.pi2graphviz.GraphvizVisualiser
import java.util.List
import java.util.Map
import java.util.Optional
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternModel
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.xbase.lib.Functions.Function1

class SolverLoader {
	def loadSolver(Solver solver, Map<String, String> config) {
		switch (solver) {
			case ALLOY_SOLVER: return new AlloySolver
			case SMT_SOLVER: return new SMTSolver
			case VIATRA_SOLVER: return new ViatraReasoner
		}
	}

	private def <Type> Optional<Type> getAsType(Map<String, String> config, String key, ScriptConsole console,
		Function1<String, Type> parser, Class<Type> requestedType) {
		if (config.containsKey(key)) {
			val stringValue = config.get(key)
			try {
				val parsedValue = parser.apply(stringValue)
				return Optional.of(parsedValue)
			} catch (Exception e) {
				console.writeError('''Unable to parse configuration value for "«key»" to «requestedType.simpleName»!''')
				return Optional::empty
			}
		} else {
			return Optional::empty
		}
	}

	private def getAsInteger(Map<String, String> config, String key, ScriptConsole console) {
		return getAsType(config, key, console, [x|Integer.parseInt(x)], Integer)
	}

	private def getAsBoolean(Map<String, String> config, String key, ScriptConsole console) {
		return getAsType(config, key, console, [x|Boolean.parseBoolean(x)], Boolean)
	}

	private def getAsDouble(Map<String, String> config, String key, ScriptConsole console) {
		return getAsType(config, key, console, [x|Double.parseDouble(x)], Double)
	}

	def loadSolverConfig(Solver solver, Map<String, String> config, List<ObjectiveEntry> objectiveEntries,
		ScriptConsole console) {
		switch (solver) {
			case ALLOY_SOLVER: {
				if (!objectiveEntries.empty) {
					throw new IllegalArgumentException("Objectives are not supported by Alloy.")
				}
				val c = new SmtSolverConfiguration
				config.getAsBoolean("fixRandomSeed", console).ifPresent[c.fixRandomSeed = it]
				config.getAsType("path", console, [it], String).ifPresent[c.solverPath = it]
				c
			}
			case SMT_SOLVER: {
				if (!objectiveEntries.empty) {
					throw new IllegalArgumentException("Objectives are not supported by Z3.")
				}
				val c = new SmtSolverConfiguration
				config.getAsBoolean("fixRandomSeed", console).ifPresent[c.fixRandomSeed = it]
				config.getAsType("path", console, [it], String).ifPresent[c.solverPath = it]
				c
			}
			case VIATRA_SOLVER: {
				val c = new ViatraReasonerConfiguration
				c.debugConfiguration.partialInterpretatioVisualiser = new GraphvizVisualiser
				if (config.containsKey("diversity-range")) {
					val stringValue = config.get("diversity-range")
					try {
						val range = Integer.parseInt(stringValue)
						c.diversityRequirement = new DiversityDescriptor => [
							it.ensureDiversity = true
							it.range = range
						]
					} catch (NumberFormatException e) {
						console.writeError('''Malformed number format: «e.message»''')
					}
				}
				for (objectiveEntry : objectiveEntries) {
					val costObjectiveConfig = new CostObjectiveConfiguration
					switch (objectiveEntry) {
						OptimizationEntry: {
							costObjectiveConfig.findExtremum = true
							costObjectiveConfig.kind = switch (direction : objectiveEntry.direction) {
								case MAXIMIZE:
									ObjectiveKind.HIGHER_IS_BETTER
								case MINIMIZE:
									ObjectiveKind.LOWER_IS_BETTER
								default:
									throw new IllegalArgumentException("Unknown direction: " + direction)
							}
							costObjectiveConfig.threshold = ObjectiveThreshold.NO_THRESHOLD
						}
						ThresholdEntry: {
							costObjectiveConfig.findExtremum = false
							val threshold = objectiveEntry.threshold.doubleValue
							switch (operator : objectiveEntry.operator) {
								case LESS: {
									costObjectiveConfig.kind = ObjectiveKind.LOWER_IS_BETTER
									costObjectiveConfig.threshold = new ObjectiveThreshold.Exclusive(threshold)
								}
								case GREATER: {
									costObjectiveConfig.kind = ObjectiveKind.HIGHER_IS_BETTER
									costObjectiveConfig.threshold = new ObjectiveThreshold.Exclusive(threshold)
								}
								case LESS_EQUALS: {
									costObjectiveConfig.kind = ObjectiveKind.LOWER_IS_BETTER
									costObjectiveConfig.threshold = new ObjectiveThreshold.Exclusive(threshold)
								}
								case GREATER_EQUALS: {
									costObjectiveConfig.kind = ObjectiveKind.HIGHER_IS_BETTER
									costObjectiveConfig.threshold = new ObjectiveThreshold.Exclusive(threshold)
								}
								default:
									throw new IllegalArgumentException("Unknown operator: " + operator)
							}
						}
					}
					val function = objectiveEntry.function
					if (function instanceof CostObjectiveFunction) {
						for (costEntry : function.entries) {
							val element = new CostObjectiveElementConfiguration
							val pattern = costEntry.patternElement.pattern
							val packageName = costEntry.patternElement.package?.packageName ?:
								EcoreUtil2.getContainerOfType(pattern, PatternModel)?.packageName
							element.patternQualifiedName = if (packageName.nullOrEmpty) {
								pattern.name
							} else {
								packageName + "." + pattern.name
							}
							element.weight = costEntry.weight
							costObjectiveConfig.elements += element
						}
					} else {
						throw new IllegalArgumentException("Only cost objectives are supported by VIATRA.")
					}
					c.costObjectives += costObjectiveConfig
				}
				c
			}
			default:
				throw new UnsupportedOperationException('''Unknown solver: «solver»''')
		}
	}

	def dispatch void setRunIndex(AlloySolverConfiguration config, Map<String, String> parameters, int runIndex,
		ScriptConsole console) {
		parameters.getAsBoolean("randomize", console).ifPresent [
			if (it) {
				config.randomise = runIndex - 1
			}
		]
	}

	def dispatch void setRunIndex(LogicSolverConfiguration config, Map<String, String> parameters, int runIndex,
		ScriptConsole console) {
	}
}
