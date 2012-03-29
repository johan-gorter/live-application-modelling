package org.instantlogic.designer.event;

public class PageFragmentDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final PageFragmentDetailsEvent INSTANCE = new PageFragmentDetailsEvent();

	public PageFragmentDetailsEvent() {
		super("PageFragmentDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE,
		});
	}
}
