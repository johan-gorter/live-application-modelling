package org.instantlogic.designer;


public class StringProducerDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.StringProducerDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<StringProducerDesign, TemplatedTextDesign> untranslatedInTemplate
		= createReverseRelationValue(org.instantlogic.designer.entity.StringProducerDesignEntity.untranslatedInTemplate);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<StringProducerDesign, TemplatedTextDesign> getUntranslatedInTemplateRelation() {
		return untranslatedInTemplate;
	}

	public org.instantlogic.designer.TemplatedTextDesign getUntranslatedInTemplate() {
		return untranslatedInTemplate.get();
	}


}
