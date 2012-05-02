package org.instantlogic.designer;


public class CompositeTemplateDesign extends FragmentTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<CompositeTemplateDesign, PageCompositionDesign> items
		= createRelationValues(org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.items);
		
	public org.instantlogic.fabric.value.RelationValues<CompositeTemplateDesign, PageCompositionDesign> getItemsRelationValue() {
		return items;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign> getItems() {
		return items.getValue();
	}
	
	public CompositeTemplateDesign addToItems(PageCompositionDesign item) {
		items.addValue(item);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign addToItems(PageCompositionDesign item, int index) {
		items.insertValue(item, index);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign removeFromItems(PageCompositionDesign item) {
		items.removeValue(item);
		return (CompositeTemplateDesign)this;
	}
	
	public CompositeTemplateDesign removeFromItems(int index) {
		items.removeValue(index);
		return (CompositeTemplateDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<CompositeTemplateDesign, PlaceTemplateDesign> contentOfPage
		= createReverseRelationValue(org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.contentOfPage);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<CompositeTemplateDesign, PlaceTemplateDesign> getContentOfPageRelationValue() {
		return contentOfPage;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getContentOfPage() {
		return contentOfPage.getValue();
	}


}
