package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.SolverProgressMonitor;

@SuppressWarnings("all")
public class NullSolverProgressMonitor extends SolverProgressMonitor {
  @Override
  protected void processWorked(final double amount) {
  }
}
