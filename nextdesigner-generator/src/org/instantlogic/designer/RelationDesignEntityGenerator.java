package org.instantlogic.designer;


public class RelationDesignEntityGenerator extends EntityDesign {

    public static final RelationDesignEntityGenerator ENTITY = new RelationDesignEntityGenerator();
    
    public RelationDesignEntityGenerator() {
        setName("RelationDesign");
        setExtendsFrom(AttributeDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public final AttributeDesign owner = addAttribute("owner", java.lang.Boolean.class);
    public final AttributeDesign autoCreate = addAttribute("autoCreate", java.lang.Boolean.class);
    public final AttributeDesign reverseMultivalue = addAttribute("reverseMultivalue", java.lang.Boolean.class);
    public final AttributeDesign reverseName = addAttribute("reverseName", java.lang.String.class);

    // Relations
    public final RelationDesign to = addRelation("to", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("reverseRelations");

}