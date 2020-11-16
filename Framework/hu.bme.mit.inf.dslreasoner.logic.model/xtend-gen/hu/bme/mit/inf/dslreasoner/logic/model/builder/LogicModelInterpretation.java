package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.BoolLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ConstantDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.FunctionDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.IntLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.LogiclanguageFactory;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RealLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.StringLiteral;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public interface LogicModelInterpretation {
  /**
   * Returns the elements of a type.
   */
  List<DefinedElement> getElements(final Type type);
  
  /**
   * Returns the interpretation of a function. The parameters and the return values are encoded to primitive java objects defined by the following table:
   * <p><table>
   * <tr><th>Term type</th><th>Java object type</th></tr>
   * <tr><td>Element of a type </td><td>DefinedElement </td></tr>
   * <tr><td>Boolean literal </td><td>Boolean </td></tr>
   * <tr><td>Integer literal </td><td>Integer </td></tr>
   * <tr><td>Real literal </td><td>BigDecimal </td></tr>
   * <tr><td>String literal </td><td>String </td></tr>
   * </table></p>
   * @param function The target function to be interpreted.
   * @param parameterSubstitution The array of the substituted parameters encoded as defined in the table.
   * @return The result of the function call encoded as defined in the table.
   */
  Object getInterpretation(final FunctionDeclaration function, final Object[] parameterSubstitution);
  
  /**
   * Returns the interpretation of a relation. The parameters are encoded to primitive java objects defined by the following table:
   * <p><table>
   * <tr><th>Term type</th><th>Java object type</th></tr>
   * <tr><td>Element of a type </td><td>DefinedElement </td></tr>
   * <tr><td>Boolean literal </td><td>Boolean </td></tr>
   * <tr><td>Integer literal </td><td>Integer </td></tr>
   * <tr><td>Real literal </td><td>BigDecimal </td></tr>
   * <tr><td>String literal </td><td>String </td></tr>
   * </table></p>
   * @param relation The target relation to be interpreted.
   * @param parameterSubstitution The array of the substituted parameters encoded as defined in the table.
   * @return If the parameter tuple is in the relation.
   */
  boolean getInterpretation(final RelationDeclaration relation, final Object[] parameterSubstitution);
  
  /**
   * Returns the interpretation of a constant. The value is encoded to primitive java objects defined by the following table:
   * <p><table>
   * <tr><th>Term type</th><th>Java object type</th></tr>
   * <tr><td>Element of a type </td><td>DefinedElement </td></tr>
   * <tr><td>Boolean literal </td><td>Boolean </td></tr>
   * <tr><td>Integer literal </td><td>Integer </td></tr>
   * <tr><td>Real literal </td><td>BigDecimal </td></tr>
   * <tr><td>String literal </td><td>String </td></tr>
   * </table></p>
   * @param constant The target constant to be interpreted.
   * @return The value of the constant encoded as specified in the table.
   */
  Object getInterpretation(final ConstantDeclaration constant);
  
  /**
   * Returns all integers relevant to the logic structure. Not all integer is necessarily used.
   */
  SortedSet<Integer> getAllIntegersInStructure();
  
  default Map<TermDescription, Integer> getAllIntegersWithInterpretation() {
    final Function1<Integer, TermDescription> _function = (Integer integer) -> {
      IntLiteral _createIntLiteral = LogiclanguageFactory.eINSTANCE.createIntLiteral();
      final Procedure1<IntLiteral> _function_1 = (IntLiteral it) -> {
        it.setValue((integer).intValue());
      };
      IntLiteral _doubleArrow = ObjectExtensions.<IntLiteral>operator_doubleArrow(_createIntLiteral, _function_1);
      return ((TermDescription) _doubleArrow);
    };
    return IterableExtensions.<TermDescription, Integer>toMap(this.getAllIntegersInStructure(), _function);
  }
  
  /**
   * Returns all real numbers relevant to the logic structure. Not all integer is necessarily used.
   */
  SortedSet<BigDecimal> getAllRealsInStructure();
  
  default Map<TermDescription, BigDecimal> getAllRealsWithInterpretation() {
    final Function1<BigDecimal, TermDescription> _function = (BigDecimal real) -> {
      RealLiteral _createRealLiteral = LogiclanguageFactory.eINSTANCE.createRealLiteral();
      final Procedure1<RealLiteral> _function_1 = (RealLiteral it) -> {
        it.setValue(real);
      };
      RealLiteral _doubleArrow = ObjectExtensions.<RealLiteral>operator_doubleArrow(_createRealLiteral, _function_1);
      return ((TermDescription) _doubleArrow);
    };
    return IterableExtensions.<TermDescription, BigDecimal>toMap(this.getAllRealsInStructure(), _function);
  }
  
  /**
   * Returns all string values relevant to the logic structure. Not all integer is necessarily used.
   */
  SortedSet<String> getAllStringsInStructure();
  
  default Map<TermDescription, String> getAllStringsWithInterpretation() {
    final Function1<String, TermDescription> _function = (String string) -> {
      StringLiteral _createStringLiteral = LogiclanguageFactory.eINSTANCE.createStringLiteral();
      final Procedure1<StringLiteral> _function_1 = (StringLiteral it) -> {
        it.setValue(string);
      };
      StringLiteral _doubleArrow = ObjectExtensions.<StringLiteral>operator_doubleArrow(_createStringLiteral, _function_1);
      return ((TermDescription) _doubleArrow);
    };
    return IterableExtensions.<TermDescription, String>toMap(this.getAllStringsInStructure(), _function);
  }
  
  default SortedSet<Boolean> getAllBooleansInStructure() {
    return new TreeSet<Boolean>(Collections.<Boolean>unmodifiableSet(CollectionLiterals.<Boolean>newHashSet(Boolean.valueOf(true), Boolean.valueOf(false))));
  }
  
  default Map<TermDescription, Boolean> getAllBooleansWithInterpretation() {
    final Function1<Boolean, TermDescription> _function = (Boolean bool) -> {
      BoolLiteral _createBoolLiteral = LogiclanguageFactory.eINSTANCE.createBoolLiteral();
      final Procedure1<BoolLiteral> _function_1 = (BoolLiteral it) -> {
        it.setValue((bool).booleanValue());
      };
      BoolLiteral _doubleArrow = ObjectExtensions.<BoolLiteral>operator_doubleArrow(_createBoolLiteral, _function_1);
      return ((TermDescription) _doubleArrow);
    };
    return IterableExtensions.<TermDescription, Boolean>toMap(this.getAllBooleansInStructure(), _function);
  }
}
