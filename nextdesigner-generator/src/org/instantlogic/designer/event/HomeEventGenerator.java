package org.instantlogic.designer.event;

import org.instantlogic.designer.EventDesign;

public class HomeEventGenerator extends EventDesign {

	public static HomeEventGenerator EVENT = new HomeEventGenerator();
	
	private HomeEventGenerator() {
		setName("Home");
	}
}
