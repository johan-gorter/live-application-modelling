package lbe.model.pageelement;

import lbe.engine.ChangeContext;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.model.Model;

public abstract class PageElementBase extends Model {

	public abstract String getElementType();

	public PageElement render(RenderContext context) {
		PageElement result = new PageElement();
		result.elementType = getElementType();
		result.name = getName();
		result.id = result.name+"@"+context.nextId();
		return result;
		
	}

	public String submit(ChangeContext changeContext) {
		changeContext.nextId();
		return null;
	}

}
