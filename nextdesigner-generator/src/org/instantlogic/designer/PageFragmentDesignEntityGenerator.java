package org.instantlogic.designer;


public class PageFragmentDesignEntityGenerator extends EntityDesign {

    public static final PageFragmentDesignEntityGenerator ENTITY = new PageFragmentDesignEntityGenerator();
    
    public PageFragmentDesignEntityGenerator() {
        setName("PageFragmentDesign");
    }

    // Attributes
    public final AttributeDesign presentation = addAttribute("presentation", java.lang.String.class);

    // Attributes

}