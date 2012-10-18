package org.instantlogic.designer;


public class AttributeDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, AttributeDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, AttributeDeductionDesign>();
	
	public static java.util.Map<String, AttributeDeductionDesign> getStaticAttributeDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static AttributeDeductionDesign addStaticInstance(String name, AttributeDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.AttributeDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDeductionDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.AttributeDeductionDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDeductionDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public AttributeDeductionDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (AttributeDeductionDesign)this;
	}
	
	public org.instantlogic.designer.AttributeDesign newAttribute() {
		org.instantlogic.designer.AttributeDesign newValue = new org.instantlogic.designer.AttributeDesign(); 
		attribute.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
