package org.instantlogic.designer;


public  class CastInstanceDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<CastInstanceDeductionDesign, EntityDesign> entity
		= createRelationValue(org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.entity);
		
	public org.instantlogic.fabric.value.RelationValue<CastInstanceDeductionDesign, EntityDesign> getEntityRelation() {
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
