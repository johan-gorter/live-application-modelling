package org.instantlogic.designer.entity;

public class DataTypeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataTypeDesign> {

	public static final DataTypeDesignEntity INSTANCE = new DataTypeDesignEntity();
	
	
	protected DataTypeDesignEntity() {
	}


	@Override
	public org.instantlogic.designer.DataTypeDesign createInstance() {
		return new org.instantlogic.designer.DataTypeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DataTypeDesign> getInstanceClass() {
		return org.instantlogic.designer.DataTypeDesign.class;
	}
	
	@Override
	public String getName() {
		return "DataTypeDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> createDeduction1() {
		    org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> d0 
		    	= new org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> createDeduction2() {
		    org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d0 
		    	= new org.instantlogic.designer.deduction.DataTypeEntityDeduction();
		return d0;
	}

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> exactRounding 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"exactRounding", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getExactRoundingAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> formatted 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"formatted", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getFormattedAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> javaClassName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String>(
			"javaClassName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.String> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getJavaClassNameAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.String> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.String> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction0();
                }
                return defaultDeduction;
            }
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multiLine 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"multiLine", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getMultiLineAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getMultivalueAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> percentage 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"percentage", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getPercentageAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> wholeNumber 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"wholeNumber", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getWholeNumberAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> dataCategory
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign>(
			"dataCategory", INSTANCE, org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE, org.instantlogic.designer.DataCategoryDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getDataCategoryRelationValue();
			}

			private org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> getRule() {
				if (rule==null) {
					rule  = createDeduction1();
				}
				return rule;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"entity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getEntityRelationValue();
			}
	
			public boolean isReadOnly() {
				return true;
			}

			private org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> getRule() {
				if (rule==null) {
					rule  = createDeduction2();
				}
				return rule;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.dataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"forEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.dataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getForEntityRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> reverseRelation
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
			"reverseRelation", INSTANCE, org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE, org.instantlogic.designer.RelationDesign.class, org.instantlogic.designer.entity.RelationDesignEntity.reverseDataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getReverseRelationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		exactRounding,
		formatted,
		javaClassName,
		multiLine,
		multivalue,
		percentage,
		wholeNumber,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataCategory,
		entity,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
		forEntity,
		reverseRelation,
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
