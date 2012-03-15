package org.instantlogic.designer.entity;

public class FieldDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FieldDesign> {

	public static final FieldDesignEntity INSTANCE = new FieldDesignEntity();
	
	protected FieldDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.FieldDesign createInstance() {
		return new org.instantlogic.designer.FieldDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FieldDesign> getInstanceClass() {
		return org.instantlogic.designer.FieldDesign.class;
	}
	
	@Override
	public String getName() {
		return "FieldDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FieldDesign, java.lang.Boolean, java.lang.Boolean> required 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FieldDesign, java.lang.Boolean, java.lang.Boolean>(
			"required", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.FieldDesign, java.lang.Boolean> get(org.instantlogic.designer.FieldDesign instance) {
				return instance.getRequiredAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FieldDesign, java.lang.Boolean, java.lang.Boolean> readOnly 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FieldDesign, java.lang.Boolean, java.lang.Boolean>(
			"readOnly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.FieldDesign, java.lang.Boolean> get(org.instantlogic.designer.FieldDesign instance) {
				return instance.getReadOnlyAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FieldDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FieldDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.fields
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FieldDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.FieldDesign instance) {
				return instance.getAttributeRelationValue();
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		required,
		readOnly,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
