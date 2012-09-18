package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.DataCategoryDesignEntity;

public class PlaceEntityGenerator extends EntityDesign {

    public static final PlaceEntityGenerator ENTITY = new PlaceEntityGenerator();
    
    private PlaceEntityGenerator() {
    	setApplication(PresenceApplicationGenerator.APPLICATION);
        setName("Place");
        setIsCustomized(true);
    }
    
    // Attributes
    public static final AttributeDesign url = addAttribute(ENTITY, "url", DataCategoryDesignEntity.INSTANCE.text);
    public static final AttributeDesign description = addAttribute(ENTITY, "description", DataCategoryDesignEntity.INSTANCE.text);
    
}
