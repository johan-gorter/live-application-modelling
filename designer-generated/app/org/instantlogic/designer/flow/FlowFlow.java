package org.instantlogic.designer.flow;

public class FlowFlow extends org.instantlogic.interaction.flow.Flow {

	public static final FlowFlow INSTANCE = new FlowFlow();
	
	private static final org.instantlogic.interaction.flow.FlowSource[] SOURCES = new org.instantlogic.interaction.flow.FlowSource[]{
		new org.instantlogic.interaction.flow.FlowSource(
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE,
			null,
			null
		),
	};

	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.flow.FlowPage.INSTANCE,
		org.instantlogic.designer.flow.flow.FlowNodeSubFlow.INSTANCE,
		org.instantlogic.designer.flow.flow.PageSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.flow.FlowPage.INSTANCE, 
			org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.flow.FlowNodeSubFlow.INSTANCE,
			null
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.flow.FlowNodeSubFlow.INSTANCE, 
			org.instantlogic.designer.event.PageDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.flow.PageSubFlow.INSTANCE,
			null
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.flow.PageSubFlow.INSTANCE, 
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.flow.FlowPage.INSTANCE,
			null
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Flow";
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
