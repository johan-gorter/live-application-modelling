package app.designer.flow;

import app.designer.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.addfield.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class AddFieldFlow extends Flow {

	public static final AddFieldFlow INSTANCE = new custom.designer.AddFieldFlowCustomization();
	
	protected AddFieldFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "AddField";
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
