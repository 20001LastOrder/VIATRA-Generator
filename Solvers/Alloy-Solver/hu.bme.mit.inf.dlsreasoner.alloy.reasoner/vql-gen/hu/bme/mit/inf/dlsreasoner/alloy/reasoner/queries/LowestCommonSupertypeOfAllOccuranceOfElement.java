/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/typeQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.HasLowerCommonSupertypeOfAllOccuranceOfElement;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.TypeContainsAllOccuranceOfElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
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
 *         pattern topmostCommonSubtypesInObject(type1: Type, type2: Type, common: Type) {
 *         	find commonSubtype(type1, type2, common);
 *         	neg find supertypeEdge(type1,_);
 *         	neg find supertypeEdge(type2,_);
 *         	neg find hasHigherCommonSubtype(type1, type2, common, _);
 *         }
 *         pattern topmostCommonSubtypesInType(in: Type, type1: Type, type2: Type, common: Type) {
 *         	find commonSubtype(type1, type2, common);
 *         	find supertypeEdge(type1,in);
 *         	find supertypeEdge(type2,in);
 *         	neg find hasHigherCommonSubtype(type1, type2, common, _);
 *         }
 *          
 *         
 *         pattern lowestCommonSupertypeOfAllOccuranceOfElement(element: DefinedElement, type: Type) {
 *         	find typeContainsAllOccuranceOfElement(element,type);
 *         	neg find hasLowerCommonSupertypeOfAllOccuranceOfElement(element, type, _);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class LowestCommonSupertypeOfAllOccuranceOfElement extends BaseGeneratedEMFQuerySpecification<LowestCommonSupertypeOfAllOccuranceOfElement.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowestCommonSupertypeOfAllOccuranceOfElement pattern,
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
    private DefinedElement fElement;
    
    private Type fType;
    
    private static List<String> parameterNames = makeImmutableList("element", "type");
    
    private Match(final DefinedElement pElement, final Type pType) {
      this.fElement = pElement;
      this.fType = pType;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "element": return this.fElement;
          case "type": return this.fType;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fElement;
          case 1: return this.fType;
          default: return null;
      }
    }
    
    public DefinedElement getElement() {
      return this.fElement;
    }
    
    public Type getType() {
      return this.fType;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("element".equals(parameterName) ) {
          this.fElement = (DefinedElement) newValue;
          return true;
      }
      if ("type".equals(parameterName) ) {
          this.fType = (Type) newValue;
          return true;
      }
      return false;
    }
    
    public void setElement(final DefinedElement pElement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElement = pElement;
    }
    
    public void setType(final Type pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowestCommonSupertypeOfAllOccuranceOfElement";
    }
    
    @Override
    public List<String> parameterNames() {
      return LowestCommonSupertypeOfAllOccuranceOfElement.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fElement, fType};
    }
    
    @Override
    public LowestCommonSupertypeOfAllOccuranceOfElement.Match toImmutable() {
      return isMutable() ? newMatch(fElement, fType) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"element\"=" + prettyPrintValue(fElement) + ", ");
      result.append("\"type\"=" + prettyPrintValue(fType));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fElement, fType);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof LowestCommonSupertypeOfAllOccuranceOfElement.Match)) {
          LowestCommonSupertypeOfAllOccuranceOfElement.Match other = (LowestCommonSupertypeOfAllOccuranceOfElement.Match) obj;
          return Objects.equals(fElement, other.fElement) && Objects.equals(fType, other.fType);
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
    public LowestCommonSupertypeOfAllOccuranceOfElement specification() {
      return LowestCommonSupertypeOfAllOccuranceOfElement.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static LowestCommonSupertypeOfAllOccuranceOfElement.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static LowestCommonSupertypeOfAllOccuranceOfElement.Match newMutableMatch(final DefinedElement pElement, final Type pType) {
      return new Mutable(pElement, pType);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static LowestCommonSupertypeOfAllOccuranceOfElement.Match newMatch(final DefinedElement pElement, final Type pType) {
      return new Immutable(pElement, pType);
    }
    
    private static final class Mutable extends LowestCommonSupertypeOfAllOccuranceOfElement.Match {
      Mutable(final DefinedElement pElement, final Type pType) {
        super(pElement, pType);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends LowestCommonSupertypeOfAllOccuranceOfElement.Match {
      Immutable(final DefinedElement pElement, final Type pType) {
        super(pElement, pType);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowestCommonSupertypeOfAllOccuranceOfElement pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern topmostCommonSubtypesInObject(type1: Type, type2: Type, common: Type) {
   * 	find commonSubtype(type1, type2, common);
   * 	neg find supertypeEdge(type1,_);
   * 	neg find supertypeEdge(type2,_);
   * 	neg find hasHigherCommonSubtype(type1, type2, common, _);
   * }
   * pattern topmostCommonSubtypesInType(in: Type, type1: Type, type2: Type, common: Type) {
   * 	find commonSubtype(type1, type2, common);
   * 	find supertypeEdge(type1,in);
   * 	find supertypeEdge(type2,in);
   * 	neg find hasHigherCommonSubtype(type1, type2, common, _);
   * }
   *  
   * 
   * pattern lowestCommonSupertypeOfAllOccuranceOfElement(element: DefinedElement, type: Type) {
   * 	find typeContainsAllOccuranceOfElement(element,type);
   * 	neg find hasLowerCommonSupertypeOfAllOccuranceOfElement(element, type, _);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see LowestCommonSupertypeOfAllOccuranceOfElement
   * 
   */
  public static class Matcher extends BaseMatcher<LowestCommonSupertypeOfAllOccuranceOfElement.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static LowestCommonSupertypeOfAllOccuranceOfElement.Matcher on(final ViatraQueryEngine engine) {
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
    public static LowestCommonSupertypeOfAllOccuranceOfElement.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_ELEMENT = 0;
    
    private static final int POSITION_TYPE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(LowestCommonSupertypeOfAllOccuranceOfElement.Matcher.class);
    
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
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<LowestCommonSupertypeOfAllOccuranceOfElement.Match> getAllMatches(final DefinedElement pElement, final Type pType) {
      return rawStreamAllMatches(new Object[]{pElement, pType}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<LowestCommonSupertypeOfAllOccuranceOfElement.Match> streamAllMatches(final DefinedElement pElement, final Type pType) {
      return rawStreamAllMatches(new Object[]{pElement, pType});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<LowestCommonSupertypeOfAllOccuranceOfElement.Match> getOneArbitraryMatch(final DefinedElement pElement, final Type pType) {
      return rawGetOneArbitraryMatch(new Object[]{pElement, pType});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final DefinedElement pElement, final Type pType) {
      return rawHasMatch(new Object[]{pElement, pType});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final DefinedElement pElement, final Type pType) {
      return rawCountMatches(new Object[]{pElement, pType});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final DefinedElement pElement, final Type pType, final Consumer<? super LowestCommonSupertypeOfAllOccuranceOfElement.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pElement, pType}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public LowestCommonSupertypeOfAllOccuranceOfElement.Match newMatch(final DefinedElement pElement, final Type pType) {
      return LowestCommonSupertypeOfAllOccuranceOfElement.Match.newMatch(pElement, pType);
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
    public Stream<DefinedElement> streamAllValuesOfelement(final LowestCommonSupertypeOfAllOccuranceOfElement.Match partialMatch) {
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
    public Stream<DefinedElement> streamAllValuesOfelement(final Type pType) {
      return rawStreamAllValuesOfelement(new Object[]{null, pType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DefinedElement> getAllValuesOfelement(final LowestCommonSupertypeOfAllOccuranceOfElement.Match partialMatch) {
      return rawStreamAllValuesOfelement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DefinedElement> getAllValuesOfelement(final Type pType) {
      return rawStreamAllValuesOfelement(new Object[]{null, pType}).collect(Collectors.toSet());
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
    public Stream<Type> streamAllValuesOftype(final LowestCommonSupertypeOfAllOccuranceOfElement.Match partialMatch) {
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
    public Stream<Type> streamAllValuesOftype(final DefinedElement pElement) {
      return rawStreamAllValuesOftype(new Object[]{pElement, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype(final LowestCommonSupertypeOfAllOccuranceOfElement.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype(final DefinedElement pElement) {
      return rawStreamAllValuesOftype(new Object[]{pElement, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected LowestCommonSupertypeOfAllOccuranceOfElement.Match tupleToMatch(final Tuple t) {
      try {
          return LowestCommonSupertypeOfAllOccuranceOfElement.Match.newMatch((DefinedElement) t.get(POSITION_ELEMENT), (Type) t.get(POSITION_TYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected LowestCommonSupertypeOfAllOccuranceOfElement.Match arrayToMatch(final Object[] match) {
      try {
          return LowestCommonSupertypeOfAllOccuranceOfElement.Match.newMatch((DefinedElement) match[POSITION_ELEMENT], (Type) match[POSITION_TYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected LowestCommonSupertypeOfAllOccuranceOfElement.Match arrayToMatchMutable(final Object[] match) {
      try {
          return LowestCommonSupertypeOfAllOccuranceOfElement.Match.newMutableMatch((DefinedElement) match[POSITION_ELEMENT], (Type) match[POSITION_TYPE]);
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
    public static IQuerySpecification<LowestCommonSupertypeOfAllOccuranceOfElement.Matcher> querySpecification() {
      return LowestCommonSupertypeOfAllOccuranceOfElement.instance();
    }
  }
  
  private LowestCommonSupertypeOfAllOccuranceOfElement() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static LowestCommonSupertypeOfAllOccuranceOfElement instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected LowestCommonSupertypeOfAllOccuranceOfElement.Matcher instantiate(final ViatraQueryEngine engine) {
    return LowestCommonSupertypeOfAllOccuranceOfElement.Matcher.on(engine);
  }
  
  @Override
  public LowestCommonSupertypeOfAllOccuranceOfElement.Matcher instantiate() {
    return LowestCommonSupertypeOfAllOccuranceOfElement.Matcher.create();
  }
  
  @Override
  public LowestCommonSupertypeOfAllOccuranceOfElement.Match newEmptyMatch() {
    return LowestCommonSupertypeOfAllOccuranceOfElement.Match.newEmptyMatch();
  }
  
  @Override
  public LowestCommonSupertypeOfAllOccuranceOfElement.Match newMatch(final Object... parameters) {
    return LowestCommonSupertypeOfAllOccuranceOfElement.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement) parameters[0], (hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link LowestCommonSupertypeOfAllOccuranceOfElement} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link LowestCommonSupertypeOfAllOccuranceOfElement#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final LowestCommonSupertypeOfAllOccuranceOfElement INSTANCE = new LowestCommonSupertypeOfAllOccuranceOfElement();
    
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
    private static final LowestCommonSupertypeOfAllOccuranceOfElement.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_element = new PParameter("element", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_type = new PParameter("type", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_element, parameter_type);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.lowestCommonSupertypeOfAllOccuranceOfElement";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("element","type");
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
          PVariable var_element = body.getOrCreateVariableByName("element");
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "DefinedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_element, parameter_element),
             new ExportedParameter(body, var_type, parameter_type)
          ));
          // 	find typeContainsAllOccuranceOfElement(element,type)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_element, var_type), TypeContainsAllOccuranceOfElement.instance().getInternalQueryRepresentation());
          // 	neg find hasLowerCommonSupertypeOfAllOccuranceOfElement(element, type, _)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_element, var_type, var___0_), HasLowerCommonSupertypeOfAllOccuranceOfElement.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
