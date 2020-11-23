package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.LocalNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodWithTraces;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2NeighbourhoodRepresentation;
import java.util.Map;
import java.util.Set;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.map.MutableMap;

@SuppressWarnings("all")
public class PartialInterpretation2Hash extends PartialInterpretation2NeighbourhoodRepresentation<Integer, Integer> {
  public PartialInterpretation2Hash() {
    super(false, true);
  }
  
  @Override
  protected NeighbourhoodWithTraces<Integer, Integer> createLocalRepresentation(final Map<DefinedElement, LocalNodeDescriptor> node2Representation, final Map<LocalNodeDescriptor, Integer> representation2Amount) {
    int _hashCode = representation2Amount.hashCode();
    MutableMap<DefinedElement, Integer> _hashValues = this.<LocalNodeDescriptor>hashValues(node2Representation);
    return new NeighbourhoodWithTraces<Integer, Integer>(Integer.valueOf(_hashCode), _hashValues, 
      null);
  }
  
  @Override
  protected NeighbourhoodWithTraces<Integer, Integer> createFurtherRepresentation(final Map<FurtherNodeDescriptor<Integer>, Integer> nodeDescriptors, final Map<DefinedElement, FurtherNodeDescriptor<Integer>> node2Representation, final NeighbourhoodWithTraces<Integer, Integer> previous, final boolean deepRepresentation) {
    int _hashCode = nodeDescriptors.hashCode();
    MutableMap<DefinedElement, Integer> _hashValues = this.<FurtherNodeDescriptor<Integer>>hashValues(node2Representation);
    NeighbourhoodWithTraces<Integer, Integer> _xifexpression = null;
    if (deepRepresentation) {
      _xifexpression = previous;
    } else {
      _xifexpression = null;
    }
    return new NeighbourhoodWithTraces<Integer, Integer>(Integer.valueOf(_hashCode), _hashValues, _xifexpression);
  }
  
  private <T extends Object> MutableMap<DefinedElement, Integer> hashValues(final Map<DefinedElement, T> map) {
    MutableMap<DefinedElement, Integer> _xblockexpression = null;
    {
      final MutableMap<DefinedElement, Integer> hashedMap = Maps.mutable.<DefinedElement, Integer>ofInitialCapacity(map.size());
      Set<Map.Entry<DefinedElement, T>> _entrySet = map.entrySet();
      for (final Map.Entry<DefinedElement, T> entry : _entrySet) {
        hashedMap.put(entry.getKey(), Integer.valueOf(entry.getValue().hashCode()));
      }
      _xblockexpression = hashedMap;
    }
    return _xblockexpression;
  }
}
