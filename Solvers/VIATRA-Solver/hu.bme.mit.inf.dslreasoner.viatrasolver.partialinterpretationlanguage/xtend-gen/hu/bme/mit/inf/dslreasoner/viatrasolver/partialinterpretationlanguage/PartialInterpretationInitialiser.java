package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage;

import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.TracedOutput;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.TypeScopes;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.And;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.BoolLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.IntLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguageFactory;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RealLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.StringLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicValue;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.SupertypeStar;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.PrimitiveValueTrace;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.Problem2PartialInterpretationTrace;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partial2logicannotations.PartialModelRelation2Assertion;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BinaryElementRelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BooleanElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.IntegerElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.NaryRelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.NaryRelationLinkElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialBooleanInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialIntegerInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRealInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialStringInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialTypeInterpratation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialinterpretationFactory;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RealElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.Scope;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.StringElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.UnaryElementRelationLink;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Initializer class for an empty partial interpretation.
 */
@SuppressWarnings("all")
public class PartialInterpretationInitialiser {
  @Extension
  private final PartialinterpretationFactory factory = PartialinterpretationFactory.eINSTANCE;
  
  @Extension
  private final LogiclanguageFactory factory2 = LogiclanguageFactory.eINSTANCE;
  
  /**
   * Initialises an empty partial interpretation from a logic problem and a scope.
   */
  public TracedOutput<PartialInterpretation, Problem2PartialInterpretationTrace> initialisePartialInterpretation(final LogicProblem problem, final TypeScopes typeScopes) {
    final PartialInterpretation res = this.factory.createPartialInterpretation();
    res.setProblem(problem);
    final PartialBooleanInterpretation booleanType = this.initBooleans(res);
    final PartialIntegerInterpretation integerType = this.initIntegers(res, typeScopes.knownIntegers, typeScopes.minNewIntegers, typeScopes.maxNewIntegers);
    final PartialRealInterpretation realType = this.initReals(res, typeScopes.knownReals, typeScopes.minNewReals, typeScopes.maxNewReals);
    final PartialStringInterpretation stringType = this.initStrings(res, typeScopes.knownStrings, typeScopes.minNewStrings, typeScopes.maxNewStrings);
    final PrimitiveValueTrace primitiveTrace = this.createPrimitiveTrace(booleanType, integerType, realType, stringType);
    final Map<TypeDeclaration, PartialComplexTypeInterpretation> type2Interpretation = this.initElements(res, 
      typeScopes.minNewElementsByType, 
      typeScopes.maxNewElementsByType, 
      typeScopes.minNewElements, 
      typeScopes.maxNewElements);
    final Map<RelationDeclaration, PartialRelationInterpretation> relation2Interpretation = this.initRelations(res, primitiveTrace);
    final Problem2PartialInterpretationTrace trace = new Problem2PartialInterpretationTrace(type2Interpretation, primitiveTrace, relation2Interpretation);
    return new TracedOutput<PartialInterpretation, Problem2PartialInterpretationTrace>(res, trace);
  }
  
