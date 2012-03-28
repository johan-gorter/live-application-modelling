package org.instantlogic.mini.generator;

import org.instantlogic.designer.ApplicationDesign;


public class MiniApplicationDesign extends ApplicationDesign {

	public static final MiniApplicationDesign APPLICATION = new MiniApplicationDesign();
	
	public MiniApplicationDesign() {
		setName("Mini");
		setRootPackageName("com.instantlogic.mini");
		setSourcePath("/prive/live-business-engineering/mini/generated");
		setCaseEntity(MiniThing.ENTITY);
		init();
	}
	
}
