package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedPartialInterpretationStateCoder;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedStateCoderFactory;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.PairwiseNeighbourhoodBasedPartialInterpretationStateCoder;

@SuppressWarnings("all")
public class PairwiseNeighbourhoodBasedStateCoderFactory extends AbstractNeighbourhoodBasedStateCoderFactory {
  public PairwiseNeighbourhoodBasedStateCoderFactory() {
  }
  
  public PairwiseNeighbourhoodBasedStateCoderFactory(final NeighbourhoodOptions options) {
    super(options);
  }
  
  @Override
  protected AbstractNeighbourhoodBasedPartialInterpretationStateCoder doCreateStateCoder(final NeighbourhoodOptions options) {
    return new PairwiseNeighbourhoodBasedPartialInterpretationStateCoder(options);
  }
}
