package org.instantlogic.designer;


public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    public DeductionDesignEntityGenerator() {
        setName("DeductionDesign");
    }

    // Attributes
    public final AttributeDesign multivalue = addAttribute("multivalue", java.lang.Boolean.class);
    public final AttributeDesign className = addAttribute("className", java.lang.String.class);
    public final AttributeDesign customization = addAttribute("customization", java.lang.String.class);

    // Attributes
    public final RelationDesign inputs = addRelation("inputs", RelationType.ManyToMany, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("outputs");

}