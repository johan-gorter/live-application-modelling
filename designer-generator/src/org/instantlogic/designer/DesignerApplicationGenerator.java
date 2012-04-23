package org.instantlogic.designer;


public class DesignerApplicationGenerator extends ApplicationDesign {

	public static final DesignerApplicationGenerator APPLICATION = new DesignerApplicationGenerator();
	
	public DesignerApplicationGenerator() {
		setName("Designer");
		setRootPackageName("com.jg.ritadministratie.instantlogic");
		setSourcePath("/prive/ritadministratie/src");
		setCaseEntity(ApplicationDesignEntityGenerator.ENTITY);
		init();
	}
	
}
