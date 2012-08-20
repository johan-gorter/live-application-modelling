package org.instantlogic.engine.presence.flow.main;

public class TravelerSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final TravelerSubFlow INSTANCE = new TravelerSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.engine.presence.flow.TravelerFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Traveler";
	}
}
