package org.instantlogic.designer;


public class NegationDeductionDesignEntityGenerator extends EntityDesign {

    public static final NegationDeductionDesignEntityGenerator ENTITY = new NegationDeductionDesignEntityGenerator();
    
    private NegationDeductionDesignEntityGenerator() {
        setName("NegationDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}