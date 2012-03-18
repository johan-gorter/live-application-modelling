package org.instantlogic.designer.codegenerator;


import java.io.File;

import org.instantlogic.designer.PageDesign;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class PageGenerator extends AbstractGenerator {

	private String flowname;
	private ContentGenerator content;
	
	private PageDesign pageDesign;
	
	public PageGenerator(PageDesign pageDesign, String appname, String flowname) {
		this.pageDesign = pageDesign;
		this.rootPackageName = appname;
		this.flowname = flowname;
	}

	public String getFlowname() {
		return flowname;
	}

	public ContentGenerator getContent() {
		return content;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) return;
		clearDeductionSchemes();
		CaseAdministration caseAdministration = pageDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		name = pageDesign.getName();
		isCustomized = pageDesign.getIsCustomized();
		content = new ContentGenerator(pageDesign.getContent(), this);
		
		AbstractGenerator.generateFile(AbstractGenerator.pageTemplate, this, "flow/"+flowname.toLowerCase(), pageDesign.getName(), "Page", rootPackageName, applicationRoot, this.isCustomized);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), pageDesign.getName(), "Page", rootPackageName, applicationRoot);
	}
}
