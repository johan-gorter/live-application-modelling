package org.instantlogic.designer;


public class PageFragmentHolderDesignEntityGenerator extends EntityDesign {

    public static final PageFragmentHolderDesignEntityGenerator ENTITY = new PageFragmentHolderDesignEntityGenerator();
    
    public PageFragmentHolderDesignEntityGenerator() {
        setName("PageFragmentHolderDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign pageFragment = addRelation("pageFragment", RelationType.OneToOneAggregation, PageFragmentDesignEntityGenerator.ENTITY)
            .setReverseName("holder");

}