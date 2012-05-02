package org.instantlogic.designer.flow;

public class PageFlow extends org.instantlogic.interaction.flow.Flow {

	public static final PageFlow INSTANCE = new PageFlow();
	
	private static final org.instantlogic.interaction.flow.FlowSource[] SOURCES = new org.instantlogic.interaction.flow.FlowSource[]{
		new org.instantlogic.interaction.flow.FlowSource(
			org.instantlogic.designer.event.PageDetailsEvent.INSTANCE,
			null,
			null
		),
	};

	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.page.PagePage.INSTANCE,
		org.instantlogic.designer.flow.page.FieldSubFlow.INSTANCE,
		org.instantlogic.designer.flow.page.AddFieldSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.page.PagePage.INSTANCE, 
			org.instantlogic.designer.event.FieldDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.page.FieldSubFlow.INSTANCE,
			org.instantlogic.designer.event.FieldDetailsEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.page.PagePage.INSTANCE, 
			org.instantlogic.designer.event.AddFieldEvent.INSTANCE,
			org.instantlogic.designer.flow.page.AddFieldSubFlow.INSTANCE,
			org.instantlogic.designer.event.AddFieldEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.page.AddFieldSubFlow.INSTANCE, 
			org.instantlogic.designer.event.FieldDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.page.FieldSubFlow.INSTANCE,
			org.instantlogic.designer.event.FieldDetailsEvent.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.page.FieldSubFlow.INSTANCE, 
			org.instantlogic.designer.event.PageDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.page.PagePage.INSTANCE,
			null
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.PlaceDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Page";
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
