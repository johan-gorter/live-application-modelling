package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.DataCategoryDesignEntity;

public class TravelerEntityGenerator extends EntityDesign {

    public static final TravelerEntityGenerator ENTITY = new TravelerEntityGenerator();
    
    private TravelerEntityGenerator() {
    	setApplication(PresenceApplicationGenerator.APPLICATION);
        setName("Traveler");
        setIsCustomized(true);
    }
    
    // Attributes
    public static final AttributeDesign id = addAttribute(ENTITY, "id", DataCategoryDesignEntity.INSTANCE.text);
    public static final AttributeDesign communicatorVisible = addAttribute(ENTITY, "communicatorVisible", DataCategoryDesignEntity.INSTANCE._boolean);

    // Relations
    public static final RelationDesign currentPlace = addRelation(ENTITY, "currentPlace", RelationType.ManyToZeroOrOne, PlaceEntityGenerator.ENTITY)
    	.setReverseName("visitingTravelers");
    
    public static final RelationDesign user = addRelation(ENTITY, "user", RelationType.ManyToZeroOrOne, UserEntityGenerator.ENTITY)
            .setReverseName("travelers");
    
    @Override
    public void init() {
    	communicatorVisible.setDefault(new DeductionSchemeDesign().deduceConstant(Boolean.class, false).getScheme());
    }
}
