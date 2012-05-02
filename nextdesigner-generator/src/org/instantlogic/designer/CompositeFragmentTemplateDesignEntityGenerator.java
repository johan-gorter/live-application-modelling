package org.instantlogic.designer;


public class CompositeFragmentTemplateDesignEntityGenerator extends EntityDesign {

    public static final CompositeFragmentTemplateDesignEntityGenerator ENTITY = new CompositeFragmentTemplateDesignEntityGenerator();
    
    public CompositeFragmentTemplateDesignEntityGenerator() {
        setName("CompositeFragmentTemplateDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign items = addRelation("items", RelationType.OneToManyAggregation, PageCompositionDesignEntityGenerator.ENTITY)
            .setReverseName("itemIn");

}