/**
 * Generated from platform:/resource/hu.bme.mit.inf.dlsreasoner.alloy.reasoner/queries/hu/bme/mit/inf/dlsreasoner/alloy/reasoner/queries/typeQueries.vql
 */
package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal;

import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.LowermostCommonSupertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.LowestCommonSupertypeOfAllOccuranceOfElement;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.Supertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.TopmostCommonSubtypes;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.CommonSubtype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.CommonSupertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.HasHigherCommonSubtype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.HasLowerCommonSupertype;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.HasLowerCommonSupertypeOfAllOccuranceOfElement;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.SupertypeEdge;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.TypeContainsAllOccuranceOfElement;
import hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries.internal.TypeDoesNotCoverElementOccurance;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all patterns defined in typeQueries.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package hu.bme.mit.inf.dlsreasoner.alloy.reasoner.queries, the group contains the definition of the following patterns: <ul>
 * <li>supertypeEdge</li>
 * <li>supertype</li>
 * <li>commonSubtype</li>
 * <li>commonSupertype</li>
 * <li>hasHigherCommonSubtype</li>
 * <li>hasLowerCommonSupertype</li>
 * <li>topmostCommonSubtypes</li>
 * <li>lowermostCommonSupertype</li>
 * <li>lowestCommonSupertypeOfAllOccuranceOfElement</li>
 * <li>hasLowerCommonSupertypeOfAllOccuranceOfElement</li>
 * <li>typeContainsAllOccuranceOfElement</li>
 * <li>typeDoesNotCoverElementOccurance</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class TypeQueriesAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TypeQueriesAll instance() {
    if (INSTANCE == null) {
        INSTANCE = new TypeQueriesAll();
    }
    return INSTANCE;
  }
  
  private static TypeQueriesAll INSTANCE;
  
  private TypeQueriesAll() {
    querySpecifications.add(SupertypeEdge.instance());
    querySpecifications.add(Supertype.instance());
    querySpecifications.add(CommonSubtype.instance());
    querySpecifications.add(CommonSupertype.instance());
    querySpecifications.add(HasHigherCommonSubtype.instance());
    querySpecifications.add(HasLowerCommonSupertype.instance());
    querySpecifications.add(TopmostCommonSubtypes.instance());
    querySpecifications.add(LowermostCommonSupertype.instance());
    querySpecifications.add(LowestCommonSupertypeOfAllOccuranceOfElement.instance());
    querySpecifications.add(HasLowerCommonSupertypeOfAllOccuranceOfElement.instance());
    querySpecifications.add(TypeContainsAllOccuranceOfElement.instance());
    querySpecifications.add(TypeDoesNotCoverElementOccurance.instance());
  }
}
