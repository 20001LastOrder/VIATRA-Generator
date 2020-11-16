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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
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
 *         All supertypes of a type.
 *          
 *         pattern supertypeStar(subtype: Type, supertype: Type) {
 *         	subtype == supertype;
 *         } or {
 *         	find supertypeDirect+(subtype,supertype);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SupertypeStar extends BaseGeneratedEMFQuerySpecification<SupertypeStar.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.supertypeStar pattern,
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
    private Type fSubtype;
    
    private Type fSupertype;
    
    private static List<String> parameterNames = makeImmutableList("subtype", "supertype");
    
    private Match(final Type pSubtype, final Type pSupertype) {
      this.fSubtype = pSubtype;
      this.fSupertype = pSupertype;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "subtype": return this.fSubtype;
          case "supertype": return this.fSupertype;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSubtype;
          case 1: return this.fSupertype;
          default: return null;
      }
    }
    
    public Type getSubtype() {
      return this.fSubtype;
    }
    
    public Type getSupertype() {
      return this.fSupertype;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("subtype".equals(parameterName) ) {
          this.fSubtype = (Type) newValue;
          return true;
      }
      if ("supertype".equals(parameterName) ) {
          this.fSupertype = (Type) newValue;
          return true;
      }
      return false;
    }
    
    public void setSubtype(final Type pSubtype) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSubtype = pSubtype;
    }
    
    public void setSupertype(final Type pSupertype) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSupertype = pSupertype;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.supertypeStar";
    }
    
    @Override
    public List<String> parameterNames() {
      return SupertypeStar.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fSubtype, fSupertype};
    }
    
    @Override
    public SupertypeStar.Match toImmutable() {
      return isMutable() ? newMatch(fSubtype, fSupertype) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"subtype\"=" + prettyPrintValue(fSubtype) + ", ");
      result.append("\"supertype\"=" + prettyPrintValue(fSupertype));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fSubtype, fSupertype);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SupertypeStar.Match)) {
          SupertypeStar.Match other = (SupertypeStar.Match) obj;
          return Objects.equals(fSubtype, other.fSubtype) && Objects.equals(fSupertype, other.fSupertype);
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
    public SupertypeStar specification() {
      return SupertypeStar.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SupertypeStar.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SupertypeStar.Match newMutableMatch(final Type pSubtype, final Type pSupertype) {
      return new Mutable(pSubtype, pSupertype);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SupertypeStar.Match newMatch(final Type pSubtype, final Type pSupertype) {
      return new Immutable(pSubtype, pSupertype);
    }
    
    private static final class Mutable extends SupertypeStar.Match {
      Mutable(final Type pSubtype, final Type pSupertype) {
        super(pSubtype, pSupertype);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends SupertypeStar.Match {
      Immutable(final Type pSubtype, final Type pSupertype) {
        super(pSubtype, pSupertype);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.supertypeStar pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * All supertypes of a type.
   *  
   * pattern supertypeStar(subtype: Type, supertype: Type) {
   * 	subtype == supertype;
   * } or {
   * 	find supertypeDirect+(subtype,supertype);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SupertypeStar
   * 
   */
  public static class Matcher extends BaseMatcher<SupertypeStar.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SupertypeStar.Matcher on(final ViatraQueryEngine engine) {
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
    public static SupertypeStar.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_SUBTYPE = 0;
    
    private static final int POSITION_SUPERTYPE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SupertypeStar.Matcher.class);
    
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
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SupertypeStar.Match> getAllMatches(final Type pSubtype, final Type pSupertype) {
      return rawStreamAllMatches(new Object[]{pSubtype, pSupertype}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SupertypeStar.Match> streamAllMatches(final Type pSubtype, final Type pSupertype) {
      return rawStreamAllMatches(new Object[]{pSubtype, pSupertype});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SupertypeStar.Match> getOneArbitraryMatch(final Type pSubtype, final Type pSupertype) {
      return rawGetOneArbitraryMatch(new Object[]{pSubtype, pSupertype});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Type pSubtype, final Type pSupertype) {
      return rawHasMatch(new Object[]{pSubtype, pSupertype});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Type pSubtype, final Type pSupertype) {
      return rawCountMatches(new Object[]{pSubtype, pSupertype});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Type pSubtype, final Type pSupertype, final Consumer<? super SupertypeStar.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSubtype, pSupertype}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSubtype the fixed value of pattern parameter subtype, or null if not bound.
     * @param pSupertype the fixed value of pattern parameter supertype, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SupertypeStar.Match newMatch(final Type pSubtype, final Type pSupertype) {
      return SupertypeStar.Match.newMatch(pSubtype, pSupertype);
    }
    
    /**
     * Retrieve the set of values that occur in matches for subtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOfsubtype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SUBTYPE, parameters).map(Type.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for subtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfsubtype() {
      return rawStreamAllValuesOfsubtype(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for subtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfsubtype() {
      return rawStreamAllValuesOfsubtype(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for subtype.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfsubtype(final SupertypeStar.Match partialMatch) {
      return rawStreamAllValuesOfsubtype(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for subtype.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfsubtype(final Type pSupertype) {
      return rawStreamAllValuesOfsubtype(new Object[]{null, pSupertype});
    }
    
    /**
     * Retrieve the set of values that occur in matches for subtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfsubtype(final SupertypeStar.Match partialMatch) {
      return rawStreamAllValuesOfsubtype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for subtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfsubtype(final Type pSupertype) {
      return rawStreamAllValuesOfsubtype(new Object[]{null, pSupertype}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for supertype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOfsupertype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SUPERTYPE, parameters).map(Type.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for supertype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfsupertype() {
      return rawStreamAllValuesOfsupertype(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for supertype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfsupertype() {
      return rawStreamAllValuesOfsupertype(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for supertype.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfsupertype(final SupertypeStar.Match partialMatch) {
      return rawStreamAllValuesOfsupertype(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for supertype.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfsupertype(final Type pSubtype) {
      return rawStreamAllValuesOfsupertype(new Object[]{pSubtype, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for supertype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfsupertype(final SupertypeStar.Match partialMatch) {
      return rawStreamAllValuesOfsupertype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for supertype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfsupertype(final Type pSubtype) {
      return rawStreamAllValuesOfsupertype(new Object[]{pSubtype, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected SupertypeStar.Match tupleToMatch(final Tuple t) {
      try {
          return SupertypeStar.Match.newMatch((Type) t.get(POSITION_SUBTYPE), (Type) t.get(POSITION_SUPERTYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SupertypeStar.Match arrayToMatch(final Object[] match) {
      try {
          return SupertypeStar.Match.newMatch((Type) match[POSITION_SUBTYPE], (Type) match[POSITION_SUPERTYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SupertypeStar.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SupertypeStar.Match.newMutableMatch((Type) match[POSITION_SUBTYPE], (Type) match[POSITION_SUPERTYPE]);
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
    public static IQuerySpecification<SupertypeStar.Matcher> querySpecification() {
      return SupertypeStar.instance();
    }
  }
  
  private SupertypeStar() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SupertypeStar instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SupertypeStar.Matcher instantiate(final ViatraQueryEngine engine) {
    return SupertypeStar.Matcher.on(engine);
  }
  
  @Override
  public SupertypeStar.Matcher instantiate() {
    return SupertypeStar.Matcher.create();
  }
  
  @Override
  public SupertypeStar.Match newEmptyMatch() {
    return SupertypeStar.Match.newEmptyMatch();
  }
  
  @Override
  public SupertypeStar.Match newMatch(final Object... parameters) {
    return SupertypeStar.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link SupertypeStar} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SupertypeStar#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SupertypeStar INSTANCE = new SupertypeStar();
    
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
    private static final SupertypeStar.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_subtype = new PParameter("subtype", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final PParameter parameter_supertype = new PParameter("supertype", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_subtype, parameter_supertype);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.supertypeStar";
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
          // 	subtype == supertype
          new Equality(body, var_subtype, var_supertype);
          bodies.add(body);
      }
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
          // 	find supertypeDirect+(subtype,supertype)
          new BinaryTransitiveClosure(body, Tuples.flatTupleOf(var_subtype, var_supertype), SupertypeDirect.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
