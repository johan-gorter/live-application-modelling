package org.instantlogic.designer.entity;

public class CustomPageFragmentDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.CustomPageFragmentDesign> {

	public static final CustomPageFragmentDesignEntity INSTANCE = new CustomPageFragmentDesignEntity();
	
	protected CustomPageFragmentDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.CustomPageFragmentDesign createInstance() {
		return new org.instantlogic.designer.CustomPageFragmentDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.CustomPageFragmentDesign> getInstanceClass() {
		return org.instantlogic.designer.CustomPageFragmentDesign.class;
	}
	
	@Override
	public String getName() {
		return "CustomPageFragmentDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.CustomPageFragmentDesign, java.lang.String, java.lang.String> implementationClassName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.CustomPageFragmentDesign, java.lang.String, java.lang.String>(
			"implementationClassName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.CustomPageFragmentDesign, java.lang.String> get(org.instantlogic.designer.CustomPageFragmentDesign instance) {
				return instance.getImplementationClassNameAttributeValue();
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		implementationClassName,
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
