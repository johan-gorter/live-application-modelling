package org.instantlogic.designer.codegenerator.generator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.PageFragmentHolderDesign;
import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class ApplicationGenerator extends AbstractGenerator{

	private ApplicationDesign applicationInstance;
	
	private Map<String, EntityGenerator> entityGenerators=new HashMap<String, EntityGenerator>();
	private Map<String, EventGenerator> eventGenerators = new HashMap<String, EventGenerator>(); 
	private Map<String, FlowGenerator> flowGenerators = new HashMap<String, FlowGenerator>(); 
	private Map<String, SharedPageFragmentGenerator> sharedPageFragmentGenerators = new HashMap<String, SharedPageFragmentGenerator>();

	public ApplicationGenerator(ApplicationDesign applicationInstance) {
		this.applicationInstance = applicationInstance;
	}
	
	
	/**
	 * @return The updates to the class models since the previous call. On the first call, every classmodel is returned.
	 */
	public GeneratedClassModels getClassModelUpdates() {
		GeneratedClassModels result = new GeneratedClassModels();
		result.rootPackageName = applicationInstance.getRootPackageName();
		update(result);
		return result;
	}
	
	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) {
			updateAll(entityGenerators.values(), context);
			updateAll(eventGenerators.values(), context);
			updateAll(flowGenerators.values(), context);
			updateAll(sharedPageFragmentGenerators.values(), context);
			return;
		}
		
		applicationInstance.getMetadata().getCaseAdministration().startRecordingObservations();
		ApplicationClassModel model = new ApplicationClassModel();

		model.rootPackageName = applicationInstance.getRootPackageName();
		model.name = applicationInstance.getName();
		model.isCustomized = applicationInstance.getIsCustomized()==Boolean.TRUE;
		for (EntityDesign entity: applicationInstance.getEntities()) {
			model.entities.add(entity.getName());
		}
		model.caseEntity = applicationInstance.getCaseEntity().getName();
		for (FlowDesign exposed: applicationInstance.getExposedFlows()) {
			model.exposedFlows.add(exposed.getName());
		}
		
		List<Design> newEntities = updateGenerators(entityGenerators, applicationInstance.getEntities(), context);
		for(Design newEntity : newEntities) {
			EntityGenerator entityGenerator = new EntityGenerator((EntityDesign)newEntity);
			entityGenerator.update(context);
			entityGenerators.put(newEntity.getName(), entityGenerator);
		}
		
		List<Design> newSharedPageFragments = updateGenerators(sharedPageFragmentGenerators, applicationInstance.getSharedPageFragments(), context);
		for(Design newSharedPageFragment : newSharedPageFragments) {
			SharedPageFragmentGenerator sharedPageFragmentGenerator = new SharedPageFragmentGenerator((PageFragmentHolderDesign)newSharedPageFragment);
			sharedPageFragmentGenerator.update(context);
			sharedPageFragmentGenerators.put(newSharedPageFragment.getName(), sharedPageFragmentGenerator);
		}

		List<Design> newEvents = updateGenerators(eventGenerators, applicationInstance.getEvents(), context);
		for(Design newEvent : newEvents) {
			EventGenerator eventGenerator = new EventGenerator((EventDesign)newEvent);
			eventGenerator.update(context);
			eventGenerators.put(newEvent.getName(), eventGenerator);
		}
		
		
		List<Design> newFlows = updateGenerators(flowGenerators, applicationInstance.getFlows(), context);
		for(Design newFlow : newFlows) {
			FlowGenerator flowGenerator = new FlowGenerator((FlowDesign)newFlow);
			flowGenerator.update(context);
			flowGenerators.put(newFlow.getName(), flowGenerator);
		}
		
		this.observations = new ObservationsOutdatedObserver(applicationInstance.getMetadata().getCaseAdministration().stopRecordingObservations(), null);
		context.updatedApplication = model;
	}

	@Override
	public void delete(GeneratedClassModels context) {
	}


	public void generateJavaCode() {
		GeneratedClassModels classModelUpdates = getClassModelUpdates();
		ApplicationJavacodeGenerator.generate(classModelUpdates, new File(applicationInstance.getSourcePath()));
	}
}
