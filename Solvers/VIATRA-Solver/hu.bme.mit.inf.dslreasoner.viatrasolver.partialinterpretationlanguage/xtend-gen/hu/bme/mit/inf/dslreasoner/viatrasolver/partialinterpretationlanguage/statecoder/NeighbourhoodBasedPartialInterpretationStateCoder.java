package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodWithTraces;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2NeighbourhoodRepresentation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedPartialInterpretationStateCoder;
import java.util.Map;
import java.util.function.Function;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class NeighbourhoodBasedPartialInterpretationStateCoder<ModelRep extends Object, NodeRep extends Object> extends AbstractNeighbourhoodBasedPartialInterpretationStateCoder {
  private final PartialInterpretation2NeighbourhoodRepresentation<ModelRep, NodeRep> calculator;
  
  private final Map<IQuerySpecification<?>, String> fullyQualifiedNames = CollectionLiterals.<IQuerySpecification<?>, String>newHashMap();
  
  private Map<DefinedElement, ? extends NodeRep> nodeRepresentations = null;
  
  private ModelRep modelRepresentation = null;
  
  public NeighbourhoodBasedPartialInterpretationStateCoder(final PartialInterpretation2NeighbourhoodRepresentation<ModelRep, NodeRep> calculator, final NeighbourhoodOptions options) {
    super(options);
    this.calculator = calculator;
  }
  
  @Override
  protected boolean isRefreshNeeded() {
    return ((this.nodeRepresentations == null) || (this.modelRepresentation == null));
  }
  
  @Override
  public void doRefreshStateCodes(final PartialInterpretation target, final NeighbourhoodOptions options) {
    final NeighbourhoodWithTraces<ModelRep, NodeRep> code = this.calculator.createRepresentation(target, options);
    this.modelRepresentation = code.getModelRepresentation();
    this.nodeRepresentations = code.getNodeRepresentations();
  }
  
  private String getFullyQualifiedNameCached(final IQuerySpecification<?> specification) {
    final Function<IQuerySpecification<?>, String> _function = (IQuerySpecification<?> it) -> {
      return it.getFullyQualifiedName();
    };
    return this.fullyQualifiedNames.computeIfAbsent(specification, _function);
  }
  
  @Override
  public Object doCreateActivationCode(final IPatternMatch match) {
    Pair<String, Integer> _xblockexpression = null;
    {
      final int size = match.specification().getParameters().size();
      int hash = 0;
      final int prime = 31;
      for (int index = 0; (index < size); index++) {
        {
          final Object matchArgument = match.get(index);
          final Object code = this.getCode(matchArgument);
          int _xifexpression = (int) 0;
          if ((code == null)) {
            _xifexpression = 0;
          } else {
            _xifexpression = code.hashCode();
          }
          final int codeNumber = _xifexpression;
          hash = ((prime * hash) + codeNumber);
          for (int i = 0; (i < index); i++) {
            {
              int _xifexpression_1 = (int) 0;
              Object _get = match.get(i);
              boolean _tripleEquals = (matchArgument == _get);
              if (_tripleEquals) {
                _xifexpression_1 = 1;
              } else {
                _xifexpression_1 = 0;
              }
              final int number = _xifexpression_1;
              hash = ((prime * hash) + number);
            }
          }
        }
      }
      String _fullyQualifiedNameCached = this.getFullyQualifiedNameCached(match.specification());
      _xblockexpression = Pair.<String, Integer>of(_fullyQualifiedNameCached, Integer.valueOf(hash));
    }
    return _xblockexpression;
  }
  
  private Object getCode(final Object o) {
    Object _switchResult = null;
    boolean _matched = false;
    if (o instanceof DefinedElement) {
      _matched=true;
      _switchResult = this.nodeRepresentations.get(o);
    }
    if (!_matched) {
      _switchResult = this.getFallbackCode(o);
    }
    return _switchResult;
  }
  
  @Override
  public Object doCreateStateCode() {
    return Integer.valueOf(this.modelRepresentation.hashCode());
  }
  
  @Override
  public void doInvalidate() {
    this.nodeRepresentations = null;
    this.modelRepresentation = null;
  }
}
