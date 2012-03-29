package org.instantlogic.designer.flow;

public class MainFlow extends org.instantlogic.interaction.flow.Flow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	protected MainFlow() {
	}
	
	private static final org.instantlogic.interaction.flow.FlowSource[] SOURCES = new org.instantlogic.interaction.flow.FlowSource[]{
		new org.instantlogic.interaction.flow.FlowSource(
			null,
			null,
			null
		),
	};

	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.main.WelcomePage.INSTANCE,
		org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.CaseExplorerSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.WelcomePage.INSTANCE, 
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE,
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.WelcomePage.INSTANCE, 
			org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE,
			org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.WelcomePage.INSTANCE, 
			org.instantlogic.designer.event.AttributeDetailsInEntityEvent.INSTANCE,
			org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE,
			org.instantlogic.designer.event.AttributeDetailsInEntityEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE, 
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE,
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE, 
			org.instantlogic.designer.event.HomeEvent.INSTANCE,
			org.instantlogic.designer.flow.main.WelcomePage.INSTANCE,
			null
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE, 
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE,
			org.instantlogic.designer.flow.main.CaseExplorerSubFlow.INSTANCE,
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE, 
			org.instantlogic.designer.event.HomeEvent.INSTANCE,
			org.instantlogic.designer.flow.main.WelcomePage.INSTANCE,
			null
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE, 
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE,
			org.instantlogic.designer.flow.main.CaseExplorerSubFlow.INSTANCE,
			org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	};
	
	@Override
	public String getName() {
		return "Main";
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
