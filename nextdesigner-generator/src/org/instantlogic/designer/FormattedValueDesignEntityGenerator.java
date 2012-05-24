package org.instantlogic.designer;


public class FormattedValueDesignEntityGenerator extends EntityDesign {

    public static final FormattedValueDesignEntityGenerator ENTITY = new FormattedValueDesignEntityGenerator();
    
    private FormattedValueDesignEntityGenerator() {
        setName("FormattedValueDesign");
        setExtendsFrom(StringProducerDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign deduction = addRelation(ENTITY, "deduction", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("templatedText");

}