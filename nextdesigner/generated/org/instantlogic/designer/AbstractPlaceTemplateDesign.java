package org.instantlogic.designer;


public abstract class AbstractPlaceTemplateDesign extends FlowNodeBaseDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ElementDesign> content
		= createRelationValue(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		
	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ElementDesign> getContentRelationValue() {
		return content;
	}

	public org.instantlogic.designer.ElementDesign getContent() {
		return content.getValue();
	}
	
	public PlaceTemplateDesign setContent(org.instantlogic.designer.ElementDesign newValue) {
		content.setValue(newValue);
		return (PlaceTemplateDesign)this;
	}


	// Reverse relations

}
