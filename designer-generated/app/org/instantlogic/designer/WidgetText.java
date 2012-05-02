package org.instantlogic.designer;


public class WidgetText extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.WidgetTextEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<WidgetText, TextDesign> text
		= createRelationValue(org.instantlogic.designer.entity.WidgetTextEntity.text);
		
	public org.instantlogic.fabric.value.RelationValue<WidgetText, TextDesign> getTextRelationValue() {
		return text;
	}

	public org.instantlogic.designer.TextDesign getText() {
		return text.getValue();
	}
	
	public WidgetText setText(org.instantlogic.designer.TextDesign newValue) {
		text.setValue(newValue);
		return (WidgetText)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<WidgetText, WidgetTemplateDesign> widget
		= createReverseRelationValue(org.instantlogic.designer.entity.WidgetTextEntity.widget);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<WidgetText, WidgetTemplateDesign> getWidgetRelationValue() {
		return widget;
	}

	public org.instantlogic.designer.WidgetTemplateDesign getWidget() {
		return widget.getValue();
	}


}
