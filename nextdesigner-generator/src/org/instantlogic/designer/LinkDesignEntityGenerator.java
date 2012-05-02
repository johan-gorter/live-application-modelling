package org.instantlogic.designer;


public class LinkDesignEntityGenerator extends EntityDesign {

    public static final LinkDesignEntityGenerator ENTITY = new LinkDesignEntityGenerator();
    
    public LinkDesignEntityGenerator() {
        setName("LinkDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign caption = addRelation("caption", RelationType.OneToOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("captionOnButton");
    public final RelationDesign event = addRelation("event", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("firesFromButtons");

}