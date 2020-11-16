/**
 * Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.logic.model/patterns/hu/bme/mit/inf/dslreasoner/logic/model/patterns/typeUtil.vql
 */
package hu.bme.mit.inf.dslreasoner.logic.model.patterns;

import hu.bme.mit.inf.dslreasoner.logic.model.patterns.CyclicTypeHierarchy;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementNotDefinedInSupertype;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementWithNoPossibleDynamicType;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.MustTypeElement;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.PossibleDynamicType;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.SupertypeStar;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.TypeDirectElements;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.TypeSystemIsInconsistent;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in typeUtil.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file typeUtil.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.dslreasoner.logic.model.patterns, the group contains the definition of the following patterns: <ul>
 * <li>supertypeStar</li>
 * <li>typeDirectElements</li>
 * <li>possibleDynamicType</li>
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
public final class TypeUtil extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TypeUtil instance() {
    if (INSTANCE == null) {
        INSTANCE = new TypeUtil();
    }
    return INSTANCE;
  }
  
  private static TypeUtil INSTANCE;
  
  private TypeUtil() {
    querySpecifications.add(SupertypeStar.instance());
    querySpecifications.add(TypeDirectElements.instance());
    querySpecifications.add(PossibleDynamicType.instance());
    querySpecifications.add(MustTypeElement.instance());
    querySpecifications.add(TypeSystemIsInconsistent.instance());
    querySpecifications.add(ElementNotDefinedInSupertype.instance());
    querySpecifications.add(ElementWithNoPossibleDynamicType.instance());
    querySpecifications.add(CyclicTypeHierarchy.instance());
  }
  
  public SupertypeStar getSupertypeStar() {
    return SupertypeStar.instance();
  }
  
  public SupertypeStar.Matcher getSupertypeStar(final ViatraQueryEngine engine) {
    return SupertypeStar.Matcher.on(engine);
  }
  
  public TypeDirectElements getTypeDirectElements() {
    return TypeDirectElements.instance();
  }
  
  public TypeDirectElements.Matcher getTypeDirectElements(final ViatraQueryEngine engine) {
    return TypeDirectElements.Matcher.on(engine);
  }
  
  public PossibleDynamicType getPossibleDynamicType() {
    return PossibleDynamicType.instance();
  }
  
  public PossibleDynamicType.Matcher getPossibleDynamicType(final ViatraQueryEngine engine) {
    return PossibleDynamicType.Matcher.on(engine);
  }
  
  public MustTypeElement getMustTypeElement() {
    return MustTypeElement.instance();
  }
  
  public MustTypeElement.Matcher getMustTypeElement(final ViatraQueryEngine engine) {
    return MustTypeElement.Matcher.on(engine);
  }
  
  public TypeSystemIsInconsistent getTypeSystemIsInconsistent() {
    return TypeSystemIsInconsistent.instance();
  }
  
  public TypeSystemIsInconsistent.Matcher getTypeSystemIsInconsistent(final ViatraQueryEngine engine) {
    return TypeSystemIsInconsistent.Matcher.on(engine);
  }
  
  public ElementNotDefinedInSupertype getElementNotDefinedInSupertype() {
    return ElementNotDefinedInSupertype.instance();
  }
  
  public ElementNotDefinedInSupertype.Matcher getElementNotDefinedInSupertype(final ViatraQueryEngine engine) {
    return ElementNotDefinedInSupertype.Matcher.on(engine);
  }
  
  public ElementWithNoPossibleDynamicType getElementWithNoPossibleDynamicType() {
    return ElementWithNoPossibleDynamicType.instance();
  }
  
  public ElementWithNoPossibleDynamicType.Matcher getElementWithNoPossibleDynamicType(final ViatraQueryEngine engine) {
    return ElementWithNoPossibleDynamicType.Matcher.on(engine);
  }
  
  public CyclicTypeHierarchy getCyclicTypeHierarchy() {
    return CyclicTypeHierarchy.instance();
  }
  
  public CyclicTypeHierarchy.Matcher getCyclicTypeHierarchy(final ViatraQueryEngine engine) {
    return CyclicTypeHierarchy.Matcher.on(engine);
  }
}
