package lbe.model;

import lbe.page.PageElement;
import lbe.page.RenderContext;

public abstract class PageElementModelBase extends ModelBase {

	public abstract String getElementType();

	public PageElement render(RenderContext context) {
		PageElement result = new PageElement();
		result.elementType = getElementType();
		result.name = getName();
		return result;
		
	}

}
