package org.instantlogic.interaction.page;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class SharedFragmentTemplate extends FragmentTemplate {

	protected abstract FragmentTemplate getDelegate();
	
	@Override
	public String getWidgetName() {
		return getDelegate().getWidgetName();
	}

	@Override
	public Fragment render(RenderContext context) {
		return getDelegate().render(context);
	}
	
	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		return getDelegate().submit(changeContext);
	}
}
