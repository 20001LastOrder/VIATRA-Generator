/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.SupertypeStar;
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
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
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
 *         Types that 
 *          
 *         pattern mustTypeElement(problem: LogicProblem, type:Type, element:DefinedElement) {
 *         	LogicProblem.types(problem,type);
 *         	TypeDefinition.elements(type,element);
 *         } or {
 *         	TypeDeclaration(type);
 *         	LogicProblem.types(problem,type);
 *         	LogicProblem.types(problem,subtype);
 *         	TypeDefinition.elements(subtype,element);
 *         	find supertypeStar(subtype,type);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class MustTypeElement extends BaseGeneratedEMFQuerySpecification<MustTypeElement.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.mustTypeElement pattern,
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
    private LogicProblem fProblem;
    
    private Type fType;
    
    private DefinedElement fElement;
    
    private static List<String> parameterNames = makeImmutableList("problem", "type", "element");
    
    private Match(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      this.fProblem = pProblem;
      this.fType = pType;
      this.fElement = pElement;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "problem": return this.fProblem;
          case "type": return this.fType;
          case "element": return this.fElement;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fProblem;
          case 1: return this.fType;
          case 2: return this.fElement;
          default: return null;
      }
    }
    
    public LogicProblem getProblem() {
      return this.fProblem;
    }
    
    public Type getType() {
      return this.fType;
    }
    
    public DefinedElement getElement() {
      return this.fElement;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("problem".equals(parameterName) ) {
          this.fProblem = (LogicProblem) newValue;
          return true;
      }
      if ("type".equals(parameterName) ) {
          this.fType = (Type) newValue;
          return true;
      }
      if ("element".equals(parameterName) ) {
          this.fElement = (DefinedElement) newValue;
          return true;
      }
      return false;
    }
    
    public void setProblem(final LogicProblem pProblem) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fProblem = pProblem;
    }
    
    public void setType(final Type pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }
    
    public void setElement(final DefinedElement pElement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElement = pElement;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.mustTypeElement";
    }
    
    @Override
    public List<String> parameterNames() {
      return MustTypeElement.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fProblem, fType, fElement};
    }
    
    @Override
    public MustTypeElement.Match toImmutable() {
      return isMutable() ? newMatch(fProblem, fType, fElement) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"problem\"=" + prettyPrintValue(fProblem) + ", ");
      result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
      result.append("\"element\"=" + prettyPrintValue(fElement));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fProblem, fType, fElement);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof MustTypeElement.Match)) {
          MustTypeElement.Match other = (MustTypeElement.Match) obj;
          return Objects.equals(fProblem, other.fProblem) && Objects.equals(fType, other.fType) && Objects.equals(fElement, other.fElement);
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
    public MustTypeElement specification() {
      return MustTypeElement.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static MustTypeElement.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static MustTypeElement.Match newMutableMatch(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return new Mutable(pProblem, pType, pElement);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static MustTypeElement.Match newMatch(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return new Immutable(pProblem, pType, pElement);
    }
    
    private static final class Mutable extends MustTypeElement.Match {
      Mutable(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
        super(pProblem, pType, pElement);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends MustTypeElement.Match {
      Immutable(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
        super(pProblem, pType, pElement);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.mustTypeElement pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Types that 
   *  
   * pattern mustTypeElement(problem: LogicProblem, type:Type, element:DefinedElement) {
   * 	LogicProblem.types(problem,type);
   * 	TypeDefinition.elements(type,element);
   * } or {
   * 	TypeDeclaration(type);
   * 	LogicProblem.types(problem,type);
   * 	LogicProblem.types(problem,subtype);
   * 	TypeDefinition.elements(subtype,element);
   * 	find supertypeStar(subtype,type);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see MustTypeElement
   * 
   */
  public static class Matcher extends BaseMatcher<MustTypeElement.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static MustTypeElement.Matcher on(final ViatraQueryEngine engine) {
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
    public static MustTypeElement.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PROBLEM = 0;
    
    private static final int POSITION_TYPE = 1;
    
    private static final int POSITION_ELEMENT = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MustTypeElement.Matcher.class);
    
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
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<MustTypeElement.Match> getAllMatches(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return rawStreamAllMatches(new Object[]{pProblem, pType, pElement}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<MustTypeElement.Match> streamAllMatches(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return rawStreamAllMatches(new Object[]{pProblem, pType, pElement});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<MustTypeElement.Match> getOneArbitraryMatch(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return rawGetOneArbitraryMatch(new Object[]{pProblem, pType, pElement});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return rawHasMatch(new Object[]{pProblem, pType, pElement});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return rawCountMatches(new Object[]{pProblem, pType, pElement});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final LogicProblem pProblem, final Type pType, final DefinedElement pElement, final Consumer<? super MustTypeElement.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pProblem, pType, pElement}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public MustTypeElement.Match newMatch(final LogicProblem pProblem, final Type pType, final DefinedElement pElement) {
      return MustTypeElement.Match.newMatch(pProblem, pType, pElement);
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<LogicProblem> rawStreamAllValuesOfproblem(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PROBLEM, parameters).map(LogicProblem.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LogicProblem> getAllValuesOfproblem() {
      return rawStreamAllValuesOfproblem(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<LogicProblem> streamAllValuesOfproblem() {
      return rawStreamAllValuesOfproblem(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<LogicProblem> streamAllValuesOfproblem(final MustTypeElement.Match partialMatch) {
      return rawStreamAllValuesOfproblem(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<LogicProblem> streamAllValuesOfproblem(final Type pType, final DefinedElement pElement) {
      return rawStreamAllValuesOfproblem(new Object[]{null, pType, pElement});
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LogicProblem> getAllValuesOfproblem(final MustTypeElement.Match partialMatch) {
      return rawStreamAllValuesOfproblem(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LogicProblem> getAllValuesOfproblem(final Type pType, final DefinedElement pElement) {
      return rawStreamAllValuesOfproblem(new Object[]{null, pType, pElement}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOftype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TYPE, parameters).map(Type.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype() {
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
    public Stream<Type> streamAllValuesOftype(final MustTypeElement.Match partialMatch) {
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
    public Stream<Type> streamAllValuesOftype(final LogicProblem pProblem, final DefinedElement pElement) {
      return rawStreamAllValuesOftype(new Object[]{pProblem, null, pElement});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype(final MustTypeElement.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype(final LogicProblem pProblem, final DefinedElement pElement) {
      return rawStreamAllValuesOftype(new Object[]{pProblem, null, pElement}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DefinedElement> rawStreamAllValuesOfelement(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ELEMENT, parameters).map(DefinedElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DefinedElement> getAllValuesOfelement() {
      return rawStreamAllValuesOfelement(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DefinedElement> streamAllValuesOfelement() {
      return rawStreamAllValuesOfelement(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DefinedElement> streamAllValuesOfelement(final MustTypeElement.Match partialMatch) {
      return rawStreamAllValuesOfelement(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DefinedElement> streamAllValuesOfelement(final LogicProblem pProblem, final Type pType) {
      return rawStreamAllValuesOfelement(new Object[]{pProblem, pType, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DefinedElement> getAllValuesOfelement(final MustTypeElement.Match partialMatch) {
      return rawStreamAllValuesOfelement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DefinedElement> getAllValuesOfelement(final LogicProblem pProblem, final Type pType) {
      return rawStreamAllValuesOfelement(new Object[]{pProblem, pType, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected MustTypeElement.Match tupleToMatch(final Tuple t) {
      try {
          return MustTypeElement.Match.newMatch((LogicProblem) t.get(POSITION_PROBLEM), (Type) t.get(POSITION_TYPE), (DefinedElement) t.get(POSITION_ELEMENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MustTypeElement.Match arrayToMatch(final Object[] match) {
      try {
          return MustTypeElement.Match.newMatch((LogicProblem) match[POSITION_PROBLEM], (Type) match[POSITION_TYPE], (DefinedElement) match[POSITION_ELEMENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MustTypeElement.Match arrayToMatchMutable(final Object[] match) {
      try {
          return MustTypeElement.Match.newMutableMatch((LogicProblem) match[POSITION_PROBLEM], (Type) match[POSITION_TYPE], (DefinedElement) match[POSITION_ELEMENT]);
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
    public static IQuerySpecification<MustTypeElement.Matcher> querySpecification() {
      return MustTypeElement.instance();
    }
  }
  
  private MustTypeElement() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static MustTypeElement instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected MustTypeElement.Matcher instantiate(final ViatraQueryEngine engine) {
    return MustTypeElement.Matcher.on(engine);
  }
  
  @Override
  public MustTypeElement.Matcher instantiate() {
    return MustTypeElement.Matcher.create();
  }
  
  @Override
  public MustTypeElement.Match newEmptyMatch() {
    return MustTypeElement.Match.newEmptyMatch();
  }
  
  @Override
  public MustTypeElement.Match newMatch(final Object... parameters) {
    return MustTypeElement.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[1], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MustTypeElement} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link MustTypeElement#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final MustTypeElement INSTANCE = new MustTypeElement();
    
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
    private static final MustTypeElement.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_problem = new PParameter("problem", "hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")), PParameterDirection.INOUT);
    
    private final PParameter parameter_type = new PParameter("type", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final PParameter parameter_element = new PParameter("element", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_problem, parameter_type, parameter_element);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.mustTypeElement";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("problem","type","element");
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
          PVariable var_problem = body.getOrCreateVariableByName("problem");
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var_element = body.getOrCreateVariableByName("element");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_problem, parameter_problem),
             new ExportedParameter(body, var_type, parameter_type),
             new ExportedParameter(body, var_element, parameter_element)
          ));
          // 	LogicProblem.types(problem,type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem", "types")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new Equality(body, var__virtual_0_, var_type);
          // 	TypeDefinition.elements(type,element)
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDefinition")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDefinition", "elements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          new Equality(body, var__virtual_1_, var_element);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_problem = body.getOrCreateVariableByName("problem");
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var_element = body.getOrCreateVariableByName("element");
          PVariable var_subtype = body.getOrCreateVariableByName("subtype");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_problem, parameter_problem),
             new ExportedParameter(body, var_type, parameter_type),
             new ExportedParameter(body, var_element, parameter_element)
          ));
          // 	TypeDeclaration(type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          // 	LogicProblem.types(problem,type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem", "types")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new Equality(body, var__virtual_0_, var_type);
          // 	LogicProblem.types(problem,subtype)
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem", "types")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          new Equality(body, var__virtual_1_, var_subtype);
          // 	TypeDefinition.elements(subtype,element)
          new TypeConstraint(body, Tuples.flatTupleOf(var_subtype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDefinition")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_subtype, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDefinition", "elements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          new Equality(body, var__virtual_2_, var_element);
          // 	find supertypeStar(subtype,type)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_subtype, var_type), SupertypeStar.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
