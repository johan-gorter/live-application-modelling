package org.instantlogic.designer;


public class WidgetChildList extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.WidgetChildListEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<WidgetChildList, FragmentTemplateDesign> children
		= createRelationValues(org.instantlogic.designer.entity.WidgetChildListEntity.children);
		
	public org.instantlogic.fabric.value.RelationValues<WidgetChildList, FragmentTemplateDesign> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign> getChildren() {
		return children.getValue();
	}
	
	public WidgetChildList addToChildren(FragmentTemplateDesign item) {
		children.addValue(item);
		return (WidgetChildList)this;
	}
	
	public WidgetChildList addToChildren(FragmentTemplateDesign item, int index) {
		children.insertValue(item, index);
		return (WidgetChildList)this;
	}
	
	public WidgetChildList removeFromChildren(FragmentTemplateDesign item) {
		children.removeValue(item);
		return (WidgetChildList)this;
	}
	
	public WidgetChildList removeFromChildren(int index) {
		children.removeValue(index);
		return (WidgetChildList)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<WidgetChildList, WidgetTemplateDesign> widget
		= createReverseRelationValue(org.instantlogic.designer.entity.WidgetChildListEntity.widget);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<WidgetChildList, WidgetTemplateDesign> getWidgetRelationValue() {
		return widget;
	}

	public org.instantlogic.designer.WidgetTemplateDesign getWidget() {
		return widget.getValue();
	}


}
