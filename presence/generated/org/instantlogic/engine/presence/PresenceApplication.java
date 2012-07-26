package org.instantlogic.engine.presence;

public class PresenceApplication extends org.instantlogic.interaction.Application {

	public static final PresenceApplication INSTANCE = new PresenceApplication();
	
	protected PresenceApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.engine.presence.Presence> getCaseEntity() {
		return org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.Flow getMainFlow() {
		return org.instantlogic.engine.presence.flow.MainFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Presence";
	}
}
