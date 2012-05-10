package org.instantlogic.interaction.page;

import java.util.ArrayList;
import java.util.HashMap;
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

public class FragmentTemplate {

	private final Map<String, Deduction<?>> Values = new HashMap<String, Deduction<?>>();
	private final Map<String, Text> Texts = new HashMap<String, Text>();
	private final Map<String, FragmentTemplate[]> Childlists = new HashMap<String, FragmentTemplate[]>();
	
	private final List<FragmentBehavior> Behaviors = new ArrayList<FragmentBehavior>();
	
	private final String id;
	private final String fragmentTypeName;
	
	public FragmentTemplate(String id, String Name) {
		this.id = id;
		this.fragmentTypeName = Name;
	}

	public FragmentTemplate putValue(String DataKey, Deduction<?> value) {
		Values.put(DataKey, value);
		return this;
	}
	
	public FragmentTemplate putText(String DataKey, Text value) {
		Texts.put(DataKey, value);
		return this;
	}
	
	public FragmentTemplate putChildren(String DataKey, FragmentTemplate... children) {
		Childlists.put(DataKey, children);
		return this;
	}
	
	public FragmentTemplate addBehavior(FragmentBehavior behavior) {
		Behaviors.add(behavior);
		return this;
	}
	
	public FragmentTemplate setField(Entity<?> entity, Attribute<?, ?, ?> attribute, String answerName) {
		addBehavior(new FieldBehavior(entity, attribute, answerName));
		return this;
	}
	
	public FragmentTemplate setEvent(FlowEvent event) {
		addBehavior(new ActionBehavior(event));
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFragmentTypeName() {
		return fragmentTypeName;
	}
	
	public Map<String, Object> render(RenderContext context) {
		Map<String, Object> result = beginRender(context);
		for (int i=0;i<Behaviors.size();i++) {
			Behaviors.get(i).beforeRender(context, result);
		}
		handleRender(context, result);
		for (int i=Behaviors.size()-1;i>=0;i--) {
			Behaviors.get(i).afterRender(context, result);
		}
		endRender(context);
		return result;
	}

	private void handleRender(RenderContext context, Map<String, Object> result) {
		for (Map.Entry<String, Deduction<?>> entry : Values.entrySet()) {
			result.put(entry.getKey(), entry.getValue().deduct(context).getValue());
		}
		for (Map.Entry<String, Text> entry : Texts.entrySet()) {
			result.put(entry.getKey(), entry.getValue().renderText(context));
		}
		for (Map.Entry<String, FragmentTemplate[]> entry : Childlists.entrySet()) {
			List<Map<String, Object>> fragments = new ArrayList<Map<String, Object>>();
			for (FragmentTemplate fragmentTemplate:entry.getValue()) {
				fragments.add(fragmentTemplate.render(context));
			}
			result.put(entry.getKey(), fragments);
		}
	}
	
	protected FlowEventOccurrence handleSubmit(ChangeContext changeContext, String id) {
		FlowEventOccurrence result = null;
		for (int i=0;i<Behaviors.size();i++) {
			result = Behaviors.get(i).beforeSubmit(changeContext, result, id);
		}
		for (FragmentTemplate[] fragmentTemplates: Childlists.values()) {
			for (FragmentTemplate fragmentTemplate: fragmentTemplates) {
				result = fragmentTemplate.submit(changeContext);
			}
		}
		for (int i=Behaviors.size()-1;i>=0;i--) {
			result = Behaviors.get(i).afterSubmit(changeContext, result, id);
		}
		return result;
	}
	
	
	protected Map<String, Object> beginRender(RenderContext context) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("type",getFragmentTypeName());
		result.put("id", context.enterScope(this));
		return result;
	}
	
	protected void endRender(RenderContext context) {
		context.exitScope();
	}
	
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		String id = changeContext.enterScope(this);
		FlowEventOccurrence result = handleSubmit(changeContext, id);
		changeContext.exitScope();
		return result;
	}
}
