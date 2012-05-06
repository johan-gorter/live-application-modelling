package org.instantlogic.designer;


public class FlowEdgeDesignEntityGenerator extends EntityDesign {

    public static final FlowEdgeDesignEntityGenerator ENTITY = new FlowEdgeDesignEntityGenerator();
    
    public FlowEdgeDesignEntityGenerator() {
        setName("FlowEdgeDesign");
    }

    // Attributes

    // Relations
    public final RelationDesign startNode = addRelation("startNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("outgoingEdges");
    public final RelationDesign startEvent = addRelation("startEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("startEventInEdges");
    public final RelationDesign endNode = addRelation("endNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("incomingEdges");
    public final RelationDesign endEvent = addRelation("endEvent", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("endEventInEdges");

}