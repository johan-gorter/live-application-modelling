package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.field.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class FieldFlow extends Flow {

	public static final FieldFlow INSTANCE = new FieldFlow();
	
	protected FieldFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			FieldDetailsEvent.INSTANCE,
			FieldPage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		FieldPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		FieldEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Field";
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