  public PrimitiveValueTrace createPrimitiveTrace(final PartialBooleanInterpretation booleanType, final PartialIntegerInterpretation integerType, final PartialRealInterpretation realType, final PartialStringInterpretation stringType) {
    final Function1<BooleanElement, Boolean> _function = (BooleanElement it) -> {
      return Boolean.valueOf(it.isValueSet());
    };
    final Function1<BooleanElement, Boolean> _function_1 = (BooleanElement it) -> {
      return Boolean.valueOf(it.isValue());
    };
    Map<Boolean, BooleanElement> _map = IterableExtensions.<Boolean, BooleanElement>toMap(IterableExtensions.<BooleanElement>filter(Iterables.<BooleanElement>filter(booleanType.getElements(), BooleanElement.class), _function), _function_1);
    final Function1<IntegerElement, Boolean> _function_2 = (IntegerElement it) -> {
      return Boolean.valueOf(it.isValueSet());
    };
    final Function1<IntegerElement, Integer> _function_3 = (IntegerElement it) -> {
      return Integer.valueOf(it.getValue());
    };
    Map<Integer, IntegerElement> _map_1 = IterableExtensions.<Integer, IntegerElement>toMap(IterableExtensions.<IntegerElement>filter(Iterables.<IntegerElement>filter(integerType.getElements(), IntegerElement.class), _function_2), _function_3);
    final Function1<RealElement, Boolean> _function_4 = (RealElement it) -> {
      return Boolean.valueOf(it.isValueSet());
    };
    final Function1<RealElement, BigDecimal> _function_5 = (RealElement it) -> {
      return it.getValue();
    };
    Map<BigDecimal, RealElement> _map_2 = IterableExtensions.<BigDecimal, RealElement>toMap(IterableExtensions.<RealElement>filter(Iterables.<RealElement>filter(realType.getElements(), RealElement.class), _function_4), _function_5);
    final Function1<StringElement, Boolean> _function_6 = (StringElement it) -> {
      return Boolean.valueOf(it.isValueSet());
    };
    final Function1<StringElement, String> _function_7 = (StringElement it) -> {
      return it.getValue();
    };
    Map<String, StringElement> _map_3 = IterableExtensions.<String, StringElement>toMap(IterableExtensions.<StringElement>filter(Iterables.<StringElement>filter(stringType.getElements(), StringElement.class), _function_6), _function_7);
    return new PrimitiveValueTrace(booleanType, _map, integerType, _map_1, realType, _map_2, stringType, _map_3);
  }
  
  protected PartialBooleanInterpretation initBooleans(final PartialInterpretation partialInterpretation) {
    final PartialBooleanInterpretation booleanInterpretation = this.factory.createPartialBooleanInterpretation();
    EList<PartialTypeInterpratation> _partialtypeinterpratation = partialInterpretation.getPartialtypeinterpratation();
    _partialtypeinterpratation.add(booleanInterpretation);
    BooleanElement _createBooleanElement = this.factory.createBooleanElement();
    final Procedure1<BooleanElement> _function = (BooleanElement it) -> {
      it.setName("true");
      it.setValue(true);
      it.setValueSet(true);
    };
    final BooleanElement trueElement = ObjectExtensions.<BooleanElement>operator_doubleArrow(_createBooleanElement, _function);
    EList<DefinedElement> _elements = booleanInterpretation.getElements();
    _elements.add(trueElement);
    EList<DefinedElement> _newElements = partialInterpretation.getNewElements();
    _newElements.add(trueElement);
    BooleanElement _createBooleanElement_1 = this.factory.createBooleanElement();
    final Procedure1<BooleanElement> _function_1 = (BooleanElement it) -> {
      it.setName("false");
      it.setValue(false);
      it.setValueSet(true);
    };
    final BooleanElement falseElement = ObjectExtensions.<BooleanElement>operator_doubleArrow(_createBooleanElement_1, _function_1);
    EList<DefinedElement> _elements_1 = booleanInterpretation.getElements();
    _elements_1.add(falseElement);
    EList<DefinedElement> _newElements_1 = partialInterpretation.getNewElements();
    _newElements_1.add(falseElement);
    return booleanInterpretation;
  }
  
