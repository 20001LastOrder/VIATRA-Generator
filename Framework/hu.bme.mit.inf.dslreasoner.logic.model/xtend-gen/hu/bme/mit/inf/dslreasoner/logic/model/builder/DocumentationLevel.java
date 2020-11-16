package hu.bme.mit.inf.dslreasoner.logic.model.builder;

/**
 * Describes the amount of debug information required to write to the workspace.
 */
@SuppressWarnings("all")
public enum DocumentationLevel {
  /**
   * The solver writes only temporary files.
   */
  NONE,
  
  /**
   * The solver is requested to write important artifacts and documents that are constructed during the generation.
   * This option should not affect the performance of the solver seriously.
   */
  NORMAL,
  
  /**
   * The solver is requested create additional documents to aid troubleshooting.
   * The documents can constructed at the cost of performance.
   */
  FULL;
}
