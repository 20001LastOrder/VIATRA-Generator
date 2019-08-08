/**
Generated from platform:/resource/hu.bme.mit.inf.dslreasoner.domains.yakindu.sgraph/queries/hu/bme/mit/inf/dslreasoner/partialsnapshot_mavo/yakindu/patterns.vql
*/
package constraints.yakindumm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

import org.eclipse.viatra.addon.validation.core.api.Severity;
import org.eclipse.viatra.addon.validation.core.api.IConstraintSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;

import hu.bme.mit.inf.dslreasoner.partialsnapshot_mavo.yakindu.MultipleTransitionFromEntry;

public class MultipleTransitionFromEntryConstraint0 implements IConstraintSpecification {

    private MultipleTransitionFromEntry querySpecification;

    public MultipleTransitionFromEntryConstraint0() {
        querySpecification = MultipleTransitionFromEntry.instance();
    }

    @Override
    public String getMessageFormat() {
        return "error";
    }


    @Override
    public Map<String,Object> getKeyObjects(IPatternMatch signature) {
        Map<String,Object> map = new HashMap<>();
        map.put("e",signature.get("e"));
        return map;
    }

    @Override
    public List<String> getKeyNames() {
        List<String> keyNames = Arrays.asList(
            "e"
        );
        return keyNames;
    }

    @Override
    public List<String> getPropertyNames() {
        List<String> propertyNames = Arrays.asList(
            "t1",
            "t2"
        );
        return propertyNames;
    }

    @Override
    public Set<List<String>> getSymmetricPropertyNames() {
        Set<List<String>> symmetricPropertyNamesSet = new HashSet<>();
        return symmetricPropertyNamesSet;
    }

    @Override
    public Set<List<String>> getSymmetricKeyNames() {
        Set<List<String>> symmetricKeyNamesSet = new HashSet<>();
        return symmetricKeyNamesSet;
    }

    @Override
    public Severity getSeverity() {
        return Severity.ERROR;
    }

    @Override
    public IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>> getQuerySpecification() {
        return querySpecification;
    }

}
