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

}
