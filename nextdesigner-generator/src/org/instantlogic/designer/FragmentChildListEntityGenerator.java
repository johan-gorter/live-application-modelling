package org.instantlogic.designer;


public class FragmentChildListEntityGenerator extends EntityDesign {

    public static final FragmentChildListEntityGenerator ENTITY = new FragmentChildListEntityGenerator();
    
    private FragmentChildListEntityGenerator() {
        setName("FragmentChildList");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign children = addRelation(ENTITY, "children", RelationType.OneToManyAggregation, FragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("childrenForFragment");

}