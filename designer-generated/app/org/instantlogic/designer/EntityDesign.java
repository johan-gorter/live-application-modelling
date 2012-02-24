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
		return extendsFrom.get();
	}
	
	public void setExtendsFrom(org.instantlogic.designer.EntityDesign newValue) {
		extendsFrom.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> attributes
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> getAttributesRelation() {
		return attributes;
	}

	public java.util.List<org.instantlogic.designer.AttributeDesign> getAttributes() {
		return attributes.get();
	}
	
	public void setAttributes(java.util.List<org.instantlogic.designer.AttributeDesign> newValue) {
		attributes.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> relations
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.relations);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> getRelationsRelation() {
		return relations;
	}

	public java.util.List<org.instantlogic.designer.RelationDesign> getRelations() {
		return relations.get();
	}
	
	public void setRelations(java.util.List<org.instantlogic.designer.RelationDesign> newValue) {
		relations.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> getApplicationRelation() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> caseEntityInApplication
		= createReverseRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.caseEntityInApplication);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<EntityDesign, ApplicationDesign> getCaseEntityInApplicationRelation() {
		return caseEntityInApplication;
	}

	public org.instantlogic.designer.ApplicationDesign getCaseEntityInApplication() {
		return caseEntityInApplication.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EntityDesign> extensions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.extensions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EntityDesign> getExtensionsRelation() {
		return extensions;
	}

	public java.util.List<org.instantlogic.designer.EntityDesign> getExtensions() {
		return extensions.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, RelationDesign> reverseRelations
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, RelationDesign> getReverseRelationsRelation() {
		return reverseRelations;
	}

	public java.util.List<org.instantlogic.designer.RelationDesign> getReverseRelations() {
		return reverseRelations.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, SelectedInstanceDeductionDesign> entityInSelectedInstanceDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.entityInSelectedInstanceDeductions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, SelectedInstanceDeductionDesign> getEntityInSelectedInstanceDeductionsRelation() {
		return entityInSelectedInstanceDeductions;
	}

	public java.util.List<org.instantlogic.designer.SelectedInstanceDeductionDesign> getEntityInSelectedInstanceDeductions() {
		return entityInSelectedInstanceDeductions.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, CastInstanceDeductionDesign> entityInCastDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.entityInCastDeductions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, CastInstanceDeductionDesign> getEntityInCastDeductionsRelation() {
		return entityInCastDeductions;
	}

	public java.util.List<org.instantlogic.designer.CastInstanceDeductionDesign> getEntityInCastDeductions() {
		return entityInCastDeductions.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EventDesign> parameterInEvent
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.parameterInEvent);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, EventDesign> getParameterInEventRelation() {
		return parameterInEvent;
	}

	public java.util.List<org.instantlogic.designer.EventDesign> getParameterInEvent() {
		return parameterInEvent.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, FlowDesign> parameterInFlows
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.parameterInFlows);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EntityDesign, FlowDesign> getParameterInFlowsRelation() {
		return parameterInFlows;
	}

	public java.util.List<org.instantlogic.designer.FlowDesign> getParameterInFlows() {
		return parameterInFlows.get();
	}


}
