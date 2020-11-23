package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PairwiseNeighbourhoodRepresentation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2ImmutableTypeLattice;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2PairwiseNeighbourhoodRepresentation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedPartialInterpretationStateCoder;
import java.util.ArrayList;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class PairwiseNeighbourhoodBasedPartialInterpretationStateCoder extends AbstractNeighbourhoodBasedPartialInterpretationStateCoder {
  private final PartialInterpretation2PairwiseNeighbourhoodRepresentation<AbstractNodeDescriptor> calculator = new PartialInterpretation2PairwiseNeighbourhoodRepresentation<AbstractNodeDescriptor>(
    new PartialInterpretation2ImmutableTypeLattice());
  
  private PairwiseNeighbourhoodRepresentation<? extends AbstractNodeDescriptor> representation;
  
  public PairwiseNeighbourhoodBasedPartialInterpretationStateCoder(final NeighbourhoodOptions options) {
    super(options);
  }
  
  @Override
  protected boolean isRefreshNeeded() {
    return (this.representation == null);
  }
  
  @Override
  protected void doRefreshStateCodes(final PartialInterpretation target, final NeighbourhoodOptions options) {
    this.representation = this.calculator.createRepresentation(target, options);
  }
  
  @Override
  protected Object doCreateActivationCode(final IPatternMatch match) {
    Pair<String, Integer> _xblockexpression = null;
    {
      final int size = match.specification().getParameters().size();
      final ArrayList<Object> res = new ArrayList<Object>((size * size));
      for (int i = 0; (i < size); i++) {
        {
          final Object a = match.get(i);
          for (int j = 0; (j < size); j++) {
            {
              final Object b = match.get(j);
              res.add(this.getPairwiseRepresentation(a, b));
            }
          }
        }
      }
      String _fullyQualifiedName = match.specification().getFullyQualifiedName();
      int _hashCode = res.hashCode();
      _xblockexpression = Pair.<String, Integer>of(_fullyQualifiedName, Integer.valueOf(_hashCode));
    }
    return _xblockexpression;
  }
  
  private Object getPairwiseRepresentation(final Object a, final Object b) {
    Object _xifexpression = null;
    if ((b instanceof DefinedElement)) {
      AbstractNodeDescriptor _xifexpression_1 = null;
      if ((a instanceof DefinedElement)) {
        _xifexpression_1 = this.representation.getPairwiseRepresentation(((DefinedElement)a), ((DefinedElement)b));
      } else {
        _xifexpression_1 = this.representation.getBasicRepresentation(((DefinedElement)b));
      }
      _xifexpression = _xifexpression_1;
    } else {
      _xifexpression = this.getFallbackCode(b);
    }
    return _xifexpression;
  }
  
  @Override
  protected Object doCreateStateCode() {
    return Integer.valueOf(this.representation.getModelRepresentation().hashCode());
  }
  
  @Override
  protected void doInvalidate() {
    this.representation = null;
  }
}
