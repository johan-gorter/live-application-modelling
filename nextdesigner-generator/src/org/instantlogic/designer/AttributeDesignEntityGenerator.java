package org.instantlogic.designer;

import org.instantlogic.designer.deduction.AttributeJavaClassNameDeduction;
import org.instantlogic.designer.util.Deductions;


public class AttributeDesignEntityGenerator extends EntityDesign {

    public static final AttributeDesignEntityGenerator ENTITY = new AttributeDesignEntityGenerator();
    
    private AttributeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("AttributeDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign readOnly = addAttribute(ENTITY, "readOnly", java.lang.Boolean.class);
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class);
    public static final AttributeDesign javaClassName = addAttribute(ENTITY, "javaClassName", java.lang.String.class);
    
    // Only relevant when dataCategory == number
    public static final AttributeDesign percentage = addAttribute(ENTITY, "percentage", java.lang.Boolean.class);
    public static final AttributeDesign wholeNumber = addAttribute(ENTITY, "wholeNumber", java.lang.Boolean.class);
    public static final AttributeDesign exactRounding = addAttribute(ENTITY, "exactRounding", java.lang.Boolean.class);

    // Relations
    public static final RelationDesign dataCategory = addRelation(ENTITY, "dataCategory", RelationType.OneToZeroOrOne, DataCategoryDesignEntityGenerator.ENTITY);
    public static final RelationDesign textDataCategory = addRelation(ENTITY, "textDataCategory", RelationType.OneToZeroOrOne, TextDataCategoryDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign question = addRelation(ENTITY, "question", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    public static final RelationDesign explanation = addRelation(ENTITY, "explanation", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    public static final RelationDesign relevance = addRelation(ENTITY, "relevance", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
    public static final RelationDesign rule = addRelation(ENTITY, "rule", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
    public static final RelationDesign _default = addRelation(ENTITY, "default", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
    
    @Override
    public void init() {
    	javaClassName.setDefault(Deductions.toScheme(Deductions.custom(AttributeJavaClassNameDeduction.class, String.class)));
    	// TODO: relevance for 'percentage', 'whole number' and 'exact rounding'
    }

}