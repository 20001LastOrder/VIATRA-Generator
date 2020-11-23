package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.IncomingRelation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelation;
import java.util.Map;

@SuppressWarnings("all")
public class FurtherNodeDescriptorWithEquivalenceCounter extends FurtherNodeDescriptor<AbstractNodeDescriptor> {
  public FurtherNodeDescriptorWithEquivalenceCounter(final AbstractNodeDescriptor previousRepresentation, final Map<IncomingRelation<AbstractNodeDescriptor>, Integer> incomingEdges, final Map<OutgoingRelation<AbstractNodeDescriptor>, Integer> outgoingEdges, final Map<DefinedElement, FurtherNodeDescriptor<AbstractNodeDescriptor>> node2Representation) {
    super(previousRepresentation, incomingEdges, outgoingEdges);
  }
}
