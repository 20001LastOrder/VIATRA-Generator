package ca.mcgill.ecse.dslreasoner.realistic.metrics.examples

import hu.bme.mit.inf.dslreasoner.domains.yakindu.sgraph.yakindumm.YakindummPackage
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.AbstractNodeDescriptor
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.IncomingRelation
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.Neighbourhood2ShapeGraph
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelation
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.PartialInterpretation2ImmutableTypeLattice
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation
import hu.bme.mit.inf.dslreasoner.workspace.FileSystemWorkspace
import java.io.PrintWriter
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import linkedList.LinkedListPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.query.runtime.rete.matcher.ReteEngine

import static extension hu.bme.mit.inf.dslreasoner.util.CollectionsUtil.*
import org.eclipse.emf.ecore.EClass
import java.util.EventObject
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.GraphShape
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelationGND
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.GraphNodeDescriptorGND
import org.eclipse.emf.ecore.impl.EReferenceImpl

class MetricsCalculationUsingShapes {

	static val neighbourhoodComputer = new PartialInterpretation2ImmutableTypeLattice

	static val neighbouhood2ShapeGraph = new Neighbourhood2ShapeGraph
	private static DecimalFormat df = new DecimalFormat("0.000");
	private static final Integer NUMMEASUREMENTS = 10
	private static final Integer NUMNA = 2
	private static final Integer NUMMPC = 4
	private static final Integer NUMNDA = 6

