package app.carinsurance.flow;

import app.carinsurance.entity.*;
import app.carinsurance.flow.*;
import app.carinsurance.event.*;
import app.carinsurance.flow.insure.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class InsureFlow extends Flow {

	public static final InsureFlow INSTANCE = new InsureFlow();
	
	protected InsureFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			null,
			DriverPage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		DriverPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
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
