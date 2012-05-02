package org.instantlogic.designer;


public class WidgetTextEntityGenerator extends EntityDesign {

    public static final WidgetTextEntityGenerator ENTITY = new WidgetTextEntityGenerator();
    
    public WidgetTextEntityGenerator() {
        setName("WidgetText");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Attributes
    public final RelationDesign text = addRelation("text", RelationType.OneToOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("textForWidget");

}