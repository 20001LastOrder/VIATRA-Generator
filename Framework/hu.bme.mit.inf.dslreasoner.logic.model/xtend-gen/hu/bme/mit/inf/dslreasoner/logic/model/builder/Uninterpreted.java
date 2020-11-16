package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicModelInterpretation;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.ConstantDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.FunctionDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.SortedSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Uninterpreted implements LogicModelInterpretation {
  /**
   * private val static unknownBecauseUninterpreted = LogiclanguageFactory.eINSTANCE.createUnknownBecauseUninterpreted
   * public def static getUnknownBecauseUninterpreted() {return Uninterpreted.unknownBecauseUninterpreted}
   */
  @Override
  public List<DefinedElement> getElements(final Type type) {
    throw new UnsupportedOperationException("The interpteration is unknown.");
  }
  
  public List<DefinedElement> getKnownElements(final Type type) {
    final Function1<Type, Iterable<Type>> _function = (Type it) -> {
      return it.getSubtypes();
    };
    final List<Type> allSubtypes = CollectionsUtil.<Type>transitiveClosureStar(type, _function);
    final Function1<TypeDefinition, EList<DefinedElement>> _function_1 = (TypeDefinition it) -> {
      return it.getElements();
    };
    return IterableExtensions.<DefinedElement>toList(Iterables.<DefinedElement>concat(IterableExtensions.<TypeDefinition, EList<DefinedElement>>map(Iterables.<TypeDefinition>filter(allSubtypes, TypeDefinition.class), _function_1)));
  }
  
  public boolean allElementsAreInterpreted(final Type type) {
    final Function1<Type, Iterable<Type>> _function = (Type it) -> {
      return it.getSubtypes();
    };
    final List<Type> allSubtypes = CollectionsUtil.<Type>transitiveClosureStar(type, _function);
    final Function1<Type, Boolean> _function_1 = (Type it) -> {
      return Boolean.valueOf((it instanceof TypeDeclaration));
    };
    return IterableExtensions.<Type>exists(allSubtypes, _function_1);
  }
  
  @Override
  public Object getInterpretation(final FunctionDeclaration function, final Object[] parameterSubstitution) {
    throw new UnsupportedOperationException("The interpteration is unknown.");
  }
  
  @Override
  public boolean getInterpretation(final RelationDeclaration relation, final Object[] parameterSubstitution) {
    throw new UnsupportedOperationException("The interpteration is unknown.");
  }
  
  @Override
  public Object getInterpretation(final ConstantDeclaration constant) {
    throw new UnsupportedOperationException("The interpteration is unknown.");
  }
  
  @Override
  public SortedSet<Integer> getAllIntegersInStructure() {
    throw new UnsupportedOperationException("The interpteration is unknown.");
  }
  
  @Override
  public SortedSet<BigDecimal> getAllRealsInStructure() {
    throw new UnsupportedOperationException("The interpteration is unknown.");
  }
  
  @Override
  public SortedSet<String> getAllStringsInStructure() {
    throw new UnsupportedOperationException("The interpteration is unknown.");
  }
}
