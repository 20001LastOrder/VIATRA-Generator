package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.ContainmentMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EAttributeMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EEnumMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EReferenceMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.ContainmentHierarchy;

@SuppressWarnings("all")
public class Ecore2Logic_Trace implements Trace<Ecore2Logic> {
  public ContainmentHierarchy containmentHierarchy;
  
  public Trace<? extends EClassMapper> classMapperTrace;
  
  public Trace<? extends EEnumMapper> enumMapperTrace;
  
  public Trace<? extends EReferenceMapper> referenceMapperTrace;
  
  public Trace<? extends ContainmentMapper> containmentMapperTrace;
  
  public Trace<? extends EAttributeMapper> attributeMapperTrace;
}
