package lbe.engine;

import lbe.instance.value.AttributeValue;
import lbe.model.Attribute;

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
	
	private FieldChange[] fieldChanges; //TOOD: more efficiency by using a sorted array

	public ChangeContext(String caseId, CaseData caseData, Session session, FieldChange[] fieldChanges, String submit) {
		super(caseId, caseData, session);
		this.fieldChanges = fieldChanges;
		this.submit = submit;
	}

	public void setValue(Attribute attribute, Object value) {
		((AttributeValue)getCaseData().getValue(attribute)).set(attribute.parse(value));
	}

	public String getSubmit() {
		return submit;
	}

	public FieldChange[] getFieldChanges() {
		return fieldChanges;
	}
	
}
