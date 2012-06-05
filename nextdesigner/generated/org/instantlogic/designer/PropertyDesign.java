package org.instantlogic.designer;


public class PropertyDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.String> name
		= createAttributeValue(org.instantlogic.designer.entity.PropertyDesignEntity.name);
	
	public java.lang.String getName() {
		return name.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.String> getNameAttributeValue() {
		return name;
	}

	public PropertyDesign setName(java.lang.String newValue) {
		name.setValue(newValue);
		return (PropertyDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<PropertyDesign, ElementDesign> children
		= createRelationValues(org.instantlogic.designer.entity.PropertyDesignEntity.children);
		
	public org.instantlogic.fabric.value.RelationValues<PropertyDesign, ElementDesign> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign> getChildren() {
		return children.getValue();
	}
	
	public PropertyDesign addToChildren(ElementDesign item) {
		children.addValue(item);
		return (PropertyDesign)this;
	}
	
	public PropertyDesign addToChildren(ElementDesign item, int index) {
		children.insertValue(item, index);
		return (PropertyDesign)this;
	}
	
	public PropertyDesign removeFromChildren(ElementDesign item) {
		children.removeValue(item);
		return (PropertyDesign)this;
	}
	
	public PropertyDesign removeFromChildren(int index) {
		children.removeValue(index);
		return (PropertyDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<PropertyDesign, DeductionSchemeDesign> deduction
		= createRelationValue(org.instantlogic.designer.entity.PropertyDesignEntity.deduction);
		
	public org.instantlogic.fabric.value.RelationValue<PropertyDesign, DeductionSchemeDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.getValue();
	}
	
	public PropertyDesign setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
		return (PropertyDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<PropertyDesign, TextDesign> text
		= createRelationValue(org.instantlogic.designer.entity.PropertyDesignEntity.text);
		
	public org.instantlogic.fabric.value.RelationValue<PropertyDesign, TextDesign> getTextRelationValue() {
		return text;
	}

	public org.instantlogic.designer.TextDesign getText() {
		return text.getValue();
	}
	
	public PropertyDesign setText(org.instantlogic.designer.TextDesign newValue) {
		text.setValue(newValue);
		return (PropertyDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<PropertyDesign, FragmentTemplateDesign> fragment
		= createReverseRelationValue(org.instantlogic.designer.entity.PropertyDesignEntity.fragment);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<PropertyDesign, FragmentTemplateDesign> getFragmentRelationValue() {
		return fragment;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getFragment() {
		return fragment.getValue();
	}


}
