package org.instantlogic.designer;


public class FragmentTemplateDesignEntityGenerator extends EntityDesign {

    public static final FragmentTemplateDesignEntityGenerator ENTITY = new FragmentTemplateDesignEntityGenerator();
    
    private FragmentTemplateDesignEntityGenerator() {
        setName("FragmentTemplateDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign fragmentTypeName = addAttribute(ENTITY, "fragmentTypeName", java.lang.String.class);

    // Relations
    public static final RelationDesign attribute = addRelation(ENTITY, "attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("usedInField");
    public static final RelationDesign entity = addRelation(ENTITY, "entity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("usedInField");
    public static final RelationDesign event = addRelation(ENTITY, "event", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("triggeredByFragment");
    public static final RelationDesign properties = addRelation(ENTITY, "properties", RelationType.OneToManyAggregation, PropertyDesignEntityGenerator.ENTITY)
            .setReverseName("fragment");
}