package app.designer.event;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.AttributeDesignEntity;
import app.designer.entity.EntityDesignEntity;

public class AttributeDetailsInEntityEvent extends SimpleFlowEvent {

	public static final AttributeDetailsInEntityEvent INSTANCE = new AttributeDetailsInEntityEvent();

	public AttributeDetailsInEntityEvent() {
		super("AttributeDetailsInEntity", new Entity[]{
			EntityDesignEntity.INSTANCE,
			AttributeDesignEntity.INSTANCE,
		});
	}
}
