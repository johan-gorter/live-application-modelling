package org.instantlogic.designer;


public class PageDesign extends FlowNodeBaseDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PageDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PageDesign, CompositePageFragmentDesign> content
		= createRelationValue(org.instantlogic.designer.entity.PageDesignEntity.content);
		
	public org.instantlogic.fabric.value.RelationValue<PageDesign, CompositePageFragmentDesign> getContentRelation() {
		return content;
	}

	public org.instantlogic.designer.CompositePageFragmentDesign getContent() {
		return content.get();
	}
	
	public void setContent(org.instantlogic.designer.CompositePageFragmentDesign newValue) {
		content.setValue(newValue);
	}

	// Reverse relations

}
