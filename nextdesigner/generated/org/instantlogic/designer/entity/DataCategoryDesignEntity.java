package org.instantlogic.designer.entity;

public class DataCategoryDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataCategoryDesign> {

	public static final DataCategoryDesignEntity INSTANCE = new DataCategoryDesignEntity();
	
	public final org.instantlogic.designer.DataCategoryDesign text;
	public final org.instantlogic.designer.DataCategoryDesign number;
	public final org.instantlogic.designer.DataCategoryDesign choice;
	
	protected DataCategoryDesignEntity() {
	   text = addStaticInstance("text", createInstance());
	   text.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Text"))
);
	   number = addStaticInstance("number", createInstance());
	   number.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Number"))
);
	   choice = addStaticInstance("choice", createInstance());
	   choice.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Choice"))
);
	}


	@Override
	public org.instantlogic.designer.DataCategoryDesign createInstance() {
		return new org.instantlogic.designer.DataCategoryDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DataCategoryDesign> getInstanceClass() {
		return org.instantlogic.designer.DataCategoryDesign.class;
	}
	
	@Override
	public String getName() {
		return "DataCategoryDesign";
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
