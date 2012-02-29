package org.instantlogic.designer.entity;

public class DesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.Design> {

	public static final DesignEntity INSTANCE = new DesignEntity();
	
	protected DesignEntity() {
	}


	@Override
	public org.instantlogic.designer.Design createInstance() {
		return new org.instantlogic.designer.Design();
	}
	
	@Override
	public Class<org.instantlogic.designer.Design> getInstanceClass() {
		return org.instantlogic.designer.Design.class;
	}
	
	@Override
	public String getName() {
		return "Design";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.JavaNameDeduction();
		return d0;
	}

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> name 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.Design, java.lang.String> get(org.instantlogic.designer.Design instance) {
				return instance.getNameAttribute();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> javaName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
			"javaName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.Design, java.lang.String> get(org.instantlogic.designer.Design instance) {
				return instance.getJavaNameAttribute();
			}
			
			public boolean isReadOnly() {
				return true;
			};
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.Boolean, java.lang.Boolean> isCustomized 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.Boolean, java.lang.Boolean>(
			"isCustomized", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.Design, java.lang.Boolean> get(org.instantlogic.designer.Design instance) {
				return instance.getIsCustomizedAttribute();
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		name,
		javaName,
		isCustomized,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
