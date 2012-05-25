package org.instantlogic.designer.event;

import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.EventDesign;

public class EntityDetailsEventGenerator extends EventDesign {

	public static EntityDetailsEventGenerator EVENT = new EntityDetailsEventGenerator();
	
	private EntityDetailsEventGenerator() {
		setName("EntityDetails");
		addToParameters(EntityDesignEntityGenerator.ENTITY);
	}
}
