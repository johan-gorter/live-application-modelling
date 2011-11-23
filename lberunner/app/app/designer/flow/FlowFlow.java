package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.flow.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class FlowFlow extends Flow {

	public static final FlowFlow INSTANCE = new FlowFlow();
	
	protected FlowFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			FlowDetailsEvent.INSTANCE,
			FlowPage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		FlowPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
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
