package org.instantlogic.interaction.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public class CompositeFragmentTemplate extends FragmentTemplate {

	private final FragmentTemplate[] children;
	private final Deduction<?> select;
	private final String id;

	
	public CompositeFragmentTemplate(String id, FragmentTemplate... children) {
		this(id, null, children);
	}
	
	public CompositeFragmentTemplate(String id, Deduction<?> select, FragmentTemplate... children) {
		this.children = children;
		this.select = select;
		this.id = id;
	}

	/**
	 * The object(s) that should be selected while rendering this container.
	 * Deduction<Object> can result in an instance or a collection of instances.
	 * 
	 * @return The objects that should be selected.
	 */
	public Deduction<? extends Object> getSelect() {
		return select;
	}
	
	@Override
	public Fragment render(RenderContext context) {
		Fragment result = super.beginRender(context);
		result.children = calculateChildren(context);
		super.endRender(context);
		return result;
	}

	@SuppressWarnings("unchecked")
	protected Fragment[] calculateChildren(RenderContext context) {
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
			return renderChildren(context, getChildren(context));
		}
		return result.toArray(new Fragment[result.size()]);
	}

	private List<Fragment> doLoopRender(RenderContext context, Iterable<Instance> value) {
		List<Fragment> children = new ArrayList<Fragment>();
		for (Object instance : (Iterable<Instance>)value) {
			Fragment element = doRenderWithInstance((Instance)instance, context);
			if (element!=null) {
				children.add(element);
			}
		}
		return children;
	}
	
	private Fragment doRenderWithInstance(Instance instance, RenderContext context) {
		Fragment result = new Fragment();
		result.id = context.enterScope(instance);
		context.pushSelectedInstance(instance);
		result.children = renderChildren(context, getChildren(context));
		context.popSelectedInstance(instance);
		context.exitScope();
		return result;
	}

	@SuppressWarnings("unchecked")
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
		for (Object instance : (Iterable<Instance>)value) {
			FlowEventOccurrence childResult = doSubmitWithInstance((Instance)instance, context);
			if (childResult!=null) {
				if (result!=null) {
					throw new RuntimeException("More than one trigger?");
				}
				result = childResult;
			}
		}
		return result;
	}

	private FlowEventOccurrence doSubmitWithInstance(Instance instance, ChangeContext context) {
		context.pushSelectedInstance(instance);
		context.enterScope(instance);
		FlowEventOccurrence result = doSubmit(context);
		context.exitScope();
		context.popSelectedInstance(instance);
		return result;
	}

	private FlowEventOccurrence doSubmit(ChangeContext context) {
		FlowEventOccurrence result = super.submit(context);
		for (FragmentTemplate child: getChildren(context)) {
			FlowEventOccurrence childResult = child.submit(context);
			if (childResult!=null) {
				if (result!=null) {
					throw new RuntimeException("More than one trigger?");
				}
				result = childResult;
			}
		}
		context.exitScope();
		return result;
	}

	public static Fragment[] renderChildren(RenderContext context, FragmentTemplate[] childModels) {
		List<Fragment> result = new ArrayList<Fragment>(childModels.length);
		for (FragmentTemplate child: childModels) {
			Fragment element = child.render(context);
			if (element!=null) {
				result.add(element);
			}
		}
		return result.toArray(new Fragment[result.size()]);
	}

	public static void changeValue(ChangeContext changeContext,
			FragmentTemplate[] childModels) {
		for (FragmentTemplate child: childModels) {
			child.submit(changeContext);
		}		
	}

	public FragmentTemplate[] getChildren(RenderContext context) {
		return children;
	}

	public String getId() {
		return id;
	}
}
