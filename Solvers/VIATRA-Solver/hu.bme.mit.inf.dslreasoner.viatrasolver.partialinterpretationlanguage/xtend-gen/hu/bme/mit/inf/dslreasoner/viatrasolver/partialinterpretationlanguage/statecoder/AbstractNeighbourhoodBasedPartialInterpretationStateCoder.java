package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.statecoder;

import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialPrimitiveInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialinterpretationPackage;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.scope.IBaseIndex;
import org.eclipse.viatra.query.runtime.base.api.FeatureListener;
import org.eclipse.viatra.query.runtime.base.api.IndexingLevel;
import org.eclipse.viatra.query.runtime.base.api.InstanceListener;
import org.eclipse.viatra.query.runtime.base.api.NavigationHelper;
import org.eclipse.viatra.query.runtime.emf.EMFBaseIndexWrapper;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractNeighbourhoodBasedPartialInterpretationStateCoder implements IStateCoder {
  private final NeighbourhoodOptions options;
  
  private PartialInterpretation target;
  
  protected AbstractNeighbourhoodBasedPartialInterpretationStateCoder(final NeighbourhoodOptions options) {
    this.options = options;
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private long statecoderRuntime = 0;
  
  private synchronized long refreshStateCodes() {
    long _xifexpression = (long) 0;
    boolean _isRefreshNeeded = this.isRefreshNeeded();
    if (_isRefreshNeeded) {
      long _xblockexpression = (long) 0;
      {
        final long startTime = System.nanoTime();
        this.doRefreshStateCodes(this.target, this.options);
        long _statecoderRuntime = this.statecoderRuntime;
        long _nanoTime = System.nanoTime();
        long _minus = (_nanoTime - startTime);
        _xblockexpression = this.statecoderRuntime = (_statecoderRuntime + _minus);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected abstract boolean isRefreshNeeded();
  
  protected abstract void doRefreshStateCodes(final PartialInterpretation target, final NeighbourhoodOptions options);
  
  @Override
  public synchronized Object createActivationCode(final IPatternMatch match) {
    Object _xblockexpression = null;
    {
      this.refreshStateCodes();
      final long startTime = System.nanoTime();
      final Object code = this.doCreateActivationCode(match);
      long _statecoderRuntime = this.statecoderRuntime;
      long _nanoTime = System.nanoTime();
      long _minus = (_nanoTime - startTime);
      this.statecoderRuntime = (_statecoderRuntime + _minus);
      _xblockexpression = code;
    }
    return _xblockexpression;
  }
  
  protected abstract Object doCreateActivationCode(final IPatternMatch match);
  
  @Override
  public synchronized Object createStateCode() {
    Object _xblockexpression = null;
    {
      this.refreshStateCodes();
      _xblockexpression = this.doCreateStateCode();
    }
    return _xblockexpression;
  }
  
  protected abstract Object doCreateStateCode();
  
  @Override
  public void init(final Notifier notifier) {
    this.target = ((PartialInterpretation) notifier);
    EMFScope _eMFScope = new EMFScope(notifier);
    final ViatraQueryEngine queryEngine = ViatraQueryEngine.on(_eMFScope);
    IBaseIndex _baseIndex = queryEngine.getBaseIndex();
    final EMFBaseIndexWrapper baseIndex = ((EMFBaseIndexWrapper) _baseIndex);
    final NavigationHelper navigationHelper = baseIndex.getNavigationHelper();
    final Set<EClass> classes = IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(PartialinterpretationPackage.eINSTANCE.getEClassifiers(), EClass.class));
    final Function1<EClass, EList<EStructuralFeature>> _function = (EClass it) -> {
      return it.getEAllStructuralFeatures();
    };
    final Set<EStructuralFeature> features = IterableExtensions.<EStructuralFeature>toSet(Iterables.<EStructuralFeature>concat(IterableExtensions.<EClass, EList<EStructuralFeature>>map(classes, _function)));
    navigationHelper.registerObservedTypes(classes, null, features, IndexingLevel.FULL);
    navigationHelper.addFeatureListener(features, new FeatureListener() {
      @Override
      public void featureInserted(final EObject host, final EStructuralFeature feature, final Object value) {
        AbstractNeighbourhoodBasedPartialInterpretationStateCoder.this.invalidate();
      }
      
      @Override
      public void featureDeleted(final EObject host, final EStructuralFeature feature, final Object value) {
        AbstractNeighbourhoodBasedPartialInterpretationStateCoder.this.invalidate();
      }
    });
    navigationHelper.addInstanceListener(classes, new InstanceListener() {
      @Override
      public void instanceInserted(final EClass clazz, final EObject instance) {
        AbstractNeighbourhoodBasedPartialInterpretationStateCoder.this.invalidate();
      }
      
      @Override
      public void instanceDeleted(final EClass clazz, final EObject instance) {
        AbstractNeighbourhoodBasedPartialInterpretationStateCoder.this.invalidate();
      }
    });
  }
  
  public synchronized void invalidate() {
    this.doInvalidate();
  }
  
  protected abstract void doInvalidate();
  
  protected Object getFallbackCode(final Object o) {
    Object _switchResult = null;
    boolean _matched = false;
    if (o instanceof PartialInterpretation) {
      _matched=true;
    }
    if (!_matched) {
      if (o instanceof LogicProblem) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = null;
    }
    if (!_matched) {
      if (o instanceof PartialRelationInterpretation) {
        _matched=true;
        _switchResult = ((PartialRelationInterpretation)o).getInterpretationOf().getName();
      }
    }
    if (!_matched) {
      if (o instanceof PartialPrimitiveInterpretation) {
        _matched=true;
        _switchResult = Integer.valueOf(((PartialPrimitiveInterpretation)o).getClass().getSimpleName().hashCode());
      }
    }
    if (!_matched) {
      if (o instanceof PartialComplexTypeInterpretation) {
        _matched=true;
        _switchResult = Integer.valueOf(((PartialComplexTypeInterpretation)o).getInterpretationOf().getName().hashCode());
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unsupported type: ");
      String _simpleName = o.getClass().getSimpleName();
      _builder.append(_simpleName);
      throw new UnsupportedOperationException(_builder.toString());
    }
    return _switchResult;
  }
  
  @Pure
  public long getStatecoderRuntime() {
    return this.statecoderRuntime;
  }
}
