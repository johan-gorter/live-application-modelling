package org.instantlogic.designer;


public  class AttributeDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> readOnly
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getReadOnlyAttribute() {
		return readOnly;
	}

	public void setReadOnly(java.lang.Boolean newValue) {
		readOnly.setValue(newValue);
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> multivalue
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getMultivalueAttribute() {
		return multivalue;
	}

	public void setMultivalue(java.lang.Boolean newValue) {
		multivalue.setValue(newValue);
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.String> className
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.className);
	
	public java.lang.String getClassName() {
		return className.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.String> getClassNameAttribute() {
		return className;
	}

	public void setClassName(java.lang.String newValue) {
		className.setValue(newValue);
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextDesign> question
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.question);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextDesign> getQuestionRelation() {
		return question;
	}

	public org.instantlogic.designer.TextDesign getQuestion() {
		return question.get();
	}
	
	public void setQuestion(org.instantlogic.designer.TextDesign newValue) {
		question.setValue(newValue);
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextDesign> explanation
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.explanation);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextDesign> getExplanationRelation() {
		return explanation;
	}

	public org.instantlogic.designer.TextDesign getExplanation() {
		return explanation.get();
	}
	
	public void setExplanation(org.instantlogic.designer.TextDesign newValue) {
		explanation.setValue(newValue);
	}

	
	private final org.instantlogic.fabric.value.RelationValues<AttributeDesign, DomainEntryDesign> domain
		= createRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.domain);
		
	public org.instantlogic.fabric.value.RelationValues<AttributeDesign, DomainEntryDesign> getDomainRelation() {
		return domain;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DomainEntryDesign> getDomain() {
		return domain.get();
	}
	
	public void addToDomain(DomainEntryDesign item) {
		domain.addValue(item);
	}
	
	public void addToDomain(DomainEntryDesign item, int index) {
		domain.insertValue(item, index);
	}
	
	public void removeFromDomain(DomainEntryDesign item) {
		domain.removeValue(item);
	}
	
	public void removeFromDomain(int index) {
		domain.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> relevance
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.relevance);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getRelevanceRelation() {
		return relevance;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRelevance() {
		return relevance.get();
	}
	
	public void setRelevance(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		relevance.setValue(newValue);
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> rule
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getRuleRelation() {
		return rule;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRule() {
		return rule.get();
	}
	
	public void setRule(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		rule.setValue(newValue);
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> _default
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity._default);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> get_defaultRelation() {
		return _default;
	}

	public org.instantlogic.designer.DeductionSchemeDesign get_default() {
		return _default.get();
	}
	
	public void set_default(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		_default.setValue(newValue);
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<AttributeDesign, EntityDesign> belongsToEntity
		= createReverseRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.belongsToEntity);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<AttributeDesign, EntityDesign> getBelongsToEntityRelation() {
		return belongsToEntity;
	}

	public org.instantlogic.designer.EntityDesign getBelongsToEntity() {
		return belongsToEntity.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, AttributeDeductionDesign> attributeInDeductions
		= createReverseRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.attributeInDeductions);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, AttributeDeductionDesign> getAttributeInDeductionsRelation() {
		return attributeInDeductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDeductionDesign> getAttributeInDeductions() {
		return attributeInDeductions.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, FieldDesign> fields
		= createReverseRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.fields);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<AttributeDesign, FieldDesign> getFieldsRelation() {
		return fields;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FieldDesign> getFields() {
		return fields.get();
	}


}
