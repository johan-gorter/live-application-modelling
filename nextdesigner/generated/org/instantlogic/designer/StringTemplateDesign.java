package org.instantlogic.designer;


public class StringTemplateDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.StringTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<StringTemplateDesign, java.lang.String> constantText
		= createAttributeValue(org.instantlogic.designer.entity.StringTemplateDesignEntity.constantText);
	
	public java.lang.String getConstantText() {
		return constantText.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<StringTemplateDesign, java.lang.String> getConstantTextAttributeValue() {
		return constantText;
	}

	public StringTemplateDesign setConstantText(java.lang.String newValue) {
		constantText.setValue(newValue);
		return (StringTemplateDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<StringTemplateDesign, DeductionSchemeDesign> deduction
		= createRelationValue(org.instantlogic.designer.entity.StringTemplateDesignEntity.deduction);
		
	public org.instantlogic.fabric.value.RelationValue<StringTemplateDesign, DeductionSchemeDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.getValue();
	}
	
	public StringTemplateDesign setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
		return (StringTemplateDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<StringTemplateDesign, TextTemplateDesign> untranslatedInTemplate
		= createReverseRelationValue(org.instantlogic.designer.entity.StringTemplateDesignEntity.untranslatedInTemplate);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<StringTemplateDesign, TextTemplateDesign> getUntranslatedInTemplateRelationValue() {
		return untranslatedInTemplate;
	}

	public org.instantlogic.designer.TextTemplateDesign getUntranslatedInTemplate() {
		return untranslatedInTemplate.getValue();
	}


}
