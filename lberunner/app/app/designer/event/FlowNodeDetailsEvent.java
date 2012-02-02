package app.designer.event;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.FlowNodeBaseDesignEntity;

public class FlowNodeDetailsEvent extends SimpleFlowEvent {

	public static final FlowNodeDetailsEvent INSTANCE = new FlowNodeDetailsEvent();

	public FlowNodeDetailsEvent() {
		super("FlowNodeDetails", new Entity[]{
			FlowNodeBaseDesignEntity.INSTANCE,
		});
	}
}
