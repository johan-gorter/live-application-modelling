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
		
	public org.instantlogic.fabric.value.RelationValues<TemplatedTextDesign, StringProducerDesign> getUntranslatedRelation() {
		return untranslated;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StringProducerDesign> getUntranslated() {
		return untranslated.getValue();
	}
	
	public void addToUntranslated(StringProducerDesign item) {
		untranslated.addValue(item);
	}
	
	public void addToUntranslated(StringProducerDesign item, int index) {
		untranslated.insertValue(item, index);
	}
	
	public void removeFromUntranslated(StringProducerDesign item) {
		untranslated.removeValue(item);
	}
	
	public void removeFromUntranslated(int index) {
		untranslated.removeValue(index);
	}
	

	// Reverse relations

}
