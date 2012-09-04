package org.instantlogic.designer;


public abstract class AbstractEntityDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> attributes
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> getAttributesRelationValue() {
		return attributes;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign> getAttributes() {
		return attributes.getValue();
	}
	
	public EntityDesign addToAttributes(AttributeDesign item) {
		attributes.addValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign addToAttributes(AttributeDesign item, int index) {
		attributes.insertValue(item, index);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromAttributes(AttributeDesign item) {
		attributes.removeValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromAttributes(int index) {
		attributes.removeValue(index);
		return (EntityDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, EntityDesign> extendsFrom
		= createRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom);
		
	public org.instantlogic.fabric.value.RelationValue<EntityDesign, EntityDesign> getExtendsFromRelationValue() {
		return extendsFrom;
	}

	public org.instantlogic.designer.EntityDesign getExtendsFrom() {
		return extendsFrom.getValue();
	}
	
	public EntityDesign setExtendsFrom(org.instantlogic.designer.EntityDesign newValue) {
		extendsFrom.setValue(newValue);
		return (EntityDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> relations
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.relations);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> getRelationsRelationValue() {
		return relations;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign> getRelations() {
		return relations.getValue();
	}
	
	public EntityDesign addToRelations(RelationDesign item) {
		relations.addValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign addToRelations(RelationDesign item, int index) {
		relations.insertValue(item, index);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromRelations(RelationDesign item) {
		relations.removeValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromRelations(int index) {
		relations.removeValue(index);
		return (EntityDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, StaticInstanceDesign> staticInstances
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.staticInstances);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, StaticInstanceDesign> getStaticInstancesRelationValue() {
		return staticInstances;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceDesign> getStaticInstances() {
		return staticInstances.getValue();
	}
	
	public EntityDesign addToStaticInstances(StaticInstanceDesign item) {
		staticInstances.addValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign addToStaticInstances(StaticInstanceDesign item, int index) {
		staticInstances.insertValue(item, index);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromStaticInstances(StaticInstanceDesign item) {
		staticInstances.removeValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromStaticInstances(int index) {
		staticInstances.removeValue(index);
		return (EntityDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<EntityDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public EntityDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, ApplicationDesign> caseEntityInApplication
		= createReverseRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.caseEntityInApplication);

	public org.instantlogic.fabric.value.RelationValue<EntityDesign, ApplicationDesign> getCaseEntityInApplicationRelationValue() {
		return caseEntityInApplication;
	}

	public org.instantlogic.designer.ApplicationDesign getCaseEntityInApplication() {
		return caseEntityInApplication.getValue();
	}

    public EntityDesign setCaseEntityInApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        caseEntityInApplication.setValue(newValue);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, CastInstanceDeductionDesign> entityInCastDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.entityInCastDeductions);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, CastInstanceDeductionDesign> getEntityInCastDeductionsRelationValue() {
		return entityInCastDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.CastInstanceDeductionDesign> getEntityInCastDeductions() {
		return entityInCastDeductions.getValue();
	}

    public EntityDesign addToEntityInCastDeductions(CastInstanceDeductionDesign item) {
        entityInCastDeductions.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromEntityInCastDeductions(CastInstanceDeductionDesign item) {
        entityInCastDeductions.removeValue(item);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, SelectedInstanceDeductionDesign> entityInSelectedInstanceDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.entityInSelectedInstanceDeductions);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, SelectedInstanceDeductionDesign> getEntityInSelectedInstanceDeductionsRelationValue() {
		return entityInSelectedInstanceDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SelectedInstanceDeductionDesign> getEntityInSelectedInstanceDeductions() {
		return entityInSelectedInstanceDeductions.getValue();
	}

    public EntityDesign addToEntityInSelectedInstanceDeductions(SelectedInstanceDeductionDesign item) {
        entityInSelectedInstanceDeductions.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromEntityInSelectedInstanceDeductions(SelectedInstanceDeductionDesign item) {
        entityInSelectedInstanceDeductions.removeValue(item);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, EntityDesign> extensions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.extensions);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, EntityDesign> getExtensionsRelationValue() {
		return extensions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getExtensions() {
		return extensions.getValue();
	}

    public EntityDesign addToExtensions(EntityDesign item) {
        extensions.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromExtensions(EntityDesign item) {
        extensions.removeValue(item);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, EventDesign> parameterInEvent
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.parameterInEvent);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, EventDesign> getParameterInEventRelationValue() {
		return parameterInEvent;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign> getParameterInEvent() {
		return parameterInEvent.getValue();
	}

    public EntityDesign addToParameterInEvent(EventDesign item) {
        parameterInEvent.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromParameterInEvent(EventDesign item) {
        parameterInEvent.removeValue(item);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, FlowDesign> parameterInFlows
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.parameterInFlows);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, FlowDesign> getParameterInFlowsRelationValue() {
		return parameterInFlows;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign> getParameterInFlows() {
		return parameterInFlows.getValue();
	}

    public EntityDesign addToParameterInFlows(FlowDesign item) {
        parameterInFlows.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromParameterInFlows(FlowDesign item) {
        parameterInFlows.removeValue(item);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> reverseRelations
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> getReverseRelationsRelationValue() {
		return reverseRelations;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign> getReverseRelations() {
		return reverseRelations.getValue();
	}

    public EntityDesign addToReverseRelations(RelationDesign item) {
        reverseRelations.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromReverseRelations(RelationDesign item) {
        reverseRelations.removeValue(item);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, FragmentTemplateDesign> usedInField
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.usedInField);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, FragmentTemplateDesign> getUsedInFieldRelationValue() {
		return usedInField;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign> getUsedInField() {
		return usedInField.getValue();
	}

    public EntityDesign addToUsedInField(FragmentTemplateDesign item) {
        usedInField.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromUsedInField(FragmentTemplateDesign item) {
        usedInField.removeValue(item);
        return (EntityDesign)this;
    }


}
