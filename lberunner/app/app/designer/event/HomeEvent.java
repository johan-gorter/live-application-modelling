package app.designer.event;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

public class HomeEvent extends SimpleFlowEvent {

	public static final HomeEvent INSTANCE = new HomeEvent();

	public HomeEvent() {
		super("Home", new Entity[]{
		});
	}
}
