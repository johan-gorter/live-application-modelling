package lbe.model;

import lbe.page.ChangeContext;
import lbe.page.PageElement;
import lbe.page.RenderContext;

public abstract class PageElementBase extends Model {

	public abstract String getElementType();

	public PageElement render(RenderContext context) {
		PageElement result = new PageElement();
		result.elementType = getElementType();
		result.name = getName();
		result.id = result.name+"@"+context.nextId();
		return result;
		
	}

	public void changeValue(ChangeContext changeContext) {
		changeContext.nextId();
	}

}
