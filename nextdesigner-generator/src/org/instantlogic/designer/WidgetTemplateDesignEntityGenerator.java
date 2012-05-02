package org.instantlogic.designer;


public class WidgetTemplateDesignEntityGenerator extends EntityDesign {

    public static final WidgetTemplateDesignEntityGenerator ENTITY = new WidgetTemplateDesignEntityGenerator();
    
    public WidgetTemplateDesignEntityGenerator() {
        setName("WidgetTemplateDesign");
        setExtendsFrom(FragmentTemplateDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public final AttributeDesign widgetTypeName = addAttribute("widgetTypeName", java.lang.String.class);

    // Attributes
    public final RelationDesign attribute = addRelation("attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("usedInField");
    public final RelationDesign entity = addRelation("entity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("usedInField");
    public final RelationDesign event = addRelation("event", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY)
            .setReverseName("triggeredByWidget");
    public final RelationDesign values = addRelation("values", RelationType.OneToManyAggregation, WidgetValueEntityGenerator.ENTITY)
            .setReverseName("widget");
    public final RelationDesign texts = addRelation("texts", RelationType.OneToManyAggregation, WidgetTextEntityGenerator.ENTITY)
            .setReverseName("widget");
    public final RelationDesign childLists = addRelation("childLists", RelationType.OneToManyAggregation, WidgetChildListEntityGenerator.ENTITY)
            .setReverseName("widget");

}