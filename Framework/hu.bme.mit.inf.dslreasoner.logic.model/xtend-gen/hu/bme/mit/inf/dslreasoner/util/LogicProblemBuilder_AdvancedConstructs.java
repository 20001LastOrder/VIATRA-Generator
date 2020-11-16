package hu.bme.mit.inf.dslreasoner.util;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.And;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Equals;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.IfThenElse;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Or;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Variable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class LogicProblemBuilder_AdvancedConstructs {
  @Extension
  private final LogicProblemBuilder builder;
  
  public LogicProblemBuilder_AdvancedConstructs(final LogicProblemBuilder builder) {
    this.builder = builder;
  }
  
  public Term FunctionDefinitionBody(final Iterable<Variable> variables, final Map<List<Term>, Term> parametersToValue, final Term other) {
    final List<Variable> variableList = IterableExtensions.<Variable>toList(variables);
    final List<Map.Entry<List<Term>, Term>> entryList = IterableExtensions.<Map.Entry<List<Term>, Term>>toList(parametersToValue.entrySet());
    if ((entryList.isEmpty() && (other == null))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No possible value is specified!");
      throw new IllegalArgumentException(_builder.toString());
    } else {
      if (((entryList.size() == 1) && (other == null))) {
        return IterableExtensions.<Map.Entry<List<Term>, Term>>head(entryList).getValue();
      } else {
        if ((entryList.isEmpty() && (!(other == null)))) {
          return other;
        } else {
          int iteNumber = 0;
          if ((other == null)) {
            int _size = entryList.size();
            int _minus = (_size - 1);
            iteNumber = _minus;
          } else {
            iteNumber = entryList.size();
          }
          final ArrayList<IfThenElse> ites = new ArrayList<IfThenElse>(iteNumber);
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, iteNumber, true);
          for (final Integer element : _doubleDotLessThan) {
            IfThenElse _ITE = this.builder.ITE(
              this.substitutionIsEqual(entryList.get((element).intValue()).getKey(), variableList), 
              entryList.get((element).intValue()).getValue(), 
              null);
            ites.add(_ITE);
          }
          int _size_1 = ites.size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(1, _size_1, true);
          for (final Integer optionIndex : _doubleDotLessThan_1) {
            {
              final IfThenElse prev = ites.get(((optionIndex).intValue() - 1));
              final IfThenElse next = ites.get((optionIndex).intValue());
              prev.setIfFalse(next);
            }
          }
          if ((other == null)) {
            IfThenElse _last = IterableExtensions.<IfThenElse>last(ites);
            _last.setIfFalse(IterableExtensions.<Map.Entry<List<Term>, Term>>last(entryList).getValue());
          } else {
            IfThenElse _last_1 = IterableExtensions.<IfThenElse>last(ites);
            _last_1.setIfFalse(other);
          }
          return IterableExtensions.<IfThenElse>head(ites);
        }
      }
    }
  }
  
  public Or RelationDefinitionBody(final Iterable<Variable> variables, final Collection<List<Term>> elements) {
    final List<Variable> variableList = IterableExtensions.<Variable>toList(variables);
    final Function1<List<Term>, And> _function = (List<Term> row) -> {
      return this.substitutionIsEqual(row, variableList);
    };
    return this.builder.Or(IterableExtensions.<List<Term>, And>map(elements, _function));
  }
  
  private And substitutionIsEqual(final List<Term> substitution, final List<Variable> variables) {
    int _size = variables.size();
    final ExclusiveRange parameterIndexes = new ExclusiveRange(0, _size, true);
    final Function1<Integer, Equals> _function = (Integer index) -> {
      Term _get = substitution.get((index).intValue());
      Variable _get_1 = variables.get((index).intValue());
      return this.builder.operator_equals(_get, _get_1);
    };
    return this.builder.And(IterableExtensions.<Integer, Equals>map(parameterIndexes, _function));
  }
}
