package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class PairwiseNeighbourhoodRepresentation<BasicNodeRepresentation extends Object> {
  private final Map<?, Integer> modelRepresentation;
  
  private final Map<DefinedElement, BasicNodeRepresentation> basicNodeRepresentations;
  
  private final Map<DefinedElement, ? extends Map<DefinedElement, ? extends BasicNodeRepresentation>> pairwiseNodeRepresentations;
  
  public BasicNodeRepresentation getBasicRepresentation(final DefinedElement a) {
    return this.basicNodeRepresentations.get(a);
  }
  
  public BasicNodeRepresentation getPairwiseRepresentation(final DefinedElement a, final DefinedElement b) {
    return this.pairwiseNodeRepresentations.get(a).get(b);
  }
  
  public PairwiseNeighbourhoodRepresentation(final Map<?, Integer> modelRepresentation, final Map<DefinedElement, BasicNodeRepresentation> basicNodeRepresentations, final Map<DefinedElement, ? extends Map<DefinedElement, ? extends BasicNodeRepresentation>> pairwiseNodeRepresentations) {
    super();
    this.modelRepresentation = modelRepresentation;
    this.basicNodeRepresentations = basicNodeRepresentations;
    this.pairwiseNodeRepresentations = pairwiseNodeRepresentations;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.modelRepresentation== null) ? 0 : this.modelRepresentation.hashCode());
    result = prime * result + ((this.basicNodeRepresentations== null) ? 0 : this.basicNodeRepresentations.hashCode());
    return prime * result + ((this.pairwiseNodeRepresentations== null) ? 0 : this.pairwiseNodeRepresentations.hashCode());
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
    PairwiseNeighbourhoodRepresentation<?> other = (PairwiseNeighbourhoodRepresentation<?>) obj;
    if (this.modelRepresentation == null) {
      if (other.modelRepresentation != null)
        return false;
    } else if (!this.modelRepresentation.equals(other.modelRepresentation))
      return false;
    if (this.basicNodeRepresentations == null) {
      if (other.basicNodeRepresentations != null)
        return false;
    } else if (!this.basicNodeRepresentations.equals(other.basicNodeRepresentations))
      return false;
    if (this.pairwiseNodeRepresentations == null) {
      if (other.pairwiseNodeRepresentations != null)
        return false;
    } else if (!this.pairwiseNodeRepresentations.equals(other.pairwiseNodeRepresentations))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("modelRepresentation", this.modelRepresentation);
    b.add("basicNodeRepresentations", this.basicNodeRepresentations);
    b.add("pairwiseNodeRepresentations", this.pairwiseNodeRepresentations);
    return b.toString();
  }
  
  @Pure
  public Map<?, Integer> getModelRepresentation() {
    return this.modelRepresentation;
  }
  
  @Pure
  public Map<DefinedElement, BasicNodeRepresentation> getBasicNodeRepresentations() {
    return this.basicNodeRepresentations;
  }
  
  @Pure
  public Map<DefinedElement, ? extends Map<DefinedElement, ? extends BasicNodeRepresentation>> getPairwiseNodeRepresentations() {
    return this.pairwiseNodeRepresentations;
  }
}
