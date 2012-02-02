package app.designer.event;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.EntityDesignEntity;

public class EntityDetailsEvent extends SimpleFlowEvent {

	public static final EntityDetailsEvent INSTANCE = new EntityDetailsEvent();

	public EntityDetailsEvent() {
		super("EntityDetails", new Entity[]{
			EntityDesignEntity.INSTANCE,
		});
	}
}
