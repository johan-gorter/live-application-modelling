package org.instantlogic.designer;


public class SharedFragmentTemplateDefinitionDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedFragmentTemplateDefinitionDesign, ElementDesign> fragment
		= createRelationValue(org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.fragment);
		
	public org.instantlogic.fabric.value.RelationValue<SharedFragmentTemplateDefinitionDesign, ElementDesign> getFragmentRelationValue() {
		return fragment;
	}

	public org.instantlogic.designer.ElementDesign getFragment() {
		return fragment.getValue();
	}
	
	public SharedFragmentTemplateDefinitionDesign setFragment(org.instantlogic.designer.ElementDesign newValue) {
		fragment.setValue(newValue);
		return (SharedFragmentTemplateDefinitionDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedFragmentTemplateDefinitionDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<SharedFragmentTemplateDefinitionDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public SharedFragmentTemplateDefinitionDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (SharedFragmentTemplateDefinitionDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<SharedFragmentTemplateDefinitionDesign, SharedElementDesign> usages
		= createReverseRelationValues(org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.usages);

	public org.instantlogic.fabric.value.RelationValues<SharedFragmentTemplateDefinitionDesign, SharedElementDesign> getUsagesRelationValue() {
		return usages;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDesign> getUsages() {
		return usages.getValue();
	}

    public SharedFragmentTemplateDefinitionDesign addToUsages(SharedElementDesign item) {
        usages.addValue(item);
        return (SharedFragmentTemplateDefinitionDesign)this;
    }

    public SharedFragmentTemplateDefinitionDesign removeFromUsages(SharedElementDesign item) {
        usages.removeValue(item);
        return (SharedFragmentTemplateDefinitionDesign)this;
    }


}
