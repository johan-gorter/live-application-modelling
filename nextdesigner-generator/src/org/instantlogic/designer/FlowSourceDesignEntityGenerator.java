package org.instantlogic.designer;


public class FlowSourceDesignEntityGenerator extends EntityDesign {

    public static final FlowSourceDesignEntityGenerator ENTITY = new FlowSourceDesignEntityGenerator();
    
    private FlowSourceDesignEntityGenerator() {
        setName("FlowSourceDesign");
    }

    // Attributes

    // Relations
    public static final RelationDesign startEvent = addRelation(ENTITY, "startEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("startEventInSources");
    public static final RelationDesign endNode = addRelation(ENTITY, "endNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("incomingSources");
    public static final RelationDesign endEvent = addRelation(ENTITY, "endEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("endEventInSources");

}