package app.carinsurance.event;

import app.carinsurance.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class NextEvent extends SimpleFlowEvent {

	public static final NextEvent INSTANCE = new NextEvent();

	public NextEvent() {
		super("Next", new Entity[]{
		});
	}
}
