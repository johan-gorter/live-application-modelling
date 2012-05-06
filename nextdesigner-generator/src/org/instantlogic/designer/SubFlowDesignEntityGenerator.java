package org.instantlogic.designer;


public class SubFlowDesignEntityGenerator extends EntityDesign {

    public static final SubFlowDesignEntityGenerator ENTITY = new SubFlowDesignEntityGenerator();
    
    public SubFlowDesignEntityGenerator() {
        setName("SubFlowDesign");
        setExtendsFrom(FlowNodeBaseDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign flow = addRelation("flow", RelationType.OneToZeroOrOne, FlowDesignEntityGenerator.ENTITY)
            .setReverseName("subFlowIn");

}