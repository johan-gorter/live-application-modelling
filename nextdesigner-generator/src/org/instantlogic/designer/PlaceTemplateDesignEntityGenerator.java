package org.instantlogic.designer;


public class PlaceTemplateDesignEntityGenerator extends EntityDesign {

    public static final PlaceTemplateDesignEntityGenerator ENTITY = new PlaceTemplateDesignEntityGenerator();
    
    public PlaceTemplateDesignEntityGenerator() {
        setName("PlaceTemplateDesign");
        setExtendsFrom(FlowNodeBaseDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public final RelationDesign content = addRelation("content", RelationType.OneToZeroOrOneAggregation, FragmentTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("contentOfPage");

}