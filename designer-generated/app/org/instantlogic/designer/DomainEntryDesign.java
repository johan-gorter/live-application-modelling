package org.instantlogic.designer;


public class DomainEntryDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DomainEntryDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DomainEntryDesign, TextDesign> display
		= createRelationValue(org.instantlogic.designer.entity.DomainEntryDesignEntity.display);
		
	public org.instantlogic.fabric.value.RelationValue<DomainEntryDesign, TextDesign> getDisplayRelationValue() {
		return display;
	}

	public org.instantlogic.designer.TextDesign getDisplay() {
		return display.getValue();
	}
	
	public DomainEntryDesign setDisplay(org.instantlogic.designer.TextDesign newValue) {
		display.setValue(newValue);
		return (DomainEntryDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DomainEntryDesign, AttributeDesign> attribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DomainEntryDesignEntity.attribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DomainEntryDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}


}
