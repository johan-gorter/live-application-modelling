package org.instantlogic.designer;


public class DesignEntityGenerator extends EntityDesign {

	public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
	
	public DesignEntityGenerator() {
		setName("Design");
	}

//	AttributeDesign valid = createAttribute(design, "valid", Boolean.class);
//	valid.readOnly.set(true);
//	valid.customization.set("custom.designer.ValidAttributeCustomization");
	
	public final AttributeDesign name = addAttribute("name", String.class);
	public final AttributeDesign isCustomized = addAttribute("isCustomized", Boolean.class);

	public final AttributeDesign technicalName = addAttribute("technicalName", String.class)
			.setReadOnly(true)
			.setRule(createCustomDeduction("org.instantlogic.designer.deduction.JavaNameDeduction", String.class));
	
//	public final RelationDesign jaren = addRelation("jaren", RelationType.OneToManyAggregation, JaarDesign.ENTITY).setReverseName("gebruiker");
	
}
