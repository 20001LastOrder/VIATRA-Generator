package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EEnumMapper_PredefinedClasses;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import java.util.Map;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;

@SuppressWarnings("all")
public class EEnumMapper_PredefinedClasses_Trace implements Trace<EEnumMapper_PredefinedClasses> {
  public Map<EEnum, Type> enums;
  
  public Map<Enumerator, DefinedElement> literals;
}
