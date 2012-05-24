package org.instantlogic.designer.event;

public class AttributeDetailsInEntityEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AttributeDetailsInEntityEvent INSTANCE = new AttributeDetailsInEntityEvent();

	public AttributeDetailsInEntityEvent() {
		super("AttributeDetailsInEntity", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
		});
	}
}
