package org.instantlogic.designer;


public class SumDeductionDesignEntityGenerator extends EntityDesign {

    public static final SumDeductionDesignEntityGenerator ENTITY = new SumDeductionDesignEntityGenerator();
    
    private SumDeductionDesignEntityGenerator() {
        setName("SumDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}