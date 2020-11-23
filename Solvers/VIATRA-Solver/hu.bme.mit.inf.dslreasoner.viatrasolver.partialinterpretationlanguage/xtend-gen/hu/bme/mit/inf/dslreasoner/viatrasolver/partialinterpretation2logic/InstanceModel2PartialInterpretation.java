package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretation2logic;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.TracedOutput;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.TypeScopes;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguageFactory;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.PartialInterpretationInitialiser;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.Problem2PartialInterpretationTrace;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BinaryElementRelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BooleanElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.IntegerElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialinterpretationFactory;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RealElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.StringElement;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class InstanceModel2PartialInterpretation {
  @Extension
  private final LogiclanguageFactory factory = LogiclanguageFactory.eINSTANCE;
  
  @Extension
  private final PartialinterpretationFactory factory2 = PartialinterpretationFactory.eINSTANCE;
  
  private final Ecore2Logic ecore2Logic = new Ecore2Logic();
  
  private final PartialInterpretationInitialiser partialInterpretationInitialiser = new PartialInterpretationInitialiser();
  
  public PartialInterpretation transform(final TracedOutput<LogicProblem, Ecore2Logic_Trace> metamodelTranslationResult, final Resource resource, final boolean withID) {
    final ImmutableList.Builder<EObject> objectsBuilder = ImmutableList.<EObject>builder();
    final TreeIterator<EObject> treeIterator = resource.getAllContents();
    final Set<EReference> referencesUsed = IterableExtensions.<EReference>toSet(this.ecore2Logic.allReferencesInScope(metamodelTranslationResult.getTrace()));
    while (treeIterator.hasNext()) {
      {
        final EObject object = treeIterator.next();
        final EReference containingReference = object.eContainmentFeature();
        if (((containingReference == null) || referencesUsed.contains(containingReference))) {
          objectsBuilder.add(object);
        } else {
          treeIterator.prune();
        }
      }
    }
    final ImmutableList<EObject> objects = objectsBuilder.build();
    return this.transform(metamodelTranslationResult, objects, withID);
  }
  
  public PartialInterpretation transform(final TracedOutput<LogicProblem, Ecore2Logic_Trace> metamodelTranslationResult, final List<EObject> objects, final boolean withID) {
    final LogicProblem problem = metamodelTranslationResult.getOutput();
    final Ecore2Logic_Trace ecore2LogicTrace = metamodelTranslationResult.getTrace();
    final Set<EReference> referencesUsed = IterableExtensions.<EReference>toSet(this.ecore2Logic.allReferencesInScope(ecore2LogicTrace));
    final Set<EAttribute> attributesUsed = IterableExtensions.<EAttribute>toSet(this.ecore2Logic.allAttributesInScope(ecore2LogicTrace));
    final TypeScopes typeScope = this.createTypeScopesFromKnownAttributeValues(objects, attributesUsed);
    final TracedOutput<PartialInterpretation, Problem2PartialInterpretationTrace> tracedOutput = this.partialInterpretationInitialiser.initialisePartialInterpretation(problem, typeScope);
    final PartialInterpretation partialInterpretation = tracedOutput.getOutput();
    final Problem2PartialInterpretationTrace partialInterpretationTrace = tracedOutput.getTrace();
    final Map<EObject, DefinedElement> object2DefinedElement = new HashMap<EObject, DefinedElement>();
    int _size = objects.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer objectIndex : _doubleDotLessThan) {
      {
        final EObject object = objects.get((objectIndex).intValue());
        DefinedElement _createDefinedElement = this.factory.createDefinedElement();
        final Procedure1<DefinedElement> _function = (DefinedElement it) -> {
          String _xifexpression = null;
          if (withID) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("o ");
            _builder.append(((objectIndex).intValue() + 1));
            _xifexpression = _builder.toString();
          } else {
            _xifexpression = null;
          }
          it.setName(_xifexpression);
        };
        final DefinedElement element = ObjectExtensions.<DefinedElement>operator_doubleArrow(_createDefinedElement, _function);
        EList<DefinedElement> _newElements = partialInterpretation.getNewElements();
        _newElements.add(element);
        Type _TypeofEClass = this.ecore2Logic.TypeofEClass(ecore2LogicTrace, object.eClass());
        final TypeDeclaration type = ((TypeDeclaration) _TypeofEClass);
        final PartialComplexTypeInterpretation interpretation = CollectionsUtil.<TypeDeclaration, PartialComplexTypeInterpretation>lookup(type, partialInterpretationTrace.getType2Interpretation());
        EList<DefinedElement> _elements = interpretation.getElements();
        _elements.add(element);
        final Consumer<PartialComplexTypeInterpretation> _function_1 = (PartialComplexTypeInterpretation it) -> {
          EList<DefinedElement> _elements_1 = it.getElements();
          _elements_1.add(element);
        };
        interpretation.getSupertypeInterpretation().forEach(_function_1);
        object2DefinedElement.put(object, element);
      }
    }
    for (final EObject source : objects) {
      {
        final Function1<EReference, Boolean> _function = (EReference it) -> {
          return Boolean.valueOf((referencesUsed.contains(it) && (!it.isDerived())));
        };
        Iterable<EReference> _filter = IterableExtensions.<EReference>filter(source.eClass().getEAllReferences(), _function);
        for (final EReference reference : _filter) {
          {
            final RelationDeclaration type = this.ecore2Logic.relationOfReference(ecore2LogicTrace, reference);
            final PartialRelationInterpretation interpretation = CollectionsUtil.<RelationDeclaration, PartialRelationInterpretation>lookup(type, partialInterpretationTrace.getRelation2Interpretation());
            final DefinedElement sourceElement = CollectionsUtil.<EObject, DefinedElement>lookup(source, object2DefinedElement);
            boolean _isMany = reference.isMany();
            if (_isMany) {
              Object _eGet = source.eGet(reference);
              final List<? extends EObject> listOfTargets = ((List<? extends EObject>) _eGet);
              for (final EObject target : listOfTargets) {
                if (((target != null) && object2DefinedElement.containsKey(target))) {
                  final DefinedElement targetElement = CollectionsUtil.<EObject, DefinedElement>lookup(target, object2DefinedElement);
                  this.translateLink(interpretation, sourceElement, targetElement);
                }
              }
            } else {
              Object _eGet_1 = source.eGet(reference);
              final EObject target_1 = ((EObject) _eGet_1);
              if (((target_1 != null) && object2DefinedElement.containsKey(target_1))) {
                final DefinedElement targetElement_1 = CollectionsUtil.<EObject, DefinedElement>lookup(target_1, object2DefinedElement);
                this.translateLink(interpretation, sourceElement, targetElement_1);
              }
            }
          }
        }
        final Function1<EAttribute, Boolean> _function_1 = (EAttribute it) -> {
          return Boolean.valueOf((attributesUsed.contains(it) && (!it.isDerived())));
        };
        Iterable<EAttribute> _filter_1 = IterableExtensions.<EAttribute>filter(source.eClass().getEAllAttributes(), _function_1);
        for (final EAttribute attribute : _filter_1) {
          {
            final RelationDeclaration type = this.ecore2Logic.relationOfAttribute(ecore2LogicTrace, attribute);
            final PartialRelationInterpretation interpretation = CollectionsUtil.<RelationDeclaration, PartialRelationInterpretation>lookup(type, partialInterpretationTrace.getRelation2Interpretation());
            final DefinedElement sourceElement = CollectionsUtil.<EObject, DefinedElement>lookup(source, object2DefinedElement);
            boolean _isMany = attribute.isMany();
            if (_isMany) {
              Object _eGet = source.eGet(attribute);
              final List<? extends EObject> listOfTargets = ((List<? extends EObject>) _eGet);
              for (final EObject target : listOfTargets) {
                {
                  final DefinedElement value = this.translateValue(target, ecore2LogicTrace, partialInterpretationTrace);
                  if ((value != null)) {
                    this.translateLink(interpretation, sourceElement, value);
                  }
                }
              }
            } else {
              final Object target_1 = source.eGet(attribute);
              if ((target_1 != null)) {
                final DefinedElement value = this.translateValue(target_1, ecore2LogicTrace, partialInterpretationTrace);
                if ((value != null)) {
                  this.translateLink(interpretation, sourceElement, value);
                }
              }
            }
          }
        }
      }
    }
    return partialInterpretation;
  }
  
  private TypeScopes createTypeScopesFromKnownAttributeValues(final List<EObject> objects, final Set<EAttribute> attributesUsed) {
    final Set<Integer> integers = new HashSet<Integer>();
    final Set<BigDecimal> reals = new HashSet<BigDecimal>();
    final Set<String> strings = new HashSet<String>();
    for (final EObject object : objects) {
      final Function1<EAttribute, Boolean> _function = (EAttribute it) -> {
        return Boolean.valueOf(attributesUsed.contains(it));
      };
      Iterable<EAttribute> _filter = IterableExtensions.<EAttribute>filter(object.eClass().getEAllAttributes(), _function);
      for (final EAttribute attribute : _filter) {
        {
          final Object value = object.eGet(attribute);
          if ((value != null)) {
            if ((value instanceof List<?>)) {
              for (final Object v : ((List<?>)value)) {
                this.shortValue(v, integers, reals, strings);
              }
            } else {
              this.shortValue(value, integers, reals, strings);
            }
          }
        }
      }
    }
    TypeScopes _typeScopes = new TypeScopes();
    final Procedure1<TypeScopes> _function_1 = (TypeScopes it) -> {
      Iterables.<Integer>addAll(it.knownIntegers, integers);
      Iterables.<BigDecimal>addAll(it.knownReals, reals);
      Iterables.<String>addAll(it.knownStrings, strings);
    };
    return ObjectExtensions.<TypeScopes>operator_doubleArrow(_typeScopes, _function_1);
  }
  
  private Boolean _shortValue(final Boolean value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    return null;
  }
  
  private Boolean _shortValue(final Integer value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    return Boolean.valueOf(integers.add(value));
  }
  
  private Boolean _shortValue(final Short value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    Integer _valueOf = Integer.valueOf((value).shortValue());
    return Boolean.valueOf(integers.add(_valueOf));
  }
  
  private Boolean _shortValue(final Float value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    BigDecimal _valueOf = BigDecimal.valueOf((value).floatValue());
    return Boolean.valueOf(reals.add(_valueOf));
  }
  
  private Boolean _shortValue(final Double value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    BigDecimal _valueOf = BigDecimal.valueOf((value).doubleValue());
    return Boolean.valueOf(reals.add(_valueOf));
  }
  
  private Boolean _shortValue(final String value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    return Boolean.valueOf(strings.add(value));
  }
  
  private Boolean _shortValue(final Void value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    return null;
  }
  
  private Boolean _shortValue(final Object value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    return null;
  }
  
  protected boolean translateLink(final PartialRelationInterpretation interpretation, final DefinedElement source, final DefinedElement target) {
    EList<RelationLink> _relationlinks = interpretation.getRelationlinks();
    BinaryElementRelationLink _createBinaryElementRelationLink = this.factory2.createBinaryElementRelationLink();
    final Procedure1<BinaryElementRelationLink> _function = (BinaryElementRelationLink it) -> {
      it.setParam1(source);
      it.setParam2(target);
    };
    BinaryElementRelationLink _doubleArrow = ObjectExtensions.<BinaryElementRelationLink>operator_doubleArrow(_createBinaryElementRelationLink, _function);
    return _relationlinks.add(_doubleArrow);
  }
  
  protected DefinedElement _translateValue(final Enumerator value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    final TermDescription term = this.ecore2Logic.Literal(ecore2LogicTrace, value);
    if ((term instanceof DefinedElement)) {
      return ((DefinedElement)term);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("term should be a defined element?");
      throw new AssertionError(_builder);
    }
  }
  
  protected DefinedElement _translateValue(final Boolean value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    return CollectionsUtil.<Boolean, BooleanElement>lookup(value, partialInterpretationTrace.getPrimitiveValues().getBooleanMap());
  }
  
  protected DefinedElement _translateValue(final Integer value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    return CollectionsUtil.<Integer, IntegerElement>lookup(value, partialInterpretationTrace.getPrimitiveValues().getIntegerMap());
  }
  
  protected DefinedElement _translateValue(final Short value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    return CollectionsUtil.<Integer, IntegerElement>lookup(Integer.valueOf((value).shortValue()), partialInterpretationTrace.getPrimitiveValues().getIntegerMap());
  }
  
  protected DefinedElement _translateValue(final Double value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    return CollectionsUtil.<BigDecimal, RealElement>lookup(BigDecimal.valueOf((value).doubleValue()), partialInterpretationTrace.getPrimitiveValues().getRealMap());
  }
  
  protected DefinedElement _translateValue(final Float value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    return CollectionsUtil.<BigDecimal, RealElement>lookup(BigDecimal.valueOf((value).floatValue()), partialInterpretationTrace.getPrimitiveValues().getRealMap());
  }
  
  protected DefinedElement _translateValue(final String value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    return CollectionsUtil.<String, StringElement>lookup(value, partialInterpretationTrace.getPrimitiveValues().getStringMap());
  }
  
  private Boolean shortValue(final Object value, final Set<Integer> integers, final Set<BigDecimal> reals, final Set<String> strings) {
    if (value instanceof Double) {
      return _shortValue((Double)value, integers, reals, strings);
    } else if (value instanceof Float) {
      return _shortValue((Float)value, integers, reals, strings);
    } else if (value instanceof Integer) {
      return _shortValue((Integer)value, integers, reals, strings);
    } else if (value instanceof Short) {
      return _shortValue((Short)value, integers, reals, strings);
    } else if (value instanceof Boolean) {
      return _shortValue((Boolean)value, integers, reals, strings);
    } else if (value instanceof String) {
      return _shortValue((String)value, integers, reals, strings);
    } else if (value == null) {
      return _shortValue((Void)null, integers, reals, strings);
    } else if (value != null) {
      return _shortValue(value, integers, reals, strings);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value, integers, reals, strings).toString());
    }
  }
  
  protected DefinedElement translateValue(final Object value, final Ecore2Logic_Trace ecore2LogicTrace, final Problem2PartialInterpretationTrace partialInterpretationTrace) {
    if (value instanceof Double) {
      return _translateValue((Double)value, ecore2LogicTrace, partialInterpretationTrace);
    } else if (value instanceof Float) {
      return _translateValue((Float)value, ecore2LogicTrace, partialInterpretationTrace);
    } else if (value instanceof Integer) {
      return _translateValue((Integer)value, ecore2LogicTrace, partialInterpretationTrace);
    } else if (value instanceof Short) {
      return _translateValue((Short)value, ecore2LogicTrace, partialInterpretationTrace);
    } else if (value instanceof Boolean) {
      return _translateValue((Boolean)value, ecore2LogicTrace, partialInterpretationTrace);
    } else if (value instanceof String) {
      return _translateValue((String)value, ecore2LogicTrace, partialInterpretationTrace);
    } else if (value instanceof Enumerator) {
      return _translateValue((Enumerator)value, ecore2LogicTrace, partialInterpretationTrace);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value, ecore2LogicTrace, partialInterpretationTrace).toString());
    }
  }
}
