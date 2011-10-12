package lbe.engine;

import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.model.Attribute;
import lbe.model.Entity;

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

	private Instance[] selectedInstancesDuringTrigger;

	public ChangeContext(FlowContext flowContext, String pageCoordinates, FieldChange[] fieldChanges, String submit) {
		super(flowContext, pageCoordinates);
		this.fieldChanges = fieldChanges;
		this.submit = submit;
	}

	public void setValue(Entity entity, Attribute attribute, Object value) {
		((AttributeValue)getAttributeValue(entity, attribute)).set(attribute.parse(value));
	}

	public String getSubmit() {
		return submit;
	}

	public FieldChange[] getFieldChanges() {
		return fieldChanges;
	}

	public void storeSelectedInstancesDuringTrigger() {
		this.selectedInstancesDuringTrigger = selectedInstances.toArray(new Instance[selectedInstances.size()]);
	}

	public Instance[] getSelectedInstancesDuringTrigger() {
		return selectedInstancesDuringTrigger;
	}
}