  protected PartialIntegerInterpretation initIntegers(final PartialInterpretation partialInterpretation, final SortedSet<Integer> knownIntegers, final int minNewIntegers, final int maxNewIntegers) {
    final PartialIntegerInterpretation integerInterpretation = this.factory.createPartialIntegerInterpretation();
    EList<PartialTypeInterpratation> _partialtypeinterpratation = partialInterpretation.getPartialtypeinterpratation();
    _partialtypeinterpratation.add(integerInterpretation);
    for (final Integer knownInteger : knownIntegers) {
      {
        IntegerElement _createIntegerElement = this.factory.createIntegerElement();
        final Procedure1<IntegerElement> _function = (IntegerElement it) -> {
          it.setName(knownInteger.toString());
          it.setValue((knownInteger).intValue());
          it.setValueSet(true);
        };
        final IntegerElement integerElement = ObjectExtensions.<IntegerElement>operator_doubleArrow(_createIntegerElement, _function);
        EList<DefinedElement> _elements = integerInterpretation.getElements();
        _elements.add(integerElement);
        EList<DefinedElement> _newElements = partialInterpretation.getNewElements();
        _newElements.add(integerElement);
      }
    }
    if ((maxNewIntegers > 0)) {
      IntegerElement _createIntegerElement = this.factory.createIntegerElement();
      final Procedure1<IntegerElement> _function = (IntegerElement it) -> {
        it.setName("New Integers");
        it.setValueSet(false);
      };
      final IntegerElement newElements = ObjectExtensions.<IntegerElement>operator_doubleArrow(_createIntegerElement, _function);
      EList<DefinedElement> _openWorldElements = partialInterpretation.getOpenWorldElements();
      _openWorldElements.add(newElements);
      EList<DefinedElement> _elements = integerInterpretation.getElements();
      _elements.add(newElements);
    }
    return integerInterpretation;
  }
  
  protected PartialRealInterpretation initReals(final PartialInterpretation partialInterpretation, final SortedSet<BigDecimal> knownReals, final int minNewReals, final int maxNewReals) {
    final PartialRealInterpretation realInterpretation = this.factory.createPartialRealInterpretation();
    EList<PartialTypeInterpratation> _partialtypeinterpratation = partialInterpretation.getPartialtypeinterpratation();
    _partialtypeinterpratation.add(realInterpretation);
    for (final BigDecimal knownReal : knownReals) {
      {
        RealElement _createRealElement = this.factory.createRealElement();
        final Procedure1<RealElement> _function = (RealElement it) -> {
          it.setName(knownReal.toString());
          it.setValue(knownReal);
          it.setValueSet(true);
        };
        final RealElement realElement = ObjectExtensions.<RealElement>operator_doubleArrow(_createRealElement, _function);
        EList<DefinedElement> _elements = realInterpretation.getElements();
        _elements.add(realElement);
        EList<DefinedElement> _newElements = partialInterpretation.getNewElements();
        _newElements.add(realElement);
      }
    }
    if ((maxNewReals > 0)) {
      RealElement _createRealElement = this.factory.createRealElement();
      final Procedure1<RealElement> _function = (RealElement it) -> {
        it.setName("New Reals");
        it.setValueSet(false);
      };
      final RealElement newElements = ObjectExtensions.<RealElement>operator_doubleArrow(_createRealElement, _function);
      EList<DefinedElement> _openWorldElements = partialInterpretation.getOpenWorldElements();
      _openWorldElements.add(newElements);
      EList<DefinedElement> _elements = realInterpretation.getElements();
      _elements.add(newElements);
    }
    return realInterpretation;
  }
  
