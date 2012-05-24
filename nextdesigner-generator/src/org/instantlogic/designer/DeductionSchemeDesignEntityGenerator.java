package org.instantlogic.designer;


public class DeductionSchemeDesignEntityGenerator extends EntityDesign {

    public static final DeductionSchemeDesignEntityGenerator ENTITY = new DeductionSchemeDesignEntityGenerator();
    
    private DeductionSchemeDesignEntityGenerator() {
        setName("DeductionSchemeDesign");
    }

    // Attributes

    // Relations
    public static final RelationDesign deductions = addRelation(ENTITY, "deductions", RelationType.OneToManyAggregation, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("scheme");
    public static final RelationDesign output = addRelation(ENTITY, "output", RelationType.OneToZeroOrOne, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("schemeOutput");

}