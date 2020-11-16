package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDescriptor;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import org.eclipse.emf.ecore.EAttribute;

@SuppressWarnings("all")
public interface EAttributeMapper {
  void transformEAttributes(final Ecore2Logic_Trace trace, final LogicProblem logicProblem, final Iterable<EAttribute> attributes);
  
  Term IsAttributeValue(final Ecore2Logic_Trace trace, final TermDescription object, final TermDescription value, final EAttribute attribute);
  
  RelationDeclaration relationOfAttribute(final Ecore2Logic_Trace trace, final EAttribute attribute);
  
  TypeDescriptor TypeOfRange(final Ecore2Logic_Trace trace, final EAttribute attribute);
  
  Iterable<EAttribute> allAttributesInScope(final Ecore2Logic_Trace trace);
}
