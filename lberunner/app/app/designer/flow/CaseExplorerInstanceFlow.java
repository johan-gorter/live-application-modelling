package app.designer.flow;

import app.designer.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.caseexplorerinstance.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class CaseExplorerInstanceFlow extends Flow {

	public static final CaseExplorerInstanceFlow INSTANCE = new custom.designer.caseexplorer.CaseExplorerInstanceFlowCustomization();
	
	protected CaseExplorerInstanceFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			ExploreInstanceEvent.INSTANCE,
			InstancePage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		InstancePage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "CaseExplorerInstance";
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
