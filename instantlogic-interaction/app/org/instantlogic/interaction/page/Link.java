package org.instantlogic.interaction.page;

import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class Link extends PlaceFragmentTemplate {

	@Override
	public String getWidgetName() {
		return "link";
	}
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public Fragment render(RenderContext context) {
		Fragment result = super.render(context);
		Text caption = getCaption();
		if (caption!=null) {
			result.widgetData.put("text", caption.renderText(context));
			result.widgetData.put("event", getEvent().getName());
		}
		return result;
	}

	public abstract Text getCaption();

	public abstract FlowEvent getEvent();

	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		String id = getName()+"@"+changeContext.nextId();
		
		if (id.equals(changeContext.getSubmit())) {
			return getEvent().createOccurrence(changeContext);
		}
		return null;
	}
	
}
