package app.generatortest.flow;

import app.generatortest.data.entity.*;
import app.generatortest.flow.*;
import app.generatortest.event.*;
import app.generatortest.flow.insurex.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class InsureXFlow extends Flow {

	public static final InsureXFlow INSTANCE = new InsureXFlow();
	
	protected InsureXFlow() {
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
		return "InsureX";
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
