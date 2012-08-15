package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;

public class PresenceMessage extends Message {

	private final String command;
	private final Object data;

	public PresenceMessage(String command, Object data) {
		this.command = command;
		this.data = data;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		presence.executeCommand(traveler, command, data);
	}

}
