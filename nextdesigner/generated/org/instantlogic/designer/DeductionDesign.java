package org.instantlogic.designer;


public class DeductionDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> className
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.className);
	
	public java.lang.String getClassName() {
		return className.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> getClassNameAttributeValue() {
		return className;
	}

	public DeductionDesign setClassName(java.lang.String newValue) {
		className.setValue(newValue);
		return (DeductionDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> customization
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> getCustomizationAttributeValue() {
		return customization;
	}

	public DeductionDesign setCustomization(java.lang.String newValue) {
		customization.setValue(newValue);
		return (DeductionDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Boolean> multivalue
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Boolean> getMultivalueAttributeValue() {
		return multivalue;
	}

	public DeductionDesign setMultivalue(java.lang.Boolean newValue) {
		multivalue.setValue(newValue);
		return (DeductionDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> inputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.inputs);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> getInputsRelationValue() {
		return inputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign> getInputs() {
		return inputs.getValue();
	}
	
	public DeductionDesign addToInputs(DeductionDesign item) {
		inputs.addValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign addToInputs(DeductionDesign item, int index) {
		inputs.insertValue(item, index);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromInputs(DeductionDesign item) {
		inputs.removeValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromInputs(int index) {
		inputs.removeValue(index);
		return (DeductionDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<DeductionDesign, DeductionDesign> outputs
		= createReverseRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.outputs);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<DeductionDesign, DeductionDesign> getOutputsRelationValue() {
		return outputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign> getOutputs() {
		return outputs.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> scheme
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.scheme);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> getSchemeRelationValue() {
		return scheme;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getScheme() {
		return scheme.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> schemeOutput
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.schemeOutput);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> getSchemeOutputRelationValue() {
		return schemeOutput;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getSchemeOutput() {
		return schemeOutput.getValue();
	}


}
