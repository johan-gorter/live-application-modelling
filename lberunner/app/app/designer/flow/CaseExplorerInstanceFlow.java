package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.flow.caseexplorerinstance.*;
import lbe.model.Entity;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class CaseExplorerInstanceFlow extends Flow {

	public static final CaseExplorerInstanceFlow INSTANCE = new custom.designer.caseexplorer.CaseExplorerInstanceFlowCustomization();
	
	protected CaseExplorerInstanceFlow() {
	}
	
	private static final FlowSource EXPLOREINSTANCE = new SimpleFlowSource("exploreInstance");

	private static final FlowSink BACK = new SimpleFlowSink("back");
	private static final FlowSink NAVIGATE = new SimpleFlowSink("navigate");

	private static final FlowSource[] SOURCES = new FlowSource[]{
		EXPLOREINSTANCE,
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
		BACK,
		NAVIGATE,
	};
	
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		InstancePage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(EXPLOREINSTANCE, "start", InstancePage.INSTANCE, null),
		new FlowEdge(InstancePage.INSTANCE, "back", BACK, null),
		new FlowEdge(InstancePage.INSTANCE, "navigate", NAVIGATE, null),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "CaseExplorerInstance";
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
