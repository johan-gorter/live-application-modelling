package app.designer.event;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.AttributeDesignEntity;

public class AttributeDetailsEvent extends SimpleFlowEvent {

	public static final AttributeDetailsEvent INSTANCE = new AttributeDetailsEvent();

	public AttributeDetailsEvent() {
		super("AttributeDetails", new Entity[]{
			AttributeDesignEntity.INSTANCE,
		});
	}
}
