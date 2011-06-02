package lbe.model.pageelement;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.ChangeContext;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.instance.Instance;
import lbe.model.Relation;

public abstract class Container extends PageElementBase {

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
		Relation<Instance, Instance> relation = this.getRelation();
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
	
	@Override
	public void changeValue(ChangeContext context) {
		super.changeValue(context);
		Relation<Instance, Instance> relation = this.getRelation();
		Instance pushed = null;
		if (relation!=null) {
			 pushed = context.pushRelation(relation);
		}
		context.nextIdLevel();
		
		for (PageElementBase child: getChildren()) {
			child.changeValue(context);
		}
		
		context.previousIdLevel();
		if (relation!=null) {
			context.popInstance(pushed);
		}
	}

	public static PageElement[] renderChildren(RenderContext context, PageElementBase[] childModels) {
		List<PageElement> result = new ArrayList<PageElement>(childModels.length);
		for (PageElementBase child: childModels) {
			PageElement element = child.render(context);
			if (element!=null) {
				result.add(element);
			}
		}
		return result.toArray(new PageElement[result.size()]);
	}

	public abstract PageElementBase[] getChildren();
	
	@SuppressWarnings("rawtypes")
	public Relation getRelation() {
		return null;
	}

	public static void changeValue(ChangeContext changeContext,
			PageElementBase[] childModels) {
		for (PageElementBase child: childModels) {
			child.changeValue(changeContext);
		}		
	}

}
