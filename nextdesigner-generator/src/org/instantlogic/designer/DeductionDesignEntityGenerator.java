package org.instantlogic.designer;

import org.instantlogic.designer.deduction.DeductionTypeDeduction;


public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionDesign");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class); // TODO: Introduce a Type class encapsulating all Type information
    public static final AttributeDesign javaClassName = addAttribute(ENTITY, "javaClassName", java.lang.String.class);
    public static final AttributeDesign customization = addAttribute(ENTITY, "customization", java.lang.String.class);

    // Relations
    public static final RelationDesign type = addRelation(ENTITY, "type", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.ManyToMany, DeductionDesignEntityGenerator.ENTITY)
    	.setReverseName("outputs");
    
    @Override
    public void init() {
    	type.setReadOnly(true);
    	type.setRule(new DeductionSchemeDesign().deduceCustom(DeductionTypeDeduction.class, DataTypeDesign.class).getScheme());
    }
}