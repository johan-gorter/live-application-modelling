package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.deduction.*;

public class FlowEdgeDesignEntity extends SimpleEntity {

	public static final FlowEdgeDesignEntity INSTANCE = new FlowEdgeDesignEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final Relation<FlowEdgeDesign, FlowNodeBaseDesign, FlowNodeBaseDesign> startNode
		= new SimpleRelation<FlowEdgeDesign, FlowNodeBaseDesign, FlowNodeBaseDesign>(
			"startNode", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowNodeBaseDesign.class, FlowNodeBaseDesignEntity.outgoingEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeDesign, FlowNodeBaseDesign> get(
					FlowEdgeDesign instance) {
				return instance.startNode;
			}
			
		};
	
	public static final Relation<FlowEdgeDesign, EventDesign, EventDesign> startEvent
		= new SimpleRelation<FlowEdgeDesign, EventDesign, EventDesign>(
			"startEvent", INSTANCE, EventDesignEntity.INSTANCE, EventDesign.class, EventDesignEntity.startEventInEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeDesign, EventDesign> get(
					FlowEdgeDesign instance) {
				return instance.startEvent;
			}
			
		};
	
	public static final Relation<FlowEdgeDesign, FlowNodeBaseDesign, FlowNodeBaseDesign> endNode
		= new SimpleRelation<FlowEdgeDesign, FlowNodeBaseDesign, FlowNodeBaseDesign>(
			"endNode", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowNodeBaseDesign.class, FlowNodeBaseDesignEntity.incomingEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeDesign, FlowNodeBaseDesign> get(
					FlowEdgeDesign instance) {
				return instance.endNode;
			}
			
		};
	
	public static final Relation<FlowEdgeDesign, EventDesign, EventDesign> endEvent
		= new SimpleRelation<FlowEdgeDesign, EventDesign, EventDesign>(
			"endEvent", INSTANCE, EventDesignEntity.INSTANCE, EventDesign.class, EventDesignEntity.endEventInEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeDesign, EventDesign> get(
					FlowEdgeDesign instance) {
				return instance.endEvent;
			}
			
		};
	
	// Reverse relations
	
	public static final Relation<FlowEdgeDesign, FlowDesign, FlowDesign> owner
		= new SimpleRelation<FlowEdgeDesign, FlowDesign, FlowDesign>(
			"owner", INSTANCE, FlowEdgeDesignEntity.INSTANCE, FlowDesign.class, FlowDesignEntity.edges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeDesign, FlowDesign> get(
					FlowEdgeDesign instance) {
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

	private FlowEdgeDesignEntity() {
		super("FlowEdgeDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowEdgeDesign(caseInstance, id);
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
