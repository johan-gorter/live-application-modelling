package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.flow.flow.*;
import lbe.model.Entity;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class FlowFlow extends Flow {

	public static final FlowFlow INSTANCE = new FlowFlow();
	
	private FlowFlow() {
	}
	
	private static final FlowSource FLOWDETAILS = new SimpleFlowSource("flowDetails");

	private static final FlowSink BACK = new SimpleFlowSink("back");
	private static final FlowSink EXPLOREINSTANCE = new SimpleFlowSink("exploreInstance");

	private static final FlowSource[] SOURCES = new FlowSource[]{
		FLOWDETAILS,
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
		BACK,
		EXPLOREINSTANCE,
	};
	
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		FlowPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(FLOWDETAILS, "start", FlowPage.INSTANCE, null),
		new FlowEdge(FlowPage.INSTANCE, "back", BACK, null),
		new FlowEdge(FlowPage.INSTANCE, "exploreInstance", EXPLOREINSTANCE, null),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		FlowEntity.INSTANCE,
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
