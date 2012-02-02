package lbe.engine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.AttributeValue;


public class ChangeContext extends RenderContext {

	public static class FieldChange {
		private String pageElementId;
		private Object value;
		
		public FieldChange(String pageElementId, Object value) {
			this.pageElementId = pageElementId;
			this.value = value;
		}

		public String getPageElementId() {
			return pageElementId;
		}
		public Object getValue() {
			return value;
		}
	}
	
	private String submit;
	
	private FieldChange[] fieldChanges; //TODO: more efficiency by using a sorted array

	public ChangeContext(FlowContext flowContext, String pageCoordinates, FieldChange[] fieldChanges, String submit) {
		super(flowContext, pageCoordinates);
		this.fieldChanges = fieldChanges;
		this.submit = submit;
	}

	public void setValue(Entity entity, Attribute attribute, Object value) {
		((AttributeValue)getAttributeValue(entity, attribute)).set(parse(value, attribute));
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

	public String getSubmit() {
		return submit;
	}

	public FieldChange[] getFieldChanges() {
		return fieldChanges;
	}
}
