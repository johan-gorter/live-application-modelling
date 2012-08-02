package org.instantlogic.interaction.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class PlaceTemplate extends FlowNodeBase {
	
	public abstract FragmentTemplate getRootContainer();

	public FlowEventOccurrence submit(SubmitContext submitContext) {
		return getRootContainer().submit(submitContext);
	}

	public void change(ChangeContext changeContext) {
		getRootContainer().change(changeContext);
	}

	public Map<String, Object> render(final RenderContext renderContext) {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		getRootContainer().render(renderContext, result);
		if (result.size()!=1) throw new RuntimeException("Rendering resulted in more than one page root");
		return result.get(0);
	}
}
