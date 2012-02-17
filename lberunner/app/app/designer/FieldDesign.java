package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.RelationValue;

import app.designer.entity.FieldDesignEntity;

public class FieldDesign 
	extends PageFragmentDesign 
	implements Instance {

	public FieldDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FieldDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FieldDesignEntity.INSTANCE, id);
	}
	
	protected FieldDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<FieldDesign, java.lang.Boolean> required
		= createAttributeValue(FieldDesignEntity.required);
	
	public java.lang.Boolean getRequired() {
		return required.get();
	}

	public void setRequired(java.lang.Boolean newValue) {
		required.set(newValue);
	}
	
	public final AttributeValue<FieldDesign, java.lang.Boolean> readOnly
		= createAttributeValue(FieldDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.get();
	}

	public void setReadOnly(java.lang.Boolean newValue) {
		readOnly.set(newValue);
	}
	
	// Relations
	
	public final RelationValue<FieldDesign, AttributeDesign> attribute
		= createRelationValue(FieldDesignEntity.attribute);
		
	public AttributeDesign getAttribute() {
		return attribute.get();
	}
	
	public void setAttribute(AttributeDesign newValue) {
		attribute.set(newValue);
	}

	// Reverse relations

}