  protected PartialStringInterpretation initStrings(final PartialInterpretation partialInterpretation, final SortedSet<String> knownStrings, final int minNewStrings, final int maxNewStrings) {
    final PartialStringInterpretation stringInterpretation = this.factory.createPartialStringInterpretation();
    EList<PartialTypeInterpratation> _partialtypeinterpratation = partialInterpretation.getPartialtypeinterpratation();
    _partialtypeinterpratation.add(stringInterpretation);
    for (final String knownString : knownStrings) {
      {
        StringElement _createStringElement = this.factory.createStringElement();
        final Procedure1<StringElement> _function = (StringElement it) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\"");
          _builder.append(knownString);
          _builder.append("\"");
          it.setName(_builder.toString());
          it.setValue(knownString);
          it.setValueSet(true);
        };
        final StringElement stringElement = ObjectExtensions.<StringElement>operator_doubleArrow(_createStringElement, _function);
        EList<DefinedElement> _elements = stringInterpretation.getElements();
        _elements.add(stringElement);
        EList<DefinedElement> _newElements = partialInterpretation.getNewElements();
        _newElements.add(stringElement);
      }
    }
    if ((maxNewStrings > 0)) {
      StringElement _createStringElement = this.factory.createStringElement();
      final Procedure1<StringElement> _function = (StringElement it) -> {
        it.setName("New Strings");
        it.setValueSet(false);
      };
      final StringElement newElements = ObjectExtensions.<StringElement>operator_doubleArrow(_createStringElement, _function);
      EList<DefinedElement> _openWorldElements = partialInterpretation.getOpenWorldElements();
      _openWorldElements.add(newElements);
      EList<DefinedElement> _elements = stringInterpretation.getElements();
      _elements.add(newElements);
    }
    return stringInterpretation;
  }
  
  protected Map<TypeDeclaration, PartialComplexTypeInterpretation> initElements(final PartialInterpretation interpretation, final Map<Type, Integer> minNewElementsByType, final Map<Type, Integer> maxNewElementsByType, final int minNewElements, final int maxNewElements) {
    final Map<TypeDeclaration, PartialComplexTypeInterpretation> type2Interpretation = new HashMap<TypeDeclaration, PartialComplexTypeInterpretation>();
    LogicProblem _problem = interpretation.getProblem();
    EMFScope _eMFScope = new EMFScope(_problem);
    final ViatraQueryEngine engine = ViatraQueryEngine.on(_eMFScope);
    interpretation.setMinNewElements(minNewElements);
    interpretation.setMaxNewElements(maxNewElements);
    if ((maxNewElements != 0)) {
      DefinedElement _createDefinedElement = this.factory2.createDefinedElement();
      final Procedure1<DefinedElement> _function = (DefinedElement it) -> {
        it.setName("New Objects");
      };
      final DefinedElement newElements = ObjectExtensions.<DefinedElement>operator_doubleArrow(_createDefinedElement, _function);
      EList<DefinedElement> _openWorldElements = interpretation.getOpenWorldElements();
      _openWorldElements.add(newElements);
    }
    Iterable<TypeDeclaration> _filter = Iterables.<TypeDeclaration>filter(interpretation.getProblem().getTypes(), TypeDeclaration.class);
    for (final TypeDeclaration typeDeclaration : _filter) {
      {
        final PartialComplexTypeInterpretation typeInterpretation = this.initialisePartialTypeInterpretation(typeDeclaration, engine);
        EList<PartialTypeInterpratation> _partialtypeinterpratation = interpretation.getPartialtypeinterpratation();
        _partialtypeinterpratation.add(typeInterpretation);
        type2Interpretation.put(typeDeclaration, typeInterpretation);
        EList<Scope> _scopes = interpretation.getScopes();
        Scope _initialiseTypeScope = this.initialiseTypeScope(typeInterpretation, minNewElementsByType.get(typeDeclaration), maxNewElementsByType.get(typeDeclaration));
        _scopes.add(_initialiseTypeScope);
      }
    }
    this.connectSuperypes(interpretation.getProblem(), type2Interpretation);
    return type2Interpretation;
  }
  
  private Scope initialiseTypeScope(final PartialTypeInterpratation interpretation, final Integer min, final Integer max) {
    final Scope res = this.factory.createScope();
    res.setTargetTypeInterpretation(interpretation);
    Integer _elvis = null;
    if (min != null) {
      _elvis = min;
    } else {
      _elvis = Integer.valueOf(0);
    }
    res.setMinNewElements((_elvis).intValue());
    Integer _elvis_1 = null;
    if (max != null) {
      _elvis_1 = max;
    } else {
      _elvis_1 = Integer.valueOf((-1));
    }
    res.setMaxNewElements((_elvis_1).intValue());
    return res;
  }
  
  private void connectSuperypes(final LogicProblem problem, final Map<TypeDeclaration, PartialComplexTypeInterpretation> trace) {
    Iterable<TypeDeclaration> _filter = Iterables.<TypeDeclaration>filter(problem.getTypes(), TypeDeclaration.class);
    for (final TypeDeclaration typeDeclaration : _filter) {
      {
        final Function1<Type, Iterable<Type>> _function = (Type it) -> {
          return it.getSupertypes();
        };
        final List<Type> supertypes = CollectionsUtil.<Type>transitiveClosurePlus(typeDeclaration, _function);
        Iterable<TypeDeclaration> _filter_1 = Iterables.<TypeDeclaration>filter(supertypes, TypeDeclaration.class);
        for (final TypeDeclaration supertype : _filter_1) {
          EList<PartialComplexTypeInterpretation> _supertypeInterpretation = CollectionsUtil.<TypeDeclaration, PartialComplexTypeInterpretation>lookup(typeDeclaration, trace).getSupertypeInterpretation();
          PartialComplexTypeInterpretation _lookup = CollectionsUtil.<TypeDeclaration, PartialComplexTypeInterpretation>lookup(supertype, trace);
          _supertypeInterpretation.add(_lookup);
        }
      }
    }
  }
  
  private Map<RelationDeclaration, PartialRelationInterpretation> initRelations(final PartialInterpretation interpretation, final PrimitiveValueTrace trace) {
    final Map<RelationDeclaration, PartialRelationInterpretation> relation2Interpretation = new HashMap<RelationDeclaration, PartialRelationInterpretation>();
    final Function1<RelationDefinition, RelationDeclaration> _function = (RelationDefinition it) -> {
      return it.getDefines();
    };
    final Iterable<RelationDeclaration> definedRelationDeclarations = IterableExtensions.<RelationDefinition, RelationDeclaration>map(Iterables.<RelationDefinition>filter(interpretation.getProblem().getRelations(), RelationDefinition.class), _function);
    final Function1<RelationDeclaration, Boolean> _function_1 = (RelationDeclaration declared) -> {
      final Function1<RelationDeclaration, Boolean> _function_2 = (RelationDeclaration defined) -> {
        return Boolean.valueOf((defined == declared));
      };
      boolean _exists = IterableExtensions.<RelationDeclaration>exists(definedRelationDeclarations, _function_2);
      return Boolean.valueOf((!_exists));
    };
    final Iterable<RelationDeclaration> undefinedRelationDeclarations = IterableExtensions.<RelationDeclaration>filter(Iterables.<RelationDeclaration>filter(interpretation.getProblem().getRelations(), RelationDeclaration.class), _function_1);
    for (final RelationDeclaration relation : undefinedRelationDeclarations) {
      {
        final PartialRelationInterpretation partialInterpretation = this.initialisePartialRelationInterpretation(relation);
        EList<PartialRelationInterpretation> _partialrelationinterpretation = interpretation.getPartialrelationinterpretation();
        _partialrelationinterpretation.add(partialInterpretation);
        relation2Interpretation.put(relation, partialInterpretation);
      }
    }
    Iterable<PartialModelRelation2Assertion> _filter = Iterables.<PartialModelRelation2Assertion>filter(interpretation.getProblem().getAnnotations(), PartialModelRelation2Assertion.class);
    for (final PartialModelRelation2Assertion pMR2A : _filter) {
      {
        final RelationDeclaration relation_1 = pMR2A.getTargetRelation();
        final PartialRelationInterpretation r = CollectionsUtil.<RelationDeclaration, PartialRelationInterpretation>lookup(relation_1, relation2Interpretation);
        final Term assertion = pMR2A.getTarget().getValue();
        Iterable<SymbolicValue> _xifexpression = null;
        if ((assertion instanceof SymbolicValue)) {
          _xifexpression = Collections.<SymbolicValue>unmodifiableList(CollectionLiterals.<SymbolicValue>newArrayList(((SymbolicValue)assertion)));
        } else {
          Iterable<SymbolicValue> _xifexpression_1 = null;
          if ((assertion instanceof And)) {
            Iterable<SymbolicValue> _xblockexpression = null;
            {
              final Iterable<SymbolicValue> res = Iterables.<SymbolicValue>filter(((And)assertion).getOperands(), SymbolicValue.class);
              Iterable<SymbolicValue> _xifexpression_2 = null;
              int _size = IterableExtensions.size(res);
              int _size_1 = ((And)assertion).getOperands().size();
              boolean _notEquals = (_size != _size_1);
              if (_notEquals) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Assertion describing partial model of \"");
                String _name = r.getInterpretationOf().getName();
                _builder.append(_name);
                _builder.append("\" contains unsupported constructs");
                throw new UnsupportedOperationException(_builder.toString());
              } else {
                _xifexpression_2 = res;
              }
              _xblockexpression = _xifexpression_2;
            }
            _xifexpression_1 = _xblockexpression;
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Assertion describing partial model of \"");
            String _name = r.getInterpretationOf().getName();
            _builder.append(_name);
            _builder.append("\" contains unsupported constructs");
            throw new UnsupportedOperationException(_builder.toString());
          }
          _xifexpression = _xifexpression_1;
        }
        final Iterable<SymbolicValue> links = _xifexpression;
        for (final SymbolicValue link : links) {
          EList<RelationLink> _relationlinks = r.getRelationlinks();
          RelationLink _createLink = this.createLink(link, trace);
          _relationlinks.add(_createLink);
        }
      }
    }
    return relation2Interpretation;
  }
  
  private RelationLink createLink(final SymbolicValue v, final PrimitiveValueTrace trace) {
    final Function1<Term, DefinedElement> _function = (Term it) -> {
      return this.getElement(it, trace);
    };
    final List<DefinedElement> translatedValues = IterableExtensions.<DefinedElement>toList(ListExtensions.<Term, DefinedElement>map(v.getParameterSubstitutions(), _function));
    int _size = translatedValues.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      UnaryElementRelationLink _createUnaryElementRelationLink = this.factory.createUnaryElementRelationLink();
      final Procedure1<UnaryElementRelationLink> _function_1 = (UnaryElementRelationLink it) -> {
        it.setParam1(translatedValues.get(0));
      };
      return ObjectExtensions.<UnaryElementRelationLink>operator_doubleArrow(_createUnaryElementRelationLink, _function_1);
    } else {
      int _size_1 = translatedValues.size();
      boolean _equals_1 = (_size_1 == 2);
      if (_equals_1) {
        BinaryElementRelationLink _createBinaryElementRelationLink = this.factory.createBinaryElementRelationLink();
        final Procedure1<BinaryElementRelationLink> _function_2 = (BinaryElementRelationLink it) -> {
          it.setParam1(translatedValues.get(0));
          it.setParam2(translatedValues.get(1));
        };
        return ObjectExtensions.<BinaryElementRelationLink>operator_doubleArrow(_createBinaryElementRelationLink, _function_2);
      } else {
        final NaryRelationLink res = this.factory.createNaryRelationLink();
        int _size_2 = translatedValues.size();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
        for (final Integer i : _doubleDotLessThan) {
          EList<NaryRelationLinkElement> _elements = res.getElements();
          NaryRelationLinkElement _createNaryRelationLinkElement = this.factory.createNaryRelationLinkElement();
          final Procedure1<NaryRelationLinkElement> _function_3 = (NaryRelationLinkElement it) -> {
            it.setIndex((i).intValue());
            it.setParam(translatedValues.get((i).intValue()));
          };
          NaryRelationLinkElement _doubleArrow = ObjectExtensions.<NaryRelationLinkElement>operator_doubleArrow(_createNaryRelationLinkElement, _function_3);
          _elements.add(_doubleArrow);
        }
        return res;
      }
    }
  }
  
  private DefinedElement _getElement(final SymbolicValue element, final PrimitiveValueTrace trace) {
    SymbolicDeclaration _symbolicReference = element.getSymbolicReference();
    return ((DefinedElement) _symbolicReference);
  }
  
  private DefinedElement _getElement(final BoolLiteral element, final PrimitiveValueTrace trace) {
    return CollectionsUtil.<Boolean, BooleanElement>lookup(Boolean.valueOf(element.isValue()), trace.getBooleanMap());
  }
  
  private DefinedElement _getElement(final IntLiteral element, final PrimitiveValueTrace trace) {
    return CollectionsUtil.<Integer, IntegerElement>lookup(Integer.valueOf(element.getValue()), trace.getIntegerMap());
  }
  
  private DefinedElement _getElement(final RealLiteral element, final PrimitiveValueTrace trace) {
    return CollectionsUtil.<BigDecimal, RealElement>lookup(element.getValue(), trace.getRealMap());
  }
  
  private DefinedElement _getElement(final StringLiteral element, final PrimitiveValueTrace trace) {
    return CollectionsUtil.<String, StringElement>lookup(element.getValue(), trace.getStringMap());
  }
  
  private PartialComplexTypeInterpretation initialisePartialTypeInterpretation(final TypeDeclaration t, final ViatraQueryEngine engine) {
    final SupertypeStar.Matcher supertypeMatcher = SupertypeStar.Matcher.on(engine);
    PartialComplexTypeInterpretation _createPartialComplexTypeInterpretation = this.factory.createPartialComplexTypeInterpretation();
    final Procedure1<PartialComplexTypeInterpretation> _function = (PartialComplexTypeInterpretation it) -> {
      it.setInterpretationOf(t);
      EList<DefinedElement> _elements = it.getElements();
      final Function1<TypeDefinition, EList<DefinedElement>> _function_1 = (TypeDefinition it_1) -> {
        return it_1.getElements();
      };
      Iterable<DefinedElement> _flatten = Iterables.<DefinedElement>concat(IterableExtensions.<TypeDefinition, EList<DefinedElement>>map(Iterables.<TypeDefinition>filter(supertypeMatcher.getAllValuesOfsubtype(t), TypeDefinition.class), _function_1));
      Iterables.<DefinedElement>addAll(_elements, _flatten);
    };
    final PartialComplexTypeInterpretation res = ObjectExtensions.<PartialComplexTypeInterpretation>operator_doubleArrow(_createPartialComplexTypeInterpretation, _function);
    return res;
  }
  
  private PartialRelationInterpretation initialisePartialRelationInterpretation(final RelationDeclaration r) {
    PartialRelationInterpretation _createPartialRelationInterpretation = this.factory.createPartialRelationInterpretation();
    final Procedure1<PartialRelationInterpretation> _function = (PartialRelationInterpretation it) -> {
      it.setInterpretationOf(r);
      int _size = r.getParameters().size();
      boolean _equals = (_size == 2);
      if (_equals) {
        it.setParam1(r.getParameters().get(0));
        it.setParam2(r.getParameters().get(1));
      } else {
        throw new UnsupportedOperationException();
      }
    };
    final PartialRelationInterpretation res = ObjectExtensions.<PartialRelationInterpretation>operator_doubleArrow(_createPartialRelationInterpretation, _function);
    return res;
  }
  
  private DefinedElement getElement(final Term element, final PrimitiveValueTrace trace) {
    if (element instanceof BoolLiteral) {
      return _getElement((BoolLiteral)element, trace);
    } else if (element instanceof IntLiteral) {
      return _getElement((IntLiteral)element, trace);
    } else if (element instanceof RealLiteral) {
      return _getElement((RealLiteral)element, trace);
    } else if (element instanceof StringLiteral) {
      return _getElement((StringLiteral)element, trace);
    } else if (element instanceof SymbolicValue) {
      return _getElement((SymbolicValue)element, trace);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, trace).toString());
    }
  }
}
