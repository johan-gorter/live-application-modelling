package org.instantlogic.designer;


public  class DeductionDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Boolean> multivalue
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Boolean> getMultivalueAttribute() {
		return multivalue;
	}


	public void setMultivalue(java.lang.Boolean newValue) {
		multivalue.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> className
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.className);
	
	public java.lang.String getClassName() {
		return className.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> getClassNameAttribute() {
		return className;
	}


	public void setClassName(java.lang.String newValue) {
		className.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> customization
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.String> getCustomizationAttribute() {
		return customization;
	}


	public void setCustomization(java.lang.String newValue) {
		customization.setValue(newValue);
	}
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> inputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.inputs);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> getInputsRelation() {
		return inputs;
	}

	public java.util.List<org.instantlogic.designer.DeductionDesign> getInputs() {
		return inputs.get();
	}
	
	public void setInputs(java.util.List<org.instantlogic.designer.DeductionDesign> newValue) {
		inputs.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> scheme
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.scheme);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> getSchemeRelation() {
		return scheme;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getScheme() {
		return scheme.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> schemeOutput
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.schemeOutput);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> getSchemeOutputRelation() {
		return schemeOutput;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getSchemeOutput() {
		return schemeOutput.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<DeductionDesign, DeductionDesign> outputs
		= createReverseRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.outputs);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<DeductionDesign, DeductionDesign> getOutputsRelation() {
		return outputs;
	}

	public java.util.List<org.instantlogic.designer.DeductionDesign> getOutputs() {
		return outputs.get();
	}


}
