package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class NeighbourhoodWithTraces<ModelRep extends Object, NodeRep extends Object> {
  private final ModelRep modelRepresentation;
  
  private final Map<DefinedElement, ? extends NodeRep> nodeRepresentations;
  
  private final NeighbourhoodWithTraces<ModelRep, NodeRep> previousRepresentation;
  
  public NeighbourhoodWithTraces(final ModelRep modelRepresentation, final Map<DefinedElement, ? extends NodeRep> nodeRepresentations, final NeighbourhoodWithTraces<ModelRep, NodeRep> previousRepresentation) {
    super();
    this.modelRepresentation = modelRepresentation;
    this.nodeRepresentations = nodeRepresentations;
    this.previousRepresentation = previousRepresentation;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.modelRepresentation== null) ? 0 : this.modelRepresentation.hashCode());
    result = prime * result + ((this.nodeRepresentations== null) ? 0 : this.nodeRepresentations.hashCode());
    return prime * result + ((this.previousRepresentation== null) ? 0 : this.previousRepresentation.hashCode());
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
    NeighbourhoodWithTraces<?, ?> other = (NeighbourhoodWithTraces<?, ?>) obj;
    if (this.modelRepresentation == null) {
      if (other.modelRepresentation != null)
        return false;
    } else if (!this.modelRepresentation.equals(other.modelRepresentation))
      return false;
    if (this.nodeRepresentations == null) {
      if (other.nodeRepresentations != null)
        return false;
    } else if (!this.nodeRepresentations.equals(other.nodeRepresentations))
      return false;
    if (this.previousRepresentation == null) {
      if (other.previousRepresentation != null)
        return false;
    } else if (!this.previousRepresentation.equals(other.previousRepresentation))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("modelRepresentation", this.modelRepresentation);
    b.add("nodeRepresentations", this.nodeRepresentations);
    b.add("previousRepresentation", this.previousRepresentation);
    return b.toString();
  }
  
  @Pure
  public ModelRep getModelRepresentation() {
    return this.modelRepresentation;
  }
  
  @Pure
  public Map<DefinedElement, ? extends NodeRep> getNodeRepresentations() {
    return this.nodeRepresentations;
  }
  
  @Pure
  public NeighbourhoodWithTraces<ModelRep, NodeRep> getPreviousRepresentation() {
    return this.previousRepresentation;
  }
}
