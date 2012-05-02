package org.instantlogic.designer;


public class SharedFragmentTemplateDefinitionDesignEntityGenerator extends EntityDesign {

    public static final SharedFragmentTemplateDefinitionDesignEntityGenerator ENTITY = new SharedFragmentTemplateDefinitionDesignEntityGenerator();
    
    public SharedFragmentTemplateDefinitionDesignEntityGenerator() {
        setName("SharedFragmentTemplateDefinitionDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Attributes
    public final RelationDesign fragment = addRelation("fragment", RelationType.OneToOneAggregation, FragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("sharedTemplateDefinition");

}