package ca.mcgill.ecse.dslreasoner.vampire.reasoner.builder

import ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSConstant
import ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSVariable
import ca.mcgill.ecse.dslreasoner.vampireLanguage.VampireLanguageFactory
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicSolverConfiguration
import java.util.List

class Logic2VampireLanguageMapper_ScopeMapper {
	private val extension VampireLanguageFactory factory = VampireLanguageFactory.eINSTANCE
	private val Logic2VampireLanguageMapper_Support support = new Logic2VampireLanguageMapper_Support
	val Logic2VampireLanguageMapper base

	public new(Logic2VampireLanguageMapper base) {
		this.base = base
	}

	def dispatch public void transformScope(LogicSolverConfiguration config, Logic2VampireLanguageMapperTrace trace) {
		val VLSVariable variable = createVLSVariable => [it.name = "A"]

		// 1. make a list of constants equaling the min number of specified objects
		val localInstances = newArrayList
		for (var i = 0; i < config.typeScopes.minNewElements; i++) {
			val num = i + 1
			val cst = createVLSConstant => [
				it.name = "o" + num
			]
			trace.uniqueInstances.add(cst)
			localInstances.add(cst)
		}

		// TODO: specify for the max
		if (config.typeScopes.minNewElements != 0) {
			// 2. Create initial fof formula to specify the number of elems
			val cstDec = createVLSFofFormula => [
				it.name = "typeScope"
				it.fofRole = "axiom"
				it.fofFormula = createVLSUniversalQuantifier => [
					it.variables += support.duplicate(variable)
					// check below
					it.operand = createVLSImplies => [
						it.left = support.unfoldOr(localInstances.map [ i |
							createVLSEquality => [
								it.left = createVLSVariable => [it.name = variable.name]
								it.right = i
							]
						])
						it.right = support.topLevelTypeFunc
					]
				]
			]
			trace.specification.formulas += cstDec

			// TODO: specify for scope per type
			// 3. Specify uniqueness of elements
			val uniqueness = createVLSFofFormula => [
				it.name = "typeUniqueness"
				it.fofRole = "axiom"
				it.fofFormula = support.establishUniqueness(trace.uniqueInstances)
			]
			trace.specification.formulas += uniqueness
		}
	}
}
