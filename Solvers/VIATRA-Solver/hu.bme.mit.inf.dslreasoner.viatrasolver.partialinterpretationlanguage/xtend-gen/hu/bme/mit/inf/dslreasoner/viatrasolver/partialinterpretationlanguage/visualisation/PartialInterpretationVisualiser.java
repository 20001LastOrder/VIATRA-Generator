package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation.PartialInterpretationVisualisation;

@SuppressWarnings("all")
public interface PartialInterpretationVisualiser {
  PartialInterpretationVisualisation visualiseConcretization(final PartialInterpretation partialInterpretation);
  
  PartialInterpretationVisualisation visualisePartialSolution(final PartialInterpretation partialInterpretation);
}
