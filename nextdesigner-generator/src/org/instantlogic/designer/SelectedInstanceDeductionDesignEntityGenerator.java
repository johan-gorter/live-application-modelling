package org.instantlogic.designer;


public class SelectedInstanceDeductionDesignEntityGenerator extends EntityDesign {

    public static final SelectedInstanceDeductionDesignEntityGenerator ENTITY = new SelectedInstanceDeductionDesignEntityGenerator();
    
    public SelectedInstanceDeductionDesignEntityGenerator() {
        setName("SelectedInstanceDeductionDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign ofEntity = addRelation("ofEntity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("entityInSelectedInstanceDeductions");

}