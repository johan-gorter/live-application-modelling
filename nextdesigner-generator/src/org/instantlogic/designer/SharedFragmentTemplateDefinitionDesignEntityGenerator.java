package org.instantlogic.designer;


public class SharedFragmentTemplateDefinitionDesignEntityGenerator extends EntityDesign {

    public static final SharedFragmentTemplateDefinitionDesignEntityGenerator ENTITY = new SharedFragmentTemplateDefinitionDesignEntityGenerator();
    
    private SharedFragmentTemplateDefinitionDesignEntityGenerator() {
        setName("SharedFragmentTemplateDefinitionDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign fragment = addRelation(ENTITY, "fragment", RelationType.OneToOneAggregation, ElementDesignEntityGenerator.ENTITY)
            .setReverseName("sharedTemplateDefinition");

}