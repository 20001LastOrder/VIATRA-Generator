package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2LogicConfiguration;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;

@SuppressWarnings("all")
public interface EEnumMapper {
  void transformEEnums(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EEnum> enums, final Ecore2LogicConfiguration config);
  
  Type TypeofEEnum(final Ecore2Logic_Trace trace, final EEnum type);
  
  TermDescription Literal(final Ecore2Logic_Trace trace, final Enumerator literal);
  
  Iterable<EEnum> allEnumsInScope(final Ecore2Logic_Trace trace);
  
  Iterable<Enumerator> allLiteralsInScope(final Ecore2Logic_Trace trace);
}
