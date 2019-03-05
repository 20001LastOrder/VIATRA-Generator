package ca.mcgill.ecse.dslreasoner.vampire.icse;

import ca.mcgill.ecse.dslreasoner.vampire.icse.GeneralTest;
import ca.mcgill.ecse.dslreasoner.vampire.queries.FamPatterns;
import functionalarchitecture.FunctionalarchitecturePackage;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EcoreMetamodelDescriptor;
import hu.bme.mit.inf.dslreasoner.viatra2logic.ViatraQuerySetDescriptor;
import hu.bme.mit.inf.dslreasoner.workspace.FileSystemWorkspace;
import java.util.LinkedList;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class FAMTest {
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("initialModels/");
    final FileSystemWorkspace inputs = new FileSystemWorkspace(_builder.toString(), "");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("output/FAMTest/");
    final FileSystemWorkspace workspace = new FileSystemWorkspace(_builder_1.toString(), "");
    workspace.initAndClear();
    final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
    final Map<String, Object> map = reg.getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    map.put("logicproblem", _xMIResourceFactoryImpl);
    InputOutput.<String>println("Input and output workspaces are created");
    final EcoreMetamodelDescriptor metamodel = GeneralTest.loadMetamodel(FunctionalarchitecturePackage.eINSTANCE);
    final EList<EObject> partialModel = GeneralTest.loadPartialModel(inputs, "FunctionalArchitectureModel2.xmi");
    final ViatraQuerySetDescriptor queries = GeneralTest.loadQueries(metamodel, FamPatterns.instance());
    InputOutput.<String>println("DSL loaded");
    LinkedList<EObject> _linkedList = new LinkedList<EObject>();
    GeneralTest.createAndSolveProblem(metamodel, _linkedList, queries, workspace);
  }
}
