package hu.bme.mit.inf.dslreasoner.util;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class SetWithCustomEquivalence<Type extends Object, Representation extends Object> implements Set<Type> {
  private final Function1<Type, Representation> representer;
  
  private final HashMap<Representation, Type> map;
  
  public SetWithCustomEquivalence(final Function1<Type, Representation> representer) {
    this.representer = representer;
    HashMap<Representation, Type> _hashMap = new HashMap<Representation, Type>();
    this.map = _hashMap;
  }
  
  public SetWithCustomEquivalence(final Function1<Type, Representation> representer, final Collection<? extends Type> initialElements) {
    this.representer = representer;
    HashMap<Representation, Type> _hashMap = new HashMap<Representation, Type>();
    this.map = _hashMap;
    final Consumer<Type> _function = (Type it) -> {
      this.add(it);
    };
    initialElements.forEach(_function);
  }
  
  @Override
  public boolean add(final Type arg0) {
    final Representation representation = this.representer.apply(arg0);
    boolean _containsKey = this.map.containsKey(representation);
    boolean _not = (!_containsKey);
    if (_not) {
      this.map.put(representation, arg0);
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public boolean addAll(final Collection<? extends Type> arg0) {
    final int originalSize = this.size();
    final Consumer<Type> _function = (Type it) -> {
      this.add(it);
    };
    arg0.forEach(_function);
    int _size = this.size();
    return (_size != originalSize);
  }
  
  @Override
  public void clear() {
    this.map.clear();
  }
  
  @Override
  public boolean contains(final Object arg0) {
    try {
      final Representation rep = this.representer.apply(((Type) arg0));
      return this.map.containsKey(rep);
    } catch (final Throwable _t) {
      if (_t instanceof ClassCastException) {
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public boolean containsAll(final Collection<?> arg0) {
    final Function1<Object, Boolean> _function = (Object it) -> {
      return Boolean.valueOf(this.contains(it));
    };
    return IterableExtensions.forall(arg0, _function);
  }
  
  @Override
  public boolean isEmpty() {
    return this.map.isEmpty();
  }
  
  @Override
  public Iterator<Type> iterator() {
    return this.map.values().iterator();
  }
  
  @Override
  public boolean remove(final Object arg0) {
    try {
      final Representation rep = this.representer.apply(((Type) arg0));
      Type _remove = this.map.remove(rep);
      return (!Objects.equal(_remove, null));
    } catch (final Throwable _t) {
      if (_t instanceof ClassCastException) {
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public boolean removeAll(final Collection<?> arg0) {
    final int originalSize = this.size();
    final Consumer<Object> _function = (Object it) -> {
      this.remove(it);
    };
    arg0.forEach(_function);
    int _size = this.size();
    return (_size != originalSize);
  }
  
  @Override
  public boolean retainAll(final Collection<?> arg0) {
    final Set<Representation> representationsOfArg0 = new HashSet<Representation>();
    for (final Object element : arg0) {
      try {
        Representation _apply = this.representer.apply(((Type) element));
        representationsOfArg0.add(_apply);
      } catch (final Throwable _t) {
        if (_t instanceof ClassCastException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    final int originalSize = this.size();
    Set<Representation> _keySet = this.map.keySet();
    for (final Representation r : _keySet) {
      boolean _contains = representationsOfArg0.contains(r);
      boolean _not = (!_contains);
      if (_not) {
        this.map.remove(r);
      }
    }
    int _size = this.size();
    return (_size != originalSize);
  }
  
  @Override
  public int size() {
    return this.map.size();
  }
  
  @Override
  public Object[] toArray() {
    return this.map.values().toArray();
  }
  
  @Override
  public <T extends Object> T[] toArray(final T[] arg0) {
    return this.map.values().<T>toArray(arg0);
  }
}
