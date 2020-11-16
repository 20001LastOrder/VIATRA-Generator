package hu.bme.mit.inf.dslreasoner.ecore2logic;

import hu.bme.mit.inf.dslreasoner.ecore2logic.ContainmentMapper_ReferenceConjuction;
import hu.bme.mit.inf.dslreasoner.ecore2logic.Trace;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Assertion;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Constant;
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Relation;

@SuppressWarnings("all")
public class ContainmentMapper_ReferenceConjuction_Trace implements Trace<ContainmentMapper_ReferenceConjuction> {
  public Constant root;
  
  public Relation contains;
  
  public Assertion containsDefinition;
  
  public Assertion rootIsNotContained;
  
  public Assertion everithingElseContained;
  
  public Assertion notContainedByMore;
}
