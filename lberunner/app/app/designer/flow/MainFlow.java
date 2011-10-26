package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.flow.main.*;
import lbe.model.Entity;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class MainFlow extends Flow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	private MainFlow() {
	}
	
	private static final FlowSource START = new SimpleFlowSource("start");


	private static final FlowSource[] SOURCES = new FlowSource[]{
		START,
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
	};
	
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		WelcomePage.INSTANCE,
		FlowSubFlow.INSTANCE,
		CaseExplorerSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(START, "start", WelcomePage.INSTANCE, null),
		new FlowEdge(WelcomePage.INSTANCE, "flowDetails", FlowSubFlow.INSTANCE, "flowDetails"),
		new FlowEdge(FlowSubFlow.INSTANCE, "back", WelcomePage.INSTANCE, null),
		new FlowEdge(FlowSubFlow.INSTANCE, "exploreInstance", CaseExplorerSubFlow.INSTANCE, "exploreInstance"),
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
	public FlowSink[] getSinks() {
		return SINKS;
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
