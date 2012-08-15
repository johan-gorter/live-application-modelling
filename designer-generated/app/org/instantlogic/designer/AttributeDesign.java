package org.instantlogic.designer;


public class AttributeDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.String> className
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.className);
	
	public java.lang.String getClassName() {
		return className.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.String> getClassNameAttributeValue() {
		return className;
	}

	public AttributeDesign setClassName(java.lang.String newValue) {
		className.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> multivalue
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getMultivalueAttributeValue() {
		return multivalue;
	}

	public AttributeDesign setMultivalue(java.lang.Boolean newValue) {
		multivalue.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> readOnly
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getReadOnlyAttributeValue() {
		return readOnly;
	}

	public AttributeDesign setReadOnly(java.lang.Boolean newValue) {
		readOnly.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> _default
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity._default);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getDefaultRelationValue() {
		return _default;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDefault() {
		return _default.getValue();
	}
	
	public AttributeDesign setDefault(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		_default.setValue(newValue);
		return (AttributeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<AttributeDesign, DomainEntryDesign> domain
		= createRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.domain);
		
	public org.instantlogic.fabric.value.RelationValues<AttributeDesign, DomainEntryDesign> getDomainRelationValue() {
		return domain;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DomainEntryDesign> getDomain() {
		return domain.getValue();
	}
	
	public AttributeDesign addToDomain(DomainEntryDesign item) {
		domain.addValue(item);
		return (AttributeDesign)this;
	}
	
	public AttributeDesign addToDomain(DomainEntryDesign item, int index) {
		domain.insertValue(item, index);
		return (AttributeDesign)this;
	}
	
	public AttributeDesign removeFromDomain(DomainEntryDesign item) {
		domain.removeValue(item);
		return (AttributeDesign)this;
	}
	
	public AttributeDesign removeFromDomain(int index) {
		domain.removeValue(index);
		return (AttributeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> explanation
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.explanation);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> getExplanationRelationValue() {
		return explanation;
	}

	public org.instantlogic.designer.TextTemplateDesign getExplanation() {
		return explanation.getValue();
	}
	
	public AttributeDesign setExplanation(org.instantlogic.designer.TextTemplateDesign newValue) {
		explanation.setValue(newValue);
		return (AttributeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> question
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.question);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> getQuestionRelationValue() {
		return question;
	}

	public org.instantlogic.designer.TextTemplateDesign getQuestion() {
		return question.getValue();
	}
	
	public AttributeDesign setQuestion(org.instantlogic.designer.TextTemplateDesign newValue) {
		question.setValue(newValue);
		return (AttributeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> relevance
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.relevance);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getRelevanceRelationValue() {
		return relevance;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRelevance() {
		return relevance.getValue();
	}
	
	public AttributeDesign setRelevance(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		relevance.setValue(newValue);
		return (AttributeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> rule
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getRuleRelationValue() {
		return rule;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRule() {
		return rule.getValue();
	}
	
	public AttributeDesign setRule(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		rule.setValue(newValue);
		return (AttributeDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, AttributeDeductionDesign> attributeInDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.attributeInDeductions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, AttributeDeductionDesign> getAttributeInDeductionsRelationValue() {
		return attributeInDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDeductionDesign> getAttributeInDeductions() {
		return attributeInDeductions.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<AttributeDesign, EntityDesign> belongsToEntity
		= createReverseRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.belongsToEntity);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<AttributeDesign, EntityDesign> getBelongsToEntityRelationValue() {
		return belongsToEntity;
	}

	public org.instantlogic.designer.EntityDesign getBelongsToEntity() {
		return belongsToEntity.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, FragmentTemplateDesign> usedInField
		= createReverseRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.usedInField);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, FragmentTemplateDesign> getUsedInFieldRelationValue() {
		return usedInField;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign> getUsedInField() {
		return usedInField.getValue();
	}


}
