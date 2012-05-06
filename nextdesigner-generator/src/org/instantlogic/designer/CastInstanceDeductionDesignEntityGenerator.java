package org.instantlogic.designer;


public class CastInstanceDeductionDesignEntityGenerator extends EntityDesign {

    public static final CastInstanceDeductionDesignEntityGenerator ENTITY = new CastInstanceDeductionDesignEntityGenerator();
    
    public CastInstanceDeductionDesignEntityGenerator() {
        setName("CastInstanceDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign toEntity = addRelation("toEntity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("entityInCastDeductions");

}