package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.ContainmentMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EReferenceMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Function;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.ContainmentHierarchy;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import java.util.Collections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ContainmentMapper_ReferenceConjuction implements ContainmentMapper {
  @Extension
  private final LogicProblemBuilder builder = new LogicProblemBuilder();
  
  @Extension
  private final EClassMapper classMapper;
  
  @Extension
  private final EReferenceMapper referenceMapper;
  
  private final int containmentAcyclicityApproximationLevel;
  
  public ContainmentMapper_ReferenceConjuction(final EClassMapper classMapper, final EReferenceMapper referenceMapper, final int containmentAcyclicityApproximationLevel) {
    this.classMapper = classMapper;
    this.referenceMapper = referenceMapper;
    this.containmentAcyclicityApproximationLevel = containmentAcyclicityApproximationLevel;
  }
  
  @Override
  public void transformContainment(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> references, final boolean singleRoot) {
    final Function1<EClass, Type> _function = (EClass it) -> {
      return this.classMapper.TypeofEClass(trace, it);
    };
    final Iterable<Type> allClasses = IterableExtensions.<EClass, Type>map(this.classMapper.allClassesInScope(trace), _function);
    final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
      return Boolean.valueOf(it.isContainment());
    };
    final Function1<EReference, RelationDeclaration> _function_2 = (EReference it) -> {
      return this.referenceMapper.relationOfReference(trace, it);
    };
    final Iterable<RelationDeclaration> containmentRelation = IterableExtensions.<EReference, RelationDeclaration>map(IterableExtensions.<EReference>filter(references, _function_1), _function_2);
    final ContainmentHierarchy containmentHierarchy = this.builder.ContainmentHierarchy(allClasses, Collections.<Function>unmodifiableList(CollectionLiterals.<Function>newArrayList()), containmentRelation, null);
    this.builder.add(problem, containmentHierarchy);
  }
}
