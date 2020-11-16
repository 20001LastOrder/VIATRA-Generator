package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EReferenceMapper_RelationsOverTypes;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import java.util.Map;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("all")
public class EReferenceMapper_RelationsOverTypes_Trace implements Trace<EReferenceMapper_RelationsOverTypes> {
  public Map<EReference, RelationDeclaration> indicators;
  
  public Map<EReference, Assertion> typeCompliance;
  
  public Map<EReference, Assertion> lowerMultiplicity;
  
  public Map<EReference, Assertion> upperMultiplicity;
  
  public Map<EReference, Assertion> inverseEdges;
}
