package org.instantlogic.designer;


public class SelectDesign extends CompositeTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SelectDesign, DeductionSchemeDesign> deduction
		= createRelationValue(org.instantlogic.designer.entity.SelectDesignEntity.deduction);
		
	public org.instantlogic.fabric.value.RelationValue<SelectDesign, DeductionSchemeDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.getValue();
	}
	
	public SelectDesign setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
		return (SelectDesign)this;
	}


	// Reverse relations

}
