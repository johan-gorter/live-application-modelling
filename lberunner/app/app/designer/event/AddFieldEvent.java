package app.designer.event;

import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class AddFieldEvent extends SimpleFlowEvent {

	public static final AddFieldEvent INSTANCE = new AddFieldEvent();

	public AddFieldEvent() {
		super("AddField", new Entity[]{
		});
	}
}
