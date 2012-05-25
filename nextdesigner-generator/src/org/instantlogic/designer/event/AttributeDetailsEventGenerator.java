package org.instantlogic.designer.event;

import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.EventDesign;

public class AttributeDetailsEventGenerator extends EventDesign {

	public static AttributeDetailsEventGenerator EVENT = new AttributeDetailsEventGenerator();
	
	private AttributeDetailsEventGenerator() {
		setName("AttributeDetails");
		addToParameters(AttributeDesignEntityGenerator.ENTITY);
	}
}
