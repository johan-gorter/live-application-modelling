package app.carinsurancetest.flow;

import app.carinsurancetest.data.entity.*;
import app.carinsurancetest.flow.*;
import app.carinsurancetest.flow.insure.*;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class InsureFlow extends Flow {

	public static final InsureFlow INSTANCE = new InsureFlow();
	
	private InsureFlow() {
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
		new FlowEdge(START, null, DriverPage.INSTANCE, null),
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
}
