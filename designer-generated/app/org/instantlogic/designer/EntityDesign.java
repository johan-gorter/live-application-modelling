package org.instantlogic.designer;


public class EntityDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, EntityDesign> extendsFrom
		= createRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom);
		
	public org.instantlogic.fabric.value.RelationValue<EntityDesign, EntityDesign> getExtendsFromRelation() {
		return extendsFrom;
	}

	public org.instantlogic.designer.EntityDesign getExtendsFrom() {
		return extendsFrom.getValue();
	}
	
	public void setExtendsFrom(org.instantlogic.designer.EntityDesign newValue) {
		extendsFrom.setValue(newValue);
	}

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> attributes
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> getAttributesRelation() {
		return attributes;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign> getAttributes() {
		return attributes.getValue();
	}
	
	public void addToAttributes(AttributeDesign item) {
		attributes.addValue(item);
	}
	
	public void addToAttributes(AttributeDesign item, int index) {
		attributes.insertValue(item, index);
	}
	
	public void removeFromAttributes(AttributeDesign item) {
		attributes.removeValue(item);
	}
	
	public void removeFromAttributes(int index) {
		attributes.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> relations
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.relations);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> getRelationsRelation() {
		return relations;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign> getRelations() {
		return relations.getValue();
	}
	
	public void addToRelations(RelationDesign item) {
		relations.addValue(item);
	}
	
	public void addToRelations(RelationDesign item, int index) {
		relations.insertValue(item, index);
	}
	
	public void removeFromRelations(RelationDesign item) {
		relations.removeValue(item);
	}
	
	public void removeFromRelations(int index) {
		relations.removeValue(index);
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> getApplicationRelation() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> caseEntityInApplication
		= createReverseRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.caseEntityInApplication);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> getCaseEntityInApplicationRelation() {
		return caseEntityInApplication;
	}

	public org.instantlogic.designer.ApplicationDesign getCaseEntityInApplication() {
		return caseEntityInApplication.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EntityDesign> extensions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.extensions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EntityDesign> getExtensionsRelation() {
		return extensions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getExtensions() {
		return extensions.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, RelationDesign> reverseRelations
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, RelationDesign> getReverseRelationsRelation() {
		return reverseRelations;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign> getReverseRelations() {
		return reverseRelations.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, SelectedInstanceDeductionDesign> entityInSelectedInstanceDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.entityInSelectedInstanceDeductions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, SelectedInstanceDeductionDesign> getEntityInSelectedInstanceDeductionsRelation() {
		return entityInSelectedInstanceDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SelectedInstanceDeductionDesign> getEntityInSelectedInstanceDeductions() {
		return entityInSelectedInstanceDeductions.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, CastInstanceDeductionDesign> entityInCastDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.entityInCastDeductions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, CastInstanceDeductionDesign> getEntityInCastDeductionsRelation() {
		return entityInCastDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.CastInstanceDeductionDesign> getEntityInCastDeductions() {
		return entityInCastDeductions.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EventDesign> parameterInEvent
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.parameterInEvent);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EventDesign> getParameterInEventRelation() {
		return parameterInEvent;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign> getParameterInEvent() {
		return parameterInEvent.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, FlowDesign> parameterInFlows
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.parameterInFlows);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, FlowDesign> getParameterInFlowsRelation() {
		return parameterInFlows;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign> getParameterInFlows() {
		return parameterInFlows.getValue();
	}


}
