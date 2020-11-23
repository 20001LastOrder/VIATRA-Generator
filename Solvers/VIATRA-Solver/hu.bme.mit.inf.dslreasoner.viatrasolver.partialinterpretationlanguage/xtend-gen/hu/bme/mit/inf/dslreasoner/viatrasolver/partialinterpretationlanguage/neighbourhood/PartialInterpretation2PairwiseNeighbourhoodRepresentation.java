package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import com.google.common.collect.Maps;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodWithTraces;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PairwiseNeighbourhoodRepresentation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2NeighbourhoodRepresentation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class PartialInterpretation2PairwiseNeighbourhoodRepresentation<BasicNodeRepresentation extends Object> {
  private final PartialInterpretation2NeighbourhoodRepresentation<? extends Map<? extends BasicNodeRepresentation, Integer>, BasicNodeRepresentation> basicNeighbourhoodRepresenter;
  
  public PairwiseNeighbourhoodRepresentation<? extends BasicNodeRepresentation> createRepresentation(final PartialInterpretation model, final NeighbourhoodOptions options) {
    PairwiseNeighbourhoodRepresentation<? extends BasicNodeRepresentation> _xblockexpression = null;
    {
      final NeighbourhoodWithTraces<? extends Map<? extends BasicNodeRepresentation, Integer>, BasicNodeRepresentation> basicRepresentation = this.basicNeighbourhoodRepresenter.createRepresentation(model, options);
      final Map<? extends BasicNodeRepresentation, Integer> basicModelRepresentation = basicRepresentation.getModelRepresentation();
      final Map<DefinedElement, ? extends BasicNodeRepresentation> basicNodeRepresentations = basicRepresentation.getNodeRepresentations();
      final HashMap<DefinedElement, Map<DefinedElement, ? extends BasicNodeRepresentation>> pairwiseNodeRepresentations = Maps.<DefinedElement, Map<DefinedElement, ? extends BasicNodeRepresentation>>newHashMapWithExpectedSize(basicNodeRepresentations.size());
      final HashMap<Object, Integer> modelRepresentation = new HashMap<Object, Integer>();
      Set<? extends Map.Entry<DefinedElement, ? extends BasicNodeRepresentation>> _entrySet = basicNodeRepresentations.entrySet();
      for (final Map.Entry<DefinedElement, ? extends BasicNodeRepresentation> nodeWithBasicRepresentation : _entrySet) {
        {
          final DefinedElement node = nodeWithBasicRepresentation.getKey();
          final BasicNodeRepresentation basicNodeRepresentation = nodeWithBasicRepresentation.getValue();
          final Integer count = basicModelRepresentation.get(basicNodeRepresentation);
          if (((count).intValue() == 1)) {
            pairwiseNodeRepresentations.put(node, basicNodeRepresentations);
            modelRepresentation.put(basicNodeRepresentation, count);
          } else {
            final NeighbourhoodWithTraces<? extends Map<? extends BasicNodeRepresentation, Integer>, BasicNodeRepresentation> neighbourhoodRepresentation = this.basicNeighbourhoodRepresenter.createRepresentationWithFocus(model, options, node);
            pairwiseNodeRepresentations.put(node, neighbourhoodRepresentation.getNodeRepresentations());
            final BiFunction<Object, Integer, Integer> _function = (Object key, Integer value) -> {
              int _xifexpression = (int) 0;
              if ((value == null)) {
                int _xifexpression_1 = (int) 0;
                int _maxNumber = options.getMaxNumber();
                boolean _greaterThan = (1 > _maxNumber);
                if (_greaterThan) {
                  _xifexpression_1 = Integer.MAX_VALUE;
                } else {
                  _xifexpression_1 = 1;
                }
                _xifexpression = _xifexpression_1;
              } else {
                _xifexpression = this.addOne((value).intValue(), options.getMaxNumber());
              }
              return Integer.valueOf(_xifexpression);
            };
            modelRepresentation.compute(neighbourhoodRepresentation.getModelRepresentation(), _function);
          }
        }
      }
      _xblockexpression = new PairwiseNeighbourhoodRepresentation(modelRepresentation, basicNodeRepresentations, pairwiseNodeRepresentations);
    }
    return _xblockexpression;
  }
  
  private int addOne(final int original, final int max) {
    if ((original == Integer.MAX_VALUE)) {
      return Integer.MAX_VALUE;
    }
    if (((original + 1) > max)) {
      return Integer.MAX_VALUE;
    } else {
      return (original + 1);
    }
  }
  
  public PartialInterpretation2PairwiseNeighbourhoodRepresentation(final PartialInterpretation2NeighbourhoodRepresentation<? extends Map<? extends BasicNodeRepresentation, Integer>, BasicNodeRepresentation> basicNeighbourhoodRepresenter) {
    super();
    this.basicNeighbourhoodRepresenter = basicNeighbourhoodRepresenter;
  }
}
