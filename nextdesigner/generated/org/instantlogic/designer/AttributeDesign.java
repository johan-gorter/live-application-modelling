package org.instantlogic.designer;


public class AttributeDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> exactRounding
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.exactRounding);
	
	public java.lang.Boolean getExactRounding() {
		return exactRounding.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getExactRoundingAttributeValue() {
		return exactRounding;
	}

	public AttributeDesign setExactRounding(java.lang.Boolean newValue) {
		exactRounding.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.String> javaClassName
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.javaClassName);
	
	public java.lang.String getJavaClassName() {
		return javaClassName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.String> getJavaClassNameAttributeValue() {
		return javaClassName;
	}

	public AttributeDesign setJavaClassName(java.lang.String newValue) {
		javaClassName.setValue(newValue);
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
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> percentage
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.percentage);
	
	public java.lang.Boolean getPercentage() {
		return percentage.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getPercentageAttributeValue() {
		return percentage;
	}

	public AttributeDesign setPercentage(java.lang.Boolean newValue) {
		percentage.setValue(newValue);
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
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> wholeNumber
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.wholeNumber);
	
	public java.lang.Boolean getWholeNumber() {
		return wholeNumber.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getWholeNumberAttributeValue() {
		return wholeNumber;
	}

	public AttributeDesign setWholeNumber(java.lang.Boolean newValue) {
		wholeNumber.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DataCategoryDesign> dataCategory
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.dataCategory);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DataCategoryDesign> getDataCategoryRelationValue() {
		return dataCategory;
	}

	public org.instantlogic.designer.DataCategoryDesign getDataCategory() {
		return dataCategory.getValue();
	}
	
	public AttributeDesign setDataCategory(org.instantlogic.designer.DataCategoryDesign newValue) {
		dataCategory.setValue(newValue);
		return (AttributeDesign)this;
	}

	
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

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextDataCategoryDesign> textDataCategory
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.textDataCategory);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextDataCategoryDesign> getTextDataCategoryRelationValue() {
		return textDataCategory;
	}

	public org.instantlogic.designer.TextDataCategoryDesign getTextDataCategory() {
		return textDataCategory.getValue();
	}
	
	public AttributeDesign setTextDataCategory(org.instantlogic.designer.TextDataCategoryDesign newValue) {
		textDataCategory.setValue(newValue);
		return (AttributeDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<AttributeDesign, AttributeDeductionDesign> attributeInDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.attributeInDeductions);

	public org.instantlogic.fabric.value.RelationValues<AttributeDesign, AttributeDeductionDesign> getAttributeInDeductionsRelationValue() {
		return attributeInDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDeductionDesign> getAttributeInDeductions() {
		return attributeInDeductions.getValue();
	}

    public AttributeDesign addToAttributeInDeductions(AttributeDeductionDesign item) {
        attributeInDeductions.addValue(item);
        return (AttributeDesign)this;
    }

    public AttributeDesign removeFromAttributeInDeductions(AttributeDeductionDesign item) {
        attributeInDeductions.removeValue(item);
        return (AttributeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, EntityDesign> belongsToEntity
		= createReverseRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.belongsToEntity);

	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, EntityDesign> getBelongsToEntityRelationValue() {
		return belongsToEntity;
	}

	public org.instantlogic.designer.EntityDesign getBelongsToEntity() {
		return belongsToEntity.getValue();
	}

    public AttributeDesign setBelongsToEntity(org.instantlogic.designer.EntityDesign newValue) {
        belongsToEntity.setValue(newValue);
        return (AttributeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<AttributeDesign, FragmentTemplateDesign> usedInField
		= createReverseRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.usedInField);

	public org.instantlogic.fabric.value.RelationValues<AttributeDesign, FragmentTemplateDesign> getUsedInFieldRelationValue() {
		return usedInField;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign> getUsedInField() {
		return usedInField.getValue();
	}

    public AttributeDesign addToUsedInField(FragmentTemplateDesign item) {
        usedInField.addValue(item);
        return (AttributeDesign)this;
    }

    public AttributeDesign removeFromUsedInField(FragmentTemplateDesign item) {
        usedInField.removeValue(item);
        return (AttributeDesign)this;
    }


}
