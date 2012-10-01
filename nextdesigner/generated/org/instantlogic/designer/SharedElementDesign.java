package org.instantlogic.designer;


public class SharedElementDesign extends ElementDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedElementDefinitionDesign> definition
		= createRelationValue(org.instantlogic.designer.entity.SharedElementDesignEntity.definition);
		
	public org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedElementDefinitionDesign> getDefinitionRelationValue() {
		return definition;
	}

	public org.instantlogic.designer.SharedElementDefinitionDesign getDefinition() {
		return definition.getValue();
	}
	
	public SharedElementDesign setDefinition(org.instantlogic.designer.SharedElementDefinitionDesign newValue) {
		definition.setValue(newValue);
		return (SharedElementDesign)this;
	}


	// Reverse relations

}