	def static void main(String[] args) {
		df.roundingMode = RoundingMode.UP
		val outputFolder = "outputs//calculatedMetrics//stats//"

		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("*", new XMIResourceFactoryImpl)
		YakindummPackage.eINSTANCE.eClass
		LinkedListPackage.eINSTANCE.eClass
		ReteEngine.getClass

		val fileDir = "Human//"
		val outputFileName = "stats.csv"
		val inputs = "inputs//" + fileDir
//		val inputs = "resources//" // TESTING
		val workspace = new FileSystemWorkspace(inputs, "")

		// Where we stor metric values
		var List<List<String>> metricValues = newArrayList
		for (var i = 0; i < NUMMEASUREMENTS; i++) {
			metricValues.add(newArrayList)
		}

		// Where we store deltas
		var List<Double> totalDeltas = newArrayList
		var List<List<String>> deltas = newArrayList
		for (var i = 0; i < NUMMEASUREMENTS; i++) {
			deltas.add(newArrayList)
			totalDeltas.add(0.0)
		}

		var calcVal = 0.0
		var realVal = 0.0
		var progressTracker = 0
		for (fileName : workspace.allFiles.subList(240, 440)) {
//		for (fileName : newArrayList("sampleList.xmi")) { // TESTING
			print(progressTracker++ + "-")
			val nameWOExt = fileName.substring(0, fileName.indexOf("."))
			val model = workspace.readModel(EObject, fileName)
			val partialModel = Util.getPartialModel(workspace, model)

			// /////////////
			// NODE ACTIVITY
			// /////////////
			// Calculate NA from partial model
			realVal = getNAfromModel(model)
			metricValues.get(0).add(df.format(realVal))
			// Calculate NA from neighbourhood shape
			calcVal = getNAfromNHShape(partialModel)
			metricValues.get(1).add(df.format(calcVal))
			// Calculate delta
			totalDeltas.set(0, totalDeltas.get(0) + (Math.abs((calcVal - realVal) / realVal * 100)))

			// /////////////
			// Multiplex Participation Coeffifcient
			// /////////////
			// Calculate MPC from partial model
			realVal = getMPCfromModel(model)
			metricValues.get(2).add(df.format(realVal))
			// Calculate MPC from neighbourhood shape
			calcVal = getMPCfromNHShape(partialModel)
			metricValues.get(3).add(df.format(calcVal))
			// Calculate delta
			totalDeltas.set(1, totalDeltas.get(1) + (Math.abs((calcVal - realVal) / realVal * 100)))

			// /////////////
			// Node Dimension Activity
			// /////////////
			// Calculate MPC from partial model
			realVal = getNDAfromModel(model)
			metricValues.get(4).add(df.format(realVal))

			// Calculate MPC from neighbourhood shape
			calcVal = getNDAfromNHShape(partialModel)
			metricValues.get(5).add(df.format(calcVal))
			// Calculate delta
			totalDeltas.set(2, totalDeltas.get(2) + (Math.abs((calcVal - realVal) / realVal * 100)))

			// /////////////
			// Node Dimension Connectivity
			// /////////////
			// Calculate MPC from partial model
			realVal = getNDCfromModel(model)
			metricValues.get(6).add(df.format(realVal))

			// Calculate MPC from neighbourhood shape
			calcVal = getNDCfromNHShape(partialModel)
			metricValues.get(7).add(df.format(calcVal))
			// Calculate delta
			totalDeltas.set(3, totalDeltas.get(3) + (Math.abs((calcVal - realVal) / realVal * 100)))

			// /////////////
			// Edge Dimension Activity
			// /////////////
			// Calculate MPC from partial model
			realVal = getEDAfromModel(model)
			metricValues.get(8).add(df.format(realVal))

			// Calculate MPC from neighbourhood shape
			calcVal = getEDAfromNHShape(partialModel, 2)
			metricValues.get(9).add(df.format(calcVal))
			// Calculate delta
			deltas.get(0).add( df.format(Math.abs((calcVal - realVal) / realVal * 100)))
			totalDeltas.set(4, totalDeltas.get(4) + (Math.abs((calcVal - realVal) / realVal * 100)))
		// /////////////
		// new metric
		// /////////////
		// Calculate MPC from partial model
//			for (var i = 0; i < NUMMEASUREMENTS - 3; i++) {
//				// Calculate MPC from neighbourhood shape
//				metricVal = getMPCfromNHShape(partialModel, i)
//				metricValues.get(i + 3).add(df.format(metricVal))
//				val deltaVal = metricVal - Double.valueOf(metricValues.get(2).get(metricValues.get(2).length - 1))
////				deltas.add(i+3, deltas.get(i+3) + Math.abs(deltaVal)) 
//				deltas.get(i + 3).add(df.format(Math.abs(deltaVal)))
//
//			}
		}

		// Write to .csv
		val headers = newArrayList("NA,Model,", "NA,Shape,", "MPC,Model,", "MPC,Shape,", "NDA,Model,", "NDA,Shape,",
			"NDC,Model,", "NDC,Shape,", "EDA,Model,", "EDA,Shape,", "EDA,Deltas,")
		var writer = new PrintWriter(outputFolder + "statsNA.csv")
		for (var i = 0; i < NUMNA; i++) {
			writer.append(headers.get(i))
			writer.append(String.join(",", metricValues.get(i)))
			writer.append("\n");
		}
		writer.close

		writer = new PrintWriter(outputFolder + "statsMPC.csv")
		for (var i = NUMNA; i < MetricsCalculationUsingShapes.NUMMPC; i++) {
			writer.append(headers.get(i))
			writer.append(String.join(",", metricValues.get(i)))
			writer.append("\n");
		}
		writer.close

		writer = new PrintWriter(outputFolder + "statsEDA.csv")
		for (var i = 8; i < 10; i++) {
			writer.append(headers.get(i))
			writer.append(String.join(",", metricValues.get(i)))
			writer.append("\n");
		}
		writer.append(headers.get(10))
		writer.append(String.join(",", deltas.get(0)))
		writer.append("\n");

		writer.close
		// print Results
		val numModels = metricValues.get(0).length
		println()
		println("Node Activity:")
		println("from Partial Model: " + metricValues.get(0))
		println("from NH Shape     : " + metricValues.get(1))
		println("       Avg % delta: " + df.format(totalDeltas.get(0) / numModels))

		println("MPC:")
		println("from Partial Model: " + metricValues.get(2))
		println("from NH Shape     : " + metricValues.get(3))
		println("       Avg % delta: " + df.format(totalDeltas.get(1) / numModels))

		println("NDA:")
		println("from Partial Model: " + metricValues.get(4))
		println("from NH Shape     : " + metricValues.get(5))
		println("       Avg % delta: " + df.format(totalDeltas.get(2) / numModels))

		println("NDC:")
		println("from Partial Model: " + metricValues.get(6))
		println("from NH Shape     : " + metricValues.get(7))
		println("       Avg % delta: " + df.format(totalDeltas.get(3) / numModels))

		println("EDA:")
		println("from Partial Model: " + metricValues.get(8))
		println("from NH Shape     : " + metricValues.get(9))
		println("       Avg % delta: " + df.format(totalDeltas.get(4) / numModels))

//		println("new metric:")
//		println("from Partial Model: " + metricValues.get(4))
//		println("-----------------")
//		for (var i = 0; i < NUMMEASUREMENTS - NUMNAMPC-1; i++) {
//			println("from NH Shape " + i + "   : " + metricValues.get(i + NUMNAMPC+1))
//			println("  avg delta=" + df.format(findSum2(deltas.get(i + NUMNAMPC+1)) / deltas.get(i+3).size) + "   " + deltas.get(i + NUMNAMPC+1))
//			println("-----------------")
//		}
	}

