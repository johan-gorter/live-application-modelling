package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.flow.caseexplorer.*;
import lbe.model.Entity;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class CaseExplorerFlow extends Flow {

	public static final CaseExplorerFlow INSTANCE = new CaseExplorerFlow();
	
	protected CaseExplorerFlow() {
	}
	
	private static final FlowSource EXPLOREINSTANCE = new SimpleFlowSource("exploreInstance");

	private static final FlowSink BACK = new SimpleFlowSink("back");

	private static final FlowSource[] SOURCES = new FlowSource[]{
		EXPLOREINSTANCE,
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
		BACK,
	};
	
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		CaseExplorerInstanceSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(EXPLOREINSTANCE, "start", CaseExplorerInstanceSubFlow.INSTANCE, "exploreInstance"),
		new FlowEdge(CaseExplorerInstanceSubFlow.INSTANCE, "back", BACK, null),
		new FlowEdge(CaseExplorerInstanceSubFlow.INSTANCE, "navigate", CaseExplorerInstanceSubFlow.INSTANCE, "exploreInstance"),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "CaseExplorer";
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
