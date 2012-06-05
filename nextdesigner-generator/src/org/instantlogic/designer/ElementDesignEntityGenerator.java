package org.instantlogic.designer;


public class ElementDesignEntityGenerator extends EntityDesign {

    public static final ElementDesignEntityGenerator ENTITY = new ElementDesignEntityGenerator();
    
    private ElementDesignEntityGenerator() {
        setName("ElementDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }
}