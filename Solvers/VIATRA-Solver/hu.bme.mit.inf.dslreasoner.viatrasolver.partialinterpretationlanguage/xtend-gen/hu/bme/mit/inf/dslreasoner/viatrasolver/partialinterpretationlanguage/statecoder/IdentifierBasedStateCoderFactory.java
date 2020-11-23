package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.IdentifierBasedStateCoder;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.dse.statecode.IStateCoderFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class IdentifierBasedStateCoderFactory implements IStateCoderFactory {
  private final List<IdentifierBasedStateCoder> statecoders = new LinkedList<IdentifierBasedStateCoder>();
  
  @Override
  public synchronized IStateCoder createStateCoder() {
    final IdentifierBasedStateCoder res = new IdentifierBasedStateCoder();
    this.statecoders.add(res);
    return res;
  }
  
  public Long getSumStatecoderRuntime() {
    final Function1<IdentifierBasedStateCoder, Long> _function = (IdentifierBasedStateCoder it) -> {
      return Long.valueOf(it.getStatecoderRuntime());
    };
    final Function2<Long, Long, Long> _function_1 = (Long p1, Long p2) -> {
      return Long.valueOf(((p1).longValue() + (p2).longValue()));
    };
    return IterableExtensions.<Long>reduce(ListExtensions.<IdentifierBasedStateCoder, Long>map(this.statecoders, _function), _function_1);
  }
}
