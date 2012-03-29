package org.instantlogic.designer.flow;

public class CaseExplorerFlow extends org.instantlogic.interaction.flow.Flow {

	public static final CaseExplorerFlow INSTANCE = new CaseExplorerFlow();
	
	protected CaseExplorerFlow() {
	}
	
	private static final org.instantlogic.interaction.flow.FlowSource[] SOURCES = new org.instantlogic.interaction.flow.FlowSource[]{
		new org.instantlogic.interaction.flow.FlowSource(
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE,
			org.instantlogic.designer.flow.caseexplorer.CaseExplorerInstanceSubFlow.INSTANCE,
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE
		),
	};

	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.caseexplorer.CaseExplorerInstanceSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.caseexplorer.CaseExplorerInstanceSubFlow.INSTANCE, 
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE,
			org.instantlogic.designer.flow.caseexplorer.CaseExplorerInstanceSubFlow.INSTANCE,
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	};
	
	@Override
	public String getName() {
		return "CaseExplorer";
	}

	@Override
	public org.instantlogic.interaction.flow.FlowSource[] getSources() {
		return SOURCES;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
}
