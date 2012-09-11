package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;

public class UserEntityGenerator extends EntityDesign {

    public static final UserEntityGenerator ENTITY = new UserEntityGenerator();
    
    private UserEntityGenerator() {
    	setApplication(PresenceApplicationGenerator.APPLICATION);
        setName("User");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign username = addAttribute(ENTITY, "username", java.lang.String.class);
    
    // Relations
}
