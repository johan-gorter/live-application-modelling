package org.instantlogic.designer;


public class ReverseRelationDeductionDesignEntityGenerator extends EntityDesign {

    public static final ReverseRelationDeductionDesignEntityGenerator ENTITY = new ReverseRelationDeductionDesignEntityGenerator();
    
    private ReverseRelationDeductionDesignEntityGenerator() {
        setName("ReverseRelationDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign relation = addRelation(ENTITY, "relation", RelationType.ManyToZeroOrOne, RelationDesignEntityGenerator.ENTITY)
            .setReverseName("relationInDeductions");

}