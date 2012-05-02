package org.instantlogic.designer;


public class CompositeTemplateDesignEntityGenerator extends EntityDesign {

    public static final CompositeTemplateDesignEntityGenerator ENTITY = new CompositeTemplateDesignEntityGenerator();
    
    public CompositeTemplateDesignEntityGenerator() {
        setName("CompositeTemplateDesign");
        setExtendsFrom(FragmentTemplateDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Attributes
    public final RelationDesign children = addRelation("children", RelationType.OneToManyAggregation, FragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("childOf");
    public final RelationDesign selections = addRelation("selections", RelationType.OneToManyAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("compositeTemplate");

}