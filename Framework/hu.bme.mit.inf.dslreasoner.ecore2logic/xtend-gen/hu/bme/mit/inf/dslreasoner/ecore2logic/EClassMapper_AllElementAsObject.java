package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EClassMapper_AllElementAsObject_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EcoreMetamodelDescriptor;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EClassMapper_AllElementAsObject implements EClassMapper {
  @Extension
  private final LogicProblemBuilder builder = new LogicProblemBuilder();
  
  @Override
  public void transformEClasses(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EClass> classes, final int numberOfObjects, final EcoreMetamodelDescriptor metamodelDescriptor) {
    final EClassMapper_AllElementAsObject_Trace classMapperTrace = new EClassMapper_AllElementAsObject_Trace();
    trace.classMapperTrace = classMapperTrace;
    for (final EClass c : classes) {
      {
        StringConcatenation _builder = new StringConcatenation();
        String _name = c.getName();
        _builder.append(_name);
        _builder.append(" class");
        final Type logicType = this.builder.add(problem, this.builder.TypeDeclaration(_builder, (c.isAbstract() || c.isInterface())));
        classMapperTrace.typeMap.put(c, logicType);
      }
    }
    for (final EClass c_1 : classes) {
      EList<EClass> _eSuperTypes = c_1.getESuperTypes();
      for (final EClass s : _eSuperTypes) {
        this.builder.Supertype(classMapperTrace.typeMap.get(c_1), classMapperTrace.typeMap.get(s));
      }
    }
  }
  
  public EClassMapper_AllElementAsObject_Trace asTrace(final Trace<? extends EClassMapper> o) {
    return ((EClassMapper_AllElementAsObject_Trace) o);
  }
  
  @Override
  public Type TypeofEClass(final Ecore2Logic_Trace trace, final EClass type) {
    Type _xblockexpression = null;
    {
      final Map<EClass, Type> typeMap = this.asTrace(trace.classMapperTrace).typeMap;
      Type _xifexpression = null;
      boolean _containsKey = typeMap.containsKey(type);
      if (_containsKey) {
        _xifexpression = typeMap.get(type);
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Class ");
        String _name = type.getName();
        _builder.append(_name);
        _builder.append(" is not translated to logic!");
        throw new IllegalArgumentException(_builder.toString());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public Iterable<EClass> allClassesInScope(final Ecore2Logic_Trace trace) {
    return this.asTrace(trace.classMapperTrace).typeMap.keySet();
  }
}
