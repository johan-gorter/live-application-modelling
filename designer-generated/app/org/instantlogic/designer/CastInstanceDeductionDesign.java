package org.instantlogic.designer;


public  class CastInstanceDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<CastInstanceDeductionDesign, EntityDesign> toEntity
		= createRelationValue(org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.toEntity);
		
	public org.instantlogic.fabric.value.RelationValue<CastInstanceDeductionDesign, EntityDesign> getToEntityRelation() {
		return toEntity;
	}

	public org.instantlogic.designer.EntityDesign getToEntity() {
		return toEntity.get();
	}
	
	public void setToEntity(org.instantlogic.designer.EntityDesign newValue) {
		toEntity.setValue(newValue);
	}

	// Reverse relations

}
