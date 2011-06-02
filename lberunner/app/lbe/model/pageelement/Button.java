package lbe.model.pageelement;

import lbe.engine.PageElement;
import lbe.engine.RenderContext;

public abstract class Button extends PageElementBase {

	@Override
	public String getElementType() {
		return "button";
	}

	@Override
	public PageElement render(RenderContext context) {
		PageElement result = super.render(context);
		result.display = getDisplay(context);
		return result;
	}

	public abstract String getDisplay(RenderContext context);
	
}
