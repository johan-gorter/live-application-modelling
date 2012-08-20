package org.instantlogic.designer;

public class NumberDataCategoryDesignEntityGenerator extends EntityDesign {

    public static final NumberDataCategoryDesignEntityGenerator ENTITY = new NumberDataCategoryDesignEntityGenerator();
    
    private NumberDataCategoryDesignEntityGenerator() {
        setName("NumberDataCategoryDesign");
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Whole number")).setName("int"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Fractional number")).setName("double"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Fractional number (exact rounding)")).setName("decimal"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Percentage")).setName("percentage"));
    }
}
