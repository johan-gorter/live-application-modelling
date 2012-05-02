package org.instantlogic.designer;


public class WidgetValueEntityGenerator extends EntityDesign {

    public static final WidgetValueEntityGenerator ENTITY = new WidgetValueEntityGenerator();
    
    public WidgetValueEntityGenerator() {
        setName("WidgetValue");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Attributes
    public final RelationDesign deduction = addRelation("deduction", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("valueForWidget");

}