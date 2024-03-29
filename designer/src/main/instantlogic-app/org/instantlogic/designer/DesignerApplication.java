package org.instantlogic.designer;

public class DesignerApplication extends org.instantlogic.interaction.Application {

	public static final DesignerApplication INSTANCE = new DesignerApplication();
	
	protected DesignerApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> getCaseEntity() {
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.Flow getMainFlow() {
		return org.instantlogic.designer.flow.MainFlow.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEvent getStartEvent() {
		return org.instantlogic.designer.event.HomeEvent.INSTANCE;
	}

    private static final String[] THEME_NAMES = new String[]{"margin", "designer"};	
	@Override
	public String[] getThemeNames() {
		return THEME_NAMES;
	}
	
	@Override
	public String getName() {
		return "Designer";
	}
}
