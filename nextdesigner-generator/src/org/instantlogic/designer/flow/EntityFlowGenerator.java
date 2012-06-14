package org.instantlogic.designer.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.flow.entity.EntityDetailsPlaceGenerator;

public class EntityFlowGenerator extends FlowDesign {
	
	public static final EntityFlowGenerator FLOW = new EntityFlowGenerator();

	private EntityFlowGenerator() {
		setName("Entity");
	}
	
	@Override
	public void registerApplication(ApplicationDesign application) {
		addToParameters(EntityDesignEntityGenerator.ENTITY);

		FlowSourceDesign source = new FlowSourceDesign();
		source.setEndNode(EntityDetailsPlaceGenerator.PLACE);
		addToSources(source);
		
		addToNodes(EntityDetailsPlaceGenerator.PLACE);

		super.registerApplication(application);
	}
	
	@Override
	public void init() {

		super.init();
	}
}
