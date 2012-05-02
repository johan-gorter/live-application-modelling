package org.instantlogic.designer;


public class CompositeTemplateDesign extends FragmentTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CompositeTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<CompositeTemplateDesign, FragmentTemplateDesign> children
		= createRelationValues(org.instantlogic.designer.entity.CompositeTemplateDesignEntity.children);
		
	public org.instantlogic.fabric.value.RelationValues<CompositeTemplateDesign, FragmentTemplateDesign> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign> getChildren() {
		return children.getValue();
	}
	
	public CompositeTemplateDesign addToChildren(FragmentTemplateDesign item) {
		children.addValue(item);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign addToChildren(FragmentTemplateDesign item, int index) {
		children.insertValue(item, index);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign removeFromChildren(FragmentTemplateDesign item) {
		children.removeValue(item);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign removeFromChildren(int index) {
		children.removeValue(index);
		return (CompositeTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<CompositeTemplateDesign, DeductionSchemeDesign> selections
		= createRelationValues(org.instantlogic.designer.entity.CompositeTemplateDesignEntity.selections);
		
	public org.instantlogic.fabric.value.RelationValues<CompositeTemplateDesign, DeductionSchemeDesign> getSelectionsRelationValue() {
		return selections;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionSchemeDesign> getSelections() {
		return selections.getValue();
	}
	
	public CompositeTemplateDesign addToSelections(DeductionSchemeDesign item) {
		selections.addValue(item);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign addToSelections(DeductionSchemeDesign item, int index) {
		selections.insertValue(item, index);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign removeFromSelections(DeductionSchemeDesign item) {
		selections.removeValue(item);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign removeFromSelections(int index) {
		selections.removeValue(index);
		return (CompositeTemplateDesign)this;
	}
	

	// Reverse relations

}
