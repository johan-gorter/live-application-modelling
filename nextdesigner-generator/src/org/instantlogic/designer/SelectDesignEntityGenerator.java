package org.instantlogic.designer;


public class SelectDesignEntityGenerator extends EntityDesign {

    public static final SelectDesignEntityGenerator ENTITY = new SelectDesignEntityGenerator();
    
    public SelectDesignEntityGenerator() {
        setName("SelectDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign deduction = addRelation("deduction", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("select");

}