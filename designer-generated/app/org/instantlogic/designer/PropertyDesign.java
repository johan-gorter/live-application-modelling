package org.instantlogic.designer;


public class PropertyDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.String> propertyName
		= createAttributeValue(org.instantlogic.designer.entity.PropertyDesignEntity.propertyName);
	
	public java.lang.String getPropertyName() {
		return propertyName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.String> getPropertyNameAttributeValue() {
		return propertyName;
	}

	public PropertyDesign setPropertyName(java.lang.String newValue) {
		propertyName.setValue(newValue);
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
	
	
	private final org.instantlogic.fabric.value.RelationValue<PropertyDesign, TextTemplateDesign> text
		= createRelationValue(org.instantlogic.designer.entity.PropertyDesignEntity.text);
		
	public org.instantlogic.fabric.value.RelationValue<PropertyDesign, TextTemplateDesign> getTextRelationValue() {
		return text;
	}

	public org.instantlogic.designer.TextTemplateDesign getText() {
		return text.getValue();
	}
	
	public PropertyDesign setText(org.instantlogic.designer.TextTemplateDesign newValue) {
		text.setValue(newValue);
		return (PropertyDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<PropertyDesign, DeductionSchemeDesign> value
		= createRelationValue(org.instantlogic.designer.entity.PropertyDesignEntity.value);
		
	public org.instantlogic.fabric.value.RelationValue<PropertyDesign, DeductionSchemeDesign> getValueRelationValue() {
		return value;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getValue() {
		return value.getValue();
	}
	
	public PropertyDesign setValue(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		value.setValue(newValue);
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
