package org.instantlogic.designer;


public class FieldDesignEntityGenerator extends EntityDesign {

    public static final FieldDesignEntityGenerator ENTITY = new FieldDesignEntityGenerator();
    
    public FieldDesignEntityGenerator() {
        setName("FieldDesign");
    }

    // Attributes
    public final AttributeDesign required = addAttribute("required", java.lang.Boolean.class);
    public final AttributeDesign readOnly = addAttribute("readOnly", java.lang.Boolean.class);

    // Attributes
    public final RelationDesign attribute = addRelation("attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("fields");

}