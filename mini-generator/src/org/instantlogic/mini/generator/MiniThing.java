package org.instantlogic.mini.generator;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;


public class MiniThing extends EntityDesign {
	
	public static final MiniThing ENTITY = new MiniThing();
	
	public MiniThing() {
		setName("MiniThing");
	}
	
	public final AttributeDesign miniProperty = addAttribute("miniProperty", Float.class);
	public final AttributeDesign miniProperty2 = addAttribute("miniProperty2", Float.class);
	
	public final RelationDesign children = addRelation("children", RelationType.OneToManyAggregation, this).setReverseName("parent");
	
}