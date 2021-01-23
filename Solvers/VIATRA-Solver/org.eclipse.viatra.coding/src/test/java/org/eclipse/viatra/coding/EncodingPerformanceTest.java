package org.eclipse.viatra.coding;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.Test;

public class EncodingPerformanceTest {
	Graph graph;
	int nrNode = 1000;
	int nrEdges = 100000;
	String[] nodeLabels = {"A", "B"};
	String[] edgeLabels = {"C", "D"};
	long seed = 1l;
	
	@Before
	public void generateRandomeGraph() {
		Random random = new Random(seed);
		graph = new Graph(Arrays.asList(nodeLabels), Arrays.asList(edgeLabels));
		
		// add nodes
		for (int i = 0; i < nrNode; i++) {
			graph.addNode(new Node(i), nodeLabels[random.nextInt(nodeLabels.length)]);
		}

		// randomly form edges from nodes
		int i = 0;
		List<Node> nodes = graph.getNodeOrdering();
		while (i < nrEdges) {
			String edgeLabel = edgeLabels[random.nextInt(edgeLabels.length)];
			Node src = nodes.get(random.nextInt(nodes.size()));
			Node tgt = nodes.get(random.nextInt(nodes.size()));
			if (!graph.containEdge(src, tgt, edgeLabel)) {
				graph.addEdge(src, tgt, edgeLabel);

				i++;
			}
		}
		
		//System.out.println(graph);
	}
	
	@Test
	public void incrementalTime() {
		IncrementalEncoder encoder = new IncrementalEncoder();
		IncrementalEncoder incrementalEncoder = new IncrementalEncoder();
		Random random = new Random(seed);
		List<Node> nodes = graph.getNodeOrdering();
		int i = 0;

		incrementalEncoder.calculateNodeCertsFromScratch(graph);
		while (i < 1) {
			String edgeLabel = edgeLabels[random.nextInt(edgeLabels.length)];
			Node src = nodes.get(random.nextInt(nodes.size()));
			Node tgt = nodes.get(random.nextInt(nodes.size()));
			if (!graph.containEdge(src, tgt, edgeLabel)) {
				graph.addEdge(src, tgt, edgeLabel);
				
				Object incremental = timer(() -> {
					incrementalEncoder.calculateNodeCerts(graph, Arrays.asList(src, tgt), edgeLabel);
					return incrementalEncoder.calculateStateCodeFromNodeCerts(graph, new ArrayStateCode());
				});
				
				Object regular = timer(() -> {
					encoder.calculateNodeCertsFromScratch(graph);
					return encoder.calculateStateCodeFromNodeCerts(graph, new ArrayStateCode());
				});
				
				assertEquals(regular, incremental);
				
				i++;
			}
		}
		
	}
	
	public Object timer(Supplier<Object> func) {
		long startTime = System.nanoTime();
		Object code = func.get();
		long finishTime = System.nanoTime();
		double elapsed = ((double) finishTime - startTime) / 1e9;
		System.out.println("Time Elapsed (s): " + elapsed);
		return code;
	}
	
	@Test
	public void arrayEncodingTime() {
		
		System.out.println("----------Array Encoding----------");
		Encoder encoder = new Encoder();
		
		long startTime = System.nanoTime();
		Object code = encoder.calculateStateCode(graph, new ArrayStateCode());
		long finishTime = System.nanoTime();
		
		double elapsed = ((double) finishTime - startTime) / 1e9;
		System.out.println("Time Elapsed (s): " + elapsed);
		System.out.println("The calculated state code is: " + code);
	}
	
	@Test
	public void matrixEncodingTime() {
		System.out.println("----------Matrix Encoding----------");
		Encoder encoder = new Encoder();
		
		long startTime = System.nanoTime();
		Object code = encoder.calculateStateCode(graph, new AdjacencyStateCode(10));
		long finishTime = System.nanoTime();
		
		double elapsed = ((double) finishTime - startTime) / 1e9;
		System.out.println("Time Elapsed (s): " + elapsed);
		System.out.println("The calculated state code is: " + code);
	}
	
	@Test
	public void apstTime() {
		System.out.println("----------APSP----------");

		long startTime = System.nanoTime();
		int[][] distances = allPairShortestPath(graph);
		long finishTime = System.nanoTime();
		
		double elapsed = ((double) finishTime - startTime) / 1e9;
		System.out.println("Time Elapsed (s): " + elapsed);
		//printMatrix(distances);
	}
	
	private int[][] allPairShortestPath(Graph graph) {
		// preprocessing (get edge information)
		Set<List<Node>> untypedEdges = new HashSet<>();
		for (String edgeLabel : edgeLabels) {
			for (List<Node> edge : graph.getLabelEdges().get(edgeLabel)) {
				untypedEdges.add(edge);
			}
		}
		List<Node> nodes = graph.getNodeOrdering();
		int n = nodes.size();
		// create the APSP matrix
		int[][] distances = new int[n][n];
		
		//initialize the initial distance to either 1 if there is an edge, or the number of nodes + 1 (meaning infinite)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				distances[i][j] = i == j? 0 : untypedEdges.contains(Arrays.asList(nodes.get(i), nodes.get(j)))? 1 : n + 1;
			}
		}
		
		// perform the algorithm
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (distances[i][k] + distances[k][j] < distances[i][j]) {
						distances[i][j] = distances[i][k] + distances[k][j];
					}
				}
			}
		}
		
		return distances;
	}
	
	public void printMatrix(int[][] matrix) {
	    for (int row = 0; row < matrix.length; row++) {
	        for (int col = 0; col < matrix[row].length; col++) {
	            System.out.printf("%4d", matrix[row][col]);
	        }
	        System.out.println();
	    }
	}
}
