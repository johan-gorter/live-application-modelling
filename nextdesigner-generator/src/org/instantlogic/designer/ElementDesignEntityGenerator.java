package org.instantlogic.designer;


public class ElementDesignEntityGenerator extends EntityDesign {

    public static final ElementDesignEntityGenerator ENTITY = new ElementDesignEntityGenerator();
    
    private ElementDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("ElementDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }
}