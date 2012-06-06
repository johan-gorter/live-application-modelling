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
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> defaultOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.defaultOfAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> getDefaultOfAttributeRelationValue() {
		return defaultOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getDefaultOfAttribute() {
		return defaultOfAttribute.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> relevanceOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.relevanceOfAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> getRelevanceOfAttributeRelationValue() {
		return relevanceOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRelevanceOfAttribute() {
		return relevanceOfAttribute.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> ruleOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleOfAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> getRuleOfAttributeRelationValue() {
		return ruleOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRuleOfAttribute() {
		return ruleOfAttribute.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, SelectionDesign> selection
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.selection);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, SelectionDesign> getSelectionRelationValue() {
		return selection;
	}

	public org.instantlogic.designer.SelectionDesign getSelection() {
		return selection.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, FormattedValueDesign> templatedText
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.templatedText);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, FormattedValueDesign> getTemplatedTextRelationValue() {
		return templatedText;
	}

	public org.instantlogic.designer.FormattedValueDesign getTemplatedText() {
		return templatedText.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, PropertyDesign> valueForFragment
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.valueForFragment);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionSchemeDesign, PropertyDesign> getValueForFragmentRelationValue() {
		return valueForFragment;
	}

	public org.instantlogic.designer.PropertyDesign getValueForFragment() {
		return valueForFragment.getValue();
	}


}
