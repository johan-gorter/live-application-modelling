package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class SharedFragmentTemplate extends FragmentTemplate {

	public SharedFragmentTemplate(String id) {
		super(id, null);
	}

	protected abstract FragmentTemplate getDelegate();
	
	@Override
	public String getFragmentTypeName() {
		return getDelegate().getFragmentTypeName();
	}
	
	@Override
	public Map<String, Object> render(RenderContext context) {
		return getDelegate().render(context);
	}
	
	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		return getDelegate().submit(changeContext);
	}
}
