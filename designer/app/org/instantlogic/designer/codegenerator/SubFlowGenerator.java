package org.instantlogic.designer.codegenerator;


import java.io.File;

import org.instantlogic.fabric.util.Observations;

import app.designer.SubFlowDesign;

public class SubFlowGenerator extends AbstractGenerator {

	public String flowname;
	public String subFlowName;
	
	public SubFlowDesign subFlowDesign;
	private Observations observations;
	
	public SubFlowGenerator(SubFlowDesign subFlowDesign, String appname, String flowName) {
		this.subFlowDesign = subFlowDesign;
		this.rootPackageName = appname;
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
		subFlowDesign.getCase().startRecordingObservations();
		
		name = subFlowDesign.name.get();
		subFlowName = subFlowDesign.flow.get().name.get();
		AbstractGenerator.generateFile(AbstractGenerator.subFlowTemplate, this, "flow/"+flowname.toLowerCase(), name, "SubFlow", rootPackageName, applicationRoot, this.customization!=null);
		
		this.observations = subFlowDesign.getCase().stopRecordingObservations();
	}
	
	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), name, "SubFlow", rootPackageName, applicationRoot);
	}
}
