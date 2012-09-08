package org.instantlogic.interaction.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.interaction.flow.Flow;


public class ChangeContext extends RenderContext {

	public static ChangeContext create(Flow mainFlow, String path, Instance caseInstance, String caseId, String pageElementId, Object value, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(mainFlow, path, caseInstance, caseId, travelerInfo);
		return new ChangeContext(flowContext, path, pageElementId, value);
	}
	
	private String pageElementId;
	private Object value;

	public ChangeContext(FlowContext flowContext, String pageCoordinates, String pageElementId, Object value) {
		super(flowContext, pageCoordinates);
		this.pageElementId = pageElementId;
		this.value = value;
	}

	public void setValue(Entity entity, Attribute attribute, Object value) {
		((AttributeValue)getAttributeValue(entity, attribute)).setValue(parse(value, attribute));
	}
	
	private static final DateFormat DATE_INTERNATIONAL = new SimpleDateFormat("yyyy/MM/dd");
	
	public Object parse(Object value, Attribute attribute) {
		if (attribute.getJavaClassName()==Date.class && value instanceof String) {
			try {
				return DATE_INTERNATIONAL.parseObject((String)value);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return value;
	}

	public String getPageElementId() {
		return pageElementId;
	}

	public Object getValue() {
		return value;
	}

	
}
