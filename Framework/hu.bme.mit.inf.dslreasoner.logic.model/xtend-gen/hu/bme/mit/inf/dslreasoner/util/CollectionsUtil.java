package hu.bme.mit.inf.dslreasoner.util;

import com.google.common.collect.Iterables;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CollectionsUtil {
  public static <FROM extends Object, TO extends Object> TO lookup(final FROM from, final Map<? super FROM, TO> map) {
    boolean _containsKey = map.containsKey(from);
    if (_containsKey) {
      return map.get(from);
    } else {
      final Function1<EObject, Boolean> _function = (EObject it) -> {
        return Boolean.valueOf(it.eIsProxy());
      };
      final Iterable<EObject> proxys = IterableExtensions.<EObject>filter(Iterables.<EObject>filter(map.values(), EObject.class), _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The map does not contains the key \"");
      String _string = from.toString();
      _builder.append(_string);
      _builder.append("\"!");
      _builder.newLineIfNotEmpty();
      _builder.append("--- Elements: ---");
      _builder.newLine();
      {
        Set<? extends Map.Entry<? super FROM, TO>> _entrySet = map.entrySet();
        boolean _hasElements = false;
        for(final Map.Entry<? super FROM, TO> entry : _entrySet) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("\n", "");
          }
          Object _key = entry.getKey();
          _builder.append(_key);
          _builder.append(" -> ");
          TO _value = entry.getValue();
          _builder.append(_value);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("-----------------");
      String message = _builder.toString();
      boolean _isEmpty = IterableExtensions.isEmpty(proxys);
      boolean _not = (!_isEmpty);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The map contains Proxy objects: ");
        List<EObject> _list = IterableExtensions.<EObject>toList(proxys);
        _builder_1.append(_list);
        _builder_1.newLineIfNotEmpty();
        _builder_1.append(message);
        _builder_1.newLineIfNotEmpty();
        message = _builder_1.toString();
      }
      throw new IllegalArgumentException(message);
    }
  }
  
  public <FROM extends Object, TO extends Object> TO ifThenElse(final FROM source, final Function1<FROM, Boolean> condition, final Function1<FROM, TO> ifTrue, final Function1<FROM, TO> ifFalse) {
    Boolean _apply = condition.apply(source);
    if ((_apply).booleanValue()) {
      return ifTrue.apply(source);
    } else {
      return ifFalse.apply(source);
    }
  }
  
  public static <Key extends Object, Value extends Object> Map<Key, Value> Union(final Map<Key, Value> a, final Map<Key, Value> b) {
    Set<Key> _keySet = a.keySet();
    Set<Key> _keySet_1 = b.keySet();
    final Function1<Key, Value> _function = (Key key) -> {
      Value _xifexpression = null;
      boolean _containsKey = a.containsKey(key);
      if (_containsKey) {
        _xifexpression = a.get(key);
      } else {
        _xifexpression = b.get(key);
      }
      return _xifexpression;
    };
    return IterableExtensions.<Key, Value>toInvertedMap(Iterables.<Key>concat(_keySet, _keySet_1), _function);
  }
  
  public static <Key extends Object, Value extends Object> Object putOrAddToSet(final Map<Key, Set<Value>> map, final Key key, final Value value) {
    Object _xifexpression = null;
    boolean _containsKey = map.containsKey(key);
    if (_containsKey) {
      _xifexpression = Boolean.valueOf(map.get(key).add(value));
    } else {
      Set<Value> _xblockexpression = null;
      {
        HashSet<Value> _hashSet = new HashSet<Value>();
        final Procedure1<HashSet<Value>> _function = (HashSet<Value> it) -> {
          it.add(value);
        };
        final HashSet<Value> set = ObjectExtensions.<HashSet<Value>>operator_doubleArrow(_hashSet, _function);
        _xblockexpression = map.put(key, set);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public static <Key extends Object, Value extends Object> Object putOrAddToList(final Map<Key, List<Value>> map, final Key key, final Value value) {
    Object _xifexpression = null;
    boolean _containsKey = map.containsKey(key);
    if (_containsKey) {
      _xifexpression = Boolean.valueOf(map.get(key).add(value));
    } else {
      List<Value> _xblockexpression = null;
      {
        LinkedList<Value> _linkedList = new LinkedList<Value>();
        final Procedure1<LinkedList<Value>> _function = (LinkedList<Value> it) -> {
          it.add(value);
        };
        final LinkedList<Value> set = ObjectExtensions.<LinkedList<Value>>operator_doubleArrow(_linkedList, _function);
        _xblockexpression = map.put(key, set);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public static <From extends Object, To extends Object, Property extends Object> Map<From, To> copyMap(final Map<From, To> oldMap, final Iterable<To> newValues, final Function1<To, Property> indexExtractor) {
    final Function1<To, Property> _function = (To to) -> {
      return indexExtractor.apply(to);
    };
    final Map<Property, To> valueIndexes = IterableExtensions.<Property, To>toMap(newValues, _function);
    final Function1<To, To> _function_1 = (To value) -> {
      return CollectionsUtil.<Property, To>lookup(indexExtractor.apply(value), valueIndexes);
    };
    final Map<From, To> res = MapExtensions.<From, To, To>mapValues(oldMap, _function_1);
    return res;
  }
  
  public static <From extends Object, To extends Object> Map<To, From> bijectiveInverse(final Map<From, To> m) {
    final Function1<From, To> _function = (From x) -> {
      return CollectionsUtil.<From, To>lookup(x, m);
    };
    return IterableExtensions.<To, From>toMap(m.keySet(), _function);
  }
  
  public static <From extends Object, To extends Object> Map<To, List<From>> inverse(final Map<From, To> m) {
    final LinkedHashMap<To, List<From>> res = new LinkedHashMap<To, List<From>>();
    final Consumer<Map.Entry<From, To>> _function = (Map.Entry<From, To> it) -> {
      CollectionsUtil.<To, From>putOrAddToList(res, it.getValue(), it.getKey());
    };
    m.entrySet().forEach(_function);
    return res;
  }
  
  public static <Type extends Object> List<Type> transitiveClosurePlus(final Type source, final Function1<Type, Iterable<Type>> next) {
    final LinkedList<Type> res = new LinkedList<Type>();
    CollectionsUtil.<Type>transitiveClosureHelper(res, source, next);
    return res;
  }
  
  public static <Type extends Object> List<Type> transitiveClosureStar(final Type source, final Function1<Type, Iterable<Type>> next) {
    final LinkedList<Type> res = new LinkedList<Type>();
    res.add(source);
    CollectionsUtil.<Type>transitiveClosureHelper(res, source, next);
    return res;
  }
  
  private static <Type extends Object> void transitiveClosureHelper(final List<Type> result, final Type actual, final Function1<Type, Iterable<Type>> next) {
    final Iterable<Type> front = next.apply(actual);
    for (final Type elementInFront : front) {
      {
        result.add(elementInFront);
        CollectionsUtil.<Type>transitiveClosureHelper(result, elementInFront, next);
      }
    }
  }
}
