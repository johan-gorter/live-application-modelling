package org.instantlogic.designer.event;

public class FieldDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final FieldDetailsEvent INSTANCE = new FieldDetailsEvent();

	public FieldDetailsEvent() {
		super("FieldDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE,
		});
	}
}
