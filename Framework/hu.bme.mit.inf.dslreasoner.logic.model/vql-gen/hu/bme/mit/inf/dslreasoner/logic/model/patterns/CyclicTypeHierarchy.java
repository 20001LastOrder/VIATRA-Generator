/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal.SupertypeDirect;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         {@literal @}Constraint(severity = "error",key = {t},
 *         	message="Circle in the type hierarchy"
 *         )
 *         pattern cyclicTypeHierarchy(t: Type) {
 *         	find supertypeDirect+(t,t);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class CyclicTypeHierarchy extends BaseGeneratedEMFQuerySpecification<CyclicTypeHierarchy.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.cyclicTypeHierarchy pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private Type fT;
    
    private static List<String> parameterNames = makeImmutableList("t");
    
    private Match(final Type pT) {
      this.fT = pT;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "t": return this.fT;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fT;
          default: return null;
      }
    }
    
    public Type getT() {
      return this.fT;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("t".equals(parameterName) ) {
          this.fT = (Type) newValue;
          return true;
      }
      return false;
    }
    
    public void setT(final Type pT) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fT = pT;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.cyclicTypeHierarchy";
    }
    
    @Override
    public List<String> parameterNames() {
      return CyclicTypeHierarchy.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fT};
    }
    
    @Override
    public CyclicTypeHierarchy.Match toImmutable() {
      return isMutable() ? newMatch(fT) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"t\"=" + prettyPrintValue(fT));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fT);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof CyclicTypeHierarchy.Match)) {
          CyclicTypeHierarchy.Match other = (CyclicTypeHierarchy.Match) obj;
          return Objects.equals(fT, other.fT);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }
    
    @Override
    public CyclicTypeHierarchy specification() {
      return CyclicTypeHierarchy.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static CyclicTypeHierarchy.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static CyclicTypeHierarchy.Match newMutableMatch(final Type pT) {
      return new Mutable(pT);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static CyclicTypeHierarchy.Match newMatch(final Type pT) {
      return new Immutable(pT);
    }
    
    private static final class Mutable extends CyclicTypeHierarchy.Match {
      Mutable(final Type pT) {
        super(pT);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends CyclicTypeHierarchy.Match {
      Immutable(final Type pT) {
        super(pT);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.cyclicTypeHierarchy pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * {@literal @}Constraint(severity = "error",key = {t},
   * 	message="Circle in the type hierarchy"
   * )
   * pattern cyclicTypeHierarchy(t: Type) {
   * 	find supertypeDirect+(t,t);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see CyclicTypeHierarchy
   * 
   */
  public static class Matcher extends BaseMatcher<CyclicTypeHierarchy.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static CyclicTypeHierarchy.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }
    
    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static CyclicTypeHierarchy.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_T = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CyclicTypeHierarchy.Matcher.class);
    
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }
    
    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<CyclicTypeHierarchy.Match> getAllMatches(final Type pT) {
      return rawStreamAllMatches(new Object[]{pT}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<CyclicTypeHierarchy.Match> streamAllMatches(final Type pT) {
      return rawStreamAllMatches(new Object[]{pT});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<CyclicTypeHierarchy.Match> getOneArbitraryMatch(final Type pT) {
      return rawGetOneArbitraryMatch(new Object[]{pT});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Type pT) {
      return rawHasMatch(new Object[]{pT});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Type pT) {
      return rawCountMatches(new Object[]{pT});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Type pT, final Consumer<? super CyclicTypeHierarchy.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pT}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pT the fixed value of pattern parameter t, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public CyclicTypeHierarchy.Match newMatch(final Type pT) {
      return CyclicTypeHierarchy.Match.newMatch(pT);
    }
    
    /**
     * Retrieve the set of values that occur in matches for t.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOft(final Object[] parameters) {
      return rawStreamAllValues(POSITION_T, parameters).map(Type.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for t.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOft() {
      return rawStreamAllValuesOft(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for t.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOft() {
      return rawStreamAllValuesOft(emptyArray());
    }
    
    @Override
    protected CyclicTypeHierarchy.Match tupleToMatch(final Tuple t) {
      try {
          return CyclicTypeHierarchy.Match.newMatch((Type) t.get(POSITION_T));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CyclicTypeHierarchy.Match arrayToMatch(final Object[] match) {
      try {
          return CyclicTypeHierarchy.Match.newMatch((Type) match[POSITION_T]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CyclicTypeHierarchy.Match arrayToMatchMutable(final Object[] match) {
      try {
          return CyclicTypeHierarchy.Match.newMutableMatch((Type) match[POSITION_T]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<CyclicTypeHierarchy.Matcher> querySpecification() {
      return CyclicTypeHierarchy.instance();
    }
  }
  
  private CyclicTypeHierarchy() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static CyclicTypeHierarchy instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected CyclicTypeHierarchy.Matcher instantiate(final ViatraQueryEngine engine) {
    return CyclicTypeHierarchy.Matcher.on(engine);
  }
  
  @Override
  public CyclicTypeHierarchy.Matcher instantiate() {
    return CyclicTypeHierarchy.Matcher.create();
  }
  
  @Override
  public CyclicTypeHierarchy.Match newEmptyMatch() {
    return CyclicTypeHierarchy.Match.newEmptyMatch();
  }
  
  @Override
  public CyclicTypeHierarchy.Match newMatch(final Object... parameters) {
    return CyclicTypeHierarchy.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link CyclicTypeHierarchy} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link CyclicTypeHierarchy#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final CyclicTypeHierarchy INSTANCE = new CyclicTypeHierarchy();
    
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
    private static final CyclicTypeHierarchy.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_t = new PParameter("t", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_t);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.cyclicTypeHierarchy";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("t");
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
          PVariable var_t = body.getOrCreateVariableByName("t");
          new TypeConstraint(body, Tuples.flatTupleOf(var_t), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_t, parameter_t)
          ));
          // 	find supertypeDirect+(t,t)
          new BinaryTransitiveClosure(body, Tuples.flatTupleOf(var_t, var_t), SupertypeDirect.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      {
          PAnnotation annotation = new PAnnotation("Constraint");
          annotation.addAttribute("severity", "error");
          annotation.addAttribute("key", Arrays.asList(new Object[] {
                              new ParameterReference("t")
                              }));
          annotation.addAttribute("message", "Circle in the type hierarchy");
          addAnnotation(annotation);
      }
      return bodies;
    }
  }
}
