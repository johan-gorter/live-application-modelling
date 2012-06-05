package org.instantlogic.designer.entity;

public class PropertyDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PropertyDesign> {

	public static final PropertyDesignEntity INSTANCE = new PropertyDesignEntity();
	
	protected PropertyDesignEntity() {
	}


	@Override
	public org.instantlogic.designer.PropertyDesign createInstance() {
		return new org.instantlogic.designer.PropertyDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PropertyDesign> getInstanceClass() {
		return org.instantlogic.designer.PropertyDesign.class;
	}
	
	@Override
	public String getName() {
		return "PropertyDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String> name 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.PropertyDesign, java.lang.String> get(org.instantlogic.designer.PropertyDesign instance) {
				return instance.getNameAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> children
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
			"children", INSTANCE, org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE, org.instantlogic.designer.ElementDesign.class, org.instantlogic.designer.entity.ElementDesignEntity.childrenForFragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.ElementDesign> get(
					org.instantlogic.designer.PropertyDesign instance) {
				return instance.getChildrenRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> deduction
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"deduction", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.valueForFragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.PropertyDesign instance) {
				return instance.getDeductionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign> text
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign>(
			"text", INSTANCE, org.instantlogic.designer.entity.TextDesignEntity.INSTANCE, org.instantlogic.designer.TextDesign.class, org.instantlogic.designer.entity.TextDesignEntity.textForFragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextDesign> get(
					org.instantlogic.designer.PropertyDesign instance) {
				return instance.getTextRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> fragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
			"fragment", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.PropertyDesign instance) {
				return instance.getFragmentRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		name,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		children,
		deduction,
		text,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		fragment,
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
