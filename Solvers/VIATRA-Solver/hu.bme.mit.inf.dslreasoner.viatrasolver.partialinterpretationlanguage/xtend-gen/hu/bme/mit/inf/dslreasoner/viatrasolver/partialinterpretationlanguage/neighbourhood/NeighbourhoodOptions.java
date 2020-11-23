package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class NeighbourhoodOptions {
  public static final int FixPointRange = (-1);
  
  public static final int GraphWidthRange = (-2);
  
  public static final int FullParallels = Integer.MAX_VALUE;
  
  public static final int MaxNumbers = Integer.MAX_VALUE;
  
  public static final NeighbourhoodOptions DEFAULT = new NeighbourhoodOptions(NeighbourhoodOptions.FixPointRange, NeighbourhoodOptions.FullParallels, NeighbourhoodOptions.MaxNumbers, null, null);
  
  private final int range;
  
  private final int parallels;
  
  private final int maxNumber;
  
  private final Set<TypeDeclaration> relevantTypes;
  
  private final Set<RelationDeclaration> relevantRelations;
  
  public NeighbourhoodOptions(final int range, final int parallels, final int maxNumber, final Set<TypeDeclaration> relevantTypes, final Set<RelationDeclaration> relevantRelations) {
    super();
    this.range = range;
    this.parallels = parallels;
    this.maxNumber = maxNumber;
    this.relevantTypes = relevantTypes;
    this.relevantRelations = relevantRelations;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.range;
    result = prime * result + this.parallels;
    result = prime * result + this.maxNumber;
    result = prime * result + ((this.relevantTypes== null) ? 0 : this.relevantTypes.hashCode());
    return prime * result + ((this.relevantRelations== null) ? 0 : this.relevantRelations.hashCode());
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
    NeighbourhoodOptions other = (NeighbourhoodOptions) obj;
    if (other.range != this.range)
      return false;
    if (other.parallels != this.parallels)
      return false;
    if (other.maxNumber != this.maxNumber)
      return false;
    if (this.relevantTypes == null) {
      if (other.relevantTypes != null)
        return false;
    } else if (!this.relevantTypes.equals(other.relevantTypes))
      return false;
    if (this.relevantRelations == null) {
      if (other.relevantRelations != null)
        return false;
    } else if (!this.relevantRelations.equals(other.relevantRelations))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("range", this.range);
    b.add("parallels", this.parallels);
    b.add("maxNumber", this.maxNumber);
    b.add("relevantTypes", this.relevantTypes);
    b.add("relevantRelations", this.relevantRelations);
    return b.toString();
  }
  
  @Pure
  public int getRange() {
    return this.range;
  }
  
  @Pure
  public int getParallels() {
    return this.parallels;
  }
  
  @Pure
  public int getMaxNumber() {
    return this.maxNumber;
  }
  
  @Pure
  public Set<TypeDeclaration> getRelevantTypes() {
    return this.relevantTypes;
  }
  
  @Pure
  public Set<RelationDeclaration> getRelevantRelations() {
    return this.relevantRelations;
  }
}
