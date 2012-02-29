package app.designer.event;

import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class AttributeDetailsEvent extends SimpleFlowEvent {

	public static final AttributeDetailsEvent INSTANCE = new AttributeDetailsEvent();

	public AttributeDetailsEvent() {
		super("AttributeDetails", new Entity[]{
			AttributeDesignEntity.INSTANCE,
		});
	}
}
