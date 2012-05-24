package org.instantlogic.designer;


public class RelationDesign extends AttributeDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> autoCreate
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.autoCreate);
	
	public java.lang.Boolean getAutoCreate() {
		return autoCreate.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getAutoCreateAttributeValue() {
		return autoCreate;
	}

	public RelationDesign setAutoCreate(java.lang.Boolean newValue) {
		autoCreate.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> owner
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.owner);
	
	public java.lang.Boolean getOwner() {
		return owner.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getOwnerAttributeValue() {
		return owner;
	}

	public RelationDesign setOwner(java.lang.Boolean newValue) {
		owner.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> reverseMultivalue
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseMultivalue);
	
	public java.lang.Boolean getReverseMultivalue() {
		return reverseMultivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getReverseMultivalueAttributeValue() {
		return reverseMultivalue;
	}

	public RelationDesign setReverseMultivalue(java.lang.Boolean newValue) {
		reverseMultivalue.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.String> reverseName
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseName);
	
	public java.lang.String getReverseName() {
		return reverseName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.String> getReverseNameAttributeValue() {
		return reverseName;
	}

	public RelationDesign setReverseName(java.lang.String newValue) {
		reverseName.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> to
		= createRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.to);
		
	public org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> getToRelationValue() {
		return to;
	}

	public org.instantlogic.designer.EntityDesign getTo() {
		return to.getValue();
	}
	
	public RelationDesign setTo(org.instantlogic.designer.EntityDesign newValue) {
		to.setValue(newValue);
		return (RelationDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<RelationDesign, EntityDesign> from
		= createReverseRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.from);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<RelationDesign, EntityDesign> getFromRelationValue() {
		return from;
	}

	public org.instantlogic.designer.EntityDesign getFrom() {
		return from.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<RelationDesign, ReverseRelationDeductionDesign> relationInDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.RelationDesignEntity.relationInDeductions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<RelationDesign, ReverseRelationDeductionDesign> getRelationInDeductionsRelationValue() {
		return relationInDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ReverseRelationDeductionDesign> getRelationInDeductions() {
		return relationInDeductions.getValue();
	}


}
