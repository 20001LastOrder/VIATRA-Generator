package hu.bme.mit.inf.dslreasoner.logic.model.statistics;

import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.IntStatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.RealStatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.StatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.Statistics;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.StringStatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.statistics.StatisticsData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class StatisticSections2CSV {
  private static final String separator = ",";
  
  private static final String empty = "";
  
  private String getValue(final Map<String, String> map, final String key) {
    boolean _containsKey = map.containsKey(key);
    if (_containsKey) {
      return map.get(key);
    } else {
      return StatisticSections2CSV.empty;
    }
  }
  
  private boolean addKey(final List<String> list, final String newValue) {
    boolean _xifexpression = false;
    boolean _contains = list.contains(newValue);
    boolean _not = (!_contains);
    if (_not) {
      _xifexpression = list.add(newValue);
    }
    return _xifexpression;
  }
  
  public CharSequence transformStatisticDatas2CSV(final List<StatisticsData> statistics) {
    final LinkedList<String> inputConfigurationColumns = new LinkedList<String>();
    int _length = ((Object[])Conversions.unwrapArray(statistics, Object.class)).length;
    final ArrayList<Map<String, String>> inputConfigurationValues = new ArrayList<Map<String, String>>(_length);
    final LinkedList<String> solverStatisticColumns = new LinkedList<String>();
    int _length_1 = ((Object[])Conversions.unwrapArray(statistics, Object.class)).length;
    final ArrayList<Map<String, String>> solverStatisticValues = new ArrayList<Map<String, String>>(_length_1);
    final LinkedList<String> outputMetricColumns = new LinkedList<String>();
    int _length_2 = ((Object[])Conversions.unwrapArray(statistics, Object.class)).length;
    final ArrayList<Map<String, String>> outputMetricValues = new ArrayList<Map<String, String>>(_length_2);
    final Function1<StatisticsData, List<Pair<String, String>>> _function = (StatisticsData it) -> {
      return it.inputConfiguration;
    };
    this.indexColumnsForPairs(ListExtensions.<StatisticsData, List<Pair<String, String>>>map(statistics, _function), inputConfigurationColumns, inputConfigurationValues);
    final Function1<StatisticsData, Statistics> _function_1 = (StatisticsData it) -> {
      return it.solverStatistics;
    };
    this.indexColumnsForEntries(ListExtensions.<StatisticsData, Statistics>map(statistics, _function_1), solverStatisticColumns, solverStatisticValues);
    final Function1<StatisticsData, List<Pair<String, String>>> _function_2 = (StatisticsData it) -> {
      return it.outputMetrics;
    };
    this.indexColumnsForPairs(ListExtensions.<StatisticsData, List<Pair<String, String>>>map(statistics, _function_2), outputMetricColumns, outputMetricValues);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ID");
    {
      int _length_3 = ((Object[])Conversions.unwrapArray(inputConfigurationColumns, Object.class)).length;
      boolean _greaterThan = (_length_3 > 0);
      if (_greaterThan) {
        _builder.append(StatisticSections2CSV.separator);
        {
          boolean _hasElements = false;
          for(final String name : inputConfigurationColumns) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(StatisticSections2CSV.separator, "");
            }
            _builder.append(name);
          }
        }
      }
    }
    _builder.append(StatisticSections2CSV.separator);
    _builder.append("Transformation_Time");
    _builder.append(StatisticSections2CSV.separator);
    _builder.append("Solver_Time");
    _builder.append(StatisticSections2CSV.separator);
    _builder.append("Solver_Memory");
    {
      int _length_4 = ((Object[])Conversions.unwrapArray(solverStatisticColumns, Object.class)).length;
      boolean _greaterThan_1 = (_length_4 > 0);
      if (_greaterThan_1) {
        _builder.append(StatisticSections2CSV.separator);
      }
    }
    {
      boolean _hasElements_1 = false;
      for(final String name_1 : solverStatisticColumns) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(StatisticSections2CSV.separator, "");
        }
        _builder.append(name_1);
      }
    }
    {
      int _length_5 = ((Object[])Conversions.unwrapArray(outputMetricColumns, Object.class)).length;
      boolean _greaterThan_2 = (_length_5 > 0);
      if (_greaterThan_2) {
        _builder.append(StatisticSections2CSV.separator);
      }
    }
    {
      boolean _hasElements_2 = false;
      for(final String name_2 : outputMetricColumns) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(StatisticSections2CSV.separator, "");
        }
        _builder.append(name_2);
      }
    }
    _builder.newLineIfNotEmpty();
    {
      int _size = statistics.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index : _doubleDotLessThan) {
        _builder.append(((index).intValue() + 1));
        {
          int _size_1 = inputConfigurationColumns.size();
          boolean _greaterThan_3 = (_size_1 > 0);
          if (_greaterThan_3) {
            _builder.append(StatisticSections2CSV.separator);
          }
        }
        {
          boolean _hasElements_3 = false;
          for(final String name_3 : inputConfigurationColumns) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate(StatisticSections2CSV.separator, "");
            }
            String _value = this.getValue(inputConfigurationValues.get((index).intValue()), name_3);
            _builder.append(_value);
          }
        }
        _builder.append(StatisticSections2CSV.separator);
        int _transformationTime = statistics.get((index).intValue()).solverStatistics.getTransformationTime();
        _builder.append(_transformationTime);
        _builder.append(StatisticSections2CSV.separator);
        int _solverTime = statistics.get((index).intValue()).solverStatistics.getSolverTime();
        _builder.append(_solverTime);
        _builder.append(StatisticSections2CSV.separator);
        int _solverMemory = statistics.get((index).intValue()).solverStatistics.getSolverMemory();
        _builder.append(_solverMemory);
        {
          int _size_2 = solverStatisticColumns.size();
          boolean _greaterThan_4 = (_size_2 > 0);
          if (_greaterThan_4) {
            _builder.append(StatisticSections2CSV.separator);
          }
        }
        {
          boolean _hasElements_4 = false;
          for(final String name_4 : solverStatisticColumns) {
            if (!_hasElements_4) {
              _hasElements_4 = true;
            } else {
              _builder.appendImmediate(StatisticSections2CSV.separator, "");
            }
            String _value_1 = this.getValue(solverStatisticValues.get((index).intValue()), name_4);
            _builder.append(_value_1);
          }
        }
        {
          int _size_3 = outputMetricColumns.size();
          boolean _greaterThan_5 = (_size_3 > 0);
          if (_greaterThan_5) {
            _builder.append(StatisticSections2CSV.separator);
          }
        }
        {
          boolean _hasElements_5 = false;
          for(final String name_5 : outputMetricColumns) {
            if (!_hasElements_5) {
              _hasElements_5 = true;
            } else {
              _builder.appendImmediate(StatisticSections2CSV.separator, "");
            }
            String _value_2 = this.getValue(outputMetricValues.get((index).intValue()), name_5);
            _builder.append(_value_2);
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private void indexColumnsForPairs(final List<List<Pair<String, String>>> datas, final List<String> columns, final List<Map<String, String>> values) {
    for (final List<Pair<String, String>> inputConfiguration : datas) {
      {
        final HashMap<String, String> map = new HashMap<String, String>();
        for (final Pair<String, String> entry : inputConfiguration) {
          {
            this.addKey(columns, entry.getKey());
            map.put(entry.getKey(), entry.getValue());
          }
        }
        values.add(map);
      }
    }
  }
  
  private void indexColumnsForEntries(final List<Statistics> datas, final List<String> columns, final List<Map<String, String>> values) {
    for (final Statistics inputConfiguration : datas) {
      {
        final HashMap<String, String> map = new HashMap<String, String>();
        EList<StatisticEntry> _entries = inputConfiguration.getEntries();
        for (final StatisticEntry entry : _entries) {
          {
            this.addKey(columns, entry.getName());
            map.put(entry.getName(), this.readValue(entry));
          }
        }
        values.add(map);
      }
    }
  }
  
  public String _readValue(final IntStatisticEntry e) {
    return Integer.valueOf(e.getValue()).toString();
  }
  
  public String _readValue(final RealStatisticEntry e) {
    return Double.valueOf(e.getValue()).toString();
  }
  
  public String _readValue(final StringStatisticEntry e) {
    return e.getValue();
  }
  
  public String readValue(final StatisticEntry e) {
    if (e instanceof IntStatisticEntry) {
      return _readValue((IntStatisticEntry)e);
    } else if (e instanceof RealStatisticEntry) {
      return _readValue((RealStatisticEntry)e);
    } else if (e instanceof StringStatisticEntry) {
      return _readValue((StringStatisticEntry)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
