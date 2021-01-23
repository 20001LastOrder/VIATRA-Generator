package org.eclipse.viatra.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class IncrementalEncoder {
	private CertificatePropagator certificate;

	private Map<Node, List<Integer>> nodeCerts;

	/**
	 * String corresponds the label of the edge First list describes the source and
	 * target node Second list is the edge certificate for each level
	 */
	private Map<String, Map<List<Node>, List<Integer>>> edgeCerts;

	private int level;
	
	public IncrementalEncoder() {
		certificate = new Encoder.BinaryCertificatePropagator();
	}

	public IncrementalEncoder(CertificatePropagator certificate) {
		this.certificate = certificate;
	}

	public Map<Node, List<Integer>> getNodeCerts() {
		return nodeCerts;
	}
	
	public void calculateNodeCerts(Graph g, List<Node> edgeChanged, String edgeLabel) {		
		// reset node certs if
		for (Node node : edgeChanged) {
			List<Integer> certLevels = nodeCerts.getOrDefault(node, new ArrayList<>());
			
			// in case this is a new node
			if (certLevels.size() == 0) {
				for (Map.Entry<String, Set<Node>> entry : g.getLabelNodes().entrySet()) {
					if (entry.getValue().contains(node)) {
						certLevels.add(entry.getKey().hashCode());
					}
				}
				
				// if still 0, this means the new node does not exist
				if (certLevels.size() == 0) {
					throw new RuntimeException("Node " + node.id + " does not exist in graph");
				}
			}
			
			certLevels.subList(1, certLevels.size()).clear();
			nodeCerts.put(node, certLevels);
		}
		
		// add the new edge
		List<Integer> newCertLevels = new ArrayList<>();
		newCertLevels.add(edgeLabel.hashCode());
		edgeCerts.get(edgeLabel).put(edgeChanged, newCertLevels);
		
		Map<Node, Integer> temp = new HashMap<>();
		for (Map.Entry<String, Set<Node>> entry : g.getLabelNodes().entrySet()) {
			for (Node node : entry.getValue()) {
				temp.put(node, 0);
			}
		}
		
		// perform the node certificate update
		int partSize = 1, oldPartSize = 0;
		level = 0;
		while (partSize > oldPartSize) {
			oldPartSize = partSize;
			level++;
			
			for (Map.Entry<String, Set<List<Node>>> entry : g.getLabelEdges().entrySet()) {
				Map<List<Node>, List<Integer>> labeledEdgeCerts = edgeCerts.get(entry.getKey());
				for (List<Node> edge : entry.getValue()) {
					List<Integer> sourceLevels = nodeCerts.get(edge.get(0));
					List<Integer> targetLevels = nodeCerts.get(edge.get(1));
					
					int newEdgeCerts;
					if (sourceLevels.size() > level && targetLevels.size() > level || 
						(level == 1 && labeledEdgeCerts.get(edge).size() > 1)) {
						// the edge is not dirty, we can use it
						newEdgeCerts = labeledEdgeCerts.get(edge).get(level);
					} else {
						// both of them are dirty now, remove the saved part
						List<Integer> certLevels = labeledEdgeCerts.get(edge);
						certLevels.subList(level, certLevels.size()).clear();
						sourceLevels.subList(level, sourceLevels.size()).clear();
						targetLevels.subList(level, targetLevels.size()).clear();
						// calculate new node certificate from the last level'
						newEdgeCerts = certificate.newCert(certLevels.get(level - 1), entry.getKey(),
								sourceLevels.get(level - 1), targetLevels.get(level - 1));

						certLevels.add(newEdgeCerts);
					}
					
					// propagate the new edge certificate to two ends
					// add 1 and 2 to distinguish incoming edge, outgoing edge and self loops
					if (edge.get(0) != edge.get(1)) {
						temp.put(edge.get(0), temp.getOrDefault(edge.get(0), 0) + newEdgeCerts + 1);
					} else {
						temp.put(edge.get(0), temp.getOrDefault(edge.get(0), 0) + newEdgeCerts + 2);
					}

					temp.put(edge.get(1), temp.getOrDefault(edge.get(1), 0) - newEdgeCerts);
				}
			}
			
			Set<Integer> certSet = new HashSet<>();
			for (Map.Entry<String, Set<Node>> entry : g.getLabelNodes().entrySet()) {
				for (Node node : entry.getValue()) {
					
					List<Integer> certLevels = nodeCerts.get(node);
					if (nodeCerts.get(node).size() <= level) {
						// the current node is dirty
						certLevels.add(certLevels.get(level - 1) + temp.get(node));

					}
					
					// cumulate the number of distinct node certificates
					certSet.add(certLevels.get(level));
					
					// reset the temp holder
					temp.put(node, 0);

				}
			}

			oldPartSize = partSize;
			partSize = certSet.size();
		}
//		System.out.println(level);
	}
	
	public void calculateNodeCertsFromScratch(Graph g) {
		// used to accumulate the edge certificates of a node
		Map<Node, Integer> temp = new HashMap<>();

		nodeCerts = new HashMap<>();
		edgeCerts = new HashMap<>();

		// set level 0 edge certificates
		for (Map.Entry<String, Set<List<Node>>> entry : g.getLabelEdges().entrySet()) {
			Map<List<Node>, List<Integer>> labelEdgeCerts = new HashMap<>();
			edgeCerts.put(entry.getKey(), labelEdgeCerts);
			for (List<Node> edge : entry.getValue()) {
				List<Integer> certLevels = new ArrayList<>();
				labelEdgeCerts.put(edge, certLevels);
				certLevels.add(entry.getKey().hashCode());
			}
		}

		// set level 0 node certificates
		for (Map.Entry<String, Set<Node>> entry : g.getLabelNodes().entrySet()) {
			for (Node node : entry.getValue()) {
				List<Integer> certLevels = new ArrayList<>();
				nodeCerts.put(node, certLevels);
				certLevels.add(entry.getKey().hashCode());
				temp.put(node, 0);
			}
		}

		int partSize = 1, oldPartSize = 0; 
		level = 0;
		do {
			level++;
			for (Map.Entry<String, Set<List<Node>>> entry : g.getLabelEdges().entrySet()) {
				Map<List<Node>, List<Integer>> labeledEdgeCerts = edgeCerts.get(entry.getKey());
				for (List<Node> edge : entry.getValue()) {
					List<Integer> certLevels = labeledEdgeCerts.get(edge);
					// calculate new node certificate from the last level
					int newEdgeCerts = certificate.newCert(certLevels.get(level - 1), entry.getKey(),
							nodeCerts.get(edge.get(0)).get(level - 1), nodeCerts.get(edge.get(1)).get(level - 1));

					certLevels.add(newEdgeCerts);

					// propagate the new edge certificate to two ends
					// add 1 and 2 to distinguish incoming edge, outgoing edge and self loops
					if (edge.get(0) != edge.get(1)) {
						temp.put(edge.get(0), temp.get(edge.get(0)) + newEdgeCerts + 1);
					} else {
						temp.put(edge.get(0), temp.get(edge.get(0)) + newEdgeCerts + 2);
					}

					temp.put(edge.get(1), temp.get(edge.get(1)) - newEdgeCerts);
				}
			}

			Set<Integer> certSet = new HashSet<>();
			for (Map.Entry<String, Set<Node>> entry : g.getLabelNodes().entrySet()) {
				for (Node node : entry.getValue()) {
					List<Integer> certLevels = nodeCerts.get(node);
					certLevels.add(certLevels.get(level - 1) + temp.get(node));

					// reset the temp holder
					temp.put(node, 0);

					// cumulate the number of distinct node certificates
					certSet.add(certLevels.get(certLevels.size() - 1));
				}
			}

			oldPartSize = partSize;
			partSize = certSet.size();
		} while (partSize > oldPartSize);	
//		System.out.println(level);
	}

	public Object calculateStateCodeFromNodeCerts(Graph g, IStateCode s) {

		Map<Node, Integer> certificates = new HashMap<>();
		for (Map.Entry<Node, List<Integer>> entry : nodeCerts.entrySet()) {
			certificates.put(entry.getKey(), entry.getValue().get(level));
		}

		return s.processStateCode(g, certificates);
	}

	public Object calculateStateCode(Graph g, IStateCode s) {
		calculateNodeCertsFromScratch(g);
		return calculateStateCodeFromNodeCerts(g, s);
	}

}
