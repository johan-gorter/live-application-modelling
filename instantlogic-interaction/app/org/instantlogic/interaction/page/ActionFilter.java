package org.instantlogic.interaction.page;

import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class ActionFilter extends AbstractFragmentFilter {

	private final FlowEvent event;
	
	public ActionFilter(FlowEvent event) {
		this.event = event;
	}
	
	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext, String id, FragmentFilterChain chain) {
		if (changeContext.getSubmit()==id) {
			return this.event.createOccurrence(changeContext);
		}
		return super.submit(changeContext, id, chain);
	}
}
