package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("all")
public interface EReferenceMapper {
  void transformEReferences(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> classes);
  
  Iterable<EReference> allReferencesInScope(final Ecore2Logic_Trace trace);
  
  Term IsInReference(final Ecore2Logic_Trace trace, final TermDescription source, final TermDescription target, final EReference type);
  
  RelationDeclaration relationOfReference(final Ecore2Logic_Trace trace, final EReference reference);
}
