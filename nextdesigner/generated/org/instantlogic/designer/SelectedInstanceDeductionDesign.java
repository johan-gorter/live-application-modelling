package org.instantlogic.designer;


public class SelectedInstanceDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, SelectedInstanceDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, SelectedInstanceDeductionDesign>();
	
	public static java.util.Map<String, SelectedInstanceDeductionDesign> getStaticSelectedInstanceDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static SelectedInstanceDeductionDesign addStaticInstance(String name, SelectedInstanceDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> ofEntity
		= createRelationValue(org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.ofEntity);
		
	public org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> getOfEntityRelationValue() {
		return ofEntity;
	}

	public org.instantlogic.designer.EntityDesign getOfEntity() {
		return ofEntity.getValue();
	}
	
	public SelectedInstanceDeductionDesign setOfEntity(org.instantlogic.designer.EntityDesign newValue) {
		ofEntity.setValue(newValue);
		return (SelectedInstanceDeductionDesign)this;
	}
	
	public org.instantlogic.designer.EntityDesign newOfEntity() {
		org.instantlogic.designer.EntityDesign newValue = new org.instantlogic.designer.EntityDesign(); 
		ofEntity.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
