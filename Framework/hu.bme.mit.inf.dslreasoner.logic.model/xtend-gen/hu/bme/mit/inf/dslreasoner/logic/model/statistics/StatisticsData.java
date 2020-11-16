package hu.bme.mit.inf.dslreasoner.logic.model.statistics;

import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.Statistics;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class StatisticsData {
  public List<Pair<String, String>> inputConfiguration;
  
  public List<Pair<String, String>> outputMetrics;
  
  public Statistics solverStatistics;
}
