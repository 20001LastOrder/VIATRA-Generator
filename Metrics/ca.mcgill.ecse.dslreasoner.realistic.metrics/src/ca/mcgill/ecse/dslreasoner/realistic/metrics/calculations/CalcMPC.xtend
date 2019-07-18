package ca.mcgill.ecse.dslreasoner.realistic.metrics.calculations

import ca.mcgill.ecse.dslreasoner.realistic.metrics.examples.Util
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.IncomingRelation
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.Neighbourhood2ShapeGraph
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelation
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2ImmutableTypeLattice
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject

import static extension hu.bme.mit.inf.dslreasoner.util.CollectionsUtil.*
import ca.mcgill.ecse.dslreasoner.realistic.metrics.examples.MetricsCalculationUsingShapes

class CalcMPC {
	static val neighbourhoodComputer = new PartialInterpretation2ImmutableTypeLattice
	static val neighbouhood2ShapeGraph = new Neighbourhood2ShapeGraph

	def static getMPCfromModel(EObject model) {
		val nodes = model.eResource.allContents.toList

		var Set<String> allDimensions = new HashSet

		// fill HashSet
		var Map<EObject, Map<String, Integer>> node2Degrees = new HashMap
		for (node : nodes) {
			node2Degrees.put(node, newHashMap)
		}

		// iterate over nodes and their references
		for (node : nodes) {

			// calculate Degree for each reference Type
			for (reference : node.eClass.EAllReferences) {
				val pointingTo = node.eGet(reference)

				if (!(pointingTo instanceof List)) {
					if (pointingTo !== null) {
						allDimensions.add(reference.name) // TODO
						// Add for source
						Util.putInside(node, reference.name, 1, node2Degrees)
						// Add for target
						Util.putInside((pointingTo as EObject), reference.name, 1, node2Degrees)
					}
				} else {
					val pointingToList = pointingTo as List
					if (!pointingToList.empty) {
						allDimensions.add(reference.name) // TODO
						// Add for source
						Util.putInside(node, reference.name, pointingToList.size, node2Degrees)
						for (target : pointingToList) {
							// Add for target
							Util.putInside((target as EObject), reference.name, 1, node2Degrees)
						}
					}
				}
			}
		}

		// Measure MPC
		val numNodes = nodes.length
		val totalNumDims = allDimensions.length
		var totalMPC = 0.0
		for (degrees : node2Degrees.values) {
			var totalDegree = Util.sumInt(degrees.values)
			var partialMPC = 1.0
			for (degree : degrees.values) {
				partialMPC -= Math.pow(degree.floatValue / totalDegree, 2)
			}
			totalMPC += partialMPC
		}
		
		var averageMPC = 0.0
		if ( totalNumDims.floatValue * totalMPC != 0) {
			averageMPC = ( totalNumDims.floatValue / (totalNumDims - 1) ) * (totalMPC / numNodes)
		}
		
		return averageMPC
	}

	def static getMPCfromNHShape(PartialInterpretation pm) {
		getMPCfromNHShape(pm, 1)
	}

	def static getMPCfromNHShape(PartialInterpretation partialModel, Integer depth) {
		// Get NH Shape
		val nh = neighbourhoodComputer.createRepresentation(partialModel, depth, Integer.MAX_VALUE, Integer.MAX_VALUE)
		val nhRep = nh.modelRepresentation as HashMap
		val nhShapeGraph = neighbouhood2ShapeGraph.createShapeGraph(nh, partialModel)

		// Useful variable initializations
		var totalMPC = 0.0
		var totalDegree = 0.0
		var partialMPC = 0.0
		var numNodes = 0
		var numToAdd = 0
		var Set<String> allDimensions = new HashSet
		var Map<String, Integer> type2Num = new HashMap

		// look at the in and out edges of each shape node
		for (node : nhShapeGraph.nodes) {
			totalDegree = 0.0
			// relation type distribution can be measured by only considering the current nodes "view" 
			// of its relations
			for (inEdge : node.incomingEdges) {
				val edgeName = inEdge.type
				allDimensions.add(edgeName)
				numToAdd = Util.sumInt(inEdge.targetDistrib)

				totalDegree += numToAdd
				if (type2Num.keySet.contains(edgeName)) {
					type2Num.put(edgeName, edgeName.lookup(type2Num) + numToAdd)
				} else {
					type2Num.put(edgeName, numToAdd)
				}
			}
			for (outEdge : node.outgoingEdges) {
				val edgeName = outEdge.type
				allDimensions.add(edgeName)
				numToAdd = Util.sumInt(outEdge.sourceDistrib)

				totalDegree += numToAdd
				if (type2Num.keySet.contains(edgeName)) {
					type2Num.put(edgeName, edgeName.lookup(type2Num) + numToAdd)
				} else {
					type2Num.put(edgeName, numToAdd)
				}
			}

			// Measure preliminary results for MPC
			partialMPC = 1.0
			for (degree : type2Num.values) {
				partialMPC -= Math.pow(degree.floatValue / totalDegree, 2)
			}

			val numOccurrences = node.correspondingAND.lookup(nhRep) as Integer
			numNodes += numOccurrences

			totalMPC += partialMPC * numOccurrences
			type2Num.clear
		}

		val totalNumDims = allDimensions.size

		val averageMPC = ( totalNumDims.floatValue / (totalNumDims - 1) ) * (totalMPC / numNodes)
		return averageMPC
	}

