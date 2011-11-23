package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.main.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class MainFlow extends Flow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	protected MainFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			null,
			WelcomePage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		WelcomePage.INSTANCE,
		FlowSubFlow.INSTANCE,
		CaseExplorerSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			WelcomePage.INSTANCE, 
			FlowDetailsEvent.INSTANCE,
			FlowSubFlow.INSTANCE,
			FlowDetailsEvent.INSTANCE
		),
		new FlowEdge(
			FlowSubFlow.INSTANCE, 
			null,
			WelcomePage.INSTANCE,
			null
		),
		new FlowEdge(
			FlowSubFlow.INSTANCE, 
			ExploreInstanceEvent.INSTANCE,
			CaseExplorerSubFlow.INSTANCE,
			ExploreInstanceEvent.INSTANCE
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "Main";
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
