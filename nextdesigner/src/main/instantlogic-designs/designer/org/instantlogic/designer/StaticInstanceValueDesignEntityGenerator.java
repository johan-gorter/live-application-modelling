package org.instantlogic.designer;



public class StaticInstanceValueDesignEntityGenerator extends EntityDesign {

    public static final StaticInstanceValueDesignEntityGenerator ENTITY = new StaticInstanceValueDesignEntityGenerator();
    
    private StaticInstanceValueDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("StaticInstanceValueDesign");
    }

    // Attributes
    public static final AttributeDesign value = addAttribute(ENTITY, "value", java.lang.Object.class);

    // Relations
    public static final RelationDesign attribute = addRelation(ENTITY, "attribute", RelationType.OneToZeroOrOne, AttributeDesignEntityGenerator.ENTITY);
    
    //TODO: pairs of attribute and value
}