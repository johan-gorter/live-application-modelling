package org.instantlogic.designer;


public class HeaderDesignEntityGenerator extends EntityDesign {

    public static final HeaderDesignEntityGenerator ENTITY = new HeaderDesignEntityGenerator();
    
    public HeaderDesignEntityGenerator() {
        setName("HeaderDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign text = addRelation("text", RelationType.OneToOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("textOnHeader");

}