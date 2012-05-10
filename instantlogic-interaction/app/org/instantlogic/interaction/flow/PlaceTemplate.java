package org.instantlogic.interaction.flow;

import java.util.Map;

import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class PlaceTemplate extends FlowNodeBase {
	
	public abstract FragmentTemplate getRootContainer();

	public FlowEventOccurrence submit(ChangeContext changeContext) {
		return getRootContainer().submit(changeContext);
	}

	public Map<String, Object> render(final RenderContext renderContext) {
		return getRootContainer().render(renderContext);
	}
}
