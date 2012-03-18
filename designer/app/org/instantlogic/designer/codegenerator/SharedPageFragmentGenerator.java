package org.instantlogic.designer.codegenerator;


import java.io.File;

import org.instantlogic.designer.PageFragmentHolderDesign;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SharedPageFragmentGenerator extends AbstractGenerator {

	private ContentGenerator content;
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
		CaseAdministration caseAdministration = pageFragmentHolderDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();

		clearDeductionSchemes();
		this.isCustomized = pageFragmentHolderDesign.getIsCustomized();
		this.content = new ContentGenerator(pageFragmentHolderDesign.getPageFragment(), this);
		AbstractGenerator.generateFile(AbstractGenerator.pageFragmentTemplate, this, "sharedpagefragment", name, "PageFragment", rootPackageName, applicationRoot, this.isCustomized);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("sharedpagefragment", name, "Event", rootPackageName, applicationRoot);
	}

	public ContentGenerator getContent() {
		return content;
	}

}
