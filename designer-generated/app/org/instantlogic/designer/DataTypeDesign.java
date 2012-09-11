package org.instantlogic.designer;


public class DataTypeDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> exactRounding
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding);
	
	public java.lang.Boolean getExactRounding() {
		return exactRounding.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getExactRoundingAttributeValue() {
		return exactRounding;
	}

	public DataTypeDesign setExactRounding(java.lang.Boolean newValue) {
		exactRounding.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> formatted
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.formatted);
	
	public java.lang.Boolean getFormatted() {
		return formatted.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getFormattedAttributeValue() {
		return formatted;
	}

	public DataTypeDesign setFormatted(java.lang.Boolean newValue) {
		formatted.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.String> javaClassName
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.javaClassName);
	
	public java.lang.String getJavaClassName() {
		return javaClassName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.String> getJavaClassNameAttributeValue() {
		return javaClassName;
	}

	public DataTypeDesign setJavaClassName(java.lang.String newValue) {
		javaClassName.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> multiLine
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine);
	
	public java.lang.Boolean getMultiLine() {
		return multiLine.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getMultiLineAttributeValue() {
		return multiLine;
	}

	public DataTypeDesign setMultiLine(java.lang.Boolean newValue) {
		multiLine.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> multivalue
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getMultivalueAttributeValue() {
		return multivalue;
	}

	public DataTypeDesign setMultivalue(java.lang.Boolean newValue) {
		multivalue.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> percentage
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.percentage);
	
	public java.lang.Boolean getPercentage() {
		return percentage.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getPercentageAttributeValue() {
		return percentage;
	}

	public DataTypeDesign setPercentage(java.lang.Boolean newValue) {
		percentage.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> wholeNumber
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber);
	
	public java.lang.Boolean getWholeNumber() {
		return wholeNumber.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getWholeNumberAttributeValue() {
		return wholeNumber;
	}

	public DataTypeDesign setWholeNumber(java.lang.Boolean newValue) {
		wholeNumber.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DataTypeDesign, DataCategoryDesign> dataCategory
		= createRelationValue(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		
	public org.instantlogic.fabric.value.RelationValue<DataTypeDesign, DataCategoryDesign> getDataCategoryRelationValue() {
		return dataCategory;
	}

	public org.instantlogic.designer.DataCategoryDesign getDataCategory() {
		return dataCategory.getValue();
	}
	
	public DataTypeDesign setDataCategory(org.instantlogic.designer.DataCategoryDesign newValue) {
		dataCategory.setValue(newValue);
		return (DataTypeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<DataTypeDesign, EntityDesign> entity
		= createRelationValue(org.instantlogic.designer.entity.DataTypeDesignEntity.entity);
		
	public org.instantlogic.fabric.value.RelationValue<DataTypeDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}
	
	public DataTypeDesign setEntity(org.instantlogic.designer.EntityDesign newValue) {
		entity.setValue(newValue);
		return (DataTypeDesign)this;
	}


	// Reverse relations

}