	def static getNAfromModel(EObject model) {
		val nodes = model.eResource.allContents.toList

		var totalNA = 0.0
		val numNodes = nodes.length

		// fill HashSet
		var Map<EObject, Set<String>> node2ActiveDims = new HashMap
		for (node : nodes) {
			node2ActiveDims.put(node, new HashSet)
		}

		// iterate over nodes and their references
		for (node : nodes) {
			for (reference : node.eClass.EAllReferences) {
				val pointingTo = node.eGet(reference)

				if (!(pointingTo instanceof List)) {
					if (pointingTo !== null) {
						// Add for source
						node.lookup(node2ActiveDims).add(reference.name)
						// Add for target
						(pointingTo as EObject).lookup(node2ActiveDims).add(reference.name)
					}
				} else {
					val pointingToSet = pointingTo as List
					if (!pointingToSet.empty) {
						for (target : pointingToSet) {
							// Add for source
							node.lookup(node2ActiveDims).add(reference.name)
							// Add for target
							(target as EObject).lookup(node2ActiveDims).add(reference.name)
						}
					}
				}
			}
		}

		// Measure NA
		for (activeDims : node2ActiveDims.values) {
			totalNA += activeDims.length
		}

		val averageNA = totalNA / numNodes

		return averageNA
	}

	def static getNAfromNHLattice(PartialInterpretation partialModel) {
		// Get required neighbourhoods
		val nh = neighbourhoodComputer.createRepresentation(partialModel, 2, Integer.MAX_VALUE, Integer.MAX_VALUE)
		val nhDeepRep = nh.modelRepresentation as HashMap
		val nhRep = neighbourhoodComputer.createRepresentation(partialModel, 1, Integer.MAX_VALUE, Integer.MAX_VALUE).
			modelRepresentation as HashMap
		val nhDeepNodes = nhDeepRep.keySet
		val nhNodes = nhRep.keySet

		// Storing active dims in a HashMap
		var Map<AbstractNodeDescriptor, Set<String>> node2ActiveDims = new HashMap

		// fill activeDims with empty lists for each node descriptor
		for (nhNode : nhNodes) {
			node2ActiveDims.put(nhNode as AbstractNodeDescriptor, new HashSet)
		}

		// populate node2ActiveDims HashMap
		for (nhDeepNode : nhDeepNodes) {
			val nhDeepNodeDesc = nhDeepNode as FurtherNodeDescriptor
			val nhParentNode = (nhDeepNodeDesc.previousRepresentation as AbstractNodeDescriptor)
			// for incoming Edges
			for (inEdge : nhDeepNodeDesc.incomingEdges.keySet) {
				val edgeDim = (inEdge as IncomingRelation).type
				nhParentNode.lookup(node2ActiveDims).add(edgeDim)
			}

			// for outgoing Edges
			for (outEdge : nhDeepNodeDesc.outgoingEdges.keySet) {
				val edgeDim = (outEdge as OutgoingRelation).type
				nhParentNode.lookup(node2ActiveDims).add(edgeDim)
			}
		}

		// Get NAs per node, considering the number of occurences in the partialModel
		var totalNA = 0.0
		var numModelElems = 0
		for (nhNode : node2ActiveDims.keySet) {
			var activeDimsForNode = nhNode.lookup(node2ActiveDims)
			var numNodeOccurences = nhNode.lookup(nhRep) as Integer

			// ASSUME THAT THERE IS NO NODE WITHOUT ANY CONNECTIONS
			// ^valid assumption because of containment edges
			if (!activeDimsForNode.empty) {
				totalNA += (activeDimsForNode.length * numNodeOccurences)
				numModelElems += numNodeOccurences
			}
		}

		// return average NA
		val averageNAwithWeight = totalNA / numModelElems
		return averageNAwithWeight

	}

