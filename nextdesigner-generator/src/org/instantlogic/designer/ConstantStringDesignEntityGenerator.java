package org.instantlogic.designer;


public class ConstantStringDesignEntityGenerator extends EntityDesign {

    public static final ConstantStringDesignEntityGenerator ENTITY = new ConstantStringDesignEntityGenerator();
    
    public ConstantStringDesignEntityGenerator() {
        setName("ConstantStringDesign");
        setExtendsFrom(StringProducerDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public final AttributeDesign constant = addAttribute("constant", java.lang.String.class);

    // Relations

}