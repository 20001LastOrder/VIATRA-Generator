/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.PossibleDynamicType;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
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
 *         {@literal @}Constraint(severity = "warning",key = {element},
 *         	message="There is no possible dynamic type for an element."
 *         )
 *         pattern elementWithNoPossibleDynamicType(problem:LogicProblem, element:DefinedElement) {
 *         	LogicProblem.elements(problem,element);
 *         	neg find possibleDynamicType(problem,_,element);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ElementWithNoPossibleDynamicType extends BaseGeneratedEMFQuerySpecification<ElementWithNoPossibleDynamicType.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.elementWithNoPossibleDynamicType pattern,
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
    
    private DefinedElement fElement;
    
    private static List<String> parameterNames = makeImmutableList("problem", "element");
    
    private Match(final LogicProblem pProblem, final DefinedElement pElement) {
      this.fProblem = pProblem;
      this.fElement = pElement;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "problem": return this.fProblem;
          case "element": return this.fElement;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fProblem;
          case 1: return this.fElement;
          default: return null;
      }
    }
    
    public LogicProblem getProblem() {
      return this.fProblem;
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
    
    public void setElement(final DefinedElement pElement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElement = pElement;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.elementWithNoPossibleDynamicType";
    }
    
    @Override
    public List<String> parameterNames() {
      return ElementWithNoPossibleDynamicType.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fProblem, fElement};
    }
    
    @Override
    public ElementWithNoPossibleDynamicType.Match toImmutable() {
      return isMutable() ? newMatch(fProblem, fElement) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"problem\"=" + prettyPrintValue(fProblem) + ", ");
      result.append("\"element\"=" + prettyPrintValue(fElement));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fProblem, fElement);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ElementWithNoPossibleDynamicType.Match)) {
          ElementWithNoPossibleDynamicType.Match other = (ElementWithNoPossibleDynamicType.Match) obj;
          return Objects.equals(fProblem, other.fProblem) && Objects.equals(fElement, other.fElement);
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
    public ElementWithNoPossibleDynamicType specification() {
      return ElementWithNoPossibleDynamicType.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ElementWithNoPossibleDynamicType.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ElementWithNoPossibleDynamicType.Match newMutableMatch(final LogicProblem pProblem, final DefinedElement pElement) {
      return new Mutable(pProblem, pElement);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ElementWithNoPossibleDynamicType.Match newMatch(final LogicProblem pProblem, final DefinedElement pElement) {
      return new Immutable(pProblem, pElement);
    }
    
    private static final class Mutable extends ElementWithNoPossibleDynamicType.Match {
      Mutable(final LogicProblem pProblem, final DefinedElement pElement) {
        super(pProblem, pElement);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ElementWithNoPossibleDynamicType.Match {
      Immutable(final LogicProblem pProblem, final DefinedElement pElement) {
        super(pProblem, pElement);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.elementWithNoPossibleDynamicType pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * {@literal @}Constraint(severity = "warning",key = {element},
   * 	message="There is no possible dynamic type for an element."
   * )
   * pattern elementWithNoPossibleDynamicType(problem:LogicProblem, element:DefinedElement) {
   * 	LogicProblem.elements(problem,element);
   * 	neg find possibleDynamicType(problem,_,element);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ElementWithNoPossibleDynamicType
   * 
   */
  public static class Matcher extends BaseMatcher<ElementWithNoPossibleDynamicType.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ElementWithNoPossibleDynamicType.Matcher on(final ViatraQueryEngine engine) {
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
    public static ElementWithNoPossibleDynamicType.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PROBLEM = 0;
    
    private static final int POSITION_ELEMENT = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ElementWithNoPossibleDynamicType.Matcher.class);
    
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
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ElementWithNoPossibleDynamicType.Match> getAllMatches(final LogicProblem pProblem, final DefinedElement pElement) {
      return rawStreamAllMatches(new Object[]{pProblem, pElement}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ElementWithNoPossibleDynamicType.Match> streamAllMatches(final LogicProblem pProblem, final DefinedElement pElement) {
      return rawStreamAllMatches(new Object[]{pProblem, pElement});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ElementWithNoPossibleDynamicType.Match> getOneArbitraryMatch(final LogicProblem pProblem, final DefinedElement pElement) {
      return rawGetOneArbitraryMatch(new Object[]{pProblem, pElement});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final LogicProblem pProblem, final DefinedElement pElement) {
      return rawHasMatch(new Object[]{pProblem, pElement});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final LogicProblem pProblem, final DefinedElement pElement) {
      return rawCountMatches(new Object[]{pProblem, pElement});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final LogicProblem pProblem, final DefinedElement pElement, final Consumer<? super ElementWithNoPossibleDynamicType.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pProblem, pElement}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ElementWithNoPossibleDynamicType.Match newMatch(final LogicProblem pProblem, final DefinedElement pElement) {
      return ElementWithNoPossibleDynamicType.Match.newMatch(pProblem, pElement);
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
    public Stream<LogicProblem> streamAllValuesOfproblem(final ElementWithNoPossibleDynamicType.Match partialMatch) {
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
    public Stream<LogicProblem> streamAllValuesOfproblem(final DefinedElement pElement) {
      return rawStreamAllValuesOfproblem(new Object[]{null, pElement});
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LogicProblem> getAllValuesOfproblem(final ElementWithNoPossibleDynamicType.Match partialMatch) {
      return rawStreamAllValuesOfproblem(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for problem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LogicProblem> getAllValuesOfproblem(final DefinedElement pElement) {
      return rawStreamAllValuesOfproblem(new Object[]{null, pElement}).collect(Collectors.toSet());
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
    public Stream<DefinedElement> streamAllValuesOfelement(final ElementWithNoPossibleDynamicType.Match partialMatch) {
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
    public Stream<DefinedElement> streamAllValuesOfelement(final LogicProblem pProblem) {
      return rawStreamAllValuesOfelement(new Object[]{pProblem, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DefinedElement> getAllValuesOfelement(final ElementWithNoPossibleDynamicType.Match partialMatch) {
      return rawStreamAllValuesOfelement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DefinedElement> getAllValuesOfelement(final LogicProblem pProblem) {
      return rawStreamAllValuesOfelement(new Object[]{pProblem, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ElementWithNoPossibleDynamicType.Match tupleToMatch(final Tuple t) {
      try {
          return ElementWithNoPossibleDynamicType.Match.newMatch((LogicProblem) t.get(POSITION_PROBLEM), (DefinedElement) t.get(POSITION_ELEMENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ElementWithNoPossibleDynamicType.Match arrayToMatch(final Object[] match) {
      try {
          return ElementWithNoPossibleDynamicType.Match.newMatch((LogicProblem) match[POSITION_PROBLEM], (DefinedElement) match[POSITION_ELEMENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ElementWithNoPossibleDynamicType.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ElementWithNoPossibleDynamicType.Match.newMutableMatch((LogicProblem) match[POSITION_PROBLEM], (DefinedElement) match[POSITION_ELEMENT]);
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
    public static IQuerySpecification<ElementWithNoPossibleDynamicType.Matcher> querySpecification() {
      return ElementWithNoPossibleDynamicType.instance();
    }
  }
  
  private ElementWithNoPossibleDynamicType() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ElementWithNoPossibleDynamicType instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ElementWithNoPossibleDynamicType.Matcher instantiate(final ViatraQueryEngine engine) {
    return ElementWithNoPossibleDynamicType.Matcher.on(engine);
  }
  
  @Override
  public ElementWithNoPossibleDynamicType.Matcher instantiate() {
    return ElementWithNoPossibleDynamicType.Matcher.create();
  }
  
  @Override
  public ElementWithNoPossibleDynamicType.Match newEmptyMatch() {
    return ElementWithNoPossibleDynamicType.Match.newEmptyMatch();
  }
  
  @Override
  public ElementWithNoPossibleDynamicType.Match newMatch(final Object... parameters) {
    return ElementWithNoPossibleDynamicType.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ElementWithNoPossibleDynamicType} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ElementWithNoPossibleDynamicType#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ElementWithNoPossibleDynamicType INSTANCE = new ElementWithNoPossibleDynamicType();
    
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
    private static final ElementWithNoPossibleDynamicType.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_problem = new PParameter("problem", "hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")), PParameterDirection.INOUT);
    
    private final PParameter parameter_element = new PParameter("element", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_problem, parameter_element);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.elementWithNoPossibleDynamicType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("problem","element");
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
          PVariable var_element = body.getOrCreateVariableByName("element");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_problem, parameter_problem),
             new ExportedParameter(body, var_element, parameter_element)
          ));
          // 	LogicProblem.elements(problem,element)
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem", "elements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          new Equality(body, var__virtual_0_, var_element);
          // 	neg find possibleDynamicType(problem,_,element)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_problem, var___0_, var_element), PossibleDynamicType.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      {
          PAnnotation annotation = new PAnnotation("Constraint");
          annotation.addAttribute("severity", "warning");
          annotation.addAttribute("key", Arrays.asList(new Object[] {
                              new ParameterReference("element")
                              }));
          annotation.addAttribute("message", "There is no possible dynamic type for an element.");
          addAnnotation(annotation);
      }
      return bodies;
    }
  }
}
