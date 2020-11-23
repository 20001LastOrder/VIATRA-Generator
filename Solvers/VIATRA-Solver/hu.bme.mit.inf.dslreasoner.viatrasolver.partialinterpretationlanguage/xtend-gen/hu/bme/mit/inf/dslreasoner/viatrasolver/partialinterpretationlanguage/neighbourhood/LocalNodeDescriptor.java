package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import com.google.common.base.Objects;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public class LocalNodeDescriptor extends AbstractNodeDescriptor {
  private final Set<String> types;
  
  private final String id;
  
  public LocalNodeDescriptor(final String id, final Set<String> types) {
    super(LocalNodeDescriptor.calcualteDataHash(id, types));
    this.types = types;
    this.id = id;
  }
  
  private static int calcualteDataHash(final String id, final Set<String> types) {
    final int prime = 31;
    int result = 0;
    if ((id != null)) {
      result = id.hashCode();
    }
    if ((types != null)) {
      int _hashCode = types.hashCode();
      int _plus = ((prime * result) + _hashCode);
      result = _plus;
    }
    return result;
  }
  
  @Override
  public int hashCode() {
    return this.getDataHash();
  }
  
  @Override
  public boolean equals(final Object other) {
    return (Objects.equal(other.getClass(), LocalNodeDescriptor.class) && (((AbstractNodeDescriptor) other).hashCode() == this.hashCode()));
  }
  
  @Override
  protected StringConcatenationClient prettyPrint() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("(");
        int _dataHash = LocalNodeDescriptor.this.getDataHash();
        _builder.append(_dataHash);
        _builder.append(")[");
        {
          if ((LocalNodeDescriptor.this.id != null)) {
            _builder.append("id = \"");
            _builder.append(LocalNodeDescriptor.this.id);
            _builder.append("\"");
            {
              if (((LocalNodeDescriptor.this.types == null) || (!LocalNodeDescriptor.this.types.isEmpty()))) {
                _builder.append(", ");
              }
            }
          }
        }
        {
          if ((LocalNodeDescriptor.this.types == null)) {
            _builder.append("TYPES = null");
          } else {
            {
              boolean _hasElements = false;
              for(final String type : LocalNodeDescriptor.this.types) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                _builder.append(type);
              }
            }
          }
        }
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
  
  @Pure
  public Set<String> getTypes() {
    return this.types;
  }
  
  @Pure
  public String getId() {
    return this.id;
  }
}
