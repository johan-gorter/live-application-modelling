package org.instantlogic.designer;


public  class SelectedInstanceDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> entity
		= createRelationValue(org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.entity);
		
	public org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> getEntityRelation() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.get();
	}
	
	public void setEntity(org.instantlogic.designer.EntityDesign newValue) {
		entity.setValue(newValue);
	}

	// Reverse relations

}
