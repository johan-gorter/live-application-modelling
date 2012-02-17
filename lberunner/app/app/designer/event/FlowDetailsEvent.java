package app.designer.event;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.FlowDesignEntity;

public class FlowDetailsEvent extends SimpleFlowEvent {

	public static final FlowDetailsEvent INSTANCE = new FlowDetailsEvent();

	public FlowDetailsEvent() {
		super("FlowDetails", new Entity[]{
			FlowDesignEntity.INSTANCE,
		});
	}
}
