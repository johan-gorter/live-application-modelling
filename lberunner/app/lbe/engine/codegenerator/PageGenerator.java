package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lbe.instance.Observations;
import app.designer.ButtonDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.ConstantTextDesign;
import app.designer.DeductionSchemeDesign;
import app.designer.FieldDesign;
import app.designer.HeaderDesign;
import app.designer.LinkDesign;
import app.designer.PageCompositionDesign;
import app.designer.PageDesign;
import app.designer.PageFragmentDesign;
import app.designer.SelectDesign;
import app.designer.TextDesign;

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
		
		AbstractGenerator.generateFile(AbstractGenerator.pageTemplate, this, "flow/"+flowname.toLowerCase(), pageDesign.name.get(), "Page", rootPackageName, applicationRoot);
		
		this.observations = pageDesign.getCase().stopRecordingObservations();
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), pageDesign.name.get(), "Page", rootPackageName, applicationRoot);
	}
}
