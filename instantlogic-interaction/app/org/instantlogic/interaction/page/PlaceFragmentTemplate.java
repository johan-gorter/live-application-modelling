package org.instantlogic.interaction.page;

import java.util.HashMap;

import org.instantlogic.fabric.model.Concept;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class PlaceFragmentTemplate extends Concept {

	public String getWidgetName() {
		return null;
	}

	public Fragment render(RenderContext context) {
		Fragment result = new Fragment();
		result.widget = getWidgetName();
		result.id = context.nextId();
		if (result.widget!=null) {
			result.widgetData = new HashMap<String, Object>();
		}
		return result;
	}
	
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		changeContext.nextId();
		return null;
	}

	public PlaceFragmentTemplate withPresentation(String presentation) {
// TODO: rethink		setPresentation(presentation);
		return this;
	}

}
