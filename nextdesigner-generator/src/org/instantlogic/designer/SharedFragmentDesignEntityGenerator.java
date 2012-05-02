package org.instantlogic.designer;


public class SharedFragmentDesignEntityGenerator extends EntityDesign {

    public static final SharedFragmentDesignEntityGenerator ENTITY = new SharedFragmentDesignEntityGenerator();
    
    public SharedFragmentDesignEntityGenerator() {
        setName("SharedFragmentDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign pageFragmentHolder = addRelation("pageFragmentHolder", RelationType.ManyToZeroOrOne, PageFragmentHolderDesignEntityGenerator.ENTITY)
            .setReverseName("usages");

}