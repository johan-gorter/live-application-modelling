package org.instantlogic.engine;

import java.util.List;

import org.instantlogic.engine.manager.Update;
import org.instantlogic.interaction.util.TravelerInfo;

public interface Client {

	TravelerInfo getTraveler();
	
	void sendUpdates(List<Update> messages);

}
