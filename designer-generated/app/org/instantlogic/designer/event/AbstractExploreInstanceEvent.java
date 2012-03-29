package org.instantlogic.designer.event;

public abstract class AbstractExploreInstanceEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final ExploreInstanceEvent INSTANCE = new ExploreInstanceEvent();

	public AbstractExploreInstanceEvent() {
		super("ExploreInstance", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
