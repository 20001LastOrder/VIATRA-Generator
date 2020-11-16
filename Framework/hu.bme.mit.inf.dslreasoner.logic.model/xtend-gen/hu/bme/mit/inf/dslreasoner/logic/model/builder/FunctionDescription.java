package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeReference;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class FunctionDescription {
  private final Iterable<TypeReference> parameters;
  
  private final TypeReference range;
  
  public FunctionDescription(final Iterable<TypeReference> parameters, final TypeReference range) {
    super();
    this.parameters = parameters;
    this.range = range;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.parameters== null) ? 0 : this.parameters.hashCode());
    return prime * result + ((this.range== null) ? 0 : this.range.hashCode());
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
    FunctionDescription other = (FunctionDescription) obj;
    if (this.parameters == null) {
      if (other.parameters != null)
        return false;
    } else if (!this.parameters.equals(other.parameters))
      return false;
    if (this.range == null) {
      if (other.range != null)
        return false;
    } else if (!this.range.equals(other.range))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("parameters", this.parameters);
    b.add("range", this.range);
    return b.toString();
  }
  
  @Pure
  public Iterable<TypeReference> getParameters() {
    return this.parameters;
  }
  
  @Pure
  public TypeReference getRange() {
    return this.range;
  }
}
