package app.carinsurance.flow;

import app.carinsurance.data.entity.*;
import app.carinsurance.flow.*;
import app.carinsurance.flow.insure.*;
import lbe.model.Entity;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class InsureFlow extends Flow {

	public static final InsureFlow INSTANCE = new InsureFlow();
	
	protected InsureFlow() {
	}
	
	private static final FlowSource START = new SimpleFlowSource("start");


	private static final FlowSource[] SOURCES = new FlowSource[]{
		START,
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
	};
	
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		DriverPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(START, "start", DriverPage.INSTANCE, null),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "Insure";
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
