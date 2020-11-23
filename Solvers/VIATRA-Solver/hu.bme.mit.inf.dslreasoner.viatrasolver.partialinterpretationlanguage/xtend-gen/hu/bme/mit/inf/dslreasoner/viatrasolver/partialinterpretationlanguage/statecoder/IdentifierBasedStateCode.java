package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.RelationStatecoder;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class IdentifierBasedStateCode {
  private final int numberOfNewElement;
  
  private final SortedSet<RelationStatecoder> relationStatecoders;
  
  private static final Comparator<RelationStatecoder> comparator = new Comparator<RelationStatecoder>() {
    @Override
    public int compare(final RelationStatecoder o1, final RelationStatecoder o2) {
      return o1.getRelationName().compareTo(o2.getRelationName());
    }
  };
  
  public IdentifierBasedStateCode(final int numberOfNewElements) {
    this.numberOfNewElement = numberOfNewElements;
    TreeSet<RelationStatecoder> _treeSet = new TreeSet<RelationStatecoder>(IdentifierBasedStateCode.comparator);
    this.relationStatecoders = _treeSet;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.numberOfNewElement;
    return prime * result + ((this.relationStatecoders== null) ? 0 : this.relationStatecoders.hashCode());
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
    IdentifierBasedStateCode other = (IdentifierBasedStateCode) obj;
    if (other.numberOfNewElement != this.numberOfNewElement)
      return false;
    if (this.relationStatecoders == null) {
      if (other.relationStatecoders != null)
        return false;
    } else if (!this.relationStatecoders.equals(other.relationStatecoders))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("numberOfNewElement", this.numberOfNewElement);
    b.add("relationStatecoders", this.relationStatecoders);
    return b.toString();
  }
  
  @Pure
  public int getNumberOfNewElement() {
    return this.numberOfNewElement;
  }
  
  @Pure
  public SortedSet<RelationStatecoder> getRelationStatecoders() {
    return this.relationStatecoders;
  }
}
