package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import app.designer.EntityDesign;
import app.designer.EventDesign;

public class EventGenerator extends AbstractGenerator {

	private EventDesign eventDesign;

	public final List<String> parameters = new ArrayList<String>();

	public EventGenerator(EventDesign eventDesign, String appname) {
		this.eventDesign = eventDesign;
		this.appname = appname;
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
		eventDesign.getCase().startRecordingObservations();
		
		this.customization = eventDesign.customization.get();
		
		parameters.clear();
		for (EntityDesign parameter: eventDesign.parameters.get()) {
			parameters.add(parameter.name.get());
		}
		AbstractGenerator.generateFile(AbstractGenerator.eventTemplate, this, "event", name, "Event", appname, applicationRoot);
		
		this.observations = eventDesign.getCase().stopRecordingObservations();
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("event", name.toLowerCase(), "Event", appname, applicationRoot);
	}
}
