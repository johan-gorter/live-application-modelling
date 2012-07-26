package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;

public class PresenceEntityGenerator extends EntityDesign {

    public static final PresenceEntityGenerator ENTITY = new PresenceEntityGenerator();
    
    private PresenceEntityGenerator() {
        setName("Presence");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign applicationName = addAttribute(ENTITY, "applicationName", java.lang.String.class);
    public static final AttributeDesign caseName = addAttribute(ENTITY, "caseName", java.lang.String.class);

    // Relations
    public static final RelationDesign activeUsers = addRelation(ENTITY, "users", RelationType.OneToManyAggregation, UserEntityGenerator.ENTITY)
            .setReverseName("presence");
    public static final RelationDesign activePlaces = addRelation(ENTITY, "activePlaces", RelationType.OneToManyAggregation, PlaceEntityGenerator.ENTITY)
            .setReverseName("presence");
    
}
