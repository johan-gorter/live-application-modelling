package app.designer.flow;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.entity.PageDesignEntity;
import app.designer.event.AddFieldEvent;
import app.designer.event.FieldDetailsEvent;
import app.designer.event.PageDetailsEvent;
import app.designer.flow.page.AddFieldSubFlow;
import app.designer.flow.page.FieldSubFlow;
import app.designer.flow.page.PagePage;

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
			FieldDetailsEvent.INSTANCE,
			FieldSubFlow.INSTANCE,
			FieldDetailsEvent.INSTANCE
		),
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
