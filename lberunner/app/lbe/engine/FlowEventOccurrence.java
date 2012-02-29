package lbe.engine;

import lbe.instance.Instance;
import lbe.model.FlowEvent;

public class FlowEventOccurrence {

	private FlowEvent event;
	
	private Instance[] parameters;
	
	public FlowEventOccurrence(FlowEvent event, Instance... parameters) {
		this.event = event;
		this.parameters = parameters;
	}

	public FlowEvent getEvent() {
		return event;
	}

	public Instance[] getParameters() {
		return parameters;
	}
}
