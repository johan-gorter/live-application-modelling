package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;

public class LeaveMessage extends Message {

	public LeaveMessage() {
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		presence.removeFromActiveTravelers(traveler);
	}
}
