package org.instantlogic.designer;


public class CustomPageFragmentDesignEntityGenerator extends EntityDesign {

    public static final CustomPageFragmentDesignEntityGenerator ENTITY = new CustomPageFragmentDesignEntityGenerator();
    
    public CustomPageFragmentDesignEntityGenerator() {
        setName("CustomPageFragmentDesign");
    }

    // Attributes
    public final AttributeDesign implementationClassName = addAttribute("implementationClassName", java.lang.String.class);

    // Attributes

}