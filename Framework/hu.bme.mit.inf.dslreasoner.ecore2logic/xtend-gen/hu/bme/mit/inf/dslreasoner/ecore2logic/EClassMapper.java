package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EcoreMetamodelDescriptor;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import org.eclipse.emf.ecore.EClass;

@SuppressWarnings("all")
public interface EClassMapper {
  void transformEClasses(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EClass> classes, final int numberOfObjects, final EcoreMetamodelDescriptor metamodelDescriptor);
  
  Iterable<EClass> allClassesInScope(final Ecore2Logic_Trace trace);
  
  Type TypeofEClass(final Ecore2Logic_Trace trace, final EClass type);
}
