package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.flow.entity.EntityDetailsPlaceGenerator;

public class EntityFlowGenerator extends FlowDesign {
	
	public static final EntityFlowGenerator FLOW = new EntityFlowGenerator();

	private EntityFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Entity");
	}
	
	@Override
	public void init() {
		addToParameters(EntityDesignEntityGenerator.ENTITY);

		addToNodes(EntityDetailsPlaceGenerator.PLACE);
		addToEdges(new FlowEdgeDesign().setEndNode(EntityDetailsPlaceGenerator.PLACE));

		super.init();
	}
}
