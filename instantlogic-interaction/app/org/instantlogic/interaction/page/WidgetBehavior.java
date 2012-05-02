package org.instantlogic.interaction.page;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public interface WidgetBehavior {

	void beforeRender(RenderContext context, Fragment result);

	void afterRender(RenderContext context, Fragment result);

	FlowEventOccurrence beforeSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id);

	FlowEventOccurrence afterSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id);

}
