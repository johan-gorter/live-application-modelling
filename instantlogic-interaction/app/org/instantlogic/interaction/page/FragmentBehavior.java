package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public interface FragmentBehavior {

	void beforeRender(RenderContext context, Map<String, Object> result);

	void afterRender(RenderContext context, Map<String, Object> result);

	FlowEventOccurrence beforeSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id);

	FlowEventOccurrence afterSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id);

}
