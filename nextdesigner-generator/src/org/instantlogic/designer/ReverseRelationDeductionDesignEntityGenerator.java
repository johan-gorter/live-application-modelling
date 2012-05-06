package org.instantlogic.designer;


public class ReverseRelationDeductionDesignEntityGenerator extends EntityDesign {

    public static final ReverseRelationDeductionDesignEntityGenerator ENTITY = new ReverseRelationDeductionDesignEntityGenerator();
    
    public ReverseRelationDeductionDesignEntityGenerator() {
        setName("ReverseRelationDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign relation = addRelation("relation", RelationType.ManyToZeroOrOne, RelationDesignEntityGenerator.ENTITY)
            .setReverseName("relationInDeductions");

}