package lbe.engine.codegenerator;

import java.io.File;

import app.designer.EntityDesign;
import app.designer.PageFragmentHolderDesign;

public class SharedPageFragmentGenerator extends AbstractGenerator {

	private ContentClassModel content;
	private PageFragmentHolderDesign pageFragmentHolderDesign;

	public SharedPageFragmentGenerator(PageFragmentHolderDesign pageFragmentHolderDesign, String appname) {
		this.pageFragmentHolderDesign = pageFragmentHolderDesign;
		this.rootPackageName = appname;
		this.name = pageFragmentHolderDesign.getName();
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) {
			return;
		}
		pageFragmentHolderDesign.getCase().startRecordingObservations();

		clearDeductionSchemes();
		this.customization = pageFragmentHolderDesign.getCustomization();
		this.content = new ContentClassModel(pageFragmentHolderDesign.getPageFragment(), this);
		AbstractGenerator.generateFile(AbstractGenerator.pageFragmentTemplate, this, "sharedpagefragment", name, "PageFragment", rootPackageName, applicationRoot);
		
		this.observations = pageFragmentHolderDesign.getCase().stopRecordingObservations();
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("sharedpagefragment", name, "Event", rootPackageName, applicationRoot);
	}

	public ContentClassModel getContent() {
		return content;
	}

}
