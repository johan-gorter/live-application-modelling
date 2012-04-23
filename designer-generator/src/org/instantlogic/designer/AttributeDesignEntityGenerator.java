package org.instantlogic.designer;

public class AttributeDesignEntityGenerator extends EntityDesign {

	public static final AttributeDesignEntityGenerator ENTITY = new AttributeDesignEntityGenerator();
	
	public AttributeDesignEntityGenerator() {
		setName("AttributeDesign");
	}

	public final AttributeDesign readOnly = addAttribute("readOnly", Boolean.class);
	public final AttributeDesign multivalue = addAttribute("multivalue", Boolean.class);
	public final AttributeDesign className = addAttribute("className", String.class);

}
