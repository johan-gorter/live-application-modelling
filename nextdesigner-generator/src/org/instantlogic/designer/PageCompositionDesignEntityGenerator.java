package org.instantlogic.designer;


public class PageCompositionDesignEntityGenerator extends EntityDesign {

    public static final PageCompositionDesignEntityGenerator ENTITY = new PageCompositionDesignEntityGenerator();
    
    public PageCompositionDesignEntityGenerator() {
        setName("PageCompositionDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign pageFragment = addRelation("pageFragment", RelationType.OneToZeroOrOneAggregation, PageFragmentDesignEntityGenerator.ENTITY)
            .setReverseName("composedIn");

}