package org.instantlogic.mini.generator;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;


public class MiniThing extends EntityDesign {
	
	public static final MiniThing ENTITY = new MiniThing();
	
	public MiniThing() {
		setName("MiniThing");
	}
	
	public final AttributeDesign miniProperty = addAttribute("miniProperty", Float.class);
	public final AttributeDesign miniProperty2 = addAttribute("miniProperty2", Float.class);
	
}