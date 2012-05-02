package org.instantlogic.interaction.flow;

import java.util.HashMap;

import org.instantlogic.interaction.page.CompositeFragmentTemplate;
import org.instantlogic.interaction.page.Fragment;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class Place extends FlowNodeBase {
	
	public abstract CompositeFragmentTemplate getRootContainer();

	public FlowEventOccurrence submit(ChangeContext changeContext) {
		return getRootContainer().submit(changeContext);
	}

	public Fragment render(final RenderContext renderContext) {
		Fragment result = new Fragment();
		result.widget = "Place";
		HashMap<String, Object> widgetData = new HashMap<String, Object>();
		result.widgetData = widgetData;
		widgetData.put("caseVersion", renderContext.getCaseInstance().getMetadata().getCaseAdministration().getVersion());
		widgetData.put("name", getName()); 
		widgetData.put("mainContent", getRootContainer().render(renderContext));
		return result;
	}
}
