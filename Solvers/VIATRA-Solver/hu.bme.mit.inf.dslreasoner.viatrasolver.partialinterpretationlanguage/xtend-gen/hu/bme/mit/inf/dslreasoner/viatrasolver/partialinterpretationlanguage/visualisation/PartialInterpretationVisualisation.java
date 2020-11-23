package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation;

import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace;

@SuppressWarnings("all")
public interface PartialInterpretationVisualisation {
  void writeToFile(final ReasonerWorkspace workspace, final String name);
}
