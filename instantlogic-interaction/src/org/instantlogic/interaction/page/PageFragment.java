package org.instantlogic.interaction.page;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;

import org.instantlogic.core.model.Concept;

public abstract class PageFragment extends Concept {

	// TODO: String -> List of tags
	private String presentation;
	
	public abstract String getElementType();

	public PageElement render(RenderContext context) {
		PageElement result = new PageElement();
		result.elementType = getElementType();
		result.name = getName();
		result.id = result.name+"@"+context.nextId();
		if (presentation!=null) {
			result.presentationStyles=presentation.split(" ");
		}
		return result;
		
	}

	public FlowEventOccurrence submit(ChangeContext changeContext) {
		changeContext.nextId();
		return null;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public PageFragment withPresentation(String presentation) {
		setPresentation(presentation);
		return this;
	}

}
