package com.instantlogic.mini;

public class MiniApplication extends org.instantlogic.interaction.Application {

	public static final MiniApplication INSTANCE = new MiniApplication();
	
	protected MiniApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<com.instantlogic.mini.MiniThing> getCaseEntity() {
		return com.instantlogic.mini.entity.MiniThingEntity.INSTANCE;
	}

	
	@Override
	public String getName() {
		return "Mini";
	}
}
