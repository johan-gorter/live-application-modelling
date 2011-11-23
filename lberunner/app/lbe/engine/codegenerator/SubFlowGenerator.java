package lbe.engine.codegenerator;

import java.io.File;

import lbe.instance.Observations;

import app.designer.data.instance.SubFlowInstance;

public class SubFlowGenerator extends AbstractGenerator {

	public String flowname;
	public String subFlowName;
	
	public SubFlowInstance subFlowInstance;
	private Observations observations;
	
	public SubFlowGenerator(SubFlowInstance subFlowInstance, String appname, String flowName) {
		this.subFlowInstance = subFlowInstance;
		this.appname = appname;
		this.flowname = flowName;
	}

	public String getFlowname() {
		return flowname;
	}

	public String getSubFlowName() {
		return subFlowName;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) return;
		subFlowInstance.getCase().startRecordingObservations();
		
		name = subFlowInstance.name.get();
		subFlowName = subFlowInstance.flow.get().name.get();
		AbstractGenerator.generateFile(AbstractGenerator.subFlowTemplate, this, "flow/"+flowname.toLowerCase(), name, "SubFlow", appname, applicationRoot);
		
		this.observations = subFlowInstance.getCase().stopRecordingObservations();
	}
	
	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), name, "SubFlow", appname, applicationRoot);
	}
}
