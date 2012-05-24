package org.instantlogic.designer;


public class PlaceTemplateDesign extends FlowNodeBaseDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, FragmentTemplateDesign> content
		= createRelationValue(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		
	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, FragmentTemplateDesign> getContentRelationValue() {
		return content;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getContent() {
		return content.getValue();
	}
	
	public PlaceTemplateDesign setContent(org.instantlogic.designer.FragmentTemplateDesign newValue) {
		content.setValue(newValue);
		return (PlaceTemplateDesign)this;
	}


	// Reverse relations

}
