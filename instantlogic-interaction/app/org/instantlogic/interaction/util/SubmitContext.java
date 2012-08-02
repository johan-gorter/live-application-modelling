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


public class SubmitContext extends RenderContext {

	public static SubmitContext create(Flow mainFlow, String path, Instance caseInstance, String caseId, String pageElementId, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(mainFlow, path, caseInstance, caseId, travelerInfo);
		return new SubmitContext(flowContext, path, pageElementId);
	}
	
	private String pageElementId;
	
	public SubmitContext(FlowContext flowContext, String pageCoordinates, String pageElementId) {
		super(flowContext, pageCoordinates);
		this.pageElementId = pageElementId;
	}

	public void setValue(Entity entity, Attribute attribute, Object value) {
		((AttributeValue)getAttributeValue(entity, attribute)).setValue(parse(value, attribute));
	}
	
	private static final DateFormat DATE_INTERNATIONAL = new SimpleDateFormat("dd/MM/yyyy");
	
	public Object parse(Object value, Attribute attribute) {
		if (attribute.getDatatype()==Date.class && value instanceof String) {
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
}
