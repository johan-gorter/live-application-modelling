package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.DomainEntry;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.page.PageElement.Domain;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public class FieldBehavior extends AbstractWidgetBehavior {
	
	private final Attribute<?, ?, ?> attribute;
	private final Entity<?> entity;
	private final String answerFragmentType;

	// TODO: question, etc...
	
	public FieldBehavior(Entity<?> entity, Attribute<?, ?, ?> attribute, String answerFragmentType) {
		this.answerFragmentType = answerFragmentType;
		this.entity = entity;
		this.attribute = attribute;
	}
	
	@Override
	public void beforeRender(RenderContext context, Map<String, Object> result) {
		result.put("answerType", this.answerFragmentType);
	}
	
	@Override
	public FlowEventOccurrence beforeSubmit(ChangeContext changeContext, FlowEventOccurrence result, String id) {
		for (ChangeContext.FieldChange fieldChange: changeContext.getFieldChanges()) {
			if (fieldChange.getPageElementId().equals(id)) {
				changeContext.setValue(this.entity, this.attribute, fieldChange.getValue());
			}
		}
		return super.beforeSubmit(changeContext, result, id);
	}
	
	@SuppressWarnings("unused")
	private Domain[] convertDomain(DomainEntry[] domain, RenderContext context) {
		Domain[] result = new Domain[domain.length];
		for (int i=0;i<domain.length;i++) {
			result[i]=new Domain(domain[i].getValue(), domain[i].getDisplay().renderText(context));
		}
		return result;
	}
}
