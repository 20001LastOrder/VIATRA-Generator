package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretation2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.Ecore2Logic_Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.TracedOutput;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretation2logic.InstanceModel2PartialInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretation2logic.PartialInterpretation2Logic;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation;
import java.util.List;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class InstanceModel2Logic {
  private final InstanceModel2PartialInterpretation instanceModel2PartialInterpretation = new InstanceModel2PartialInterpretation();
  
  private final PartialInterpretation2Logic partialInterpretation2Logic = new PartialInterpretation2Logic();
  
  public TracedOutput<LogicProblem, Ecore2Logic_Trace> transform(final TracedOutput<LogicProblem, Ecore2Logic_Trace> metamodelTranslationResult, final List<EObject> objects) {
    final PartialInterpretation res1 = this.instanceModel2PartialInterpretation.transform(metamodelTranslationResult, objects, true);
    this.partialInterpretation2Logic.transformPartialIntepretation2Logic(metamodelTranslationResult.getOutput(), res1);
    return metamodelTranslationResult;
  }
}
