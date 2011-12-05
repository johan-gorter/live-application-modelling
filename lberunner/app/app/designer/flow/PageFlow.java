package app.designer.flow;

import app.designer.entity.*;
import app.designer.flow.*;
import app.designer.event.*;
import app.designer.flow.page.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class PageFlow extends Flow {

	public static final PageFlow INSTANCE = new PageFlow();
	
	protected PageFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			PageDetailsEvent.INSTANCE,
			PagePage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		PagePage.INSTANCE,
		FieldSubFlow.INSTANCE,
		AddFieldSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			PagePage.INSTANCE, 
			AddFieldEvent.INSTANCE,
			AddFieldSubFlow.INSTANCE,
			AddFieldEvent.INSTANCE
		),
		new FlowEdge(
			AddFieldSubFlow.INSTANCE, 
			FieldDetailsEvent.INSTANCE,
			FieldSubFlow.INSTANCE,
			FieldDetailsEvent.INSTANCE
		),
		new FlowEdge(
			FieldSubFlow.INSTANCE, 
			PageDetailsEvent.INSTANCE,
			PagePage.INSTANCE,
			null
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		PageDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Page";
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
