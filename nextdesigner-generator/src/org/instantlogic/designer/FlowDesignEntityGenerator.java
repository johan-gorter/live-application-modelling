package org.instantlogic.designer;


public class FlowDesignEntityGenerator extends EntityDesign {

    public static final FlowDesignEntityGenerator ENTITY = new FlowDesignEntityGenerator();
    
    public FlowDesignEntityGenerator() {
        setName("FlowDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign sources = addRelation("sources", RelationType.OneToManyAggregation, FlowSourceDesignEntityGenerator.ENTITY)
            .setReverseName("owner");
    public final RelationDesign nodes = addRelation("nodes", RelationType.OneToManyAggregation, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("owner");
    public final RelationDesign edges = addRelation("edges", RelationType.OneToManyAggregation, FlowEdgeDesignEntityGenerator.ENTITY)
            .setReverseName("owner");
    public final RelationDesign parameters = addRelation("parameters", RelationType.ManyToMany, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("parameterInFlows");

}