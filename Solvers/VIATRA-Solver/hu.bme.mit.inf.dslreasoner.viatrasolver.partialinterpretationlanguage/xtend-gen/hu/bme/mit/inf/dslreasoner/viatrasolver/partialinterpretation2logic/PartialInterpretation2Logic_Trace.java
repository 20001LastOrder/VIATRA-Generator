package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretation2logic;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class PartialInterpretation2Logic_Trace {
  private final Map<DefinedElement, DefinedElement> new2Old = new HashMap<DefinedElement, DefinedElement>();
  
  private final Map<TypeDeclaration, TypeDefinition> definedPart = new HashMap<TypeDeclaration, TypeDefinition>();
  
  private final Map<TypeDeclaration, TypeDeclaration> undefinedPart = new HashMap<TypeDeclaration, TypeDeclaration>();
  
  private final Set<Type> originalTypes = new HashSet<Type>();
  
  private final Set<TypeDeclaration> splittedTypes = new HashSet<TypeDeclaration>();
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.new2Old== null) ? 0 : this.new2Old.hashCode());
    result = prime * result + ((this.definedPart== null) ? 0 : this.definedPart.hashCode());
    result = prime * result + ((this.undefinedPart== null) ? 0 : this.undefinedPart.hashCode());
    result = prime * result + ((this.originalTypes== null) ? 0 : this.originalTypes.hashCode());
    return prime * result + ((this.splittedTypes== null) ? 0 : this.splittedTypes.hashCode());
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
    PartialInterpretation2Logic_Trace other = (PartialInterpretation2Logic_Trace) obj;
    if (this.new2Old == null) {
      if (other.new2Old != null)
        return false;
    } else if (!this.new2Old.equals(other.new2Old))
      return false;
    if (this.definedPart == null) {
      if (other.definedPart != null)
        return false;
    } else if (!this.definedPart.equals(other.definedPart))
      return false;
    if (this.undefinedPart == null) {
      if (other.undefinedPart != null)
        return false;
    } else if (!this.undefinedPart.equals(other.undefinedPart))
      return false;
    if (this.originalTypes == null) {
      if (other.originalTypes != null)
        return false;
    } else if (!this.originalTypes.equals(other.originalTypes))
      return false;
    if (this.splittedTypes == null) {
      if (other.splittedTypes != null)
        return false;
    } else if (!this.splittedTypes.equals(other.splittedTypes))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("new2Old", this.new2Old);
    b.add("definedPart", this.definedPart);
    b.add("undefinedPart", this.undefinedPart);
    b.add("originalTypes", this.originalTypes);
    b.add("splittedTypes", this.splittedTypes);
    return b.toString();
  }
  
  @Pure
  public Map<DefinedElement, DefinedElement> getNew2Old() {
    return this.new2Old;
  }
  
  @Pure
  public Map<TypeDeclaration, TypeDefinition> getDefinedPart() {
    return this.definedPart;
  }
  
  @Pure
  public Map<TypeDeclaration, TypeDeclaration> getUndefinedPart() {
    return this.undefinedPart;
  }
  
  @Pure
  public Set<Type> getOriginalTypes() {
    return this.originalTypes;
  }
  
  @Pure
  public Set<TypeDeclaration> getSplittedTypes() {
    return this.splittedTypes;
  }
}
