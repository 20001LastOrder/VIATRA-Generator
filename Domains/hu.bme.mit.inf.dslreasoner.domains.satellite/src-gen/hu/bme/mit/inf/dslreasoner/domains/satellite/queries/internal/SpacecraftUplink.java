/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.domains.satellite/src/hu/bme/mit/inf/dslreasoner/domains/satellite/queries/SatelliteQueries.vql
 */
package hu.bme.mit.inf.dslreasoner.domains.satellite.queries.internal;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecificationWithGenericMatcher;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate GenericPatternMatcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         private pattern spacecraftUplink(Spacecraft : Spacecraft, Band : TransceiverBand, Target : CommunicatingElement) {
 *         	CommunicatingElement.communicationLink(Spacecraft, Link);
 *         	DirectedCommunicationLink.source.band(Link, Band);
 *         	DirectedCommunicationLink.target(Link, TargetSubsystem);
 *         	CommunicatingElement.commSubsystem(Target, TargetSubsystem);
 *         }
 * </pre></code>
 * 
 * @see GenericPatternMatcher
 * @see GenericPatternMatch
 * 
 */
@SuppressWarnings("all")
public final class SpacecraftUplink extends BaseGeneratedEMFQuerySpecificationWithGenericMatcher {
  private SpacecraftUplink() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SpacecraftUplink instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.inf.dslreasoner.domains.satellite.queries.internal.SpacecraftUplink (visibility: PUBLIC, simpleName: SpacecraftUplink, identifier: hu.bme.mit.inf.dslreasoner.domains.satellite.queries.internal.SpacecraftUplink, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.inf.dslreasoner.domains.satellite.queries.internal) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.inf.dslreasoner.domains.satellite.queries.internal.SpacecraftUplink (visibility: PUBLIC, simpleName: SpacecraftUplink, identifier: hu.bme.mit.inf.dslreasoner.domains.satellite.queries.internal.SpacecraftUplink, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.inf.dslreasoner.domains.satellite.queries.internal) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SpacecraftUplink INSTANCE = new SpacecraftUplink();
    
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
    private static final SpacecraftUplink.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_Spacecraft = new PParameter("Spacecraft", "hu.bme.mit.inf.dslreasoner.domains.satellite.Spacecraft", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.example.org/satellite", "Spacecraft")), PParameterDirection.INOUT);
    
    private final PParameter parameter_Band = new PParameter("Band", "hu.bme.mit.inf.dslreasoner.domains.satellite.TransceiverBand", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://www.example.org/satellite", "TransceiverBand")), PParameterDirection.INOUT);
    
    private final PParameter parameter_Target = new PParameter("Target", "hu.bme.mit.inf.dslreasoner.domains.satellite.CommunicatingElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.example.org/satellite", "CommunicatingElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_Spacecraft, parameter_Band, parameter_Target);
    
    private GeneratedPQuery() {
      super(PVisibility.PRIVATE);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.dslreasoner.domains.satellite.queries.spacecraftUplink";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Spacecraft","Band","Target");
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
          PVariable var_Spacecraft = body.getOrCreateVariableByName("Spacecraft");
          PVariable var_Band = body.getOrCreateVariableByName("Band");
          PVariable var_Target = body.getOrCreateVariableByName("Target");
          PVariable var_Link = body.getOrCreateVariableByName("Link");
          PVariable var_TargetSubsystem = body.getOrCreateVariableByName("TargetSubsystem");
          new TypeConstraint(body, Tuples.flatTupleOf(var_Spacecraft), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "Spacecraft")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_Band), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.example.org/satellite", "TransceiverBand")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_Target), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "CommunicatingElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_Spacecraft, parameter_Spacecraft),
             new ExportedParameter(body, var_Band, parameter_Band),
             new ExportedParameter(body, var_Target, parameter_Target)
          ));
          // 	CommunicatingElement.communicationLink(Spacecraft, Link)
          new TypeConstraint(body, Tuples.flatTupleOf(var_Spacecraft), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "CommunicatingElement")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_Spacecraft, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.example.org/satellite", "CommunicatingElement", "communicationLink")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "DirectedCommunicationLink")));
          new Equality(body, var__virtual_0_, var_Link);
          // 	DirectedCommunicationLink.source.band(Link, Band)
          new TypeConstraint(body, Tuples.flatTupleOf(var_Link), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "DirectedCommunicationLink")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_Link, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.example.org/satellite", "DirectedCommunicationLink", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "CommSubsystem")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.example.org/satellite", "CommSubsystem", "band")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.example.org/satellite", "TransceiverBand")));
          new Equality(body, var__virtual_2_, var_Band);
          // 	DirectedCommunicationLink.target(Link, TargetSubsystem)
          new TypeConstraint(body, Tuples.flatTupleOf(var_Link), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "DirectedCommunicationLink")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_Link, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.example.org/satellite", "DirectedCommunicationLink", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "CommSubsystem")));
          new Equality(body, var__virtual_3_, var_TargetSubsystem);
          // 	CommunicatingElement.commSubsystem(Target, TargetSubsystem)
          new TypeConstraint(body, Tuples.flatTupleOf(var_Target), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "CommunicatingElement")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_Target, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.example.org/satellite", "CommunicatingElement", "commSubsystem")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.example.org/satellite", "CommSubsystem")));
          new Equality(body, var__virtual_4_, var_TargetSubsystem);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
