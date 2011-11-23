package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowEdgeEntity extends SimpleEntity {

	public static final FlowEdgeEntity INSTANCE = new FlowEdgeEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance> startNode
		= new SimpleRelation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance>(
			"startNode", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowNodeBaseInstance.class, FlowNodeBaseEntity.outgoingEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, FlowNodeBaseInstance> get(
					FlowEdgeInstance instance) {
				return instance.startNode;
			}
		};
	
	public static final Relation<FlowEdgeInstance, EventInstance, EventInstance> startEvent
		= new SimpleRelation<FlowEdgeInstance, EventInstance, EventInstance>(
			"startEvent", INSTANCE, EventEntity.INSTANCE, EventInstance.class, EventEntity.startEventInEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, EventInstance> get(
					FlowEdgeInstance instance) {
				return instance.startEvent;
			}
		};
	
	public static final Relation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance> endNode
		= new SimpleRelation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance>(
			"endNode", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowNodeBaseInstance.class, FlowNodeBaseEntity.incomingEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, FlowNodeBaseInstance> get(
					FlowEdgeInstance instance) {
				return instance.endNode;
			}
		};
	
	public static final Relation<FlowEdgeInstance, EventInstance, EventInstance> endEvent
		= new SimpleRelation<FlowEdgeInstance, EventInstance, EventInstance>(
			"endEvent", INSTANCE, EventEntity.INSTANCE, EventInstance.class, EventEntity.endEventInEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, EventInstance> get(
					FlowEdgeInstance instance) {
				return instance.endEvent;
			}
		};
	
	// Reverse relations
	
	public static final Relation<FlowEdgeInstance, FlowInstance, FlowInstance> owner
		= new SimpleRelation<FlowEdgeInstance, FlowInstance, FlowInstance>(
			"owner", INSTANCE, FlowEdgeEntity.INSTANCE, FlowInstance.class, FlowEntity.edges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, FlowInstance> get(
					FlowEdgeInstance instance) {
				return instance.owner;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		startNode,
		startEvent,
		endNode,
		endEvent,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		owner,
	};

	private FlowEdgeEntity() {
		super("FlowEdge");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowEdgeInstance(caseInstance, id);
	}
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
