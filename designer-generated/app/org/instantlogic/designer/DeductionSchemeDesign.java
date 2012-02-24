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
		
	public org.instantlogic.fabric.value.RelationValues<DeductionSchemeDesign, DeductionDesign> getDeductionsRelation() {
		return deductions;
	}

	public java.util.List<org.instantlogic.designer.DeductionDesign> getDeductions() {
		return deductions.get();
	}
	
	public void setDeductions(java.util.List<org.instantlogic.designer.DeductionDesign> newValue) {
		deductions.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> output
		= createRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> getOutputRelation() {
		return output;
	}

	public org.instantlogic.designer.DeductionDesign getOutput() {
		return output.get();
	}
	
	public void setOutput(org.instantlogic.designer.DeductionDesign newValue) {
		output.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> relevanceOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.relevanceOfAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> getRelevanceOfAttributeRelation() {
		return relevanceOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRelevanceOfAttribute() {
		return relevanceOfAttribute.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> ruleOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleOfAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> getRuleOfAttributeRelation() {
		return ruleOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRuleOfAttribute() {
		return ruleOfAttribute.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> defaultOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.defaultOfAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> getDefaultOfAttributeRelation() {
		return defaultOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getDefaultOfAttribute() {
		return defaultOfAttribute.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, FormattedValueDesign> templatedText
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.templatedText);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, FormattedValueDesign> getTemplatedTextRelation() {
		return templatedText;
	}

	public org.instantlogic.designer.FormattedValueDesign getTemplatedText() {
		return templatedText.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, SelectDesign> select
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.select);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, SelectDesign> getSelectRelation() {
		return select;
	}

	public org.instantlogic.designer.SelectDesign getSelect() {
		return select.get();
	}


}
