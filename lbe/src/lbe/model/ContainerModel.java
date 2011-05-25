package lbe.model;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.Instance;
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
		RelationModel<Instance> relation = this.getRelation();
		Instance pushed = null;
		if (relation!=null) {
			 pushed = context.pushRelation(relation);
		}
		
		PageElement result = super.render(context);
		result.display = getDisplay(context);
		result.name = getName();
		context.nextIdLevel();
		result.content = renderChildren(context, getChildren());
		context.previousIdLevel();
		if (relation!=null) {
			context.popInstance(pushed);
		}
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
	
	public RelationModel<Instance> getRelation() {
		return null;
	}

}
