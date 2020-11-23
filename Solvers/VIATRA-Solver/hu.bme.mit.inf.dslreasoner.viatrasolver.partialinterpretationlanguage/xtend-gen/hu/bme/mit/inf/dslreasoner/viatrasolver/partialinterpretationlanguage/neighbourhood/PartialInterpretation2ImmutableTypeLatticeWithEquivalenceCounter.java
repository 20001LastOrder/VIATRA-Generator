package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import com.google.common.collect.ImmutableMap;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.LocalNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodWithTraces;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2NeighbourhoodRepresentation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PartialInterpretation2ImmutableTypeLatticeWithEquivalenceCounter extends PartialInterpretation2NeighbourhoodRepresentation<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> {
  protected PartialInterpretation2ImmutableTypeLatticeWithEquivalenceCounter() {
    super(true, false);
  }
  
  @Override
  protected NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> createLocalRepresentation(final Map<DefinedElement, LocalNodeDescriptor> node2Representation, final Map<LocalNodeDescriptor, Integer> representation2Amount) {
    Map<DefinedElement, LocalNodeDescriptor> _immutableCopy = ImmutableMap.<DefinedElement, LocalNodeDescriptor>copyOf(node2Representation);
    Map<DefinedElement, LocalNodeDescriptor> _immutableCopy_1 = ImmutableMap.<DefinedElement, LocalNodeDescriptor>copyOf(node2Representation);
    return new NeighbourhoodWithTraces(_immutableCopy, _immutableCopy_1, null);
  }
  
  @Override
  protected NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> createFurtherRepresentation(final Map<FurtherNodeDescriptor<AbstractNodeDescriptor>, Integer> nodeDescriptors, final Map<DefinedElement, FurtherNodeDescriptor<AbstractNodeDescriptor>> node2Representation, final NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> previous, final boolean deepRepresentation) {
    if (deepRepresentation) {
      return new NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor>(nodeDescriptors, node2Representation, previous);
    } else {
      return new NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor>(nodeDescriptors, node2Representation, null);
    }
  }
  
  public void finalRepresentation(final NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> representation) {
    final Map<DefinedElement, ? extends AbstractNodeDescriptor> node2Representation = representation.getNodeRepresentations();
    final HashMap<DefinedElement, LocalNodeDescriptor> node2LocalRepresentation = new HashMap<DefinedElement, LocalNodeDescriptor>();
    Set<? extends Map.Entry<DefinedElement, ? extends AbstractNodeDescriptor>> _entrySet = node2Representation.entrySet();
    for (final Map.Entry<DefinedElement, ? extends AbstractNodeDescriptor> entry : _entrySet) {
      {
        final DefinedElement node = entry.getKey();
        final LocalNodeDescriptor localNodeDescriptor = this.toLocalDescriptor(entry.getValue());
        node2LocalRepresentation.put(node, localNodeDescriptor);
      }
    }
  }
  
  public LocalNodeDescriptor toLocalDescriptor(final AbstractNodeDescriptor descriptor) {
    LocalNodeDescriptor _xifexpression = null;
    if ((descriptor instanceof LocalNodeDescriptor)) {
      return ((LocalNodeDescriptor)descriptor);
    } else {
      LocalNodeDescriptor _xifexpression_1 = null;
      if ((descriptor instanceof FurtherNodeDescriptor<?>)) {
        Object _previousRepresentation = ((FurtherNodeDescriptor<?>)descriptor).getPreviousRepresentation();
        _xifexpression_1 = this.toLocalDescriptor(((AbstractNodeDescriptor) _previousRepresentation));
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Unsupported descriptor type: ");
        String _simpleName = descriptor.getClass().getSimpleName();
        _builder.append(_simpleName);
        throw new IllegalArgumentException(_builder.toString());
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
