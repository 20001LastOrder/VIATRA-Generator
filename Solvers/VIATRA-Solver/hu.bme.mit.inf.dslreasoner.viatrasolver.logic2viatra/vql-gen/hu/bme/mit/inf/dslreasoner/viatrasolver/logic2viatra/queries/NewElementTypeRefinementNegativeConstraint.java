/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra/patterns/hu/bme/mit/inf/dslreasoner/viatrasolver/logic2viatra/queries/TypeAnalysis.vql
 */
package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.IncompatibleTopType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.PossibleNewElementDynamicType;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         pattern newElementTypeRefinementNegativeConstraint(refined:TypeDeclaration, inhibitor:TypeDeclaration) {
 *         	find incompatibleTopType(refined, inhibitor);
 *         } or {
 *         	find possibleNewElementDynamicType(refined);
 *         	refined == inhibitor;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class NewElementTypeRefinementNegativeConstraint extends BaseGeneratedEMFQuerySpecification<NewElementTypeRefinementNegativeConstraint.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementTypeRefinementNegativeConstraint pattern,
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
    private TypeDeclaration fRefined;
    
    private TypeDeclaration fInhibitor;
    
    private static List<String> parameterNames = makeImmutableList("refined", "inhibitor");
    
    private Match(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      this.fRefined = pRefined;
      this.fInhibitor = pInhibitor;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "refined": return this.fRefined;
          case "inhibitor": return this.fInhibitor;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fRefined;
          case 1: return this.fInhibitor;
          default: return null;
      }
    }
    
    public TypeDeclaration getRefined() {
      return this.fRefined;
    }
    
    public TypeDeclaration getInhibitor() {
      return this.fInhibitor;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("refined".equals(parameterName) ) {
          this.fRefined = (TypeDeclaration) newValue;
          return true;
      }
      if ("inhibitor".equals(parameterName) ) {
          this.fInhibitor = (TypeDeclaration) newValue;
          return true;
      }
      return false;
    }
    
    public void setRefined(final TypeDeclaration pRefined) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRefined = pRefined;
    }
    
    public void setInhibitor(final TypeDeclaration pInhibitor) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fInhibitor = pInhibitor;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementTypeRefinementNegativeConstraint";
    }
    
    @Override
    public List<String> parameterNames() {
      return NewElementTypeRefinementNegativeConstraint.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fRefined, fInhibitor};
    }
    
    @Override
    public NewElementTypeRefinementNegativeConstraint.Match toImmutable() {
      return isMutable() ? newMatch(fRefined, fInhibitor) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"refined\"=" + prettyPrintValue(fRefined) + ", ");
      result.append("\"inhibitor\"=" + prettyPrintValue(fInhibitor));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fRefined, fInhibitor);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof NewElementTypeRefinementNegativeConstraint.Match)) {
          NewElementTypeRefinementNegativeConstraint.Match other = (NewElementTypeRefinementNegativeConstraint.Match) obj;
          return Objects.equals(fRefined, other.fRefined) && Objects.equals(fInhibitor, other.fInhibitor);
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
    public NewElementTypeRefinementNegativeConstraint specification() {
      return NewElementTypeRefinementNegativeConstraint.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static NewElementTypeRefinementNegativeConstraint.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static NewElementTypeRefinementNegativeConstraint.Match newMutableMatch(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return new Mutable(pRefined, pInhibitor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static NewElementTypeRefinementNegativeConstraint.Match newMatch(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return new Immutable(pRefined, pInhibitor);
    }
    
    private static final class Mutable extends NewElementTypeRefinementNegativeConstraint.Match {
      Mutable(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
        super(pRefined, pInhibitor);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends NewElementTypeRefinementNegativeConstraint.Match {
      Immutable(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
        super(pRefined, pInhibitor);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementTypeRefinementNegativeConstraint pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern newElementTypeRefinementNegativeConstraint(refined:TypeDeclaration, inhibitor:TypeDeclaration) {
   * 	find incompatibleTopType(refined, inhibitor);
   * } or {
   * 	find possibleNewElementDynamicType(refined);
   * 	refined == inhibitor;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see NewElementTypeRefinementNegativeConstraint
   * 
   */
  public static class Matcher extends BaseMatcher<NewElementTypeRefinementNegativeConstraint.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static NewElementTypeRefinementNegativeConstraint.Matcher on(final ViatraQueryEngine engine) {
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
    public static NewElementTypeRefinementNegativeConstraint.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_REFINED = 0;
    
    private static final int POSITION_INHIBITOR = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NewElementTypeRefinementNegativeConstraint.Matcher.class);
    
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
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<NewElementTypeRefinementNegativeConstraint.Match> getAllMatches(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return rawStreamAllMatches(new Object[]{pRefined, pInhibitor}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<NewElementTypeRefinementNegativeConstraint.Match> streamAllMatches(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return rawStreamAllMatches(new Object[]{pRefined, pInhibitor});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<NewElementTypeRefinementNegativeConstraint.Match> getOneArbitraryMatch(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return rawGetOneArbitraryMatch(new Object[]{pRefined, pInhibitor});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return rawHasMatch(new Object[]{pRefined, pInhibitor});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return rawCountMatches(new Object[]{pRefined, pInhibitor});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor, final Consumer<? super NewElementTypeRefinementNegativeConstraint.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pRefined, pInhibitor}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRefined the fixed value of pattern parameter refined, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public NewElementTypeRefinementNegativeConstraint.Match newMatch(final TypeDeclaration pRefined, final TypeDeclaration pInhibitor) {
      return NewElementTypeRefinementNegativeConstraint.Match.newMatch(pRefined, pInhibitor);
    }
    
    /**
     * Retrieve the set of values that occur in matches for refined.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<TypeDeclaration> rawStreamAllValuesOfrefined(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REFINED, parameters).map(TypeDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for refined.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfrefined() {
      return rawStreamAllValuesOfrefined(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refined.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfrefined() {
      return rawStreamAllValuesOfrefined(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refined.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfrefined(final NewElementTypeRefinementNegativeConstraint.Match partialMatch) {
      return rawStreamAllValuesOfrefined(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refined.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfrefined(final TypeDeclaration pInhibitor) {
      return rawStreamAllValuesOfrefined(new Object[]{null, pInhibitor});
    }
    
    /**
     * Retrieve the set of values that occur in matches for refined.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfrefined(final NewElementTypeRefinementNegativeConstraint.Match partialMatch) {
      return rawStreamAllValuesOfrefined(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refined.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfrefined(final TypeDeclaration pInhibitor) {
      return rawStreamAllValuesOfrefined(new Object[]{null, pInhibitor}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<TypeDeclaration> rawStreamAllValuesOfinhibitor(final Object[] parameters) {
      return rawStreamAllValues(POSITION_INHIBITOR, parameters).map(TypeDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfinhibitor() {
      return rawStreamAllValuesOfinhibitor(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfinhibitor() {
      return rawStreamAllValuesOfinhibitor(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfinhibitor(final NewElementTypeRefinementNegativeConstraint.Match partialMatch) {
      return rawStreamAllValuesOfinhibitor(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfinhibitor(final TypeDeclaration pRefined) {
      return rawStreamAllValuesOfinhibitor(new Object[]{pRefined, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfinhibitor(final NewElementTypeRefinementNegativeConstraint.Match partialMatch) {
      return rawStreamAllValuesOfinhibitor(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfinhibitor(final TypeDeclaration pRefined) {
      return rawStreamAllValuesOfinhibitor(new Object[]{pRefined, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected NewElementTypeRefinementNegativeConstraint.Match tupleToMatch(final Tuple t) {
      try {
          return NewElementTypeRefinementNegativeConstraint.Match.newMatch((TypeDeclaration) t.get(POSITION_REFINED), (TypeDeclaration) t.get(POSITION_INHIBITOR));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected NewElementTypeRefinementNegativeConstraint.Match arrayToMatch(final Object[] match) {
      try {
          return NewElementTypeRefinementNegativeConstraint.Match.newMatch((TypeDeclaration) match[POSITION_REFINED], (TypeDeclaration) match[POSITION_INHIBITOR]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected NewElementTypeRefinementNegativeConstraint.Match arrayToMatchMutable(final Object[] match) {
      try {
          return NewElementTypeRefinementNegativeConstraint.Match.newMutableMatch((TypeDeclaration) match[POSITION_REFINED], (TypeDeclaration) match[POSITION_INHIBITOR]);
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
    public static IQuerySpecification<NewElementTypeRefinementNegativeConstraint.Matcher> querySpecification() {
      return NewElementTypeRefinementNegativeConstraint.instance();
    }
  }
  
  private NewElementTypeRefinementNegativeConstraint() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static NewElementTypeRefinementNegativeConstraint instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected NewElementTypeRefinementNegativeConstraint.Matcher instantiate(final ViatraQueryEngine engine) {
    return NewElementTypeRefinementNegativeConstraint.Matcher.on(engine);
  }
  
  @Override
  public NewElementTypeRefinementNegativeConstraint.Matcher instantiate() {
    return NewElementTypeRefinementNegativeConstraint.Matcher.create();
  }
  
  @Override
  public NewElementTypeRefinementNegativeConstraint.Match newEmptyMatch() {
    return NewElementTypeRefinementNegativeConstraint.Match.newEmptyMatch();
  }
  
  @Override
  public NewElementTypeRefinementNegativeConstraint.Match newMatch(final Object... parameters) {
    return NewElementTypeRefinementNegativeConstraint.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link NewElementTypeRefinementNegativeConstraint} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link NewElementTypeRefinementNegativeConstraint#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final NewElementTypeRefinementNegativeConstraint INSTANCE = new NewElementTypeRefinementNegativeConstraint();
    
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
    private static final NewElementTypeRefinementNegativeConstraint.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_refined = new PParameter("refined", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final PParameter parameter_inhibitor = new PParameter("inhibitor", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_refined, parameter_inhibitor);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementTypeRefinementNegativeConstraint";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("refined","inhibitor");
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
          PVariable var_refined = body.getOrCreateVariableByName("refined");
          PVariable var_inhibitor = body.getOrCreateVariableByName("inhibitor");
          new TypeConstraint(body, Tuples.flatTupleOf(var_refined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_inhibitor), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_refined, parameter_refined),
             new ExportedParameter(body, var_inhibitor, parameter_inhibitor)
          ));
          // 	find incompatibleTopType(refined, inhibitor)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_refined, var_inhibitor), IncompatibleTopType.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_refined = body.getOrCreateVariableByName("refined");
          PVariable var_inhibitor = body.getOrCreateVariableByName("inhibitor");
          new TypeConstraint(body, Tuples.flatTupleOf(var_refined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_inhibitor), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_refined, parameter_refined),
             new ExportedParameter(body, var_inhibitor, parameter_inhibitor)
          ));
          // 	find possibleNewElementDynamicType(refined)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_refined), PossibleNewElementDynamicType.instance().getInternalQueryRepresentation());
          // 	refined == inhibitor
          new Equality(body, var_refined, var_inhibitor);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
