package org.instantlogic.designer;

import org.instantlogic.designer.deduction.DeductionDataTypeDeduction;


public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionDesign");
        setIsCustomized(true);
    }

    // Attributes
    // TODO: remove these 3
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class);
    public static final AttributeDesign javaClassName = addAttribute(ENTITY, "javaClassName", java.lang.String.class);
    public static final AttributeDesign customization = addAttribute(ENTITY, "customization", java.lang.String.class);

    // Relations
    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.ManyToMany, DeductionDesignEntityGenerator.ENTITY)
    	.setReverseName("outputs");
    
    @Override
    public void init() {
    	dataType.setReadOnly(true);
    	dataType.setRule(new DeductionSchemeDesign().deduceCustom(DeductionDataTypeDeduction.class, DataTypeDesign.class).getScheme());
    }
}