package org.instantlogic.designer;


public class ConstantTextDesignEntityGenerator extends EntityDesign {

    public static final ConstantTextDesignEntityGenerator ENTITY = new ConstantTextDesignEntityGenerator();
    
    private ConstantTextDesignEntityGenerator() {
        setName("ConstantTextDesign");
        setExtendsFrom(TextDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign untranslated = addAttribute(ENTITY, "untranslated", java.lang.String.class);

    // Relations

}