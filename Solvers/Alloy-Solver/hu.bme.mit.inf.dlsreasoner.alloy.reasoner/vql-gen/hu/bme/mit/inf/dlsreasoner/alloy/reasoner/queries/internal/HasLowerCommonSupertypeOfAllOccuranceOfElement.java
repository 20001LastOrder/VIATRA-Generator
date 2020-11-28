/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/typeQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.Supertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.TypeContainsAllOccuranceOfElement;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecificationWithGenericMatcher;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
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
 *         private pattern hasLowerCommonSupertypeOfAllOccuranceOfElement(element: DefinedElement, type: Type, lower: Type) {
 *         	find typeContainsAllOccuranceOfElement(element, type);
 *         	find typeContainsAllOccuranceOfElement(element, lower);
 *         	find supertype(lower, type);
 *         	type != lower;
 *         }
 * </pre></code>
 * 
 * @see GenericPatternMatcher
 * @see GenericPatternMatch
 * 
 */
@SuppressWarnings("all")
public final class HasLowerCommonSupertypeOfAllOccuranceOfElement extends BaseGeneratedEMFQuerySpecificationWithGenericMatcher {
  private HasLowerCommonSupertypeOfAllOccuranceOfElement() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HasLowerCommonSupertypeOfAllOccuranceOfElement instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  /**
   * Inner class allowing the singleton instance of {@link HasLowerCommonSupertypeOfAllOccuranceOfElement} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link HasLowerCommonSupertypeOfAllOccuranceOfElement#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HasLowerCommonSupertypeOfAllOccuranceOfElement INSTANCE = new HasLowerCommonSupertypeOfAllOccuranceOfElement();
    
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
    private static final HasLowerCommonSupertypeOfAllOccuranceOfElement.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_element = new PParameter("element", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_type = new PParameter("type", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final PParameter parameter_lower = new PParameter("lower", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_element, parameter_type, parameter_lower);
    
    private GeneratedPQuery() {
      super(PVisibility.PRIVATE);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.hasLowerCommonSupertypeOfAllOccuranceOfElement";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("element","type","lower");
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
          PVariable var_element = body.getOrCreateVariableByName("element");
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var_lower = body.getOrCreateVariableByName("lower");
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_lower), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_element, parameter_element),
             new ExportedParameter(body, var_type, parameter_type),
             new ExportedParameter(body, var_lower, parameter_lower)
          ));
          // 	find typeContainsAllOccuranceOfElement(element, type)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_element, var_type), TypeContainsAllOccuranceOfElement.instance().getInternalQueryRepresentation());
          // 	find typeContainsAllOccuranceOfElement(element, lower)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_element, var_lower), TypeContainsAllOccuranceOfElement.instance().getInternalQueryRepresentation());
          // 	find supertype(lower, type)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_lower, var_type), Supertype.instance().getInternalQueryRepresentation());
          // 	type != lower
          new Inequality(body, var_type, var_lower);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
