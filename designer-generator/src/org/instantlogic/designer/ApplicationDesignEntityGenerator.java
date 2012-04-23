package org.instantlogic.designer;


public class ApplicationDesignEntityGenerator extends EntityDesign {

	public static final ApplicationDesignEntityGenerator ENTITY = new ApplicationDesignEntityGenerator();
	
	public ApplicationDesignEntityGenerator() {
		setName("ApplicationDesign");
		setIsCustomized(true);
	}
	
	public final AttributeDesign name = addAttribute("name", String.class);
	public final AttributeDesign isCustomized = addAttribute("isCustomized", Boolean.class);
	public final AttributeDesign rootPackageName = addAttribute("rootPackageName", String.class);
	public final AttributeDesign sourcePath = addAttribute("sourcePath", String.class);

}
