package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lbe.instance.Observations;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ValueChangeListener;

import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.ConceptInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.EventInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.PageFragmentHolderInstance;

public class ApplicationGenerator extends AbstractGenerator {

	private ApplicationInstance applicationInstance;
	
	private Map<String, EntityGenerator> entityGenerators=new HashMap<String, EntityGenerator>();
	private Map<String, EventGenerator> eventGenerators = new HashMap<String, EventGenerator>(); 
	private Map<String, FlowGenerator> flowGenerators = new HashMap<String, FlowGenerator>(); 
	
	private boolean mustRegenerate = false;


	public ApplicationGenerator(ApplicationInstance applicationInstance) {
		this.applicationInstance = applicationInstance;
	}

	public void dryRun() {
		update(null);
	}

	public void afterSubmit() {
		//TODO: if appname changed...
		File applicationRoot = new File(AbstractGenerator.applicationsRoot, appname);
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
			purge(applicationRoot);
			eventGenerators.clear();
			entityGenerators.clear();
			flowGenerators.clear();
		}
		mustRegenerate = false;
		
		applicationInstance.startRecordingObservations();
		appname = applicationInstance.name.get().toLowerCase();
		name = applicationInstance.name.get();
		customization = applicationInstance.customization.get();
		caseInstanceCustomization = applicationInstance.caseEntity.get().customization.get();
		entities = new ArrayList<String>();
		for (EntityInstance entity: applicationInstance.entities.get()) {
			entities.add(entity.name.get());
		}
		caseEntity = applicationInstance.caseEntity.get().name.get();
		exposedFlows = new ArrayList<String>();
		for (FlowInstance exposed: applicationInstance.exposedFlows.get()) {
			exposedFlows.add(exposed.name.get());
		}
		
		if (applicationRoot!=null) {
			new File(applicationRoot, "data/entity").mkdirs();
			new File(applicationRoot, "data/instance").mkdirs();
			new File(applicationRoot, "event").mkdirs();
			new File(applicationRoot, "flow").mkdirs();
		}

		AbstractGenerator.generateFile(AbstractGenerator.applicationTemplate, this, null, name, "Application", appname, applicationRoot);
		
		List<ConceptInstance> newEntities = updateGenerators(entityGenerators, applicationInstance.entities.get(), applicationRoot);
		for(ConceptInstance newEntity : newEntities) {
			EntityGenerator entityGenerator = new EntityGenerator((EntityInstance)newEntity, appname);
			entityGenerator.update(applicationRoot);
			entityGenerators.put(newEntity.getName(), entityGenerator);
		}

		for (PageFragmentHolderInstance pageFragment: applicationInstance.shared.get().pageFragments.get()) {
//TODO:			generatePageFragment(pageFragment, appname, applicationRoot);
		}
		// TODO: textHolder

		List<ConceptInstance> newEvents = updateGenerators(eventGenerators, applicationInstance.events.get(), applicationRoot);
		for(ConceptInstance newEvent : newEvents) {
			EventGenerator eventGenerator = new EventGenerator((EventInstance)newEvent, appname);
			eventGenerator.update(applicationRoot);
			eventGenerators.put(newEvent.getName(), eventGenerator);
		}
		
		
		List<ConceptInstance> newFlows = updateGenerators(flowGenerators, applicationInstance.flows.get(), applicationRoot);
		for(ConceptInstance newFlow : newFlows) {
			FlowGenerator flowGenerator = new FlowGenerator((FlowInstance)newFlow, appname);
			flowGenerator.update(applicationRoot);
			flowGenerators.put(newFlow.getName(), flowGenerator);
		}
		
		this.observations = applicationInstance.stopRecordingObservations();
	}
	
	public String caseEntity;
	public List<String> exposedFlows;
	public List<String> entities;
	public String caseInstanceCustomization;
	
	public String getCaseEntity() {
		return caseEntity;
	}
	public List<String> getExposedFlows() {
		return exposedFlows;
	}
	public List<String> getEntities() {
		return entities;
	}

	public String getCaseInstanceCustomization() {
		return caseInstanceCustomization;
	}
	
	public void setMustRegenerate() {
		mustRegenerate = true;
	}
}
