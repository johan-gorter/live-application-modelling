package org.instantlogic.designer;


public class FragmentText extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FragmentTextEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentText, TextDesign> text
		= createRelationValue(org.instantlogic.designer.entity.FragmentTextEntity.text);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentText, TextDesign> getTextRelationValue() {
		return text;
	}

	public org.instantlogic.designer.TextDesign getText() {
		return text.getValue();
	}
	
	public FragmentText setText(org.instantlogic.designer.TextDesign newValue) {
		text.setValue(newValue);
		return (FragmentText)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentText, FragmentTemplateDesign> fragment
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTextEntity.fragment);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentText, FragmentTemplateDesign> getFragmentRelationValue() {
		return fragment;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getFragment() {
		return fragment.getValue();
	}


}
