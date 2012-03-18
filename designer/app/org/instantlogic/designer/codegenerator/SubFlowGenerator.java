package org.instantlogic.designer.codegenerator;


import java.io.File;

import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SubFlowGenerator extends AbstractGenerator {

	public String flowname;
	public String subFlowName;
	
	public SubFlowDesign subFlowDesign;
	
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
		CaseAdministration caseAdministration = subFlowDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		name = subFlowDesign.getName();
		subFlowName = subFlowDesign.getFlow().getName();
		AbstractGenerator.generateFile(AbstractGenerator.subFlowTemplate, this, "flow/"+flowname.toLowerCase(), name, "SubFlow", rootPackageName, applicationRoot, this.isCustomized);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
	}
	
	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), name, "SubFlow", rootPackageName, applicationRoot);
	}
}
