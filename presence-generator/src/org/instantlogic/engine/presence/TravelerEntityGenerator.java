package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.util.Deductions;

public class TravelerEntityGenerator extends EntityDesign {

    public static final TravelerEntityGenerator ENTITY = new TravelerEntityGenerator();
    
    private TravelerEntityGenerator() {
        setName("Traveler");
        setIsCustomized(true);
    }
    
    // Attributes
    public static final AttributeDesign id = addAttribute(ENTITY, "id", java.lang.String.class);
    public static final AttributeDesign communicatorVisible = addAttribute(ENTITY, "communicatorVisible", java.lang.Boolean.class);

    // Relations
    public static final RelationDesign currentPlace = addRelation(ENTITY, "currentPlace", RelationType.ManyToZeroOrOne, PlaceEntityGenerator.ENTITY)
    	.setReverseName("visitingTravelers");
    
    @Override
    public void init() {
    	communicatorVisible.setDefault(Deductions.toScheme(Deductions.constant(Boolean.class, false)));
    }
}
