package org.instantlogic.designer;


public class AttributeDeductionDesignEntityGenerator extends EntityDesign {

    public static final AttributeDeductionDesignEntityGenerator ENTITY = new AttributeDeductionDesignEntityGenerator();
    
    public AttributeDeductionDesignEntityGenerator() {
        setName("AttributeDeductionDesign");
    }

    // Attributes

    // Attributes
    public final RelationDesign attribute = addRelation("attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("attributeInDeductions");

}