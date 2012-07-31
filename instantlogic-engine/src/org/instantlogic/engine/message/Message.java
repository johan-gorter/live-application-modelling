package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;

public abstract class Message {

	public abstract void execute(Traveler traveler, Presence presence, Instance theCase);

	
}
