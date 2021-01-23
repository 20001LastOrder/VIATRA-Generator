package org.eclipse.viatra.coding;

import java.util.*;

public class Graph{
    private Map<String, Set<List<Node>>> labelEdges;
    private Map<String, Set<Node>> labelNodes;
    private List<Node> nodeOrdering;
    private Object hash;
    
    /**
     * Create a graph with predefined node types and edge types
     * @param nodeLabels
     * @param edgeLabels
     */
    public Graph(List<String> nodeLabels, List<String> edgeLabels) {
        labelNodes = new HashMap<>();
        labelEdges = new HashMap<>();
        for (String nodeLabel : nodeLabels) {
            labelNodes.put(nodeLabel, new HashSet<>());
        }

        for (String edgeLabel : edgeLabels) {
            labelEdges.put(edgeLabel, new HashSet<>());
        }
        nodeOrdering = new ArrayList<>();
    }

    /**
     * Create a graph by cloning another graph
     * @param other
     */
    public Graph(Graph other) {
        labelNodes = new HashMap<>();
        labelEdges = new HashMap<>();
        for (Map.Entry<String, Set<Node>> entry : other.labelNodes.entrySet()) {
            labelNodes.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }

        for (Map.Entry<String, Set<List<Node>>> entry : other.labelEdges.entrySet()) {
            Set<List<Node>> value = new HashSet<>();
            for (List<Node> edge : entry.getValue()) {
                value.add(new ArrayList<>(edge));
            }

            labelEdges.put(entry.getKey(), value);
        }

        nodeOrdering = new ArrayList<>(other.nodeOrdering);
    }

    /**
     * Add a node with a specific node type to the graph
     * @param node
     * @param label
     */
    public void addNode(Node node, String label) {
        if (labelNodes.containsKey(label)) {
            labelNodes.get(label).add(node);
            nodeOrdering.add(node);
        }
    }

    /**
     * Add an edge with a specific edge type to the graph. (the src and tgt must be added to the graph already)
     * @param src
     * @param tgt
     * @param label
     */
    public void addEdge(Node src, Node tgt, String label) {
        if (nodeOrdering.contains(src) && nodeOrdering.contains(tgt) && labelEdges.containsKey(label)) {
            labelEdges.get(label).add(Arrays.asList(src, tgt));
        }
    }

    /**
     * Remove an edge with specific edge type
     * @param src
     * @param tgt
     * @param label
     */
    public void removeEdge(Node src, Node tgt, String label) {
        if (!labelEdges.containsKey(label)) {
            return;
        }

        labelEdges.get(label).remove(Arrays.asList(src, tgt));
    }

    public Map<String, Set<List<Node>>> getLabelEdges() {
        return labelEdges;
    }

    public List<String> getEdgeLabels() {
        return new ArrayList<>(labelEdges.keySet());
    }

    public Map<String, Set<Node>> getLabelNodes() {
        return labelNodes;
    }

    public int getSize() {
        return nodeOrdering.size();
    }

    public List<Node> getNodeOrdering() {
        return nodeOrdering;
    }
    
    /**
     * check if the graph contains an edge with a specific label
     * @param src: source node, should be in the graph
     * @param tgt: target node, should be in the graph
     * @param edgeLabel: label of the edge, should be one of the graph
     * @return
     */
    public boolean containEdge(Node src, Node tgt, String label) {
    	if (!labelEdges.containsKey(label)) {
    		return false;
    	}
    	
    	List<Node> edge = Arrays.asList(src, tgt);
    	return labelEdges.get(label).contains(edge);
    }

    /**
     * Remove all nodes and edges in the graph
     */
    public void clear() {
        for (Map.Entry<String, Set<Node>> entry : labelNodes.entrySet()) {
            entry.getValue().clear();
        }

        for (Map.Entry<String, Set<List<Node>>> entry : labelEdges.entrySet()) {
            entry.getValue().clear();
        }

        nodeOrdering.clear();
    }

    /**
     * Order the graph nodes. 
     * @param nodeOrdering: the nodes of this graph in a specific order
     */
    public void setNodeOrdering(List<Node> nodeOrdering) {
        this.nodeOrdering = nodeOrdering;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nodes: \n");
        for (Map.Entry<String, Set<Node>> entry : labelNodes.entrySet()) {
            sb.append("\t").append(entry.getKey()).append(":").append(entry.getValue());
        }
        sb.append("\n");
        sb.append("Edges: \n");
        for (Map.Entry<String, Set<List<Node>>> entry : labelEdges.entrySet()) {
            sb.append("\t").append(entry.getKey()).append(":").append(entry.getValue());
        }

        return sb.toString();
    }
    
    public void setHash(Object hash) {
    	this.hash = hash;
    }
    
    public Object getHash() {
    	return this.hash;
    }
}
