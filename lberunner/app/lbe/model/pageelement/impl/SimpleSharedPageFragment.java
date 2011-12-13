package lbe.model.pageelement.impl;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.model.pageelement.PageFragment;

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
