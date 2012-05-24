package org.instantlogic.designer;


public class SelectedInstanceDeductionDesignEntityGenerator extends EntityDesign {

    public static final SelectedInstanceDeductionDesignEntityGenerator ENTITY = new SelectedInstanceDeductionDesignEntityGenerator();
    
    private SelectedInstanceDeductionDesignEntityGenerator() {
        setName("SelectedInstanceDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign ofEntity = addRelation(ENTITY, "ofEntity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("entityInSelectedInstanceDeductions");

}