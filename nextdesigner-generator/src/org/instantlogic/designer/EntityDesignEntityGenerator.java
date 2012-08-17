package org.instantlogic.designer;


public class EntityDesignEntityGenerator extends EntityDesign {

    public static final EntityDesignEntityGenerator ENTITY = new EntityDesignEntityGenerator();
    
    private EntityDesignEntityGenerator() {
        setName("EntityDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes

    // Relations
    public static final RelationDesign extendsFrom = addRelation(ENTITY, "extendsFrom", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("extensions");
    public static final RelationDesign attributes = addRelation(ENTITY, "attributes", RelationType.OneToManyAggregation, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("belongsToEntity");
    public static final RelationDesign relations = addRelation(ENTITY, "relations", RelationType.OneToManyAggregation, RelationDesignEntityGenerator.ENTITY)
            .setReverseName("from");
    public static final RelationDesign staticInstances = addRelation(ENTITY, "staticInstances", RelationType.OneToManyAggregation, StaticInstanceDesignEntityGenerator.ENTITY)
            .setReverseName("entity");

}