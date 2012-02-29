package app.designer.flow;

import app.designer.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.attribute.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class AttributeFlow extends Flow {

	public static final AttributeFlow INSTANCE = new AttributeFlow();
	
	protected AttributeFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			AttributeDetailsEvent.INSTANCE,
			AttributePage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		AttributePage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		AttributeDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Attribute";
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
