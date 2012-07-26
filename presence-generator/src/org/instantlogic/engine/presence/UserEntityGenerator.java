package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;

public class UserEntityGenerator extends EntityDesign {

    public static final UserEntityGenerator ENTITY = new UserEntityGenerator();
    
    private UserEntityGenerator() {
        setName("User");
    }

    // Attributes
    public static final AttributeDesign userName = addAttribute(ENTITY, "userName", java.lang.String.class);
    
    // Relations
    public static final RelationDesign travelers = addRelation(ENTITY, "travelers", RelationType.OneToManyAggregation, TravelerEntityGenerator.ENTITY)
            .setReverseName("user");
}
