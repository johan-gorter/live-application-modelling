package org.instantlogic.designer;


public class HeaderDesign extends CompositePageFragmentDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.HeaderDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<HeaderDesign, TextDesign> text
		= createRelationValue(org.instantlogic.designer.entity.HeaderDesignEntity.text);
		
	public org.instantlogic.fabric.value.RelationValue<HeaderDesign, TextDesign> getTextRelationValue() {
		return text;
	}

	public org.instantlogic.designer.TextDesign getText() {
		return text.getValue();
	}
	
	public HeaderDesign setText(org.instantlogic.designer.TextDesign newValue) {
		text.setValue(newValue);
		return (HeaderDesign)this;
	}


	// Reverse relations

}
