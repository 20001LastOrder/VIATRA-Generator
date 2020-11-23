package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.LocalNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodWithTraces;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2NeighbourhoodRepresentation;
import java.util.Map;

@SuppressWarnings("all")
public class PartialInterpretation2ImmutableTypeLattice extends PartialInterpretation2NeighbourhoodRepresentation<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> {
  public PartialInterpretation2ImmutableTypeLattice() {
    super(false, true);
  }
  
  public PartialInterpretation2ImmutableTypeLattice(final boolean deeprepresnetation, final boolean mergeSimilarNeighbourhood) {
    super(deeprepresnetation, mergeSimilarNeighbourhood);
  }
  
  @Override
  protected NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> createLocalRepresentation(final Map<DefinedElement, LocalNodeDescriptor> node2Representation, final Map<LocalNodeDescriptor, Integer> representation2Amount) {
    final NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> res = new NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor>(representation2Amount, node2Representation, 
      null);
    return res;
  }
  
  @Override
  protected NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> createFurtherRepresentation(final Map<FurtherNodeDescriptor<AbstractNodeDescriptor>, Integer> nodeDescriptors, final Map<DefinedElement, FurtherNodeDescriptor<AbstractNodeDescriptor>> node2Representation, final NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> previous, final boolean deepRepresentation) {
    if (deepRepresentation) {
      return new NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor>(nodeDescriptors, node2Representation, previous);
    } else {
      return new NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor>(nodeDescriptors, node2Representation, null);
    }
  }
}
