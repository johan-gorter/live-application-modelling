package org.instantlogic.designer.event;

public class AddFieldEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AddFieldEvent INSTANCE = new AddFieldEvent();

	public AddFieldEvent() {
		super("AddField", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
