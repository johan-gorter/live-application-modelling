package org.instantlogic.designer;


public class RelationDesignEntityGenerator extends EntityDesign {

    public static final RelationDesignEntityGenerator ENTITY = new RelationDesignEntityGenerator();
    
    private RelationDesignEntityGenerator() {
        setName("RelationDesign");
        setExtendsFrom(AttributeDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign owner = addAttribute(ENTITY, "owner", java.lang.Boolean.class);
    public static final AttributeDesign autoCreate = addAttribute(ENTITY, "autoCreate", java.lang.Boolean.class);
    public static final AttributeDesign reverseMultivalue = addAttribute(ENTITY, "reverseMultivalue", java.lang.Boolean.class);
    public static final AttributeDesign reverseName = addAttribute(ENTITY, "reverseName", java.lang.String.class);

    // Relations
    public static final RelationDesign to = addRelation(ENTITY, "to", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("reverseRelations");

}