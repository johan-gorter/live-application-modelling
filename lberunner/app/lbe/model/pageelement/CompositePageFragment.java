package lbe.model.pageelement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.instance.Instance;
import lbe.model.Relation;
import lbe.model.deduction.Deduction;

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

	/**
	 * The object(s) that should be selected while rendering this container.
	 * Deduction<Object> can result in an instance or a collection of instances.
	 * 
	 * @return The objects that should be selected.
	 */
	public Deduction<? extends Object> getSelect() {
		return null;
	}

	@Override
	public PageElement render(RenderContext context) {
		PageElement result;
		Deduction<? extends Object> select = this.getSelect();
		if (select!=null) {
			Object value = select.deduct(context);
			if (value==null) {
				throw new RuntimeException("Deduction did not yield a value for select "+this);
			} else if (value instanceof Instance) {
				result = doRenderWithInstance((Instance)value, context);
			} else if (value instanceof Iterable) {
				result = doLoopRender(context, (Iterable<Instance>) value);
			} else {
				throw new RuntimeException("Deduction of select did not yield instance(s), but "+value);
			}
		} else {
			result = doRender(context);
		}
		return result;
	}

	private PageElement doLoopRender(RenderContext context, Iterable<Instance> value) {
		PageElement result = super.render(context);
		context.nextIdLevel();
		result.name = getName()+"-Parent";
		List<PageElement> children = new ArrayList<PageElement>();
		for (Object instance : (Iterable<Instance>)value) {
			children.add(doRenderWithInstance((Instance)instance, context));
		}
		result.content = children.toArray(new PageElement[children.size()]);
		context.previousIdLevel();
		return result;
	}
	
	private PageElement doRenderWithInstance(Instance instance, RenderContext context) {
		context.pushSelectedInstance(instance);
		PageElement result = doRender(context);
		context.popSelectedInstance(instance);
		return result;
	}

	private PageElement doRender(RenderContext context) {
		PageElement result = super.render(context);
		Text display = getDisplay();
		if (display!=null) {
			result.display = display.renderText(context);
		}
		result.name = getName();
		context.nextIdLevel();
		
		result.content = renderChildren(context, getChildren(context));
		
		context.previousIdLevel();
		return result;
	}

	@Override
	public FlowEventOccurrence submit(ChangeContext context) {
		FlowEventOccurrence result = null;
		
		Deduction<? extends Object> select = this.getSelect();
		if (select!=null) {
			Object value = select.deduct(context);
			if (value==null) {
				throw new RuntimeException("Deduction did not yield a value for select "+this);
			} else if (value instanceof Instance) {
				result = doSubmitWithInstance((Instance)value, context);
			} else if (value instanceof Iterable) {
				result = doLoopSubmit(context, (Iterable<Instance>) value);
			} else {
				throw new RuntimeException("Deduction of select did not yield instance(s), but "+value);
			}
		} else {
			result = doSubmit(context);
		}
		return result;
	}
	
	private FlowEventOccurrence doLoopSubmit(ChangeContext context, Iterable<Instance> value) {
		FlowEventOccurrence result = super.submit(context);
		context.nextIdLevel();
		for (Object instance : (Iterable<Instance>)value) {
			FlowEventOccurrence childResult = doSubmitWithInstance((Instance)instance, context);
			if (childResult!=null) {
				if (result!=null) {
					throw new RuntimeException("More than one trigger?");
				}
				result = childResult;
			}
		}
		context.previousIdLevel();
		return result;
	}

	private FlowEventOccurrence doSubmitWithInstance(Instance instance, ChangeContext context) {
		context.pushSelectedInstance(instance);
		FlowEventOccurrence result = doSubmit(context);
		context.popSelectedInstance(instance);
		return result;
	}

	private FlowEventOccurrence doSubmit(ChangeContext context) {
		FlowEventOccurrence result = super.submit(context);
		context.nextIdLevel();
		for (PageFragment child: getChildren(context)) {
			FlowEventOccurrence childResult = child.submit(context);
			if (childResult!=null) {
				if (result!=null) {
					throw new RuntimeException("More than one trigger?");
				}
				result = childResult;
			}
		}
		context.previousIdLevel();
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

	public abstract PageFragment[] getChildren(RenderContext context);
	
	public static void changeValue(ChangeContext changeContext,
			PageFragment[] childModels) {
		for (PageFragment child: childModels) {
			child.submit(changeContext);
		}		
	}
	
	@Override
	public CompositePageFragment withPresentation(String presentation) {
		return (CompositePageFragment)super.withPresentation(presentation);
	}
}
