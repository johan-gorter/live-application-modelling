package app.designer.event;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

public class ExploreInstanceEvent extends SimpleFlowEvent {

	public static final ExploreInstanceEvent INSTANCE = new custom.designer.caseexplorer.ExploreInstanceEventCustomization();

	public ExploreInstanceEvent() {
		super("ExploreInstance", new Entity[]{
		});
	}
}
