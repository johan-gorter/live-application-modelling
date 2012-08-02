package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;


public abstract class SharedElement extends Element {

	private final Element delegate;
	
	public SharedElement(Element delegate) {
		this.delegate = delegate;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		delegate.render(context, appendTo);
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		return delegate.submit(submitContext);
	}
}
