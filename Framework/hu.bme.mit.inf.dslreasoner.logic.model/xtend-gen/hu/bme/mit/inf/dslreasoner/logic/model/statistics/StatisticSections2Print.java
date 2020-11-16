package hu.bme.mit.inf.dslreasoner.logic.model.statistics;

import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.IntStatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.RealStatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.StatisticEntry;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.StringStatisticEntry;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class StatisticSections2Print {
  public CharSequence transformStatisticDatas2CSV(final List<StatisticEntry> statistics) {
    String result = "";
    for (final StatisticEntry statistic : statistics) {
      String _result = result;
      StringConcatenation _builder = new StringConcatenation();
      String _readValue = this.readValue(statistic);
      _builder.append(_readValue);
      _builder.append(",");
      result = (_result + _builder);
    }
    return result;
  }
  
  private String _readValue(final IntStatisticEntry e) {
    return Integer.valueOf(e.getValue()).toString();
  }
  
  private String _readValue(final RealStatisticEntry e) {
    return Double.valueOf(e.getValue()).toString();
  }
  
  private String _readValue(final StringStatisticEntry e) {
    return e.getValue();
  }
  
  private String readValue(final StatisticEntry e) {
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
