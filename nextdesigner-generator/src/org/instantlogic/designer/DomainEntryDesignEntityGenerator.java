package org.instantlogic.designer;


public class DomainEntryDesignEntityGenerator extends EntityDesign {

    public static final DomainEntryDesignEntityGenerator ENTITY = new DomainEntryDesignEntityGenerator();
    
    private DomainEntryDesignEntityGenerator() {
        setName("DomainEntryDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign display = addRelation(ENTITY, "display", RelationType.OneToZeroOrOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("displayOnDomainEntry");

}