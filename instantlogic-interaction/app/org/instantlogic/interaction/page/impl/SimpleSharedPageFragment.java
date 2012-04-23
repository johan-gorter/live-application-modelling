package org.instantlogic.interaction.page.impl;

import org.instantlogic.interaction.page.Fragment;
import org.instantlogic.interaction.page.PageElement;
import org.instantlogic.interaction.page.PlaceFragmentTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class SimpleSharedPageFragment extends PlaceFragmentTemplate {

	protected abstract PlaceFragmentTemplate getDelegate();
	
	@Override
	public String getWidgetName() {
		return getDelegate().getWidgetName();
	}

	@Override
	public String getName() {
		return getDelegate().getName();
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
