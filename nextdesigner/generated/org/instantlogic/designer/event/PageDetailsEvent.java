package org.instantlogic.designer.event;

public class PageDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final PageDetailsEvent INSTANCE = new PageDetailsEvent();

	public PageDetailsEvent() {
		super("PageDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE,
		});
	}
}
