package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.EventInstance;

public class EventGenerator extends AbstractGenerator {

	private EventInstance eventInstance;

	public final List<String> parameters = new ArrayList<String>();

	public EventGenerator(EventInstance eventInstance, String appname) {
		this.eventInstance = eventInstance;
		this.appname = appname;
		this.name = eventInstance.getName();
	}
	
	public List<String> getParameters() {
		return parameters;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) {
			return;
		}
		eventInstance.getCase().startRecordingObservations();
		
		this.customization = eventInstance.customization.get();
		
		parameters.clear();
		for (EntityInstance parameter: eventInstance.parameters.get()) {
			parameters.add(parameter.name.get());
		}
		AbstractGenerator.generateFile(AbstractGenerator.eventTemplate, this, "event", name, "Event", appname, applicationRoot);
		
		this.observations = eventInstance.getCase().stopRecordingObservations();
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("event", name.toLowerCase(), "Event", appname, applicationRoot);
	}
}
