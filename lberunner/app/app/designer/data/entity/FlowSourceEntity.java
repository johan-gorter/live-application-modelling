package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowSourceEntity extends SimpleEntity {

	public static final FlowSourceEntity INSTANCE = new FlowSourceEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<FlowSourceInstance, EventInstance, EventInstance> startEvent
		= new SimpleRelation<FlowSourceInstance, EventInstance, EventInstance>(
			"startEvent", INSTANCE, EventEntity.INSTANCE, EventInstance.class, EventEntity.startEventInSources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceInstance, EventInstance> get(
					FlowSourceInstance instance) {
				return instance.startEvent;
			}
		};
	
	public static final Relation<FlowSourceInstance, FlowNodeBaseInstance, FlowNodeBaseInstance> endNode
		= new SimpleRelation<FlowSourceInstance, FlowNodeBaseInstance, FlowNodeBaseInstance>(
			"endNode", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowNodeBaseInstance.class, FlowNodeBaseEntity.incomingSources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceInstance, FlowNodeBaseInstance> get(
					FlowSourceInstance instance) {
				return instance.endNode;
			}
		};
	
	public static final Relation<FlowSourceInstance, EventInstance, EventInstance> endEvent
		= new SimpleRelation<FlowSourceInstance, EventInstance, EventInstance>(
			"endEvent", INSTANCE, EventEntity.INSTANCE, EventInstance.class, EventEntity.endEventInSources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceInstance, EventInstance> get(
					FlowSourceInstance instance) {
				return instance.endEvent;
			}
		};
	
	// Reverse relations
	
	public static final Relation<FlowSourceInstance, FlowInstance, FlowInstance> owner
		= new SimpleRelation<FlowSourceInstance, FlowInstance, FlowInstance>(
			"owner", INSTANCE, FlowSourceEntity.INSTANCE, FlowInstance.class, FlowEntity.sources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceInstance, FlowInstance> get(
					FlowSourceInstance instance) {
				return instance.owner;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		startEvent,
		endNode,
		endEvent,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		owner,
	};

	private FlowSourceEntity() {
		super("FlowSource");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowSourceInstance(caseInstance, id);
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
