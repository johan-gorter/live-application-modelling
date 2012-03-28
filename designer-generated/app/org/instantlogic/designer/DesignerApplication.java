package org.instantlogic.designer;

public class DesignerApplication extends org.instantlogic.interaction.Application {

	public static final DesignerApplication INSTANCE = new DesignerApplication();
	
	protected DesignerApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> getCaseEntity() {
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}
	
	private static final org.instantlogic.interaction.flow.Flow[] exposedFlows = new org.instantlogic.interaction.flow.Flow[] {
		MainFlow.INSTANCE,
	};

	@Override
	public org.instantlogic.interaction.flow.Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	@Override
	public String getName() {
		return "Designer";
	}
}
