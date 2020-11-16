package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.InterpretationValidationResult;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicModelInterpretation;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.And;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.BoolLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.BoolTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ComplexTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Constant;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ConstantDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ConstantDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Distinct;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Divison;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Equals;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Exists;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Forall;
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
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Minus;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Mod;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.MoreOrEqualThan;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.MoreThan;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Multiply;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Not;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Or;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Plus;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RealLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RealTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.StringLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.StringTypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.SymbolicValue;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeReference;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Variable;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class LogicStructureBuilder {
  @Extension
  protected final LogiclanguageFactory factory = LogiclanguageFactory.eINSTANCE;
  
  public Collection<DefinedElement> _getElements(final LogicModelInterpretation interpretation, final TypeDeclaration type) {
    return interpretation.getElements(type);
  }
  
  public Collection<DefinedElement> _getElements(final LogicModelInterpretation interpretation, final TypeDefinition type) {
    return type.getElements();
  }
  
  public Term evalAsTerm(final LogicModelInterpretation interpretation, final TermDescription term) {
    return this.toTerm(this.resolve(this.termDescriptiontoTerm(term), interpretation, CollectionLiterals.<Variable, Object>emptyMap()));
  }
  
  public boolean evalAsBool(final LogicModelInterpretation interpretation, final TermDescription term) {
    Object _resolve = this.resolve(this.termDescriptiontoTerm(term), interpretation, CollectionLiterals.<Variable, Object>emptyMap());
    return (((Boolean) _resolve)).booleanValue();
  }
  
  public int evalAsInt(final LogicModelInterpretation interpretation, final TermDescription term) {
    Object _resolve = this.resolve(this.termDescriptiontoTerm(term), interpretation, CollectionLiterals.<Variable, Object>emptyMap());
    return (((Integer) _resolve)).intValue();
  }
  
  public BigDecimal evalAsReal(final LogicModelInterpretation interpretation, final TermDescription term) {
    Object _resolve = this.resolve(this.termDescriptiontoTerm(term), interpretation, CollectionLiterals.<Variable, Object>emptyMap());
    return ((BigDecimal) _resolve);
  }
  
  /**
   * Evaluate the expression on a solution to an logic element.
   * @param interpretation The interpretation which the expression is evaluated on.
   * @param term An expression which results in a logic element.
   * @return The logic element value of the expression. Returns the element directly, not a symbolic reference!
   */
  public DefinedElement evalAsElement(final LogicModelInterpretation interpretation, final TermDescription term) {
    Object _resolve = this.resolve(this.toTerm(term), interpretation, CollectionLiterals.<Variable, Object>emptyMap());
    return ((DefinedElement) _resolve);
  }
  
  /**
   * Checks if the interpretation is a valid solution of the problem by checking the satisfactions of each assertion.
   * Returns the collection of failed assertions.
   * @param interpretation The checked interpretation.
   * @param problem The interpretation is checked on this problem.
   * @return The collection of failed assertions.
   */
  public InterpretationValidationResult validateInterpretationOnProblem(final LogicModelInterpretation interpretation, final LogicProblem problem) {
    final List<String> problems = new LinkedList<String>();
    final Function1<Type, List<DefinedElement>> _function = (Type it) -> {
      return interpretation.getElements(it);
    };
    final Map<Type, List<DefinedElement>> type2ElementsMap = IterableExtensions.<Type, List<DefinedElement>>toInvertedMap(problem.getTypes(), _function);
    Iterable<TypeDefinition> _filter = Iterables.<TypeDefinition>filter(problem.getTypes(), TypeDefinition.class);
    for (final TypeDefinition type : _filter) {
      {
        final List<DefinedElement> elements = type2ElementsMap.get(type);
        boolean _containsAll = type.getElements().containsAll(elements);
        boolean _not = (!_containsAll);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("The interpretation of ");
          String _name = type.getName();
          _builder.append(_name);
          _builder.append(" does not contains each elements of the problem");
          problems.add(_builder.toString());
        }
        boolean _containsAll_1 = elements.containsAll(type.getElements());
        boolean _not_1 = (!_containsAll_1);
        if (_not_1) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("The interpretation of ");
          String _name_1 = type.getName();
          _builder_1.append(_name_1);
          _builder_1.append(" does not contains additional elements not specified in the problem");
          problems.add(_builder_1.toString());
        }
      }
    }
    final Set<DefinedElement> allElements = IterableExtensions.<DefinedElement>toSet(Iterables.<DefinedElement>concat(type2ElementsMap.values()));
    for (final DefinedElement element : allElements) {
      boolean _checkElement = this.checkElement(problem, type2ElementsMap, element);
      boolean _not = (!_checkElement);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        String _name = element.getName();
        _builder.append(_name);
        _builder.append(" does not follows the type hierarchy");
        problems.add(_builder.toString());
      }
    }
    final List<Assertion> invalidAssertions = new LinkedList<Assertion>();
    EList<Assertion> _assertions = problem.getAssertions();
    for (final Assertion assertion : _assertions) {
      boolean _evalAsBool = this.evalAsBool(interpretation, assertion.getValue());
      boolean _not_1 = (!_evalAsBool);
      if (_not_1) {
        invalidAssertions.add(assertion);
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = assertion.getName();
        _builder_1.append(_name_1);
        _builder_1.append(" is violated!");
        problems.add(_builder_1.toString());
      }
    }
    return new InterpretationValidationResult(problems, invalidAssertions);
  }
  
  private boolean checkElement(final LogicProblem problem, final Map<Type, List<DefinedElement>> type2ElementsMap, final DefinedElement element) {
    final LinkedList<Type> compatibleDynamicTypes = new LinkedList<Type>();
    final Function1<Type, Boolean> _function = (Type it) -> {
      boolean _isIsAbstract = it.isIsAbstract();
      return Boolean.valueOf((!_isIsAbstract));
    };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(problem.getTypes(), _function);
    for (final Type possibleDynamicType : _filter) {
      {
        final Function1<Type, Iterable<Type>> _function_1 = (Type it) -> {
          return it.getSupertypes();
        };
        final List<Type> compatibleTypes = CollectionsUtil.<Type>transitiveClosureStar(possibleDynamicType, _function_1);
        final Function1<Type, Boolean> _function_2 = (Type it) -> {
          boolean _contains = compatibleTypes.contains(it);
          return Boolean.valueOf((!_contains));
        };
        final Iterable<Type> incompatibleTypes = IterableExtensions.<Type>filter(problem.getTypes(), _function_2);
        if ((IterableExtensions.<Type>forall(compatibleTypes, ((Function1<Type, Boolean>) (Type it) -> {
          return Boolean.valueOf(type2ElementsMap.get(it).contains(element));
        })) && IterableExtensions.<Type>forall(incompatibleTypes, ((Function1<Type, Boolean>) (Type it) -> {
          boolean _contains = type2ElementsMap.get(it).contains(element);
          return Boolean.valueOf((!_contains));
        })))) {
          compatibleDynamicTypes.add(possibleDynamicType);
        }
      }
    }
    int _size = compatibleDynamicTypes.size();
    return (_size == 1);
  }
  
  protected Term _toTerm(final Integer o) {
    IntLiteral _createIntLiteral = this.factory.createIntLiteral();
    final Procedure1<IntLiteral> _function = (IntLiteral it) -> {
      it.setValue((o).intValue());
    };
    return ObjectExtensions.<IntLiteral>operator_doubleArrow(_createIntLiteral, _function);
  }
  
  protected Term _toTerm(final BigDecimal o) {
    RealLiteral _createRealLiteral = this.factory.createRealLiteral();
    final Procedure1<RealLiteral> _function = (RealLiteral it) -> {
      it.setValue(o);
    };
    return ObjectExtensions.<RealLiteral>operator_doubleArrow(_createRealLiteral, _function);
  }
  
  protected Term _toTerm(final Boolean o) {
    BoolLiteral _createBoolLiteral = this.factory.createBoolLiteral();
    final Procedure1<BoolLiteral> _function = (BoolLiteral it) -> {
      it.setValue((o).booleanValue());
    };
    return ObjectExtensions.<BoolLiteral>operator_doubleArrow(_createBoolLiteral, _function);
  }
  
  protected Term _toTerm(final SymbolicDeclaration o) {
    SymbolicValue _createSymbolicValue = this.factory.createSymbolicValue();
    final Procedure1<SymbolicValue> _function = (SymbolicValue it) -> {
      it.setSymbolicReference(o);
    };
    return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue, _function);
  }
  
  public Term termDescriptiontoTerm(final TermDescription term) {
    if ((term instanceof Term)) {
      return ((Term)term);
    } else {
      if ((term instanceof Variable)) {
        SymbolicValue _createSymbolicValue = this.factory.createSymbolicValue();
        final Procedure1<SymbolicValue> _function = (SymbolicValue it) -> {
          it.setSymbolicReference(((SymbolicDeclaration)term));
        };
        return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue, _function);
      } else {
        if ((term instanceof Constant)) {
          SymbolicValue _createSymbolicValue_1 = this.factory.createSymbolicValue();
          final Procedure1<SymbolicValue> _function_1 = (SymbolicValue it) -> {
            it.setSymbolicReference(((SymbolicDeclaration)term));
          };
          return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue_1, _function_1);
        } else {
          if ((term instanceof DefinedElement)) {
            SymbolicValue _createSymbolicValue_2 = this.factory.createSymbolicValue();
            final Procedure1<SymbolicValue> _function_2 = (SymbolicValue it) -> {
              it.setSymbolicReference(((SymbolicDeclaration)term));
            };
            return ObjectExtensions.<SymbolicValue>operator_doubleArrow(_createSymbolicValue_2, _function_2);
          } else {
            String _name = term.getClass().getName();
            String _plus = ("Can not create reference for symbolic declaration " + _name);
            throw new UnsupportedOperationException(_plus);
          }
        }
      }
    }
  }
  
  /**
   * Returns if the operation with the numbers in the parameter requires the use of <code>BigDecimal</code>.
   */
  private boolean isBigDecimalRequired(final Object... numbers) {
    final Function1<Object, Boolean> _function = (Object it) -> {
      return Boolean.valueOf(((it instanceof BigDecimal) || (it instanceof RealLiteral)));
    };
    return IterableExtensions.<Object>exists(((Iterable<Object>)Conversions.doWrapArray(numbers)), _function);
  }
  
  private BigDecimal _asBigDecimal(final IntLiteral i) {
    return this.asBigDecimal(Integer.valueOf(i.getValue()));
  }
  
  private BigDecimal _asBigDecimal(final RealLiteral i) {
    return this.asBigDecimal(i.getValue());
  }
  
  private BigDecimal _asBigDecimal(final Integer i) {
    return BigDecimal.valueOf((i).intValue());
  }
  
  private BigDecimal _asBigDecimal(final BigDecimal i) {
    return i;
  }
  
  private Integer _asInteger(final Integer i) {
    return i;
  }
  
  private Integer _asInteger(final BigDecimal i) {
    return Integer.valueOf(i.intValue());
  }
  
  private Integer _asInteger(final IntLiteral i) {
    return this.asInteger(Integer.valueOf(i.getValue()));
  }
  
  protected Object _resolve(final IntLiteral literal, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    int _value = literal.getValue();
    return ((Integer) Integer.valueOf(_value));
  }
  
  protected Object _resolve(final BoolLiteral literal, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    return Boolean.valueOf(literal.isValue());
  }
  
  protected Object _resolve(final RealLiteral literal, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    BigDecimal _value = literal.getValue();
    return ((BigDecimal) _value);
  }
  
  protected Object _resolve(final StringLiteral literal, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    return literal.getValue();
  }
  
  protected Object _resolve(final Not not, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(not.getOperand(), interpretation, variableBinding);
    return Boolean.valueOf((!(((Boolean) _resolve)).booleanValue()));
  }
  
  protected Object _resolve(final And and, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final Function1<Term, Boolean> _function = (Term it) -> {
      Object _resolve = this.resolve(it, interpretation, variableBinding);
      return ((Boolean) _resolve);
    };
    boolean _forall = IterableExtensions.<Term>forall(and.getOperands(), _function);
    return ((Boolean) Boolean.valueOf(_forall));
  }
  
  protected Object _resolve(final Or or, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final Function1<Term, Boolean> _function = (Term it) -> {
      Object _resolve = this.resolve(it, interpretation, variableBinding);
      return ((Boolean) _resolve);
    };
    return Boolean.valueOf(IterableExtensions.<Term>exists(or.getOperands(), _function));
  }
  
  protected Object _resolve(final Impl impl, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(impl.getLeftOperand(), interpretation, variableBinding);
    final Boolean left = ((Boolean) _resolve);
    Object _resolve_1 = this.resolve(impl.getRightOperand(), interpretation, variableBinding);
    final Boolean right = ((Boolean) _resolve_1);
    return Boolean.valueOf(((!(left).booleanValue()) || (right).booleanValue()));
  }
  
  protected Object _resolve(final Iff iff, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(iff.getLeftOperand(), interpretation, variableBinding);
    Object _resolve_1 = this.resolve(iff.getRightOperand(), interpretation, variableBinding);
    return Boolean.valueOf(Objects.equal(((Boolean) _resolve), ((Boolean) _resolve_1)));
  }
  
  protected Object _resolve(final IfThenElse ite, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(ite.getCondition(), interpretation, variableBinding);
    final Boolean condition = ((Boolean) _resolve);
    if ((condition).booleanValue()) {
      return this.resolve(ite.getIfTrue(), interpretation, variableBinding);
    } else {
      return this.resolve(ite.getIfFalse(), interpretation, variableBinding);
    }
  }
  
  protected Object _resolve(final MoreThan moreThan, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(moreThan.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(moreThan.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      int _compareTo = this.asBigDecimal(left).compareTo(this.asBigDecimal(right));
      return Boolean.valueOf((_compareTo > 0));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Boolean.valueOf((_asInteger.compareTo(_asInteger_1) > 0));
    }
  }
  
  protected Object _resolve(final LessThan lessThan, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(lessThan.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(lessThan.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      int _compareTo = this.asBigDecimal(left).compareTo(this.asBigDecimal(right));
      return Boolean.valueOf((_compareTo < 0));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Boolean.valueOf((_asInteger.compareTo(_asInteger_1) < 0));
    }
  }
  
  protected Object _resolve(final MoreOrEqualThan moreThan, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(moreThan.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(moreThan.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      int _compareTo = this.asBigDecimal(left).compareTo(this.asBigDecimal(right));
      return Boolean.valueOf((_compareTo >= 0));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Boolean.valueOf((_asInteger.compareTo(_asInteger_1) >= 0));
    }
  }
  
  protected Object _resolve(final LessOrEqualThan lessThan, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(lessThan.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(lessThan.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      int _compareTo = this.asBigDecimal(left).compareTo(this.asBigDecimal(right));
      return Boolean.valueOf((_compareTo <= 0));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Boolean.valueOf((_asInteger.compareTo(_asInteger_1) <= 0));
    }
  }
  
  protected Object _resolve(final Equals equals, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final Object left = this.resolve(equals.getLeftOperand(), interpretation, variableBinding);
    final Object right = this.resolve(equals.getRightOperand(), interpretation, variableBinding);
    return Boolean.valueOf(this.compare(left, right));
  }
  
  protected Object _resolve(final Distinct distinct, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final Function1<Term, Object> _function = (Term it) -> {
      return this.resolve(it, interpretation, variableBinding);
    };
    final List<Object> elements = ListExtensions.<Term, Object>map(distinct.getOperands(), _function);
    int _size = elements.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return Boolean.valueOf(true);
    } else {
      int _size_1 = elements.size();
      final Function1<Integer, Boolean> _function_1 = (Integer i) -> {
        final Function1<Integer, Boolean> _function_2 = (Integer j) -> {
          boolean _compare = this.compare(elements.get((i).intValue()), elements.get((j).intValue()));
          return Boolean.valueOf((!_compare));
        };
        return Boolean.valueOf(IterableExtensions.<Integer>forall(new ExclusiveRange(0, (i).intValue(), true), _function_2));
      };
      final boolean res = IterableExtensions.<Integer>forall(new ExclusiveRange(0, _size_1, true), _function_1);
      return Boolean.valueOf(res);
    }
  }
  
  protected Object _resolve(final Plus plus, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(plus.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(plus.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      return this.asBigDecimal(left).add(this.asBigDecimal(right));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Integer.valueOf(((_asInteger).intValue() + (_asInteger_1).intValue()));
    }
  }
  
  protected Object _resolve(final Minus minus, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(minus.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(minus.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      return this.asBigDecimal(left).subtract(this.asBigDecimal(right));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Integer.valueOf(((_asInteger).intValue() - (_asInteger_1).intValue()));
    }
  }
  
  protected Object _resolve(final Multiply multiply, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final Object left = this.resolve(multiply.getLeftOperand(), interpretation, variableBinding);
    final Object right = this.resolve(multiply.getRightOperand(), interpretation, variableBinding);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      return this.asBigDecimal(left).multiply(this.asBigDecimal(right));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Integer.valueOf(((_asInteger).intValue() * (_asInteger_1).intValue()));
    }
  }
  
  protected Object _resolve(final Divison divide, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(divide.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(divide.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      return this.asBigDecimal(left).divide(this.asBigDecimal(right));
    }
    Integer _asInteger = this.asInteger(left);
    Integer _asInteger_1 = this.asInteger(right);
    return Integer.valueOf(((_asInteger).intValue() / (_asInteger_1).intValue()));
  }
  
  protected Object _resolve(final Mod modulo, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    Object _resolve = this.resolve(modulo.getLeftOperand(), interpretation, variableBinding);
    final Number left = ((Number) _resolve);
    Object _resolve_1 = this.resolve(modulo.getRightOperand(), interpretation, variableBinding);
    final Number right = ((Number) _resolve_1);
    boolean _isBigDecimalRequired = this.isBigDecimalRequired(left, right);
    if (_isBigDecimalRequired) {
      return this.asBigDecimal(left).remainder(this.asBigDecimal(right));
    } else {
      Integer _asInteger = this.asInteger(left);
      Integer _asInteger_1 = this.asInteger(right);
      return Integer.valueOf(((_asInteger).intValue() % (_asInteger_1).intValue()));
    }
  }
  
  protected Object _resolve(final InstanceOf instanceOf, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final TypeReference typeReference = instanceOf.getRange();
    if ((typeReference instanceof ComplexTypeReference)) {
      final Collection<DefinedElement> elements = this.getElements(interpretation, ((ComplexTypeReference)typeReference).getReferred());
      final Object element = this.resolve(instanceOf.getValue(), interpretation, variableBinding);
      if ((element instanceof DefinedElement)) {
        return Boolean.valueOf(elements.contains(element));
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("InstanceOf with ");
        String _simpleName = element.getClass().getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" object");
        throw new AssertionError(_builder);
      }
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("InstanceOf with ");
      String _simpleName_1 = typeReference.getClass().getSimpleName();
      _builder_1.append(_simpleName_1);
      _builder_1.append(" reference");
      throw new AssertionError(_builder_1);
    }
  }
  
  protected Object _resolve(final Exists exists, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    return Boolean.valueOf(this.executeExists(exists.getExpression(), interpretation, variableBinding, exists.getQuantifiedVariables()));
  }
  
  protected Object _resolve(final Forall forall, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    return Boolean.valueOf(this.executeForall(forall.getExpression(), interpretation, variableBinding, forall.getQuantifiedVariables()));
  }
  
  protected Object _resolve(final SymbolicValue symbolicValue, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final SymbolicDeclaration referenced = symbolicValue.getSymbolicReference();
    return this.resolveSymbolicValue(referenced, interpretation, symbolicValue.getParameterSubstitutions(), variableBinding);
  }
  
  protected Object _resolveSymbolicValue(final DefinedElement element, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    return element;
  }
  
  protected Object _resolveSymbolicValue(final Variable variable, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    return CollectionsUtil.<Variable, Object>lookup(variable, variableBinding);
  }
  
  protected Object _resolveSymbolicValue(final FunctionDeclaration declaration, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    Object _xblockexpression = null;
    {
      final FunctionDefinition internalDefinition = this.hasDefined(declaration);
      Object _xifexpression = null;
      if ((internalDefinition == null)) {
        _xifexpression = interpretation.getInterpretation(declaration, ((Object[])Conversions.unwrapArray(this.createBinding2(parameterSubstitution, interpretation, variableBinding), Object.class)));
      } else {
        _xifexpression = this.resolveSymbolicValue(internalDefinition, interpretation, parameterSubstitution, variableBinding);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Object _resolveSymbolicValue(final FunctionDefinition definition, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    return this.resolve(definition.getValue(), interpretation, this.createBinding(interpretation, variableBinding, definition.getVariable(), parameterSubstitution));
  }
  
  protected Object _resolveSymbolicValue(final ConstantDeclaration declaration, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    final ConstantDefinition internalDefinition = this.hasDefined(declaration);
    if ((internalDefinition == null)) {
      return interpretation.getInterpretation(declaration);
    } else {
      return this.resolveSymbolicValue(internalDefinition, interpretation, parameterSubstitution, variableBinding);
    }
  }
  
  protected Object _resolveSymbolicValue(final ConstantDefinition definition, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    return this.resolve(definition.getValue(), interpretation, CollectionLiterals.<Variable, Object>emptyMap());
  }
  
  protected Object _resolveSymbolicValue(final RelationDeclaration declaration, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    Object _xblockexpression = null;
    {
      final RelationDefinition internalDefinition = this.hasDefined(declaration);
      Object _xifexpression = null;
      if ((internalDefinition == null)) {
        _xifexpression = Boolean.valueOf(interpretation.getInterpretation(declaration, ((Object[])Conversions.unwrapArray(this.createBinding2(parameterSubstitution, interpretation, variableBinding), Object.class))));
      } else {
        _xifexpression = this.resolveSymbolicValue(internalDefinition, interpretation, parameterSubstitution, variableBinding);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Object _resolveSymbolicValue(final RelationDefinition definition, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    return this.resolve(definition.getValue(), interpretation, this.createBinding(interpretation, variableBinding, definition.getVariables(), parameterSubstitution));
  }
  
  private RelationDefinition hasDefined(final RelationDeclaration declaration) {
    final EObject container = declaration.eContainer();
    if ((container instanceof LogicProblem)) {
      final Function1<RelationDefinition, Boolean> _function = (RelationDefinition it) -> {
        RelationDeclaration _defines = it.getDefines();
        return Boolean.valueOf((_defines == declaration));
      };
      final Iterable<RelationDefinition> internalDefinitions = IterableExtensions.<RelationDefinition>filter(Iterables.<RelationDefinition>filter(((LogicProblem)container).getRelations(), RelationDefinition.class), _function);
      boolean _isEmpty = IterableExtensions.isEmpty(internalDefinitions);
      boolean _not = (!_isEmpty);
      if (_not) {
        return IterableExtensions.<RelationDefinition>head(internalDefinitions);
      }
    }
    return null;
  }
  
  private FunctionDefinition hasDefined(final FunctionDeclaration declaration) {
    final EObject container = declaration.eContainer();
    if ((container instanceof LogicProblem)) {
      final Function1<FunctionDefinition, Boolean> _function = (FunctionDefinition it) -> {
        FunctionDeclaration _defines = it.getDefines();
        return Boolean.valueOf((_defines == declaration));
      };
      final Iterable<FunctionDefinition> internalDefinitions = IterableExtensions.<FunctionDefinition>filter(Iterables.<FunctionDefinition>filter(((LogicProblem)container).getRelations(), FunctionDefinition.class), _function);
      boolean _isEmpty = IterableExtensions.isEmpty(internalDefinitions);
      boolean _not = (!_isEmpty);
      if (_not) {
        return IterableExtensions.<FunctionDefinition>head(internalDefinitions);
      }
    }
    return null;
  }
  
  private ConstantDefinition hasDefined(final ConstantDeclaration declaration) {
    final EObject container = declaration.eContainer();
    if ((container instanceof LogicProblem)) {
      final Function1<ConstantDefinition, Boolean> _function = (ConstantDefinition it) -> {
        ConstantDeclaration _defines = it.getDefines();
        return Boolean.valueOf((_defines == declaration));
      };
      final Iterable<ConstantDefinition> internalDefinitions = IterableExtensions.<ConstantDefinition>filter(Iterables.<ConstantDefinition>filter(((LogicProblem)container).getRelations(), ConstantDefinition.class), _function);
      boolean _isEmpty = IterableExtensions.isEmpty(internalDefinitions);
      boolean _not = (!_isEmpty);
      if (_not) {
        return IterableExtensions.<ConstantDefinition>head(internalDefinitions);
      }
    }
    return null;
  }
  
  private HashMap<Variable, Object> createBinding(final LogicModelInterpretation interpretation, final Map<Variable, Object> previousVariableBinding, final List<Variable> definitionVariables, final List<? extends Term> parameterSubstitution) {
    final HashMap<Variable, Object> binding = new HashMap<Variable, Object>(previousVariableBinding);
    int _size = definitionVariables.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer place : _doubleDotLessThan) {
      binding.put(
        definitionVariables.get((place).intValue()), 
        this.resolve(parameterSubstitution.get((place).intValue()), interpretation, previousVariableBinding));
    }
    return binding;
  }
  
  private List<Object> createBinding2(final List<? extends Term> parameterSubstitution, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    final Function1<Term, Object> _function = (Term it) -> {
      return this.resolve(it, interpretation, variableBinding);
    };
    return ListExtensions.map(parameterSubstitution, _function);
  }
  
  private boolean compare(final Object left, final Object right) {
    if (((left instanceof Number) && (right instanceof Number))) {
      boolean _isBigDecimalRequired = this.isBigDecimalRequired(((Number) left), ((Number) right));
      if (_isBigDecimalRequired) {
        int _compareTo = this.asBigDecimal(((Number) left)).compareTo(this.asBigDecimal(((Number) right)));
        return (_compareTo == 0);
      } else {
        Integer _asInteger = this.asInteger(((Number) left));
        Integer _asInteger_1 = this.asInteger(((Number) right));
        return Objects.equal(_asInteger, _asInteger_1);
      }
    } else {
      return left.equals(right);
    }
  }
  
  private Collection<?> _allObjects(final LogicModelInterpretation interpretation, final ComplexTypeReference type) {
    return interpretation.getElements(type.getReferred());
  }
  
  private Collection<?> _allObjects(final LogicModelInterpretation interpretation, final BoolTypeReference type) {
    return Collections.<Boolean>unmodifiableList(CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true), Boolean.valueOf(false)));
  }
  
  private Collection<?> _allObjects(final LogicModelInterpretation interpretation, final IntTypeReference type) {
    return interpretation.getAllIntegersInStructure();
  }
  
  private Collection<?> _allObjects(final LogicModelInterpretation interpretation, final RealTypeReference type) {
    return interpretation.getAllRealsInStructure();
  }
  
  private Collection<?> _allObjects(final LogicModelInterpretation interpretation, final StringTypeReference type) {
    return interpretation.getAllStringsInStructure();
  }
  
  private Collection<?> _allObjects(final LogicModelInterpretation interpretation, final TypeReference type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Unknown type :");
    String _simpleName = type.getClass().getSimpleName();
    _builder.append(_simpleName);
    _builder.append("!");
    throw new UnsupportedOperationException(_builder.toString());
  }
  
  private boolean executeExists(final Term expression, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding, final List<Variable> variablesToBind) {
    boolean _isEmpty = variablesToBind.isEmpty();
    if (_isEmpty) {
      Object _resolve = this.resolve(expression, interpretation, variableBinding);
      final Boolean res = ((Boolean) _resolve);
      return (res).booleanValue();
    } else {
      final Variable unfoldedVariable = IterableExtensions.<Variable>head(variablesToBind);
      final Collection<?> possibleValues = this.allObjects(interpretation, unfoldedVariable.getRange());
      final Function1<Object, Boolean> _function = (Object newBinding) -> {
        HashMap<Variable, Object> _hashMap = new HashMap<Variable, Object>(variableBinding);
        final Procedure1<HashMap<Variable, Object>> _function_1 = (HashMap<Variable, Object> it) -> {
          it.put(unfoldedVariable, newBinding);
        };
        HashMap<Variable, Object> _doubleArrow = ObjectExtensions.<HashMap<Variable, Object>>operator_doubleArrow(_hashMap, _function_1);
        return Boolean.valueOf(this.executeExists(expression, interpretation, _doubleArrow, 
          variablesToBind.subList(1, variablesToBind.size())));
      };
      return IterableExtensions.exists(possibleValues, _function);
    }
  }
  
  private boolean executeForall(final Term expression, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding, final List<Variable> variablesToBind) {
    boolean _isEmpty = variablesToBind.isEmpty();
    if (_isEmpty) {
      Object _resolve = this.resolve(expression, interpretation, variableBinding);
      return (((Boolean) _resolve)).booleanValue();
    } else {
      final Variable unfoldedVariable = IterableExtensions.<Variable>head(variablesToBind);
      final Collection<?> possibleValues = this.allObjects(interpretation, unfoldedVariable.getRange());
      final Function1<Object, Boolean> _function = (Object newBinding) -> {
        HashMap<Variable, Object> _hashMap = new HashMap<Variable, Object>(variableBinding);
        final Procedure1<HashMap<Variable, Object>> _function_1 = (HashMap<Variable, Object> it) -> {
          it.put(unfoldedVariable, newBinding);
        };
        HashMap<Variable, Object> _doubleArrow = ObjectExtensions.<HashMap<Variable, Object>>operator_doubleArrow(_hashMap, _function_1);
        return Boolean.valueOf(this.executeForall(expression, interpretation, _doubleArrow, 
          variablesToBind.subList(1, variablesToBind.size())));
      };
      return IterableExtensions.forall(possibleValues, _function);
    }
  }
  
  public Collection<DefinedElement> getElements(final LogicModelInterpretation interpretation, final Type type) {
    if (type instanceof TypeDeclaration) {
      return _getElements(interpretation, (TypeDeclaration)type);
    } else if (type instanceof TypeDefinition) {
      return _getElements(interpretation, (TypeDefinition)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(interpretation, type).toString());
    }
  }
  
  protected Term toTerm(final Object o) {
    if (o instanceof SymbolicDeclaration) {
      return _toTerm((SymbolicDeclaration)o);
    } else if (o instanceof Integer) {
      return _toTerm((Integer)o);
    } else if (o instanceof BigDecimal) {
      return _toTerm((BigDecimal)o);
    } else if (o instanceof Boolean) {
      return _toTerm((Boolean)o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
  
  private BigDecimal asBigDecimal(final Object i) {
    if (i instanceof IntLiteral) {
      return _asBigDecimal((IntLiteral)i);
    } else if (i instanceof RealLiteral) {
      return _asBigDecimal((RealLiteral)i);
    } else if (i instanceof Integer) {
      return _asBigDecimal((Integer)i);
    } else if (i instanceof BigDecimal) {
      return _asBigDecimal((BigDecimal)i);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(i).toString());
    }
  }
  
  private Integer asInteger(final Object i) {
    if (i instanceof IntLiteral) {
      return _asInteger((IntLiteral)i);
    } else if (i instanceof Integer) {
      return _asInteger((Integer)i);
    } else if (i instanceof BigDecimal) {
      return _asInteger((BigDecimal)i);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(i).toString());
    }
  }
  
  protected Object resolve(final Term and, final LogicModelInterpretation interpretation, final Map<Variable, Object> variableBinding) {
    if (and instanceof And) {
      return _resolve((And)and, interpretation, variableBinding);
    } else if (and instanceof BoolLiteral) {
      return _resolve((BoolLiteral)and, interpretation, variableBinding);
    } else if (and instanceof Distinct) {
      return _resolve((Distinct)and, interpretation, variableBinding);
    } else if (and instanceof Divison) {
      return _resolve((Divison)and, interpretation, variableBinding);
    } else if (and instanceof Equals) {
      return _resolve((Equals)and, interpretation, variableBinding);
    } else if (and instanceof Exists) {
      return _resolve((Exists)and, interpretation, variableBinding);
    } else if (and instanceof Forall) {
      return _resolve((Forall)and, interpretation, variableBinding);
    } else if (and instanceof Iff) {
      return _resolve((Iff)and, interpretation, variableBinding);
    } else if (and instanceof Impl) {
      return _resolve((Impl)and, interpretation, variableBinding);
    } else if (and instanceof IntLiteral) {
      return _resolve((IntLiteral)and, interpretation, variableBinding);
    } else if (and instanceof LessOrEqualThan) {
      return _resolve((LessOrEqualThan)and, interpretation, variableBinding);
    } else if (and instanceof LessThan) {
      return _resolve((LessThan)and, interpretation, variableBinding);
    } else if (and instanceof Minus) {
      return _resolve((Minus)and, interpretation, variableBinding);
    } else if (and instanceof Mod) {
      return _resolve((Mod)and, interpretation, variableBinding);
    } else if (and instanceof MoreOrEqualThan) {
      return _resolve((MoreOrEqualThan)and, interpretation, variableBinding);
    } else if (and instanceof MoreThan) {
      return _resolve((MoreThan)and, interpretation, variableBinding);
    } else if (and instanceof Multiply) {
      return _resolve((Multiply)and, interpretation, variableBinding);
    } else if (and instanceof Not) {
      return _resolve((Not)and, interpretation, variableBinding);
    } else if (and instanceof Or) {
      return _resolve((Or)and, interpretation, variableBinding);
    } else if (and instanceof Plus) {
      return _resolve((Plus)and, interpretation, variableBinding);
    } else if (and instanceof RealLiteral) {
      return _resolve((RealLiteral)and, interpretation, variableBinding);
    } else if (and instanceof StringLiteral) {
      return _resolve((StringLiteral)and, interpretation, variableBinding);
    } else if (and instanceof IfThenElse) {
      return _resolve((IfThenElse)and, interpretation, variableBinding);
    } else if (and instanceof InstanceOf) {
      return _resolve((InstanceOf)and, interpretation, variableBinding);
    } else if (and instanceof SymbolicValue) {
      return _resolve((SymbolicValue)and, interpretation, variableBinding);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(and, interpretation, variableBinding).toString());
    }
  }
  
  protected Object resolveSymbolicValue(final SymbolicDeclaration declaration, final LogicModelInterpretation interpretation, final List<? extends Term> parameterSubstitution, final Map<Variable, Object> variableBinding) {
    if (declaration instanceof ConstantDeclaration) {
      return _resolveSymbolicValue((ConstantDeclaration)declaration, interpretation, parameterSubstitution, variableBinding);
    } else if (declaration instanceof ConstantDefinition) {
      return _resolveSymbolicValue((ConstantDefinition)declaration, interpretation, parameterSubstitution, variableBinding);
    } else if (declaration instanceof FunctionDeclaration) {
      return _resolveSymbolicValue((FunctionDeclaration)declaration, interpretation, parameterSubstitution, variableBinding);
    } else if (declaration instanceof FunctionDefinition) {
      return _resolveSymbolicValue((FunctionDefinition)declaration, interpretation, parameterSubstitution, variableBinding);
    } else if (declaration instanceof RelationDeclaration) {
      return _resolveSymbolicValue((RelationDeclaration)declaration, interpretation, parameterSubstitution, variableBinding);
    } else if (declaration instanceof RelationDefinition) {
      return _resolveSymbolicValue((RelationDefinition)declaration, interpretation, parameterSubstitution, variableBinding);
    } else if (declaration instanceof DefinedElement) {
      return _resolveSymbolicValue((DefinedElement)declaration, interpretation, parameterSubstitution, variableBinding);
    } else if (declaration instanceof Variable) {
      return _resolveSymbolicValue((Variable)declaration, interpretation, parameterSubstitution, variableBinding);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(declaration, interpretation, parameterSubstitution, variableBinding).toString());
    }
  }
  
  private Collection<?> allObjects(final LogicModelInterpretation interpretation, final TypeReference type) {
    if (type instanceof BoolTypeReference) {
      return _allObjects(interpretation, (BoolTypeReference)type);
    } else if (type instanceof IntTypeReference) {
      return _allObjects(interpretation, (IntTypeReference)type);
    } else if (type instanceof RealTypeReference) {
      return _allObjects(interpretation, (RealTypeReference)type);
    } else if (type instanceof StringTypeReference) {
      return _allObjects(interpretation, (StringTypeReference)type);
    } else if (type instanceof ComplexTypeReference) {
      return _allObjects(interpretation, (ComplexTypeReference)type);
    } else if (type != null) {
      return _allObjects(interpretation, type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(interpretation, type).toString());
    }
  }
}
