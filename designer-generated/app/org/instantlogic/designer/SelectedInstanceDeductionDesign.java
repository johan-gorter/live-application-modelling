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
		
	public org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> getOfEntityRelation() {
		return ofEntity;
	}

	public org.instantlogic.designer.EntityDesign getOfEntity() {
		return ofEntity.get();
	}
	
	public void setOfEntity(org.instantlogic.designer.EntityDesign newValue) {
		ofEntity.setValue(newValue);
	}

	// Reverse relations

}
