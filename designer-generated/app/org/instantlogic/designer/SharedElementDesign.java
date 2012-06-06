package org.instantlogic.designer;


public class SharedElementDesign extends ElementDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedFragmentTemplateDefinitionDesign> definition
		= createRelationValue(org.instantlogic.designer.entity.SharedElementDesignEntity.definition);
		
	public org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedFragmentTemplateDefinitionDesign> getDefinitionRelationValue() {
		return definition;
	}

	public org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign getDefinition() {
		return definition.getValue();
	}
	
	public SharedElementDesign setDefinition(org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign newValue) {
		definition.setValue(newValue);
		return (SharedElementDesign)this;
	}


	// Reverse relations

}
