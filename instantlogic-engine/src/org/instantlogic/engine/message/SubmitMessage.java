package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.SubmitContext;

public class SubmitMessage extends Message {

	private final String placeElementId;
	
	public SubmitMessage(String placeElementId) {
		this.placeElementId = placeElementId;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		SubmitContext submitContext = SubmitContext.create(application.getMainFlow(), traveler.getCurrentPlace().getUrl(), theCase, presence.getCaseName(), placeElementId, traveler.getTravelerInfo());
		FlowContext flowContext = submitContext.getFlowContext();
		PlaceTemplate placeTemplate = (PlaceTemplate)flowContext.getFlowStack().getCurrentNode();
		FlowEventOccurrence eventOccurrence = placeTemplate.submit(submitContext);
		while (eventOccurrence!=null) {
			eventOccurrence = flowContext.step(eventOccurrence);
		}
		traveler.getUser().getPresence().enter(traveler, flowContext.getFlowStack().toPath());
	}
}
