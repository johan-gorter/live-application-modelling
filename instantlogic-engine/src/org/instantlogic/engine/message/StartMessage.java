package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(StartMessage.class);
	
	public StartMessage() {
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		logger.info("Traveler {}-{} starting", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
		FlowContext flowContext = FlowContext.create(application.getMainFlow(), null, theCase, presence.getCaseName(), traveler.getTravelerInfo());
		FlowEventOccurrence eventOccurrence = new FlowEventOccurrence(application.getStartEvent());
		while (eventOccurrence!=null) {
			eventOccurrence = flowContext.step(eventOccurrence);
		}
		traveler.getPresence().enter(traveler, flowContext.getFlowStack().toPath());
	}
}
