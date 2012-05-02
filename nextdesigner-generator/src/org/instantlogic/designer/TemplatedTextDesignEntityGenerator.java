package org.instantlogic.designer;


public class TemplatedTextDesignEntityGenerator extends EntityDesign {

    public static final TemplatedTextDesignEntityGenerator ENTITY = new TemplatedTextDesignEntityGenerator();
    
    public TemplatedTextDesignEntityGenerator() {
        setName("TemplatedTextDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign untranslated = addRelation("untranslated", RelationType.OneToManyAggregation, StringProducerDesignEntityGenerator.ENTITY)
            .setReverseName("untranslatedInTemplate");

}