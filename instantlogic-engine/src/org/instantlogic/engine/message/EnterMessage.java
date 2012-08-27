package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;

public class EnterMessage extends Message {

	private final String newLocation;
	
	public EnterMessage(String newLocation) {
		if (newLocation==null || newLocation.length()==0) throw new IllegalArgumentException("newLocation may not be null");
		this.newLocation = newLocation;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		presence.enter(traveler, newLocation); // Update presence
	}
}
