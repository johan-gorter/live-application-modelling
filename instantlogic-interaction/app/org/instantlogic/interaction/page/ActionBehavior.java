package org.instantlogic.interaction.page;

import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class ActionBehavior extends AbstractWidgetBehavior {

	private final FlowEvent event;
	
	public ActionBehavior(FlowEvent event) {
		this.event = event;
	}

	@Override
	public FlowEventOccurrence afterSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id) {
		if (changeContext.getSubmit()==id) {
			return this.event.createOccurrence(changeContext);
		}
		return super.afterSubmit(changeContext, result, id);
	}
}
