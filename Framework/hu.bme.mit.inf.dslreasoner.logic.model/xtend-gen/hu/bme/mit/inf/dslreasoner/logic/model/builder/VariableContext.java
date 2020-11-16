package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguageFactory;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDescriptor;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Variable;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class VariableContext {
  @Extension
  private final LogiclanguageFactory language;
  
  @Extension
  private final LogicProblemBuilder logicProblemBuilder;
  
  public VariableContext(final LogicProblemBuilder logicProblemBuilder, final LogiclanguageFactory language) {
    this.logicProblemBuilder = logicProblemBuilder;
    this.language = language;
  }
  
  private List<Variable> variables = new LinkedList<Variable>();
  
  public List<Variable> getVariables() {
    return this.variables;
  }
  
  public Variable addVar(final TypeDescriptor type) {
    return this.addVar(null, type);
  }
  
  public Variable addVar(final CharSequence variableName, final TypeDescriptor type) {
    final Function1<Variable, Boolean> _function = (Variable it) -> {
      return Boolean.valueOf(it.getName().equals(variableName));
    };
    boolean _exists = IterableExtensions.<Variable>exists(this.variables, _function);
    if (_exists) {
      throw new IllegalArgumentException((("Variable with name " + variableName) + " is already defined."));
    }
    Variable _createVariable = this.language.createVariable();
    final Procedure1<Variable> _function_1 = (Variable it) -> {
      it.setName(this.logicProblemBuilder.canonize(variableName));
      it.setRange(this.logicProblemBuilder.toTypeReference(type));
    };
    final Variable variable = ObjectExtensions.<Variable>operator_doubleArrow(_createVariable, _function_1);
    this.variables.add(variable);
    return variable;
  }
}
