package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.PageClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class PlaceTemplateGenerator extends AbstractGenerator {

	
	private PlaceTemplateDesign placeTemplateDesign;
	
	public PlaceTemplateGenerator(PlaceTemplateDesign placeTemplateDesign) {
		this.placeTemplateDesign = placeTemplateDesign;
	}

	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return;

		CaseAdministration caseAdministration = placeTemplateDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		PageClassModel model = initModel();
		model.rootPackageName = context.rootPackageName;
		model.content = ContentGenerator.generate(placeTemplateDesign.getContent(), model);

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
		model.name = placeTemplateDesign.getName();
		model.id = placeTemplateDesign.getMetadata().getInstanceId();
		model.isCustomized = placeTemplateDesign.getIsCustomized()==Boolean.TRUE;
		model.flowname = placeTemplateDesign.getOwner().getName();
		return model;
	}
}
