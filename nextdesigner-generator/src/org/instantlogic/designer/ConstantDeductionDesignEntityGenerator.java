package org.instantlogic.designer;


public class ConstantDeductionDesignEntityGenerator extends EntityDesign {

    public static final ConstantDeductionDesignEntityGenerator ENTITY = new ConstantDeductionDesignEntityGenerator();
    
    public ConstantDeductionDesignEntityGenerator() {
        setName("ConstantDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public final AttributeDesign value = addAttribute("value", java.lang.Object.class);

    // Relations

}