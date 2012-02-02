package app.designer.flow;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.entity.FlowDesignEntity;
import app.designer.event.FlowDetailsEvent;
import app.designer.event.FlowNodeDetailsEvent;
import app.designer.event.PageDetailsEvent;
import app.designer.flow.flow.FlowNodeSubFlow;
import app.designer.flow.flow.FlowPage;
import app.designer.flow.flow.PageSubFlow;

public class FlowFlow extends Flow {

	public static final FlowFlow INSTANCE = new FlowFlow();
	
	protected FlowFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			FlowDetailsEvent.INSTANCE,
			FlowPage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		FlowPage.INSTANCE,
		FlowNodeSubFlow.INSTANCE,
		PageSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			FlowPage.INSTANCE, 
			FlowNodeDetailsEvent.INSTANCE,
			FlowNodeSubFlow.INSTANCE,
			null
		),
		new FlowEdge(
			FlowNodeSubFlow.INSTANCE, 
			PageDetailsEvent.INSTANCE,
			PageSubFlow.INSTANCE,
			null
		),
		new FlowEdge(
			PageSubFlow.INSTANCE, 
			FlowDetailsEvent.INSTANCE,
			FlowPage.INSTANCE,
			null
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		FlowDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Flow";
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
