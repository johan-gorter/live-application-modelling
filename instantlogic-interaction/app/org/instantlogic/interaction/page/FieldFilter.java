package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.RenderContext;

public class FieldFilter extends AbstractFragmentFilter {
	
	private final Attribute<?, ?, ?> attribute;
	private final Entity<?> entity;
	
	public FieldFilter(Entity<?> entity, Attribute<?, ?, ?> attribute) {
		this.entity = entity;
		this.attribute = attribute;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> render(RenderContext context, String id, FragmentFilterChain chain) {
		Map<String, Object> result = super.render(context, id, chain);
		if (!result.containsKey("questionText")) {
			if (attribute.getQuestion()!=null) {
				result.put("questionText", attribute.getQuestion().renderText(context));
			} else {
				result.put("questionText", attribute.getName());
			}
		}
		if (!result.containsKey("explainText")) {
			if (attribute.getExplain()!=null) {
				result.put("explainText", attribute.getExplain().renderText(context));
			}
		}
		if (!result.containsKey("dataType")) {
			Map<String, Object> dataType = attribute.getDataType();
			if (dataType!=null) {
				result.put("dataType", dataType);
			}
		}
		Object value = context.getValue((Entity)entity, (Attribute)attribute);
		result.put("value", value);
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
