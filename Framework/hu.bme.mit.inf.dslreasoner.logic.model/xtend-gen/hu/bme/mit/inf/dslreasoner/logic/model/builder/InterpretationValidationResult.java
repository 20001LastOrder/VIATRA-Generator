package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class InterpretationValidationResult {
  private final List<String> problems;
  
  private final List<Assertion> invalidAssertions;
  
  public boolean isValid() {
    return (this.problems.isEmpty() && this.invalidAssertions.isEmpty());
  }
  
  public InterpretationValidationResult(final List<String> problems, final List<Assertion> invalidAssertions) {
    super();
    this.problems = problems;
    this.invalidAssertions = invalidAssertions;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.problems== null) ? 0 : this.problems.hashCode());
    return prime * result + ((this.invalidAssertions== null) ? 0 : this.invalidAssertions.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    InterpretationValidationResult other = (InterpretationValidationResult) obj;
    if (this.problems == null) {
      if (other.problems != null)
        return false;
    } else if (!this.problems.equals(other.problems))
      return false;
    if (this.invalidAssertions == null) {
      if (other.invalidAssertions != null)
        return false;
    } else if (!this.invalidAssertions.equals(other.invalidAssertions))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("problems", this.problems);
    b.add("invalidAssertions", this.invalidAssertions);
    return b.toString();
  }
  
  @Pure
  public List<String> getProblems() {
    return this.problems;
  }
  
  @Pure
  public List<Assertion> getInvalidAssertions() {
    return this.invalidAssertions;
  }
}
