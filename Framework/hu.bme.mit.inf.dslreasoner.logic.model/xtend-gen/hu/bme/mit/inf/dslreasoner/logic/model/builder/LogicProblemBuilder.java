package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.FunctionDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilderException;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.VariableContext;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.AggregateExpression;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.AggregatedParameterSubstitution;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.And;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.BoolLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.BoolTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ComplexTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Constant;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ConstantDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ConstantDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Count;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Distinct;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Divison;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Equals;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Exists;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Forall;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Function;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.FunctionDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.FunctionDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.IfThenElse;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Iff;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Impl;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.InstanceOf;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.IntLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.IntTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LessOrEqualThan;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LessThan;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguageFactory;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Max;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Min;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Minus;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Mod;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.MoreOrEqualThan;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.MoreThan;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Multiply;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Not;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Or;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Plus;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Pow;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ProjectedAggregateExpression;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.QuantifiedExpression;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RealLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RealTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Relation;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.StringLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.StringTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Sum;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicValue;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TransitiveClosure;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDescriptor;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Variable;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.ContainmentHierarchy;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicproblemFactory;
import hu.bme.mit.inf.dslreasoner.util.LogicProblemBuilder_AdvancedConstructs;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class LogicProblemBuilder {
  @Extension
  protected final LogiclanguageFactory logicFactiory = LogiclanguageFactory.eINSTANCE;
  
  @Extension
  protected final LogicproblemFactory problemFactory = LogicproblemFactory.eINSTANCE;
  
  protected final LogicProblemBuilder_AdvancedConstructs advancedConstructs = new LogicProblemBuilder_AdvancedConstructs(this);
  
  public LogicProblem createProblem() {
    return this.problemFactory.createLogicProblem();
  }
  
  protected String canonize(final CharSequence name) {
    try {
      if ((name == null)) {
        return "";
      }
      final String[] result = name.toString().split("\\s+");
      int _size = ((List<String>)Conversions.doWrapArray(result)).size();
      boolean _equals = (_size == 1);
      if (_equals) {
        final String element = result[0];
        if ((((Objects.equal(element, "bool") || 
          Objects.equal(element, "int")) || 
          Objects.equal(element, "real")) || 
          Objects.equal(element, "string"))) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Reserved keyword \"");
          _builder.append(element);
          _builder.append("\"!");
          throw new LogicProblemBuilderException(_builder.toString());
        } else {
          return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(result)), " ");
        }
      } else {
        return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(result)), " ");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String generateUniqueName(final Iterable<String> previous, final Function1<Integer, String> namer) {
    int i = 0;
    boolean generateNew = false;
    String finalName = null;
    do {
      {
        i = (i + 1);
        final String nameCandidate = namer.apply(Integer.valueOf(i));
        finalName = nameCandidate;
        final Function1<String, Boolean> _function = (String it) -> {
          return Boolean.valueOf(it.equals(nameCandidate));
        };
        generateNew = IterableExtensions.<String>exists(previous, _function);
      }
    } while(generateNew);
    return finalName;
  }
  
  public DefinedElement Element(final CharSequence elementName) {
    DefinedElement _createDefinedElement = this.logicFactiory.createDefinedElement();
    final Procedure1<DefinedElement> _function = (DefinedElement x) -> {
      x.setName(this.canonize(elementName));
    };
    return ObjectExtensions.<DefinedElement>operator_doubleArrow(_createDefinedElement, _function);
  }
  
  public DefinedElement Element() {
    return this.logicFactiory.createDefinedElement();
  }
  
  public TypeDeclaration TypeDeclaration(final CharSequence name, final boolean isAbstract) {
    TypeDeclaration _TypeDeclaration = this.TypeDeclaration();
    final Procedure1<TypeDeclaration> _function = (TypeDeclaration x) -> {
      x.setName(this.canonize(name));
      x.setIsAbstract(isAbstract);
    };
    return ObjectExtensions.<TypeDeclaration>operator_doubleArrow(_TypeDeclaration, _function);
  }
  
  public TypeDeclaration TypeDeclaration() {
    return this.logicFactiory.createTypeDeclaration();
  }
  
  public TypeDefinition TypeDefinition(final CharSequence name, final boolean isAbstract, final DefinedElement... elements) {
    return this.TypeDefinition(name, isAbstract, ((Iterable<DefinedElement>) Conversions.doWrapArray(elements)));
  }
  
  public TypeDefinition TypeDefinition(final CharSequence name, final boolean isAbstract, final Iterable<DefinedElement> elements) {
    TypeDefinition _createTypeDefinition = this.logicFactiory.createTypeDefinition();
    final Procedure1<TypeDefinition> _function = (TypeDefinition x) -> {
      x.setName(this.canonize(name));
      x.setIsAbstract(isAbstract);
      EList<DefinedElement> _elements = x.getElements();
      Iterables.<DefinedElement>addAll(_elements, elements);
    };
    return ObjectExtensions.<TypeDefinition>operator_doubleArrow(_createTypeDefinition, _function);
  }
  
  public boolean Supertype(final Type subtype, final Type supertype) {
    EList<Type> _supertypes = subtype.getSupertypes();
    return _supertypes.add(supertype);
  }
  
  public boolean SetSupertype(final Type subtype, final Type supertype, final boolean value) {
    boolean _xifexpression = false;
    if (value) {
      EList<Type> _supertypes = subtype.getSupertypes();
      _xifexpression = _supertypes.add(supertype);
    } else {
      EList<Type> _subtypes = subtype.getSubtypes();
      _xifexpression = _subtypes.remove(supertype);
    }
    return _xifexpression;
  }
  
  public Type add(final LogicProblem problem, final Type type) {
    this.nameIfAnonymType(problem, type);
    EList<Type> _types = problem.getTypes();
    _types.add(type);
    if ((type instanceof TypeDefinition)) {
      EList<DefinedElement> _elements = problem.getElements();
      EList<DefinedElement> _elements_1 = ((TypeDefinition)type).getElements();
      Iterables.<DefinedElement>addAll(_elements, _elements_1);
    }
    return type;
  }
  
  protected void _nameIfAnonymType(final LogicProblem problem, final Type typeDeclaration) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(typeDeclaration.getName());
    if (_isNullOrEmpty) {
      final Function1<Type, String> _function = (Type it) -> {
        return it.getName();
      };
      final Function1<Integer, String> _function_1 = (Integer i) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type ");
        String _string = i.toString();
        _builder.append(_string);
        return _builder.toString();
      };
      typeDeclaration.setName(this.generateUniqueName(ListExtensions.<Type, String>map(problem.getTypes(), _function), _function_1));
    }
  }
  
  protected void _nameIfAnonymType(final LogicProblem problem, final TypeDefinition typeDefinition) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(typeDefinition.getName());
    if (_isNullOrEmpty) {
      final Function1<Type, String> _function = (Type it) -> {
        return it.getName();
      };
      final Function1<Integer, String> _function_1 = (Integer i) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type ");
        String _string = i.toString();
        _builder.append(_string);
        return _builder.toString();
      };
      typeDefinition.setName(this.generateUniqueName(ListExtensions.<Type, String>map(problem.getTypes(), _function), _function_1));
    }
    EList<DefinedElement> _elements = typeDefinition.getElements();
    for (final DefinedElement element : _elements) {
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(element.getName());
      if (_isNullOrEmpty_1) {
        final Function1<DefinedElement, String> _function_2 = (DefinedElement it) -> {
          return it.getName();
        };
        final Function1<Integer, String> _function_3 = (Integer i) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("type ");
          String _string = i.toString();
          _builder.append(_string);
          return _builder.toString();
        };
        element.setName(this.generateUniqueName(ListExtensions.<DefinedElement, String>map(typeDefinition.getElements(), _function_2), _function_3));
      }
    }
  }
  
  public BoolTypeReference LogicBool() {
    return this.logicFactiory.createBoolTypeReference();
  }
  
  public IntTypeReference LogicInt() {
    return this.logicFactiory.createIntTypeReference();
  }
  
  public RealTypeReference LogicReal() {
    return this.logicFactiory.createRealTypeReference();
  }
  
  public StringTypeReference LogicString() {
    return this.logicFactiory.createStringTypeReference();
  }
  
  public TypeReference toTypeReference(final TypeDescriptor descriptor) {
    if ((descriptor instanceof TypeReference)) {
      return EcoreUtil.<TypeReference>copy(((TypeReference)descriptor));
    } else {
      if ((descriptor instanceof Type)) {
        ComplexTypeReference _createComplexTypeReference = this.logicFactiory.createComplexTypeReference();
        final Procedure1<ComplexTypeReference> _function = (ComplexTypeReference it) -> {
          it.setReferred(((Type)descriptor));
        };
        return ObjectExtensions.<ComplexTypeReference>operator_doubleArrow(_createComplexTypeReference, _function);
      } else {
        Class<? extends TypeDescriptor> _class = descriptor.getClass();
        String _plus = ("Unsupported type descriptor: " + _class);
        throw new UnsupportedOperationException(_plus);
      }
    }
  }
  
  public Variable createVar(final CharSequence name, final TypeDescriptor range) {
    Variable _createVariable = this.logicFactiory.createVariable();
    final Procedure1<Variable> _function = (Variable it) -> {
      it.setName(this.canonize(name));
      it.setRange(this.toTypeReference(range));
    };
    return ObjectExtensions.<Variable>operator_doubleArrow(_createVariable, _function);
  }
  
  public FunctionDescription operator_mappedTo(final TypeDescriptor parameter, final TypeDescriptor range) {
    return this.operator_mappedTo(Collections.<TypeDescriptor>unmodifiableList(CollectionLiterals.<TypeDescriptor>newArrayList(parameter)), range);
  }
  
  public FunctionDescription operator_mappedTo(final Iterable<? extends TypeDescriptor> parameters, final TypeDescriptor range) {
    final Function1<TypeDescriptor, TypeReference> _function = (TypeDescriptor it) -> {
      return this.toTypeReference(it);
    };
    Iterable<TypeReference> _map = IterableExtensions.map(parameters, _function);
    TypeReference _typeReference = this.toTypeReference(range);
    return new FunctionDescription(_map, _typeReference);
  }
  
  public FunctionDeclaration FunctionDeclaration(final CharSequence name, final FunctionDescription functionDescription) {
    return this.FunctionDeclaration(name, functionDescription.getRange(), functionDescription.getParameters());
  }
  
  public FunctionDeclaration FunctionDeclaration(final FunctionDescription functionDescription) {
    return this.FunctionDeclaration(functionDescription.getRange(), functionDescription.getParameters());
  }
  
  public FunctionDeclaration FunctionDeclaration(final CharSequence name, final TypeDescriptor range, final TypeDescriptor... parameters) {
    return this.FunctionDeclaration(name, range, ((Iterable<? extends TypeReference>) Conversions.doWrapArray(parameters)));
  }
  
  public FunctionDeclaration FunctionDeclaration(final TypeDescriptor range, final TypeDescriptor... parameters) {
    return this.FunctionDeclaration(range, ((Iterable<? extends TypeReference>) Conversions.doWrapArray(parameters)));
  }
  
  public FunctionDeclaration FunctionDeclaration(final CharSequence name, final TypeDescriptor range, final Iterable<? extends TypeDescriptor> parameters) {
    FunctionDeclaration _FunctionDeclaration = this.FunctionDeclaration(range, parameters);
    final Procedure1<FunctionDeclaration> _function = (FunctionDeclaration x) -> {
      x.setName(this.canonize(name));
    };
    return ObjectExtensions.<FunctionDeclaration>operator_doubleArrow(_FunctionDeclaration, _function);
  }
  
  public FunctionDeclaration FunctionDeclaration(final TypeDescriptor range, final Iterable<? extends TypeDescriptor> parameters) {
    final FunctionDeclaration function = this.logicFactiory.createFunctionDeclaration();
    for (final TypeDescriptor parameter : parameters) {
      EList<TypeReference> _parameters = function.getParameters();
      TypeReference _typeReference = this.toTypeReference(parameter);
      _parameters.add(_typeReference);
    }
    function.setRange(this.toTypeReference(range));
    return function;
  }
  
  public FunctionDefinition FunctionDefinition(final CharSequence name, final TypeDescriptor range, final Function1<VariableContext, ? extends TermDescription> expression) {
    final VariableContext context = new VariableContext(this, this.logicFactiory);
    final TermDescription definition = expression.apply(context);
    return this.FunctionDefinition(name, range, context.getVariables(), definition);
  }
  
  public FunctionDefinition FunctionDefinition(final CharSequence name, final TypeDescriptor range, final Iterable<Variable> variables, final TermDescription definition) {
    FunctionDefinition _createFunctionDefinition = this.logicFactiory.createFunctionDefinition();
    final Procedure1<FunctionDefinition> _function = (FunctionDefinition it) -> {
      it.setName(this.canonize(name));
      EList<TypeReference> _parameters = it.getParameters();
      final Function1<Variable, TypeReference> _function_1 = (Variable it_1) -> {
        return this.toTypeReference(it_1.getRange());
      };
      Iterable<TypeReference> _map = IterableExtensions.<Variable, TypeReference>map(variables, _function_1);
      Iterables.<TypeReference>addAll(_parameters, _map);
      EList<Variable> _variable = it.getVariable();
      Iterables.<Variable>addAll(_variable, variables);
      it.setRange(this.toTypeReference(range));
      it.setValue(this.toTerm(definition));
    };
    return ObjectExtensions.<FunctionDefinition>operator_doubleArrow(_createFunctionDefinition, _function);
  }
  
  public FunctionDefinition FunctionDefinition(final CharSequence name, final TypeDescriptor range, final Iterable<TypeDescriptor> parameters, final Map<List<Term>, Term> parametersToValue) {
    return this.FunctionDefinition(name, range, parameters, parametersToValue, null);
  }
  
  public FunctionDefinition FunctionDefinition(final CharSequence name, final TypeDescriptor range, final Iterable<TypeDescriptor> parameters, final Map<List<Term>, Term> parametersToValue, final Term defaultValue) {
    final List<TypeDescriptor> parameterList = IterableExtensions.<TypeDescriptor>toList(parameters);
    int _size = parameterList.size();
    final Function1<Integer, Variable> _function = (Integer index) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("param ");
      _builder.append(index);
      return this.createVar(_builder, parameterList.get(((index).intValue() - 1)));
    };
    final List<Variable> variableList = IterableExtensions.<Variable>toList(IterableExtensions.<Integer, Variable>map(new IntegerRange(1, _size), _function));
    return this.FunctionDefinition(name, range, variableList, this.advancedConstructs.FunctionDefinitionBody(variableList, parametersToValue, defaultValue));
  }
  
  public Function add(final LogicProblem input, final Function function) {
    this.nameIfAnonymFunction(input, function);
    this.checkFunction(input, function);
    EList<Function> _functions = input.getFunctions();
    _functions.add(function);
    return function;
  }
  
  public Function add(final LogicProblem input, final FunctionDescription functionDescription) {
    return this.add(input, this.FunctionDeclaration(functionDescription));
  }
  
  protected void nameIfAnonymFunction(final LogicProblem problem, final Function functionDeclaration) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(functionDeclaration.getName());
    if (_isNullOrEmpty) {
      final Function1<Function, String> _function = (Function it) -> {
        return it.getName();
      };
      final Function1<Integer, String> _function_1 = (Integer i) -> {
        return ("function" + i);
      };
      functionDeclaration.setName(this.generateUniqueName(ListExtensions.<Function, String>map(problem.getFunctions(), _function), _function_1));
    }
  }
  
  protected void checkFunction(final LogicProblem problem, final Function function) {
    try {
      final Function1<Function, Boolean> _function = (Function x) -> {
        String _name = x.getName();
        String _name_1 = function.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      boolean _exists = IterableExtensions.<Function>exists(problem.getFunctions(), _function);
      if (_exists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Function with the following name is already defined: \"");
        String _name = function.getName();
        _builder.append(_name);
        _builder.append("\"!");
        throw new LogicProblemBuilderException(_builder.toString());
      }
      final Function1<ComplexTypeReference, Type> _function_1 = (ComplexTypeReference it) -> {
        return it.getReferred();
      };
      Iterable<Type> _map = IterableExtensions.<ComplexTypeReference, Type>map(Iterables.<ComplexTypeReference>filter(function.getParameters(), ComplexTypeReference.class), _function_1);
      for (final Type ref : _map) {
        boolean _contains = problem.getTypes().contains(ref);
        boolean _not = (!_contains);
        if (_not) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Type \"");
          String _name_1 = ref.getName();
          _builder_1.append(_name_1);
          _builder_1.append("\" is not availabe in the logic problem!");
          throw new LogicProblemBuilderException(_builder_1.toString());
        }
      }
      final TypeReference range = function.getRange();
      if ((range instanceof ComplexTypeReference)) {
        boolean _contains_1 = problem.getTypes().contains(((ComplexTypeReference)range).getReferred());
        boolean _not_1 = (!_contains_1);
        if (_not_1) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Type \"");
          String _name_2 = ((ComplexTypeReference)range).getReferred().getName();
          _builder_2.append(_name_2);
          _builder_2.append("\" is not availabe in the logic problem!");
          throw new LogicProblemBuilderException(_builder_2.toString());
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ConstantDeclaration ConstantDeclaration(final CharSequence name, final TypeDescriptor type) {
    ConstantDeclaration _ConstantDeclaration = this.ConstantDeclaration(type);
    final Procedure1<ConstantDeclaration> _function = (ConstantDeclaration it) -> {
      it.setName(this.canonize(name));
    };
    return ObjectExtensions.<ConstantDeclaration>operator_doubleArrow(_ConstantDeclaration, _function);
  }
  
  public ConstantDeclaration ConstantDeclaration(final TypeDescriptor type) {
    ConstantDeclaration _createConstantDeclaration = this.logicFactiory.createConstantDeclaration();
    final Procedure1<ConstantDeclaration> _function = (ConstantDeclaration it) -> {
      it.setType(this.toTypeReference(type));
    };
    return ObjectExtensions.<ConstantDeclaration>operator_doubleArrow(_createConstantDeclaration, _function);
  }
  
  public ConstantDefinition ConstantDefinition(final CharSequence name, final TypeDescriptor type, final TermDescription value) {
    ConstantDefinition _createConstantDefinition = this.logicFactiory.createConstantDefinition();
    final Procedure1<ConstantDefinition> _function = (ConstantDefinition it) -> {
      it.setName(this.canonize(name));
      it.setType(this.toTypeReference(type));
      it.setValue(this.toTerm(value));
    };
    return ObjectExtensions.<ConstantDefinition>operator_doubleArrow(_createConstantDefinition, _function);
  }
  
  public Constant add(final LogicProblem problem, final Constant constant) {
    this.nameIfAnonymConstant(problem, constant);
    this.checkConstant(problem, constant);
    EList<Constant> _constants = problem.getConstants();
    _constants.add(constant);
    return constant;
  }
  
  protected void nameIfAnonymConstant(final LogicProblem problem, final Constant constant) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(constant.getName());
    if (_isNullOrEmpty) {
      final Function1<Constant, String> _function = (Constant it) -> {
        return it.getName();
      };
      final Function1<Integer, String> _function_1 = (Integer i) -> {
        return ("constant" + i);
      };
      constant.setName(this.generateUniqueName(ListExtensions.<Constant, String>map(problem.getConstants(), _function), _function_1));
    }
  }
  
  protected void checkConstant(final LogicProblem problem, final Constant constant) {
    try {
      final Function1<Constant, Boolean> _function = (Constant x) -> {
        String _name = x.getName();
        String _name_1 = constant.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      boolean _exists = IterableExtensions.<Constant>exists(problem.getConstants(), _function);
      if (_exists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Constant with the following name is already defined: \"");
        String _name = constant.getName();
        _builder.append(_name);
        _builder.append("\"!");
        throw new LogicProblemBuilderException(_builder.toString());
      }
      if (((constant.getType() instanceof ComplexTypeReference) && (!problem.getTypes().contains(((ComplexTypeReference) constant.getType()).getReferred())))) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Type \"");
        TypeReference _type = constant.getType();
        String _name_1 = ((ComplexTypeReference) _type).getReferred().getName();
        _builder_1.append(_name_1);
        _builder_1.append("\" is not availabe in the logic problem!");
        throw new LogicProblemBuilderException(_builder_1.toString());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public RelationDeclaration RelationDeclaration(final CharSequence name, final TypeDescriptor... parameters) {
    return this.RelationDeclaration(name, ((Iterable<? extends TypeReference>) Conversions.doWrapArray(parameters)));
  }
  
  public RelationDeclaration RelationDeclaration(final CharSequence name, final Iterable<? extends TypeDescriptor> parameters) {
    RelationDeclaration _RelationDeclaration = this.RelationDeclaration(parameters);
    final Procedure1<RelationDeclaration> _function = (RelationDeclaration x) -> {
      x.setName(this.canonize(name));
    };
    return ObjectExtensions.<RelationDeclaration>operator_doubleArrow(_RelationDeclaration, _function);
  }
  
  public RelationDeclaration RelationDeclaration(final TypeDescriptor... parameters) {
    return this.RelationDeclaration(((Iterable<? extends TypeReference>) Conversions.doWrapArray(parameters)));
  }
  
  public RelationDeclaration RelationDeclaration(final Iterable<? extends TypeDescriptor> parameters) {
    final RelationDeclaration relation = this.logicFactiory.createRelationDeclaration();
    for (final TypeDescriptor parameter : parameters) {
      EList<TypeReference> _parameters = relation.getParameters();
      TypeReference _typeReference = this.toTypeReference(parameter);
      _parameters.add(_typeReference);
    }
    return relation;
  }
  
  public RelationDefinition RelationDefinition(final CharSequence name, final Function1<VariableContext, ? extends TermDescription> expression) {
    final VariableContext context = new VariableContext(this, this.logicFactiory);
    final TermDescription definition = expression.apply(context);
    return this.RelationDefinition(name, context.getVariables(), definition);
  }
  
  public RelationDefinition RelationDefinition(final CharSequence name, final Iterable<Variable> variables, final TermDescription definition) {
    RelationDefinition _createRelationDefinition = this.logicFactiory.createRelationDefinition();
    final Procedure1<RelationDefinition> _function = (RelationDefinition it) -> {
      it.setName(this.canonize(name));
      EList<TypeReference> _parameters = it.getParameters();
      final Function1<Variable, TypeReference> _function_1 = (Variable it_1) -> {
        return this.toTypeReference(it_1.getRange());
      };
      Iterable<TypeReference> _map = IterableExtensions.<Variable, TypeReference>map(variables, _function_1);
      Iterables.<TypeReference>addAll(_parameters, _map);
      EList<Variable> _variables = it.getVariables();
      Iterables.<Variable>addAll(_variables, variables);
      Term _term = null;
      if (definition!=null) {
        _term=this.toTerm(definition);
      }
      it.setValue(_term);
    };
    return ObjectExtensions.<RelationDefinition>operator_doubleArrow(_createRelationDefinition, _function);
  }
  
  public RelationDefinition RelationDefinition(final CharSequence name, final Iterable<? extends TypeDescriptor> parameters, final Iterable<? extends List<? extends TermDescription>> possibleValues) {
    RelationDefinition _createRelationDefinition = this.logicFactiory.createRelationDefinition();
    final Procedure1<RelationDefinition> _function = (RelationDefinition it) -> {
      it.setName(this.canonize(name));
    };
    final RelationDefinition res = ObjectExtensions.<RelationDefinition>operator_doubleArrow(_createRelationDefinition, _function);
    int _size = IterableExtensions.size(parameters);
    final ArrayList<Variable> variableMap = new ArrayList<Variable>(_size);
    int index = 0;
    for (final TypeDescriptor parameter : parameters) {
      {
        final int actualIndex = index;
        Variable _createVariable = this.logicFactiory.createVariable();
        final Procedure1<Variable> _function_1 = (Variable it) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("var ");
          _builder.append(actualIndex);
          it.setName(this.canonize(_builder));
          it.setRange(this.toTypeReference(parameter));
        };
        final Variable newVar = ObjectExtensions.<Variable>operator_doubleArrow(_createVariable, _function_1);
        variableMap.add(index, newVar);
        EList<Variable> _variables = res.getVariables();
        _variables.add(newVar);
        EList<TypeReference> _parameters = res.getParameters();
        TypeReference _range = newVar.getRange();
        _parameters.add(_range);
        int _index = index;
        index = (_index + 1);
      }
    }
    final Function1<List<? extends TermDescription>, And> _function_1 = (List<? extends TermDescription> possibleValue) -> {
      int _size_1 = IterableExtensions.size(parameters);
      final Function1<Integer, Equals> _function_2 = (Integer i) -> {
        Variable _get = variableMap.get((i).intValue());
        Term _term = this.toTerm(possibleValue.get((i).intValue()));
        return this.operator_equals(_get, _term);
      };
      return this.And(IterableExtensions.<Integer, Equals>map(new ExclusiveRange(0, _size_1, true), _function_2));
    };
    res.setValue(this.Or(IterableExtensions.map(possibleValues, _function_1)));
    return res;
  }
  
  public Relation add(final LogicProblem input, final Relation relation) {
    this.nameIfAnonymRelation(input, relation);
    this.checkRelation(input, relation);
    EList<Relation> _relations = input.getRelations();
    _relations.add(relation);
    return relation;
  }
  
  protected void nameIfAnonymRelation(final LogicProblem problem, final Relation relation) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(relation.getName());
    if (_isNullOrEmpty) {
      final Function1<Relation, String> _function = (Relation it) -> {
        return it.getName();
      };
      final Function1<Integer, String> _function_1 = (Integer i) -> {
        return ("relation" + i);
      };
      relation.setName(this.generateUniqueName(ListExtensions.<Relation, String>map(problem.getRelations(), _function), _function_1));
    }
  }
  
  protected Object checkRelation(final LogicProblem problem, final Relation relation) {
    try {
      Object _xblockexpression = null;
      {
        final Function1<Relation, Boolean> _function = (Relation x) -> {
          String _name = x.getName();
          String _name_1 = relation.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        boolean _exists = IterableExtensions.<Relation>exists(problem.getRelations(), _function);
        if (_exists) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Relation with the following name is already defined: \"");
          String _name = relation.getName();
          _builder.append(_name);
          _builder.append("\"!");
          throw new LogicProblemBuilderException(_builder.toString());
        }
        final Function1<ComplexTypeReference, Type> _function_1 = (ComplexTypeReference it) -> {
          return it.getReferred();
        };
        Iterable<Type> _map = IterableExtensions.<ComplexTypeReference, Type>map(Iterables.<ComplexTypeReference>filter(relation.getParameters(), ComplexTypeReference.class), _function_1);
        for (final Type ref : _map) {
          boolean _contains = problem.getTypes().contains(ref);
          boolean _not = (!_contains);
          if (_not) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Type \"");
            String _name_1 = ref.getName();
            _builder_1.append(_name_1);
            _builder_1.append("\" is not availabe in the logic problem!");
            throw new LogicProblemBuilderException(_builder_1.toString());
          }
        }
        Object _xifexpression = null;
        if ((relation instanceof RelationDefinition)) {
          _xifexpression = this.checkDefinition(relation);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Assertion Assertion(final TermDescription term) {
    Assertion _xblockexpression = null;
    {
      final Term result = this.toTerm(term);
      this.nameAnonymVariables(result, Collections.EMPTY_LIST);
      Assertion _createAssertion = this.logicFactiory.createAssertion();
      final Procedure1<Assertion> _function = (Assertion it) -> {
        it.setValue(result);
      };
      _xblockexpression = ObjectExtensions.<Assertion>operator_doubleArrow(_createAssertion, _function);
    }
    return _xblockexpression;
  }
  
  public Assertion Assertion(final CharSequence name, final TermDescription term) {
    Assertion _xblockexpression = null;
    {
      final Term result = this.toTerm(term);
      this.nameAnonymVariables(result, Collections.EMPTY_LIST);
      Assertion _createAssertion = this.logicFactiory.createAssertion();
      final Procedure1<Assertion> _function = (Assertion it) -> {
        it.setValue(result);
        it.setName(this.canonize(name));
      };
      _xblockexpression = ObjectExtensions.<Assertion>operator_doubleArrow(_createAssertion, _function);
    }
    return _xblockexpression;
  }
  
  public Assertion add(final LogicProblem problem, final Assertion assertion) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(assertion.getName());
    if (_isNullOrEmpty) {
      final Function1<Assertion, String> _function = (Assertion it) -> {
        return it.getName();
      };
      final Function1<Integer, String> _function_1 = (Integer it) -> {
        return ("assertion" + it);
      };
      final String name = this.generateUniqueName(ListExtensions.<Assertion, String>map(problem.getAssertions(), _function), _function_1);
      assertion.setName(name);
    }
    this.checkAssertion(assertion);
    EList<Assertion> _assertions = problem.getAssertions();
    _assertions.add(assertion);
    return assertion;
  }
  
  public Assertion add(final LogicProblem problem, final TermDescription term) {
    return this.add(problem, this.Assertion(term));
  }
  
  public void checkAssertion(final Assertion assertion) {
    try {
      Iterable<SymbolicValue> _iterable = IteratorExtensions.<SymbolicValue>toIterable(Iterators.<SymbolicValue>filter(assertion.eAllContents(), SymbolicValue.class));
      for (final SymbolicValue value : _iterable) {
        {
          SymbolicDeclaration referred = value.getSymbolicReference();
          if ((referred instanceof Variable)) {
            boolean _hasDeclaredVariable = this.hasDeclaredVariable(value, ((Variable)referred));
            boolean _not = (!_hasDeclaredVariable);
            if (_not) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Variable \"");
              String _name = ((Variable)referred).getName();
              _builder.append(_name);
              _builder.append("\" is not availabe in the logic problem!");
              throw new LogicProblemBuilderException(_builder.toString());
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object checkDefinition(final EObject definition) {
    return null;
  }
  
  public ContainmentHierarchy ContainmentHierarchy(final Iterable<? extends Type> typesInHierarchy, final Iterable<? extends Function> containmentFunctions, final Iterable<? extends Relation> containmentRelations, final Constant rootConstant) {
    ContainmentHierarchy _createContainmentHierarchy = this.problemFactory.createContainmentHierarchy();
    final Procedure1<ContainmentHierarchy> _function = (ContainmentHierarchy it) -> {
      EList<Type> _typesOrderedInHierarchy = it.getTypesOrderedInHierarchy();
      Iterables.<Type>addAll(_typesOrderedInHierarchy, typesInHierarchy);
      EList<Function> _containmentFunctions = it.getContainmentFunctions();
      Iterables.<Function>addAll(_containmentFunctions, containmentFunctions);
      EList<Relation> _containmentRelations = it.getContainmentRelations();
      Iterables.<Relation>addAll(_containmentRelations, containmentRelations);
      it.setRootConstant(rootConstant);
    };
    final ContainmentHierarchy result = ObjectExtensions.<ContainmentHierarchy>operator_doubleArrow(_createContainmentHierarchy, _function);
    return result;
  }
  
  public ContainmentHierarchy add(final LogicProblem problem, final ContainmentHierarchy hierarchy) {
    EList<ContainmentHierarchy> _containmentHierarchies = problem.getContainmentHierarchies();
    _containmentHierarchies.add(hierarchy);
    return hierarchy;
  }
  
  private boolean _hasDeclaredVariable(final QuantifiedExpression term, final Variable variable) {
    return (term.getQuantifiedVariables().contains(variable) || ((term.eContainer() instanceof Term) && this.hasDeclaredVariable(((Term) term.eContainer()), variable)));
  }
  
  private boolean _hasDeclaredVariable(final Term term, final Variable variable) {
    return ((term.eContainer() instanceof Term) && this.hasDeclaredVariable(((Term) term.eContainer()), variable));
  }
  
  private boolean _hasDeclaredVariable(final RelationDefinition relation, final Variable variable) {
    return relation.getVariables().contains(variable);
  }
  
  private boolean _hasDeclaredVariable(final Void term, final Variable variable) {
    return false;
  }
  
  protected void nameAnonymVariables(final EObject termSegment, final List<String> previousNames) {
    if ((termSegment instanceof QuantifiedExpression)) {
      final LinkedList<String> newNames = new LinkedList<String>(previousNames);
      EList<Variable> _quantifiedVariables = ((QuantifiedExpression)termSegment).getQuantifiedVariables();
      for (final Variable variable : _quantifiedVariables) {
        {
          String newName = null;
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(variable.getName());
          if (_isNullOrEmpty) {
            final Function1<Integer, String> _function = (Integer i) -> {
              String x = this.variableAnonymName(variable.getRange());
              String _x = x;
              String _string = i.toString();
              String _plus = ("var" + _string);
              x = (_x + _plus);
              return x;
            };
            newName = this.generateUniqueName(newNames, _function);
            variable.setName(newName);
          } else {
            newName = variable.getName();
          }
          newNames.add(newName);
        }
      }
      this.nameAnonymVariables(((QuantifiedExpression)termSegment).getExpression(), newNames);
    } else {
      EList<EObject> _eContents = termSegment.eContents();
      for (final EObject subTerm : _eContents) {
        this.nameAnonymVariables(subTerm, previousNames);
      }
    }
  }
  
  protected String _variableAnonymName(final BoolTypeReference ref) {
    return "bool";
  }
  
  protected String _variableAnonymName(final IntTypeReference ref) {
    return "int";
  }
  
  protected String _variableAnonymName(final RealTypeReference ref) {
    return "real";
  }
  
  protected String _variableAnonymName(final ComplexTypeReference ref) {
    return ref.getReferred().getName().toLowerCase();
  }
  
  protected ArrayList<EObject> allSubterms(final Term term) {
    final TreeIterator<EObject> content = term.eAllContents();
    int _size = IteratorExtensions.size(content);
    int _plus = (_size + 1);
    final ArrayList<EObject> result = new ArrayList<EObject>(_plus);
    result.add(term);
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(content);
    Iterables.<EObject>addAll(result, _iterable);
    return result;
  }
  
  public Term toTerm(final TermDescription term) {
    if ((term instanceof Term)) {
      return ((Term)term);
    } else {
      if ((term instanceof Variable)) {
        SymbolicValue _createSymbolicValue = this.logicFactiory.createSymbolicValue();
        final Procedure1<SymbolicValue> _function = (SymbolicValue it) -> {
          it.setSymbolicReference(((SymbolicDeclaration)term));
        };
        return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue, _function);
      } else {
        if ((term instanceof Constant)) {
          return this.call(((Constant)term));
        } else {
          if ((term instanceof DefinedElement)) {
            SymbolicValue _createSymbolicValue_1 = this.logicFactiory.createSymbolicValue();
            final Procedure1<SymbolicValue> _function_1 = (SymbolicValue it) -> {
              it.setSymbolicReference(((SymbolicDeclaration)term));
            };
            return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue_1, _function_1);
          } else {
            String _name = term.getClass().getName();
            String _plus = ("Can not create reference for symbolic declaration " + _name);
            throw new UnsupportedOperationException(_plus);
          }
        }
      }
    }
  }
  
  public Not operator_not(final TermDescription term) {
    return this.Not(term);
  }
  
  public Not Not(final TermDescription term) {
    Not _createNot = this.logicFactiory.createNot();
    final Procedure1<Not> _function = (Not it) -> {
      it.setOperand(this.toTerm(term));
    };
    return ObjectExtensions.<Not>operator_doubleArrow(_createNot, _function);
  }
  
  public And operator_and(final TermDescription a, final TermDescription b) {
    return this.And(a, b);
  }
  
  public And And(final TermDescription... terms) {
    return this.And(((Iterable<? extends TermDescription>) Conversions.doWrapArray(terms)));
  }
  
  public And And(final Iterable<? extends TermDescription> terms) {
    And _createAnd = this.logicFactiory.createAnd();
    final Procedure1<And> _function = (And it) -> {
      EList<Term> _operands = it.getOperands();
      final Function1<TermDescription, Term> _function_1 = (TermDescription it_1) -> {
        return this.toTerm(it_1);
      };
      Iterable<Term> _map = IterableExtensions.map(terms, _function_1);
      Iterables.<Term>addAll(_operands, _map);
    };
    return ObjectExtensions.<And>operator_doubleArrow(_createAnd, _function);
  }
  
  public Or operator_or(final TermDescription a, final TermDescription b) {
    return this.Or(a, b);
  }
  
  public Or Or(final TermDescription... terms) {
    return this.Or(((Iterable<? extends TermDescription>) Conversions.doWrapArray(terms)));
  }
  
  public Or Or(final Iterable<? extends TermDescription> terms) {
    Or _createOr = this.logicFactiory.createOr();
    final Procedure1<Or> _function = (Or it) -> {
      EList<Term> _operands = it.getOperands();
      final Function1<TermDescription, Term> _function_1 = (TermDescription it_1) -> {
        return this.toTerm(it_1);
      };
      Iterable<Term> _map = IterableExtensions.map(terms, _function_1);
      Iterables.<Term>addAll(_operands, _map);
    };
    return ObjectExtensions.<Or>operator_doubleArrow(_createOr, _function);
  }
  
  public Impl operator_doubleArrow(final TermDescription a, final TermDescription b) {
    return this.Impl(a, b);
  }
  
  public Impl Impl(final TermDescription a, final TermDescription b) {
    Impl _createImpl = this.logicFactiory.createImpl();
    final Procedure1<Impl> _function = (Impl it) -> {
      it.setLeftOperand(this.toTerm(a));
      it.setRightOperand(this.toTerm(b));
    };
    return ObjectExtensions.<Impl>operator_doubleArrow(_createImpl, _function);
  }
  
  public Iff operator_spaceship(final TermDescription a, final TermDescription b) {
    return this.Iff(a, b);
  }
  
  public Iff Iff(final TermDescription a, final TermDescription b) {
    Iff _createIff = this.logicFactiory.createIff();
    final Procedure1<Iff> _function = (Iff it) -> {
      it.setLeftOperand(this.toTerm(a));
      it.setRightOperand(this.toTerm(b));
    };
    return ObjectExtensions.<Iff>operator_doubleArrow(_createIff, _function);
  }
  
  public IfThenElse ITE(final TermDescription condition, final TermDescription ifTrue, final TermDescription ifFalse) {
    IfThenElse _createIfThenElse = this.logicFactiory.createIfThenElse();
    final Procedure1<IfThenElse> _function = (IfThenElse it) -> {
      it.setCondition(this.toTerm(condition));
      it.setIfTrue(this.toTerm(ifTrue));
      it.setIfFalse(this.toTerm(ifFalse));
    };
    return ObjectExtensions.<IfThenElse>operator_doubleArrow(_createIfThenElse, _function);
  }
  
  public MoreThan operator_greaterThan(final TermDescription left, final TermDescription right) {
    return this.MoreThan(left, right);
  }
  
  public MoreThan MoreThan(final TermDescription left, final TermDescription right) {
    MoreThan _createMoreThan = this.logicFactiory.createMoreThan();
    final Procedure1<MoreThan> _function = (MoreThan it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<MoreThan>operator_doubleArrow(_createMoreThan, _function);
  }
  
  public LessThan operator_lessThan(final TermDescription left, final TermDescription right) {
    return this.LessThan(left, right);
  }
  
  public LessThan LessThan(final TermDescription left, final TermDescription right) {
    LessThan _createLessThan = this.logicFactiory.createLessThan();
    final Procedure1<LessThan> _function = (LessThan it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<LessThan>operator_doubleArrow(_createLessThan, _function);
  }
  
  public LessOrEqualThan operator_lessEqualsThan(final TermDescription left, final TermDescription right) {
    return this.LessOrEqual(left, right);
  }
  
  public LessOrEqualThan LessOrEqual(final TermDescription left, final TermDescription right) {
    LessOrEqualThan _createLessOrEqualThan = this.logicFactiory.createLessOrEqualThan();
    final Procedure1<LessOrEqualThan> _function = (LessOrEqualThan it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<LessOrEqualThan>operator_doubleArrow(_createLessOrEqualThan, _function);
  }
  
  public MoreOrEqualThan operator_greaterEqualsThan(final TermDescription left, final TermDescription right) {
    return this.MoreOrEqual(left, right);
  }
  
  public MoreOrEqualThan MoreOrEqual(final TermDescription left, final TermDescription right) {
    MoreOrEqualThan _createMoreOrEqualThan = this.logicFactiory.createMoreOrEqualThan();
    final Procedure1<MoreOrEqualThan> _function = (MoreOrEqualThan it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<MoreOrEqualThan>operator_doubleArrow(_createMoreOrEqualThan, _function);
  }
  
  public Equals operator_equals(final TermDescription left, final TermDescription right) {
    return this.Equals(left, right);
  }
  
  public Equals Equals(final TermDescription left, final TermDescription right) {
    Equals _createEquals = this.logicFactiory.createEquals();
    final Procedure1<Equals> _function = (Equals it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<Equals>operator_doubleArrow(_createEquals, _function);
  }
  
  public Distinct operator_notEquals(final TermDescription left, final TermDescription right) {
    return this.Distinct(left, right);
  }
  
  public Distinct Distinct(final TermDescription... terms) {
    return this.Distinct(((Iterable<? extends TermDescription>) Conversions.doWrapArray(terms)));
  }
  
  public Distinct Distinct(final Iterable<? extends TermDescription> terms) {
    Distinct _createDistinct = this.logicFactiory.createDistinct();
    final Procedure1<Distinct> _function = (Distinct it) -> {
      EList<Term> _operands = it.getOperands();
      final Function1<TermDescription, Term> _function_1 = (TermDescription it_1) -> {
        return this.toTerm(it_1);
      };
      Iterable<Term> _map = IterableExtensions.map(terms, _function_1);
      Iterables.<Term>addAll(_operands, _map);
    };
    return ObjectExtensions.<Distinct>operator_doubleArrow(_createDistinct, _function);
  }
  
  public Plus operator_plus(final TermDescription left, final TermDescription right) {
    return this.Plus(left, right);
  }
  
  public Plus Plus(final TermDescription left, final TermDescription right) {
    Plus _createPlus = this.logicFactiory.createPlus();
    final Procedure1<Plus> _function = (Plus it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<Plus>operator_doubleArrow(_createPlus, _function);
  }
  
  public Minus operator_minus(final TermDescription left, final TermDescription right) {
    return this.Minus(left, right);
  }
  
  public Minus Minus(final TermDescription left, final TermDescription right) {
    Minus _createMinus = this.logicFactiory.createMinus();
    final Procedure1<Minus> _function = (Minus it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<Minus>operator_doubleArrow(_createMinus, _function);
  }
  
  public Multiply operator_multiply(final TermDescription left, final TermDescription right) {
    return this.Multiply(left, right);
  }
  
  public Multiply Multiply(final TermDescription left, final TermDescription right) {
    Multiply _createMultiply = this.logicFactiory.createMultiply();
    final Procedure1<Multiply> _function = (Multiply it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<Multiply>operator_doubleArrow(_createMultiply, _function);
  }
  
  public Divison operator_divide(final TermDescription left, final TermDescription right) {
    return this.Divide(left, right);
  }
  
  public Divison Divide(final TermDescription left, final TermDescription right) {
    Divison _createDivison = this.logicFactiory.createDivison();
    final Procedure1<Divison> _function = (Divison it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<Divison>operator_doubleArrow(_createDivison, _function);
  }
  
  public Mod operator_modulo(final TermDescription left, final TermDescription right) {
    return this.Modulo(left, right);
  }
  
  public Mod Modulo(final TermDescription left, final TermDescription right) {
    Mod _createMod = this.logicFactiory.createMod();
    final Procedure1<Mod> _function = (Mod it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<Mod>operator_doubleArrow(_createMod, _function);
  }
  
  public Pow Pow(final TermDescription left, final TermDescription right) {
    Pow _createPow = this.logicFactiory.createPow();
    final Procedure1<Pow> _function = (Pow it) -> {
      it.setLeftOperand(this.toTerm(left));
      it.setRightOperand(this.toTerm(right));
    };
    return ObjectExtensions.<Pow>operator_doubleArrow(_createPow, _function);
  }
  
  public BoolLiteral asTerm(final boolean value) {
    BoolLiteral _createBoolLiteral = this.logicFactiory.createBoolLiteral();
    final Procedure1<BoolLiteral> _function = (BoolLiteral x) -> {
      x.setValue(value);
    };
    return ObjectExtensions.<BoolLiteral>operator_doubleArrow(_createBoolLiteral, _function);
  }
  
  public IntLiteral asTerm(final int value) {
    IntLiteral _createIntLiteral = this.logicFactiory.createIntLiteral();
    final Procedure1<IntLiteral> _function = (IntLiteral x) -> {
      x.setValue(value);
    };
    return ObjectExtensions.<IntLiteral>operator_doubleArrow(_createIntLiteral, _function);
  }
  
  public RealLiteral asTerm(final double value) {
    return this.asTerm(BigDecimal.valueOf(value));
  }
  
  public RealLiteral asTerm(final float value) {
    return this.asTerm(BigDecimal.valueOf(value));
  }
  
  public RealLiteral asTerm(final BigDecimal value) {
    RealLiteral _createRealLiteral = this.logicFactiory.createRealLiteral();
    final Procedure1<RealLiteral> _function = (RealLiteral x) -> {
      x.setValue(value);
    };
    return ObjectExtensions.<RealLiteral>operator_doubleArrow(_createRealLiteral, _function);
  }
  
  public StringLiteral asTerm(final String value) {
    StringLiteral _createStringLiteral = this.logicFactiory.createStringLiteral();
    final Procedure1<StringLiteral> _function = (StringLiteral x) -> {
      x.setValue(value);
    };
    return ObjectExtensions.<StringLiteral>operator_doubleArrow(_createStringLiteral, _function);
  }
  
  public InstanceOf InstanceOf(final TermDescription term, final TypeDescriptor type) {
    InstanceOf _createInstanceOf = this.logicFactiory.createInstanceOf();
    final Procedure1<InstanceOf> _function = (InstanceOf it) -> {
      it.setValue(this.toTerm(term));
      it.setRange(this.toTypeReference(type));
    };
    return ObjectExtensions.<InstanceOf>operator_doubleArrow(_createInstanceOf, _function);
  }
  
  public TransitiveClosure transitiveClosure(final Relation relation, final TermDescription source, final TermDescription target) {
    TransitiveClosure _createTransitiveClosure = this.logicFactiory.createTransitiveClosure();
    final Procedure1<TransitiveClosure> _function = (TransitiveClosure it) -> {
      it.setRelation(relation);
      it.setLeftOperand(this.toTerm(source));
      it.setRightOperand(this.toTerm(target));
    };
    return ObjectExtensions.<TransitiveClosure>operator_doubleArrow(_createTransitiveClosure, _function);
  }
  
  public Forall Forall(final Function1<VariableContext, ? extends TermDescription> expression) {
    final VariableContext context = new VariableContext(this, this.logicFactiory);
    final TermDescription term = expression.apply(context);
    Forall _createForall = this.logicFactiory.createForall();
    final Procedure1<Forall> _function = (Forall x) -> {
      EList<Variable> _quantifiedVariables = x.getQuantifiedVariables();
      List<Variable> _variables = context.getVariables();
      Iterables.<Variable>addAll(_quantifiedVariables, _variables);
      x.setExpression(this.toTerm(term));
    };
    return ObjectExtensions.<Forall>operator_doubleArrow(_createForall, _function);
  }
  
  public Forall Forall(final TermDescription expression, final Variable... variables) {
    return this.Forall(((Iterable<? extends Variable>)Conversions.doWrapArray(variables)), expression);
  }
  
  public Forall Forall(final Iterable<? extends Variable> variables, final TermDescription expression) {
    final Forall forallExpression = this.logicFactiory.createForall();
    for (final Variable variable : variables) {
      EList<Variable> _quantifiedVariables = forallExpression.getQuantifiedVariables();
      _quantifiedVariables.add(variable);
    }
    forallExpression.setExpression(this.toTerm(expression));
    return forallExpression;
  }
  
  public Exists Exists(final Function1<VariableContext, ? extends TermDescription> expression) {
    final VariableContext context = new VariableContext(this, this.logicFactiory);
    final TermDescription term = expression.apply(context);
    Exists _createExists = this.logicFactiory.createExists();
    final Procedure1<Exists> _function = (Exists x) -> {
      EList<Variable> _quantifiedVariables = x.getQuantifiedVariables();
      List<Variable> _variables = context.getVariables();
      Iterables.<Variable>addAll(_quantifiedVariables, _variables);
      x.setExpression(this.toTerm(term));
    };
    return ObjectExtensions.<Exists>operator_doubleArrow(_createExists, _function);
  }
  
  public Exists Exists(final TermDescription expression, final Variable... variables) {
    return this.Exists(((Iterable<? extends Variable>)Conversions.doWrapArray(variables)), expression);
  }
  
  public Exists Exists(final Iterable<? extends Variable> variables, final TermDescription expression) {
    final Exists existsExpression = this.logicFactiory.createExists();
    for (final Variable variable : variables) {
      EList<Variable> _quantifiedVariables = existsExpression.getQuantifiedVariables();
      _quantifiedVariables.add(variable);
    }
    existsExpression.setExpression(this.toTerm(expression));
    return existsExpression;
  }
  
  private <T extends AggregateExpression> T configureAggregateExpression(final T expression, final Relation referred, final List<Variable> terms, final Variable target) {
    try {
      int _size = terms.size();
      int _size_1 = referred.getParameters().size();
      boolean _notEquals = (_size != _size_1);
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The function called has ");
        int _size_2 = referred.getParameters().size();
        _builder.append(_size_2);
        _builder.append(" parameters but it is called with ");
        int _size_3 = terms.size();
        _builder.append(_size_3);
        _builder.append("!");
        throw new LogicProblemBuilderException(_builder.toString());
      } else {
        expression.setRelation(referred);
        expression.setResultVariable(target);
        for (int i = 0; (i < referred.getParameters().size()); i++) {
          {
            final Variable targetRelation = terms.get(i);
            AggregatedParameterSubstitution _createAggregatedParameterSubstitution = this.logicFactiory.createAggregatedParameterSubstitution();
            final Procedure1<AggregatedParameterSubstitution> _function = (AggregatedParameterSubstitution it) -> {
              it.setVariable(targetRelation);
            };
            final AggregatedParameterSubstitution substitution = ObjectExtensions.<AggregatedParameterSubstitution>operator_doubleArrow(_createAggregatedParameterSubstitution, _function);
            EList<AggregatedParameterSubstitution> _parameterSubstitution = expression.getParameterSubstitution();
            _parameterSubstitution.add(substitution);
          }
        }
        return expression;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private <T extends ProjectedAggregateExpression> T configureProjectedAggregateExpression(final T expression, final Relation referred, final List<Variable> terms, final Variable target, final int projection) {
    try {
      if (((projection < 0) || (projection >= referred.getParameters().size()))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The function called has ");
        int _size = referred.getParameters().size();
        _builder.append(_size);
        _builder.append(" parameters but it is called with ");
        int _size_1 = terms.size();
        _builder.append(_size_1);
        _builder.append("!");
        throw new LogicProblemBuilderException(_builder.toString());
      } else {
        final T res = this.<T>configureAggregateExpression(expression, referred, terms, target);
        Variable _variable = res.getParameterSubstitution().get(projection).getVariable();
        boolean _tripleNotEquals = (_variable != null);
        if (_tripleNotEquals) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Projection over set variable!");
          throw new LogicProblemBuilderException(_builder_1.toString());
        }
        final TypeReference projectionType = referred.getParameters().get(projection);
        if ((!((projectionType instanceof IntTypeReference) || (projectionType instanceof RealTypeReference)))) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Projection over nunnumeric parameter!");
          throw new LogicProblemBuilderException(_builder_2.toString());
        }
        res.setProjectionIndex(projection);
        return res;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Count Count(final Relation referred, final List<Variable> terms, final Variable result) {
    return this.<Count>configureAggregateExpression(this.logicFactiory.createCount(), referred, terms, result);
  }
  
  public Sum Sum(final Relation referred, final List<Variable> terms, final int projection, final Variable result) {
    return this.<Sum>configureProjectedAggregateExpression(this.logicFactiory.createSum(), referred, terms, result, projection);
  }
  
  public Min Min(final Relation referred, final List<Variable> terms, final int projection, final Variable result) {
    return this.<Min>configureProjectedAggregateExpression(this.logicFactiory.createMin(), referred, terms, result, projection);
  }
  
  public Max Max(final Relation referred, final List<Variable> terms, final int projection, final Variable result) {
    return this.<Max>configureProjectedAggregateExpression(this.logicFactiory.createMax(), referred, terms, result, projection);
  }
  
  public SymbolicValue call(final Function function, final TermDescription... substitutions) {
    return this.call(function, ((Iterable<? extends TermDescription>) Conversions.doWrapArray(substitutions)));
  }
  
  public SymbolicValue call(final Function function, final Iterable<? extends TermDescription> substitutions) {
    final SymbolicValue functionReference = this.logicFactiory.createSymbolicValue();
    functionReference.setSymbolicReference(function);
    final List<TermDescription> l = new LinkedList<TermDescription>();
    Iterables.<TermDescription>addAll(l, substitutions);
    for (final TermDescription substitution : l) {
      EList<Term> _parameterSubstitutions = functionReference.getParameterSubstitutions();
      Term _term = this.toTerm(substitution);
      _parameterSubstitutions.add(_term);
    }
    this.checkFunctionCall(functionReference, function);
    return functionReference;
  }
  
  private void checkFunctionCall(final SymbolicValue value, final Function referredFunction) {
    try {
      int _size = value.getParameterSubstitutions().size();
      int _size_1 = referredFunction.getParameters().size();
      boolean _notEquals = (_size != _size_1);
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The function called has ");
        int _size_2 = referredFunction.getParameters().size();
        _builder.append(_size_2);
        _builder.append(" parameters but it is called with ");
        int _size_3 = value.getParameterSubstitutions().size();
        _builder.append(_size_3);
        _builder.append("!");
        throw new LogicProblemBuilderException(_builder.toString());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public SymbolicValue call(final Relation relation, final TermDescription... substitution) {
    return this.call(relation, ((Iterable<? extends TermDescription>) Conversions.doWrapArray(substitution)));
  }
  
  public SymbolicValue call(final Relation relation, final Iterable<? extends TermDescription> substitution) {
    try {
      final SymbolicValue relationReference = this.logicFactiory.createSymbolicValue();
      if ((relation == null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Call is referring to null!");
        throw new LogicProblemBuilderException(_builder.toString());
      }
      relationReference.setSymbolicReference(relation);
      for (final TermDescription value : substitution) {
        EList<Term> _parameterSubstitutions = relationReference.getParameterSubstitutions();
        Term _term = this.toTerm(value);
        _parameterSubstitutions.add(_term);
      }
      this.checkRelationCall(relationReference, relation);
      return relationReference;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void checkRelationCall(final SymbolicValue value, final Relation referredRelation) {
    try {
      if (((value == null) || (referredRelation == null))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Call is referring to null!");
        throw new LogicProblemBuilderException(_builder.toString());
      }
      int _size = value.getParameterSubstitutions().size();
      int _size_1 = referredRelation.getParameters().size();
      boolean _notEquals = (_size != _size_1);
      if (_notEquals) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The relation \"");
        String _name = referredRelation.getName();
        _builder_1.append(_name);
        _builder_1.append("\" called has ");
        int _size_2 = referredRelation.getParameters().size();
        _builder_1.append(_size_2);
        _builder_1.append(" parameters but it is called with ");
        int _size_3 = value.getParameterSubstitutions().size();
        _builder_1.append(_size_3);
        _builder_1.append("!");
        throw new LogicProblemBuilderException(_builder_1.toString());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public SymbolicValue call(final Constant constant) {
    final SymbolicValue constantReference = this.logicFactiory.createSymbolicValue();
    constantReference.setSymbolicReference(constant);
    return constantReference;
  }
  
  protected void nameIfAnonymType(final LogicProblem problem, final Type typeDefinition) {
    if (typeDefinition instanceof TypeDefinition) {
      _nameIfAnonymType(problem, (TypeDefinition)typeDefinition);
      return;
    } else if (typeDefinition != null) {
      _nameIfAnonymType(problem, typeDefinition);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(problem, typeDefinition).toString());
    }
  }
  
  private boolean hasDeclaredVariable(final TermDescription relation, final Variable variable) {
    if (relation instanceof RelationDefinition) {
      return _hasDeclaredVariable((RelationDefinition)relation, variable);
    } else if (relation instanceof QuantifiedExpression) {
      return _hasDeclaredVariable((QuantifiedExpression)relation, variable);
    } else if (relation instanceof Term) {
      return _hasDeclaredVariable((Term)relation, variable);
    } else if (relation == null) {
      return _hasDeclaredVariable((Void)null, variable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(relation, variable).toString());
    }
  }
  
  protected String variableAnonymName(final TypeReference ref) {
    if (ref instanceof BoolTypeReference) {
      return _variableAnonymName((BoolTypeReference)ref);
    } else if (ref instanceof IntTypeReference) {
      return _variableAnonymName((IntTypeReference)ref);
    } else if (ref instanceof RealTypeReference) {
      return _variableAnonymName((RealTypeReference)ref);
    } else if (ref instanceof ComplexTypeReference) {
      return _variableAnonymName((ComplexTypeReference)ref);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ref).toString());
    }
  }
}
