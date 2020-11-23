package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class OutgoingRelation<TO extends Object> {
  private final TO to;
  
  private final String type;
  
  public OutgoingRelation(final TO to, final String type) {
    super();
    this.to = to;
    this.type = type;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.to== null) ? 0 : this.to.hashCode());
    return prime * result + ((this.type== null) ? 0 : this.type.hashCode());
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
    OutgoingRelation<?> other = (OutgoingRelation<?>) obj;
    if (this.to == null) {
      if (other.to != null)
        return false;
    } else if (!this.to.equals(other.to))
      return false;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("to", this.to);
    b.add("type", this.type);
    return b.toString();
  }
  
  @Pure
  public TO getTo() {
    return this.to;
  }
  
  @Pure
  public String getType() {
    return this.type;
  }
}
