/**
 * generated by Xtext 2.12.0
 */
package hu.bme.mit.inf.dslreasoner.vampireLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VLS Defined Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.vampireLanguage.VLSDefinedTerm#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.inf.dslreasoner.vampireLanguage.VampireLanguagePackage#getVLSDefinedTerm()
 * @model
 * @generated
 */
public interface VLSDefinedTerm extends VLSTerm
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see hu.bme.mit.inf.dslreasoner.vampireLanguage.VampireLanguagePackage#getVLSDefinedTerm_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link hu.bme.mit.inf.dslreasoner.vampireLanguage.VLSDefinedTerm#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // VLSDefinedTerm
