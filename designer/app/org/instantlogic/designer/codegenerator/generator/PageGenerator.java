package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.PageDesign;
import org.instantlogic.designer.codegenerator.classmodel.PageClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class PageGenerator extends AbstractGenerator {

	
	private PageDesign pageDesign;
	
	public PageGenerator(PageDesign pageDesign) {
		this.pageDesign = pageDesign;
	}

	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return;

		CaseAdministration caseAdministration = pageDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		PageClassModel model = initModel();
		model.rootPackageName = context.rootPackageName;
		model.content = ContentGenerator.generate(pageDesign.getContent(), model);

		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedPages.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		PageClassModel model = initModel();
		context.deletedPages.add(model);
	}

	private PageClassModel initModel() {
		PageClassModel model = new PageClassModel();
		model.name = pageDesign.getName();
		model.isCustomized = pageDesign.getIsCustomized()==Boolean.TRUE;
		model.flowname = pageDesign.getOwner().getName();
		return model;
	}
}
