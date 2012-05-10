package org.instantlogic.designer;


public class DomainEntryDesignEntityGenerator extends EntityDesign {

    public static final DomainEntryDesignEntityGenerator ENTITY = new DomainEntryDesignEntityGenerator();
    
    public DomainEntryDesignEntityGenerator() {
        setName("DomainEntryDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign display = addRelation("display", RelationType.OneToZeroOrOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("displayOnDomainEntry");

}