package org.instantlogic.designer;


public class FlowEdgeDesignEntityGenerator extends EntityDesign {

    public static final FlowEdgeDesignEntityGenerator ENTITY = new FlowEdgeDesignEntityGenerator();
    
    private FlowEdgeDesignEntityGenerator() {
        setName("FlowEdgeDesign");
    }

    // Attributes

    // Relations
    public static final RelationDesign startNode = addRelation(ENTITY, "startNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("outgoingEdges");
    public static final RelationDesign startEvent = addRelation(ENTITY, "startEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("startEventInEdges");
    public static final RelationDesign endNode = addRelation(ENTITY, "endNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("incomingEdges");
    public static final RelationDesign endEvent = addRelation(ENTITY, "endEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("endEventInEdges");

}