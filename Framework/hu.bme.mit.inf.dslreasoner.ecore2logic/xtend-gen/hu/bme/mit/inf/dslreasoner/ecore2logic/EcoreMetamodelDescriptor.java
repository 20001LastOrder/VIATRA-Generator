package hu.bme.mit.inf.dslreasoner.ecore2logic;

import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class EcoreMetamodelDescriptor {
  private final List<EClass> classes;
  
  private final Set<EClass> concretised;
  
  private final boolean isEObjectConcretised;
  
  private final List<EEnum> enums;
  
  private final List<EEnumLiteral> literals;
  
  private final List<EReference> references;
  
  private final List<EAttribute> attributes;
  
  public boolean isConcretised(final EClass clazz) {
    return this.concretised.contains(clazz);
  }
  
  public EcoreMetamodelDescriptor(final List<EClass> classes, final Set<EClass> concretised, final boolean isEObjectConcretised, final List<EEnum> enums, final List<EEnumLiteral> literals, final List<EReference> references, final List<EAttribute> attributes) {
    super();
    this.classes = classes;
    this.concretised = concretised;
    this.isEObjectConcretised = isEObjectConcretised;
    this.enums = enums;
    this.literals = literals;
    this.references = references;
    this.attributes = attributes;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.classes== null) ? 0 : this.classes.hashCode());
    result = prime * result + ((this.concretised== null) ? 0 : this.concretised.hashCode());
    result = prime * result + (this.isEObjectConcretised ? 1231 : 1237);
    result = prime * result + ((this.enums== null) ? 0 : this.enums.hashCode());
    result = prime * result + ((this.literals== null) ? 0 : this.literals.hashCode());
    result = prime * result + ((this.references== null) ? 0 : this.references.hashCode());
    return prime * result + ((this.attributes== null) ? 0 : this.attributes.hashCode());
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
    EcoreMetamodelDescriptor other = (EcoreMetamodelDescriptor) obj;
    if (this.classes == null) {
      if (other.classes != null)
        return false;
    } else if (!this.classes.equals(other.classes))
      return false;
    if (this.concretised == null) {
      if (other.concretised != null)
        return false;
    } else if (!this.concretised.equals(other.concretised))
      return false;
    if (other.isEObjectConcretised != this.isEObjectConcretised)
      return false;
    if (this.enums == null) {
      if (other.enums != null)
        return false;
    } else if (!this.enums.equals(other.enums))
      return false;
    if (this.literals == null) {
      if (other.literals != null)
        return false;
    } else if (!this.literals.equals(other.literals))
      return false;
    if (this.references == null) {
      if (other.references != null)
        return false;
    } else if (!this.references.equals(other.references))
      return false;
    if (this.attributes == null) {
      if (other.attributes != null)
        return false;
    } else if (!this.attributes.equals(other.attributes))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("classes", this.classes);
    b.add("concretised", this.concretised);
    b.add("isEObjectConcretised", this.isEObjectConcretised);
    b.add("enums", this.enums);
    b.add("literals", this.literals);
    b.add("references", this.references);
    b.add("attributes", this.attributes);
    return b.toString();
  }
  
  @Pure
  public List<EClass> getClasses() {
    return this.classes;
  }
  
  @Pure
  public Set<EClass> getConcretised() {
    return this.concretised;
  }
  
  @Pure
  public boolean isEObjectConcretised() {
    return this.isEObjectConcretised;
  }
  
  @Pure
  public List<EEnum> getEnums() {
    return this.enums;
  }
  
  @Pure
  public List<EEnumLiteral> getLiterals() {
    return this.literals;
  }
  
  @Pure
  public List<EReference> getReferences() {
    return this.references;
  }
  
  @Pure
  public List<EAttribute> getAttributes() {
    return this.attributes;
  }
}
