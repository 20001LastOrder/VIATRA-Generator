package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import com.google.common.base.Objects;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.IncomingRelation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelation;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public class FurtherNodeDescriptor<NodeRep extends Object> extends AbstractNodeDescriptor {
  private final NodeRep previousRepresentation;
  
  private final Map<IncomingRelation<NodeRep>, Integer> incomingEdges;
  
  private final Map<OutgoingRelation<NodeRep>, Integer> outgoingEdges;
  
  public FurtherNodeDescriptor(final NodeRep previousRepresentation, final Map<IncomingRelation<NodeRep>, Integer> incomingEdges, final Map<OutgoingRelation<NodeRep>, Integer> outgoingEdges) {
    super(FurtherNodeDescriptor.<NodeRep>calculateDataHash(previousRepresentation, incomingEdges, outgoingEdges));
    this.previousRepresentation = previousRepresentation;
    this.incomingEdges = incomingEdges;
    this.outgoingEdges = outgoingEdges;
  }
  
  private static <NodeRep extends Object> int calculateDataHash(final NodeRep previousRepresentation, final Map<IncomingRelation<NodeRep>, Integer> incomingEdges, final Map<OutgoingRelation<NodeRep>, Integer> outgoingEdges) {
    final int prime = 31;
    int result = previousRepresentation.hashCode();
    if ((incomingEdges != null)) {
      int _hashIncomingNeighborhood = FurtherNodeDescriptor.<NodeRep>hashIncomingNeighborhood(incomingEdges);
      int _plus = ((prime * result) + _hashIncomingNeighborhood);
      result = _plus;
    }
    if ((outgoingEdges != null)) {
      int _hashOutgoingNeighborhood = FurtherNodeDescriptor.<NodeRep>hashOutgoingNeighborhood(outgoingEdges);
      int _plus_1 = ((prime * result) + _hashOutgoingNeighborhood);
      result = _plus_1;
    }
    return result;
  }
  
  @Override
  public int hashCode() {
    return this.getDataHash();
  }
  
  @Override
  public boolean equals(final Object other) {
    return (Objects.equal(other.getClass(), FurtherNodeDescriptor.class) && (((AbstractNodeDescriptor) other).hashCode() == this.hashCode()));
  }
  
  @Override
  public StringConcatenationClient prettyPrint() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("(");
        int _dataHash = FurtherNodeDescriptor.this.getDataHash();
        _builder.append(_dataHash);
        _builder.append(")[");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("PREV = ");
        StringConcatenationClient _prettyPrint = null;
        if (FurtherNodeDescriptor.this.previousRepresentation!=null) {
          _prettyPrint=FurtherNodeDescriptor.this.prettyPrint(FurtherNodeDescriptor.this.previousRepresentation);
        }
        _builder.append(_prettyPrint, "\t");
        _builder.newLineIfNotEmpty();
        {
          if ((FurtherNodeDescriptor.this.incomingEdges == null)) {
            _builder.append("\t");
            _builder.append("IN null");
            _builder.newLine();
          } else {
            {
              Set<Map.Entry<IncomingRelation<NodeRep>, Integer>> _entrySet = FurtherNodeDescriptor.this.incomingEdges.entrySet();
              for(final Map.Entry<IncomingRelation<NodeRep>, Integer> edge : _entrySet) {
                _builder.append("\t");
                _builder.append("IN ");
                Integer _value = edge.getValue();
                _builder.append(_value, "\t");
                _builder.append(" ");
                String _type = edge.getKey().getType();
                _builder.append(_type, "\t");
                _builder.append(" = ");
                StringConcatenationClient _prettyPrint_1 = FurtherNodeDescriptor.this.prettyPrint(edge.getKey().getFrom());
                _builder.append(_prettyPrint_1, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if ((FurtherNodeDescriptor.this.outgoingEdges == null)) {
            _builder.append("\t");
            _builder.append("OUT null");
            _builder.newLine();
          } else {
            {
              Set<Map.Entry<OutgoingRelation<NodeRep>, Integer>> _entrySet_1 = FurtherNodeDescriptor.this.outgoingEdges.entrySet();
              for(final Map.Entry<OutgoingRelation<NodeRep>, Integer> edge_1 : _entrySet_1) {
                _builder.append("\t");
                _builder.append("OUT ");
                Integer _value_1 = edge_1.getValue();
                _builder.append(_value_1, "\t");
                _builder.append(" ");
                String _type_1 = edge_1.getKey().getType();
                _builder.append(_type_1, "\t");
                _builder.append(" = ");
                StringConcatenationClient _prettyPrint_2 = FurtherNodeDescriptor.this.prettyPrint(edge_1.getKey().getTo());
                _builder.append(_prettyPrint_2, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("]");
      }
    };
    return _client;
  }
  
  private StringConcatenationClient prettyPrint(final NodeRep rep) {
    StringConcatenationClient _xifexpression = null;
    if ((rep instanceof AbstractNodeDescriptor)) {
      _xifexpression = ((AbstractNodeDescriptor)rep).prettyPrint();
    } else {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append(rep);
        }
      };
      _xifexpression = _client;
    }
    return _xifexpression;
  }
  
  private static <NodeRep extends Object> int hashIncomingNeighborhood(final Map<IncomingRelation<NodeRep>, Integer> neighborhood) {
    int _xblockexpression = (int) 0;
    {
      final int prime = 31;
      int hash = 0;
      Set<Map.Entry<IncomingRelation<NodeRep>, Integer>> _entrySet = neighborhood.entrySet();
      for (final Map.Entry<IncomingRelation<NodeRep>, Integer> entry : _entrySet) {
        {
          final IncomingRelation<NodeRep> relation = entry.getKey();
          int _hash = hash;
          int _hashCode = relation.getFrom().hashCode();
          int _multiply = (prime * _hashCode);
          int _hashCode_1 = relation.getType().hashCode();
          hash = (_hash + ((_multiply + _hashCode_1) ^ entry.getValue().hashCode()));
        }
      }
      _xblockexpression = hash;
    }
    return _xblockexpression;
  }
  
  private static <NodeRep extends Object> int hashOutgoingNeighborhood(final Map<OutgoingRelation<NodeRep>, Integer> neighborhood) {
    int _xblockexpression = (int) 0;
    {
      final int prime = 31;
      int hash = 0;
      Set<Map.Entry<OutgoingRelation<NodeRep>, Integer>> _entrySet = neighborhood.entrySet();
      for (final Map.Entry<OutgoingRelation<NodeRep>, Integer> entry : _entrySet) {
        {
          final OutgoingRelation<NodeRep> relation = entry.getKey();
          int _hash = hash;
          int _hashCode = relation.getTo().hashCode();
          int _multiply = (prime * _hashCode);
          int _hashCode_1 = relation.getType().hashCode();
          hash = (_hash + ((_multiply + _hashCode_1) ^ entry.getValue().hashCode()));
        }
      }
      _xblockexpression = hash;
    }
    return _xblockexpression;
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
  public NodeRep getPreviousRepresentation() {
    return this.previousRepresentation;
  }
  
  @Pure
  public Map<IncomingRelation<NodeRep>, Integer> getIncomingEdges() {
    return this.incomingEdges;
  }
  
  @Pure
  public Map<OutgoingRelation<NodeRep>, Integer> getOutgoingEdges() {
    return this.outgoingEdges;
  }
}
