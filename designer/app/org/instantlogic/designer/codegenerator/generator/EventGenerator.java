package org.instantlogic.designer.codegenerator.generator;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.javacode.AbstractJavacodeGenerator;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class EventGenerator extends AbstractGenerator {

	private EventDesign eventDesign;

	public EventGenerator(EventDesign eventDesign) {
		this.eventDesign = eventDesign;
	}
	
	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) {
			return;
		}

		CaseAdministration caseAdministration = eventDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		EventClassModel model = initModel();

		for (EntityDesign parameter: eventDesign.getParameters()) {
			model.parameters.add(parameter.getName());
		}
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedEvents.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		EventClassModel model = initModel();
		context.deletedEvents.add(model);
	}

	private EventClassModel initModel() {
		EventClassModel model = new EventClassModel();
		model.name = eventDesign.getName();
		model.isCustomized = eventDesign.getIsCustomized()==Boolean.TRUE;
		return model;
	}
}
