package org.instantlogic.designer;


public class PageDesignEntityGenerator extends EntityDesign {

    public static final PageDesignEntityGenerator ENTITY = new PageDesignEntityGenerator();
    
    public PageDesignEntityGenerator() {
        setName("PageDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign content = addRelation("content", RelationType.OneToOneAggregation, CompositeFragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("contentOfPage");

}