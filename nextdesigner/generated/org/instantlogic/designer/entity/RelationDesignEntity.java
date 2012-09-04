package org.instantlogic.designer.entity;

public class RelationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.RelationDesign> {

	public static final RelationDesignEntity INSTANCE = new RelationDesignEntity();
	
	
	protected RelationDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.RelationDesign createInstance() {
		return new org.instantlogic.designer.RelationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.RelationDesign> getInstanceClass() {
		return org.instantlogic.designer.RelationDesign.class;
	}
	
	@Override
	public String getName() {
		return "RelationDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction();
		return d0;
	}

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> autoCreate 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
			"autoCreate", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.RelationDesign, java.lang.Boolean> get(org.instantlogic.designer.RelationDesign instance) {
				return instance.getAutoCreateAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> owner 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
			"owner", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.RelationDesign, java.lang.Boolean> get(org.instantlogic.designer.RelationDesign instance) {
				return instance.getOwnerAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseJavaIdentifier 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
			"reverseJavaIdentifier", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.RelationDesign, java.lang.String> get(org.instantlogic.designer.RelationDesign instance) {
				return instance.getReverseJavaIdentifierAttributeValue();
			}
			
			public boolean isReadOnly() {
				return true;
			};

            private org.instantlogic.fabric.deduction.Deduction<java.lang.String> rule;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.String> getRule() {
                if (rule==null) {
                    rule = createDeduction1();
                }
                return rule;
            }
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> reverseMultivalue 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
			"reverseMultivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.RelationDesign, java.lang.Boolean> get(org.instantlogic.designer.RelationDesign instance) {
				return instance.getReverseMultivalueAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
			"reverseName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.RelationDesign, java.lang.String> get(org.instantlogic.designer.RelationDesign instance) {
				return instance.getReverseNameAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseTechnicalName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
			"reverseTechnicalName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.RelationDesign, java.lang.String> get(org.instantlogic.designer.RelationDesign instance) {
				return instance.getReverseTechnicalNameAttributeValue();
			}
			
			public boolean isReadOnly() {
				return true;
			};

            private org.instantlogic.fabric.deduction.Deduction<java.lang.String> rule;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.String> getRule() {
                if (rule==null) {
                    rule = createDeduction0();
                }
                return rule;
            }
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> to
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"to", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.RelationDesign instance) {
				return instance.getToRelationValue();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> from
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"from", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.relations
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.RelationDesign instance) {
				return instance.getFromRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		autoCreate,
		owner,
		reverseJavaIdentifier,
		reverseMultivalue,
		reverseName,
		reverseTechnicalName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		to,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		from,
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
