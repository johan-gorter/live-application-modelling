package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class AbstractFragmentFilter implements FragmentFilter {

	@Override
	public Map<String, Object> render(RenderContext context, String id, FragmentFilterChain chain) {
		return chain.render(context);
	}
	
	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext, String id, FragmentFilterChain chain) {
		return chain.submit(changeContext);
	}
}
