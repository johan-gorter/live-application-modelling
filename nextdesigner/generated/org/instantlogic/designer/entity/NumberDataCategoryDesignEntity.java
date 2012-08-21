package org.instantlogic.designer.entity;

public class NumberDataCategoryDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.NumberDataCategoryDesign> {

	public static final NumberDataCategoryDesignEntity INSTANCE = new NumberDataCategoryDesignEntity();
	
	public final org.instantlogic.designer.NumberDataCategoryDesign _int;
	public final org.instantlogic.designer.NumberDataCategoryDesign _double;
	public final org.instantlogic.designer.NumberDataCategoryDesign decimal;
	public final org.instantlogic.designer.NumberDataCategoryDesign percentage;
	
	protected NumberDataCategoryDesignEntity() {
	   _int = addStaticInstance("int", createInstance());
	   _int.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Whole number"))
);
	   _double = addStaticInstance("double", createInstance());
	   _double.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Fractional number"))
);
	   decimal = addStaticInstance("decimal", createInstance());
	   decimal.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Fractional number (exact rounding)"))
);
	   percentage = addStaticInstance("percentage", createInstance());
	   percentage.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Percentage"))
);
	}


	@Override
	public org.instantlogic.designer.NumberDataCategoryDesign createInstance() {
		return new org.instantlogic.designer.NumberDataCategoryDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.NumberDataCategoryDesign> getInstanceClass() {
		return org.instantlogic.designer.NumberDataCategoryDesign.class;
	}
	
	@Override
	public String getName() {
		return "NumberDataCategoryDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
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
