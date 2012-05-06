package org.instantlogic.designer;


public class SharedTextDesignEntityGenerator extends EntityDesign {

    public static final SharedTextDesignEntityGenerator ENTITY = new SharedTextDesignEntityGenerator();
    
    public SharedTextDesignEntityGenerator() {
        setName("SharedTextDesign");
        setExtendsFrom(TextDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}