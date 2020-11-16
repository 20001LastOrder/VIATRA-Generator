package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EAttributeMapper_RelationsOverTypes;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;

@SuppressWarnings("all")
public class EAttributeMapper_RelationsOverTypes_Trace implements Trace<EAttributeMapper_RelationsOverTypes> {
  public Map<EAttribute, RelationDeclaration> indicators = new HashMap<EAttribute, RelationDeclaration>();
  
  public Map<EAttribute, Assertion> typeCompliance = new HashMap<EAttribute, Assertion>();
  
  public Map<EAttribute, Assertion> lowerMultiplicity = new HashMap<EAttribute, Assertion>();
  
  public Map<EAttribute, Assertion> upperMultiplicity = new HashMap<EAttribute, Assertion>();
}
