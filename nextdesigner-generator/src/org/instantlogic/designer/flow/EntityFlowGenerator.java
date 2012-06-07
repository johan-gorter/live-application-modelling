package org.instantlogic.designer.flow;

import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.flow.entity.EntityPlaceGenerator;

public class EntityFlowGenerator extends FlowDesign {
	
	public static final EntityFlowGenerator FLOW = new EntityFlowGenerator();

	private EntityFlowGenerator() {
		setName("Entity");
		addToParameters(EntityDesignEntityGenerator.ENTITY);

		FlowSourceDesign source = new FlowSourceDesign();
		addToSources(source);
		
		addToNodes(EntityPlaceGenerator.PLACE);
	}
}
