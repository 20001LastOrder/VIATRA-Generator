/**
 * generated by Xtext 2.21.0
 */
package org.eclipse.viatra.solver.language.solverLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extern Predicate Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.solver.language.solverLanguage.ExternPredicateDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.viatra.solver.language.solverLanguage.ExternPredicateDefinition#getArgumentList <em>Argument List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getExternPredicateDefinition()
 * @model
 * @generated
 */
public interface ExternPredicateDefinition extends Statement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getExternPredicateDefinition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.solver.language.solverLanguage.ExternPredicateDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Argument List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument List</em>' containment reference.
	 * @see #setArgumentList(ArgumentList)
	 * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getExternPredicateDefinition_ArgumentList()
	 * @model containment="true"
	 * @generated
	 */
	ArgumentList getArgumentList();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.solver.language.solverLanguage.ExternPredicateDefinition#getArgumentList <em>Argument List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument List</em>' containment reference.
	 * @see #getArgumentList()
	 * @generated
	 */
	void setArgumentList(ArgumentList value);

} // ExternPredicateDefinition