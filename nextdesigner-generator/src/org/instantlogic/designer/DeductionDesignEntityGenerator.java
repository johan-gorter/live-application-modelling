package org.instantlogic.designer;


public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionDesign");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class); // TODO: actually use this attribute
    public static final AttributeDesign javaClassName = addAttribute(ENTITY, "javaClassName", java.lang.String.class);
    public static final AttributeDesign customization = addAttribute(ENTITY, "customization", java.lang.String.class);

    // Relations
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.ManyToMany, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("outputs");

}