package org.instantlogic.interaction.page.impl;

import org.instantlogic.interaction.page.PageElement;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class SimpleSharedPageFragment extends PageFragment {

	protected abstract PageFragment getDelegate();
	
	@Override
	public String getElementType() {
		return getDelegate().getElementType();
	}

	@Override
	public String getName() {
		return getDelegate().getName();
	}
	
	@Override
	public String getPresentation() {
		return getDelegate().getPresentation();
	}
	
	@Override
	public void setPresentation(String presentation) {
		throw new RuntimeException("This would modify the shared pageFragment");
	}
	
	@Override
	public PageElement render(RenderContext context) {
		return getDelegate().render(context);
	}
	
	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		return getDelegate().submit(changeContext);
	}
}
