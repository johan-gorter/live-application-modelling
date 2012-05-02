package org.instantlogic.designer;


public class FormattedValueDesignEntityGenerator extends EntityDesign {

    public static final FormattedValueDesignEntityGenerator ENTITY = new FormattedValueDesignEntityGenerator();
    
    public FormattedValueDesignEntityGenerator() {
        setName("FormattedValueDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign deduction = addRelation("deduction", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("templatedText");

}