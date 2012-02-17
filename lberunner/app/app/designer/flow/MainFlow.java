package app.designer.flow;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.event.AttributeDetailsInEntityEvent;
import app.designer.event.EntityDetailsEvent;
import app.designer.event.ExploreInstanceEvent;
import app.designer.event.FlowDetailsEvent;
import app.designer.event.HomeEvent;
import app.designer.flow.main.CaseExplorerSubFlow;
import app.designer.flow.main.EntitySubFlow;
import app.designer.flow.main.FlowSubFlow;
import app.designer.flow.main.WelcomePage;

public class MainFlow extends Flow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	protected MainFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			null,
			WelcomePage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		WelcomePage.INSTANCE,
		EntitySubFlow.INSTANCE,
		FlowSubFlow.INSTANCE,
		CaseExplorerSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			WelcomePage.INSTANCE, 
			FlowDetailsEvent.INSTANCE,
			FlowSubFlow.INSTANCE,
			FlowDetailsEvent.INSTANCE
		),
		new FlowEdge(
			WelcomePage.INSTANCE, 
			EntityDetailsEvent.INSTANCE,
			EntitySubFlow.INSTANCE,
			EntityDetailsEvent.INSTANCE
		),
		new FlowEdge(
			WelcomePage.INSTANCE, 
			AttributeDetailsInEntityEvent.INSTANCE,
			EntitySubFlow.INSTANCE,
			AttributeDetailsInEntityEvent.INSTANCE
		),
		new FlowEdge(
			FlowSubFlow.INSTANCE, 
			FlowDetailsEvent.INSTANCE,
			FlowSubFlow.INSTANCE,
			FlowDetailsEvent.INSTANCE
		),
		new FlowEdge(
			FlowSubFlow.INSTANCE, 
			HomeEvent.INSTANCE,
			WelcomePage.INSTANCE,
			null
		),
		new FlowEdge(
			FlowSubFlow.INSTANCE, 
			ExploreInstanceEvent.INSTANCE,
			CaseExplorerSubFlow.INSTANCE,
			ExploreInstanceEvent.INSTANCE
		),
		new FlowEdge(
			EntitySubFlow.INSTANCE, 
			HomeEvent.INSTANCE,
			WelcomePage.INSTANCE,
			null
		),
		new FlowEdge(
			EntitySubFlow.INSTANCE, 
			ExploreInstanceEvent.INSTANCE,
			CaseExplorerSubFlow.INSTANCE,
			ExploreInstanceEvent.INSTANCE
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "Main";
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
