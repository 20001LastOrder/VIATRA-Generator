package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("all")
public interface ContainmentMapper {
  void transformContainment(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> references, final boolean singleRoot);
}
