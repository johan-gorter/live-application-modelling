package org.instantlogic.designer;


public class AttributeDesignEntityGenerator extends EntityDesign {

    public static final AttributeDesignEntityGenerator ENTITY = new AttributeDesignEntityGenerator();
    
    private AttributeDesignEntityGenerator() {
        setName("AttributeDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign readOnly = addAttribute(ENTITY, "readOnly", java.lang.Boolean.class);
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class);
    public static final AttributeDesign className = addAttribute(ENTITY, "className", java.lang.String.class);

    // Relations
    public static final RelationDesign question = addRelation(ENTITY, "question", RelationType.OneToZeroOrOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("questionOnAttribute");
    public static final RelationDesign explanation = addRelation(ENTITY, "explanation", RelationType.OneToZeroOrOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("explanationOnAttribute");
    public static final RelationDesign domain = addRelation(ENTITY, "domain", RelationType.OneToManyAggregation, DomainEntryDesignEntityGenerator.ENTITY)
            .setReverseName("attribute");
    public static final RelationDesign relevance = addRelation(ENTITY, "relevance", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("relevanceOfAttribute");
    public static final RelationDesign rule = addRelation(ENTITY, "rule", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("ruleOfAttribute");
    public static final RelationDesign _default = addRelation(ENTITY, "default", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("defaultOfAttribute");

}