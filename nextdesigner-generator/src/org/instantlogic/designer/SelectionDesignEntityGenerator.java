package org.instantlogic.designer;

import org.instantlogic.designer.EntityDesign.RelationType;


public class SelectionDesignEntityGenerator extends EntityDesign {

    public static final SelectionDesignEntityGenerator ENTITY = new SelectionDesignEntityGenerator();
    
    private SelectionDesignEntityGenerator() {
        setName("SelectionDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
    }

    // Relations
    public static final RelationDesign selection = addRelation(ENTITY, "selection", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
            .setReverseName("selection");
    
    public static final RelationDesign children = addRelation(ENTITY, "children", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY)
            .setReverseName("childOfSelection");
    
}