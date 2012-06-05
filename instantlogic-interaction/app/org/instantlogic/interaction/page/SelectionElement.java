package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

/**
 * Does not create a fragment on the client, but selects instances on the server.
 */
public class SelectionElement extends Element {

	private final Deduction<?> selection;
	private final Element[] children;
	
	public SelectionElement(Deduction<?> selection, Element... children) {
		this.selection = selection;
		this.children = children;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		ValueAndLevel<?> valueAndLevel = selection.deduct(context);
		if (valueAndLevel.hasValue()) {
			Object value = valueAndLevel.getValue();
			if (value instanceof Multi<?>) {
				for (Object item: (Multi<?>)value) {
					renderWith(item, context, appendTo);
				}
			} else  {
				renderWith(value, context, appendTo);
			}
		}
	}

	private void renderWith(Object value, RenderContext context, List<Map<String, Object>> appendTo) {
		if (value instanceof Instance) {
			Instance instance = (Instance) value;
			context.enterScope(instance);
			context.pushSelectedInstance(instance);
			for (Element template: children) {
				template.render(context, appendTo);
			}
			context.popSelectedInstance(instance);
			context.exitScope();
		} else {
			throw new RuntimeException("Not sure how to handle selection of primitives");
		}
	}

	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		FlowEventOccurrence result = null;
		ValueAndLevel<?> valueAndLevel = selection.deduct(changeContext);
		if (valueAndLevel.hasValue()) {
			Object value = valueAndLevel.getValue();
			if (value instanceof Multi<?>) {
				for (Object item: (Multi<?>)value) {
					FlowEventOccurrence itemResult = submitWith(item, changeContext);
					if (itemResult!=null) {
						if (result!=null) { 
							throw new RuntimeException("More than one FlowEventOccurrence");
						}
						result = itemResult;
					}
				}
			} else  {
				result = submitWith(value, changeContext);
			}
		}
		return result;
	}

	private FlowEventOccurrence submitWith(Object value, ChangeContext changeContext) {
		FlowEventOccurrence result = null;
		if (value instanceof Instance) {
			Instance instance = (Instance) value;
			changeContext.enterScope(instance);
			for (Element template: children) {
				FlowEventOccurrence itemResult = template.submit(changeContext);
				if (itemResult!=null) {
					if (result!=null) { 
						throw new RuntimeException("More than one FlowEventOccurrence");
					}
					result = itemResult;
				}
			}
			changeContext.exitScope();
		} else {
			throw new RuntimeException("Not sure how to handle selection of primitives");
		}
		return result;
	}
}
