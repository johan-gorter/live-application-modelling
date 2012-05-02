package org.instantlogic.designer;


public class PlaceTemplateDesign extends FlowNodeBaseDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PlaceDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, CompositeTemplateDesign> content
		= createRelationValue(org.instantlogic.designer.entity.PlaceDesignEntity.content);
		
	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, CompositeTemplateDesign> getContentRelationValue() {
		return content;
	}

	public org.instantlogic.designer.CompositeTemplateDesign getContent() {
		return content.getValue();
	}
	
	public PlaceTemplateDesign setContent(org.instantlogic.designer.CompositeTemplateDesign newValue) {
		content.setValue(newValue);
		return (PlaceTemplateDesign)this;
	}


	// Reverse relations

}
