/**
 * Generated from platform:/resource/ca.mcgill.ecse.dslreasoner.vampire.reasoner/queries/ca/mcgill/ecse/dslreasoner/vampire/reasoner/queries/vampireQueries.vql
 */
package ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries;

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
 *         pattern VLSUnaryNegation(term: VLSUnaryNegation){
 *         	VLSUnaryNegation(term);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class VLSUnaryNegation extends BaseGeneratedEMFQuerySpecification<VLSUnaryNegation.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUnaryNegation pattern,
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
    private ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation fTerm;
    
    private static List<String> parameterNames = makeImmutableList("term");
    
    private Match(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      this.fTerm = pTerm;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "term": return this.fTerm;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fTerm;
          default: return null;
      }
    }
    
    public ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation getTerm() {
      return this.fTerm;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("term".equals(parameterName) ) {
          this.fTerm = (ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation) newValue;
          return true;
      }
      return false;
    }
    
    public void setTerm(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTerm = pTerm;
    }
    
    @Override
    public String patternName() {
      return "ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUnaryNegation";
    }
    
    @Override
    public List<String> parameterNames() {
      return VLSUnaryNegation.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTerm};
    }
    
    @Override
    public VLSUnaryNegation.Match toImmutable() {
      return isMutable() ? newMatch(fTerm) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"term\"=" + prettyPrintValue(fTerm));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fTerm);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof VLSUnaryNegation.Match)) {
          VLSUnaryNegation.Match other = (VLSUnaryNegation.Match) obj;
          return Objects.equals(fTerm, other.fTerm);
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
    public VLSUnaryNegation specification() {
      return VLSUnaryNegation.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static VLSUnaryNegation.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static VLSUnaryNegation.Match newMutableMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return new Mutable(pTerm);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static VLSUnaryNegation.Match newMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return new Immutable(pTerm);
    }
    
    private static final class Mutable extends VLSUnaryNegation.Match {
      Mutable(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
        super(pTerm);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends VLSUnaryNegation.Match {
      Immutable(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
        super(pTerm);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUnaryNegation pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern VLSUnaryNegation(term: VLSUnaryNegation){
   * 	VLSUnaryNegation(term);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see VLSUnaryNegation
   * 
   */
  public static class Matcher extends BaseMatcher<VLSUnaryNegation.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static VLSUnaryNegation.Matcher on(final ViatraQueryEngine engine) {
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
    public static VLSUnaryNegation.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TERM = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VLSUnaryNegation.Matcher.class);
    
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
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<VLSUnaryNegation.Match> getAllMatches(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return rawStreamAllMatches(new Object[]{pTerm}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<VLSUnaryNegation.Match> streamAllMatches(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return rawStreamAllMatches(new Object[]{pTerm});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<VLSUnaryNegation.Match> getOneArbitraryMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return rawGetOneArbitraryMatch(new Object[]{pTerm});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return rawHasMatch(new Object[]{pTerm});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return rawCountMatches(new Object[]{pTerm});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm, final Consumer<? super VLSUnaryNegation.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTerm}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public VLSUnaryNegation.Match newMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation pTerm) {
      return VLSUnaryNegation.Match.newMatch(pTerm);
    }
    
    /**
     * Retrieve the set of values that occur in matches for term.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation> rawStreamAllValuesOfterm(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TERM, parameters).map(ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for term.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation> getAllValuesOfterm() {
      return rawStreamAllValuesOfterm(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for term.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation> streamAllValuesOfterm() {
      return rawStreamAllValuesOfterm(emptyArray());
    }
    
    @Override
    protected VLSUnaryNegation.Match tupleToMatch(final Tuple t) {
      try {
          return VLSUnaryNegation.Match.newMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation) t.get(POSITION_TERM));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected VLSUnaryNegation.Match arrayToMatch(final Object[] match) {
      try {
          return VLSUnaryNegation.Match.newMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation) match[POSITION_TERM]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected VLSUnaryNegation.Match arrayToMatchMutable(final Object[] match) {
      try {
          return VLSUnaryNegation.Match.newMutableMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation) match[POSITION_TERM]);
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
    public static IQuerySpecification<VLSUnaryNegation.Matcher> querySpecification() {
      return VLSUnaryNegation.instance();
    }
  }
  
  private VLSUnaryNegation() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static VLSUnaryNegation instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected VLSUnaryNegation.Matcher instantiate(final ViatraQueryEngine engine) {
    return VLSUnaryNegation.Matcher.on(engine);
  }
  
  @Override
  public VLSUnaryNegation.Matcher instantiate() {
    return VLSUnaryNegation.Matcher.create();
  }
  
  @Override
  public VLSUnaryNegation.Match newEmptyMatch() {
    return VLSUnaryNegation.Match.newEmptyMatch();
  }
  
  @Override
  public VLSUnaryNegation.Match newMatch(final Object... parameters) {
    return VLSUnaryNegation.Match.newMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link VLSUnaryNegation} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link VLSUnaryNegation#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final VLSUnaryNegation INSTANCE = new VLSUnaryNegation();
    
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
    private static final VLSUnaryNegation.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_term = new PParameter("term", "ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUnaryNegation", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.mcgill.ca/ecse/dslreasoner/VampireLanguage", "VLSUnaryNegation")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_term);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUnaryNegation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("term");
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
          PVariable var_term = body.getOrCreateVariableByName("term");
          new TypeConstraint(body, Tuples.flatTupleOf(var_term), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.mcgill.ca/ecse/dslreasoner/VampireLanguage", "VLSUnaryNegation")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_term, parameter_term)
          ));
          // 	VLSUnaryNegation(term)
          new TypeConstraint(body, Tuples.flatTupleOf(var_term), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.mcgill.ca/ecse/dslreasoner/VampireLanguage", "VLSUnaryNegation")));
          bodies.add(body);
      }
      return bodies;
    }
  }
}
