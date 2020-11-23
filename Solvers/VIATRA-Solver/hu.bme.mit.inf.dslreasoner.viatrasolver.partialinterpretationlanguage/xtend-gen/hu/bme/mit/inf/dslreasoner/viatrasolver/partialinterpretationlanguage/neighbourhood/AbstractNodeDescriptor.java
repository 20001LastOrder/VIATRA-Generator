package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public abstract class AbstractNodeDescriptor {
  private final int dataHash;
  
  protected StringConcatenationClient prettyPrint() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("(");
        _builder.append(AbstractNodeDescriptor.this.dataHash);
        _builder.append(")[");
        String _simpleName = AbstractNodeDescriptor.this.getClass().getSimpleName();
        _builder.append(_simpleName);
        _builder.append("]");
      }
    };
    return _client;
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenationClient _prettyPrint = this.prettyPrint();
    _builder.append(_prettyPrint);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public AbstractNodeDescriptor(final int dataHash) {
    super();
    this.dataHash = dataHash;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + this.dataHash;
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
    AbstractNodeDescriptor other = (AbstractNodeDescriptor) obj;
    if (other.dataHash != this.dataHash)
      return false;
    return true;
  }
  
  @Pure
  public int getDataHash() {
    return this.dataHash;
  }
}
