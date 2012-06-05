package org.instantlogic.designer;


public class SelectionDesign extends ElementDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
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


	// Reverse relations

}
