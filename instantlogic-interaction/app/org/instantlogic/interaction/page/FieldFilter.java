package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.RenderContext;

public class FieldFilter extends AbstractFragmentFilter {
	
	private final Attribute<?, ?, ?> attribute;
	private final Entity<?> entity;
	private final String answerFragmentType;

	// TODO: question, etc...
	
	public FieldFilter(Entity<?> entity, Attribute<?, ?, ?> attribute, String answerFragmentType) {
		this.answerFragmentType = answerFragmentType;
		this.entity = entity;
		this.attribute = attribute;
	}
	
	@Override
	public Map<String, Object> render(RenderContext context, String id, FragmentFilterChain chain) {
		Map<String, Object> result = super.render(context, id, chain);
		result.put("answerType", this.answerFragmentType);
		// TODO: add question etc if not yet present
		return result;
	}
	
	@Override
	public void change(ChangeContext changeContext, String id, FragmentFilterChain chain) {
		super.change(changeContext, id, chain);
		if (changeContext.getPageElementId().equals(id)) {
			changeContext.setValue(this.entity, this.attribute, changeContext.getValue());
		}
	}
	
//	private Domain[] convertDomain(DomainEntry[] domain, RenderContext context) {
//		Domain[] result = new Domain[domain.length];
//		for (int i=0;i<domain.length;i++) {
//			result[i]=new Domain(domain[i].getValue(), domain[i].getDisplay().renderText(context));
//		}
//		return result;
//	}
}
