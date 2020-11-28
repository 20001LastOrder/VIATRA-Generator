/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/typeQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.SupertypeEdge;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
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
 *         pattern supertype(type1: Type, type2: Type) {
 *         	type1 == type2;
 *         } or {
 *         	find supertypeEdge+(type1,type2);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Supertype extends BaseGeneratedEMFQuerySpecification<Supertype.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.supertype pattern,
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
    private Type fType1;
    
    private Type fType2;
    
    private static List<String> parameterNames = makeImmutableList("type1", "type2");
    
    private Match(final Type pType1, final Type pType2) {
      this.fType1 = pType1;
      this.fType2 = pType2;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "type1": return this.fType1;
          case "type2": return this.fType2;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fType1;
          case 1: return this.fType2;
          default: return null;
      }
    }
    
    public Type getType1() {
      return this.fType1;
    }
    
    public Type getType2() {
      return this.fType2;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("type1".equals(parameterName) ) {
          this.fType1 = (Type) newValue;
          return true;
      }
      if ("type2".equals(parameterName) ) {
          this.fType2 = (Type) newValue;
          return true;
      }
      return false;
    }
    
    public void setType1(final Type pType1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType1 = pType1;
    }
    
    public void setType2(final Type pType2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType2 = pType2;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.supertype";
    }
    
    @Override
    public List<String> parameterNames() {
      return Supertype.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fType1, fType2};
    }
    
    @Override
    public Supertype.Match toImmutable() {
      return isMutable() ? newMatch(fType1, fType2) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"type1\"=" + prettyPrintValue(fType1) + ", ");
      result.append("\"type2\"=" + prettyPrintValue(fType2));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fType1, fType2);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Supertype.Match)) {
          Supertype.Match other = (Supertype.Match) obj;
          return Objects.equals(fType1, other.fType1) && Objects.equals(fType2, other.fType2);
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
    public Supertype specification() {
      return Supertype.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Supertype.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Supertype.Match newMutableMatch(final Type pType1, final Type pType2) {
      return new Mutable(pType1, pType2);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Supertype.Match newMatch(final Type pType1, final Type pType2) {
      return new Immutable(pType1, pType2);
    }
    
    private static final class Mutable extends Supertype.Match {
      Mutable(final Type pType1, final Type pType2) {
        super(pType1, pType2);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Supertype.Match {
      Immutable(final Type pType1, final Type pType2) {
        super(pType1, pType2);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.supertype pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern supertype(type1: Type, type2: Type) {
   * 	type1 == type2;
   * } or {
   * 	find supertypeEdge+(type1,type2);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Supertype
   * 
   */
  public static class Matcher extends BaseMatcher<Supertype.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Supertype.Matcher on(final ViatraQueryEngine engine) {
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
    public static Supertype.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TYPE1 = 0;
    
    private static final int POSITION_TYPE2 = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Supertype.Matcher.class);
    
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
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Supertype.Match> getAllMatches(final Type pType1, final Type pType2) {
      return rawStreamAllMatches(new Object[]{pType1, pType2}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Supertype.Match> streamAllMatches(final Type pType1, final Type pType2) {
      return rawStreamAllMatches(new Object[]{pType1, pType2});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Supertype.Match> getOneArbitraryMatch(final Type pType1, final Type pType2) {
      return rawGetOneArbitraryMatch(new Object[]{pType1, pType2});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Type pType1, final Type pType2) {
      return rawHasMatch(new Object[]{pType1, pType2});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Type pType1, final Type pType2) {
      return rawCountMatches(new Object[]{pType1, pType2});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Type pType1, final Type pType2, final Consumer<? super Supertype.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pType1, pType2}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Supertype.Match newMatch(final Type pType1, final Type pType2) {
      return Supertype.Match.newMatch(pType1, pType2);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOftype1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TYPE1, parameters).map(Type.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype1() {
      return rawStreamAllValuesOftype1(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype1() {
      return rawStreamAllValuesOftype1(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype1(final Supertype.Match partialMatch) {
      return rawStreamAllValuesOftype1(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype1(final Type pType2) {
      return rawStreamAllValuesOftype1(new Object[]{null, pType2});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype1(final Supertype.Match partialMatch) {
      return rawStreamAllValuesOftype1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype1(final Type pType2) {
      return rawStreamAllValuesOftype1(new Object[]{null, pType2}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOftype2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TYPE2, parameters).map(Type.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype2() {
      return rawStreamAllValuesOftype2(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype2() {
      return rawStreamAllValuesOftype2(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype2(final Supertype.Match partialMatch) {
      return rawStreamAllValuesOftype2(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype2(final Type pType1) {
      return rawStreamAllValuesOftype2(new Object[]{pType1, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype2(final Supertype.Match partialMatch) {
      return rawStreamAllValuesOftype2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype2(final Type pType1) {
      return rawStreamAllValuesOftype2(new Object[]{pType1, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Supertype.Match tupleToMatch(final Tuple t) {
      try {
          return Supertype.Match.newMatch((Type) t.get(POSITION_TYPE1), (Type) t.get(POSITION_TYPE2));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Supertype.Match arrayToMatch(final Object[] match) {
      try {
          return Supertype.Match.newMatch((Type) match[POSITION_TYPE1], (Type) match[POSITION_TYPE2]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Supertype.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Supertype.Match.newMutableMatch((Type) match[POSITION_TYPE1], (Type) match[POSITION_TYPE2]);
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
    public static IQuerySpecification<Supertype.Matcher> querySpecification() {
      return Supertype.instance();
    }
  }
  
  private Supertype() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Supertype instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Supertype.Matcher instantiate(final ViatraQueryEngine engine) {
    return Supertype.Matcher.on(engine);
  }
  
  @Override
  public Supertype.Matcher instantiate() {
    return Supertype.Matcher.create();
  }
  
  @Override
  public Supertype.Match newEmptyMatch() {
    return Supertype.Match.newEmptyMatch();
  }
  
  @Override
  public Supertype.Match newMatch(final Object... parameters) {
    return Supertype.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link Supertype} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link Supertype#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Supertype INSTANCE = new Supertype();
    
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
    private static final Supertype.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_type1 = new PParameter("type1", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final PParameter parameter_type2 = new PParameter("type2", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_type1, parameter_type2);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.supertype";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("type1","type2");
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
          PVariable var_type1 = body.getOrCreateVariableByName("type1");
          PVariable var_type2 = body.getOrCreateVariableByName("type2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_type1, parameter_type1),
             new ExportedParameter(body, var_type2, parameter_type2)
          ));
          // 	type1 == type2
          new Equality(body, var_type1, var_type2);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_type1 = body.getOrCreateVariableByName("type1");
          PVariable var_type2 = body.getOrCreateVariableByName("type2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_type1, parameter_type1),
             new ExportedParameter(body, var_type2, parameter_type2)
          ));
          // 	find supertypeEdge+(type1,type2)
          new BinaryTransitiveClosure(body, Tuples.flatTupleOf(var_type1, var_type2), SupertypeEdge.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
