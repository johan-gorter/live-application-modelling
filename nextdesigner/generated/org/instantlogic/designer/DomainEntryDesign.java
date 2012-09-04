package org.instantlogic.designer;


public class DomainEntryDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DomainEntryDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DomainEntryDesign, TextTemplateDesign> display
		= createRelationValue(org.instantlogic.designer.entity.DomainEntryDesignEntity.display);
		
	public org.instantlogic.fabric.value.RelationValue<DomainEntryDesign, TextTemplateDesign> getDisplayRelationValue() {
		return display;
	}

	public org.instantlogic.designer.TextTemplateDesign getDisplay() {
		return display.getValue();
	}
	
	public DomainEntryDesign setDisplay(org.instantlogic.designer.TextTemplateDesign newValue) {
		display.setValue(newValue);
		return (DomainEntryDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DomainEntryDesign, AttributeDesign> attributes
		= createReverseRelationValue(org.instantlogic.designer.entity.DomainEntryDesignEntity.attributes);

	public org.instantlogic.fabric.value.RelationValue<DomainEntryDesign, AttributeDesign> getAttributesRelationValue() {
		return attributes;
	}

	public org.instantlogic.designer.AttributeDesign getAttributes() {
		return attributes.getValue();
	}

    public DomainEntryDesign setAttributes(org.instantlogic.designer.AttributeDesign newValue) {
        attributes.setValue(newValue);
        return (DomainEntryDesign)this;
    }


}
