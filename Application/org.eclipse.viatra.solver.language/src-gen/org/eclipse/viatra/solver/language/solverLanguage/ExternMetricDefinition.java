/**
 * generated by Xtext 2.21.0
 */
package org.eclipse.viatra.solver.language.solverLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extern Metric Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.solver.language.solverLanguage.ExternMetricDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.viatra.solver.language.solverLanguage.ExternMetricDefinition#getHead <em>Head</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getExternMetricDefinition()
 * @model
 * @generated
 */
public interface ExternMetricDefinition extends Statement
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.viatra.solver.language.solverLanguage.MetricType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.viatra.solver.language.solverLanguage.MetricType
   * @see #setType(MetricType)
   * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getExternMetricDefinition_Type()
   * @model
   * @generated
   */
  MetricType getType();

  /**
   * Sets the value of the '{@link org.eclipse.viatra.solver.language.solverLanguage.ExternMetricDefinition#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.viatra.solver.language.solverLanguage.MetricType
   * @see #getType()
   * @generated
   */
  void setType(MetricType value);

  /**
   * Returns the value of the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Head</em>' containment reference.
   * @see #setHead(Call)
   * @see org.eclipse.viatra.solver.language.solverLanguage.SolverLanguagePackage#getExternMetricDefinition_Head()
   * @model containment="true"
   * @generated
   */
  Call getHead();

  /**
   * Sets the value of the '{@link org.eclipse.viatra.solver.language.solverLanguage.ExternMetricDefinition#getHead <em>Head</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Head</em>' containment reference.
   * @see #getHead()
   * @generated
   */
  void setHead(Call value);

} // ExternMetricDefinition