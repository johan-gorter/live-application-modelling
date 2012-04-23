package org.instantlogic.interaction.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class CompositePageFragment extends PlaceFragmentTemplate {

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
	public Fragment render(RenderContext context) {
		Fragment result = super.render(context);
		result.id=result.id+"-Parent";
		setChildren(result, context);
		return result;
	}

	protected void setChildren(Fragment result, RenderContext context) {
		Collection<Fragment> children = calculateChildren(context);
		result.children = children.toArray(new Fragment[children.size()]);
	}
	
	protected Collection<Fragment> calculateChildren(RenderContext context) {
		Collection<Fragment> result;
		Deduction<? extends Object> select = this.getSelect();
		if (select!=null) {
			Object value = select.deduct(context).getValue();
			if (value==null) {
				return null;
			} else if (value instanceof Instance) {
				result = Collections.singleton(doRenderWithInstance((Instance)value, context));
			} else if (value instanceof Iterable) {
				result = doLoopRender(context, (Iterable<Instance>) value);
			} else {
				throw new RuntimeException("Deduction of select did not yield instance(s), but "+value);
			}
		} else {
			result = Collections.singleton(doRender(context));
		}
		return result;
	}

	private List<Fragment> doLoopRender(RenderContext context, Iterable<Instance> value) {
		context.nextIdLevel();
		List<Fragment> children = new ArrayList<Fragment>();
		for (Object instance : (Iterable<Instance>)value) {
			Fragment element = doRenderWithInstance((Instance)instance, context);
			if (element!=null) {
				children.add(element);
			}
		}
		context.previousIdLevel();
		return children;
	}
	
	private Fragment doRenderWithInstance(Instance instance, RenderContext context) {
		context.pushSelectedInstance(instance);
		Fragment result = doRender(context);
		context.popSelectedInstance(instance);
		return result;
	}

	private Fragment doRender(RenderContext context) {
		Fragment result = super.render(context);
//		Text display = getDisplay();
//		if (display!=null) {
//			result.display = display.renderText(context);
//		}
//		result.name = getName();
		context.nextIdLevel();
		
		result.children = renderChildren(context, getChildren(context));
		
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
				return null;
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
		for (PlaceFragmentTemplate child: getChildren(context)) {
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

	public static Fragment[] renderChildren(RenderContext context, PlaceFragmentTemplate[] childModels) {
		List<Fragment> result = new ArrayList<Fragment>(childModels.length);
		for (PlaceFragmentTemplate child: childModels) {
			Fragment element = child.render(context);
			if (element!=null) {
				result.add(element);
			}
		}
		return result.toArray(new Fragment[result.size()]);
	}

	public abstract PlaceFragmentTemplate[] getChildren(RenderContext context);
	
	public static void changeValue(ChangeContext changeContext,
			PlaceFragmentTemplate[] childModels) {
		for (PlaceFragmentTemplate child: childModels) {
			child.submit(changeContext);
		}		
	}
}
