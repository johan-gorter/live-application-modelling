package org.instantlogic.designer.codegenerator;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.PageFragmentHolderDesign;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class ApplicationGenerator extends AbstractGenerator {

	private ApplicationDesign applicationInstance;
	
	private Map<String, EntityGenerator> entityGenerators=new HashMap<String, EntityGenerator>();
	private Map<String, EventGenerator> eventGenerators = new HashMap<String, EventGenerator>(); 
	private Map<String, FlowGenerator> flowGenerators = new HashMap<String, FlowGenerator>(); 
	private Map<String, SharedPageFragmentGenerator> sharedPageFragmentGenerators = new HashMap<String, SharedPageFragmentGenerator>();
	
	private boolean mustRegenerate = false;

	public ApplicationGenerator(ApplicationDesign applicationInstance) {
		this.applicationInstance = applicationInstance;
	}

	public void dryRun() {
		update(null);
	}

	public void afterSubmit() {
		//TODO: if appname changed...
		File applicationRoot;
		if (applicationInstance.getSourcePath()!=null) {
			applicationRoot = new File(applicationInstance.getSourcePath());
			String[] packageNames = applicationInstance.getRootPackageName().split("\\.");
			for (String packageName : packageNames) {
				applicationRoot = new File(applicationRoot, packageName);
			}
		} else {
			applicationRoot = new File(applicationInstance.getName());
		}
		applicationRoot.mkdirs();
		update(applicationRoot);
	}
	
	public void delete(File applicationRoot) {
		purge(applicationRoot);
	}
	
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated() && !mustRegenerate) {
			updateAll(entityGenerators.values(), applicationRoot);
			updateAll(flowGenerators.values(), applicationRoot);
			return;
		}
		if (mustRegenerate) {
//TODO: rethink what can be thrown away, for example only files containing the special word AllowGeneratorToOverwriteThisFile purge(applicationRoot);
			eventGenerators.clear();
			entityGenerators.clear();
			flowGenerators.clear();
			sharedPageFragmentGenerators.clear();
		}
		mustRegenerate = false;
		
		applicationInstance.getMetadata().getCaseAdministration().startRecordingObservations();
		rootPackageName = applicationInstance.getRootPackageName();
		name = applicationInstance.getName();
		isCustomized = applicationInstance.getIsCustomized()==Boolean.TRUE;
		entities = new ArrayList<String>();
		for (EntityDesign entity: applicationInstance.getEntities()) {
			entities.add(entity.getName());
		}
		caseEntity = applicationInstance.getCaseEntity().getName();
		exposedFlows = new ArrayList<String>();
		for (FlowDesign exposed: applicationInstance.getExposedFlows()) {
			exposedFlows.add(exposed.getName());
		}
		
		if (applicationRoot!=null) {
			new File(applicationRoot, "entity").mkdirs();
			new File(applicationRoot, "event").mkdirs();
			new File(applicationRoot, "flow").mkdirs();
			new File(applicationRoot, "sharedpagefragment").mkdirs();
		}

		//TODO: if application.generateApplication...
		//AbstractGenerator.generateFile(AbstractGenerator.applicationTemplate, this, null, name, "Application", rootPackageName, applicationRoot);
		
		List<Design> newEntities = updateGenerators(entityGenerators, applicationInstance.getEntities(), applicationRoot);
		for(Design newEntity : newEntities) {
			EntityGenerator entityGenerator = new EntityGenerator((EntityDesign)newEntity, rootPackageName);
			entityGenerator.update(applicationRoot);
			entityGenerators.put(newEntity.getName(), entityGenerator);
		}
		
		// TODO: re-enable
//		List<Design> newSharedPageFragments = updateGenerators(sharedPageFragmentGenerators, applicationInstance.getSharedPageFragments(), applicationRoot);
//		for(Design newSharedPageFragment : newSharedPageFragments) {
//			SharedPageFragmentGenerator sharedPageFragmentGenerator = new SharedPageFragmentGenerator((PageFragmentHolderDesign)newSharedPageFragment, rootPackageName);
//			sharedPageFragmentGenerator.update(applicationRoot);
//			sharedPageFragmentGenerators.put(newSharedPageFragment.getName(), sharedPageFragmentGenerator);
//		}
//
//		List<Design> newEvents = updateGenerators(eventGenerators, applicationInstance.events.get(), applicationRoot);
//		for(Design newEvent : newEvents) {
//			EventGenerator eventGenerator = new EventGenerator((EventDesign)newEvent, rootPackageName);
//			eventGenerator.update(applicationRoot);
//			eventGenerators.put(newEvent.getName(), eventGenerator);
//		}
//		
//		
//		List<Design> newFlows = updateGenerators(flowGenerators, applicationInstance.flows.get(), applicationRoot);
//		for(Design newFlow : newFlows) {
//			FlowGenerator flowGenerator = new FlowGenerator((FlowDesign)newFlow, rootPackageName);
//			flowGenerator.update(applicationRoot);
//			flowGenerators.put(newFlow.getName(), flowGenerator);
//		}
		
		this.observations = new ObservationsOutdatedObserver(applicationInstance.getMetadata().getCaseAdministration().stopRecordingObservations(), null);
	}
	
	public String caseEntity;
	public List<String> exposedFlows;
	public List<String> entities;
	
	public String getCaseEntity() {
		return caseEntity;
	}
	public List<String> getExposedFlows() {
		return exposedFlows;
	}
	public List<String> getEntities() {
		return entities;
	}

	public void setMustRegenerate() {
		mustRegenerate = true;
	}

	public void generateJavaCode() {
		mustRegenerate=true;
		afterSubmit();
	}
}
