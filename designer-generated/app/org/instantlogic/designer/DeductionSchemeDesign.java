package org.instantlogic.designer;


public class DeductionSchemeDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionSchemeDesign, DeductionDesign> deductions
		= createRelationValues(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionSchemeDesign, DeductionDesign> getDeductionsRelationValue() {
		return deductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign> getDeductions() {
		return deductions.getValue();
	}
	
	public DeductionSchemeDesign addToDeductions(DeductionDesign item) {
		deductions.addValue(item);
		return (DeductionSchemeDesign)this;
	}
	
	public DeductionSchemeDesign addToDeductions(DeductionDesign item, int index) {
		deductions.insertValue(item, index);
		return (DeductionSchemeDesign)this;
	}
	
	public DeductionSchemeDesign removeFromDeductions(DeductionDesign item) {
		deductions.removeValue(item);
		return (DeductionSchemeDesign)this;
	}
	
	public DeductionSchemeDesign removeFromDeductions(int index) {
		deductions.removeValue(index);
		return (DeductionSchemeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> output
		= createRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> getOutputRelationValue() {
		return output;
	}

	public org.instantlogic.designer.DeductionDesign getOutput() {
		return output.getValue();
	}
	
	public DeductionSchemeDesign setOutput(org.instantlogic.designer.DeductionDesign newValue) {
		output.setValue(newValue);
		return (DeductionSchemeDesign)this;
	}


	// Reverse relations

}
