package org.instantlogic.designer;

import org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction;
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
    
    // Relations
    public static final RelationDesign dateType = addRelation(ENTITY, "dataType", RelationType.OneToOneAggregation, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign question = addRelation(ENTITY, "question", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    public static final RelationDesign explanation = addRelation(ENTITY, "explanation", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    public static final RelationDesign relevance = addRelation(ENTITY, "relevance", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
    public static final RelationDesign rule = addRelation(ENTITY, "rule", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
    public static final RelationDesign _default = addRelation(ENTITY, "default", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
}