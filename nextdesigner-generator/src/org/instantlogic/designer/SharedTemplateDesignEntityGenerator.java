package org.instantlogic.designer;


public class SharedTemplateDesignEntityGenerator extends EntityDesign {

    public static final SharedTemplateDesignEntityGenerator ENTITY = new SharedTemplateDesignEntityGenerator();
    
    private SharedTemplateDesignEntityGenerator() {
        setName("SharedTemplateDesign");
        setExtendsFrom(FragmentTemplateDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign definition = addRelation(ENTITY, "definition", RelationType.ManyToZeroOrOne, SharedFragmentTemplateDefinitionDesignEntityGenerator.ENTITY)
            .setReverseName("usages");

}