package org.instantlogic.designer;


public class SubFlowDesignEntityGenerator extends EntityDesign {

    public static final SubFlowDesignEntityGenerator ENTITY = new SubFlowDesignEntityGenerator();
    
    public SubFlowDesignEntityGenerator() {
        setName("SubFlowDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign flow = addRelation("flow", RelationType.OneToZeroOrOne, FlowDesignEntityGenerator.ENTITY)
            .setReverseName("subFlowIn");

}