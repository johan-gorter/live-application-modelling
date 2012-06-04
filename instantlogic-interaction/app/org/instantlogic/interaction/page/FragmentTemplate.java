package org.instantlogic.interaction.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public class FragmentTemplate extends AbstractTemplate {

	private final List<FragmentFilter> customFilters = new ArrayList<FragmentFilter>();
	
	private final Map<String, Deduction<?>> values = new HashMap<String, Deduction<?>>();
	private final Map<String, Text> texts = new HashMap<String, Text>();
	private final Map<String, AbstractTemplate[]> childlists = new HashMap<String, AbstractTemplate[]>();
	
	private final String id;
	private final String fragmentTypeName;

	private FieldFilter field;
	private ActionFilter event;

	private List<FragmentFilter> filters;
	
	private void initFilters() {
		if (filters==null) {
			filters = new ArrayList<FragmentFilter>();
			filters.addAll(customFilters);
			if (field!=null) {
				filters.add(field);
			}
			if (event!=null) {
				filters.add(event);
			}
		}
	}
	
	private class FilterChain implements FragmentFilterChain {
		
		private final String id;
		private Iterator<FragmentFilter> iterator = filters.iterator();
		
		public FilterChain(String id) {
			this.id = id;
		}
		
		@Override
		public Map<String, Object> render(RenderContext context) {
			if (iterator.hasNext()) {
				return iterator.next().render(context, id, this);
			} else {
				return doRender(context, id);
			}
		}

		@Override
		public FlowEventOccurrence submit(ChangeContext context) {
			if (iterator.hasNext()) {
				return iterator.next().submit(context, id, this);
			} else {
				return doSubmit(context, id);
			}
		}
	};
	
	public FragmentTemplate(String id, String fragmentTypeName) {
		this.id = id;
		this.fragmentTypeName = fragmentTypeName;
	}
	
	public FragmentTemplate addCustomFilter(FragmentFilter filter) {
		customFilters.add(filter);
		return this;
	}

	public FragmentTemplate putValue(String DataKey, Deduction<?> value) {
		values.put(DataKey, value);
		return this;
	}
	
	public FragmentTemplate putText(String DataKey, Text value) {
		texts.put(DataKey, value);
		return this;
	}
	
	public FragmentTemplate putChildren(String DataKey, AbstractTemplate... children) {
		childlists.put(DataKey, children);
		return this;
	}
	
	public FragmentTemplate setField(Entity<?> entity, Attribute<?, ?, ?> attribute, String answerFragmentTypeName) {
		this.field = new FieldFilter(entity, attribute, answerFragmentTypeName);
		return this;
	}
	
	public FragmentTemplate setEvent(FlowEvent event) {
		this.event = new ActionFilter(event);
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFragmentTypeName() {
		return fragmentTypeName;
	}
	
	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		initFilters();
		String id = context.enterScope(this);
		FilterChain chain = new FilterChain(id);
		Map<String, Object> rendering = chain.render(context); // Chain ends with a call to doRender
		appendTo.add(rendering);
		context.exitScope();
	}
	
	protected Map<String, Object> doRender(RenderContext context, String id) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("type", getFragmentTypeName());
		result.put("id", id);
		for (Map.Entry<String, Deduction<?>> entry : values.entrySet()) {
			result.put(entry.getKey(), entry.getValue().deduct(context).getValue());
		}
		for (Map.Entry<String, Text> entry : texts.entrySet()) {
			result.put(entry.getKey(), entry.getValue().renderText(context));
		}
		for (Map.Entry<String, AbstractTemplate[]> entry : childlists.entrySet()) {
			List<Map<String, Object>> fragments = new ArrayList<Map<String, Object>>();
			for (AbstractTemplate template: entry.getValue()) {
				template.render(context, fragments);
			}
			result.put(entry.getKey(), fragments);
		}
		return result;
	}

	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		initFilters();
		String id = changeContext.enterScope(this);
		FilterChain chain = new FilterChain(id);
		FlowEventOccurrence result = chain.submit(changeContext); // Chain ends with a call to doSubmit
		changeContext.exitScope();
		return result;
	}
	
	protected FlowEventOccurrence doSubmit(ChangeContext changeContext, String id) {
		FlowEventOccurrence result=null;
		for (AbstractTemplate[] fragmentTemplates: childlists.values()) {
			for (AbstractTemplate template: fragmentTemplates) {
				FlowEventOccurrence itemResult = template.submit(changeContext);
				if (itemResult!=null) {
					if (result!=null) {
						throw new RuntimeException("More than one FlowEventOccurrence");
					}
					result = itemResult;
				}
			}
		}
		return result;
	}
}
