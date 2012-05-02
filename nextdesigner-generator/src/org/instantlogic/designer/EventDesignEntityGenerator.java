package org.instantlogic.designer;


public class EventDesignEntityGenerator extends EntityDesign {

    public static final EventDesignEntityGenerator ENTITY = new EventDesignEntityGenerator();
    
    public EventDesignEntityGenerator() {
        setName("EventDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Attributes
    public final RelationDesign parameters = addRelation("parameters", RelationType.ManyToMany, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("parameterInEvent");

}