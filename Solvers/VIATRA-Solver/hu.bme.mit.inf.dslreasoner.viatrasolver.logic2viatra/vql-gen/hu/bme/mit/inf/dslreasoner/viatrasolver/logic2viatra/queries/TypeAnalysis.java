/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra/patterns/hu/bme/mit/inf/dslreasoner/viatrasolver/logic2viatra/queries/TypeAnalysis.vql
 */
package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries;

import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.DontHaveDefinedSupertype;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.HasDefinedSupertype;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.IncompatibleSuperType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.IncompatibleTopType;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementMayTypeNegativeConstraint;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementTypeConstructor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementTypeRefinementNegativeConstraint;
import hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries.NewElementTypeRefinementTarget;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in TypeAnalysis.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file TypeAnalysis.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.queries, the group contains the definition of the following patterns: <ul>
 * <li>hasDefinedSupertype</li>
 * <li>dontHaveDefinedSupertype</li>
 * <li>newElementTypeConstructor</li>
 * <li>newElementTypeRefinementTarget</li>
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
public final class TypeAnalysis extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TypeAnalysis instance() {
    if (INSTANCE == null) {
        INSTANCE = new TypeAnalysis();
    }
    return INSTANCE;
  }
  
  private static TypeAnalysis INSTANCE;
  
  private TypeAnalysis() {
    querySpecifications.add(HasDefinedSupertype.instance());
    querySpecifications.add(DontHaveDefinedSupertype.instance());
    querySpecifications.add(NewElementTypeConstructor.instance());
    querySpecifications.add(NewElementTypeRefinementTarget.instance());
    querySpecifications.add(IncompatibleSuperType.instance());
    querySpecifications.add(IncompatibleTopType.instance());
    querySpecifications.add(NewElementTypeRefinementNegativeConstraint.instance());
    querySpecifications.add(NewElementMayTypeNegativeConstraint.instance());
  }
  
  public HasDefinedSupertype getHasDefinedSupertype() {
    return HasDefinedSupertype.instance();
  }
  
  public HasDefinedSupertype.Matcher getHasDefinedSupertype(final ViatraQueryEngine engine) {
    return HasDefinedSupertype.Matcher.on(engine);
  }
  
  public DontHaveDefinedSupertype getDontHaveDefinedSupertype() {
    return DontHaveDefinedSupertype.instance();
  }
  
  public DontHaveDefinedSupertype.Matcher getDontHaveDefinedSupertype(final ViatraQueryEngine engine) {
    return DontHaveDefinedSupertype.Matcher.on(engine);
  }
  
  public NewElementTypeConstructor getNewElementTypeConstructor() {
    return NewElementTypeConstructor.instance();
  }
  
  public NewElementTypeConstructor.Matcher getNewElementTypeConstructor(final ViatraQueryEngine engine) {
    return NewElementTypeConstructor.Matcher.on(engine);
  }
  
  public NewElementTypeRefinementTarget getNewElementTypeRefinementTarget() {
    return NewElementTypeRefinementTarget.instance();
  }
  
  public NewElementTypeRefinementTarget.Matcher getNewElementTypeRefinementTarget(final ViatraQueryEngine engine) {
    return NewElementTypeRefinementTarget.Matcher.on(engine);
  }
  
  public IncompatibleSuperType getIncompatibleSuperType() {
    return IncompatibleSuperType.instance();
  }
  
  public IncompatibleSuperType.Matcher getIncompatibleSuperType(final ViatraQueryEngine engine) {
    return IncompatibleSuperType.Matcher.on(engine);
  }
  
  public IncompatibleTopType getIncompatibleTopType() {
    return IncompatibleTopType.instance();
  }
  
  public IncompatibleTopType.Matcher getIncompatibleTopType(final ViatraQueryEngine engine) {
    return IncompatibleTopType.Matcher.on(engine);
  }
  
  public NewElementTypeRefinementNegativeConstraint getNewElementTypeRefinementNegativeConstraint() {
    return NewElementTypeRefinementNegativeConstraint.instance();
  }
  
  public NewElementTypeRefinementNegativeConstraint.Matcher getNewElementTypeRefinementNegativeConstraint(final ViatraQueryEngine engine) {
    return NewElementTypeRefinementNegativeConstraint.Matcher.on(engine);
  }
  
  public NewElementMayTypeNegativeConstraint getNewElementMayTypeNegativeConstraint() {
    return NewElementMayTypeNegativeConstraint.instance();
  }
  
  public NewElementMayTypeNegativeConstraint.Matcher getNewElementMayTypeNegativeConstraint(final ViatraQueryEngine engine) {
    return NewElementMayTypeNegativeConstraint.Matcher.on(engine);
  }
}
