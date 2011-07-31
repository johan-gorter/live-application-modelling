package lbe.model.pageelement;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.ChangeContext;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.instance.Instance;
import lbe.model.Relation;

public abstract class CompositePageFragment extends PageFragment {

	@Override
	public String getName() {
		return null;
	}
	
	public Text getDisplay() {
		return null;
	}
	
	public String getElementType() {
		return "container";
	}

	// TODO --> getSelect()
	@SuppressWarnings("rawtypes")
	public Relation getRelation() {
		return null;
	}

	@Override
	public PageElement render(RenderContext context) {
		Relation<Instance, Instance, Instance> relation = this.getRelation();
		Instance pushed = null;
		if (relation!=null) {
			 pushed = context.pushRelation(relation);
		}
		
		PageElement result = super.render(context);
		Text display = getDisplay();
		if (display!=null) {
			result.display = display.renderText(context);
		}
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
	public String submit(ChangeContext context) {
		String result = null;
		super.submit(context);
		//TODO: remove code duplication
		Relation<Instance, Instance, Instance> relation = this.getRelation();
		Instance pushed = null;
		if (relation!=null) {
			 pushed = context.pushRelation(relation);
		}
		context.nextIdLevel();
		
		for (PageFragment child: getChildren()) {
			String childResult = child.submit(context);
			if (childResult!=null) {
				if (result!=null) {
					throw new RuntimeException("More than one trigger?");
				}
				result = childResult;
			}
		}
		
		context.previousIdLevel();
		if (relation!=null) {
			context.popInstance(pushed);
		}
		return result;
	}

	public static PageElement[] renderChildren(RenderContext context, PageFragment[] childModels) {
		List<PageElement> result = new ArrayList<PageElement>(childModels.length);
		for (PageFragment child: childModels) {
			PageElement element = child.render(context);
			if (element!=null) {
				result.add(element);
			}
		}
		return result.toArray(new PageElement[result.size()]);
	}

	public abstract PageFragment[] getChildren();
	
	public static void changeValue(ChangeContext changeContext,
			PageFragment[] childModels) {
		for (PageFragment child: childModels) {
			child.submit(changeContext);
		}		
	}
}
