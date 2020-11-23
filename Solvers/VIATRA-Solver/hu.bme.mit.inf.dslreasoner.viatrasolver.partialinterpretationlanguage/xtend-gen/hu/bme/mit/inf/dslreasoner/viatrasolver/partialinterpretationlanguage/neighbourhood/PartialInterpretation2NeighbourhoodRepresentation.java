package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDeclaration;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.FurtherNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.IncomingRelation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.LocalNodeDescriptor;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodOptions;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.NeighbourhoodWithTraces;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.neighbourhood.OutgoingRelation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BinaryElementRelationLink;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialComplexTypeInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialPrimitiveInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRelationInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialTypeInterpratation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RelationLink;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public abstract class PartialInterpretation2NeighbourhoodRepresentation<ModelRepresentation extends Object, NodeRepresentation extends Object> {
  private final boolean deepRepresentation;
  
  private final boolean mergeSimilarNeighbourhood;
  
  protected PartialInterpretation2NeighbourhoodRepresentation(final boolean deeprepresentation, final boolean mergeSimilarNeighbourhood) {
    this.deepRepresentation = deeprepresentation;
    this.mergeSimilarNeighbourhood = mergeSimilarNeighbourhood;
  }
  
  public static final int FixPointRange = NeighbourhoodOptions.FixPointRange;
  
  public static final int GraphWidthRange = NeighbourhoodOptions.GraphWidthRange;
  
  public static final int FullParallels = NeighbourhoodOptions.FullParallels;
  
  public static final int MaxNumbers = NeighbourhoodOptions.MaxNumbers;
  
  private static final String FOCUSED_ELEMENT_NAME = "<<THIS>>";
  
  /**
   * Creates a neighbourhood representation with traces
   * @param model The model to be represented.
   * @param range The range of the neighbourhood.
   * @param parallels The maximal number of parallel references to be differentiated.
   * @param maxNumber The maximal number of elements in a equivalence class that chan be differentiated.
   */
  public NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> createRepresentation(final PartialInterpretation model, final int range, final int parallels, final int maxNumber) {
    return this.createRepresentation(model, range, parallels, maxNumber, null, null);
  }
  
  public NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> createRepresentation(final PartialInterpretation model, final NeighbourhoodOptions options) {
    return this.createRepresentation(model, options.getRange(), options.getParallels(), options.getMaxNumber(), options.getRelevantTypes(), 
      options.getRelevantRelations());
  }
  
  /**
   * Creates a neighbourhood representation with traces
   * @param model The model to be represented.
   * @param range The range of the neighbourhood.
   * @param parallels The maximal number of parallel references to be differentiated.
   * @param maxNumber The maximal number of elements in a equivalence class that chan be differentiated.
   */
  public NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> createRepresentation(final PartialInterpretation model, final int range, final int parallels, final int maxNumber, final Set<TypeDeclaration> relevantTypes, final Set<RelationDeclaration> relevantRelations) {
    return this.createRepresentationWithFocus(model, range, parallels, maxNumber, relevantTypes, relevantRelations, null);
  }
  
  public NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> createRepresentationWithFocus(final PartialInterpretation model, final NeighbourhoodOptions options, final DefinedElement focusedElement) {
    return this.createRepresentationWithFocus(model, options.getRange(), options.getParallels(), options.getMaxNumber(), options.getRelevantTypes(), 
      options.getRelevantRelations(), focusedElement);
  }
  
  public NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> createRepresentationWithFocus(final PartialInterpretation model, final int range, final int parallels, final int maxNumber, final Set<TypeDeclaration> relevantTypes, final Set<RelationDeclaration> relevantRelations, final DefinedElement focusedElement) {
    final int initialSize = IterableExtensions.size(this.getElements(model));
    final Map<DefinedElement, Set<String>> types = Maps.mutable.<DefinedElement, Set<String>>ofInitialCapacity(initialSize);
    this.fillTypes(model, types, relevantTypes);
    final Map<DefinedElement, List<IncomingRelation<DefinedElement>>> IncomingRelations = Maps.mutable.<DefinedElement, List<IncomingRelation<DefinedElement>>>ofInitialCapacity(initialSize);
    final Map<DefinedElement, List<OutgoingRelation<DefinedElement>>> OutgoingRelations = Maps.mutable.<DefinedElement, List<OutgoingRelation<DefinedElement>>>ofInitialCapacity(initialSize);
    this.fillReferences(model, IncomingRelations, OutgoingRelations, relevantRelations);
    final NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> res = this.doRecursiveNeighbourCalculation(model, types, IncomingRelations, OutgoingRelations, range, parallels, maxNumber, focusedElement);
    return res;
  }
  
  private boolean isRelevant(final TypeDeclaration t, final Set<TypeDeclaration> relevantTypes) {
    if ((relevantTypes == null)) {
      return true;
    } else {
      return relevantTypes.contains(t);
    }
  }
  
  private boolean isRelevant(final RelationDeclaration r, final Set<RelationDeclaration> relevantRelations) {
    if ((relevantRelations == null)) {
      return true;
    } else {
      return relevantRelations.contains(r);
    }
  }
  
  /**
   * Gets the minimal neighbourhood size such that every reachable node appears in the shape of every other at least once.
   */
  private int getWidth(final Map<DefinedElement, Set<String>> types, final Map<DefinedElement, List<IncomingRelation<DefinedElement>>> IncomingRelations, final Map<DefinedElement, List<OutgoingRelation<DefinedElement>>> OutgoingRelations) {
    final Set<DefinedElement> elements = types.keySet();
    Map<DefinedElement, Set<DefinedElement>> reachable = Maps.mutable.<DefinedElement, Set<DefinedElement>>ofInitialCapacity(elements.size());
    Map<DefinedElement, Set<DefinedElement>> newReachable = Maps.mutable.<DefinedElement, Set<DefinedElement>>ofInitialCapacity(elements.size());
    for (final DefinedElement element : elements) {
      {
        final MutableSet<DefinedElement> set = Sets.mutable.<DefinedElement>of();
        set.add(element);
        reachable.put(element, Sets.mutable.<DefinedElement>of());
        newReachable.put(element, set);
      }
    }
    int width = 0;
    boolean newAdded = false;
    do {
      {
        Map<DefinedElement, Set<DefinedElement>> tmp = reachable;
        reachable = newReachable;
        newReachable = tmp;
        newAdded = false;
        for (final DefinedElement element_1 : elements) {
          {
            final Set<DefinedElement> elementNeigbours = CollectionsUtil.<DefinedElement, Set<DefinedElement>>lookup(element_1, reachable);
            final Set<DefinedElement> newElementNeigbours = CollectionsUtil.<DefinedElement, Set<DefinedElement>>lookup(element_1, newReachable);
            newElementNeigbours.addAll(elementNeigbours);
            List<IncomingRelation<DefinedElement>> _lookup = CollectionsUtil.<DefinedElement, List<IncomingRelation<DefinedElement>>>lookup(element_1, IncomingRelations);
            for (final IncomingRelation<DefinedElement> incoming : _lookup) {
              newElementNeigbours.addAll(CollectionsUtil.<DefinedElement, Set<DefinedElement>>lookup(incoming.getFrom(), reachable));
            }
            List<OutgoingRelation<DefinedElement>> _lookup_1 = CollectionsUtil.<DefinedElement, List<OutgoingRelation<DefinedElement>>>lookup(element_1, OutgoingRelations);
            for (final OutgoingRelation<DefinedElement> outgoing : _lookup_1) {
              newElementNeigbours.addAll(CollectionsUtil.<DefinedElement, Set<DefinedElement>>lookup(outgoing.getTo(), reachable));
            }
            newAdded = (newAdded || (newElementNeigbours.size() > elementNeigbours.size()));
          }
        }
        int _width = width;
        width = (_width + 1);
      }
    } while(newAdded);
    return width;
  }
  
  /**
   * Creates a neighbourhood representation with traces
   * @param model The model to be represented.
   * @param IncomingRelations Requires the previously indexed incoming references.
   * @param OutgoingRelations Requires the previously indexed outgoing references.
   * @param range The range of the neighbourhood.
   * @param parallels The maximal number of parallel references to be differentiated.
   */
  private NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> doRecursiveNeighbourCalculation(final PartialInterpretation model, final Map<DefinedElement, Set<String>> types, final Map<DefinedElement, List<IncomingRelation<DefinedElement>>> IncomingRelations, final Map<DefinedElement, List<OutgoingRelation<DefinedElement>>> OutgoingRelations, final int range, final int parallels, final int maxNumber, final DefinedElement focusedElement) {
    if ((range == 0)) {
      final Pair<Map<LocalNodeDescriptor, Integer>, Map<DefinedElement, LocalNodeDescriptor>> r = this.calculateLocalNodeDescriptors(model, types, maxNumber, focusedElement);
      final NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> res = this.createLocalRepresentation(r.getValue(), r.getKey());
      ModelRepresentation _modelRepresentation = res.getModelRepresentation();
      boolean _tripleEquals = (_modelRepresentation == null);
      if (_tripleEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Model representation is null");
        throw new IllegalArgumentException(_builder.toString());
      } else {
        if (((res.getNodeRepresentations() == null) || res.getNodeRepresentations().isEmpty())) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("No node representation");
          throw new IllegalArgumentException(_builder_1.toString());
        } else {
          NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> _previousRepresentation = res.getPreviousRepresentation();
          boolean _tripleNotEquals = (_previousRepresentation != null);
          if (_tripleNotEquals) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("The previous representation of the first neighbourhood have to be null");
            throw new IllegalArgumentException(_builder_2.toString());
          } else {
            return res;
          }
        }
      }
    } else {
      if ((range > 0)) {
        final NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> previous = this.doRecursiveNeighbourCalculation(model, types, IncomingRelations, OutgoingRelations, 
          (range - 1), parallels, maxNumber, focusedElement);
        final Pair<Map<FurtherNodeDescriptor<NodeRepresentation>, Integer>, MutableMap<DefinedElement, FurtherNodeDescriptor<NodeRepresentation>>> r_1 = this.calculateFurtherNodeDescriptors(model, previous, IncomingRelations, OutgoingRelations, parallels, maxNumber);
        final NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> res_1 = this.createFurtherRepresentation(r_1.getKey(), r_1.getValue(), previous, this.deepRepresentation);
        ModelRepresentation _modelRepresentation_1 = res_1.getModelRepresentation();
        boolean _tripleEquals_1 = (_modelRepresentation_1 == null);
        if (_tripleEquals_1) {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("Model representation is null");
          throw new IllegalArgumentException(_builder_3.toString());
        } else {
          if (((res_1.getNodeRepresentations() == null) || res_1.getNodeRepresentations().isEmpty())) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("No node representation");
            throw new IllegalArgumentException(_builder_4.toString());
          } else {
            if (((res_1.getPreviousRepresentation() == null) && this.deepRepresentation)) {
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append("Need previous representations");
              throw new IllegalArgumentException(_builder_5.toString());
            } else {
              return res_1;
            }
          }
        }
      } else {
        if ((range == PartialInterpretation2NeighbourhoodRepresentation.FixPointRange)) {
          return this.refineUntilFixpoint(model, types, IncomingRelations, OutgoingRelations, parallels, maxNumber, focusedElement);
        } else {
          if ((range == PartialInterpretation2NeighbourhoodRepresentation.GraphWidthRange)) {
            final int width = this.getWidth(types, IncomingRelations, OutgoingRelations);
            return this.doRecursiveNeighbourCalculation(model, types, IncomingRelations, OutgoingRelations, width, parallels, maxNumber, focusedElement);
          }
        }
      }
    }
    return null;
  }
  
  private NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> refineUntilFixpoint(final PartialInterpretation model, final Map<DefinedElement, Set<String>> types, final Map<DefinedElement, List<IncomingRelation<DefinedElement>>> IncomingRelations, final Map<DefinedElement, List<OutgoingRelation<DefinedElement>>> OutgoingRelations, final int parallels, final int maxNumbers, final DefinedElement focusedElement) {
    int lastRange = 0;
    final Pair<Map<LocalNodeDescriptor, Integer>, Map<DefinedElement, LocalNodeDescriptor>> last = this.calculateLocalNodeDescriptors(model, types, maxNumbers, focusedElement);
    NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> lastRepresentation = this.createLocalRepresentation(last.getValue(), last.getKey());
    boolean hasRefined = false;
    do {
      {
        final int nextRange = (lastRange + 1);
        final Pair<Map<FurtherNodeDescriptor<NodeRepresentation>, Integer>, MutableMap<DefinedElement, FurtherNodeDescriptor<NodeRepresentation>>> next = this.calculateFurtherNodeDescriptors(model, lastRepresentation, IncomingRelations, OutgoingRelations, parallels, maxNumbers);
        final NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> nextRepresentation = this.createFurtherRepresentation(next.getKey(), next.getValue(), lastRepresentation, 
          this.deepRepresentation);
        final int previousNumberOfTypes = Sets.immutable.<NodeRepresentation>withAll(lastRepresentation.getNodeRepresentations().values()).size();
        final int nextNumberOfTypes = Sets.immutable.<NodeRepresentation>withAll(nextRepresentation.getNodeRepresentations().values()).size();
        hasRefined = (nextNumberOfTypes > previousNumberOfTypes);
        lastRange = nextRange;
        lastRepresentation = nextRepresentation;
      }
    } while(hasRefined);
    return lastRepresentation;
  }
  
  private Iterable<DefinedElement> getElements(final PartialInterpretation model) {
    EList<DefinedElement> _elements = model.getProblem().getElements();
    EList<DefinedElement> _newElements = model.getNewElements();
    Iterable<DefinedElement> _plus = Iterables.<DefinedElement>concat(_elements, _newElements);
    EList<DefinedElement> _openWorldElements = model.getOpenWorldElements();
    return Iterables.<DefinedElement>concat(_plus, _openWorldElements);
  }
  
  private void fillTypes(final PartialInterpretation model, final Map<DefinedElement, Set<String>> node2Type, final Set<TypeDeclaration> relevantTypes) {
    Iterable<DefinedElement> _elements = this.getElements(model);
    for (final DefinedElement element : _elements) {
      node2Type.put(element, Sets.mutable.<String>of());
    }
    EList<PartialTypeInterpratation> _partialtypeinterpratation = model.getPartialtypeinterpratation();
    for (final PartialTypeInterpratation typeInterpretation : _partialtypeinterpratation) {
      if ((typeInterpretation instanceof PartialPrimitiveInterpretation)) {
      } else {
        if ((typeInterpretation instanceof PartialComplexTypeInterpretation)) {
          final TypeDeclaration type = ((PartialComplexTypeInterpretation)typeInterpretation).getInterpretationOf();
          boolean _isRelevant = this.isRelevant(type, relevantTypes);
          if (_isRelevant) {
            EList<DefinedElement> _elements_1 = ((PartialComplexTypeInterpretation)typeInterpretation).getElements();
            for (final DefinedElement element_1 : _elements_1) {
              CollectionsUtil.<DefinedElement, Set<String>>lookup(element_1, node2Type).add(type.getName());
            }
          }
        }
      }
    }
  }
  
  /**
   * Indexes the references
   */
  private void fillReferences(final PartialInterpretation model, final Map<DefinedElement, List<IncomingRelation<DefinedElement>>> IncomingRelations, final Map<DefinedElement, List<OutgoingRelation<DefinedElement>>> OutgoingRelations, final Set<RelationDeclaration> relevantRelations) {
    Iterable<DefinedElement> _elements = this.getElements(model);
    for (final DefinedElement object : _elements) {
      {
        ArrayList<IncomingRelation<DefinedElement>> _arrayList = new ArrayList<IncomingRelation<DefinedElement>>();
        IncomingRelations.put(object, _arrayList);
        ArrayList<OutgoingRelation<DefinedElement>> _arrayList_1 = new ArrayList<OutgoingRelation<DefinedElement>>();
        OutgoingRelations.put(object, _arrayList_1);
      }
    }
    EList<PartialRelationInterpretation> _partialrelationinterpretation = model.getPartialrelationinterpretation();
    for (final PartialRelationInterpretation relationInterpretation : _partialrelationinterpretation) {
      {
        final RelationDeclaration type = relationInterpretation.getInterpretationOf();
        boolean _isRelevant = this.isRelevant(type, relevantRelations);
        if (_isRelevant) {
          EList<RelationLink> _relationlinks = relationInterpretation.getRelationlinks();
          for (final RelationLink link : _relationlinks) {
            if ((link instanceof BinaryElementRelationLink)) {
              List<OutgoingRelation<DefinedElement>> _get = OutgoingRelations.get(((BinaryElementRelationLink)link).getParam1());
              DefinedElement _param2 = ((BinaryElementRelationLink)link).getParam2();
              String _name = type.getName();
              OutgoingRelation<DefinedElement> _outgoingRelation = new OutgoingRelation<DefinedElement>(_param2, _name);
              _get.add(_outgoingRelation);
              List<IncomingRelation<DefinedElement>> _get_1 = IncomingRelations.get(((BinaryElementRelationLink)link).getParam2());
              DefinedElement _param1 = ((BinaryElementRelationLink)link).getParam1();
              String _name_1 = type.getName();
              IncomingRelation<DefinedElement> _incomingRelation = new IncomingRelation<DefinedElement>(_param1, _name_1);
              _get_1.add(_incomingRelation);
            } else {
              throw new UnsupportedOperationException();
            }
          }
        }
      }
    }
  }
  
  /**
   * Creates a local representation of the objects (aka zero range neighbourhood)
   */
  protected abstract NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> createLocalRepresentation(final Map<DefinedElement, LocalNodeDescriptor> node2Representation, final Map<LocalNodeDescriptor, Integer> representation2Amount);
  
  /**
   * Creates a
   */
  protected abstract NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> createFurtherRepresentation(final Map<FurtherNodeDescriptor<NodeRepresentation>, Integer> nodeDescriptors, final Map<DefinedElement, FurtherNodeDescriptor<NodeRepresentation>> node2Representation, final NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> previous, final boolean deepRepresentation);
  
  private int addOne(final Integer originalObj, final int max) {
    if ((originalObj == null)) {
      return 1;
    }
    final int original = originalObj.intValue();
    if ((original == Integer.MAX_VALUE)) {
      return Integer.MAX_VALUE;
    }
    if (((original + 1) > max)) {
      return Integer.MAX_VALUE;
    } else {
      return (original + 1);
    }
  }
  
  private Map<IncomingRelation<NodeRepresentation>, Integer> calculateIncomingEdges(final Map<DefinedElement, List<IncomingRelation<DefinedElement>>> IncomingRelations, final DefinedElement object, final Map<DefinedElement, ? extends NodeRepresentation> previousNodeRepresentations, final int parallel) {
    final Map<IncomingRelation<NodeRepresentation>, Integer> res = Maps.mutable.<IncomingRelation<NodeRepresentation>, Integer>of();
    List<IncomingRelation<DefinedElement>> _get = IncomingRelations.get(object);
    for (final IncomingRelation<DefinedElement> incomingConcreteEdge : _get) {
      {
        NodeRepresentation _get_1 = previousNodeRepresentations.get(incomingConcreteEdge.getFrom());
        String _type = incomingConcreteEdge.getType();
        final IncomingRelation<NodeRepresentation> e = new IncomingRelation<NodeRepresentation>(_get_1, _type);
        final BiFunction<IncomingRelation<NodeRepresentation>, Integer, Integer> _function = (IncomingRelation<NodeRepresentation> key, Integer value) -> {
          return Integer.valueOf(this.addOne(value, parallel));
        };
        res.compute(e, _function);
      }
    }
    return res;
  }
  
  private Map<OutgoingRelation<NodeRepresentation>, Integer> calcuateOutgoingEdges(final Map<DefinedElement, List<OutgoingRelation<DefinedElement>>> OutgoingRelations, final DefinedElement object, final Map<DefinedElement, ? extends NodeRepresentation> previousNodeRepresentations, final int parallel) {
    final Map<OutgoingRelation<NodeRepresentation>, Integer> res = Maps.mutable.<OutgoingRelation<NodeRepresentation>, Integer>of();
    List<OutgoingRelation<DefinedElement>> _get = OutgoingRelations.get(object);
    for (final OutgoingRelation<DefinedElement> outgoingConcreteEdge : _get) {
      {
        NodeRepresentation _get_1 = previousNodeRepresentations.get(outgoingConcreteEdge.getTo());
        String _type = outgoingConcreteEdge.getType();
        final OutgoingRelation<NodeRepresentation> e = new OutgoingRelation<NodeRepresentation>(_get_1, _type);
        final BiFunction<OutgoingRelation<NodeRepresentation>, Integer, Integer> _function = (OutgoingRelation<NodeRepresentation> key, Integer value) -> {
          return Integer.valueOf(this.addOne(value, parallel));
        };
        res.compute(e, _function);
      }
    }
    return res;
  }
  
  /**
   * def private <KEY,VALUE> void addOrCreate_Set(Map<KEY,Set<VALUE>> map, KEY key, VALUE value) {
   * 	var Set<VALUE> s;
   * 	if(map.containsKey(key)) {
   * 		s = map.get(key);
   * 	} else {
   * 		s = new HashSet
   * 		map.put(key,s)
   * 	}
   * 	s.add(value)
   * }
   */
  private Pair<Map<FurtherNodeDescriptor<NodeRepresentation>, Integer>, MutableMap<DefinedElement, FurtherNodeDescriptor<NodeRepresentation>>> calculateFurtherNodeDescriptors(final PartialInterpretation model, final NeighbourhoodWithTraces<ModelRepresentation, NodeRepresentation> previous, final Map<DefinedElement, List<IncomingRelation<DefinedElement>>> IncomingRelations, final Map<DefinedElement, List<OutgoingRelation<DefinedElement>>> OutgoingRelations, final int parallels, final int maxNumber) {
    final Map<DefinedElement, ? extends NodeRepresentation> previousNodeRepresentations = previous.getNodeRepresentations();
    final int size = previousNodeRepresentations.size();
    final MutableMap<DefinedElement, FurtherNodeDescriptor<NodeRepresentation>> node2Representation = Maps.mutable.<DefinedElement, FurtherNodeDescriptor<NodeRepresentation>>ofInitialCapacity(size);
    MutableMap<FurtherNodeDescriptor<NodeRepresentation>, Integer> _xifexpression = null;
    if (this.mergeSimilarNeighbourhood) {
      _xifexpression = Maps.mutable.<FurtherNodeDescriptor<NodeRepresentation>, Integer>ofInitialCapacity(size);
    } else {
      _xifexpression = null;
    }
    final Map<FurtherNodeDescriptor<NodeRepresentation>, Integer> descriptor2Number = _xifexpression;
    MutableMap<FurtherNodeDescriptor<NodeRepresentation>, FurtherNodeDescriptor<NodeRepresentation>> _xifexpression_1 = null;
    if (this.mergeSimilarNeighbourhood) {
      _xifexpression_1 = Maps.mutable.<FurtherNodeDescriptor<NodeRepresentation>, FurtherNodeDescriptor<NodeRepresentation>>ofInitialCapacity(size);
    } else {
      _xifexpression_1 = null;
    }
    final Map<FurtherNodeDescriptor<NodeRepresentation>, FurtherNodeDescriptor<NodeRepresentation>> uniqueDescription = _xifexpression_1;
    Iterable<DefinedElement> _elements = this.getElements(model);
    for (final DefinedElement object : _elements) {
      {
        final Map<IncomingRelation<NodeRepresentation>, Integer> incomingEdges = this.calculateIncomingEdges(IncomingRelations, object, previousNodeRepresentations, parallels);
        final Map<OutgoingRelation<NodeRepresentation>, Integer> outgoingEdges = this.calcuateOutgoingEdges(OutgoingRelations, object, previousNodeRepresentations, parallels);
        final NodeRepresentation previousType = previousNodeRepresentations.get(object);
        if ((previousType == null)) {
          InputOutput.<String>println("Error in state coder");
        }
        final FurtherNodeDescriptor<NodeRepresentation> nodeDescriptor = new FurtherNodeDescriptor<NodeRepresentation>(previousType, incomingEdges, outgoingEdges);
        if (this.mergeSimilarNeighbourhood) {
          boolean _containsKey = descriptor2Number.containsKey(nodeDescriptor);
          if (_containsKey) {
            descriptor2Number.put(nodeDescriptor, 
              Integer.valueOf(this.addOne(descriptor2Number.get(nodeDescriptor), maxNumber)));
            node2Representation.put(object, uniqueDescription.get(nodeDescriptor));
          } else {
            int _xifexpression_2 = (int) 0;
            if ((1 > maxNumber)) {
              _xifexpression_2 = Integer.MAX_VALUE;
            } else {
              _xifexpression_2 = 1;
            }
            descriptor2Number.put(nodeDescriptor, Integer.valueOf(_xifexpression_2));
            uniqueDescription.put(nodeDescriptor, nodeDescriptor);
            node2Representation.put(object, nodeDescriptor);
          }
        } else {
          node2Representation.put(object, nodeDescriptor);
        }
      }
    }
    return Pair.<Map<FurtherNodeDescriptor<NodeRepresentation>, Integer>, MutableMap<DefinedElement, FurtherNodeDescriptor<NodeRepresentation>>>of(descriptor2Number, node2Representation);
  }
  
  private Pair<Map<LocalNodeDescriptor, Integer>, Map<DefinedElement, LocalNodeDescriptor>> calculateLocalNodeDescriptors(final PartialInterpretation model, final Map<DefinedElement, Set<String>> types, final int maxNumber, final DefinedElement focusedElement) {
    final int size = types.size();
    final Map<DefinedElement, LocalNodeDescriptor> node2Representation = Maps.mutable.<DefinedElement, LocalNodeDescriptor>ofInitialCapacity(size);
    MutableMap<LocalNodeDescriptor, Integer> _xifexpression = null;
    if (this.mergeSimilarNeighbourhood) {
      _xifexpression = Maps.mutable.<LocalNodeDescriptor, Integer>ofInitialCapacity(size);
    } else {
      _xifexpression = null;
    }
    final Map<LocalNodeDescriptor, Integer> representation2Amount = _xifexpression;
    MutableMap<LocalNodeDescriptor, LocalNodeDescriptor> _xifexpression_1 = null;
    if (this.mergeSimilarNeighbourhood) {
      _xifexpression_1 = Maps.mutable.<LocalNodeDescriptor, LocalNodeDescriptor>ofInitialCapacity(size);
    } else {
      _xifexpression_1 = null;
    }
    final Map<LocalNodeDescriptor, LocalNodeDescriptor> uniqueRepresentation = _xifexpression_1;
    Iterable<DefinedElement> _elements = this.getElements(model);
    for (final DefinedElement element : _elements) {
      {
        String _xifexpression_2 = null;
        boolean _equals = Objects.equal(element, focusedElement);
        if (_equals) {
          _xifexpression_2 = PartialInterpretation2NeighbourhoodRepresentation.FOCUSED_ELEMENT_NAME;
        } else {
          _xifexpression_2 = element.getName();
        }
        final String name = _xifexpression_2;
        Set<String> _lookup = CollectionsUtil.<DefinedElement, Set<String>>lookup(element, types);
        LocalNodeDescriptor newDescriptor = new LocalNodeDescriptor(name, _lookup);
        if (this.mergeSimilarNeighbourhood) {
          boolean _containsKey = uniqueRepresentation.containsKey(newDescriptor);
          if (_containsKey) {
            newDescriptor = CollectionsUtil.<LocalNodeDescriptor, LocalNodeDescriptor>lookup(newDescriptor, uniqueRepresentation);
            node2Representation.put(element, newDescriptor);
            representation2Amount.put(newDescriptor, 
              Integer.valueOf(this.addOne(CollectionsUtil.<LocalNodeDescriptor, Integer>lookup(newDescriptor, representation2Amount), maxNumber)));
          } else {
            uniqueRepresentation.put(newDescriptor, newDescriptor);
            node2Representation.put(element, newDescriptor);
            int _xifexpression_3 = (int) 0;
            if ((1 > maxNumber)) {
              _xifexpression_3 = Integer.MAX_VALUE;
            } else {
              _xifexpression_3 = 1;
            }
            representation2Amount.put(newDescriptor, Integer.valueOf(_xifexpression_3));
          }
        } else {
          node2Representation.put(element, newDescriptor);
        }
      }
    }
    return Pair.<Map<LocalNodeDescriptor, Integer>, Map<DefinedElement, LocalNodeDescriptor>>of(representation2Amount, node2Representation);
  }
}
