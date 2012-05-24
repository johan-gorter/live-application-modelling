package org.instantlogic.designer;


public class TextDesignEntityGenerator extends EntityDesign {

    public static final TextDesignEntityGenerator ENTITY = new TextDesignEntityGenerator();
    
    private TextDesignEntityGenerator() {
        setName("TextDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}