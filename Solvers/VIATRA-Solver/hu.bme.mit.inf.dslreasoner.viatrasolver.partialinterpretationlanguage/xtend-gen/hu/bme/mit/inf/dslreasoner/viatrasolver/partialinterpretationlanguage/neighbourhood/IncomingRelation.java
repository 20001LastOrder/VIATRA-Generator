package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class IncomingRelation<FROM extends Object> {
  private final FROM from;
  
  private final String type;
  
  public IncomingRelation(final FROM from, final String type) {
    super();
    this.from = from;
    this.type = type;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.from== null) ? 0 : this.from.hashCode());
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
    IncomingRelation<?> other = (IncomingRelation<?>) obj;
    if (this.from == null) {
      if (other.from != null)
        return false;
    } else if (!this.from.equals(other.from))
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
    b.add("from", this.from);
    b.add("type", this.type);
    return b.toString();
  }
  
  @Pure
  public FROM getFrom() {
    return this.from;
  }
  
  @Pure
  public String getType() {
    return this.type;
  }
}
