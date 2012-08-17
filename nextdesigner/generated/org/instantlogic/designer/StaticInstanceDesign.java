package org.instantlogic.designer;


public class StaticInstanceDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<StaticInstanceDesign, TextTemplateDesign> description
		= createRelationValue(org.instantlogic.designer.entity.StaticInstanceDesignEntity.description);
		
	public org.instantlogic.fabric.value.RelationValue<StaticInstanceDesign, TextTemplateDesign> getDescriptionRelationValue() {
		return description;
	}

	public org.instantlogic.designer.TextTemplateDesign getDescription() {
		return description.getValue();
	}
	
	public StaticInstanceDesign setDescription(org.instantlogic.designer.TextTemplateDesign newValue) {
		description.setValue(newValue);
		return (StaticInstanceDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<StaticInstanceDesign, EntityDesign> entity
		= createReverseRelationValue(org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<StaticInstanceDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}


}
