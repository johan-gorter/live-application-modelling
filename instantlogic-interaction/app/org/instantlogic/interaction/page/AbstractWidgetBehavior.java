package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class AbstractWidgetBehavior implements FragmentBehavior {

	@Override
	public void beforeRender(RenderContext context, Map<String, Object> result) {
	}

	@Override
	public void afterRender(RenderContext context, Map<String, Object> result) {
	}

	@Override
	public FlowEventOccurrence beforeSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id) {
		return result;
	}

	@Override
	public FlowEventOccurrence afterSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id) {
		return result;
	}
}
