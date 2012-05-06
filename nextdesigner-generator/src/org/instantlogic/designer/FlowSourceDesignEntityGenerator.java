package org.instantlogic.designer;


public class FlowSourceDesignEntityGenerator extends EntityDesign {

    public static final FlowSourceDesignEntityGenerator ENTITY = new FlowSourceDesignEntityGenerator();
    
    public FlowSourceDesignEntityGenerator() {
        setName("FlowSourceDesign");
    }

    // Attributes

    // Relations
    public final RelationDesign startEvent = addRelation("startEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("startEventInSources");
    public final RelationDesign endNode = addRelation("endNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("incomingSources");
    public final RelationDesign endEvent = addRelation("endEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("endEventInSources");

}