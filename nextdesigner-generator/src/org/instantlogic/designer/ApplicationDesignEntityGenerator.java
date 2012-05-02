package org.instantlogic.designer;


public class ApplicationDesignEntityGenerator extends EntityDesign {

    public static final ApplicationDesignEntityGenerator ENTITY = new ApplicationDesignEntityGenerator();
    
    public ApplicationDesignEntityGenerator() {
        setName("ApplicationDesign");
        setIsCustomized(true);
    }

    // Attributes
    public final AttributeDesign name = addAttribute("name", java.lang.String.class);
    public final AttributeDesign rootPackageName = addAttribute("rootPackageName", java.lang.String.class);
    public final AttributeDesign sourcePath = addAttribute("sourcePath", java.lang.String.class);
    public final AttributeDesign isCustomized = addAttribute("isCustomized", java.lang.Boolean.class);

    // Attributes
    public final RelationDesign entities = addRelation("entities", RelationType.OneToManyAggregation, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public final RelationDesign caseEntity = addRelation("caseEntity", RelationType.OneToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("caseEntityInApplication");
    public final RelationDesign flows = addRelation("flows", RelationType.OneToManyAggregation, FlowDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public final RelationDesign events = addRelation("events", RelationType.OneToManyAggregation, EventDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public final RelationDesign exposedFlows = addRelation("exposedFlows", RelationType.OneToMany, FlowDesignEntityGenerator.ENTITY)
            .setReverseName("exposedFlowInApplication");
    public final RelationDesign sharedTemplates = addRelation("sharedTemplates", RelationType.OneToManyAggregation, SharedFragmentTemplateDefinitionDesignEntityGenerator.ENTITY)
            .setReverseName("application");

}