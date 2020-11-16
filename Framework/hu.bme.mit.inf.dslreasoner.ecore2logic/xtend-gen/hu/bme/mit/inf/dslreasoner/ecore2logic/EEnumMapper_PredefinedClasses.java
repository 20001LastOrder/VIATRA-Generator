package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.EEnumMapper;
import hu.bme.mit.inf.dslreasoner.ecore2logic.EEnumMapper_PredefinedClasses_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2LogicConfiguration;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.DefinedElement;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TermDescription;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Type;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.TypeDefinition;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.util.CollectionsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class EEnumMapper_PredefinedClasses implements EEnumMapper {
  @Extension
  private final LogicProblemBuilder builder = new LogicProblemBuilder();
  
  @Override
  public void transformEEnums(final Ecore2Logic_Trace trace, final LogicProblem problem, final Iterable<EEnum> enums, final Ecore2LogicConfiguration config) {
    final EEnumMapper_PredefinedClasses_Trace enumTrace = new EEnumMapper_PredefinedClasses_Trace();
    trace.enumMapperTrace = enumTrace;
    HashMap<EEnum, Type> _hashMap = new HashMap<EEnum, Type>();
    enumTrace.enums = _hashMap;
    HashMap<Enumerator, DefinedElement> _hashMap_1 = new HashMap<Enumerator, DefinedElement>();
    enumTrace.literals = _hashMap_1;
    for (final EEnum enum_ : enums) {
      {
        int _size = enum_.getELiterals().size();
        final ArrayList<DefinedElement> l = new ArrayList<DefinedElement>(_size);
        final Function1<EEnumLiteral, Enumerator> _function = (EEnumLiteral it) -> {
          return it.getInstance();
        };
        List<Enumerator> _map = ListExtensions.<EEnumLiteral, Enumerator>map(enum_.getELiterals(), _function);
        for (final Enumerator literal : _map) {
          {
            StringConcatenation _builder = new StringConcatenation();
            String _name = literal.getName();
            _builder.append(_name);
            _builder.append(" literal ");
            String _name_1 = enum_.getName();
            _builder.append(_name_1);
            final DefinedElement element = this.builder.Element(_builder);
            l.add(element);
            enumTrace.literals.put(literal, element);
          }
        }
        StringConcatenation _builder = new StringConcatenation();
        String _name = enum_.getName();
        _builder.append(_name);
        _builder.append(" enum");
        final TypeDefinition type = this.builder.TypeDefinition(_builder, false, l);
        this.builder.add(problem, type);
        enumTrace.enums.put(enum_, type);
      }
    }
  }
  
  private EEnumMapper_PredefinedClasses_Trace asTrace(final Trace<? extends EEnumMapper> o) {
    return ((EEnumMapper_PredefinedClasses_Trace) o);
  }
  
  @Override
  public Type TypeofEEnum(final Ecore2Logic_Trace trace, final EEnum type) {
    return this.asTrace(trace.enumMapperTrace).enums.get(type);
  }
  
  @Override
  public TermDescription Literal(final Ecore2Logic_Trace trace, final Enumerator literal) {
    return CollectionsUtil.<Enumerator, DefinedElement>lookup(literal, this.asTrace(trace.enumMapperTrace).literals);
  }
  
  @Override
  public Iterable<EEnum> allEnumsInScope(final Ecore2Logic_Trace trace) {
    return this.asTrace(trace.enumMapperTrace).enums.keySet();
  }
  
  @Override
  public Iterable<Enumerator> allLiteralsInScope(final Ecore2Logic_Trace trace) {
    return this.asTrace(trace.enumMapperTrace).literals.keySet();
  }
}
