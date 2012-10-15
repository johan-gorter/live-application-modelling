package org.instantlogic.designer;


public class SelectedInstanceDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> ofEntity
		= createRelationValue(org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.ofEntity);
		
	public org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> getOfEntityRelationValue() {
		return ofEntity;
	}

	public org.instantlogic.designer.EntityDesign getOfEntity() {
		return ofEntity.getValue();
	}
	
	public SelectedInstanceDeductionDesign setOfEntity(org.instantlogic.designer.EntityDesign newValue) {
		ofEntity.setValue(newValue);
		return (SelectedInstanceDeductionDesign)this;
	}
	
	public org.instantlogic.designer.EntityDesign newOfEntity() {
		org.instantlogic.designer.EntityDesign newValue = new org.instantlogic.designer.EntityDesign(); 
		ofEntity.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
