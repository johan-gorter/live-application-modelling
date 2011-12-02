package app.designer.event;

import app.designer.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class FlowNodeDetailsEvent extends SimpleFlowEvent {

	public static final FlowNodeDetailsEvent INSTANCE = new FlowNodeDetailsEvent();

	public FlowNodeDetailsEvent() {
		super("FlowNodeDetails", new Entity[]{
			FlowNodeBaseEntity.INSTANCE,
		});
	}
}
