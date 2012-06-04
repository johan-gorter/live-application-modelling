package org.instantlogic.designer;


public class DesignEntityGenerator extends EntityDesign {

    public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
    
    private DesignEntityGenerator() {
    	setIsCustomized(true);
        setName("Design");
    }

    // Attributes
    public static final AttributeDesign name = addAttribute(ENTITY, "name", java.lang.String.class);
    public static final AttributeDesign javaIdentifier = addAttribute(ENTITY, "javaIdentifier", java.lang.String.class);
    public static final AttributeDesign technicalName = addAttribute(ENTITY, "technicalName", java.lang.String.class);
    public static final AttributeDesign isCustomized = addAttribute(ENTITY, "isCustomized", java.lang.Boolean.class);

    // Relations

    @Override
    public void init() {
    	super.init();
    	
		javaIdentifier.setReadOnly(true);
		javaIdentifier.setRule(createCustomDeduction("org.instantlogic.designer.deduction.JavaIdentifierDeduction", "java.lang.String"));

		technicalName.setReadOnly(true);
		technicalName.setRule(createCustomDeduction("org.instantlogic.designer.deduction.TechnicalNameDeduction", "java.lang.String"));
    }
}