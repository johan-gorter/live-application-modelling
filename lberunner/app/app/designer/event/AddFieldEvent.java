package app.designer.event;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

public class AddFieldEvent extends SimpleFlowEvent {

	public static final AddFieldEvent INSTANCE = new AddFieldEvent();

	public AddFieldEvent() {
		super("AddField", new Entity[]{
		});
	}
}
