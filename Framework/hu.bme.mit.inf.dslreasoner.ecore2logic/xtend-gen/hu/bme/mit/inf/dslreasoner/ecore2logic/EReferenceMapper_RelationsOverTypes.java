package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EReferenceMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EReferenceMapper_RelationsOverTypes_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ecore2logicannotations.Ecore2logicannotationsFactory;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ecore2logicannotations.InverseRelationAssertion;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ecore2logicannotations.LowerMultiplicityAssertion;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ecore2logicannotations.UpperMultiplicityAssertion;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.VariableContext;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.And;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Distinct;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Exists;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Iff;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Impl;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Not;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Relation;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Variable;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.Annotation;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.AssertionAnnotation;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EReferenceMapper_RelationsOverTypes implements EReferenceMapper {
  @Extension
  private final LogicProblemBuilder builder = new LogicProblemBuilder();
  
  @Extension
  private final Ecore2logicannotationsFactory builder2 = Ecore2logicannotationsFactory.eINSTANCE;
  
  @Extension
  private final EClassMapper classMapper;
  
  public EReferenceMapper_RelationsOverTypes(final EClassMapper classMapper) {
    this.classMapper = classMapper;
  }
  
  public EReferenceMapper_RelationsOverTypes_Trace asTrace(final Trace<? extends EReferenceMapper> o) {
    return ((EReferenceMapper_RelationsOverTypes_Trace) o);
  }
  
  @Override
  public void transformEReferences(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> references) {
    final EReferenceMapper_RelationsOverTypes_Trace newTrace = new EReferenceMapper_RelationsOverTypes_Trace();
    trace.referenceMapperTrace = newTrace;
    this.createIndicatorDeclarations(trace, problem, references);
    this.createMultiplicityConstraints(trace, problem, references);
    this.createInverseReferenceConstraints(trace, problem, references);
  }
  
  protected void createIndicatorDeclarations(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> references) {
    EReferenceMapper_RelationsOverTypes_Trace _asTrace = this.asTrace(trace.referenceMapperTrace);
    HashMap<EReference, RelationDeclaration> _hashMap = new HashMap<EReference, RelationDeclaration>();
    _asTrace.indicators = _hashMap;
    for (final EReference reference : references) {
      {
        StringConcatenation _builder = new StringConcatenation();
        String _name = reference.getName();
        _builder.append(_name);
        _builder.append(" reference ");
        String _name_1 = reference.getEContainingClass().getName();
        _builder.append(_name_1);
        EClassifier _eType = reference.getEType();
        final Relation relation = this.builder.add(problem, 
          this.builder.RelationDeclaration(_builder, 
            this.classMapper.TypeofEClass(trace, reference.getEContainingClass()), 
            this.classMapper.TypeofEClass(trace, ((EClass) _eType))));
        this.asTrace(trace.referenceMapperTrace).indicators.put(reference, ((RelationDeclaration) relation));
      }
    }
  }
  
  public void createMultiplicityConstraints(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> references) {
    EReferenceMapper_RelationsOverTypes_Trace _asTrace = this.asTrace(trace.referenceMapperTrace);
    HashMap<EReference, Assertion> _hashMap = new HashMap<EReference, Assertion>();
    _asTrace.lowerMultiplicity = _hashMap;
    EReferenceMapper_RelationsOverTypes_Trace _asTrace_1 = this.asTrace(trace.referenceMapperTrace);
    HashMap<EReference, Assertion> _hashMap_1 = new HashMap<EReference, Assertion>();
    _asTrace_1.upperMultiplicity = _hashMap_1;
    for (final EReference reference : references) {
      {
        final EClass sourceType = reference.getEContainingClass();
        EClassifier _eType = reference.getEType();
        final EClass targetType = ((EClass) _eType);
        final int lower = reference.getLowerBound();
        final int upper = reference.getUpperBound();
        if ((lower > 0)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("lowerMultiplicity ");
          String _name = reference.getName();
          _builder.append(_name);
          _builder.append(" ");
          String _name_1 = sourceType.getName();
          _builder.append(_name_1);
          final Function1<VariableContext, TermDescription> _function = (VariableContext it) -> {
            Exists _xblockexpression = null;
            {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("src");
              final Variable source = it.addVar(_builder_1, this.classMapper.TypeofEClass(trace, sourceType));
              final Function1<VariableContext, TermDescription> _function_1 = (VariableContext context) -> {
                final Function1<Integer, Variable> _function_2 = (Integer it_1) -> {
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("trg ");
                  _builder_2.append(it_1);
                  return context.addVar(_builder_2, this.classMapper.TypeofEClass(trace, targetType));
                };
                final List<Variable> targets = IterableExtensions.<Variable>toList(IterableExtensions.<Integer, Variable>map(new IntegerRange(1, lower), _function_2));
                final Function1<Variable, Term> _function_3 = (Variable it_1) -> {
                  return this.IsInReference(trace, source, it_1, reference);
                };
                final And inReference = this.builder.And(ListExtensions.<Variable, Term>map(targets, _function_3));
                int _size = targets.size();
                boolean _greaterThan = (_size > 1);
                if (_greaterThan) {
                  Distinct _Distinct = this.builder.Distinct(targets);
                  return this.builder.operator_and(_Distinct, inReference);
                } else {
                  return inReference;
                }
              };
              _xblockexpression = this.builder.Exists(_function_1);
            }
            return _xblockexpression;
          };
          final Assertion assertion = this.builder.Assertion(_builder, 
            this.builder.Forall(_function));
          LowerMultiplicityAssertion _createLowerMultiplicityAssertion = this.builder2.createLowerMultiplicityAssertion();
          final Procedure1<LowerMultiplicityAssertion> _function_1 = (LowerMultiplicityAssertion it) -> {
            it.setLower(lower);
            it.setRelation(this.asTrace(trace.referenceMapperTrace).indicators.get(reference));
          };
          final LowerMultiplicityAssertion annotation = ObjectExtensions.<LowerMultiplicityAssertion>operator_doubleArrow(_createLowerMultiplicityAssertion, _function_1);
          this.builder.add(problem, assertion);
          EList<Annotation> _annotations = problem.getAnnotations();
          _annotations.add(annotation);
          EList<AssertionAnnotation> _annotations_1 = assertion.getAnnotations();
          _annotations_1.add(annotation);
          this.asTrace(trace.referenceMapperTrace).lowerMultiplicity.put(reference, assertion);
        } else {
          this.asTrace(trace.referenceMapperTrace).lowerMultiplicity.put(reference, null);
        }
        if ((upper != (-1))) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("upperMultiplicity ");
          String _name_2 = reference.getName();
          _builder_1.append(_name_2);
          _builder_1.append(" ");
          String _name_3 = sourceType.getName();
          _builder_1.append(_name_3);
          final Function1<VariableContext, TermDescription> _function_2 = (VariableContext context) -> {
            Impl _xblockexpression = null;
            {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("src");
              final Variable source = context.addVar(_builder_2, this.classMapper.TypeofEClass(trace, sourceType));
              final Function1<Integer, Variable> _function_3 = (Integer it) -> {
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("trg ");
                _builder_3.append(it);
                return context.addVar(_builder_3, this.classMapper.TypeofEClass(trace, targetType));
              };
              final List<Variable> targets = IterableExtensions.<Variable>toList(IterableExtensions.<Integer, Variable>map(new IntegerRange(1, (upper + 1)), _function_3));
              final Function1<Variable, Term> _function_4 = (Variable it) -> {
                return this.IsInReference(trace, source, it, reference);
              };
              And _And = this.builder.And(ListExtensions.<Variable, Term>map(targets, _function_4));
              Distinct _Distinct = this.builder.Distinct(targets);
              Not _not = this.builder.operator_not(_Distinct);
              _xblockexpression = this.builder.operator_doubleArrow(_And, _not);
            }
            return _xblockexpression;
          };
          final Assertion assertion_1 = this.builder.Assertion(_builder_1, 
            this.builder.Forall(_function_2));
          UpperMultiplicityAssertion _createUpperMultiplicityAssertion = this.builder2.createUpperMultiplicityAssertion();
          final Procedure1<UpperMultiplicityAssertion> _function_3 = (UpperMultiplicityAssertion it) -> {
            it.setUpper(upper);
            it.setRelation(this.asTrace(trace.referenceMapperTrace).indicators.get(reference));
          };
          final UpperMultiplicityAssertion annotation_1 = ObjectExtensions.<UpperMultiplicityAssertion>operator_doubleArrow(_createUpperMultiplicityAssertion, _function_3);
          this.builder.add(problem, assertion_1);
          EList<Annotation> _annotations_2 = problem.getAnnotations();
          _annotations_2.add(annotation_1);
          EList<AssertionAnnotation> _annotations_3 = assertion_1.getAnnotations();
          _annotations_3.add(annotation_1);
          this.asTrace(trace.referenceMapperTrace).lowerMultiplicity.put(reference, assertion_1);
        } else {
          this.asTrace(trace.referenceMapperTrace).upperMultiplicity.put(reference, null);
        }
      }
    }
  }
  
  public void createInverseReferenceConstraints(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> references) {
    EReferenceMapper_RelationsOverTypes_Trace _asTrace = this.asTrace(trace.referenceMapperTrace);
    HashMap<EReference, Assertion> _hashMap = new HashMap<EReference, Assertion>();
    _asTrace.inverseEdges = _hashMap;
    for (final EReference reference : references) {
      if (((reference.getEOpposite() != null) && IterableExtensions.<EReference>exists(references, ((Function1<EReference, Boolean>) (EReference it) -> {
        EReference _eOpposite = reference.getEOpposite();
        return Boolean.valueOf((it == _eOpposite));
      })))) {
        final EReference opposite = reference.getEOpposite();
        boolean _containsKey = this.asTrace(trace.referenceMapperTrace).inverseEdges.containsKey(opposite);
        if (_containsKey) {
          this.asTrace(trace.referenceMapperTrace).inverseEdges.put(reference, this.asTrace(trace.referenceMapperTrace).inverseEdges.get(opposite));
        } else {
          final EClass sourceType = reference.getEContainingClass();
          EClassifier _eType = reference.getEType();
          final EClass targetType = ((EClass) _eType);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("oppositeReference ");
          String _name = reference.getName();
          _builder.append(_name);
          _builder.append(" ");
          String _name_1 = sourceType.getName();
          _builder.append(_name_1);
          final Function1<VariableContext, TermDescription> _function = (VariableContext it) -> {
            Iff _xblockexpression = null;
            {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("src");
              final Variable src = it.addVar(_builder_1, this.classMapper.TypeofEClass(trace, sourceType));
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("trg");
              final Variable trg = it.addVar(_builder_2, this.classMapper.TypeofEClass(trace, targetType));
              Term _IsInReference = this.IsInReference(trace, src, trg, reference);
              Term _IsInReference_1 = this.IsInReference(trace, trg, src, opposite);
              _xblockexpression = this.builder.operator_spaceship(_IsInReference, _IsInReference_1);
            }
            return _xblockexpression;
          };
          final Assertion assertion = this.builder.Assertion(_builder, 
            this.builder.Forall(_function));
          this.builder.add(problem, assertion);
          this.asTrace(trace.referenceMapperTrace).inverseEdges.put(reference, assertion);
          InverseRelationAssertion _createInverseRelationAssertion = this.builder2.createInverseRelationAssertion();
          final Procedure1<InverseRelationAssertion> _function_1 = (InverseRelationAssertion it) -> {
            it.setTarget(assertion);
            it.setInverseA(this.asTrace(trace.referenceMapperTrace).indicators.get(reference));
            it.setInverseB(this.asTrace(trace.referenceMapperTrace).indicators.get(reference.getEOpposite()));
          };
          final InverseRelationAssertion annotation = ObjectExtensions.<InverseRelationAssertion>operator_doubleArrow(_createInverseRelationAssertion, _function_1);
          EList<Annotation> _annotations = problem.getAnnotations();
          _annotations.add(annotation);
        }
      } else {
        this.asTrace(trace.referenceMapperTrace).inverseEdges.put(reference, null);
      }
    }
  }
  
  @Override
  public Term IsInReference(final Ecore2Logic_Trace trace, final TermDescription source, final TermDescription target, final EReference type) {
    return this.builder.call(this.asTrace(trace.referenceMapperTrace).indicators.get(type), source, target);
  }
  
  @Override
  public RelationDeclaration relationOfReference(final Ecore2Logic_Trace trace, final EReference reference) {
    return this.asTrace(trace.referenceMapperTrace).indicators.get(reference);
  }
  
  @Override
  public Iterable<EReference> allReferencesInScope(final Ecore2Logic_Trace trace) {
    return this.asTrace(trace.referenceMapperTrace).indicators.keySet();
  }
}
