package org.instantlogic.interaction.page;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;

import org.instantlogic.core.text.Text;
import org.instantlogic.interaction.flow.FlowEvent;

public abstract class Link extends PageFragment {

	@Override
	public String getElementType() {
		return "link";
	}
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public PageElement render(RenderContext context) {
		PageElement result = super.render(context);
		Text caption = getCaption();
		if (caption!=null) {
			result.display = caption.renderText(context);
			result.name = getEvent().getName();
		}
		return result;
	}

	public abstract Text getCaption();

	public abstract FlowEvent getEvent();

	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		String id = getName()+"@"+changeContext.nextId();
		
		if (id.equals(changeContext.getSubmit())) {
			return getEvent().createOccurrence(changeContext);
		}
		return null;
	}
	
}
