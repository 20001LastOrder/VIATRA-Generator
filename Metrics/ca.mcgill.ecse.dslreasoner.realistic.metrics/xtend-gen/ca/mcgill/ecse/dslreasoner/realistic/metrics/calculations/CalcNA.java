package ca.mcgill.ecse.dslreasoner.realistic.metrics.calculations;

import ca.mcgill.ecse.dslreasoner.realistic.metrics.calculations.CalcMetric2;
import ca.mcgill.ecse.dslreasoner.realistic.metrics.examples.Util;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.GraphNodeDescriptorGND;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.GraphShape;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.IncomingRelation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.IncomingRelationGND;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.Neighbourhood2ShapeGraph;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodWithTraces;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelationGND;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2ImmutableTypeLattice;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class CalcNA extends CalcMetric2 {
  private final static PartialInterpretation2ImmutableTypeLattice neighbourhoodComputer = new PartialInterpretation2ImmutableTypeLattice();
  
  private final static Neighbourhood2ShapeGraph neighbouhood2ShapeGraph = new Neighbourhood2ShapeGraph();
  
  @Override
  public List<Double> calcFromModel(final EObject model) {
    final List<EObject> nodes = IteratorExtensions.<EObject>toList(model.eResource().getAllContents());
    double totalNA = 0.0;
    final int numNodes = ((Object[])Conversions.unwrapArray(nodes, Object.class)).length;
    Map<EObject, Set<String>> node2ActiveDims = new HashMap<EObject, Set<String>>();
    for (final EObject node : nodes) {
      HashSet<String> _hashSet = new HashSet<String>();
      node2ActiveDims.put(node, _hashSet);
    }
    for (final EObject node_1 : nodes) {
      EList<EReference> _eAllReferences = node_1.eClass().getEAllReferences();
      for (final EReference reference : _eAllReferences) {
        {
          final Object pointingTo = node_1.eGet(reference);
          if ((!(pointingTo instanceof List))) {
            if ((pointingTo != null)) {
              CollectionsUtil.<EObject, Set<String>>lookup(node_1, node2ActiveDims).add(reference.getName());
              CollectionsUtil.<EObject, Set<String>>lookup(((EObject) pointingTo), node2ActiveDims).add(reference.getName());
            }
          } else {
            final List pointingToSet = ((List) pointingTo);
            boolean _isEmpty = pointingToSet.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              for (final Object target : pointingToSet) {
                {
                  CollectionsUtil.<EObject, Set<String>>lookup(node_1, node2ActiveDims).add(reference.getName());
                  CollectionsUtil.<EObject, Set<String>>lookup(((EObject) target), node2ActiveDims).add(reference.getName());
                }
              }
            }
          }
        }
      }
    }
    final List<Double> metricDistrib = CollectionLiterals.<Double>newArrayList();
    Collection<Set<String>> _values = node2ActiveDims.values();
    for (final Set<String> activeDims : _values) {
      int _length = ((Object[])Conversions.unwrapArray(activeDims, Object.class)).length;
      metricDistrib.add(Double.valueOf(((double) _length)));
    }
    return metricDistrib;
  }
  
  @Override
  public List<Double> calcFromNHLattice(final PartialInterpretation partialModel) {
    return this.calcFromNHLattice(partialModel, Integer.valueOf(1));
  }
  
  @Override
  public List<Double> calcFromNHLattice(final PartialInterpretation partialModel, final Integer depth) {
    final NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> nh = CalcNA.neighbourhoodComputer.createRepresentation(partialModel, ((depth).intValue() + 1), Integer.MAX_VALUE, Integer.MAX_VALUE);
    Map<? extends AbstractNodeDescriptor, Integer> _modelRepresentation = nh.getModelRepresentation();
    final HashMap nhDeepRep = ((HashMap) _modelRepresentation);
    Map<? extends AbstractNodeDescriptor, Integer> _modelRepresentation_1 = CalcNA.neighbourhoodComputer.createRepresentation(partialModel, (depth).intValue(), Integer.MAX_VALUE, Integer.MAX_VALUE).getModelRepresentation();
    final HashMap nhRep = ((HashMap) _modelRepresentation_1);
    final Set nhDeepNodes = nhDeepRep.keySet();
    final Set nhNodes = nhRep.keySet();
    Map<AbstractNodeDescriptor, Set<String>> node2ActiveDims = new HashMap<AbstractNodeDescriptor, Set<String>>();
    for (final Object nhNode : nhNodes) {
      HashSet<String> _hashSet = new HashSet<String>();
      node2ActiveDims.put(((AbstractNodeDescriptor) nhNode), _hashSet);
    }
    for (final Object nhDeepNode : nhDeepNodes) {
      {
        final FurtherNodeDescriptor nhDeepNodeDesc = ((FurtherNodeDescriptor) nhDeepNode);
        Object _previousRepresentation = nhDeepNodeDesc.getPreviousRepresentation();
        final AbstractNodeDescriptor nhParentNode = ((AbstractNodeDescriptor) _previousRepresentation);
        Set _keySet = nhDeepNodeDesc.getIncomingEdges().keySet();
        for (final Object inEdge : _keySet) {
          {
            final String edgeDim = ((IncomingRelation) inEdge).getType();
            CollectionsUtil.<AbstractNodeDescriptor, Set<String>>lookup(nhParentNode, node2ActiveDims).add(edgeDim);
          }
        }
        Set _keySet_1 = nhDeepNodeDesc.getOutgoingEdges().keySet();
        for (final Object outEdge : _keySet_1) {
          {
            final String edgeDim = ((OutgoingRelation) outEdge).getType();
            CollectionsUtil.<AbstractNodeDescriptor, Set<String>>lookup(nhParentNode, node2ActiveDims).add(edgeDim);
          }
        }
      }
    }
    final List<Double> metricDistrib = CollectionLiterals.<Double>newArrayList();
    Set<AbstractNodeDescriptor> _keySet = node2ActiveDims.keySet();
    for (final AbstractNodeDescriptor nhNode_1 : _keySet) {
      {
        final AbstractNodeDescriptor nodeAND = ((AbstractNodeDescriptor) nhNode_1);
        int NAVal = ((Object[])Conversions.unwrapArray(CollectionsUtil.<AbstractNodeDescriptor, Set<String>>lookup(nhNode_1, node2ActiveDims), Object.class)).length;
        Object _lookup = CollectionsUtil.<AbstractNodeDescriptor, Object>lookup(nhNode_1, nhRep);
        Integer numNodeOccurences = ((Integer) _lookup);
        boolean _isEmpty = Util.toLocalNode(nodeAND).getTypes().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          for (int i = 0; (i < (numNodeOccurences).intValue()); i++) {
            metricDistrib.add(Double.valueOf(((double) NAVal)));
          }
        }
      }
    }
    return metricDistrib;
  }
  
  public static double getNAfromNHShape(final PartialInterpretation pm) {
    return CalcNA.getNAfromNHShape(pm, Integer.valueOf(1));
  }
  
  public static double getNAfromNHShape(final PartialInterpretation partialModel, final Integer depth) {
    final NeighbourhoodWithTraces<Map<? extends AbstractNodeDescriptor, Integer>, AbstractNodeDescriptor> nh = CalcNA.neighbourhoodComputer.createRepresentation(partialModel, (depth).intValue(), Integer.MAX_VALUE, Integer.MAX_VALUE);
    Map<? extends AbstractNodeDescriptor, Integer> _modelRepresentation = nh.getModelRepresentation();
    final HashMap nhRep = ((HashMap) _modelRepresentation);
    final GraphShape<Object, Object> nhShapeGraph = CalcNA.neighbouhood2ShapeGraph.createShapeGraph(nh, partialModel);
    double totalMetricValue = 0.0;
    int numNodesTotal = 0;
    Set<Object> activeDims = new HashSet<Object>();
    List<GraphNodeDescriptorGND> _nodes = nhShapeGraph.getNodes();
    for (final GraphNodeDescriptorGND node : _nodes) {
      {
        List<IncomingRelationGND> _incomingEdges = node.getIncomingEdges();
        for (final IncomingRelationGND inEdge : _incomingEdges) {
          activeDims.add(inEdge.getType());
        }
        List<OutgoingRelationGND> _outgoingEdges = node.getOutgoingEdges();
        for (final OutgoingRelationGND outEdge : _outgoingEdges) {
          activeDims.add(outEdge.getType());
        }
        Object _lookup = CollectionsUtil.<AbstractNodeDescriptor, Object>lookup(node.getCorrespondingAND(), nhRep);
        final Integer numOccurrences = ((Integer) _lookup);
        final Set<Object> _converted_activeDims = (Set<Object>)activeDims;
        final int numActDims = ((Object[])Conversions.unwrapArray(_converted_activeDims, Object.class)).length;
        final int totalActDims = (numActDims * (numOccurrences).intValue());
        int _numNodesTotal = numNodesTotal;
        numNodesTotal = (_numNodesTotal + (numOccurrences).intValue());
        double _talMetricValue = totalMetricValue;
        totalMetricValue = (_talMetricValue + totalActDims);
        activeDims.clear();
      }
    }
    double averageMetricValue = 0.0;
    if ((totalMetricValue != 0)) {
      averageMetricValue = (totalMetricValue / numNodesTotal);
    }
    return averageMetricValue;
  }
}
