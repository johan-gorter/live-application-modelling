package lbe.model.pageelement;

import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.model.Model;

public abstract class Text extends PageElementBase {

	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public String getElementType() {
		return "text";
	}
	
	@Override
	public PageElement render(RenderContext context) {
		PageElement result = super.render(context);
		result.display = renderText(context);
		return result;
		
	}
	
	public abstract String renderText(RenderContext context);

}
