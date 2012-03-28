package org.instantlogic.designer.codegenerator.generator;


import java.io.File;

import org.instantlogic.designer.PageFragmentHolderDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.designer.codegenerator.javacode.AbstractJavacodeGenerator;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SharedPageFragmentGenerator extends AbstractGenerator {

	private PageFragmentHolderDesign pageFragmentHolderDesign;

	public SharedPageFragmentGenerator(PageFragmentHolderDesign pageFragmentHolderDesign) {
		this.pageFragmentHolderDesign = pageFragmentHolderDesign;
	}


	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) { return; }

		CaseAdministration caseAdministration = pageFragmentHolderDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();

		SharedPageFragmentClassModel model = initModel(context);
		model.content = ContentGenerator.generate(pageFragmentHolderDesign.getPageFragment(), model);
		
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
		model.name = pageFragmentHolderDesign.getName();
		model.isCustomized = pageFragmentHolderDesign.getIsCustomized();
		return model;
	}
}