	def static getNAfromNHShape(PartialInterpretation pm) {
		getNAfromNHShape(pm, 1)
	}

	def static getNAfromNHShape(PartialInterpretation partialModel, Integer depth) {
		// Get NH Shape
		val nh = neighbourhoodComputer.createRepresentation(partialModel, depth, Integer.MAX_VALUE, Integer.MAX_VALUE)
		val nhRep = nh.modelRepresentation as HashMap
		val nhShapeGraph = neighbouhood2ShapeGraph.createShapeGraph(nh, partialModel)

		// Useful variable initializations
		var totalMetricValue = 0.0
		var numNodesTotal = 0
		var Set<Object> activeDims = new HashSet

		// look at the in and out edges of each shape node
		for (node : nhShapeGraph.nodes) {
			for (inEdge : node.incomingEdges) {
				activeDims.add(inEdge.type)
			}
			for (outEdge : node.outgoingEdges) {
				activeDims.add(outEdge.type)
			}

			// Measure preliminary results for NA
			val numOccurrences = node.correspondingAND.lookup(nhRep) as Integer
			val numActDims = activeDims.length
			val totalActDims = numActDims * numOccurrences

			numNodesTotal += numOccurrences
			totalMetricValue += totalActDims
			activeDims.clear
		}

		val averageMetricValue = totalMetricValue / numNodesTotal
		return averageMetricValue

	}

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
						putInside(node, reference.name, 1, node2Degrees)
						// Add for target
						putInside((pointingTo as EObject), reference.name, 1, node2Degrees)
					}
				} else {
					val pointingToList = pointingTo as List
					if (!pointingToList.empty) {
						allDimensions.add(reference.name) // TODO
						// Add for source
						putInside(node, reference.name, pointingToList.size, node2Degrees)
						for (target : pointingToList) {
							// Add for target
							putInside((target as EObject), reference.name, 1, node2Degrees)
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
			var totalDegree = Util.sum(degrees.values)
			var partialMPC = 1.0
			for (degree : degrees.values) {
				partialMPC -= Math.pow(degree.floatValue / totalDegree, 2)
			}
			totalMPC += partialMPC
		}

		val averageMPC = ( totalNumDims.floatValue / (totalNumDims - 1) ) * (totalMPC / numNodes)
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
				numToAdd = Util.sum(inEdge.targetDistrib)

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
				numToAdd = Util.sum(outEdge.sourceDistrib)

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

	def static getNDAfromModel(EObject model) {
		val Map<EObject, Set<EObject>> dim2NumActNodes = dim2NumActNodesFromModel(model)

		var totalNDA = 0.0
		for (actNodes : dim2NumActNodes.values) {
			totalNDA += actNodes.length
		}

		val numDims = dim2NumActNodes.keySet.length
		val avgNDA = totalNDA / numDims
		return avgNDA
	}

	def static getNDAfromNHShape(PartialInterpretation pm) {
		return getNDAfromNHShape(pm, 1)
	}

	def static getNDAfromNHShape(PartialInterpretation pm, Integer depth) {
		// Get NH Shape
		val nh = neighbourhoodComputer.createRepresentation(pm, depth, Integer.MAX_VALUE, Integer.MAX_VALUE)
		val nhRep = nh.modelRepresentation as HashMap
		val nhShapeGraph = neighbouhood2ShapeGraph.createShapeGraph(nh, pm)

		// TODO make below map from OutgoingRelationGND to value
		val Map<String, Set<AbstractNodeDescriptor>> dim2NumActNodes = dim2NumActNodesFromNHShape(nhShapeGraph)

		// calculations
		var totalNDA = 0.0
		for (actNodes : dim2NumActNodes.values) {
			for (actNode : actNodes) {
				val numInstances = actNode.lookup(nhRep) as Integer
				totalNDA += numInstances
			}
		}

		val numDims = dim2NumActNodes.keySet.length
		val avgNDA = totalNDA / numDims
		return avgNDA
	}

	def static getNDCfromModel(EObject model) {

		val NDA = getNDAfromModel(model)
		val nodes = model.eResource.allContents.toList
		val numNodes = nodes.length
		val NDC = NDA / numNodes
		return NDC
	}

	def static getNDCfromNHShape(PartialInterpretation pm) {
		return getNDCfromNHShape(pm, 1)
	}

	def static getNDCfromNHShape(PartialInterpretation pm, Integer depth) {
		// Get NH Shape
		val nh = neighbourhoodComputer.createRepresentation(pm, depth, Integer.MAX_VALUE, Integer.MAX_VALUE)
		val nhRep = nh.modelRepresentation as HashMap
		val gs = neighbouhood2ShapeGraph.createShapeGraph(nh, pm)

		// calculations
		val NDA = getNDAfromNHShape(pm, depth)
		val nodes = gs.nodes
		var numNodes = 0

		// calculations
		for (node : nodes) {
			numNodes += node.correspondingAND.lookup(nhRep) as Integer
		}

		val NDC = NDA / numNodes
		return NDC
	}

	def static getEDAfromModel(EObject model) {
		val Map<EObject, Integer> dim2Occ = dim2NumOccurencesFromModel(model)

		print("Real  :")
		printer(dim2Occ)
		println()

		var totalEDA = Util.sum(dim2Occ.values)
		val numDims = dim2Occ.keySet.length
		val avgEDA = Double.valueOf(totalEDA) / numDims
		return avgEDA
	}

	def static printer(Map<EObject, Integer> map) {
		for (key : map.keySet) {
			print((key as EReferenceImpl).name + "=" + key.lookup(map) + ", ")
		}
	}

	def static getEDAfromNHShape(PartialInterpretation pm) {
		return getEDAfromNHShape(pm, 1)
	}

	def static getEDAfromNHShape(PartialInterpretation pm, Integer depth) {
		// Get NH Shape
		val nh = neighbourhoodComputer.createRepresentation(pm, depth, Integer.MAX_VALUE, Integer.MAX_VALUE)
		val nhRep = nh.modelRepresentation as HashMap
		val gs = neighbouhood2ShapeGraph.createShapeGraph(nh, pm)

		// TODO make below map from OutgoingRelationGND to value
		// calculations
		val nodes = gs.nodes as List<GraphNodeDescriptorGND>

		val Map<String, Integer> dim2Occ = new HashMap
		var newVal = 0
		for (node : nodes) {
			for (dim : node.outgoingEdges) {
				val dimName = dim.type
				val numNodeOcc = node.correspondingAND.lookup(nhRep) as Integer
				val numNodeChildren = dim.sourceDistrib.size

				val toNode = dim.to
				val numToNodeOcc = toNode.correspondingAND.lookup(nhRep) as Integer
				val numToNodeChildren = dim.targetDistrib.size

				val amountToAdd = (Util.sum(dim.sourceDistrib) * numNodeOcc / numNodeChildren) // +
//					Util.sum(dim.targetDistrib) * numToNodeOcc / numToNodeChildren) /2
				if (dim2Occ.keySet.contains(dimName)) {
					newVal = dimName.lookup(dim2Occ) + amountToAdd
				} else {
					newVal = amountToAdd
				}
				dim2Occ.put(dimName, newVal)
			}
		}
		println("Calc    :" + dim2Occ)
		// calculations
		var totalEDA = Util.sum(dim2Occ.values)
		val numDims = dim2Occ.keySet.length
		val avgEDA = Double.valueOf(totalEDA) / numDims
		return avgEDA
	}

	def static dim2NumActNodesFromModel(EObject model) {
		val nodes = model.eResource.allContents.toList

		val Map<EObject, Set<EObject>> dim2NumActNodes = new HashMap

		for (node : nodes) {
			for (dim : node.eClass.EAllReferences) {
				val srcNode = node
				val trgNode = node.eGet(dim)

				if (!(trgNode instanceof List)) {
					if (trgNode !== null) {
						if (dim2NumActNodes.keySet.contains(dim)) {
							dim.lookup(dim2NumActNodes).add(srcNode)
						} else {
							dim2NumActNodes.put(dim, newHashSet(srcNode))
						}
						dim.lookup(dim2NumActNodes).addAll(trgNode as EObject)
					}
				} else {
					val trgSet = trgNode as List
					if (!trgSet.empty) {
						if (dim2NumActNodes.keySet.contains(dim)) {
							dim.lookup(dim2NumActNodes).addAll(srcNode)
						} else {
							dim2NumActNodes.put(dim, newHashSet(srcNode))
						}
						for (target : trgSet) {
							dim.lookup(dim2NumActNodes).add(target as EObject)
						}
					}
				}
			}
		}

		return dim2NumActNodes
	}

	def static dim2NumActNodesFromNHShape(GraphShape gs) {
		val nodes = gs.nodes as List<GraphNodeDescriptorGND>

		val Map<String, Set<AbstractNodeDescriptor>> dim2NumActNodes = new HashMap

		for (node : nodes) {
			for (dim : node.outgoingEdges) {
				val dimName = dim.type

				val srcName = node.correspondingAND
				val trgName = dim.to.correspondingAND

				if (dim2NumActNodes.keySet.contains(dimName)) {
					dimName.lookup(dim2NumActNodes).add(srcName)
				} else {
					dim2NumActNodes.put(dimName, newHashSet(srcName))
				}
				dimName.lookup(dim2NumActNodes).addAll(trgName)
			}
		}

		return dim2NumActNodes
	}

	def static dim2NumOccurencesFromModel(EObject model) {
		val nodes = model.eResource.allContents.toList

		val Map<EObject, Integer> dim2Occurences = new HashMap
		var newVal = 0
		for (node : nodes) {
			for (dim : node.eClass.EAllReferences) {
				val target = node.eGet(dim)

				if (!(target instanceof List)) {
					if (target !== null) {
						if (dim2Occurences.keySet.contains(dim)) {
							newVal = dim.lookup(dim2Occurences) + 1
						} else {
							newVal = 1
						}
						dim2Occurences.put(dim, newVal)
					}
				} else {
					val trgSet = target as List
					if (!trgSet.empty) {
						if (dim2Occurences.keySet.contains(dim)) {
							newVal = dim.lookup(dim2Occurences) + trgSet.length
						} else {
							newVal = trgSet.length
						}
						dim2Occurences.put(dim, newVal)
					}
				}
			}
		}

		return dim2Occurences
	}

	def static putInside(EObject object, String string, int i, Map<EObject, Map<String, Integer>> map) {
		val Map<String, Integer> correspondingMap = object.lookup(map)
		if (correspondingMap.keySet.contains(string)) {
			correspondingMap.put(string, string.lookup(correspondingMap) + i)
		} else {
			correspondingMap.put(string, i)
		}
	}

	def static printMap(Map<String, Set<String>> map) {
		for (key : map.keySet) {
			println(key + " -> " + key.lookup(map))
		}
	}

}
