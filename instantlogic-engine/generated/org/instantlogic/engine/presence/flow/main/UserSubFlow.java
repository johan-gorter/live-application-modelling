package org.instantlogic.engine.presence.flow.main;

public class UserSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final UserSubFlow INSTANCE = new UserSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.engine.presence.flow.UserFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "User";
	}
}
