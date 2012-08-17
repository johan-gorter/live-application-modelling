package org.instantlogic.designer;



public class StaticInstanceDesignEntityGenerator extends EntityDesign {

    public static final StaticInstanceDesignEntityGenerator ENTITY = new StaticInstanceDesignEntityGenerator();
    
    private StaticInstanceDesignEntityGenerator() {
        setName("StaticInstanceDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign description = addRelation(ENTITY, "description", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY)
        .setReverseName("descriptionOnStaticInstance");
    
    //TODO: pairs of attribute and value
}