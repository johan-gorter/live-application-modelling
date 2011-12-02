package app.designer.event;

import app.designer.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class FieldDetailsEvent extends SimpleFlowEvent {

	public static final FieldDetailsEvent INSTANCE = new FieldDetailsEvent();

	public FieldDetailsEvent() {
		super("FieldDetails", new Entity[]{
			FieldEntity.INSTANCE,
		});
	}
}
