package org.instantlogic.designer;


public class ReverseRelationDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ReverseRelationDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<ReverseRelationDeductionDesign, RelationDesign> relation
		= createRelationValue(org.instantlogic.designer.entity.ReverseRelationDeductionDesignEntity.relation);
		
	public org.instantlogic.fabric.value.RelationValue<ReverseRelationDeductionDesign, RelationDesign> getRelationRelationValue() {
		return relation;
	}

	public org.instantlogic.designer.RelationDesign getRelation() {
		return relation.getValue();
	}
	
	public ReverseRelationDeductionDesign setRelation(org.instantlogic.designer.RelationDesign newValue) {
		relation.setValue(newValue);
		return (ReverseRelationDeductionDesign)this;
	}
	
	public org.instantlogic.designer.RelationDesign newRelation() {
		org.instantlogic.designer.RelationDesign newValue = new org.instantlogic.designer.RelationDesign(); 
		relation.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
