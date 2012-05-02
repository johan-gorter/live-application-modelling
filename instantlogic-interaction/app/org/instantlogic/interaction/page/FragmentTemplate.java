package org.instantlogic.interaction.page;

import java.util.HashMap;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class FragmentTemplate {

	public abstract String getId();
	
	public String getWidgetName() {
		return null;
	}
	
	public abstract Fragment render(RenderContext context);

	protected Fragment beginRender(RenderContext context) {
		Fragment result = new Fragment();
		result.widget = getWidgetName();
		result.id = context.enterScope(this);
		if (result.widget!=null) {
			result.widgetData = new HashMap<String, Object>();
		}
		return result;
	}
	
	protected void endRender(RenderContext context) {
		context.exitScope();
	}
	
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		String id = changeContext.enterScope(this);
		FlowEventOccurrence result = handleSubmit(changeContext, id);
		changeContext.exitScope();
		return result;
	}

	protected FlowEventOccurrence handleSubmit(ChangeContext changeContext, String id) {
		return null;
	}
}
