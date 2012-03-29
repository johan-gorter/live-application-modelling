package org.instantlogic.designer.flow;

public class EntityFlow extends org.instantlogic.interaction.flow.Flow {

	public static final EntityFlow INSTANCE = new EntityFlow();
	
	protected EntityFlow() {
	}
	
	private static final org.instantlogic.interaction.flow.FlowSource[] SOURCES = new org.instantlogic.interaction.flow.FlowSource[]{
		new org.instantlogic.interaction.flow.FlowSource(
			org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE,
			null,
			null
		),
		new org.instantlogic.interaction.flow.FlowSource(
			org.instantlogic.designer.event.AttributeDetailsInEntityEvent.INSTANCE,
			org.instantlogic.designer.flow.entity.AttributeSubFlow.INSTANCE,
			org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE
		),
	};

	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.entity.EntityPage.INSTANCE,
		org.instantlogic.designer.flow.entity.AttributeSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.entity.EntityPage.INSTANCE, 
			org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.entity.AttributeSubFlow.INSTANCE,
			org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.entity.AttributeSubFlow.INSTANCE, 
			org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.entity.EntityPage.INSTANCE,
			null
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Entity";
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
