package org.instantlogic.designer;


public class SharedElementDesignEntityGenerator extends EntityDesign {

    public static final SharedElementDesignEntityGenerator ENTITY = new SharedElementDesignEntityGenerator();
    
    private SharedElementDesignEntityGenerator() {
        setName("SharedElementDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign definition = addRelation(ENTITY, "definition", RelationType.ManyToZeroOrOne, SharedFragmentTemplateDefinitionDesignEntityGenerator.ENTITY)
            .setReverseName("usages");

}