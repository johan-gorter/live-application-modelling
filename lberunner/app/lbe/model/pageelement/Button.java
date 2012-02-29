package lbe.model.pageelement;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.model.FlowEvent;

public abstract class Button extends Link {

	@Override
	public String getElementType() {
		return "button";
	}

}
