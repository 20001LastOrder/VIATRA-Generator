/**
 * generated by Xtext 2.12.0
 */
package hu.bme.mit.inf.dslreasoner.vampireLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VLS Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasoner.vampireLanguage.VLSVariable#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.inf.dslreasoner.vampireLanguage.VampireLanguagePackage#getVLSVariable()
 * @model
 * @generated
 */
public interface VLSVariable extends VLSTerm
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see hu.bme.mit.inf.dslreasoner.vampireLanguage.VampireLanguagePackage#getVLSVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.inf.dslreasoner.vampireLanguage.VLSVariable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // VLSVariable
