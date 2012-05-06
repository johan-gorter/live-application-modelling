package org.instantlogic.designer;


public class SelectedInstanceDeductionDesignEntityGenerator extends EntityDesign {

    public static final SelectedInstanceDeductionDesignEntityGenerator ENTITY = new SelectedInstanceDeductionDesignEntityGenerator();
    
    public SelectedInstanceDeductionDesignEntityGenerator() {
        setName("SelectedInstanceDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign ofEntity = addRelation("ofEntity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("entityInSelectedInstanceDeductions");

}