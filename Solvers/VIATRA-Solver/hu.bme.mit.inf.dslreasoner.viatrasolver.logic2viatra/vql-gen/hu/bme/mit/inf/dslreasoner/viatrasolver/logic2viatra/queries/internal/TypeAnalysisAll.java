/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra/patterns/hu/bme/mit/inf/dslreasoner/viatrasolver/logic2viatra/queries/TypeAnalysis.vql
 */
package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal;

import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.DontHaveDefinedSupertype;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.HasDefinedSupertype;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.IncompatibleSuperType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.IncompatibleTopType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementMayTypeNegativeConstraint;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementTypeConstructor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementTypeRefinementNegativeConstraint;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementTypeRefinementTarget;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.IncompatibleType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.PossibleNewElementDynamicType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.SupertypeDirect;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.SupertypePlus;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.internal.SupertypeStar;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all patterns defined in TypeAnalysis.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries, the group contains the definition of the following patterns: <ul>
 * <li>supertypeDirect</li>
 * <li>supertypePlus</li>
 * <li>supertypeStar</li>
 * <li>hasDefinedSupertype</li>
 * <li>dontHaveDefinedSupertype</li>
 * <li>possibleNewElementDynamicType</li>
 * <li>newElementTypeConstructor</li>
 * <li>newElementTypeRefinementTarget</li>
 * <li>incompatibleType</li>
 * <li>incompatibleSuperType</li>
 * <li>incompatibleTopType</li>
 * <li>newElementTypeRefinementNegativeConstraint</li>
 * <li>newElementMayTypeNegativeConstraint</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class TypeAnalysisAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TypeAnalysisAll instance() {
    if (INSTANCE == null) {
        INSTANCE = new TypeAnalysisAll();
    }
    return INSTANCE;
  }
  
  private static TypeAnalysisAll INSTANCE;
  
  private TypeAnalysisAll() {
    querySpecifications.add(SupertypeDirect.instance());
    querySpecifications.add(SupertypePlus.instance());
    querySpecifications.add(SupertypeStar.instance());
    querySpecifications.add(HasDefinedSupertype.instance());
    querySpecifications.add(DontHaveDefinedSupertype.instance());
    querySpecifications.add(PossibleNewElementDynamicType.instance());
    querySpecifications.add(NewElementTypeConstructor.instance());
    querySpecifications.add(NewElementTypeRefinementTarget.instance());
    querySpecifications.add(IncompatibleType.instance());
    querySpecifications.add(IncompatibleSuperType.instance());
    querySpecifications.add(IncompatibleTopType.instance());
    querySpecifications.add(NewElementTypeRefinementNegativeConstraint.instance());
    querySpecifications.add(NewElementMayTypeNegativeConstraint.instance());
  }
}
