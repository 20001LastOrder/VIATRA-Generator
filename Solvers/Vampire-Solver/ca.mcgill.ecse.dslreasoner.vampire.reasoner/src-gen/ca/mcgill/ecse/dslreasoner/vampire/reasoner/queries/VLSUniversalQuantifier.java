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
 *         pattern VLSUniversalQuantifier(term: VLSUniversalQuantifier){
 *         	VLSUniversalQuantifier(term);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class VLSUniversalQuantifier extends BaseGeneratedEMFQuerySpecification<VLSUniversalQuantifier.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier pattern,
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
    private ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier fTerm;
    
    private static List<String> parameterNames = makeImmutableList("term");
    
    private Match(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
      this.fTerm = pTerm;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("term".equals(parameterName)) return this.fTerm;
      return null;
    }
    
    public ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier getTerm() {
      return this.fTerm;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("term".equals(parameterName) ) {
          this.fTerm = (ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier) newValue;
          return true;
      }
      return false;
    }
    
    public void setTerm(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTerm = pTerm;
    }
    
    @Override
    public String patternName() {
      return "ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier";
    }
    
    @Override
    public List<String> parameterNames() {
      return VLSUniversalQuantifier.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTerm};
    }
    
    @Override
    public VLSUniversalQuantifier.Match toImmutable() {
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
      if ((obj instanceof VLSUniversalQuantifier.Match)) {
          VLSUniversalQuantifier.Match other = (VLSUniversalQuantifier.Match) obj;
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
    public VLSUniversalQuantifier specification() {
      return VLSUniversalQuantifier.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static VLSUniversalQuantifier.Match newEmptyMatch() {
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
    public static VLSUniversalQuantifier.Match newMutableMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
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
    public static VLSUniversalQuantifier.Match newMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
      return new Immutable(pTerm);
    }
    
    private static final class Mutable extends VLSUniversalQuantifier.Match {
      Mutable(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
        super(pTerm);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends VLSUniversalQuantifier.Match {
      Immutable(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
        super(pTerm);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern VLSUniversalQuantifier(term: VLSUniversalQuantifier){
   * 	VLSUniversalQuantifier(term);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see VLSUniversalQuantifier
   * 
   */
  public static class Matcher extends BaseMatcher<VLSUniversalQuantifier.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static VLSUniversalQuantifier.Matcher on(final ViatraQueryEngine engine) {
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
    public static VLSUniversalQuantifier.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_TERM = 0;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VLSUniversalQuantifier.Matcher.class);
    
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
    public Collection<VLSUniversalQuantifier.Match> getAllMatches(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
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
    public Stream<VLSUniversalQuantifier.Match> streamAllMatches(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
      return rawStreamAllMatches(new Object[]{pTerm});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<VLSUniversalQuantifier.Match> getOneArbitraryMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
      return rawGetOneArbitraryMatch(new Object[]{pTerm});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
      return rawHasMatch(new Object[]{pTerm});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTerm the fixed value of pattern parameter term, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
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
    public boolean forOneArbitraryMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm, final Consumer<? super VLSUniversalQuantifier.Match> processor) {
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
    public VLSUniversalQuantifier.Match newMatch(final ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier pTerm) {
      return VLSUniversalQuantifier.Match.newMatch(pTerm);
    }
    
    /**
     * Retrieve the set of values that occur in matches for term.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier> rawStreamAllValuesOfterm(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TERM, parameters).map(ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for term.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier> getAllValuesOfterm() {
      return rawStreamAllValuesOfterm(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for term.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier> streamAllValuesOfterm() {
      return rawStreamAllValuesOfterm(emptyArray());
    }
    
    @Override
    protected VLSUniversalQuantifier.Match tupleToMatch(final Tuple t) {
      try {
          return VLSUniversalQuantifier.Match.newMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier) t.get(POSITION_TERM));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected VLSUniversalQuantifier.Match arrayToMatch(final Object[] match) {
      try {
          return VLSUniversalQuantifier.Match.newMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier) match[POSITION_TERM]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected VLSUniversalQuantifier.Match arrayToMatchMutable(final Object[] match) {
      try {
          return VLSUniversalQuantifier.Match.newMutableMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier) match[POSITION_TERM]);
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
    public static IQuerySpecification<VLSUniversalQuantifier.Matcher> querySpecification() {
      return VLSUniversalQuantifier.instance();
    }
  }
  
  private VLSUniversalQuantifier() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static VLSUniversalQuantifier instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected VLSUniversalQuantifier.Matcher instantiate(final ViatraQueryEngine engine) {
    return VLSUniversalQuantifier.Matcher.on(engine);
  }
  
  @Override
  public VLSUniversalQuantifier.Matcher instantiate() {
    return VLSUniversalQuantifier.Matcher.create();
  }
  
  @Override
  public VLSUniversalQuantifier.Match newEmptyMatch() {
    return VLSUniversalQuantifier.Match.newEmptyMatch();
  }
  
  @Override
  public VLSUniversalQuantifier.Match newMatch(final Object... parameters) {
    return VLSUniversalQuantifier.Match.newMatch((ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier (visibility: PUBLIC, simpleName: VLSUniversalQuantifier, identifier: ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier (visibility: PUBLIC, simpleName: VLSUniversalQuantifier, identifier: ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static VLSUniversalQuantifier INSTANCE = new VLSUniversalQuantifier();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static VLSUniversalQuantifier.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_term = new PParameter("term", "ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSUniversalQuantifier", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.mcgill.ca/ecse/dslreasoner/VampireLanguage", "VLSUniversalQuantifier")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_term);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "ca.mcgill.ecse.dslreasoner.vampire.reasoner.queries.VLSUniversalQuantifier";
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
          new TypeConstraint(body, Tuples.flatTupleOf(var_term), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.mcgill.ca/ecse/dslreasoner/VampireLanguage", "VLSUniversalQuantifier")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_term, parameter_term)
          ));
          // 	VLSUniversalQuantifier(term)
          new TypeConstraint(body, Tuples.flatTupleOf(var_term), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.mcgill.ca/ecse/dslreasoner/VampireLanguage", "VLSUniversalQuantifier")));
          bodies.add(body);
      }
      return bodies;
    }
  }
}