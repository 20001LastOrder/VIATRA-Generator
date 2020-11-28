/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra/patterns/hu/bme/mit/inf/dslreasoner/viatrasolver/logic2viatra/queries/TypeAnalysis.vql
 */
package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.IncompatibleType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.SupertypePlus;
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
 *         pattern incompatibleSuperType(type:TypeDeclaration, incompatibleType1:TypeDeclaration, incompatibleType2:TypeDeclaration) {
 *         	find incompatibleType(type, incompatibleType1);
 *         	find incompatibleType(type, incompatibleType2);
 *         	find supertypePlus(incompatibleType1, incompatibleType2);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class IncompatibleSuperType extends BaseGeneratedEMFQuerySpecification<IncompatibleSuperType.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.incompatibleSuperType pattern,
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
    private TypeDeclaration fType;
    
    private TypeDeclaration fIncompatibleType1;
    
    private TypeDeclaration fIncompatibleType2;
    
    private static List<String> parameterNames = makeImmutableList("type", "incompatibleType1", "incompatibleType2");
    
    private Match(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      this.fType = pType;
      this.fIncompatibleType1 = pIncompatibleType1;
      this.fIncompatibleType2 = pIncompatibleType2;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "type": return this.fType;
          case "incompatibleType1": return this.fIncompatibleType1;
          case "incompatibleType2": return this.fIncompatibleType2;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fType;
          case 1: return this.fIncompatibleType1;
          case 2: return this.fIncompatibleType2;
          default: return null;
      }
    }
    
    public TypeDeclaration getType() {
      return this.fType;
    }
    
    public TypeDeclaration getIncompatibleType1() {
      return this.fIncompatibleType1;
    }
    
    public TypeDeclaration getIncompatibleType2() {
      return this.fIncompatibleType2;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("type".equals(parameterName) ) {
          this.fType = (TypeDeclaration) newValue;
          return true;
      }
      if ("incompatibleType1".equals(parameterName) ) {
          this.fIncompatibleType1 = (TypeDeclaration) newValue;
          return true;
      }
      if ("incompatibleType2".equals(parameterName) ) {
          this.fIncompatibleType2 = (TypeDeclaration) newValue;
          return true;
      }
      return false;
    }
    
    public void setType(final TypeDeclaration pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }
    
    public void setIncompatibleType1(final TypeDeclaration pIncompatibleType1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fIncompatibleType1 = pIncompatibleType1;
    }
    
    public void setIncompatibleType2(final TypeDeclaration pIncompatibleType2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fIncompatibleType2 = pIncompatibleType2;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.incompatibleSuperType";
    }
    
    @Override
    public List<String> parameterNames() {
      return IncompatibleSuperType.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fType, fIncompatibleType1, fIncompatibleType2};
    }
    
    @Override
    public IncompatibleSuperType.Match toImmutable() {
      return isMutable() ? newMatch(fType, fIncompatibleType1, fIncompatibleType2) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
      result.append("\"incompatibleType1\"=" + prettyPrintValue(fIncompatibleType1) + ", ");
      result.append("\"incompatibleType2\"=" + prettyPrintValue(fIncompatibleType2));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fType, fIncompatibleType1, fIncompatibleType2);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof IncompatibleSuperType.Match)) {
          IncompatibleSuperType.Match other = (IncompatibleSuperType.Match) obj;
          return Objects.equals(fType, other.fType) && Objects.equals(fIncompatibleType1, other.fIncompatibleType1) && Objects.equals(fIncompatibleType2, other.fIncompatibleType2);
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
    public IncompatibleSuperType specification() {
      return IncompatibleSuperType.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static IncompatibleSuperType.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static IncompatibleSuperType.Match newMutableMatch(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return new Mutable(pType, pIncompatibleType1, pIncompatibleType2);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static IncompatibleSuperType.Match newMatch(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return new Immutable(pType, pIncompatibleType1, pIncompatibleType2);
    }
    
    private static final class Mutable extends IncompatibleSuperType.Match {
      Mutable(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
        super(pType, pIncompatibleType1, pIncompatibleType2);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends IncompatibleSuperType.Match {
      Immutable(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
        super(pType, pIncompatibleType1, pIncompatibleType2);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.incompatibleSuperType pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern incompatibleSuperType(type:TypeDeclaration, incompatibleType1:TypeDeclaration, incompatibleType2:TypeDeclaration) {
   * 	find incompatibleType(type, incompatibleType1);
   * 	find incompatibleType(type, incompatibleType2);
   * 	find supertypePlus(incompatibleType1, incompatibleType2);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see IncompatibleSuperType
   * 
   */
  public static class Matcher extends BaseMatcher<IncompatibleSuperType.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static IncompatibleSuperType.Matcher on(final ViatraQueryEngine engine) {
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
    public static IncompatibleSuperType.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TYPE = 0;
    
    private static final int POSITION_INCOMPATIBLETYPE1 = 1;
    
    private static final int POSITION_INCOMPATIBLETYPE2 = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(IncompatibleSuperType.Matcher.class);
    
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
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<IncompatibleSuperType.Match> getAllMatches(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return rawStreamAllMatches(new Object[]{pType, pIncompatibleType1, pIncompatibleType2}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<IncompatibleSuperType.Match> streamAllMatches(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return rawStreamAllMatches(new Object[]{pType, pIncompatibleType1, pIncompatibleType2});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<IncompatibleSuperType.Match> getOneArbitraryMatch(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return rawGetOneArbitraryMatch(new Object[]{pType, pIncompatibleType1, pIncompatibleType2});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return rawHasMatch(new Object[]{pType, pIncompatibleType1, pIncompatibleType2});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return rawCountMatches(new Object[]{pType, pIncompatibleType1, pIncompatibleType2});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2, final Consumer<? super IncompatibleSuperType.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pType, pIncompatibleType1, pIncompatibleType2}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pIncompatibleType1 the fixed value of pattern parameter incompatibleType1, or null if not bound.
     * @param pIncompatibleType2 the fixed value of pattern parameter incompatibleType2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public IncompatibleSuperType.Match newMatch(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return IncompatibleSuperType.Match.newMatch(pType, pIncompatibleType1, pIncompatibleType2);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<TypeDeclaration> rawStreamAllValuesOftype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TYPE, parameters).map(TypeDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOftype(final IncompatibleSuperType.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOftype(final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return rawStreamAllValuesOftype(new Object[]{null, pIncompatibleType1, pIncompatibleType2});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOftype(final IncompatibleSuperType.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOftype(final TypeDeclaration pIncompatibleType1, final TypeDeclaration pIncompatibleType2) {
      return rawStreamAllValuesOftype(new Object[]{null, pIncompatibleType1, pIncompatibleType2}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<TypeDeclaration> rawStreamAllValuesOfincompatibleType1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_INCOMPATIBLETYPE1, parameters).map(TypeDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfincompatibleType1() {
      return rawStreamAllValuesOfincompatibleType1(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfincompatibleType1() {
      return rawStreamAllValuesOfincompatibleType1(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfincompatibleType1(final IncompatibleSuperType.Match partialMatch) {
      return rawStreamAllValuesOfincompatibleType1(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfincompatibleType1(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType2) {
      return rawStreamAllValuesOfincompatibleType1(new Object[]{pType, null, pIncompatibleType2});
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfincompatibleType1(final IncompatibleSuperType.Match partialMatch) {
      return rawStreamAllValuesOfincompatibleType1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfincompatibleType1(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType2) {
      return rawStreamAllValuesOfincompatibleType1(new Object[]{pType, null, pIncompatibleType2}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<TypeDeclaration> rawStreamAllValuesOfincompatibleType2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_INCOMPATIBLETYPE2, parameters).map(TypeDeclaration.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfincompatibleType2() {
      return rawStreamAllValuesOfincompatibleType2(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfincompatibleType2() {
      return rawStreamAllValuesOfincompatibleType2(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfincompatibleType2(final IncompatibleSuperType.Match partialMatch) {
      return rawStreamAllValuesOfincompatibleType2(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TypeDeclaration> streamAllValuesOfincompatibleType2(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1) {
      return rawStreamAllValuesOfincompatibleType2(new Object[]{pType, pIncompatibleType1, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfincompatibleType2(final IncompatibleSuperType.Match partialMatch) {
      return rawStreamAllValuesOfincompatibleType2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for incompatibleType2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TypeDeclaration> getAllValuesOfincompatibleType2(final TypeDeclaration pType, final TypeDeclaration pIncompatibleType1) {
      return rawStreamAllValuesOfincompatibleType2(new Object[]{pType, pIncompatibleType1, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected IncompatibleSuperType.Match tupleToMatch(final Tuple t) {
      try {
          return IncompatibleSuperType.Match.newMatch((TypeDeclaration) t.get(POSITION_TYPE), (TypeDeclaration) t.get(POSITION_INCOMPATIBLETYPE1), (TypeDeclaration) t.get(POSITION_INCOMPATIBLETYPE2));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected IncompatibleSuperType.Match arrayToMatch(final Object[] match) {
      try {
          return IncompatibleSuperType.Match.newMatch((TypeDeclaration) match[POSITION_TYPE], (TypeDeclaration) match[POSITION_INCOMPATIBLETYPE1], (TypeDeclaration) match[POSITION_INCOMPATIBLETYPE2]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected IncompatibleSuperType.Match arrayToMatchMutable(final Object[] match) {
      try {
          return IncompatibleSuperType.Match.newMutableMatch((TypeDeclaration) match[POSITION_TYPE], (TypeDeclaration) match[POSITION_INCOMPATIBLETYPE1], (TypeDeclaration) match[POSITION_INCOMPATIBLETYPE2]);
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
    public static IQuerySpecification<IncompatibleSuperType.Matcher> querySpecification() {
      return IncompatibleSuperType.instance();
    }
  }
  
  private IncompatibleSuperType() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static IncompatibleSuperType instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected IncompatibleSuperType.Matcher instantiate(final ViatraQueryEngine engine) {
    return IncompatibleSuperType.Matcher.on(engine);
  }
  
  @Override
  public IncompatibleSuperType.Matcher instantiate() {
    return IncompatibleSuperType.Matcher.create();
  }
  
  @Override
  public IncompatibleSuperType.Match newEmptyMatch() {
    return IncompatibleSuperType.Match.newEmptyMatch();
  }
  
  @Override
  public IncompatibleSuperType.Match newMatch(final Object... parameters) {
    return IncompatibleSuperType.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[1], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link IncompatibleSuperType} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link IncompatibleSuperType#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final IncompatibleSuperType INSTANCE = new IncompatibleSuperType();
    
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
    private static final IncompatibleSuperType.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_type = new PParameter("type", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final PParameter parameter_incompatibleType1 = new PParameter("incompatibleType1", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final PParameter parameter_incompatibleType2 = new PParameter("incompatibleType2", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_type, parameter_incompatibleType1, parameter_incompatibleType2);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.incompatibleSuperType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("type","incompatibleType1","incompatibleType2");
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
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var_incompatibleType1 = body.getOrCreateVariableByName("incompatibleType1");
          PVariable var_incompatibleType2 = body.getOrCreateVariableByName("incompatibleType2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_incompatibleType1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_incompatibleType2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_type, parameter_type),
             new ExportedParameter(body, var_incompatibleType1, parameter_incompatibleType1),
             new ExportedParameter(body, var_incompatibleType2, parameter_incompatibleType2)
          ));
          // 	find incompatibleType(type, incompatibleType1)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_type, var_incompatibleType1), IncompatibleType.instance().getInternalQueryRepresentation());
          // 	find incompatibleType(type, incompatibleType2)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_type, var_incompatibleType2), IncompatibleType.instance().getInternalQueryRepresentation());
          // 	find supertypePlus(incompatibleType1, incompatibleType2)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_incompatibleType1, var_incompatibleType2), SupertypePlus.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
