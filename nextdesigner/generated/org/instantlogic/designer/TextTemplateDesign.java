package org.instantlogic.designer;


public class TextTemplateDesign extends Design { 

	private static final java.util.Map<String, TextTemplateDesign> _staticInstances = new java.util.LinkedHashMap<String, TextTemplateDesign>();
	
	public static java.util.Map<String, TextTemplateDesign> getStaticTextTemplateDesignInstances() {
		return _staticInstances;
	}
	
	private static TextTemplateDesign addStaticInstance(String name, TextTemplateDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}

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
	
	private final org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, PlaceTemplateDesign> titleOfPlaceTemplate
		= createReverseRelationValue(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfPlaceTemplate);

	public org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, PlaceTemplateDesign> getTitleOfPlaceTemplateRelationValue() {
		return titleOfPlaceTemplate;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getTitleOfPlaceTemplate() {
		return titleOfPlaceTemplate.getValue();
	}

    public TextTemplateDesign setTitleOfPlaceTemplate(org.instantlogic.designer.PlaceTemplateDesign newValue) {
        titleOfPlaceTemplate.setValue(newValue);
        return (TextTemplateDesign)this;
    }


}
