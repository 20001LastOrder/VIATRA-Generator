package hu.bme.mit.inf.dslreasoner.run

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialInterpretation
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.ModelGenerationMethod
import hu.bme.mit.inf.dslreasoner.viatrasolver.reasoner.ModelGenerationMethodBasedGlobalConstraint
import org.eclipse.viatra.dse.base.ThreadContext
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher

class FileSystemInconsistencyDetector extends ModelGenerationMethodBasedGlobalConstraint {
	var PartialInterpretation partialInterpretation
	
	//unfinishedLowerMultiplicity_root_reference_FileSystem
	//unfinishedLowerMultiplicity_filesystems_reference_Model
	var ViatraQueryMatcher<?> filesystem
	var ViatraQueryMatcher<?> root
	
	new(ModelGenerationMethod method) {
		super(method)
	}
	
	override init(ThreadContext context) {
		partialInterpretation = context.model as PartialInterpretation
		
		try{
			this.filesystem = method.allPatterns.filter[
				it.fullyQualifiedName.equals("unfinishedLowerMultiplicity_root_reference_FileSystem")
			].head.getMatcher(context.queryEngine)
			
			this.root = method.allPatterns.filter[
				it.fullyQualifiedName.equals("unfinishedLowerMultiplicity_filesystems_reference_Model")
			].head.getMatcher(context.queryEngine)
			
		} catch(Exception e) {	}
	}
	
	override checkGlobalConstraint(ThreadContext context) {
		var requiredNewObjects = 
				root.countMatches*2 +
				filesystem.countMatches
		val availableNewObjects = partialInterpretation.maxNewElements
		val res = availableNewObjects >= requiredNewObjects
		println('''[«availableNewObjects» >= «requiredNewObjects»] = «res»''')
		return res
	}
	
	override createNew() {
		return new FileSystemInconsistencyDetector(this.method)
	}
	
	override getName() {
		this.class.simpleName
	}
}
