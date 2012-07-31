package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;

public class TravelerEntityGenerator extends EntityDesign {

    public static final TravelerEntityGenerator ENTITY = new TravelerEntityGenerator();
    
    private TravelerEntityGenerator() {
        setName("Traveler");
        setIsCustomized(true);
    }
    
    // Attributes
    public static final AttributeDesign id = addAttribute(ENTITY, "id", java.lang.String.class);

    // Relations
    public static final RelationDesign currentPlace = addRelation(ENTITY, "currentPlace", RelationType.ManyToZeroOrOne, PlaceEntityGenerator.ENTITY)
    		.setReverseName("visitingTravelers");
}
