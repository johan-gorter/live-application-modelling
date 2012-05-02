package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SharedPageFragmentGenerator extends AbstractGenerator {

	private SharedFragmentTemplateDefinitionDesign definition;

	public SharedPageFragmentGenerator(SharedFragmentTemplateDefinitionDesign pageFragmentHolderDesign) {
		this.definition = pageFragmentHolderDesign;
	}


	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) { return; }

		CaseAdministration caseAdministration = definition.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();

		SharedPageFragmentClassModel model = initModel(context);
		model.rootPackageName = context.rootPackageName;
		model.content = ContentGenerator.generate(definition.getFragment(), model);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedSharedPageFragments.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		SharedPageFragmentClassModel model = initModel(context);
		context.deletedSharedPageFragments.add(model);
	}

	private SharedPageFragmentClassModel initModel(GeneratedClassModels context) {
		SharedPageFragmentClassModel model = new SharedPageFragmentClassModel();
		model.rootPackageName = context.rootPackageName;
		model.name = definition.getName();
		model.isCustomized = definition.getIsCustomized()==Boolean.TRUE;
		return model;
	}
}
