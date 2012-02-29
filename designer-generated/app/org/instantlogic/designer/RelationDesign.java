package org.instantlogic.designer;


public class RelationDesign extends AttributeDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> owner
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.owner);
	
	public java.lang.Boolean getOwner() {
		return owner.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getOwnerAttribute() {
		return owner;
	}

	public void setOwner(java.lang.Boolean newValue) {
		owner.setValue(newValue);
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> autoCreate
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.autoCreate);
	
	public java.lang.Boolean getAutoCreate() {
		return autoCreate.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getAutoCreateAttribute() {
		return autoCreate;
	}

	public void setAutoCreate(java.lang.Boolean newValue) {
		autoCreate.setValue(newValue);
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> reverseMultivalue
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseMultivalue);
	
	public java.lang.Boolean getReverseMultivalue() {
		return reverseMultivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getReverseMultivalueAttribute() {
		return reverseMultivalue;
	}

	public void setReverseMultivalue(java.lang.Boolean newValue) {
		reverseMultivalue.setValue(newValue);
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.String> reverseName
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseName);
	
	public java.lang.String getReverseName() {
		return reverseName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.String> getReverseNameAttribute() {
		return reverseName;
	}

	public void setReverseName(java.lang.String newValue) {
		reverseName.setValue(newValue);
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> to
		= createRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.to);
		
	public org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> getToRelation() {
		return to;
	}

	public org.instantlogic.designer.EntityDesign getTo() {
		return to.getValue();
	}
	
	public void setTo(org.instantlogic.designer.EntityDesign newValue) {
		to.setValue(newValue);
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<RelationDesign, EntityDesign> from
		= createReverseRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.from);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<RelationDesign, EntityDesign> getFromRelation() {
		return from;
	}

	public org.instantlogic.designer.EntityDesign getFrom() {
		return from.getValue();
	}


}
