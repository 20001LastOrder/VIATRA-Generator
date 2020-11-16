package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.FunctionDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Constant;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Function;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Relation;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;

@SuppressWarnings("all")
public class TracedLogicProblem {
  private final LogicProblemBuilder builder = new LogicProblemBuilder();
  
  private final LogicProblem problem = this.builder.createProblem();
  
  public LogicProblem getProblem() {
    return this.problem;
  }
  
  public Type add(final TypeDeclaration type) {
    return this.builder.add(this.problem, type);
  }
  
  public Type add(final TypeDefinition type) {
    return this.builder.add(this.problem, type);
  }
  
  public Function add(final Function function) {
    return this.builder.add(this.problem, function);
  }
  
  public Function add(final FunctionDescription functionDescription) {
    return this.builder.add(this.problem, functionDescription);
  }
  
  public Relation add(final Relation relation) {
    return this.builder.add(this.problem, relation);
  }
  
  public Constant add(final Constant constant) {
    return this.builder.add(this.problem, constant);
  }
  
  public Assertion add(final Assertion assertion) {
    return this.builder.add(this.problem, assertion);
  }
  
  public Assertion add(final TermDescription termDescription) {
    return this.builder.add(this.problem, termDescription);
  }
}
