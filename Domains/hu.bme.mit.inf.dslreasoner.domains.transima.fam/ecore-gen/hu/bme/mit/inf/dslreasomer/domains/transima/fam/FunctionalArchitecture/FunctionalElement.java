/**
 */
package hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalElement#getInterface <em>Interface</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalElement#getModel <em>Model</em>}</li>
 *   <li>{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalElement#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalArchitecturePackage#getFunctionalElement()
 * @model abstract="true"
 * @generated
 */
public interface FunctionalElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalInterface#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' containment reference.
	 * @see #setInterface(FunctionalInterface)
	 * @see hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalArchitecturePackage#getFunctionalElement_Interface()
	 * @see hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalInterface#getElement
	 * @model opposite="element" containment="true"
	 * @generated
	 */
	FunctionalInterface getInterface();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalElement#getInterface <em>Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' containment reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(FunctionalInterface value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(FunctionalArchitectureModel)
	 * @see hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalArchitecturePackage#getFunctionalElement_Model()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='hu.bme.mit.inf.dslreasoner.domains.transima.fam.patterns.model'"
	 * @generated
	 */
	FunctionalArchitectureModel getModel();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalElement#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(FunctionalArchitectureModel value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.Function#getSubElements <em>Sub Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Function)
	 * @see hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalArchitecturePackage#getFunctionalElement_Parent()
	 * @see hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.Function#getSubElements
	 * @model opposite="subElements" transient="false"
	 * @generated
	 */
	Function getParent();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.dslreasomer.domains.transima.fam.FunctionalArchitecture.FunctionalElement#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Function value);

} // FunctionalElement
