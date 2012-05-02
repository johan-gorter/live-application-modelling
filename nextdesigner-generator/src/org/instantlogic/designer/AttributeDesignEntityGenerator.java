package org.instantlogic.designer;


public class AttributeDesignEntityGenerator extends EntityDesign {

    public static final AttributeDesignEntityGenerator ENTITY = new AttributeDesignEntityGenerator();
    
    public AttributeDesignEntityGenerator() {
        setName("AttributeDesign");
    }

    // Attributes
    public final AttributeDesign readOnly = addAttribute("readOnly", java.lang.Boolean.class);
    public final AttributeDesign multivalue = addAttribute("multivalue", java.lang.Boolean.class);
    public final AttributeDesign className = addAttribute("className", java.lang.String.class);

    // Attributes
    public final RelationDesign question = addRelation("question", RelationType.OneToZeroOrOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("questionOnAttribute");
    public final RelationDesign explanation = addRelation("explanation", RelationType.OneToZeroOrOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("explanationOnAttribute");
    public final RelationDesign domain = addRelation("domain", RelationType.OneToManyAggregation, DomainEntryDesignEntityGenerator.ENTITY)
            .setReverseName("attribute");
    public final RelationDesign relevance = addRelation("relevance", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("relevanceOfAttribute");
    public final RelationDesign rule = addRelation("rule", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("ruleOfAttribute");
    public final RelationDesign default = addRelation("default", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("defaultOfAttribute");

}