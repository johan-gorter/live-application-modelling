package org.instantlogic.designer;

public class RelationDesignEntityDesign extends EntityDesign {

	public static final RelationDesignEntityDesign ENTITY = new RelationDesignEntityDesign();
	
	public RelationDesignEntityDesign() {
		setName("RelationDesign");
	}
	
	public final AttributeDesign owner = addAttribute("owner", Boolean.class);
	public final AttributeDesign autoCreate = addAttribute("autoCreate", Boolean.class);
	public final AttributeDesign reverseMultivalue = addAttribute("reverseMultivalue", Boolean.class);
	public final AttributeDesign reverseName = addAttribute("reverseName", String.class);
	
}
