package org.instantlogic.designer;


public class CompositePageFragmentDesign extends PageFragmentDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<CompositePageFragmentDesign, PageCompositionDesign> items
		= createRelationValues(org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.items);
		
	public org.instantlogic.fabric.value.RelationValues<CompositePageFragmentDesign, PageCompositionDesign> getItemsRelation() {
		return items;
	}

	public java.util.List<org.instantlogic.designer.PageCompositionDesign> getItems() {
		return items.get();
	}
	
	public void setItems(java.util.List<org.instantlogic.designer.PageCompositionDesign> newValue) {
		items.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<CompositePageFragmentDesign, PageDesign> contentOfPage
		= createReverseRelationValue(org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.contentOfPage);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<CompositePageFragmentDesign, PageDesign> getContentOfPageRelation() {
		return contentOfPage;
	}

	public org.instantlogic.designer.PageDesign getContentOfPage() {
		return contentOfPage.get();
	}


}
