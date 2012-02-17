package app.designer.flow;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.entity.EntityDesignEntity;
import app.designer.event.AttributeDetailsEvent;
import app.designer.event.AttributeDetailsInEntityEvent;
import app.designer.event.EntityDetailsEvent;
import app.designer.flow.entity.AttributeSubFlow;
import app.designer.flow.entity.EntityPage;

public class EntityFlow extends Flow {

	public static final EntityFlow INSTANCE = new EntityFlow();
	
	protected EntityFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			EntityDetailsEvent.INSTANCE,
			EntityPage.INSTANCE,
			null
		),
		new FlowSource(
			AttributeDetailsInEntityEvent.INSTANCE,
			AttributeSubFlow.INSTANCE,
			AttributeDetailsEvent.INSTANCE
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		EntityPage.INSTANCE,
		AttributeSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			EntityPage.INSTANCE, 
			AttributeDetailsEvent.INSTANCE,
			AttributeSubFlow.INSTANCE,
			AttributeDetailsEvent.INSTANCE
		),
		new FlowEdge(
			AttributeSubFlow.INSTANCE, 
			EntityDetailsEvent.INSTANCE,
			EntityPage.INSTANCE,
			null
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		EntityDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Entity";
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
