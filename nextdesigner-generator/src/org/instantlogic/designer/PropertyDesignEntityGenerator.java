package org.instantlogic.designer;




public class PropertyDesignEntityGenerator extends EntityDesign {

    public static final PropertyDesignEntityGenerator ENTITY = new PropertyDesignEntityGenerator();
    
    private PropertyDesignEntityGenerator() {
        setName("PropertyDesign");
    }

    // Attributes
    public static final AttributeDesign propertyName = addAttribute(ENTITY, "propertyName", java.lang.String.class);

    // Relations
    public static final RelationDesign children = addRelation(ENTITY, "children", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY)
            .setReverseName("childrenForFragment");
    public static final RelationDesign text = addRelation(ENTITY, "text", RelationType.OneToZeroOrOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("textForFragment");
    public static final RelationDesign value = addRelation(ENTITY, "value", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("valueForFragment");
    

}