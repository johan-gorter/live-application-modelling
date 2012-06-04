package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;


public abstract class SharedTemplate extends AbstractTemplate {

	private final AbstractTemplate delegate;
	
	public SharedTemplate(AbstractTemplate delegate) {
		this.delegate = delegate;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		delegate.render(context, appendTo);
	}
	
	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		return delegate.submit(changeContext);
	}
}
