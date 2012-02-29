package org.instantlogic.designer.codegenerator;


import java.io.File;

import org.instantlogic.fabric.util.Observations;

public class PageGenerator extends AbstractGenerator {

	private String flowname;
	private ContentClassModel content;
	
	private PageDesign pageDesign;
	
	private Observations observations;
	
	public PageGenerator(PageDesign pageDesign, String appname, String flowname) {
		this.pageDesign = pageDesign;
		this.rootPackageName = appname;
		this.flowname = flowname;
	}

	public String getFlowname() {
		return flowname;
	}

	public ContentClassModel getContent() {
		return content;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) return;
		clearDeductionSchemes();
		pageDesign.getCase().startRecordingObservations();
		
		name = pageDesign.name.get();
		customization = pageDesign.customization.get();
		content = new ContentClassModel(pageDesign.getContent(), this);
		
		AbstractGenerator.generateFile(AbstractGenerator.pageTemplate, this, "flow/"+flowname.toLowerCase(), pageDesign.name.get(), "Page", rootPackageName, applicationRoot, this.customization!=null);
		
		this.observations = pageDesign.getInstanceAdministration().stopRecordingObservations();
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), pageDesign.name.get(), "Page", rootPackageName, applicationRoot);
	}
}
