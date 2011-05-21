package lbe.model;

import java.util.ArrayList;
import java.util.List;

import lbe.page.PageElement;
import lbe.page.RenderContext;

public abstract class ContainerModel extends PageElementModelBase {

	@Override
	public String getName() {
		return null;
	}
	
	public String getDisplay(RenderContext context) {
		return null;
	}
	
	public String getElementType() {
		return "container";
	}

	@Override
	public PageElement render(RenderContext context) {
		PageElement result = super.render(context);
		result.display = getDisplay(context);
		result.name = getName();
		result.content = renderChildren(context, getChildren());
		return result;
	}

	public static PageElement[] renderChildren(RenderContext context, PageElementModelBase[] childModels) {
		List<PageElement> result = new ArrayList<PageElement>(childModels.length);
		for (PageElementModelBase child: childModels) {
			PageElement element = child.render(context);
			if (element!=null) {
				result.add(element);
			}
		}
		return result.toArray(new PageElement[result.size()]);
	}

	public abstract PageElementModelBase[] getChildren();

}
