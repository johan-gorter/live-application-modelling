package org.instantlogic.designer;


public class TemplatedTextDesignEntityGenerator extends EntityDesign {

    public static final TemplatedTextDesignEntityGenerator ENTITY = new TemplatedTextDesignEntityGenerator();
    
    private TemplatedTextDesignEntityGenerator() {
        setName("TemplatedTextDesign");
        setExtendsFrom(TextDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign untranslated = addRelation(ENTITY, "untranslated", RelationType.OneToManyAggregation, StringProducerDesignEntityGenerator.ENTITY)
            .setReverseName("untranslatedInTemplate");

}