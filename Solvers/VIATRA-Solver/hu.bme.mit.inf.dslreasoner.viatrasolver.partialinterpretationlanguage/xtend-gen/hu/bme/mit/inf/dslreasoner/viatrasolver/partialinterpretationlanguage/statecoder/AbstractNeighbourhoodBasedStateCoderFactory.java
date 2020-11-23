package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder.AbstractNeighbourhoodBasedPartialInterpretationStateCoder;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.dse.statecode.IStateCoderFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class AbstractNeighbourhoodBasedStateCoderFactory implements IStateCoderFactory {
  private final List<AbstractNeighbourhoodBasedPartialInterpretationStateCoder> statecoders = new LinkedList<AbstractNeighbourhoodBasedPartialInterpretationStateCoder>();
  
  private final NeighbourhoodOptions options;
  
  protected AbstractNeighbourhoodBasedStateCoderFactory() {
    this(NeighbourhoodOptions.DEFAULT);
  }
  
  protected AbstractNeighbourhoodBasedStateCoderFactory(final NeighbourhoodOptions options) {
    this.options = options;
  }
  
  @Override
  public synchronized IStateCoder createStateCoder() {
    final AbstractNeighbourhoodBasedPartialInterpretationStateCoder res = this.doCreateStateCoder(this.options);
    this.statecoders.add(res);
    return res;
  }
  
  protected abstract AbstractNeighbourhoodBasedPartialInterpretationStateCoder doCreateStateCoder(final NeighbourhoodOptions options);
  
  public Long getSumStatecoderRuntime() {
    final Function1<AbstractNeighbourhoodBasedPartialInterpretationStateCoder, Long> _function = (AbstractNeighbourhoodBasedPartialInterpretationStateCoder it) -> {
      return Long.valueOf(it.getStatecoderRuntime());
    };
    final Function2<Long, Long, Long> _function_1 = (Long p1, Long p2) -> {
      return Long.valueOf(((p1).longValue() + (p2).longValue()));
    };
    return IterableExtensions.<Long>reduce(ListExtensions.<AbstractNeighbourhoodBasedPartialInterpretationStateCoder, Long>map(this.statecoders, _function), _function_1);
  }
}
