package app.oldcarinsurance.event;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;


public class NextEvent extends SimpleFlowEvent {

	public static final NextEvent INSTANCE = new NextEvent();
	
	public NextEvent() {
		super("Next", new Entity[]{});
	}
	
}
