package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class TracedOutput<OUTPUT extends Object, TRACE extends Object> {
  private final OUTPUT _output;
  
  private final TRACE _trace;
  
  public TracedOutput(final OUTPUT output, final TRACE trace) {
    super();
    this._output = output;
    this._trace = trace;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._output== null) ? 0 : this._output.hashCode());
    return prime * result + ((this._trace== null) ? 0 : this._trace.hashCode());
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
    TracedOutput<?, ?> other = (TracedOutput<?, ?>) obj;
    if (this._output == null) {
      if (other._output != null)
        return false;
    } else if (!this._output.equals(other._output))
      return false;
    if (this._trace == null) {
      if (other._trace != null)
        return false;
    } else if (!this._trace.equals(other._trace))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public OUTPUT getOutput() {
    return this._output;
  }
  
  @Pure
  public TRACE getTrace() {
    return this._trace;
  }
}
