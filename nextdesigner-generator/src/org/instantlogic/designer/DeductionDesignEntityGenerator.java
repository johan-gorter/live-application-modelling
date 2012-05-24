package org.instantlogic.designer;


public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
        setName("DeductionDesign");
    }

    // Attributes
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class);
    public static final AttributeDesign className = addAttribute(ENTITY, "className", java.lang.String.class);
    public static final AttributeDesign customization = addAttribute(ENTITY, "customization", java.lang.String.class);

    // Relations
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.ManyToMany, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("outputs");

}