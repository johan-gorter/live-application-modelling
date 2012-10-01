package org.instantlogic.designer.entity;

public class AttributeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.AttributeDesign> {

	public static final AttributeDesignEntity INSTANCE = new AttributeDesignEntity();
	
	
	protected AttributeDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
		org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE
	};
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	@Override
	public org.instantlogic.designer.AttributeDesign createInstance() {
		return new org.instantlogic.designer.AttributeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.AttributeDesign> getInstanceClass() {
		return org.instantlogic.designer.AttributeDesign.class;
	}
	
	@Override
	public String getName() {
		return "AttributeDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> createDeduction0() {
		    org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d0 
		    	= new org.instantlogic.designer.deduction.AttributeBelongsToDeduction();
		return d0;
	}

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> readOnly 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
			"readOnly", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.AttributeDesign, java.lang.Boolean> get(org.instantlogic.designer.AttributeDesign instance) {
				return instance.getReadOnlyAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> belongsToEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"belongsToEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getBelongsToEntityRelationValue();
			}
	
			public boolean isReadOnly() {
				return true;
			}

			private org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> getRule() {
				if (rule==null) {
					rule  = createDeduction0();
				}
				return rule;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
			"dataType", INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.DataTypeDesign.class, 
			org.instantlogic.designer.entity.DataTypeDesignEntity.attribute
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getDataTypeRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> _default
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"default", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getDefaultRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> explanation
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
			"explanation", INSTANCE, org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE, org.instantlogic.designer.TextTemplateDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getExplanationRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> question
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
			"question", INSTANCE, org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE, org.instantlogic.designer.TextTemplateDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getQuestionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> relevance
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"relevance", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getRelevanceRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> rule
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"rule", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getRuleRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> attributeOf
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"attributeOf", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.attributes
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.AttributeDesign instance) {
				return instance.getAttributeOfRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		readOnly,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		belongsToEntity,
		dataType,
		_default,
		explanation,
		question,
		relevance,
		rule,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributeOf,
	};

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
