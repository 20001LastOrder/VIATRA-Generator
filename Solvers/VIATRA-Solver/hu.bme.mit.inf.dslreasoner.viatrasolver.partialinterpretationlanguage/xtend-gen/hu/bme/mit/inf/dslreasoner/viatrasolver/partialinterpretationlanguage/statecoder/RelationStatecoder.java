package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class RelationStatecoder {
  private final String relationName;
  
  private final SortedSet<Pair<Integer, Integer>> links;
  
  private static final Comparator<Pair<Integer, Integer>> comparator = new Comparator<Pair<Integer, Integer>>() {
    @Override
    public int compare(final Pair<Integer, Integer> o1, final Pair<Integer, Integer> o2) {
      Integer _key = o1.getKey();
      Integer _key_1 = o2.getKey();
      boolean _greaterThan = (_key.compareTo(_key_1) > 0);
      if (_greaterThan) {
        return 1;
      } else {
        Integer _key_2 = o1.getKey();
        Integer _key_3 = o2.getKey();
        boolean _lessThan = (_key_2.compareTo(_key_3) < 0);
        if (_lessThan) {
          return (-1);
        } else {
          return Integer.compare((o1.getValue()).intValue(), (o2.getValue()).intValue());
        }
      }
    }
  };
  
  public RelationStatecoder(final String relationName) {
    this.relationName = relationName;
    TreeSet<Pair<Integer, Integer>> _treeSet = new TreeSet<Pair<Integer, Integer>>(RelationStatecoder.comparator);
    this.links = _treeSet;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.relationName== null) ? 0 : this.relationName.hashCode());
    return prime * result + ((this.links== null) ? 0 : this.links.hashCode());
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
    RelationStatecoder other = (RelationStatecoder) obj;
    if (this.relationName == null) {
      if (other.relationName != null)
        return false;
    } else if (!this.relationName.equals(other.relationName))
      return false;
    if (this.links == null) {
      if (other.links != null)
        return false;
    } else if (!this.links.equals(other.links))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("relationName", this.relationName);
    b.add("links", this.links);
    return b.toString();
  }
  
  @Pure
  public String getRelationName() {
    return this.relationName;
  }
  
  @Pure
  public SortedSet<Pair<Integer, Integer>> getLinks() {
    return this.links;
  }
}
