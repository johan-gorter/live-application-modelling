package org.instantlogic.designer;


public  class AttributeDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.AttributeDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDeductionDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.AttributeDeductionDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDeductionDesign, AttributeDesign> getAttributeRelation() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.get();
	}
	
	public void setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
	}


	// Reverse relations

}
