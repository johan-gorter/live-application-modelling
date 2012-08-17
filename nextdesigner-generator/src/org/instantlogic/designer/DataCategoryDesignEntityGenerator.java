package org.instantlogic.designer;


public class DataCategoryDesignEntityGenerator extends EntityDesign {

    public static final DataCategoryDesignEntityGenerator ENTITY = new DataCategoryDesignEntityGenerator();
    
    private DataCategoryDesignEntityGenerator() {
        setName("DataCategoryDesign");
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Text")).setName("text"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Number")).setName("number"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Choice")).setName("choice"));
    }
}
