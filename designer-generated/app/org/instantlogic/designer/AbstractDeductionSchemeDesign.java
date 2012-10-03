package org.instantlogic.designer;


public abstract class AbstractDeductionSchemeDesign extends org.instantlogic.fabric.Instance { 

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
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> defaultOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.defaultOfAttribute);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> getDefaultOfAttributeRelationValue() {
		return defaultOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getDefaultOfAttribute() {
		return defaultOfAttribute.getValue();
	}

    public DeductionSchemeDesign setDefaultOfAttribute(org.instantlogic.designer.AttributeDesign newValue) {
        defaultOfAttribute.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> relevanceOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.relevanceOfAttribute);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> getRelevanceOfAttributeRelationValue() {
		return relevanceOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRelevanceOfAttribute() {
		return relevanceOfAttribute.getValue();
	}

    public DeductionSchemeDesign setRelevanceOfAttribute(org.instantlogic.designer.AttributeDesign newValue) {
        relevanceOfAttribute.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> ruleOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleOfAttribute);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> getRuleOfAttributeRelationValue() {
		return ruleOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRuleOfAttribute() {
		return ruleOfAttribute.getValue();
	}

    public DeductionSchemeDesign setRuleOfAttribute(org.instantlogic.designer.AttributeDesign newValue) {
        ruleOfAttribute.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }


}
