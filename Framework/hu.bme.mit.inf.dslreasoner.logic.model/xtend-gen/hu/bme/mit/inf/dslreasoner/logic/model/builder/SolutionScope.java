package hu.bme.mit.inf.dslreasoner.logic.model.builder;

/**
 * Defines the required number of solutions for the problem.
 * Constant <code>All</code> defines that all solution for the problem is requested.
 */
@SuppressWarnings("all")
public class SolutionScope {
  public static final int All = Integer.MAX_VALUE;
  
  public int numberOfRequiredSolutions = 1;
}
