package org.instantlogic.designer;


public class TemplatedTextDesign extends TextDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.TemplatedTextDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<TemplatedTextDesign, StringProducerDesign> untranslated
		= createRelationValues(org.instantlogic.designer.entity.TemplatedTextDesignEntity.untranslated);
		
	public org.instantlogic.fabric.value.RelationValues<TemplatedTextDesign, StringProducerDesign> getUntranslatedRelationValue() {
		return untranslated;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StringProducerDesign> getUntranslated() {
		return untranslated.getValue();
	}
	
	public TemplatedTextDesign addToUntranslated(StringProducerDesign item) {
		untranslated.addValue(item);
		return (TemplatedTextDesign)this;
	}
	
	public TemplatedTextDesign addToUntranslated(StringProducerDesign item, int index) {
		untranslated.insertValue(item, index);
		return (TemplatedTextDesign)this;
	}
	
	public TemplatedTextDesign removeFromUntranslated(StringProducerDesign item) {
		untranslated.removeValue(item);
		return (TemplatedTextDesign)this;
	}
	
	public TemplatedTextDesign removeFromUntranslated(int index) {
		untranslated.removeValue(index);
		return (TemplatedTextDesign)this;
	}
	

	// Reverse relations

}
