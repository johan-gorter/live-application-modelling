package org.instantlogic.designer;


public class FormattedValueDesign extends StringProducerDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FormattedValueDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FormattedValueDesign, DeductionSchemeDesign> deduction
		= createRelationValue(org.instantlogic.designer.entity.FormattedValueDesignEntity.deduction);
		
	public org.instantlogic.fabric.value.RelationValue<FormattedValueDesign, DeductionSchemeDesign> getDeductionRelation() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.get();
	}
	
	public void setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
	}

	// Reverse relations

}
