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

	public java.util.List<org.instantlogic.designer.StringProducerDesign> getUntranslated() {
		return untranslated.get();
	}
	
	public void setUntranslated(java.util.List<org.instantlogic.designer.StringProducerDesign> newValue) {
		untranslated.setValue(newValue);
	}

	// Reverse relations

}
