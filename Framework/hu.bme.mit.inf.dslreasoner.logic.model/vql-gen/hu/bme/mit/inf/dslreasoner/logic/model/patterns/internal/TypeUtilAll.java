/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal;

import hu.bme.mit.inf.dslreasoner.logic.model.patterns.CyclicTypeHierarchy;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementNotDefinedInSupertype;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementWithNoPossibleDynamicType;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.MustTypeElement;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.PossibleDynamicType;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.SupertypeStar;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.TypeDirectElements;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.TypeSystemIsInconsistent;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal.DynamicTypeIsSubtypeOfANonDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal.DynamicTypeNotSubtypeOfADefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal.SupertypeDirect;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.internal.TypesWithDefinedSupertype;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all patterns defined in typeUtil.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package hu.bme.mit.inf.dslreasoner.logic.model.patterns, the group contains the definition of the following patterns: <ul>
 * <li>supertypeDirect</li>
 * <li>supertypeStar</li>
 * <li>typeDirectElements</li>
 * <li>possibleDynamicType</li>
 * <li>dynamicTypeNotSubtypeOfADefinition</li>
 * <li>dynamicTypeIsSubtypeOfANonDefinition</li>
 * <li>typesWithDefinedSupertype</li>
 * <li>mustTypeElement</li>
 * <li>typeSystemIsInconsistent</li>
 * <li>elementNotDefinedInSupertype</li>
 * <li>elementWithNoPossibleDynamicType</li>
 * <li>cyclicTypeHierarchy</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class TypeUtilAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TypeUtilAll instance() {
    if (INSTANCE == null) {
        INSTANCE = new TypeUtilAll();
    }
    return INSTANCE;
  }
  
  private static TypeUtilAll INSTANCE;
  
  private TypeUtilAll() {
    querySpecifications.add(SupertypeDirect.instance());
    querySpecifications.add(SupertypeStar.instance());
    querySpecifications.add(TypeDirectElements.instance());
    querySpecifications.add(PossibleDynamicType.instance());
    querySpecifications.add(DynamicTypeNotSubtypeOfADefinition.instance());
    querySpecifications.add(DynamicTypeIsSubtypeOfANonDefinition.instance());
    querySpecifications.add(TypesWithDefinedSupertype.instance());
    querySpecifications.add(MustTypeElement.instance());
    querySpecifications.add(TypeSystemIsInconsistent.instance());
    querySpecifications.add(ElementNotDefinedInSupertype.instance());
    querySpecifications.add(ElementWithNoPossibleDynamicType.instance());
    querySpecifications.add(CyclicTypeHierarchy.instance());
  }
}
