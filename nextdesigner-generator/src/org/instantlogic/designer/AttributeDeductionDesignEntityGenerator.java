package org.instantlogic.designer;


public class AttributeDeductionDesignEntityGenerator extends EntityDesign {

    public static final AttributeDeductionDesignEntityGenerator ENTITY = new AttributeDeductionDesignEntityGenerator();
    
    private AttributeDeductionDesignEntityGenerator() {
        setName("AttributeDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign attribute = addRelation(ENTITY, "attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("attributeInDeductions");

}