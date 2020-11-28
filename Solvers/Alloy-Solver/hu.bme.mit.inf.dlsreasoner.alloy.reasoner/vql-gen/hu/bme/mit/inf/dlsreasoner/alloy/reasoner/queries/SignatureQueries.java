/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/signatureQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.DirectSubset;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.Subset;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in signatureQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file signatureQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries, the group contains the definition of the following patterns: <ul>
 * <li>directSubset</li>
 * <li>subset</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class SignatureQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static SignatureQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new SignatureQueries();
    }
    return INSTANCE;
  }
  
  private static SignatureQueries INSTANCE;
  
  private SignatureQueries() {
    querySpecifications.add(DirectSubset.instance());
    querySpecifications.add(Subset.instance());
  }
  
  public DirectSubset getDirectSubset() {
    return DirectSubset.instance();
  }
  
  public DirectSubset.Matcher getDirectSubset(final ViatraQueryEngine engine) {
    return DirectSubset.Matcher.on(engine);
  }
  
  public Subset getSubset() {
    return Subset.instance();
  }
  
  public Subset.Matcher getSubset(final ViatraQueryEngine engine) {
    return Subset.Matcher.on(engine);
  }
}
