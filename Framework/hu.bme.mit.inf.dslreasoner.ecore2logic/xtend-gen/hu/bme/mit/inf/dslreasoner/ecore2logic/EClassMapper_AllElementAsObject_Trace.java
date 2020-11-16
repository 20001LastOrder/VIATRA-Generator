package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper_AllElementAsObject;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;

@SuppressWarnings("all")
public class EClassMapper_AllElementAsObject_Trace implements Trace<EClassMapper_AllElementAsObject> {
  public Map<EClass, Type> typeMap = new HashMap<EClass, Type>();
}
