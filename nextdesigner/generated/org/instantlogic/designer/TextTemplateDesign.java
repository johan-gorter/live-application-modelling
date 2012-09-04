package org.instantlogic.designer;


public class TextTemplateDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<TextTemplateDesign, StringTemplateDesign> untranslated
		= createRelationValues(org.instantlogic.designer.entity.TextTemplateDesignEntity.untranslated);
		
	public org.instantlogic.fabric.value.RelationValues<TextTemplateDesign, StringTemplateDesign> getUntranslatedRelationValue() {
		return untranslated;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StringTemplateDesign> getUntranslated() {
		return untranslated.getValue();
	}
	
	public TextTemplateDesign addToUntranslated(StringTemplateDesign item) {
		untranslated.addValue(item);
		return (TextTemplateDesign)this;
	}
	
	public TextTemplateDesign addToUntranslated(StringTemplateDesign item, int index) {
		untranslated.insertValue(item, index);
		return (TextTemplateDesign)this;
	}
	
	public TextTemplateDesign removeFromUntranslated(StringTemplateDesign item) {
		untranslated.removeValue(item);
		return (TextTemplateDesign)this;
	}
	
	public TextTemplateDesign removeFromUntranslated(int index) {
		untranslated.removeValue(index);
		return (TextTemplateDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, StaticInstanceDesign> descriptionOnStaticInstance
		= createReverseRelationValue(org.instantlogic.designer.entity.TextTemplateDesignEntity.descriptionOnStaticInstance);

	public org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, StaticInstanceDesign> getDescriptionOnStaticInstanceRelationValue() {
		return descriptionOnStaticInstance;
	}

	public org.instantlogic.designer.StaticInstanceDesign getDescriptionOnStaticInstance() {
		return descriptionOnStaticInstance.getValue();
	}

    public TextTemplateDesign setDescriptionOnStaticInstance(org.instantlogic.designer.StaticInstanceDesign newValue) {
        descriptionOnStaticInstance.setValue(newValue);
        return (TextTemplateDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, DomainEntryDesign> displayOnDomainEntry
		= createReverseRelationValue(org.instantlogic.designer.entity.TextTemplateDesignEntity.displayOnDomainEntry);

	public org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, DomainEntryDesign> getDisplayOnDomainEntryRelationValue() {
		return displayOnDomainEntry;
	}

	public org.instantlogic.designer.DomainEntryDesign getDisplayOnDomainEntry() {
		return displayOnDomainEntry.getValue();
	}

    public TextTemplateDesign setDisplayOnDomainEntry(org.instantlogic.designer.DomainEntryDesign newValue) {
        displayOnDomainEntry.setValue(newValue);
        return (TextTemplateDesign)this;
    }


}
