package org.instantlogic.designer;


public class ConstantStringDesignEntityGenerator extends EntityDesign {

    public static final ConstantStringDesignEntityGenerator ENTITY = new ConstantStringDesignEntityGenerator();
    
    private ConstantStringDesignEntityGenerator() {
        setName("ConstantStringDesign");
        setExtendsFrom(StringProducerDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign constant = addAttribute(ENTITY, "constant", java.lang.String.class);

    // Relations

}