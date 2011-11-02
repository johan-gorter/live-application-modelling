package app.oldcarinsurance.flow;

import app.oldcarinsurance.flow.insure.DriverPage;
import lbe.model.Entity;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowEdge;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.FlowSink;
import lbe.model.flow.FlowSource;
import lbe.model.flow.Page;
import lbe.model.flow.impl.SimpleFlowSource;

public class InsureFlow extends Flow {
	
	public static final InsureFlow INSTANCE = new InsureFlow();
	
	private static final FlowSource START = new SimpleFlowSource("start");

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		DriverPage.INSTANCE
	};

	private static final FlowSource[] SOURCES = new FlowSource[]{
		START
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
	};

	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(START, null, DriverPage.INSTANCE, null)
	};

	private static final Entity[] PARAMETERS = new Entity[0];
	
	private InsureFlow() {
	}
	
	@Override
	public String getName() {
		return "Insure";
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
	public FlowSource[] getSources() {
		return SOURCES;
	}

	@Override
	public FlowSink[] getSinks() {
		return SINKS;
	}

	@Override
	public Entity[] getParameters() {
		return PARAMETERS;
	}
}
