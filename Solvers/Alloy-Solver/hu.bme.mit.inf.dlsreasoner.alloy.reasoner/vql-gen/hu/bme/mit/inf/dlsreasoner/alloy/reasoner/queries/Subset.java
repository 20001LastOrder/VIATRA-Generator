/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/signatureQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.DirectSubset;
import hu.bme.mit.inf.dslreasoner.alloyLanguage.ALSSignatureDeclaration;
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
 *         pattern subset(x: ALSSignatureDeclaration, y: ALSSignatureDeclaration) {
 *         	x == y;
 *         } or {
 *         	find directSubset+(x,y);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Subset extends BaseGeneratedEMFQuerySpecification<Subset.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.subset pattern,
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
    private ALSSignatureDeclaration fX;
    
    private ALSSignatureDeclaration fY;
    
    private static List<String> parameterNames = makeImmutableList("x", "y");
    
    private Match(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      this.fX = pX;
      this.fY = pY;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "x": return this.fX;
          case "y": return this.fY;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fX;
          case 1: return this.fY;
          default: return null;
      }
    }
    
    public ALSSignatureDeclaration getX() {
      return this.fX;
    }
    
    public ALSSignatureDeclaration getY() {
      return this.fY;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("x".equals(parameterName) ) {
          this.fX = (ALSSignatureDeclaration) newValue;
          return true;
      }
      if ("y".equals(parameterName) ) {
          this.fY = (ALSSignatureDeclaration) newValue;
          return true;
      }
      return false;
    }
    
    public void setX(final ALSSignatureDeclaration pX) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fX = pX;
    }
    
    public void setY(final ALSSignatureDeclaration pY) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fY = pY;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.subset";
    }
    
    @Override
    public List<String> parameterNames() {
      return Subset.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fX, fY};
    }
    
    @Override
    public Subset.Match toImmutable() {
      return isMutable() ? newMatch(fX, fY) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"x\"=" + prettyPrintValue(fX) + ", ");
      result.append("\"y\"=" + prettyPrintValue(fY));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fX, fY);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Subset.Match)) {
          Subset.Match other = (Subset.Match) obj;
          return Objects.equals(fX, other.fX) && Objects.equals(fY, other.fY);
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
    public Subset specification() {
      return Subset.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Subset.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Subset.Match newMutableMatch(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return new Mutable(pX, pY);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Subset.Match newMatch(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return new Immutable(pX, pY);
    }
    
    private static final class Mutable extends Subset.Match {
      Mutable(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
        super(pX, pY);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Subset.Match {
      Immutable(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
        super(pX, pY);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.subset pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern subset(x: ALSSignatureDeclaration, y: ALSSignatureDeclaration) {
   * 	x == y;
   * } or {
   * 	find directSubset+(x,y);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Subset
   * 
   */
  public static class Matcher extends BaseMatcher<Subset.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Subset.Matcher on(final ViatraQueryEngine engine) {
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
    public static Subset.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_X = 0;
    
    private static final int POSITION_Y = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Subset.Matcher.class);
    
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
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Subset.Match> getAllMatches(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return rawStreamAllMatches(new Object[]{pX, pY}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Subset.Match> streamAllMatches(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return rawStreamAllMatches(new Object[]{pX, pY});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Subset.Match> getOneArbitraryMatch(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return rawGetOneArbitraryMatch(new Object[]{pX, pY});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return rawHasMatch(new Object[]{pX, pY});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return rawCountMatches(new Object[]{pX, pY});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY, final Consumer<? super Subset.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pX, pY}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pX the fixed value of pattern parameter x, or null if not bound.
     * @param pY the fixed value of pattern parameter y, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Subset.Match newMatch(final ALSSignatureDeclaration pX, final ALSSignatureDeclaration pY) {
      return Subset.Match.newMatch(pX, pY);
    }
    
    /**
     * Retrieve the set of values that occur in matches for x.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ALSSignatureDeclaration> rawStreamAllValuesOfx(final Object[] parameters) {
      return rawStreamAllValues(POSITION_X, parameters).map(ALSSignatureDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for x.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ALSSignatureDeclaration> getAllValuesOfx() {
      return rawStreamAllValuesOfx(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for x.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ALSSignatureDeclaration> streamAllValuesOfx() {
      return rawStreamAllValuesOfx(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for x.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ALSSignatureDeclaration> streamAllValuesOfx(final Subset.Match partialMatch) {
      return rawStreamAllValuesOfx(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for x.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ALSSignatureDeclaration> streamAllValuesOfx(final ALSSignatureDeclaration pY) {
      return rawStreamAllValuesOfx(new Object[]{null, pY});
    }
    
    /**
     * Retrieve the set of values that occur in matches for x.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ALSSignatureDeclaration> getAllValuesOfx(final Subset.Match partialMatch) {
      return rawStreamAllValuesOfx(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for x.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ALSSignatureDeclaration> getAllValuesOfx(final ALSSignatureDeclaration pY) {
      return rawStreamAllValuesOfx(new Object[]{null, pY}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for y.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ALSSignatureDeclaration> rawStreamAllValuesOfy(final Object[] parameters) {
      return rawStreamAllValues(POSITION_Y, parameters).map(ALSSignatureDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for y.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ALSSignatureDeclaration> getAllValuesOfy() {
      return rawStreamAllValuesOfy(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for y.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ALSSignatureDeclaration> streamAllValuesOfy() {
      return rawStreamAllValuesOfy(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for y.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ALSSignatureDeclaration> streamAllValuesOfy(final Subset.Match partialMatch) {
      return rawStreamAllValuesOfy(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for y.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ALSSignatureDeclaration> streamAllValuesOfy(final ALSSignatureDeclaration pX) {
      return rawStreamAllValuesOfy(new Object[]{pX, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for y.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ALSSignatureDeclaration> getAllValuesOfy(final Subset.Match partialMatch) {
      return rawStreamAllValuesOfy(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for y.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ALSSignatureDeclaration> getAllValuesOfy(final ALSSignatureDeclaration pX) {
      return rawStreamAllValuesOfy(new Object[]{pX, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Subset.Match tupleToMatch(final Tuple t) {
      try {
          return Subset.Match.newMatch((ALSSignatureDeclaration) t.get(POSITION_X), (ALSSignatureDeclaration) t.get(POSITION_Y));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Subset.Match arrayToMatch(final Object[] match) {
      try {
          return Subset.Match.newMatch((ALSSignatureDeclaration) match[POSITION_X], (ALSSignatureDeclaration) match[POSITION_Y]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Subset.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Subset.Match.newMutableMatch((ALSSignatureDeclaration) match[POSITION_X], (ALSSignatureDeclaration) match[POSITION_Y]);
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
    public static IQuerySpecification<Subset.Matcher> querySpecification() {
      return Subset.instance();
    }
  }
  
  private Subset() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Subset instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Subset.Matcher instantiate(final ViatraQueryEngine engine) {
    return Subset.Matcher.on(engine);
  }
  
  @Override
  public Subset.Matcher instantiate() {
    return Subset.Matcher.create();
  }
  
  @Override
  public Subset.Match newEmptyMatch() {
    return Subset.Match.newEmptyMatch();
  }
  
  @Override
  public Subset.Match newMatch(final Object... parameters) {
    return Subset.Match.newMatch((hu.bme.mit.inf.dslreasoner.alloyLanguage.ALSSignatureDeclaration) parameters[0], (hu.bme.mit.inf.dslreasoner.alloyLanguage.ALSSignatureDeclaration) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link Subset} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link Subset#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Subset INSTANCE = new Subset();
    
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
    private static final Subset.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_x = new PParameter("x", "hu.bme.mit.inf.dslreasoner.alloyLanguage.ALSSignatureDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/AlloyLanguage", "ALSSignatureDeclaration")), PParameterDirection.INOUT);
    
    private final PParameter parameter_y = new PParameter("y", "hu.bme.mit.inf.dslreasoner.alloyLanguage.ALSSignatureDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/AlloyLanguage", "ALSSignatureDeclaration")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_x, parameter_y);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.subset";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("x","y");
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
          PVariable var_x = body.getOrCreateVariableByName("x");
          PVariable var_y = body.getOrCreateVariableByName("y");
          new TypeConstraint(body, Tuples.flatTupleOf(var_x), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/AlloyLanguage", "ALSSignatureDeclaration")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_y), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/AlloyLanguage", "ALSSignatureDeclaration")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_x, parameter_x),
             new ExportedParameter(body, var_y, parameter_y)
          ));
          // 	x == y
          new Equality(body, var_x, var_y);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_x = body.getOrCreateVariableByName("x");
          PVariable var_y = body.getOrCreateVariableByName("y");
          new TypeConstraint(body, Tuples.flatTupleOf(var_x), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/AlloyLanguage", "ALSSignatureDeclaration")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_y), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/AlloyLanguage", "ALSSignatureDeclaration")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_x, parameter_x),
             new ExportedParameter(body, var_y, parameter_y)
          ));
          // 	find directSubset+(x,y)
          new BinaryTransitiveClosure(body, Tuples.flatTupleOf(var_x, var_y), DirectSubset.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
