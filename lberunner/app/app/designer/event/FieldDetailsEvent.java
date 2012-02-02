package app.designer.event;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.FieldDesignEntity;

public class FieldDetailsEvent extends SimpleFlowEvent {

	public static final FieldDetailsEvent INSTANCE = new FieldDetailsEvent();

	public FieldDetailsEvent() {
		super("FieldDetails", new Entity[]{
			FieldDesignEntity.INSTANCE,
		});
	}
}
