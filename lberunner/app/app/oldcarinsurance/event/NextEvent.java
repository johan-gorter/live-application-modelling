package app.oldcarinsurance.event;

import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class NextEvent extends SimpleFlowEvent {

	public static final NextEvent INSTANCE = new NextEvent();
	
	public NextEvent() {
		super("Next", new Entity[]{});
	}
	
}
