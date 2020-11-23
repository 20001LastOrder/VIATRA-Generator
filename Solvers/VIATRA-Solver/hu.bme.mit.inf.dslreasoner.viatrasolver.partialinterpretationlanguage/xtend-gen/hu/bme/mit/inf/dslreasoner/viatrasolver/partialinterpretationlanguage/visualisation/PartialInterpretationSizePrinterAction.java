package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation.PartialInterpretationVisualisation;
import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class PartialInterpretationSizePrinterAction implements PartialInterpretationVisualisation {
  private final int size;
  
  private long millis;
  
  public PartialInterpretationSizePrinterAction(final int size, final long millis) {
    this.size = size;
    this.millis = millis;
  }
  
  @Override
  public void writeToFile(final ReasonerWorkspace workspace, final String name) {
    InputOutput.<String>println((((("Size=" + Integer.valueOf(this.size)) + ", Time=") + Long.valueOf((this.millis / 1000))) + "s"));
  }
}
