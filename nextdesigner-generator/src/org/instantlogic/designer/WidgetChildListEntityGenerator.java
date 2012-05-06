package org.instantlogic.designer;


public class WidgetChildListEntityGenerator extends EntityDesign {

    public static final WidgetChildListEntityGenerator ENTITY = new WidgetChildListEntityGenerator();
    
    public WidgetChildListEntityGenerator() {
        setName("WidgetChildList");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign children = addRelation("children", RelationType.OneToManyAggregation, FragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("childrenForWidget");

}