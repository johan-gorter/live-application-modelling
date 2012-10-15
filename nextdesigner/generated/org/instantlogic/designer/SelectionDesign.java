package org.instantlogic.designer;


public class SelectionDesign extends ElementDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<SelectionDesign, ElementDesign> children
		= createRelationValues(org.instantlogic.designer.entity.SelectionDesignEntity.children);
		
	public org.instantlogic.fabric.value.RelationValues<SelectionDesign, ElementDesign> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign> getChildren() {
		return children.getValue();
	}
	
	public SelectionDesign addToChildren(ElementDesign item) {
		children.addValue(item);
		return (SelectionDesign)this;
	}
	
	public SelectionDesign addToChildren(ElementDesign item, int index) {
		children.insertValue(item, index);
		return (SelectionDesign)this;
	}
	
	public SelectionDesign removeFromChildren(ElementDesign item) {
		children.removeValue(item);
		return (SelectionDesign)this;
	}
	
	public SelectionDesign removeFromChildren(int index) {
		children.removeValue(index);
		return (SelectionDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<SelectionDesign, DeductionSchemeDesign> selection
		= createRelationValue(org.instantlogic.designer.entity.SelectionDesignEntity.selection);
		
	public org.instantlogic.fabric.value.RelationValue<SelectionDesign, DeductionSchemeDesign> getSelectionRelationValue() {
		return selection;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getSelection() {
		return selection.getValue();
	}
	
	public SelectionDesign setSelection(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		selection.setValue(newValue);
		return (SelectionDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newSelection() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		selection.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
