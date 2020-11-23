package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.visualisation;

import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Relation;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.ContainmentHierarchy;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BinaryElementRelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BooleanElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.IntegerElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RealElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.StringElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class PartialInterpretation2Gml {
  private Iterable<DefinedElement> getElements(final PartialInterpretation model) {
    EList<DefinedElement> _elements = model.getProblem().getElements();
    EList<DefinedElement> _newElements = model.getNewElements();
    Iterable<DefinedElement> _plus = Iterables.<DefinedElement>concat(_elements, _newElements);
    EList<DefinedElement> _openWorldElements = model.getOpenWorldElements();
    return Iterables.<DefinedElement>concat(_plus, _openWorldElements);
  }
  
  public String transform(final PartialInterpretation i) {
    String _xblockexpression = null;
    {
      final LogicProblem p = i.getProblem();
      final Map<DefinedElement, Integer> objectToID = new HashMap<DefinedElement, Integer>();
      final Function1<ContainmentHierarchy, EList<Relation>> _function = (ContainmentHierarchy it) -> {
        return it.getContainmentRelations();
      };
      final Set<Relation> containmentRelations = IterableExtensions.<Relation>toSet(Iterables.<Relation>concat(ListExtensions.<ContainmentHierarchy, EList<Relation>>map(p.getContainmentHierarchies(), _function)));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("graph");
      _builder.newLine();
      _builder.append("[");
      _builder.newLine();
      {
        Iterable<DefinedElement> _elements = this.getElements(i);
        boolean _hasElements = false;
        for(final DefinedElement object : _elements) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("\n", "\t");
          }
          _builder.append("\t");
          CharSequence _transformObject = this.transformObject(object, this.typesOfElement(object, i), objectToID);
          _builder.append(_transformObject, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<PartialRelationInterpretation> _partialrelationinterpretation = i.getPartialrelationinterpretation();
        for(final PartialRelationInterpretation relation : _partialrelationinterpretation) {
          {
            Iterable<BinaryElementRelationLink> _filter = Iterables.<BinaryElementRelationLink>filter(relation.getRelationlinks(), BinaryElementRelationLink.class);
            for(final BinaryElementRelationLink link : _filter) {
              _builder.append("\t");
              CharSequence _transformLink = this.transformLink(relation, link, objectToID, containmentRelations);
              _builder.append(_transformLink, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("]");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public Iterable<Type> typesOfElement(final DefinedElement e, final PartialInterpretation i) {
    final Function1<TypeDefinition, Boolean> _function = (TypeDefinition it) -> {
      return Boolean.valueOf(it.getElements().contains(e));
    };
    final Iterable<TypeDefinition> typesElementDefinedIn = IterableExtensions.<TypeDefinition>filter(Iterables.<TypeDefinition>filter(i.getProblem().getTypes(), TypeDefinition.class), _function);
    final Function1<PartialComplexTypeInterpretation, Boolean> _function_1 = (PartialComplexTypeInterpretation it) -> {
      return Boolean.valueOf(it.getElements().contains(e));
    };
    final Function1<PartialComplexTypeInterpretation, TypeDeclaration> _function_2 = (PartialComplexTypeInterpretation it) -> {
      return it.getInterpretationOf();
    };
    final Iterable<TypeDeclaration> typesElementAddedDuringGeneration = IterableExtensions.<PartialComplexTypeInterpretation, TypeDeclaration>map(IterableExtensions.<PartialComplexTypeInterpretation>filter(Iterables.<PartialComplexTypeInterpretation>filter(i.getPartialtypeinterpratation(), PartialComplexTypeInterpretation.class), _function_1), _function_2);
    return Iterables.<Type>concat(typesElementDefinedIn, typesElementAddedDuringGeneration);
  }
  
  protected final int titleSize = 16;
  
  protected final int attributeSize = 14;
  
  protected final int borderDistance = 6;
  
  protected final int attributeBorderDistance = 8;
  
  protected final double ratio = (11.0 / 20.0);
  
  protected CharSequence transformObject(final DefinedElement object, final Iterable<Type> types, final Map<DefinedElement, Integer> objectToID) {
    CharSequence _xblockexpression = null;
    {
      final String title = this.transormTitle(object);
      final Function1<Type, String> _function = (Type it) -> {
        return it.getName();
      };
      final Iterable<String> attributes = IterableExtensions.<Type, String>map(types, _function);
      int _length = title.length();
      int _multiply = (_length * this.titleSize);
      double width = (_multiply + (this.borderDistance * 2));
      final Function1<String, Integer> _function_1 = (String it) -> {
        int _length_1 = it.length();
        int _multiply_1 = (_length_1 * this.attributeSize);
        int _plus = (_multiply_1 + (this.borderDistance * 2));
        return Integer.valueOf((_plus + (this.attributeBorderDistance * 2)));
      };
      Iterable<Integer> _map = IterableExtensions.<String, Integer>map(attributes, _function_1);
      for (final Integer x : _map) {
        width = Math.max(width, (x).intValue());
      }
      width = (width * this.ratio);
      int _size = IterableExtensions.size(attributes);
      int _plus = (_size + 1);
      int _multiply_1 = (_plus * this.attributeSize);
      int _plus_1 = (_multiply_1 + (this.borderDistance * 2));
      final int height = Math.max(
        (this.titleSize + 4), _plus_1);
      final int id = objectToID.size();
      objectToID.put(object, Integer.valueOf(id));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("node");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("id\t");
      _builder.append(id, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("graphics");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("[");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("w\t");
      _builder.append(width, "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("h\t");
      _builder.append(height, "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("type\t\"rectangle\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("fill\t\"#FFFFFF\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("fill2\t\"#FFFFFF\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("outline\t\"#000000\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("LabelGraphics");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("[");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("text\t\"");
      _builder.append(title, "\t\t\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("outline\t\"#000000\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("fill\t\"#FFFFFF\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("fontSize\t");
      _builder.append(this.titleSize, "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("fontName\t\"Monospace\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("autoSizePolicy\t\"node_width\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("anchor\t\"t\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("borderDistance\t0.0");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("LabelGraphics");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("[");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("text\t\"");
      _builder.newLine();
      {
        for(final String attribute : attributes) {
          _builder.append(attribute);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("fontSize\t");
      _builder.append(this.attributeSize, "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("fontName\t\"Consolas\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("alignment\t\"left\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("anchor\t\"tl\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("borderDistance\t");
      _builder.append(this.borderDistance, "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected String _transormTitle(final DefinedElement object) {
    String _xifexpression = null;
    String _name = object.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      _xifexpression = object.getName().replace("\"", "");
    } else {
      _xifexpression = "null";
    }
    return _xifexpression;
  }
  
  protected String _transormTitle(final BooleanElement object) {
    String _xifexpression = null;
    boolean _isValueSet = object.isValueSet();
    if (_isValueSet) {
      _xifexpression = Boolean.valueOf(object.isValue()).toString();
    } else {
      _xifexpression = "?";
    }
    return _xifexpression;
  }
  
  protected String _transormTitle(final IntegerElement object) {
    String _xifexpression = null;
    boolean _isValueSet = object.isValueSet();
    if (_isValueSet) {
      _xifexpression = Integer.valueOf(object.getValue()).toString();
    } else {
      _xifexpression = "?";
    }
    return _xifexpression;
  }
  
  protected String _transormTitle(final RealElement object) {
    String _xifexpression = null;
    boolean _isValueSet = object.isValueSet();
    if (_isValueSet) {
      _xifexpression = object.getValue().toString();
    } else {
      _xifexpression = "?";
    }
    return _xifexpression;
  }
  
  protected String _transormTitle(final StringElement object) {
    String _xifexpression = null;
    boolean _isValueSet = object.isValueSet();
    if (_isValueSet) {
      _xifexpression = object.getValue().toString();
    } else {
      _xifexpression = "?";
    }
    return _xifexpression;
  }
  
  protected CharSequence transformLink(final PartialRelationInterpretation reference, final BinaryElementRelationLink link, final Map<DefinedElement, Integer> objectToID, final Set<Relation> containmentRelations) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("edge");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("source\t");
    Integer _get = objectToID.get(link.getParam1());
    _builder.append(_get, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("target\t");
    Integer _get_1 = objectToID.get(link.getParam2());
    _builder.append(_get_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("graphics");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fill\t\"#000000\"");
    _builder.newLine();
    {
      boolean _contains = containmentRelations.contains(reference.getInterpretationOf());
      if (_contains) {
        _builder.append("\t\t");
        _builder.append("width\t3");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("targetArrow\t\"standard\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LabelGraphics");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("text\t\"");
    String _name = reference.getInterpretationOf().getName();
    _builder.append(_name, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("fontSize\t14");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fontName\t\"Consolas\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("configuration\t\"AutoFlippingLabel\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("model\t\"six_pos\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("position\t\"thead\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  protected String transormTitle(final DefinedElement object) {
    if (object instanceof BooleanElement) {
      return _transormTitle((BooleanElement)object);
    } else if (object instanceof IntegerElement) {
      return _transormTitle((IntegerElement)object);
    } else if (object instanceof RealElement) {
      return _transormTitle((RealElement)object);
    } else if (object instanceof StringElement) {
      return _transormTitle((StringElement)object);
    } else if (object != null) {
      return _transormTitle(object);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(object).toString());
    }
  }
}
