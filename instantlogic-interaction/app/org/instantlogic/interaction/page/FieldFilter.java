package org.instantlogic.interaction.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.InstanceMetadata;
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
		if (!result.containsKey("options") && (attribute instanceof Relation<?,?,?>)) {
			Deduction options = ((Relation)attribute).getOptions();
			if (options!=null) {
				Iterable<Instance> values = (Iterable<Instance>) options.deduct(context).getValue();
				List<Map<String, Object>> resultOptions = new ArrayList<Map<String, Object>>();
				for(Instance value : values) {
					Map resultOption = new HashMap<String, Object>();
					if (value.getMetadata().getStaticName()!=null) {
						resultOption.put("id", value.getMetadata().getStaticName());						
					} else {
						resultOption.put("id", value.getMetadata().getInstanceId());						
					}
					if (value.getMetadata().getStaticDescription()!=null) {
						resultOption.put("text", value.getMetadata().getStaticDescription().renderText(context));
					} else if (value.getMetadata().getStaticName()!=null) {
						resultOption.put("text", value.getMetadata().getStaticName());
					} else {
						resultOption.put("text", value.getMetadata().getInstanceId()); // TODO: Entities should get descriptions like titles on Places
					}
					resultOptions.add(resultOption);
				}
				result.put("options", resultOptions.toArray());
			}
		}
		if (!result.containsKey("dataType")) {
			Map<String, Object> dataType = attribute.getDataType();
			if (dataType!=null) {
				result.put("dataType", dataType);
			}
		}
		Object value = context.getValue((Entity)entity, (Attribute)attribute);
		result.put("value", safeValue(value));
		return result;
	}
	
	private Object safeValue(Object value) {
		if (value instanceof Instance) {
			InstanceMetadata metadata = ((Instance)value).getMetadata();
			if (metadata.getStaticName()!=null) {
				return metadata.getStaticName();
			} else {
				return metadata.getInstanceId();
			}
		}
		return value;
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
