package org.instantlogic.designer;


public class TextDesign extends FragmentTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.TextDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, AttributeDesign> questionOnAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.TextDesignEntity.questionOnAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, AttributeDesign> getQuestionOnAttributeRelationValue() {
		return questionOnAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getQuestionOnAttribute() {
		return questionOnAttribute.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, AttributeDesign> explanationOnAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.TextDesignEntity.explanationOnAttribute);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, AttributeDesign> getExplanationOnAttributeRelationValue() {
		return explanationOnAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getExplanationOnAttribute() {
		return explanationOnAttribute.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, DomainEntryDesign> displayOnDomainEntry
		= createReverseRelationValue(org.instantlogic.designer.entity.TextDesignEntity.displayOnDomainEntry);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, DomainEntryDesign> getDisplayOnDomainEntryRelationValue() {
		return displayOnDomainEntry;
	}

	public org.instantlogic.designer.DomainEntryDesign getDisplayOnDomainEntry() {
		return displayOnDomainEntry.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, WidgetText> textForWidget
		= createReverseRelationValue(org.instantlogic.designer.entity.TextDesignEntity.textForWidget);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<TextDesign, WidgetText> getTextForWidgetRelationValue() {
		return textForWidget;
	}

	public org.instantlogic.designer.WidgetText getTextForWidget() {
		return textForWidget.getValue();
	}


}
