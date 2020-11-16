package hu.bme.mit.inf.dslreasoner.logic.model.builder;

/**
 * Progress monitor class for a solver to
 * <li>(optionally) report progress via {@link worked}</li>
 * <li>(optionally) inform about cancellation request via {@link isCancelled}
 *     or via a listener registered by {@link addCancelListener}</li>
 */
@SuppressWarnings("all")
public abstract class SolverProgressMonitor {
  protected volatile boolean cancelled = false;
  
  protected double progress = 0.0;
  
  /**
   * Method to report progress, e.g. finishing translation or founding one of the model.
   * The sum of all {@link amount} should be 1.0, which is reached when all model is generated.
   * By default,
   * forward transformation should take 0.1 work unit (implemented in {@link#workedForwardTransformation}),
   * founding all solution 0.8 (implemented in {@link#workedModelFound})
   * and backward transformation 0.1 again (implemented in {@link#workedBackwardTransformation}).
   */
  public void worked(final double amount) {
    double _progress = this.progress;
    this.progress = (_progress + amount);
    this.processWorked(amount);
  }
  
  public void workedForwardTransformation() {
    this.worked(0.1);
  }
  
  public void workedModelFound(final int numberOfRequestedModels) {
    if ((numberOfRequestedModels > 0)) {
      this.worked((0.8 / numberOfRequestedModels));
    }
  }
  
  public void workedSearchFinished() {
    this.worked(((0.1 + 0.8) - this.progress));
  }
  
  public void workedBackwardTransformation(final int numberOfFoundModels) {
    this.worked((0.1 / numberOfFoundModels));
  }
  
  public void workedBackwardTransformationFinished() {
    this.worked((1.0 - this.progress));
  }
  
  protected abstract void processWorked(final double amount);
  
  /**
   * Requesting the solver to stop with the solutions already found.
   * It is not guaranteed however that the solver finishes.
   */
  public void cancel() {
    this.cancelled = true;
  }
  
  public boolean isCancelled() {
    return this.cancelled;
  }
}
