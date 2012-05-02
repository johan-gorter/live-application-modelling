package org.instantlogic.designer;


public class PlaceTemplateDesignEntityGenerator extends EntityDesign {

    public static final PlaceTemplateDesignEntityGenerator ENTITY = new PlaceTemplateDesignEntityGenerator();
    
    public PlaceTemplateDesignEntityGenerator() {
        setName("PlaceTemplateDesign");
        setExtendsFrom(FlowNodeBaseDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Attributes
    public final RelationDesign content = addRelation("content", RelationType.OneToOneAggregation, FragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("contentOfPage");

}