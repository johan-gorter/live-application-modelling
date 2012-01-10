package app.designer.event;

import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class EntityDetailsEvent extends SimpleFlowEvent {

	public static final EntityDetailsEvent INSTANCE = new EntityDetailsEvent();

	public EntityDetailsEvent() {
		super("EntityDetails", new Entity[]{
			EntityDesignEntity.INSTANCE,
		});
	}
}
