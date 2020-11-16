/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns;

import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementNotDefinedInSupertype;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementWithNoPossibleDynamicType;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.ParameterReference;
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
 *         /// Validation patterns ///
 *         
 *         {@literal @}Constraint(severity = "warning",key = {problem},
 *         	message="Type system is inconsistent."
 *         )
 *         pattern typeSystemIsInconsistent(problem:LogicProblem) {
 *         	find elementWithNoPossibleDynamicType(problem,_);
 *         } or {
 *         	find elementNotDefinedInSupertype(problem,_,_,_);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TypeSystemIsInconsistent extends BaseGeneratedEMFQuerySpecification<TypeSystemIsInconsistent.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.typeSystemIsInconsistent pattern,
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
    
    private static List<String> parameterNames = makeImmutableList("problem");
    
    private Match(final LogicProblem pProblem) {
      this.fProblem = pProblem;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "problem": return this.fProblem;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fProblem;
          default: return null;
      }
    }
    
    public LogicProblem getProblem() {
      return this.fProblem;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("problem".equals(parameterName) ) {
          this.fProblem = (LogicProblem) newValue;
          return true;
      }
      return false;
    }
    
    public void setProblem(final LogicProblem pProblem) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fProblem = pProblem;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.typeSystemIsInconsistent";
    }
    
    @Override
    public List<String> parameterNames() {
      return TypeSystemIsInconsistent.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fProblem};
    }
    
    @Override
    public TypeSystemIsInconsistent.Match toImmutable() {
      return isMutable() ? newMatch(fProblem) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"problem\"=" + prettyPrintValue(fProblem));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fProblem);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TypeSystemIsInconsistent.Match)) {
          TypeSystemIsInconsistent.Match other = (TypeSystemIsInconsistent.Match) obj;
          return Objects.equals(fProblem, other.fProblem);
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
    public TypeSystemIsInconsistent specification() {
      return TypeSystemIsInconsistent.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TypeSystemIsInconsistent.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TypeSystemIsInconsistent.Match newMutableMatch(final LogicProblem pProblem) {
      return new Mutable(pProblem);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TypeSystemIsInconsistent.Match newMatch(final LogicProblem pProblem) {
      return new Immutable(pProblem);
    }
    
    private static final class Mutable extends TypeSystemIsInconsistent.Match {
      Mutable(final LogicProblem pProblem) {
        super(pProblem);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends TypeSystemIsInconsistent.Match {
      Immutable(final LogicProblem pProblem) {
        super(pProblem);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.logic.model.patterns.typeSystemIsInconsistent pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * /// Validation patterns ///
   * 
   * {@literal @}Constraint(severity = "warning",key = {problem},
   * 	message="Type system is inconsistent."
   * )
   * pattern typeSystemIsInconsistent(problem:LogicProblem) {
   * 	find elementWithNoPossibleDynamicType(problem,_);
   * } or {
   * 	find elementNotDefinedInSupertype(problem,_,_,_);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TypeSystemIsInconsistent
   * 
   */
  public static class Matcher extends BaseMatcher<TypeSystemIsInconsistent.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TypeSystemIsInconsistent.Matcher on(final ViatraQueryEngine engine) {
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
    public static TypeSystemIsInconsistent.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PROBLEM = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TypeSystemIsInconsistent.Matcher.class);
    
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
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TypeSystemIsInconsistent.Match> getAllMatches(final LogicProblem pProblem) {
      return rawStreamAllMatches(new Object[]{pProblem}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TypeSystemIsInconsistent.Match> streamAllMatches(final LogicProblem pProblem) {
      return rawStreamAllMatches(new Object[]{pProblem});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TypeSystemIsInconsistent.Match> getOneArbitraryMatch(final LogicProblem pProblem) {
      return rawGetOneArbitraryMatch(new Object[]{pProblem});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final LogicProblem pProblem) {
      return rawHasMatch(new Object[]{pProblem});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final LogicProblem pProblem) {
      return rawCountMatches(new Object[]{pProblem});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final LogicProblem pProblem, final Consumer<? super TypeSystemIsInconsistent.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pProblem}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pProblem the fixed value of pattern parameter problem, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TypeSystemIsInconsistent.Match newMatch(final LogicProblem pProblem) {
      return TypeSystemIsInconsistent.Match.newMatch(pProblem);
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
    
    @Override
    protected TypeSystemIsInconsistent.Match tupleToMatch(final Tuple t) {
      try {
          return TypeSystemIsInconsistent.Match.newMatch((LogicProblem) t.get(POSITION_PROBLEM));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TypeSystemIsInconsistent.Match arrayToMatch(final Object[] match) {
      try {
          return TypeSystemIsInconsistent.Match.newMatch((LogicProblem) match[POSITION_PROBLEM]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TypeSystemIsInconsistent.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TypeSystemIsInconsistent.Match.newMutableMatch((LogicProblem) match[POSITION_PROBLEM]);
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
    public static IQuerySpecification<TypeSystemIsInconsistent.Matcher> querySpecification() {
      return TypeSystemIsInconsistent.instance();
    }
  }
  
  private TypeSystemIsInconsistent() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TypeSystemIsInconsistent instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TypeSystemIsInconsistent.Matcher instantiate(final ViatraQueryEngine engine) {
    return TypeSystemIsInconsistent.Matcher.on(engine);
  }
  
  @Override
  public TypeSystemIsInconsistent.Matcher instantiate() {
    return TypeSystemIsInconsistent.Matcher.create();
  }
  
  @Override
  public TypeSystemIsInconsistent.Match newEmptyMatch() {
    return TypeSystemIsInconsistent.Match.newEmptyMatch();
  }
  
  @Override
  public TypeSystemIsInconsistent.Match newMatch(final Object... parameters) {
    return TypeSystemIsInconsistent.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link TypeSystemIsInconsistent} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TypeSystemIsInconsistent#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TypeSystemIsInconsistent INSTANCE = new TypeSystemIsInconsistent();
    
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
    private static final TypeSystemIsInconsistent.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_problem = new PParameter("problem", "hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_problem);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.logic.model.patterns.typeSystemIsInconsistent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("problem");
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
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_problem, parameter_problem)
          ));
          // 	find elementWithNoPossibleDynamicType(problem,_)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_problem, var___0_), ElementWithNoPossibleDynamicType.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_problem = body.getOrCreateVariableByName("problem");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_problem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/problem", "LogicProblem")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_problem, parameter_problem)
          ));
          // 	find elementNotDefinedInSupertype(problem,_,_,_)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_problem, var___0_, var___1_, var___2_), ElementNotDefinedInSupertype.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      {
          PAnnotation annotation = new PAnnotation("Constraint");
          annotation.addAttribute("severity", "warning");
          annotation.addAttribute("key", Arrays.asList(new Object[] {
                              new ParameterReference("problem")
                              }));
          annotation.addAttribute("message", "Type system is inconsistent.");
          addAnnotation(annotation);
      }
      return bodies;
    }
  }
}