	def static getMPCfromNHLattice(PartialInterpretation pm) {
		getMPCfromNHLattice(pm, 1)
	}

	def static getMPCfromNHLattice(PartialInterpretation pm, Integer depth) {
		// Get NH Lattice and deepLattice
		val nh = neighbourhoodComputer.createRepresentation(pm, depth + 1, Integer.MAX_VALUE, Integer.MAX_VALUE)
		val nhDeepRep = nh.modelRepresentation as HashMap
		val nhRep = neighbourhoodComputer.createRepresentation(pm, depth, Integer.MAX_VALUE, Integer.MAX_VALUE).
			modelRepresentation as HashMap
		val nhDeepNodes = nhDeepRep.keySet
		val nhNodes = nhRep.keySet

		// Associate each deepNode to their parent
		val Map<AbstractNodeDescriptor, List<FurtherNodeDescriptor>> AND2children = new HashMap
		for (deepNodeKey : nhDeepNodes) {
			val deepNodeDesc = deepNodeKey as FurtherNodeDescriptor
			val parentDesc = deepNodeDesc.previousRepresentation as AbstractNodeDescriptor
			if (AND2children.keySet.contains(parentDesc)) {
				parentDesc.lookup(AND2children).add(deepNodeDesc)
			} else {
				AND2children.put(parentDesc, newArrayList(deepNodeDesc))
			}
		}

		// Useful variable initializations
		var totalMPC = 0.0
		var totalDegree = 0.0
		var partialMPC = 0.0
		var numNodes = 0
		var numToAdd = 0
		var Set<String> allDimensions = new HashSet
		var Map<String, Integer> type2Num = new HashMap
		
		// look at the in and out edges of each shape node
		for (node : nhNodes) {
			val nodeAND = node as AbstractNodeDescriptor
			if (!Util.toLocalNode(nodeAND).types.empty) {
				totalDegree = 0.0
				for (child : nodeAND.lookup(AND2children)) {

					for (inEdge : child.incomingEdges.keySet) {
						val edgeDesc = inEdge as IncomingRelation<AbstractNodeDescriptor>
						val edgeName = edgeDesc.type
						allDimensions.add(edgeName)
						numToAdd = inEdge.lookup(child.incomingEdges) as Integer

						totalDegree += numToAdd
						if (type2Num.keySet.contains(edgeName)) {
							type2Num.put(edgeName, edgeName.lookup(type2Num) + numToAdd)
						} else {
							type2Num.put(edgeName, numToAdd)
						}

					}

					for (outEdge : child.outgoingEdges.keySet) {
						val edgeDesc = outEdge as OutgoingRelation<AbstractNodeDescriptor>
						val edgeName = edgeDesc.type
						allDimensions.add(edgeName)
						numToAdd = outEdge.lookup(child.outgoingEdges) as Integer

						totalDegree += numToAdd
						if (type2Num.keySet.contains(edgeName)) {
							type2Num.put(edgeName, edgeName.lookup(type2Num) + numToAdd)
						} else {
							type2Num.put(edgeName, numToAdd)
						}

					}
				}
				
				// Measure preliminary results for MPC
				partialMPC = 1.0
				for (degree : type2Num.values) {
					partialMPC -= Math.pow(degree.floatValue / totalDegree, 2)
				}

				val numOccurrences = node.lookup(nhRep) as Integer
				numNodes += numOccurrences

				totalMPC += partialMPC * numOccurrences
				type2Num.clear
			}

		}

		val totalNumDims = allDimensions.size
		
		var averageMPC = 0.0
		if ( totalNumDims.floatValue * totalMPC != 0) {
			averageMPC = ( totalNumDims.floatValue / (totalNumDims - 1) ) * (totalMPC / numNodes)
		}
		
		return averageMPC
	}
}