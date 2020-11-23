package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.PrimitiveValueTrace;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Problem2PartialInterpretationTrace {
  private final Map<TypeDeclaration, PartialComplexTypeInterpretation> type2Interpretation;
  
  private final PrimitiveValueTrace primitiveValues;
  
  private final Map<RelationDeclaration, PartialRelationInterpretation> relation2Interpretation;
  
  public Problem2PartialInterpretationTrace(final Map<TypeDeclaration, PartialComplexTypeInterpretation> type2Interpretation, final PrimitiveValueTrace primitiveValues, final Map<RelationDeclaration, PartialRelationInterpretation> relation2Interpretation) {
    super();
    this.type2Interpretation = type2Interpretation;
    this.primitiveValues = primitiveValues;
    this.relation2Interpretation = relation2Interpretation;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.type2Interpretation== null) ? 0 : this.type2Interpretation.hashCode());
    result = prime * result + ((this.primitiveValues== null) ? 0 : this.primitiveValues.hashCode());
    return prime * result + ((this.relation2Interpretation== null) ? 0 : this.relation2Interpretation.hashCode());
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
    Problem2PartialInterpretationTrace other = (Problem2PartialInterpretationTrace) obj;
    if (this.type2Interpretation == null) {
      if (other.type2Interpretation != null)
        return false;
    } else if (!this.type2Interpretation.equals(other.type2Interpretation))
      return false;
    if (this.primitiveValues == null) {
      if (other.primitiveValues != null)
        return false;
    } else if (!this.primitiveValues.equals(other.primitiveValues))
      return false;
    if (this.relation2Interpretation == null) {
      if (other.relation2Interpretation != null)
        return false;
    } else if (!this.relation2Interpretation.equals(other.relation2Interpretation))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("type2Interpretation", this.type2Interpretation);
    b.add("primitiveValues", this.primitiveValues);
    b.add("relation2Interpretation", this.relation2Interpretation);
    return b.toString();
  }
  
  @Pure
  public Map<TypeDeclaration, PartialComplexTypeInterpretation> getType2Interpretation() {
    return this.type2Interpretation;
  }
  
  @Pure
  public PrimitiveValueTrace getPrimitiveValues() {
    return this.primitiveValues;
  }
  
  @Pure
  public Map<RelationDeclaration, PartialRelationInterpretation> getRelation2Interpretation() {
    return this.relation2Interpretation;
  }
}
