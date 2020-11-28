/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/typeQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.LowermostCommonSupertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.LowestCommonSupertypeOfAllOccuranceOfElement;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.Supertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.TopmostCommonSubtypes;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in typeQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file typeQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries, the group contains the definition of the following patterns: <ul>
 * <li>supertype</li>
 * <li>topmostCommonSubtypes</li>
 * <li>lowermostCommonSupertype</li>
 * <li>lowestCommonSupertypeOfAllOccuranceOfElement</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class TypeQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TypeQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new TypeQueries();
    }
    return INSTANCE;
  }
  
  private static TypeQueries INSTANCE;
  
  private TypeQueries() {
    querySpecifications.add(Supertype.instance());
    querySpecifications.add(TopmostCommonSubtypes.instance());
    querySpecifications.add(LowermostCommonSupertype.instance());
    querySpecifications.add(LowestCommonSupertypeOfAllOccuranceOfElement.instance());
  }
  
  public Supertype getSupertype() {
    return Supertype.instance();
  }
  
  public Supertype.Matcher getSupertype(final ViatraQueryEngine engine) {
    return Supertype.Matcher.on(engine);
  }
  
  public TopmostCommonSubtypes getTopmostCommonSubtypes() {
    return TopmostCommonSubtypes.instance();
  }
  
  public TopmostCommonSubtypes.Matcher getTopmostCommonSubtypes(final ViatraQueryEngine engine) {
    return TopmostCommonSubtypes.Matcher.on(engine);
  }
  
  public LowermostCommonSupertype getLowermostCommonSupertype() {
    return LowermostCommonSupertype.instance();
  }
  
  public LowermostCommonSupertype.Matcher getLowermostCommonSupertype(final ViatraQueryEngine engine) {
    return LowermostCommonSupertype.Matcher.on(engine);
  }
  
  public LowestCommonSupertypeOfAllOccuranceOfElement getLowestCommonSupertypeOfAllOccuranceOfElement() {
    return LowestCommonSupertypeOfAllOccuranceOfElement.instance();
  }
  
  public LowestCommonSupertypeOfAllOccuranceOfElement.Matcher getLowestCommonSupertypeOfAllOccuranceOfElement(final ViatraQueryEngine engine) {
    return LowestCommonSupertypeOfAllOccuranceOfElement.Matcher.on(engine);
  }
}
