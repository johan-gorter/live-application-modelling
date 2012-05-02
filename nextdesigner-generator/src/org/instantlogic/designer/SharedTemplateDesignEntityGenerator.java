package org.instantlogic.designer;


public class SharedTemplateDesignEntityGenerator extends EntityDesign {

    public static final SharedTemplateDesignEntityGenerator ENTITY = new SharedTemplateDesignEntityGenerator();
    
    public SharedTemplateDesignEntityGenerator() {
        setName("SharedTemplateDesign");
        setExtendsFrom(FragmentTemplateDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Attributes
    public final RelationDesign definition = addRelation("definition", RelationType.ManyToZeroOrOne, SharedFragmentTemplateDefinitionDesignEntityGenerator.ENTITY)
            .setReverseName("usages");

}