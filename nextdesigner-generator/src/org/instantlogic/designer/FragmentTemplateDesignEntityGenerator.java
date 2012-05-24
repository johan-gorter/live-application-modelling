package org.instantlogic.designer;


public class FragmentTemplateDesignEntityGenerator extends EntityDesign {

    public static final FragmentTemplateDesignEntityGenerator ENTITY = new FragmentTemplateDesignEntityGenerator();
    
    private FragmentTemplateDesignEntityGenerator() {
        setName("FragmentTemplateDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign fragmentTypeName = addAttribute(ENTITY, "fragmentTypeName", java.lang.String.class);

    // Relations
    public static final RelationDesign selections = addRelation(ENTITY, "selections", RelationType.OneToManyAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("compositeTemplate");
    public static final RelationDesign attribute = addRelation(ENTITY, "attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("usedInField");
    public static final RelationDesign entity = addRelation(ENTITY, "entity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("usedInField");
    public static final RelationDesign event = addRelation(ENTITY, "event", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("triggeredByFragment");
    public static final RelationDesign values = addRelation(ENTITY, "values", RelationType.OneToManyAggregation, FragmentValueEntityGenerator.ENTITY)
            .setReverseName("fragment");
    public static final RelationDesign texts = addRelation(ENTITY, "texts", RelationType.OneToManyAggregation, FragmentTextEntityGenerator.ENTITY)
            .setReverseName("fragment");
    public static final RelationDesign childLists = addRelation(ENTITY, "childLists", RelationType.OneToManyAggregation, FragmentChildListEntityGenerator.ENTITY)
            .setReverseName("fragment");

}