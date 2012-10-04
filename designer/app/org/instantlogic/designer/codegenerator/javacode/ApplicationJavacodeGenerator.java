package org.instantlogic.designer.codegenerator.javacode;


import java.io.File;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;

public class ApplicationJavacodeGenerator extends AbstractJavacodeGenerator {

	public static void generate(GeneratedClassModels context, File sourcePath) {
		File applicationRoot = sourcePath;
		if (context.updatedApplication!=null) {
			String[] packageNames = context.updatedApplication.rootPackageName.split("\\.");
			for (String packageName : packageNames) {
				applicationRoot = new File(applicationRoot, packageName);
			}
			applicationRoot.mkdirs();
			new File(applicationRoot, "entity").mkdirs();
			new File(applicationRoot, "event").mkdirs();
			new File(applicationRoot, "flow").mkdirs();
			new File(applicationRoot, "sharedpagefragment").mkdirs();
			
			generateFile(AbstractJavacodeGenerator.applicationTemplate, context.updatedApplication, null, "Application", applicationRoot);
		}
		for (EntityClassModel entity: context.updatedEntities) {
			boolean oldCustomized = entity.isCustomized;
			entity.isCustomized = false;
			generateFile(AbstractJavacodeGenerator.entityTemplate, entity, "entity", "Entity", applicationRoot);
			entity.isCustomized = oldCustomized;
			generateFile(AbstractJavacodeGenerator.instanceTemplate, entity, null, "", applicationRoot);
		}
		for (EntityClassModel entity: context.deletedEntities) {
			deleteFile("entity", entity, "Entity", applicationRoot);
			deleteFile(null, entity, "Instance", applicationRoot);
			deleteFile(null, entity, "AbstractInstance", applicationRoot);
		}
		for (SharedPageFragmentClassModel sharedPageFramgent:context.updatedSharedPageFragments) {
			generateFile(AbstractJavacodeGenerator.pageFragmentTemplate, sharedPageFramgent, "sharedpagefragment", "PageFragment", applicationRoot);
			
		}
		for (SharedPageFragmentClassModel sharedPageFragment:context.deletedSharedPageFragments) {
			deleteFile("sharedpagefragment", sharedPageFragment, "Pagefragment", applicationRoot);
		}
		for (EventClassModel event:context.updatedEvents) {
			generateFile(AbstractJavacodeGenerator.eventTemplate, event, "event", "Event", applicationRoot);
		}
		for (EventClassModel event:context.deletedEvents) {
			deleteFile("event", event, "Event", applicationRoot);
		}
		for (PlaceClassModel page:context.updatedPages) {
			generateFile(AbstractJavacodeGenerator.placeTemplateTemplate, page, "flow/"+page.flowname.toLowerCase(), "PlaceTemplate", applicationRoot);
		}
		for (PlaceClassModel page:context.deletedPages) {
			deleteFile("flow/"+page.flowname.toLowerCase(), page, "Page", applicationRoot);
		}
		for (FlowClassModel flow:context.updatedFlows) {
			generateFile(AbstractJavacodeGenerator.flowTemplate, flow, "flow", "Flow", applicationRoot);
			if (applicationRoot!=null) {
				new File(new File(applicationRoot,"flow"), flow.technicalNameCapitalized.toLowerCase()).mkdirs();
			}
		}
		for (FlowClassModel flow:context.deletedFlows) {
			deleteFile("flow", flow, "Flow", applicationRoot);
			File dir = new File(applicationRoot,"flow/"+flow.name.toLowerCase()); 
			purge(dir);
			dir.delete();
		}
		for (SubFlowClassModel subFlow:context.updatedSubFlows) {
			generateFile(AbstractJavacodeGenerator.subFlowTemplate, subFlow, "flow/"+subFlow.flowname.toLowerCase(), "SubFlow", applicationRoot);
		}
		for (SubFlowClassModel subFlow:context.deletedSubFlows) {
			deleteFile("flow/"+subFlow.flowname.toLowerCase(), subFlow, "SubFlow", applicationRoot);
		}
	}
}
