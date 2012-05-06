package org.instantlogic.designer;


public class DeductionSchemeDesignEntityGenerator extends EntityDesign {

    public static final DeductionSchemeDesignEntityGenerator ENTITY = new DeductionSchemeDesignEntityGenerator();
    
    public DeductionSchemeDesignEntityGenerator() {
        setName("DeductionSchemeDesign");
    }

    // Attributes

    // Relations
    public final RelationDesign deductions = addRelation("deductions", RelationType.OneToManyAggregation, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("scheme");
    public final RelationDesign output = addRelation("output", RelationType.OneToZeroOrOne, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("schemeOutput");

}