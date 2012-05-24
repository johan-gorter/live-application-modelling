package org.instantlogic.designer.event;

public class ExploreInstanceEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final ExploreInstanceEvent INSTANCE = new ExploreInstanceEvent();

	public ExploreInstanceEvent() {
		super("ExploreInstance", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
