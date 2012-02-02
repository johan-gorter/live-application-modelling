package app.designer.flow;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.entity.FieldDesignEntity;
import app.designer.event.FieldDetailsEvent;
import app.designer.flow.field.FieldPage;

public class FieldFlow extends Flow {

	public static final FieldFlow INSTANCE = new FieldFlow();
	
	protected FieldFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			FieldDetailsEvent.INSTANCE,
			FieldPage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		FieldPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		FieldDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Field";
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
