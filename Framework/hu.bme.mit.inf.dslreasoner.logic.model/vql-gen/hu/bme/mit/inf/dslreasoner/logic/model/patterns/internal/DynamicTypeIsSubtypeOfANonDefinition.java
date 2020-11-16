/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal;

import hu.bme.mit.inf.dslreasoner.logic.model.patterns.SupertypeStar;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.TypeDirectElements;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecificationWithGenericMatcher;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate GenericPatternMatcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         supertype -------{@literal >} element {@literal <}---X--- otherSupertype
 *               A                                     A
 *               |                                     |
 *           wrongDynamic -----------------------------+
 *          
 *         private pattern dynamicTypeIsSubtypeOfANonDefinition(problem: LogicProblem, element:DefinedElement, wrongDynamic:Type) {
 *         	LogicProblem.types(problem,wrongDynamic);
 *         	find typeDirectElements(supertype, element);
 *         	find supertypeStar(wrongDynamic, supertype);
 *         	find supertypeStar(wrongDynamic, otherSupertype);
 *         	TypeDefinition(otherSupertype);
 *         	neg find typeDirectElements(otherSupertype, element);
 *         }
 * </pre></code>
 * 
 * @see GenericPatternMatcher
 * @see GenericPatternMatch
 * 
 */
@SuppressWarnings("all")
public final class DynamicTypeIsSubtypeOfANonDefinition extends BaseGeneratedEMFQuerySpecificationWithGenericMatcher {
  private DynamicTypeIsSubtypeOfANonDefinition() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static DynamicTypeIsSubtypeOfANonDefinition instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  /**
   * Inner class allowing the singleton instance of {@link DynamicTypeIsSubtypeOfANonDefinition} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link DynamicTypeIsSubtypeOfANonDefinition#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final DynamicTypeIsSubtypeOfANonDefinition INSTANCE = new DynamicTypeIsSubtypeOfANonDefinition();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final DynamicTypeIsSubtypeOfANonDefinition.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_problem = new PParameter("problem", "hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")), PParameterDirection.INOUT);
    
    private final PParameter parameter_element = new PParameter("element", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_wrongDynamic = new PParameter("wrongDynamic", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_problem, parameter_element, parameter_wrongDynamic);
    
    private GeneratedPQuery() {
      super(PVisibility.PRIVATE);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.dynamicTypeIsSubtypeOfANonDefinition";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("problem","element","wrongDynamic");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_problem = body.getOrCreateVariableByName("problem");
          PVariable var_element = body.getOrCreateVariableByName("element");
          PVariable var_wrongDynamic = body.getOrCreateVariableByName("wrongDynamic");
          PVariable var_supertype = body.getOrCreateVariableByName("supertype");
          PVariable var_otherSupertype = body.getOrCreateVariableByName("otherSupertype");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_wrongDynamic), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_problem, parameter_problem),
             new ExportedParameter(body, var_element, parameter_element),
             new ExportedParameter(body, var_wrongDynamic, parameter_wrongDynamic)
          ));
          // 	LogicProblem.types(problem,wrongDynamic)
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem", "types")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new Equality(body, var__virtual_0_, var_wrongDynamic);
          // 	find typeDirectElements(supertype, element)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_supertype, var_element), TypeDirectElements.instance().getInternalQueryRepresentation());
          // 	find supertypeStar(wrongDynamic, supertype)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_wrongDynamic, var_supertype), SupertypeStar.instance().getInternalQueryRepresentation());
          // 	find supertypeStar(wrongDynamic, otherSupertype)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_wrongDynamic, var_otherSupertype), SupertypeStar.instance().getInternalQueryRepresentation());
          // 	TypeDefinition(otherSupertype)
          new TypeConstraint(body, Tuples.flatTupleOf(var_otherSupertype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDefinition")));
          // 	neg find typeDirectElements(otherSupertype, element)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_otherSupertype, var_element), TypeDirectElements.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
