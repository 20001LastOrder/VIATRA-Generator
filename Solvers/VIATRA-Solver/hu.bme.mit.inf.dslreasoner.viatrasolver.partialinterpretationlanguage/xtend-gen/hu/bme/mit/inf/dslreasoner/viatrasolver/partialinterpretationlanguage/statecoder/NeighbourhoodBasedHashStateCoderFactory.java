package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2Hash;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedPartialInterpretationStateCoder;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedStateCoderFactory;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.NeighbourhoodBasedPartialInterpretationStateCoder;

@SuppressWarnings("all")
public class NeighbourhoodBasedHashStateCoderFactory extends AbstractNeighbourhoodBasedStateCoderFactory {
  public NeighbourhoodBasedHashStateCoderFactory() {
  }
  
  public NeighbourhoodBasedHashStateCoderFactory(final NeighbourhoodOptions options) {
    super(options);
  }
  
  @Override
  protected AbstractNeighbourhoodBasedPartialInterpretationStateCoder doCreateStateCoder(final NeighbourhoodOptions options) {
    PartialInterpretation2Hash _partialInterpretation2Hash = new PartialInterpretation2Hash();
    return new NeighbourhoodBasedPartialInterpretationStateCoder<Integer, Integer>(_partialInterpretation2Hash, options);
  }
}
