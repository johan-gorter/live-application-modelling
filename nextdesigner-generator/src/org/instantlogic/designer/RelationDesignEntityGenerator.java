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
    public static final AttributeDesign reverseTechnicalName = addAttribute(ENTITY, "reverseTechnicalName", java.lang.String.class);
    public static final AttributeDesign reverseJavaIdentifier = addAttribute(ENTITY, "reverseJavaIdentifier", java.lang.String.class);

    // Relations
    public static final RelationDesign to = addRelation(ENTITY, "to", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("reverseRelations");

    @Override
    public void init() {
    	super.init();
    	
    	reverseTechnicalName.setReadOnly(true);
    	reverseTechnicalName.setRule(createCustomDeduction("org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction", "java.lang.String"));

    	reverseJavaIdentifier.setReadOnly(true);
    	reverseJavaIdentifier.setRule(createCustomDeduction("org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction", "java.lang.String"));
    }
    
}