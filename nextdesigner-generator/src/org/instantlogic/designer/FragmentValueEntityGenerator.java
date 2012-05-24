package org.instantlogic.designer;


public class FragmentValueEntityGenerator extends EntityDesign {

    public static final FragmentValueEntityGenerator ENTITY = new FragmentValueEntityGenerator();
    
    private FragmentValueEntityGenerator() {
        setName("FragmentValue");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign deduction = addRelation(ENTITY, "deduction", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("valueForFragment");

}