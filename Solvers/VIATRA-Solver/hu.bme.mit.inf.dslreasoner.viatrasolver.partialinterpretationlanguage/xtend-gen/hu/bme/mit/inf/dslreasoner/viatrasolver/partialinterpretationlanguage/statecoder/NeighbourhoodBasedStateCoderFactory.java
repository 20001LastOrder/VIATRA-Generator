package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2ImmutableTypeLattice;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedPartialInterpretationStateCoder;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedStateCoderFactory;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.NeighbourhoodBasedPartialInterpretationStateCoder;
import java.util.Map;

@SuppressWarnings("all")
public class NeighbourhoodBasedStateCoderFactory extends AbstractNeighbourhoodBasedStateCoderFactory {
  public NeighbourhoodBasedStateCoderFactory() {
  }
  
  public NeighbourhoodBasedStateCoderFactory(final NeighbourhoodOptions options) {
    super(options);
  }
  
  @Override
  protected AbstractNeighbourhoodBasedPartialInterpretationStateCoder doCreateStateCoder(final NeighbourhoodOptions options) {
    PartialInterpretation2ImmutableTypeLattice _partialInterpretation2ImmutableTypeLattice = new PartialInterpretation2ImmutableTypeLattice();
    return new NeighbourhoodBasedPartialInterpretationStateCoder<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor>(_partialInterpretation2ImmutableTypeLattice, options);
  }
}
