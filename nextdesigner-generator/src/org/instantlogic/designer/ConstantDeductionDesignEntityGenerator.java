package org.instantlogic.designer;


public class ConstantDeductionDesignEntityGenerator extends EntityDesign {

    public static final ConstantDeductionDesignEntityGenerator ENTITY = new ConstantDeductionDesignEntityGenerator();
    
    private ConstantDeductionDesignEntityGenerator() {
        setName("ConstantDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    public static final AttributeDesign value = addAttribute(ENTITY, "value", java.lang.Object.class);
    
    // Relations

}