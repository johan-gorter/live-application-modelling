package app.designer.flow;

import app.designer.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.entity.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class EntityFlow extends Flow {

	public static final EntityFlow INSTANCE = new EntityFlow();
	
	protected EntityFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			EntityDetailsEvent.INSTANCE,
			EntityPage.INSTANCE,
			null
		),
		new FlowSource(
			AttributeDetailsInEntityEvent.INSTANCE,
			AttributeSubFlow.INSTANCE,
			AttributeDetailsEvent.INSTANCE
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		EntityPage.INSTANCE,
		AttributeSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			EntityPage.INSTANCE, 
			AttributeDetailsEvent.INSTANCE,
			AttributeSubFlow.INSTANCE,
			AttributeDetailsEvent.INSTANCE
		),
		new FlowEdge(
			AttributeSubFlow.INSTANCE, 
			EntityDetailsEvent.INSTANCE,
			EntityPage.INSTANCE,
			null
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		EntityDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Entity";
	}

	@Override
	public FlowSource[] getSources() {
		return SOURCES;
	}

	@Override
	public FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public Entity[] getParameters() {
		return PARAMETERS;
	}
}
