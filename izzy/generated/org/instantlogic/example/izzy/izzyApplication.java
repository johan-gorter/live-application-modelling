package org.instantlogic.example.izzy;

public class izzyApplication extends org.instantlogic.interaction.Application {

	public static final izzyApplication INSTANCE = new izzyApplication();
	
	protected izzyApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.project> getCaseEntity() {
		return org.instantlogic.example.izzy.entity.projectEntity.INSTANCE;
	}

	
	@Override
	public String getName() {
		return "izzy";
	}
}
