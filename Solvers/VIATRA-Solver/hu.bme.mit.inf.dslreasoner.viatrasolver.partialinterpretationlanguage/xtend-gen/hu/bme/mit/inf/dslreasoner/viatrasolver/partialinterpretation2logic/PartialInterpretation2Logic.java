package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretation2logic;

import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguageFactory;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Not;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicValue;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.Annotation;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.ContainmentHierarchy;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretation2logic.PartialInterpretation2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partial2logicannotations.Partial2logicannotationsFactory;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partial2logicannotations.PartialModelRelation2Assertion;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BinaryElementRelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BooleanElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.IntegerElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PrimitiveElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RealElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.StringElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PartialInterpretation2Logic {
  @Extension
  private final LogiclanguageFactory factory = LogiclanguageFactory.eINSTANCE;
  
  @Extension
  private final LogicProblemBuilder builder = new LogicProblemBuilder();
  
  public void transformPartialIntepretation2Logic(final LogicProblem p, final PartialInterpretation i) {
    final PartialInterpretation2Logic_Trace trace = new PartialInterpretation2Logic_Trace();
    trace.getOriginalTypes().addAll(p.getTypes());
    boolean _isEmpty = i.getNewElements().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.addExistingElementToProblem(p, i, trace);
      Iterable<PartialComplexTypeInterpretation> _filter = Iterables.<PartialComplexTypeInterpretation>filter(i.getPartialtypeinterpratation(), PartialComplexTypeInterpretation.class);
      for (final PartialComplexTypeInterpretation partialTypeDeclaration : _filter) {
        this.splitTypeIntoTwo(p, partialTypeDeclaration, trace);
      }
      this.connectSplittings(p, trace);
      EList<PartialRelationInterpretation> _partialrelationinterpretation = i.getPartialrelationinterpretation();
      for (final PartialRelationInterpretation partialRelationInterpretation : _partialrelationinterpretation) {
        this.relationLinksToAssertion(p, partialRelationInterpretation, trace);
      }
    }
  }
  
  private boolean addExistingElementToProblem(final LogicProblem p, final PartialInterpretation i, final PartialInterpretation2Logic_Trace trace) {
    EList<DefinedElement> _elements = p.getElements();
    final Function1<DefinedElement, Boolean> _function = (DefinedElement it) -> {
      Not _not = this.builder.operator_not(it);
      return Boolean.valueOf((_not instanceof PrimitiveElement));
    };
    Iterable<DefinedElement> _filter = IterableExtensions.<DefinedElement>filter(i.getNewElements(), _function);
    return Iterables.<DefinedElement>addAll(_elements, _filter);
  }
  
  private void splitTypeIntoTwo(final LogicProblem p, final PartialComplexTypeInterpretation partialTypeDeclaration, final PartialInterpretation2Logic_Trace trace) {
    boolean _isEmpty = partialTypeDeclaration.getElements().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final TypeDeclaration declaration = partialTypeDeclaration.getInterpretationOf();
      TypeDefinition _createTypeDefinition = this.factory.createTypeDefinition();
      final Procedure1<TypeDefinition> _function = (TypeDefinition it) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _name = declaration.getName();
        _builder.append(_name);
        _builder.append(" DefinedPart");
        it.setName(_builder.toString());
        EList<DefinedElement> _elements = it.getElements();
        EList<DefinedElement> _elements_1 = partialTypeDeclaration.getElements();
        Iterables.<DefinedElement>addAll(_elements, _elements_1);
        it.setIsAbstract(declaration.isIsAbstract());
      };
      final TypeDefinition definedPart = ObjectExtensions.<TypeDefinition>operator_doubleArrow(_createTypeDefinition, _function);
      TypeDeclaration _createTypeDeclaration = this.factory.createTypeDeclaration();
      final Procedure1<TypeDeclaration> _function_1 = (TypeDeclaration it) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _name = declaration.getName();
        _builder.append(_name);
        _builder.append(" UndefinedPart");
        it.setName(_builder.toString());
        it.setIsAbstract(declaration.isIsAbstract());
      };
      final TypeDeclaration undefinedPart = ObjectExtensions.<TypeDeclaration>operator_doubleArrow(_createTypeDeclaration, _function_1);
      declaration.setIsAbstract(true);
      trace.getDefinedPart().put(declaration, definedPart);
      trace.getUndefinedPart().put(declaration, undefinedPart);
      trace.getSplittedTypes().add(declaration);
      this.builder.add(p, definedPart);
      this.builder.add(p, undefinedPart);
      this.builder.Supertype(definedPart, declaration);
      this.builder.Supertype(undefinedPart, declaration);
      EList<ContainmentHierarchy> _containmentHierarchies = p.getContainmentHierarchies();
      for (final ContainmentHierarchy containment : _containmentHierarchies) {
        boolean _contains = containment.getTypesOrderedInHierarchy().contains(declaration);
        if (_contains) {
          EList<Type> _typesOrderedInHierarchy = containment.getTypesOrderedInHierarchy();
          _typesOrderedInHierarchy.add(definedPart);
          EList<Type> _typesOrderedInHierarchy_1 = containment.getTypesOrderedInHierarchy();
          _typesOrderedInHierarchy_1.add(undefinedPart);
        }
      }
    }
  }
  
  private void connectSplittings(final LogicProblem p, final PartialInterpretation2Logic_Trace trace) {
    final Function1<Type, Boolean> _function = (Type it) -> {
      return Boolean.valueOf(this.originalType(it, trace));
    };
    final List<Type> originalTypes = IterableExtensions.<Type>toList(IterableExtensions.<Type>filter(p.getTypes(), _function));
    for (final Type type : originalTypes) {
      {
        final Function1<Type, Boolean> _function_1 = (Type it) -> {
          return Boolean.valueOf(this.originalType(it, trace));
        };
        List<Type> _list = IterableExtensions.<Type>toList(IterableExtensions.<Type>filter(type.getSupertypes(), _function_1));
        final ArrayList<Type> superTypes = new ArrayList<Type>(_list);
        for (final Type supertype : superTypes) {
          boolean _isSplitted = this.isSplitted(type, trace);
          if (_isSplitted) {
            boolean _isSplitted_1 = this.isSplitted(supertype, trace);
            if (_isSplitted_1) {
              this.builder.Supertype(CollectionsUtil.<TypeDeclaration, TypeDefinition>lookup(((TypeDeclaration) type), trace.getDefinedPart()), CollectionsUtil.<TypeDeclaration, TypeDefinition>lookup(((TypeDeclaration) supertype), trace.getDefinedPart()));
              this.builder.Supertype(CollectionsUtil.<TypeDeclaration, TypeDeclaration>lookup(((TypeDeclaration) type), trace.getUndefinedPart()), CollectionsUtil.<TypeDeclaration, TypeDeclaration>lookup(((TypeDeclaration) supertype), trace.getUndefinedPart()));
            } else {
            }
          } else {
            boolean _isSplitted_2 = this.isSplitted(supertype, trace);
            if (_isSplitted_2) {
              this.builder.Supertype(type, CollectionsUtil.<TypeDeclaration, TypeDeclaration>lookup(((TypeDeclaration) supertype), trace.getUndefinedPart()));
            } else {
              if ((supertype instanceof TypeDefinition)) {
              }
            }
          }
        }
      }
    }
  }
  
  private boolean originalType(final Type type, final PartialInterpretation2Logic_Trace trace) {
    return trace.getOriginalTypes().contains(type);
  }
  
  private boolean isSplitted(final Type t, final PartialInterpretation2Logic_Trace trace) {
    return trace.getSplittedTypes().contains(t);
  }
  
  private void relationLinksToAssertion(final LogicProblem p, final PartialRelationInterpretation r, final PartialInterpretation2Logic_Trace trace) {
    final RelationDeclaration relation = r.getInterpretationOf();
    final EList<RelationLink> links = r.getRelationlinks();
    int _size = links.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return;
    } else {
      Term _xifexpression = null;
      int _size_1 = links.size();
      boolean _equals_1 = (_size_1 == 1);
      if (_equals_1) {
        _xifexpression = this.createLink(IterableExtensions.<RelationLink>head(links), relation);
      } else {
        final Function1<RelationLink, SymbolicValue> _function = (RelationLink link) -> {
          return this.createLink(link, relation);
        };
        _xifexpression = this.builder.And(ListExtensions.<RelationLink, SymbolicValue>map(links, _function));
      }
      final Term term = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PartialInterpretation ");
      String _name = r.getInterpretationOf().getName();
      _builder.append(_name);
      final Assertion assertion = this.builder.Assertion(_builder, term);
      final PartialModelRelation2Assertion annotation = Partial2logicannotationsFactory.eINSTANCE.createPartialModelRelation2Assertion();
      annotation.setTarget(assertion);
      annotation.setTargetRelation(relation);
      this.builder.add(p, assertion);
      EList<Annotation> _annotations = p.getAnnotations();
      _annotations.add(annotation);
    }
  }
  
  private SymbolicValue createLink(final RelationLink link, final SymbolicDeclaration relationDeclaration) {
    if ((link instanceof BinaryElementRelationLink)) {
      if (((((BinaryElementRelationLink)link).getParam1() != null) && (((BinaryElementRelationLink)link).getParam2() != null))) {
        SymbolicValue _createSymbolicValue = this.factory.createSymbolicValue();
        final Procedure1<SymbolicValue> _function = (SymbolicValue it) -> {
          it.setSymbolicReference(relationDeclaration);
          EList<Term> _parameterSubstitutions = it.getParameterSubstitutions();
          Term _createValueInLink = this.createValueInLink(((BinaryElementRelationLink)link).getParam1());
          _parameterSubstitutions.add(_createValueInLink);
          EList<Term> _parameterSubstitutions_1 = it.getParameterSubstitutions();
          Term _createValueInLink_1 = this.createValueInLink(((BinaryElementRelationLink)link).getParam2());
          _parameterSubstitutions_1.add(_createValueInLink_1);
        };
        return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue, _function);
      } else {
        throw new IllegalArgumentException();
      }
    } else {
      throw new UnsupportedOperationException();
    }
  }
  
  private Term _createValueInLink(final BooleanElement element) {
    return this.builder.asTerm(element.isValue());
  }
  
  private Term _createValueInLink(final IntegerElement element) {
    return this.builder.asTerm(element.getValue());
  }
  
  private Term _createValueInLink(final RealElement element) {
    return this.builder.asTerm(element.getValue());
  }
  
  private Term _createValueInLink(final StringElement element) {
    return this.builder.asTerm(element.getValue());
  }
  
  private Term _createValueInLink(final DefinedElement element) {
    SymbolicValue _createSymbolicValue = this.factory.createSymbolicValue();
    final Procedure1<SymbolicValue> _function = (SymbolicValue it) -> {
      it.setSymbolicReference(element);
    };
    return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue, _function);
  }
  
  private Term createValueInLink(final DefinedElement element) {
    if (element instanceof BooleanElement) {
      return _createValueInLink((BooleanElement)element);
    } else if (element instanceof IntegerElement) {
      return _createValueInLink((IntegerElement)element);
    } else if (element instanceof RealElement) {
      return _createValueInLink((RealElement)element);
    } else if (element instanceof StringElement) {
      return _createValueInLink((StringElement)element);
    } else if (element != null) {
      return _createValueInLink(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
