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

public class WidgetFragmentTemplate extends FragmentTemplate {

	private final Map<String, Deduction<?>> widgetValues = new HashMap<String, Deduction<?>>();
	private final Map<String, Text> widgetTexts = new HashMap<String, Text>();
	private final Map<String, FragmentTemplate[]> widgetChildlists = new HashMap<String, FragmentTemplate[]>();
	
	private final List<WidgetBehavior> widgetBehaviors = new ArrayList<WidgetBehavior>();
	
	private final String id;
	private final String widgetName;

	public WidgetFragmentTemplate(String id, String widgetName) {
		this.id = id;
		this.widgetName = widgetName;
	}
	
	public WidgetFragmentTemplate putValue(String widgetDataKey, Deduction<?> value) {
		widgetValues.put(widgetDataKey, value);
		return this;
	}
	
	public WidgetFragmentTemplate putText(String widgetDataKey, Text value) {
		widgetTexts.put(widgetDataKey, value);
		return this;
	}
	
	public WidgetFragmentTemplate putChildren(String widgetDataKey, FragmentTemplate... children) {
		widgetChildlists.put(widgetDataKey, children);
		return this;
	}
	
	public WidgetFragmentTemplate addBehavior(WidgetBehavior behavior) {
		widgetBehaviors.add(behavior);
		return this;
	}
	
	public WidgetFragmentTemplate setField(Entity<?> entity, Attribute<?, ?, ?> attribute, String answerWidgetName) {
		addBehavior(new FieldWidgetBehavior(entity, attribute, answerWidgetName));
		return this;
	}
	
	public WidgetFragmentTemplate setEvent(FlowEvent event) {
		addBehavior(new ActionWidgetBehavior(event));
		return this;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getWidgetName() {
		return widgetName;
	}
	
	@Override
	public Fragment render(RenderContext context) {
		Fragment result = super.beginRender(context);
		for (int i=0;i<widgetBehaviors.size();i++) {
			widgetBehaviors.get(i).beforeRender(context, result);
		}
		handleRender(context, result);
		for (int i=widgetBehaviors.size()-1;i>=0;i--) {
			widgetBehaviors.get(i).afterRender(context, result);
		}
		super.endRender(context);
		return result;
	}

	private void handleRender(RenderContext context, Fragment result) {
		for (Map.Entry<String, Deduction<?>> entry : widgetValues.entrySet()) {
			result.widgetData.put(entry.getKey(), entry.getValue().deduct(context));
		}
		for (Map.Entry<String, Text> entry : widgetTexts.entrySet()) {
			result.widgetData.put(entry.getKey(), entry.getValue().renderText(context));
		}
		for (Map.Entry<String, FragmentTemplate[]> entry : widgetChildlists.entrySet()) {
			List<Fragment> fragments = new ArrayList<Fragment>();
			for (FragmentTemplate fragmentTemplate:entry.getValue()) {
				fragments.add(fragmentTemplate.render(context));
			}
			result.widgetData.put(entry.getKey(), fragments);
		}
	}
	
	@Override
	protected FlowEventOccurrence handleSubmit(ChangeContext changeContext, String id) {
		FlowEventOccurrence result = null;
		for (int i=0;i<widgetBehaviors.size();i++) {
			result = widgetBehaviors.get(i).beforeSubmit(changeContext, result, id);
		}
		for (FragmentTemplate[] fragmentTemplates: widgetChildlists.values()) {
			for (FragmentTemplate fragmentTemplate: fragmentTemplates) {
				result = fragmentTemplate.submit(changeContext);
			}
		}
		for (int i=widgetBehaviors.size()-1;i>=0;i--) {
			result = widgetBehaviors.get(i).afterSubmit(changeContext, result, id);
		}
		return result;
	}
}
