package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class FlowNodeFlow extends org.instantlogic.interaction.flow.Flow {

	public static final FlowNodeFlow INSTANCE = new FlowNodeFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.flownode.FlowNodeChoiceSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.flownode.FlowNodeChoiceSubFlow.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "FlowNode";
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
