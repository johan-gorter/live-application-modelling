package app.designer.flow;

import app.designer.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.flow.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class FlowFlow extends Flow {

	public static final FlowFlow INSTANCE = new FlowFlow();
	
	protected FlowFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			FlowDetailsEvent.INSTANCE,
			FlowPage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		FlowPage.INSTANCE,
		FlowNodeSubFlow.INSTANCE,
		PageSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			FlowPage.INSTANCE, 
			FlowNodeDetailsEvent.INSTANCE,
			FlowNodeSubFlow.INSTANCE,
			null
		),
		new FlowEdge(
			FlowNodeSubFlow.INSTANCE, 
			PageDetailsEvent.INSTANCE,
			PageSubFlow.INSTANCE,
			null
		),
		new FlowEdge(
			PageSubFlow.INSTANCE, 
			FlowDetailsEvent.INSTANCE,
			FlowPage.INSTANCE,
			null
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		FlowDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Flow";
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
