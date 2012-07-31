package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;

public class EnterMessage extends Message {

	private final String newLocation;
	
	public EnterMessage(String newLocation) {
		this.newLocation = newLocation;
	}

	@Override
	public void execute(Traveler traveler, Presence presence, Instance theCase) {
		presence.enter(traveler, newLocation);
		
	}

}
