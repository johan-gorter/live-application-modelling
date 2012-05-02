package org.instantlogic.designer;


public class LinkDesign extends FragmentTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.LinkDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<LinkDesign, TextDesign> caption
		= createRelationValue(org.instantlogic.designer.entity.LinkDesignEntity.caption);
		
	public org.instantlogic.fabric.value.RelationValue<LinkDesign, TextDesign> getCaptionRelationValue() {
		return caption;
	}

	public org.instantlogic.designer.TextDesign getCaption() {
		return caption.getValue();
	}
	
	public LinkDesign setCaption(org.instantlogic.designer.TextDesign newValue) {
		caption.setValue(newValue);
		return (LinkDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<LinkDesign, EventDesign> event
		= createRelationValue(org.instantlogic.designer.entity.LinkDesignEntity.event);
		
	public org.instantlogic.fabric.value.RelationValue<LinkDesign, EventDesign> getEventRelationValue() {
		return event;
	}

	public org.instantlogic.designer.EventDesign getEvent() {
		return event.getValue();
	}
	
	public LinkDesign setEvent(org.instantlogic.designer.EventDesign newValue) {
		event.setValue(newValue);
		return (LinkDesign)this;
	}


	// Reverse relations

}
