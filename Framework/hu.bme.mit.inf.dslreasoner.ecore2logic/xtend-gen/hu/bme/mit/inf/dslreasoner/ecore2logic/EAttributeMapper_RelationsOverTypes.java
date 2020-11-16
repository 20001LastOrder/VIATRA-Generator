package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EAttributeMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EAttributeMapper_RelationsOverTypes_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EEnumMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ecore2logicannotations.Ecore2logicannotationsFactory;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ecore2logicannotations.LowerMultiplicityAssertion;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ecore2logicannotations.UpperMultiplicityAssertion;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.VariableContext;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.And;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Distinct;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Exists;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Impl;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Not;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDescriptor;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Variable;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.Annotation;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.AssertionAnnotation;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EAttributeMapper_RelationsOverTypes implements EAttributeMapper {
  @Extension
  protected final LogicProblemBuilder builder = new LogicProblemBuilder();
  
  @Extension
  private final Ecore2logicannotationsFactory builder2 = Ecore2logicannotationsFactory.eINSTANCE;
  
  @Extension
  protected final EClassMapper classMapper;
  
  @Extension
  protected final EEnumMapper enumMapper;
  
  public EAttributeMapper_RelationsOverTypes(final EClassMapper classMapper, final EEnumMapper enumMapper) {
    this.enumMapper = enumMapper;
    this.classMapper = classMapper;
  }
  
  @Override
  public void transformEAttributes(final Ecore2Logic_Trace trace, final LogicProblem logicProblem, final Iterable<EAttribute> attributes) {
    final EAttributeMapper_RelationsOverTypes_Trace attributeMapperTrace = new EAttributeMapper_RelationsOverTypes_Trace();
    trace.attributeMapperTrace = attributeMapperTrace;
    for (final EAttribute attribute : attributes) {
      {
        final Type sourceType = this.classMapper.TypeofEClass(trace, attribute.getEContainingClass());
        final TypeDescriptor rangeType = this.TypeOfRange(trace, attribute);
        StringConcatenation _builder = new StringConcatenation();
        String _name = attribute.getName();
        _builder.append(_name);
        _builder.append(" attribute ");
        String _name_1 = attribute.getEContainingClass().getName();
        _builder.append(_name_1);
        final RelationDeclaration indicator = this.builder.RelationDeclaration(_builder, sourceType, rangeType);
        this.builder.add(logicProblem, indicator);
        attributeMapperTrace.indicators.put(attribute, indicator);
        Assertion lowerMultiplicity = null;
        int _lowerBound = attribute.getLowerBound();
        boolean _notEquals = (_lowerBound != 0);
        if (_notEquals) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("lowerMultiplicity ");
          String _name_2 = attribute.getName();
          _builder_1.append(_name_2);
          _builder_1.append(" ");
          String _name_3 = attribute.getEContainingClass().getName();
          _builder_1.append(_name_3);
          final Function1<VariableContext, TermDescription> _function = (VariableContext it) -> {
            Exists _xblockexpression = null;
            {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("src");
              final Variable source = it.addVar(_builder_2, sourceType);
              final Function1<VariableContext, TermDescription> _function_1 = (VariableContext context) -> {
                int _lowerBound_1 = attribute.getLowerBound();
                final Function1<Integer, Variable> _function_2 = (Integer it_1) -> {
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append("trg ");
                  _builder_3.append(it_1);
                  return context.addVar(_builder_3, rangeType);
                };
                final List<Variable> targets = IterableExtensions.<Variable>toList(IterableExtensions.<Integer, Variable>map(new IntegerRange(1, _lowerBound_1), _function_2));
                final Function1<Variable, Term> _function_3 = (Variable it_1) -> {
                  return this.IsAttributeValue(trace, source, it_1, attribute);
                };
                final And attributeValue = this.builder.And(ListExtensions.<Variable, Term>map(targets, _function_3));
                int _size = targets.size();
                boolean _greaterThan = (_size > 1);
                if (_greaterThan) {
                  Distinct _Distinct = this.builder.Distinct(targets);
                  return this.builder.operator_and(_Distinct, attributeValue);
                } else {
                  return attributeValue;
                }
              };
              _xblockexpression = this.builder.Exists(_function_1);
            }
            return _xblockexpression;
          };
          lowerMultiplicity = this.builder.Assertion(_builder_1, 
            this.builder.Forall(_function));
          LowerMultiplicityAssertion _createLowerMultiplicityAssertion = this.builder2.createLowerMultiplicityAssertion();
          final Procedure1<LowerMultiplicityAssertion> _function_1 = (LowerMultiplicityAssertion it) -> {
            it.setLower(attribute.getLowerBound());
            it.setRelation(indicator);
          };
          final LowerMultiplicityAssertion annotation = ObjectExtensions.<LowerMultiplicityAssertion>operator_doubleArrow(_createLowerMultiplicityAssertion, _function_1);
          this.builder.add(logicProblem, lowerMultiplicity);
          EList<Annotation> _annotations = logicProblem.getAnnotations();
          _annotations.add(annotation);
          EList<AssertionAnnotation> _annotations_1 = lowerMultiplicity.getAnnotations();
          _annotations_1.add(annotation);
        }
        attributeMapperTrace.lowerMultiplicity.put(attribute, lowerMultiplicity);
        Assertion upperMultiplicity = null;
        int _upperBound = attribute.getUpperBound();
        boolean _greaterThan = (_upperBound > 0);
        if (_greaterThan) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("upperMultiplicity ");
          String _name_4 = attribute.getName();
          _builder_2.append(_name_4);
          _builder_2.append(" ");
          String _name_5 = attribute.getEContainingClass().getName();
          _builder_2.append(_name_5);
          final Function1<VariableContext, TermDescription> _function_2 = (VariableContext context) -> {
            Impl _xblockexpression = null;
            {
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("src");
              final Variable source = context.addVar(_builder_3, sourceType);
              int _upperBound_1 = attribute.getUpperBound();
              int _plus = (_upperBound_1 + 1);
              final Function1<Integer, Variable> _function_3 = (Integer it) -> {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("trg ");
                _builder_4.append(it);
                return context.addVar(_builder_4, rangeType);
              };
              final List<Variable> targets = IterableExtensions.<Variable>toList(IterableExtensions.<Integer, Variable>map(new IntegerRange(1, _plus), _function_3));
              final Function1<Variable, Term> _function_4 = (Variable it) -> {
                return this.IsAttributeValue(trace, source, it, attribute);
              };
              And _And = this.builder.And(ListExtensions.<Variable, Term>map(targets, _function_4));
              Distinct _Distinct = this.builder.Distinct(targets);
              Not _not = this.builder.operator_not(_Distinct);
              _xblockexpression = this.builder.operator_doubleArrow(_And, _not);
            }
            return _xblockexpression;
          };
          upperMultiplicity = this.builder.Assertion(_builder_2, 
            this.builder.Forall(_function_2));
          UpperMultiplicityAssertion _createUpperMultiplicityAssertion = this.builder2.createUpperMultiplicityAssertion();
          final Procedure1<UpperMultiplicityAssertion> _function_3 = (UpperMultiplicityAssertion it) -> {
            it.setUpper(attribute.getUpperBound());
            it.setRelation(indicator);
          };
          final UpperMultiplicityAssertion annotation_1 = ObjectExtensions.<UpperMultiplicityAssertion>operator_doubleArrow(_createUpperMultiplicityAssertion, _function_3);
          this.builder.add(logicProblem, upperMultiplicity);
          EList<Annotation> _annotations_2 = logicProblem.getAnnotations();
          _annotations_2.add(annotation_1);
          EList<AssertionAnnotation> _annotations_3 = upperMultiplicity.getAnnotations();
          _annotations_3.add(annotation_1);
        }
        attributeMapperTrace.upperMultiplicity.put(attribute, upperMultiplicity);
      }
    }
  }
  
  public EAttributeMapper_RelationsOverTypes_Trace asTrace(final Trace<? extends EAttributeMapper> trace) {
    return ((EAttributeMapper_RelationsOverTypes_Trace) trace);
  }
  
  @Override
  public Term IsAttributeValue(final Ecore2Logic_Trace trace, final TermDescription object, final TermDescription value, final EAttribute attribute) {
    return this.builder.call(this.asTrace(trace.attributeMapperTrace).indicators.get(attribute), object, value);
  }
  
  @Override
  public TypeDescriptor TypeOfRange(final Ecore2Logic_Trace trace, final EAttribute attribute) {
    EClassifier _eType = attribute.getEType();
    if ((_eType instanceof EEnum)) {
      EClassifier _eType_1 = attribute.getEType();
      return this.enumMapper.TypeofEEnum(trace, ((EEnum) _eType_1));
    } else {
      if ((attribute.getEType().getName().equals("EInt") || attribute.getEType().getName().equals("EShort"))) {
        return this.builder.LogicInt();
      } else {
        boolean _equals = attribute.getEType().getName().equals("EBoolean");
        if (_equals) {
          return this.builder.LogicBool();
        } else {
          if ((attribute.getEType().getName().equals("EDouble") || 
            attribute.getEType().getName().equals("EFloat"))) {
            return this.builder.LogicReal();
          } else {
            boolean _equals_1 = attribute.getEType().getName().equals("EString");
            if (_equals_1) {
              return this.builder.LogicString();
            } else {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Unsupported attribute type: ");
              String _name = attribute.getEType().getName();
              _builder.append(_name);
              _builder.append(" of ");
              EPackage _ePackage = attribute.getEContainingClass().getEPackage();
              _builder.append(_ePackage);
              _builder.append("::");
              String _name_1 = attribute.getEContainingClass().getName();
              _builder.append(_name_1);
              _builder.append(".");
              String _name_2 = attribute.getName();
              _builder.append(_name_2);
              throw new UnsupportedOperationException(_builder.toString());
            }
          }
        }
      }
    }
  }
  
  @Override
  public RelationDeclaration relationOfAttribute(final Ecore2Logic_Trace trace, final EAttribute attribute) {
    return this.asTrace(trace.attributeMapperTrace).indicators.get(attribute);
  }
  
  @Override
  public Iterable<EAttribute> allAttributesInScope(final Ecore2Logic_Trace trace) {
    return this.asTrace(trace.attributeMapperTrace).indicators.keySet();
  }
}
