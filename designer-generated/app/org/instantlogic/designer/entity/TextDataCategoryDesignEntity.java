package org.instantlogic.designer.entity;

public class TextDataCategoryDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.TextDataCategoryDesign> {

	public static final TextDataCategoryDesignEntity INSTANCE = new TextDataCategoryDesignEntity();
	
	public final org.instantlogic.designer.TextDataCategoryDesign singleline;
	public final org.instantlogic.designer.TextDataCategoryDesign multiline;
	public final org.instantlogic.designer.TextDataCategoryDesign formatted;
	
	protected TextDataCategoryDesignEntity() {
	   singleline = addStaticInstance("singleline", createInstance());
	   singleline.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Single line of text"))
);
	   multiline = addStaticInstance("multiline", createInstance());
	   multiline.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Multiple lines of text"))
);
	   formatted = addStaticInstance("formatted", createInstance());
	   formatted.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Formatted text"))
);
	}


	@Override
	public org.instantlogic.designer.TextDataCategoryDesign createInstance() {
		return new org.instantlogic.designer.TextDataCategoryDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.TextDataCategoryDesign> getInstanceClass() {
		return org.instantlogic.designer.TextDataCategoryDesign.class;
	}
	
	@Override
	public String getName() {
		return "TextDataCategoryDesign";
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
