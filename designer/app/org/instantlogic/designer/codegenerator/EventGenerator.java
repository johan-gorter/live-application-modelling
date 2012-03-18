package org.instantlogic.designer.codegenerator;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class EventGenerator extends AbstractGenerator {

	private EventDesign eventDesign;

	public final List<String> parameters = new ArrayList<String>();

	public EventGenerator(EventDesign eventDesign, String appname) {
		this.eventDesign = eventDesign;
		this.rootPackageName = appname;
		this.name = eventDesign.getName();
	}
	
	public List<String> getParameters() {
		return parameters;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) {
			return;
		}
		CaseAdministration caseAdministration = eventDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		this.isCustomized = eventDesign.getIsCustomized();
		
		parameters.clear();
		for (EntityDesign parameter: eventDesign.getParameters()) {
			parameters.add(parameter.getName());
		}
		AbstractGenerator.generateFile(AbstractGenerator.eventTemplate, this, "event", name, "Event", rootPackageName, applicationRoot, this.isCustomized);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("event", name, "Event", rootPackageName, applicationRoot);
	}
}
