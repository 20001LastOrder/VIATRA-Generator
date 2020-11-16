package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.ContainmentMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.ContainmentMapper_ReferenceConjuction;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EAttributeMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EAttributeMapper_RelationsOverTypes;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper_AllElementAsObject;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EEnumMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EEnumMapper_PredefinedClasses;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EReferenceMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EReferenceMapper_RelationsOverTypes;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2LogicConfiguration;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EcoreMetamodelDescriptor;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.TracedOutput;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.RelationDeclaration;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDescriptor;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Ecore2Logic implements EClassMapper, EEnumMapper, EReferenceMapper, ContainmentMapper, EAttributeMapper {
  @Delegate
  protected final EClassMapper classMapper;
  
  @Delegate
  protected final EEnumMapper enumMapper;
  
  @Delegate
  protected final EReferenceMapper referenceMapper;
  
  @Delegate
  protected final ContainmentMapper containmentMapper;
  
  @Delegate
  protected final EAttributeMapper attributeMapper;
  
  public Ecore2Logic() {
    EClassMapper_AllElementAsObject _eClassMapper_AllElementAsObject = new EClassMapper_AllElementAsObject();
    this.classMapper = _eClassMapper_AllElementAsObject;
    EEnumMapper_PredefinedClasses _eEnumMapper_PredefinedClasses = new EEnumMapper_PredefinedClasses();
    this.enumMapper = _eEnumMapper_PredefinedClasses;
    EReferenceMapper_RelationsOverTypes _eReferenceMapper_RelationsOverTypes = new EReferenceMapper_RelationsOverTypes(this.classMapper);
    this.referenceMapper = _eReferenceMapper_RelationsOverTypes;
    ContainmentMapper_ReferenceConjuction _containmentMapper_ReferenceConjuction = new ContainmentMapper_ReferenceConjuction(this.classMapper, this.referenceMapper, 0);
    this.containmentMapper = _containmentMapper_ReferenceConjuction;
    EAttributeMapper_RelationsOverTypes _eAttributeMapper_RelationsOverTypes = new EAttributeMapper_RelationsOverTypes(this.classMapper, this.enumMapper);
    this.attributeMapper = _eAttributeMapper_RelationsOverTypes;
  }
  
  public Ecore2Logic(final EClassMapper classMapper, final EEnumMapper enumMapper, final EReferenceMapper referenceMapper, final ContainmentMapper containmentMapper, final EAttributeMapper attributeMapper) {
    if ((((((classMapper == null) || (enumMapper == null)) || (referenceMapper == null)) || (containmentMapper == null)) || 
      (attributeMapper == null))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The mappers should not be null!");
      throw new IllegalArgumentException(_builder.toString());
    }
    this.classMapper = classMapper;
    this.enumMapper = enumMapper;
    this.referenceMapper = referenceMapper;
    this.containmentMapper = containmentMapper;
    this.attributeMapper = attributeMapper;
  }
  
  public TracedOutput<LogicProblem, Ecore2Logic_Trace> transformMetamodel(final EcoreMetamodelDescriptor metamodel, final Ecore2LogicConfiguration config) {
    final Ecore2Logic_Trace trace = new Ecore2Logic_Trace();
    final LogicProblem problem = new LogicProblemBuilder().createProblem();
    this.transformEClasses(trace, problem, metamodel.getClasses(), config.numberOfObjects, metamodel);
    this.transformEEnums(trace, problem, metamodel.getEnums(), config);
    this.transformEReferences(trace, problem, metamodel.getReferences());
    this.transformContainment(trace, problem, metamodel.getReferences(), config.singleRoot);
    this.transformEAttributes(trace, problem, metamodel.getAttributes());
    return new TracedOutput<LogicProblem, Ecore2Logic_Trace>(problem, trace);
  }
  
  public Type TypeofEClass(final Ecore2Logic_Trace trace, final EClass type) {
    return this.classMapper.TypeofEClass(trace, type);
  }
  
  public Iterable<EClass> allClassesInScope(final Ecore2Logic_Trace trace) {
    return this.classMapper.allClassesInScope(trace);
  }
  
  public void transformEClasses(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EClass> classes, final int numberOfObjects, final EcoreMetamodelDescriptor metamodelDescriptor) {
    this.classMapper.transformEClasses(trace, problem, classes, numberOfObjects, metamodelDescriptor);
  }
  
  public TermDescription Literal(final Ecore2Logic_Trace trace, final Enumerator literal) {
    return this.enumMapper.Literal(trace, literal);
  }
  
  public Type TypeofEEnum(final Ecore2Logic_Trace trace, final EEnum type) {
    return this.enumMapper.TypeofEEnum(trace, type);
  }
  
  public Iterable<EEnum> allEnumsInScope(final Ecore2Logic_Trace trace) {
    return this.enumMapper.allEnumsInScope(trace);
  }
  
  public Iterable<Enumerator> allLiteralsInScope(final Ecore2Logic_Trace trace) {
    return this.enumMapper.allLiteralsInScope(trace);
  }
  
  public void transformEEnums(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EEnum> enums, final Ecore2LogicConfiguration config) {
    this.enumMapper.transformEEnums(trace, problem, enums, config);
  }
  
  public Term IsInReference(final Ecore2Logic_Trace trace, final TermDescription source, final TermDescription target, final EReference type) {
    return this.referenceMapper.IsInReference(trace, source, target, type);
  }
  
  public Iterable<EReference> allReferencesInScope(final Ecore2Logic_Trace trace) {
    return this.referenceMapper.allReferencesInScope(trace);
  }
  
  public RelationDeclaration relationOfReference(final Ecore2Logic_Trace trace, final EReference reference) {
    return this.referenceMapper.relationOfReference(trace, reference);
  }
  
  public void transformEReferences(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> classes) {
    this.referenceMapper.transformEReferences(trace, problem, classes);
  }
  
  public void transformContainment(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EReference> references, final boolean singleRoot) {
    this.containmentMapper.transformContainment(trace, problem, references, singleRoot);
  }
  
  public Term IsAttributeValue(final Ecore2Logic_Trace trace, final TermDescription object, final TermDescription value, final EAttribute attribute) {
    return this.attributeMapper.IsAttributeValue(trace, object, value, attribute);
  }
  
  public TypeDescriptor TypeOfRange(final Ecore2Logic_Trace trace, final EAttribute attribute) {
    return this.attributeMapper.TypeOfRange(trace, attribute);
  }
  
  public Iterable<EAttribute> allAttributesInScope(final Ecore2Logic_Trace trace) {
    return this.attributeMapper.allAttributesInScope(trace);
  }
  
  public RelationDeclaration relationOfAttribute(final Ecore2Logic_Trace trace, final EAttribute attribute) {
    return this.attributeMapper.relationOfAttribute(trace, attribute);
  }
  
  public void transformEAttributes(final Ecore2Logic_Trace trace, final LogicProblem logicProblem, final Iterable<EAttribute> attributes) {
    this.attributeMapper.transformEAttributes(trace, logicProblem, attributes);
  }
}
