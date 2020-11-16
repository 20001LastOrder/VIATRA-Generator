package hu.bme.mit.inf.dslreasoner.logic.model.builder;

@SuppressWarnings("all")
public class LogicReasonerException extends Exception {
  public LogicReasonerException(final String message, final Exception cause) {
    super(message, cause);
  }
  
  public LogicReasonerException(final Exception cause) {
    super("The reasoner has failed", cause);
  }
  
  public LogicReasonerException(final String message) {
    super(message);
  }
}
