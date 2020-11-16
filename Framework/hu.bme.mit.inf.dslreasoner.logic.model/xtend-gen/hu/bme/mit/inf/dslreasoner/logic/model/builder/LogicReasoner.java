package hu.bme.mit.inf.dslreasoner.logic.model.builder;

import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicModelInterpretation;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicReasonerException;
import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicSolverConfiguration;
import hu.bme.mit.inf.dslreasoner.logic.model.logicproblem.LogicProblem;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.LogicResult;
import hu.bme.mit.inf.dslreasoner.logic.model.logicresult.ModelResult;
import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace;
import java.util.List;

@SuppressWarnings("all")
public abstract class LogicReasoner {
  public abstract LogicResult solve(final LogicProblem problem, final LogicSolverConfiguration configuration, final ReasonerWorkspace workspace) throws LogicReasonerException;
  
  public abstract List<? extends LogicModelInterpretation> getInterpretations(final ModelResult modelResult);
}
