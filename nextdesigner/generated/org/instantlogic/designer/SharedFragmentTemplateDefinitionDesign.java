package org.instantlogic.designer;


public class SharedFragmentTemplateDefinitionDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedFragmentTemplateDefinitionDesign, FragmentTemplateDesign> fragment
		= createRelationValue(org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.fragment);
		
	public org.instantlogic.fabric.value.RelationValue<SharedFragmentTemplateDefinitionDesign, FragmentTemplateDesign> getFragmentRelationValue() {
		return fragment;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getFragment() {
		return fragment.getValue();
	}
	
	public SharedFragmentTemplateDefinitionDesign setFragment(org.instantlogic.designer.FragmentTemplateDesign newValue) {
		fragment.setValue(newValue);
		return (SharedFragmentTemplateDefinitionDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<SharedFragmentTemplateDefinitionDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<SharedFragmentTemplateDefinitionDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<SharedFragmentTemplateDefinitionDesign, SharedTemplateDesign> usages
		= createReverseRelationValues(org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.usages);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<SharedFragmentTemplateDefinitionDesign, SharedTemplateDesign> getUsagesRelationValue() {
		return usages;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedTemplateDesign> getUsages() {
		return usages.getValue();
	}


}
