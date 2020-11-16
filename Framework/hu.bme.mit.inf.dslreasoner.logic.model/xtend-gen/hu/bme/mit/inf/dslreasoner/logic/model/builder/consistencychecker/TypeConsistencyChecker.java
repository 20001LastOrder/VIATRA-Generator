package hu.bme.mit.inf.dslreasoner.logic.model.builder.consistencychecker;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicModelInterpretation;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicReasoner;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicReasonerException;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicSolverConfiguration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicproblemPackage;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.InconsistencyResult;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.LogicResult;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.LogicresultFactory;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.ModelResult;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.StatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.Statistics;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.StringStatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.UndecidableResult;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementNotDefinedInSupertype;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.ElementWithNoPossibleDynamicType;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.PossibleDynamicType;
import hu.bme.mit.inf.dslreasoner.logic.model.patterns.TypeSystemIsInconsistent;
import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TypeConsistencyChecker extends LogicReasoner {
  @Extension
  private final LogicresultFactory factory = LogicresultFactory.eINSTANCE;
  
  public TypeConsistencyChecker() {
    LogicproblemPackage.eINSTANCE.getClass();
  }
  
  @Override
  public LogicResult solve(final LogicProblem problem, final LogicSolverConfiguration configuration, final ReasonerWorkspace workspace) throws LogicReasonerException {
    Statistics _createStatistics = this.factory.createStatistics();
    final Procedure1<Statistics> _function = (Statistics it) -> {
      it.setTransformationTime(0);
      it.setSolverMemory((-1));
    };
    final Statistics statistics = ObjectExtensions.<Statistics>operator_doubleArrow(_createStatistics, _function);
    final long start = System.currentTimeMillis();
    EMFScope _eMFScope = new EMFScope(problem);
    final ViatraQueryEngine queryEngine = ViatraQueryEngine.on(_eMFScope);
    final TypeSystemIsInconsistent.Matcher typeSystemInconsistencyMatcher = TypeSystemIsInconsistent.Matcher.on(queryEngine);
    final ElementNotDefinedInSupertype.Matcher elementNotDefinedInSupertype = ElementNotDefinedInSupertype.Matcher.on(queryEngine);
    final ElementWithNoPossibleDynamicType.Matcher elementWithNoPossibleDynamicType = ElementWithNoPossibleDynamicType.Matcher.on(queryEngine);
    final PossibleDynamicType.Matcher possibleDynamicType = PossibleDynamicType.Matcher.on(queryEngine);
    final boolean hasErrorPatternMatch = typeSystemInconsistencyMatcher.hasMatch(problem);
    long _currentTimeMillis = System.currentTimeMillis();
    long _minus = (_currentTimeMillis - start);
    statistics.setSolverTime(((int) _minus));
    final Function1<DefinedElement, String> _function_1 = (DefinedElement e) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _name = e.getName();
      _builder.append(_name);
      _builder.append(": [");
      final Function1<Type, String> _function_2 = (Type it) -> {
        return it.getName();
      };
      String _join = IterableExtensions.join(IterableExtensions.<Type, String>map(possibleDynamicType.getAllValuesOfdynamic(problem, e), _function_2), ", ");
      _builder.append(_join);
      _builder.append("]");
      return _builder.toString();
    };
    final String possibleDynamicTypeStatisticEntry = IterableExtensions.join(ListExtensions.<DefinedElement, String>map(problem.getElements(), _function_1), "\n");
    if (hasErrorPatternMatch) {
      InconsistencyResult _createInconsistencyResult = this.factory.createInconsistencyResult();
      final Procedure1<InconsistencyResult> _function_2 = (InconsistencyResult it) -> {
        it.setProblem(problem);
        it.setStatistics(statistics);
        EList<StatisticEntry> _entries = it.getStatistics().getEntries();
        StringStatisticEntry _createStringStatisticEntry = this.factory.createStringStatisticEntry();
        final Procedure1<StringStatisticEntry> _function_3 = (StringStatisticEntry it_1) -> {
          it_1.setName("possibleDynamicType");
          it_1.setValue(possibleDynamicTypeStatisticEntry);
        };
        StringStatisticEntry _doubleArrow = ObjectExtensions.<StringStatisticEntry>operator_doubleArrow(_createStringStatisticEntry, _function_3);
        _entries.add(_doubleArrow);
        EList<StatisticEntry> _entries_1 = it.getStatistics().getEntries();
        StringStatisticEntry _createStringStatisticEntry_1 = this.factory.createStringStatisticEntry();
        final Procedure1<StringStatisticEntry> _function_4 = (StringStatisticEntry it_1) -> {
          it_1.setName("elementNotDefinedInSupertype");
          final Function1<DefinedElement, String> _function_5 = (DefinedElement it_2) -> {
            return it_2.getName();
          };
          it_1.setValue(IterableExtensions.join(IterableExtensions.<DefinedElement, String>map(elementNotDefinedInSupertype.getAllValuesOfelement(), _function_5), ", "));
        };
        StringStatisticEntry _doubleArrow_1 = ObjectExtensions.<StringStatisticEntry>operator_doubleArrow(_createStringStatisticEntry_1, _function_4);
        _entries_1.add(_doubleArrow_1);
        EList<StatisticEntry> _entries_2 = it.getStatistics().getEntries();
        StringStatisticEntry _createStringStatisticEntry_2 = this.factory.createStringStatisticEntry();
        final Procedure1<StringStatisticEntry> _function_5 = (StringStatisticEntry it_1) -> {
          it_1.setName("elementWithNoPossibleDynamicType");
          final Function1<DefinedElement, String> _function_6 = (DefinedElement it_2) -> {
            return it_2.getName();
          };
          it_1.setValue(IterableExtensions.join(IterableExtensions.<DefinedElement, String>map(elementWithNoPossibleDynamicType.getAllValuesOfelement(), _function_6), ", "));
        };
        StringStatisticEntry _doubleArrow_2 = ObjectExtensions.<StringStatisticEntry>operator_doubleArrow(_createStringStatisticEntry_2, _function_5);
        _entries_2.add(_doubleArrow_2);
      };
      return ObjectExtensions.<InconsistencyResult>operator_doubleArrow(_createInconsistencyResult, _function_2);
    } else {
      UndecidableResult _createUndecidableResult = this.factory.createUndecidableResult();
      final Procedure1<UndecidableResult> _function_3 = (UndecidableResult it) -> {
        it.setProblem(problem);
        it.setStatistics(statistics);
      };
      return ObjectExtensions.<UndecidableResult>operator_doubleArrow(_createUndecidableResult, _function_3);
    }
  }
  
  @Override
  public List<? extends LogicModelInterpretation> getInterpretations(final ModelResult modelResult) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("This solver is unable to create interpretations!");
    throw new UnsupportedOperationException(_builder.toString());
  }
}
