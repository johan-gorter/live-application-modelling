package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lbe.instance.Observations;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ValueChangeListener;

import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.PageFragmentHolderInstance;

public class ApplicationGenerator extends AbstractClassModel implements ValueChangeListener {

	private ApplicationInstance applicationInstance;

	public ApplicationGenerator(ApplicationInstance applicationInstance) {
		this.applicationInstance = applicationInstance;
	}
	
	public void generate() {
		applicationInstance.startRecordingObservations();
		appname = applicationInstance.name.get().toLowerCase();
		name = applicationInstance.name.get();
		customization = applicationInstance.customization.get();
		entities = new ArrayList<String>();
		for (EntityInstance entity: applicationInstance.entities.get()) {
			entities.add(entity.name.get());
		}
		caseEntity = applicationInstance.caseEntity.get().name.get();
		exposedFlows = new ArrayList<String>();
		for (FlowInstance exposed: applicationInstance.exposedFlows.get()) {
			exposedFlows.add(exposed.name.get());
		}
		
		File applicationRoot = new File(CodeGenerator.applicationsRoot, appname);
		applicationRoot.mkdirs();
		purge(applicationRoot);
		
		CodeGenerator.generateFile(CodeGenerator.applicationTemplate, this, null, name, "Application", appname, applicationRoot);
		
		new File(applicationRoot, "data/entity").mkdirs();
		new File(applicationRoot, "data/instance").mkdirs();
		for (EntityInstance entity: applicationInstance.entities.get()) {
			CodeGenerator.generateEntity(entity, appname, applicationRoot);
		}
		for (PageFragmentHolderInstance pageFragment: applicationInstance.shared.get().pageFragments.get()) {
//TODO:			generatePageFragment(pageFragment, appname, applicationRoot);
		}
		// TODO: textHolder
		new File(applicationRoot, "flow").mkdirs();
		for (FlowInstance flow: applicationInstance.flows.get()) {
			CodeGenerator.generateFlow(flow, appname, applicationRoot);
		}
		Observations observations = applicationInstance.stopRecordingObservations();
		observations.setOneTimeOutdatedListener(this);
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

	@Override
	public void valueChanged(ReadOnlyAttributeValue value) {
		// NO: register an aftersubmit listener that regenerates.
		// generate();
	}

	private static void purge(File dir) {
		for( File file : dir.listFiles()) {
			if (file.isDirectory()) {
				purge(file);
			}
			if (!file.delete()) throw new RuntimeException("Could not delete "+file.getAbsolutePath());
		}
	}
}
