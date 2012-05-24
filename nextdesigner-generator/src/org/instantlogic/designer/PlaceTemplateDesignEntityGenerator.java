package org.instantlogic.designer;


public class PlaceTemplateDesignEntityGenerator extends EntityDesign {

    public static final PlaceTemplateDesignEntityGenerator ENTITY = new PlaceTemplateDesignEntityGenerator();
    
    private PlaceTemplateDesignEntityGenerator() {
        setName("PlaceTemplateDesign");
        setExtendsFrom(FlowNodeBaseDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign content = addRelation(ENTITY, "content", RelationType.OneToZeroOrOneAggregation, FragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("contentOfPage");

}