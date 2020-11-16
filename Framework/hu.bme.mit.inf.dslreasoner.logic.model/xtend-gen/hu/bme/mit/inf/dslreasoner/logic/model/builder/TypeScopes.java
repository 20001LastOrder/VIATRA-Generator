package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Defines the the size of the generated models. Constant <code>Unlimited</code> defines no upper limit to the type.
 */
@SuppressWarnings("all")
public class TypeScopes {
  public static final int Unlimited = Integer.MAX_VALUE;
  
  /**
   * Sets the Integers that are already in the scope of the problem.
   */
  public SortedSet<Integer> knownIntegers = new TreeSet<Integer>();
  
  /**
   * Sets the number of Integers that has to be used to solve the problem.
   */
  public int minNewIntegers = 0;
  
  public int maxNewIntegers = TypeScopes.Unlimited;
  
  public SortedSet<BigDecimal> knownReals = new TreeSet<BigDecimal>();
  
  /**
   * Sets the number of Reals that has to be used to solve the problem.
   */
  public int minNewReals = 0;
  
  public int maxNewReals = TypeScopes.Unlimited;
  
  public SortedSet<String> knownStrings = new TreeSet<String>();
  
  /**
   * Sets the number of Strings that has to be used to solve the problem.
   */
  public int minNewStrings = 0;
  
  public int maxNewStrings = TypeScopes.Unlimited;
  
  /**
   * Defines the minimal number of newly added elements. Default value is 0.
   */
  public int minNewElements = 0;
  
  /**
   * Defines the maximal number of newly added elements. Default value is <code>TypeScopes.Unlimited</code>.
   */
  public int maxNewElements = TypeScopes.Unlimited;
  
  public Map<Type, Integer> minNewElementsByType = new HashMap<Type, Integer>();
  
  public Map<Type, Integer> maxNewElementsByType = new HashMap<Type, Integer>();
  
  /**
   * Checks if the scope contains negative elements
   */
  public LinkedList<String> validateTypeScopes(final TypeScopes scopes) {
    final LinkedList<String> res = new LinkedList<String>();
    if ((scopes.maxNewElements < 0)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Inconsistent scope: Maximal number of new elements is negative.");
      res.add(_builder.toString());
    }
    if ((scopes.maxNewIntegers < 0)) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Inconsistent scope: Maximal number of new integer values is negative.");
      res.add(_builder_1.toString());
    }
    if ((scopes.maxNewReals < 0)) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Inconsistent scope: Maximal number of new real values is negative.");
      res.add(_builder_2.toString());
    }
    if ((scopes.maxNewStrings < 0)) {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Inconsistent scope: Maximal number of new string values is negative.");
      res.add(_builder_3.toString());
    }
    Set<Map.Entry<Type, Integer>> _entrySet = scopes.minNewElementsByType.entrySet();
    for (final Map.Entry<Type, Integer> x : _entrySet) {
      Integer _value = x.getValue();
      boolean _lessThan = ((_value).intValue() < 0);
      if (_lessThan) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("Inconsistent scope: Maximal number of new \"");
        String _name = x.getKey().getName();
        _builder_4.append(_name);
        _builder_4.append("\" elements is negative.");
        res.add(_builder_4.toString());
      }
    }
    return res;
  }
}
