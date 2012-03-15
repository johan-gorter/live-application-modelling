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
		
	public org.instantlogic.fabric.value.RelationValue<FormattedValueDesign, DeductionSchemeDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.getValue();
	}
	
	public FormattedValueDesign setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
		return (FormattedValueDesign)this;
	}


	// Reverse relations

}
