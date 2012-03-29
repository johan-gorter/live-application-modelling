package org.instantlogic.designer.flow;

public class AttributeFlow extends org.instantlogic.interaction.flow.Flow {

	public static final AttributeFlow INSTANCE = new AttributeFlow();
	
	protected AttributeFlow() {
	}
	
	private static final org.instantlogic.interaction.flow.FlowSource[] SOURCES = new org.instantlogic.interaction.flow.FlowSource[]{
		new org.instantlogic.interaction.flow.FlowSource(
			org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE,
			null,
			null
		),
	};

	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.attribute.AttributePage.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Attribute";
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
