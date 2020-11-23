package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation.PartialInterpretationSizePrinterAction;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation.PartialInterpretationVisualisation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation.PartialInterpretationVisualiser;

@SuppressWarnings("all")
public class PartialInterpretationSizePrinter implements PartialInterpretationVisualiser {
  private long startTime;
  
  public PartialInterpretationSizePrinter() {
    this.startTime = System.currentTimeMillis();
  }
  
  @Override
  public PartialInterpretationVisualisation visualiseConcretization(final PartialInterpretation partialInterpretation) {
    int _size = partialInterpretation.getNewElements().size();
    long _currentTimeMillis = System.currentTimeMillis();
    long _minus = (_currentTimeMillis - this.startTime);
    return new PartialInterpretationSizePrinterAction(_size, _minus);
  }
  
  @Override
  public PartialInterpretationVisualisation visualisePartialSolution(final PartialInterpretation partialInterpretation) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
