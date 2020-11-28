/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra/patterns/hu/bme/mit/inf/dslreasoner/viatrasolver/logic2viatra/queries/TypeAnalysis.vql
 */
package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.HasDefinedSupertype;
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
 *         pattern dontHaveDefinedSupertype(type:TypeDeclaration) {
 *         	neg find hasDefinedSupertype(type);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class DontHaveDefinedSupertype extends BaseGeneratedEMFQuerySpecification<DontHaveDefinedSupertype.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.dontHaveDefinedSupertype pattern,
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
    
    private static List<String> parameterNames = makeImmutableList("type");
    
    private Match(final TypeDeclaration pType) {
      this.fType = pType;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "type": return this.fType;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fType;
          default: return null;
      }
    }
    
    public TypeDeclaration getType() {
      return this.fType;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("type".equals(parameterName) ) {
          this.fType = (TypeDeclaration) newValue;
          return true;
      }
      return false;
    }
    
    public void setType(final TypeDeclaration pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.dontHaveDefinedSupertype";
    }
    
    @Override
    public List<String> parameterNames() {
      return DontHaveDefinedSupertype.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fType};
    }
    
    @Override
    public DontHaveDefinedSupertype.Match toImmutable() {
      return isMutable() ? newMatch(fType) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"type\"=" + prettyPrintValue(fType));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fType);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof DontHaveDefinedSupertype.Match)) {
          DontHaveDefinedSupertype.Match other = (DontHaveDefinedSupertype.Match) obj;
          return Objects.equals(fType, other.fType);
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
    public DontHaveDefinedSupertype specification() {
      return DontHaveDefinedSupertype.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static DontHaveDefinedSupertype.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static DontHaveDefinedSupertype.Match newMutableMatch(final TypeDeclaration pType) {
      return new Mutable(pType);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static DontHaveDefinedSupertype.Match newMatch(final TypeDeclaration pType) {
      return new Immutable(pType);
    }
    
    private static final class Mutable extends DontHaveDefinedSupertype.Match {
      Mutable(final TypeDeclaration pType) {
        super(pType);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends DontHaveDefinedSupertype.Match {
      Immutable(final TypeDeclaration pType) {
        super(pType);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.dontHaveDefinedSupertype pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern dontHaveDefinedSupertype(type:TypeDeclaration) {
   * 	neg find hasDefinedSupertype(type);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see DontHaveDefinedSupertype
   * 
   */
  public static class Matcher extends BaseMatcher<DontHaveDefinedSupertype.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static DontHaveDefinedSupertype.Matcher on(final ViatraQueryEngine engine) {
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
    public static DontHaveDefinedSupertype.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TYPE = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(DontHaveDefinedSupertype.Matcher.class);
    
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
     * @return matches represented as a Match object.
     * 
     */
    public Collection<DontHaveDefinedSupertype.Match> getAllMatches(final TypeDeclaration pType) {
      return rawStreamAllMatches(new Object[]{pType}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<DontHaveDefinedSupertype.Match> streamAllMatches(final TypeDeclaration pType) {
      return rawStreamAllMatches(new Object[]{pType});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<DontHaveDefinedSupertype.Match> getOneArbitraryMatch(final TypeDeclaration pType) {
      return rawGetOneArbitraryMatch(new Object[]{pType});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final TypeDeclaration pType) {
      return rawHasMatch(new Object[]{pType});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final TypeDeclaration pType) {
      return rawCountMatches(new Object[]{pType});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final TypeDeclaration pType, final Consumer<? super DontHaveDefinedSupertype.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pType}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public DontHaveDefinedSupertype.Match newMatch(final TypeDeclaration pType) {
      return DontHaveDefinedSupertype.Match.newMatch(pType);
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
    
    @Override
    protected DontHaveDefinedSupertype.Match tupleToMatch(final Tuple t) {
      try {
          return DontHaveDefinedSupertype.Match.newMatch((TypeDeclaration) t.get(POSITION_TYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected DontHaveDefinedSupertype.Match arrayToMatch(final Object[] match) {
      try {
          return DontHaveDefinedSupertype.Match.newMatch((TypeDeclaration) match[POSITION_TYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected DontHaveDefinedSupertype.Match arrayToMatchMutable(final Object[] match) {
      try {
          return DontHaveDefinedSupertype.Match.newMutableMatch((TypeDeclaration) match[POSITION_TYPE]);
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
    public static IQuerySpecification<DontHaveDefinedSupertype.Matcher> querySpecification() {
      return DontHaveDefinedSupertype.instance();
    }
  }
  
  private DontHaveDefinedSupertype() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static DontHaveDefinedSupertype instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected DontHaveDefinedSupertype.Matcher instantiate(final ViatraQueryEngine engine) {
    return DontHaveDefinedSupertype.Matcher.on(engine);
  }
  
  @Override
  public DontHaveDefinedSupertype.Matcher instantiate() {
    return DontHaveDefinedSupertype.Matcher.create();
  }
  
  @Override
  public DontHaveDefinedSupertype.Match newEmptyMatch() {
    return DontHaveDefinedSupertype.Match.newEmptyMatch();
  }
  
  @Override
  public DontHaveDefinedSupertype.Match newMatch(final Object... parameters) {
    return DontHaveDefinedSupertype.Match.newMatch((hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link DontHaveDefinedSupertype} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link DontHaveDefinedSupertype#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final DontHaveDefinedSupertype INSTANCE = new DontHaveDefinedSupertype();
    
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
    private static final DontHaveDefinedSupertype.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_type = new PParameter("type", "hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_type);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.dontHaveDefinedSupertype";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("type");
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
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.bme.hu/mit/inf/dslreasoner/logic/model/language", "TypeDeclaration")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_type, parameter_type)
          ));
          // 	neg find hasDefinedSupertype(type)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_type), HasDefinedSupertype.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
