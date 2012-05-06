package org.instantlogic.designer;


public class EntityDesignEntityGenerator extends EntityDesign {

    public static final EntityDesignEntityGenerator ENTITY = new EntityDesignEntityGenerator();
    
    public EntityDesignEntityGenerator() {
        setName("EntityDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes

    // Relations
    public final RelationDesign extendsFrom = addRelation("extendsFrom", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("extensions");
    public final RelationDesign attributes = addRelation("attributes", RelationType.OneToManyAggregation, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("belongsToEntity");
    public final RelationDesign relations = addRelation("relations", RelationType.OneToManyAggregation, RelationDesignEntityGenerator.ENTITY)
            .setReverseName("from");

}