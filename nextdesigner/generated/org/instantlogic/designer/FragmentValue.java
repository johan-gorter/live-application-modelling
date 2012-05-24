package org.instantlogic.designer;


public class FragmentValue extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FragmentValueEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentValue, DeductionSchemeDesign> deduction
		= createRelationValue(org.instantlogic.designer.entity.FragmentValueEntity.deduction);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentValue, DeductionSchemeDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.getValue();
	}
	
	public FragmentValue setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
		return (FragmentValue)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentValue, FragmentTemplateDesign> fragment
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentValueEntity.fragment);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentValue, FragmentTemplateDesign> getFragmentRelationValue() {
		return fragment;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getFragment() {
		return fragment.getValue();
	}


}
