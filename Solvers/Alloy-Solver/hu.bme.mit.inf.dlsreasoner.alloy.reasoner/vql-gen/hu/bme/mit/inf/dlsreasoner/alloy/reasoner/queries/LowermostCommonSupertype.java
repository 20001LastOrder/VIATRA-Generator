/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/typeQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.CommonSupertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.HasLowerCommonSupertype;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
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
 *         pattern lowermostCommonSupertype(type1: Type, type2: Type, common: Type) {
 *         	find commonSupertype(type1, type2, common);
 *         	neg find hasLowerCommonSupertype(type1, type2, common, _);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class LowermostCommonSupertype extends BaseGeneratedEMFQuerySpecification<LowermostCommonSupertype.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowermostCommonSupertype pattern,
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
    
    private Type fCommon;
    
    private static List<String> parameterNames = makeImmutableList("type1", "type2", "common");
    
    private Match(final Type pType1, final Type pType2, final Type pCommon) {
      this.fType1 = pType1;
      this.fType2 = pType2;
      this.fCommon = pCommon;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "type1": return this.fType1;
          case "type2": return this.fType2;
          case "common": return this.fCommon;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fType1;
          case 1: return this.fType2;
          case 2: return this.fCommon;
          default: return null;
      }
    }
    
    public Type getType1() {
      return this.fType1;
    }
    
    public Type getType2() {
      return this.fType2;
    }
    
    public Type getCommon() {
      return this.fCommon;
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
      if ("common".equals(parameterName) ) {
          this.fCommon = (Type) newValue;
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
    
    public void setCommon(final Type pCommon) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCommon = pCommon;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowermostCommonSupertype";
    }
    
    @Override
    public List<String> parameterNames() {
      return LowermostCommonSupertype.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fType1, fType2, fCommon};
    }
    
    @Override
    public LowermostCommonSupertype.Match toImmutable() {
      return isMutable() ? newMatch(fType1, fType2, fCommon) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"type1\"=" + prettyPrintValue(fType1) + ", ");
      result.append("\"type2\"=" + prettyPrintValue(fType2) + ", ");
      result.append("\"common\"=" + prettyPrintValue(fCommon));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fType1, fType2, fCommon);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof LowermostCommonSupertype.Match)) {
          LowermostCommonSupertype.Match other = (LowermostCommonSupertype.Match) obj;
          return Objects.equals(fType1, other.fType1) && Objects.equals(fType2, other.fType2) && Objects.equals(fCommon, other.fCommon);
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
    public LowermostCommonSupertype specification() {
      return LowermostCommonSupertype.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static LowermostCommonSupertype.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static LowermostCommonSupertype.Match newMutableMatch(final Type pType1, final Type pType2, final Type pCommon) {
      return new Mutable(pType1, pType2, pCommon);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static LowermostCommonSupertype.Match newMatch(final Type pType1, final Type pType2, final Type pCommon) {
      return new Immutable(pType1, pType2, pCommon);
    }
    
    private static final class Mutable extends LowermostCommonSupertype.Match {
      Mutable(final Type pType1, final Type pType2, final Type pCommon) {
        super(pType1, pType2, pCommon);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends LowermostCommonSupertype.Match {
      Immutable(final Type pType1, final Type pType2, final Type pCommon) {
        super(pType1, pType2, pCommon);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowermostCommonSupertype pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern lowermostCommonSupertype(type1: Type, type2: Type, common: Type) {
   * 	find commonSupertype(type1, type2, common);
   * 	neg find hasLowerCommonSupertype(type1, type2, common, _);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see LowermostCommonSupertype
   * 
   */
  public static class Matcher extends BaseMatcher<LowermostCommonSupertype.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static LowermostCommonSupertype.Matcher on(final ViatraQueryEngine engine) {
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
    public static LowermostCommonSupertype.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TYPE1 = 0;
    
    private static final int POSITION_TYPE2 = 1;
    
    private static final int POSITION_COMMON = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(LowermostCommonSupertype.Matcher.class);
    
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
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<LowermostCommonSupertype.Match> getAllMatches(final Type pType1, final Type pType2, final Type pCommon) {
      return rawStreamAllMatches(new Object[]{pType1, pType2, pCommon}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<LowermostCommonSupertype.Match> streamAllMatches(final Type pType1, final Type pType2, final Type pCommon) {
      return rawStreamAllMatches(new Object[]{pType1, pType2, pCommon});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<LowermostCommonSupertype.Match> getOneArbitraryMatch(final Type pType1, final Type pType2, final Type pCommon) {
      return rawGetOneArbitraryMatch(new Object[]{pType1, pType2, pCommon});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Type pType1, final Type pType2, final Type pCommon) {
      return rawHasMatch(new Object[]{pType1, pType2, pCommon});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Type pType1, final Type pType2, final Type pCommon) {
      return rawCountMatches(new Object[]{pType1, pType2, pCommon});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Type pType1, final Type pType2, final Type pCommon, final Consumer<? super LowermostCommonSupertype.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pType1, pType2, pCommon}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType1 the fixed value of pattern parameter type1, or null if not bound.
     * @param pType2 the fixed value of pattern parameter type2, or null if not bound.
     * @param pCommon the fixed value of pattern parameter common, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public LowermostCommonSupertype.Match newMatch(final Type pType1, final Type pType2, final Type pCommon) {
      return LowermostCommonSupertype.Match.newMatch(pType1, pType2, pCommon);
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
    public Stream<Type> streamAllValuesOftype1(final LowermostCommonSupertype.Match partialMatch) {
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
    public Stream<Type> streamAllValuesOftype1(final Type pType2, final Type pCommon) {
      return rawStreamAllValuesOftype1(new Object[]{null, pType2, pCommon});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype1(final LowermostCommonSupertype.Match partialMatch) {
      return rawStreamAllValuesOftype1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype1(final Type pType2, final Type pCommon) {
      return rawStreamAllValuesOftype1(new Object[]{null, pType2, pCommon}).collect(Collectors.toSet());
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
    public Stream<Type> streamAllValuesOftype2(final LowermostCommonSupertype.Match partialMatch) {
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
    public Stream<Type> streamAllValuesOftype2(final Type pType1, final Type pCommon) {
      return rawStreamAllValuesOftype2(new Object[]{pType1, null, pCommon});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype2(final LowermostCommonSupertype.Match partialMatch) {
      return rawStreamAllValuesOftype2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype2(final Type pType1, final Type pCommon) {
      return rawStreamAllValuesOftype2(new Object[]{pType1, null, pCommon}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for common.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOfcommon(final Object[] parameters) {
      return rawStreamAllValues(POSITION_COMMON, parameters).map(Type.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for common.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfcommon() {
      return rawStreamAllValuesOfcommon(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for common.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfcommon() {
      return rawStreamAllValuesOfcommon(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for common.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfcommon(final LowermostCommonSupertype.Match partialMatch) {
      return rawStreamAllValuesOfcommon(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for common.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOfcommon(final Type pType1, final Type pType2) {
      return rawStreamAllValuesOfcommon(new Object[]{pType1, pType2, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for common.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfcommon(final LowermostCommonSupertype.Match partialMatch) {
      return rawStreamAllValuesOfcommon(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for common.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOfcommon(final Type pType1, final Type pType2) {
      return rawStreamAllValuesOfcommon(new Object[]{pType1, pType2, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected LowermostCommonSupertype.Match tupleToMatch(final Tuple t) {
      try {
          return LowermostCommonSupertype.Match.newMatch((Type) t.get(POSITION_TYPE1), (Type) t.get(POSITION_TYPE2), (Type) t.get(POSITION_COMMON));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected LowermostCommonSupertype.Match arrayToMatch(final Object[] match) {
      try {
          return LowermostCommonSupertype.Match.newMatch((Type) match[POSITION_TYPE1], (Type) match[POSITION_TYPE2], (Type) match[POSITION_COMMON]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected LowermostCommonSupertype.Match arrayToMatchMutable(final Object[] match) {
      try {
          return LowermostCommonSupertype.Match.newMutableMatch((Type) match[POSITION_TYPE1], (Type) match[POSITION_TYPE2], (Type) match[POSITION_COMMON]);
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
    public static IQuerySpecification<LowermostCommonSupertype.Matcher> querySpecification() {
      return LowermostCommonSupertype.instance();
    }
  }
  
  private LowermostCommonSupertype() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static LowermostCommonSupertype instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected LowermostCommonSupertype.Matcher instantiate(final ViatraQueryEngine engine) {
    return LowermostCommonSupertype.Matcher.on(engine);
  }
  
  @Override
  public LowermostCommonSupertype.Matcher instantiate() {
    return LowermostCommonSupertype.Matcher.create();
  }
  
  @Override
  public LowermostCommonSupertype.Match newEmptyMatch() {
    return LowermostCommonSupertype.Match.newEmptyMatch();
  }
  
  @Override
  public LowermostCommonSupertype.Match newMatch(final Object... parameters) {
    return LowermostCommonSupertype.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[1], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link LowermostCommonSupertype} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link LowermostCommonSupertype#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final LowermostCommonSupertype INSTANCE = new LowermostCommonSupertype();
    
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
    private static final LowermostCommonSupertype.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_type1 = new PParameter("type1", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final PParameter parameter_type2 = new PParameter("type2", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final PParameter parameter_common = new PParameter("common", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_type1, parameter_type2, parameter_common);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowermostCommonSupertype";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("type1","type2","common");
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
          PVariable var_common = body.getOrCreateVariableByName("common");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_common), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_type1, parameter_type1),
             new ExportedParameter(body, var_type2, parameter_type2),
             new ExportedParameter(body, var_common, parameter_common)
          ));
          // 	find commonSupertype(type1, type2, common)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_type1, var_type2, var_common), CommonSupertype.instance().getInternalQueryRepresentation());
          // 	neg find hasLowerCommonSupertype(type1, type2, common, _)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_type1, var_type2, var_common, var___0_), HasLowerCommonSupertype.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
