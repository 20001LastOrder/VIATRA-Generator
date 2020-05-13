/*
 * generated by Xtext 2.18.0.M3
 */
package org.eclipse.viatra.solver.language.ide

import com.google.inject.Guice
import org.eclipse.viatra.solver.language.SolverLanguageRuntimeModule
import org.eclipse.viatra.solver.language.SolverLanguageStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class SolverLanguageIdeSetup extends SolverLanguageStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new SolverLanguageRuntimeModule, new SolverLanguageIdeModule))
	}
	
}