package app.designer.event;

import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class FlowDetailsEvent extends SimpleFlowEvent {

	public static final FlowDetailsEvent INSTANCE = new FlowDetailsEvent();

	public FlowDetailsEvent() {
		super("FlowDetails", new Entity[]{
			FlowDesignEntity.INSTANCE,
		});
	}
}
