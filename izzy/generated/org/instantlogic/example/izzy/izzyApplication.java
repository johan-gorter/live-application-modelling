package org.instantlogic.example.izzy;

public class IzzyApplication extends org.instantlogic.interaction.Application {

	public static final IzzyApplication INSTANCE = new IzzyApplication();
	
	protected IzzyApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.Project> getCaseEntity() {
		return org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.Flow getMainFlow() {
		return org.instantlogic.example.izzy.flow.MainFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "izzy";
	}
}
