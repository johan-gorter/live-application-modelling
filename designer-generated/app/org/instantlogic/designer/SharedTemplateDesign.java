package org.instantlogic.designer;


public class SharedTemplateDesign extends FragmentTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SharedTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedTemplateDesign, SharedFragmentTemplateDefinitionDesign> definition
		= createRelationValue(org.instantlogic.designer.entity.SharedTemplateDesignEntity.definition);
		
	public org.instantlogic.fabric.value.RelationValue<SharedTemplateDesign, SharedFragmentTemplateDefinitionDesign> getDefinitionRelationValue() {
		return definition;
	}

	public org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign getDefinition() {
		return definition.getValue();
	}
	
	public SharedTemplateDesign setDefinition(org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign newValue) {
		definition.setValue(newValue);
		return (SharedTemplateDesign)this;
	}


	// Reverse relations

}
