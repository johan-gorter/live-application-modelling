package org.instantlogic.designer;


public class ConstantTextDesignEntityGenerator extends EntityDesign {

    public static final ConstantTextDesignEntityGenerator ENTITY = new ConstantTextDesignEntityGenerator();
    
    public ConstantTextDesignEntityGenerator() {
        setName("ConstantTextDesign");
        setExtendsFrom(TextDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public final AttributeDesign untranslated = addAttribute("untranslated", java.lang.String.class);

    // Relations

}