package org.instantlogic.designer;


public class FragmentTextEntityGenerator extends EntityDesign {

    public static final FragmentTextEntityGenerator ENTITY = new FragmentTextEntityGenerator();
    
    private FragmentTextEntityGenerator() {
        setName("FragmentText");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign text = addRelation(ENTITY, "text", RelationType.OneToOneAggregation, TextDesignEntityGenerator.ENTITY)
            .setReverseName("textForFragment");

}