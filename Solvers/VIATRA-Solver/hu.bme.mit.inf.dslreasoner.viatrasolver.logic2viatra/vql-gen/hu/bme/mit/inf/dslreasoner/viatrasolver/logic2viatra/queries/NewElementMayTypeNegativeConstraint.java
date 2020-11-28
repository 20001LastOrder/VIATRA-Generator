/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra/patterns/hu/bme/mit/inf/dslreasoner/viatrasolver/logic2viatra/queries/TypeAnalysis.vql
 */
package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.IncompatibleTopType;
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
 *         pattern newElementMayTypeNegativeConstraint(mayType: TypeDeclaration, inhibitor: TypeDeclaration) {
 *         	find incompatibleTopType(mayType, inhibitor);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class NewElementMayTypeNegativeConstraint extends BaseGeneratedEMFQuerySpecification<NewElementMayTypeNegativeConstraint.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementMayTypeNegativeConstraint pattern,
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
    private TypeDeclaration fMayType;
    
    private TypeDeclaration fInhibitor;
    
    private static List<String> parameterNames = makeImmutableList("mayType", "inhibitor");
    
    private Match(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      this.fMayType = pMayType;
      this.fInhibitor = pInhibitor;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "mayType": return this.fMayType;
          case "inhibitor": return this.fInhibitor;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fMayType;
          case 1: return this.fInhibitor;
          default: return null;
      }
    }
    
    public TypeDeclaration getMayType() {
      return this.fMayType;
    }
    
    public TypeDeclaration getInhibitor() {
      return this.fInhibitor;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("mayType".equals(parameterName) ) {
          this.fMayType = (TypeDeclaration) newValue;
          return true;
      }
      if ("inhibitor".equals(parameterName) ) {
          this.fInhibitor = (TypeDeclaration) newValue;
          return true;
      }
      return false;
    }
    
    public void setMayType(final TypeDeclaration pMayType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fMayType = pMayType;
    }
    
    public void setInhibitor(final TypeDeclaration pInhibitor) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fInhibitor = pInhibitor;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementMayTypeNegativeConstraint";
    }
    
    @Override
    public List<String> parameterNames() {
      return NewElementMayTypeNegativeConstraint.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fMayType, fInhibitor};
    }
    
    @Override
    public NewElementMayTypeNegativeConstraint.Match toImmutable() {
      return isMutable() ? newMatch(fMayType, fInhibitor) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"mayType\"=" + prettyPrintValue(fMayType) + ", ");
      result.append("\"inhibitor\"=" + prettyPrintValue(fInhibitor));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fMayType, fInhibitor);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof NewElementMayTypeNegativeConstraint.Match)) {
          NewElementMayTypeNegativeConstraint.Match other = (NewElementMayTypeNegativeConstraint.Match) obj;
          return Objects.equals(fMayType, other.fMayType) && Objects.equals(fInhibitor, other.fInhibitor);
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
    public NewElementMayTypeNegativeConstraint specification() {
      return NewElementMayTypeNegativeConstraint.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static NewElementMayTypeNegativeConstraint.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static NewElementMayTypeNegativeConstraint.Match newMutableMatch(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return new Mutable(pMayType, pInhibitor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static NewElementMayTypeNegativeConstraint.Match newMatch(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return new Immutable(pMayType, pInhibitor);
    }
    
    private static final class Mutable extends NewElementMayTypeNegativeConstraint.Match {
      Mutable(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
        super(pMayType, pInhibitor);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends NewElementMayTypeNegativeConstraint.Match {
      Immutable(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
        super(pMayType, pInhibitor);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementMayTypeNegativeConstraint pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern newElementMayTypeNegativeConstraint(mayType: TypeDeclaration, inhibitor: TypeDeclaration) {
   * 	find incompatibleTopType(mayType, inhibitor);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see NewElementMayTypeNegativeConstraint
   * 
   */
  public static class Matcher extends BaseMatcher<NewElementMayTypeNegativeConstraint.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static NewElementMayTypeNegativeConstraint.Matcher on(final ViatraQueryEngine engine) {
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
    public static NewElementMayTypeNegativeConstraint.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_MAYTYPE = 0;
    
    private static final int POSITION_INHIBITOR = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NewElementMayTypeNegativeConstraint.Matcher.class);
    
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
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<NewElementMayTypeNegativeConstraint.Match> getAllMatches(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return rawStreamAllMatches(new Object[]{pMayType, pInhibitor}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<NewElementMayTypeNegativeConstraint.Match> streamAllMatches(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return rawStreamAllMatches(new Object[]{pMayType, pInhibitor});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<NewElementMayTypeNegativeConstraint.Match> getOneArbitraryMatch(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return rawGetOneArbitraryMatch(new Object[]{pMayType, pInhibitor});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return rawHasMatch(new Object[]{pMayType, pInhibitor});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return rawCountMatches(new Object[]{pMayType, pInhibitor});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor, final Consumer<? super NewElementMayTypeNegativeConstraint.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pMayType, pInhibitor}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pMayType the fixed value of pattern parameter mayType, or null if not bound.
     * @param pInhibitor the fixed value of pattern parameter inhibitor, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public NewElementMayTypeNegativeConstraint.Match newMatch(final TypeDeclaration pMayType, final TypeDeclaration pInhibitor) {
      return NewElementMayTypeNegativeConstraint.Match.newMatch(pMayType, pInhibitor);
    }
    
    /**
     * Retrieve the set of values that occur in matches for mayType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<TypeDeclaration> rawStreamAllValuesOfmayType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MAYTYPE, parameters).map(TypeDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for mayType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfmayType() {
      return rawStreamAllValuesOfmayType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for mayType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfmayType() {
      return rawStreamAllValuesOfmayType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for mayType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfmayType(final NewElementMayTypeNegativeConstraint.Match partialMatch) {
      return rawStreamAllValuesOfmayType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for mayType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfmayType(final TypeDeclaration pInhibitor) {
      return rawStreamAllValuesOfmayType(new Object[]{null, pInhibitor});
    }
    
    /**
     * Retrieve the set of values that occur in matches for mayType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfmayType(final NewElementMayTypeNegativeConstraint.Match partialMatch) {
      return rawStreamAllValuesOfmayType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for mayType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfmayType(final TypeDeclaration pInhibitor) {
      return rawStreamAllValuesOfmayType(new Object[]{null, pInhibitor}).collect(Collectors.toSet());
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
    public Stream<TypeDeclaration> streamAllValuesOfinhibitor(final NewElementMayTypeNegativeConstraint.Match partialMatch) {
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
    public Stream<TypeDeclaration> streamAllValuesOfinhibitor(final TypeDeclaration pMayType) {
      return rawStreamAllValuesOfinhibitor(new Object[]{pMayType, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfinhibitor(final NewElementMayTypeNegativeConstraint.Match partialMatch) {
      return rawStreamAllValuesOfinhibitor(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for inhibitor.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfinhibitor(final TypeDeclaration pMayType) {
      return rawStreamAllValuesOfinhibitor(new Object[]{pMayType, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected NewElementMayTypeNegativeConstraint.Match tupleToMatch(final Tuple t) {
      try {
          return NewElementMayTypeNegativeConstraint.Match.newMatch((TypeDeclaration) t.get(POSITION_MAYTYPE), (TypeDeclaration) t.get(POSITION_INHIBITOR));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected NewElementMayTypeNegativeConstraint.Match arrayToMatch(final Object[] match) {
      try {
          return NewElementMayTypeNegativeConstraint.Match.newMatch((TypeDeclaration) match[POSITION_MAYTYPE], (TypeDeclaration) match[POSITION_INHIBITOR]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected NewElementMayTypeNegativeConstraint.Match arrayToMatchMutable(final Object[] match) {
      try {
          return NewElementMayTypeNegativeConstraint.Match.newMutableMatch((TypeDeclaration) match[POSITION_MAYTYPE], (TypeDeclaration) match[POSITION_INHIBITOR]);
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
    public static IQuerySpecification<NewElementMayTypeNegativeConstraint.Matcher> querySpecification() {
      return NewElementMayTypeNegativeConstraint.instance();
    }
  }
  
  private NewElementMayTypeNegativeConstraint() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static NewElementMayTypeNegativeConstraint instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected NewElementMayTypeNegativeConstraint.Matcher instantiate(final ViatraQueryEngine engine) {
    return NewElementMayTypeNegativeConstraint.Matcher.on(engine);
  }
  
  @Override
  public NewElementMayTypeNegativeConstraint.Matcher instantiate() {
    return NewElementMayTypeNegativeConstraint.Matcher.create();
  }
  
  @Override
  public NewElementMayTypeNegativeConstraint.Match newEmptyMatch() {
    return NewElementMayTypeNegativeConstraint.Match.newEmptyMatch();
  }
  
  @Override
  public NewElementMayTypeNegativeConstraint.Match newMatch(final Object... parameters) {
    return NewElementMayTypeNegativeConstraint.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link NewElementMayTypeNegativeConstraint} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link NewElementMayTypeNegativeConstraint#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final NewElementMayTypeNegativeConstraint INSTANCE = new NewElementMayTypeNegativeConstraint();
    
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
    private static final NewElementMayTypeNegativeConstraint.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_mayType = new PParameter("mayType", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final PParameter parameter_inhibitor = new PParameter("inhibitor", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_mayType, parameter_inhibitor);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.newElementMayTypeNegativeConstraint";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("mayType","inhibitor");
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
          PVariable var_mayType = body.getOrCreateVariableByName("mayType");
          PVariable var_inhibitor = body.getOrCreateVariableByName("inhibitor");
          new TypeConstraint(body, Tuples.flatTupleOf(var_mayType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_inhibitor), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_mayType, parameter_mayType),
             new ExportedParameter(body, var_inhibitor, parameter_inhibitor)
          ));
          // 	find incompatibleTopType(mayType, inhibitor)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_mayType, var_inhibitor), IncompatibleTopType.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
