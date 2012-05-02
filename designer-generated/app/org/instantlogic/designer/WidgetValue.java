package org.instantlogic.designer;


public class WidgetValue extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.WidgetValueEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<WidgetValue, DeductionSchemeDesign> deduction
		= createRelationValue(org.instantlogic.designer.entity.WidgetValueEntity.deduction);
		
	public org.instantlogic.fabric.value.RelationValue<WidgetValue, DeductionSchemeDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.getValue();
	}
	
	public WidgetValue setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
		return (WidgetValue)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<WidgetValue, WidgetTemplateDesign> widget
		= createReverseRelationValue(org.instantlogic.designer.entity.WidgetValueEntity.widget);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<WidgetValue, WidgetTemplateDesign> getWidgetRelationValue() {
		return widget;
	}

	public org.instantlogic.designer.WidgetTemplateDesign getWidget() {
		return widget.getValue();
	}


}
