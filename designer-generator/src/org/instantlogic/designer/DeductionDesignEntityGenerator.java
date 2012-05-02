package org.instantlogic.designer;

public class DeductionDesignEntityGenerator extends EntityDesign {

	public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
	
	public DeductionDesignEntityGenerator() {
		setName("DeductionDesign");
	}
	
	public final AttributeDesign multivalue = addAttribute("multivalue", Boolean.class);
	public final AttributeDesign className = addAttribute("className", Boolean.class);
	public final AttributeDesign customization = addAttribute("customization", Boolean.class);

}
