package hu.bme.mit.inf.dslreasoner.application.linking

import com.google.inject.Inject
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ApplicationConfigurationPackage
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.EPackageImport
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ViatraImport
import java.util.Collections
import java.util.Optional
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.viatra.query.patternlanguage.emf.scoping.IMetamodelProvider
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.emf.ecore.resource.Resource
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.PatternEntry
import org.eclipse.emf.ecore.util.EcoreUtil
import hu.bme.mit.inf.dslreasoner.application.applicationConfiguration.ConfigurationScript
import org.eclipse.xtext.EcoreUtil2
import java.util.List
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter

class ApplicationConfigurationLinkingService extends DefaultLinkingService{

    //@Inject Logger logger

    @Inject IValueConverterService valueConverterService

    @Inject IMetamodelProvider metamodelProvider
    
    public static extension ApplicationConfigurationPackage pac = ApplicationConfigurationPackage.eINSTANCE

    override getLinkedObjects(EObject context, EReference ref, INode node) {
    	if(context instanceof EPackageImport) {
    		if(ref == EPackageImport_ImportedPackage && node instanceof ILeafNode) {
    			return getEPackage(context as EPackageImport, node as ILeafNode)
    		}
    	} else if(context instanceof ViatraImport) {
    		if(ref == viatraImport_ImportedViatra && node instanceof ILeafNode) {
    			return getViatra(context as ViatraImport, node as ILeafNode)
    		}
        } else if(context instanceof PatternEntry) {
        	if(ref === patternEntry_Package) {
        		return getViatraPackage(context as PatternEntry,node)
        	}
        }
        return super.getLinkedObjects(context, ref, node)
    }
	
	def getViatraPackage(PatternEntry entry, INode node) {
		val document = EcoreUtil2.getContainerOfType(entry,ConfigurationScript)
		val nodeString = valueConverterService.toValue(node.text,
                linkingHelper.getRuleNameFrom(node.grammarElement), node).toString.replaceAll("\\s","")
		val patternModels = document.imports.filter(ViatraImport).map[it.importedViatra].filterNull
		val List<EObject> patternModelsWithSameNamespace = patternModels.filter[nodeString.equals(it.packageName)].filter(EObject).toList
		return patternModelsWithSameNamespace
	}

    private def getEPackage(EPackageImport packageImport, ILeafNode node) {
        getNSUri(node).flatMap [ uri |
            Optional.ofNullable(metamodelProvider.loadEPackage(uri, packageImport.eResource.resourceSet))
        ].map [ ePackage |
            Collections.singletonList(ePackage as EObject)
        ].orElse(emptyList)
    }
    
    private def getViatra(ViatraImport viatraImport, ILeafNode node) {
    	val uri = getNSUri(node)
    	if(uri.present) {
    		var URI createdURI
    		try{
    			createdURI = URI.createURI(uri.get)
    		}catch(IllegalArgumentException e) {
    			return super.getLinkedObjects(viatraImport, viatraImport_ImportedViatra, node)
    		}
    		var Resource res
    		try{
    			res = viatraImport.eResource.resourceSet.getResource(createdURI,true);
    		} catch(RuntimeException  e){
    			return super.getLinkedObjects(viatraImport, viatraImport_ImportedViatra, node)
    		}
    		if(res!==null && !res.contents.empty) {
    			return #[res.contents.head]
    		} else {
    			return super.getLinkedObjects(viatraImport, viatraImport_ImportedViatra, node)
    		}
    	} else {
    		return super.getLinkedObjects(viatraImport, viatraImport_ImportedViatra, node)
    	}
    }

    private def getNSUri(ILeafNode node) {
        try {
            val convertedValue = valueConverterService.toValue(node.text,
                linkingHelper.getRuleNameFrom(node.grammarElement), node)
            Optional.of(convertedValue as String)
        } catch (ValueConverterException e) {
            Optional.empty
        }
    }
}