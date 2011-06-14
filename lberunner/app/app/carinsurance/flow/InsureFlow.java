package app.carinsurance.flow;

import app.carinsurance.flow.insure.DriverPage;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowEdge;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.Page;

public class InsureFlow extends Flow {
	
	public static final InsureFlow INSTANCE = new InsureFlow();

	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		DriverPage.INSTANCE
	};

	private InsureFlow() {
	}
	
	@Override
	public FlowNodeBase getStart() {
		return DriverPage.INSTANCE;
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
}
