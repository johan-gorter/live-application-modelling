package org.instantlogic.designer;

public class TextDataCategoryDesignEntityGenerator extends EntityDesign {

    public static final TextDataCategoryDesignEntityGenerator ENTITY = new TextDataCategoryDesignEntityGenerator();
    
    private TextDataCategoryDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("TextDataCategoryDesign");
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Single line of text")).setName("singleline"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Multiple lines of text")).setName("multiline"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Formatted text")).setName("formatted"));
    }
}
