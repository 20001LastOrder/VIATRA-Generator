package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BinaryElementRelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialPrimitiveInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialTypeInterpratation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.IdentifierBasedStateCode;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.RelationStatecoder;
import java.util.ArrayList;
import java.util.SortedSet;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class IdentifierBasedStateCoder implements IStateCoder {
  private PartialInterpretation model = null;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private long statecoderRuntime = 0;
  
  @Override
  public Object createActivationCode(final IPatternMatch match) {
    final long startTime = System.nanoTime();
    int _size = match.parameterNames().size();
    final ArrayList<Integer> res = new ArrayList<Integer>(_size);
    int index = 0;
    while ((index < match.parameterNames().size())) {
      {
        res.add(Integer.valueOf(this.getID(match.get(index))));
        index++;
      }
    }
    long _statecoderRuntime = this.statecoderRuntime;
    long _nanoTime = System.nanoTime();
    long _minus = (_nanoTime - startTime);
    this.statecoderRuntime = (_statecoderRuntime + _minus);
    String _fullyQualifiedName = match.specification().getFullyQualifiedName();
    return Pair.<String, ArrayList<Integer>>of(_fullyQualifiedName, res);
  }
  
  @Override
  public Object createStateCode() {
    final long startTime = System.nanoTime();
    int _size = this.model.getNewElements().size();
    final IdentifierBasedStateCode res = new IdentifierBasedStateCode(_size);
    EList<PartialRelationInterpretation> _partialrelationinterpretation = this.model.getPartialrelationinterpretation();
    for (final PartialRelationInterpretation relation : _partialrelationinterpretation) {
      {
        String _name = relation.getInterpretationOf().getName();
        final RelationStatecoder relationCoder = new RelationStatecoder(_name);
        Iterable<BinaryElementRelationLink> _filter = Iterables.<BinaryElementRelationLink>filter(relation.getRelationlinks(), BinaryElementRelationLink.class);
        for (final BinaryElementRelationLink link : _filter) {
          SortedSet<Pair<Integer, Integer>> _links = relationCoder.getLinks();
          int _iD = this.getID(link.getParam1());
          int _iD_1 = this.getID(link.getParam2());
          Pair<Integer, Integer> _mappedTo = Pair.<Integer, Integer>of(Integer.valueOf(_iD), Integer.valueOf(_iD_1));
          _links.add(_mappedTo);
        }
        SortedSet<RelationStatecoder> _relationStatecoders = res.getRelationStatecoders();
        _relationStatecoders.add(relationCoder);
      }
    }
    long _statecoderRuntime = this.statecoderRuntime;
    long _nanoTime = System.nanoTime();
    long _minus = (_nanoTime - startTime);
    this.statecoderRuntime = (_statecoderRuntime + _minus);
    return res;
  }
  
  public int getID(final Object element) {
    int _xifexpression = (int) 0;
    if ((element instanceof DefinedElement)) {
      final EObject container = ((DefinedElement)element).eContainer();
      if ((container instanceof LogicProblem)) {
        int _indexOf = ((LogicProblem)container).getElements().indexOf(element);
        int _minus = (-_indexOf);
        return (_minus - 1);
      } else {
        if ((container instanceof PartialInterpretation)) {
          int _indexOf_1 = ((PartialInterpretation)container).getNewElements().indexOf(element);
          return (_indexOf_1 + 1);
        }
      }
    } else {
      int _xifexpression_1 = (int) 0;
      if (((element instanceof PartialInterpretation) || (element instanceof LogicProblem))) {
        return 0;
      } else {
        int _xifexpression_2 = (int) 0;
        if ((element instanceof PartialRelationInterpretation)) {
          return ((PartialRelationInterpretation)element).getInterpretationOf().getName().hashCode();
        } else {
          int _xifexpression_3 = (int) 0;
          if ((element instanceof PartialTypeInterpratation)) {
            int _xifexpression_4 = (int) 0;
            if ((element instanceof PartialPrimitiveInterpretation)) {
              _xifexpression_4 = ((PartialPrimitiveInterpretation)element).getClass().getSimpleName().hashCode();
            } else {
              if ((element instanceof PartialComplexTypeInterpretation)) {
                return ((PartialComplexTypeInterpretation)element).getInterpretationOf().getName().hashCode();
              } else {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Unsupported type: ");
                String _simpleName = ((PartialTypeInterpratation)element).getClass().getSimpleName();
                _builder.append(_simpleName);
                throw new UnsupportedOperationException(_builder.toString());
              }
            }
            _xifexpression_3 = _xifexpression_4;
          } else {
            InputOutput.<Object>println(element);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Unsupported type: ");
            String _simpleName_1 = element.getClass().getSimpleName();
            _builder_1.append(_simpleName_1);
            throw new UnsupportedOperationException(_builder_1.toString());
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  public void init(final Notifier notifier) {
    this.model = ((PartialInterpretation) notifier);
  }
  
  @Pure
  public long getStatecoderRuntime() {
    return this.statecoderRuntime;
  }
}
