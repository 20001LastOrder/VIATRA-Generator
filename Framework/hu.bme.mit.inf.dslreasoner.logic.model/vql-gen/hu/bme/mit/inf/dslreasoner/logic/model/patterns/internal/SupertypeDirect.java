/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal;

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
 *         /// Basic util patterns ///
 *         
 *         
 *           Direct supertypes of a type.
 *          
 *         private pattern supertypeDirect(subtype : Type, supertype : Type) {
 *         	Type.supertypes(subtype, supertype);
 *         }
 * </pre></code>
 * 
 * @see GenericPatternMatcher
 * @see GenericPatternMatch
 * 
 */
@SuppressWarnings("all")
public final class SupertypeDirect extends BaseGeneratedEMFQuerySpecificationWithGenericMatcher {
  private SupertypeDirect() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SupertypeDirect instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  /**
   * Inner class allowing the singleton instance of {@link SupertypeDirect} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SupertypeDirect#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SupertypeDirect INSTANCE = new SupertypeDirect();
    
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
    private static final SupertypeDirect.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_subtype = new PParameter("subtype", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final PParameter parameter_supertype = new PParameter("supertype", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_subtype, parameter_supertype);
    
    private GeneratedPQuery() {
      super(PVisibility.PRIVATE);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.supertypeDirect";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("subtype","supertype");
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
          PVariable var_subtype = body.getOrCreateVariableByName("subtype");
          PVariable var_supertype = body.getOrCreateVariableByName("supertype");
          new TypeConstraint(body, Tuples.flatTupleOf(var_subtype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_supertype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_subtype, parameter_subtype),
             new ExportedParameter(body, var_supertype, parameter_supertype)
          ));
          // 	Type.supertypes(subtype, supertype)
          new TypeConstraint(body, Tuples.flatTupleOf(var_subtype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_subtype, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type", "supertypes")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new Equality(body, var__virtual_0_, var_supertype);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
