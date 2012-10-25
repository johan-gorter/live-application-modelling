package org.instantlogic.designer;


public class ElementDesignEntityGenerator extends EntityDesign {

    public static final ElementDesignEntityGenerator ENTITY = new ElementDesignEntityGenerator();
    
    // Attributes
    public static final AttributeDesign editorOpen = addAttribute(ENTITY, "editorOpen", java.lang.Boolean.class);
    
    private ElementDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("ElementDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }
    
    @Override
    public void init() {
    	editorOpen.newDefault().deduceConstant(Boolean.class, Boolean.FALSE);
    }
}