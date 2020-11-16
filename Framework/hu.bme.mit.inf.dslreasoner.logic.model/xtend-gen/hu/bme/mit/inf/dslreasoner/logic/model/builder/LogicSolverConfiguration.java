package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.SolutionScope;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.SolverConfiguration;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.TypeScopes;

@SuppressWarnings("all")
public abstract class LogicSolverConfiguration extends SolverConfiguration {
  public TypeScopes typeScopes = new TypeScopes();
  
  public SolutionScope solutionScope = new SolutionScope();
}
