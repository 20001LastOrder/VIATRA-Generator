package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.DocumentationLevel;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.NullSolverProgressMonitor;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.SolverProgressMonitor;

@SuppressWarnings("all")
public abstract class SolverConfiguration {
  public static final int Unlimited = (-1);
  
  public static final String UndefinedPath = null;
  
  /**
   * The URI string to the independent solver application
   */
  public String solverPath = SolverConfiguration.UndefinedPath;
  
  /**
   * Max runtime limit in seconds.
   */
  public int runtimeLimit = SolverConfiguration.Unlimited;
  
  /**
   * Max memory limit in megabytes.
   */
  public int memoryLimit = SolverConfiguration.Unlimited;
  
  /**
   * Documentation level of the solver.
   */
  public DocumentationLevel documentationLevel = DocumentationLevel.NONE;
  
  /**
   * Progress monitor for the solver to
   * <li>(optionally) report progress via {@link progressMonitor.worked}</li>
   * <li>(optionally) inform about cancellation request via {@link progressMonitor.isCancelled}
   *     or via a listener registered by {@link progressMonitor.addCancelListener}</li>
   */
  public SolverProgressMonitor progressMonitor = new NullSolverProgressMonitor();
}
