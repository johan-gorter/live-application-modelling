package org.instantlogic.designer;


public class DesignEntityGenerator extends EntityDesign {

    public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
    
    public DesignEntityGenerator() {
        setName("Design");
    }

    // Attributes
    public final AttributeDesign name = addAttribute("name", java.lang.String.class);
    public final AttributeDesign javaIdentifier = addAttribute("javaIdentifier", java.lang.String.class);
    public final AttributeDesign technicalName = addAttribute("technicalName", java.lang.String.class);
    public final AttributeDesign isCustomized = addAttribute("isCustomized", java.lang.Boolean.class);

    // Attributes

}