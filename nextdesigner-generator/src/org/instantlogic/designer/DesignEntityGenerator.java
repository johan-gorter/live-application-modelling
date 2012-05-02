package org.instantlogic.designer;


public class DesignEntityGenerator extends EntityDesign {

    public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
    
    public DesignEntityGenerator() {
        setName("Design");
    }

    // Attributes
    public final AttributeDesign name = addAttribute("name", java.lang.String.class);
    public final AttributeDesign javaName = addAttribute("javaName", java.lang.String.class);
    public final AttributeDesign isCustomized = addAttribute("isCustomized", java.lang.Boolean.class);

    // Attributes

}