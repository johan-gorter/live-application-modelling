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

public class FlowSourceDesignEntity extends SimpleEntity {

	public static final FlowSourceDesignEntity INSTANCE = new FlowSourceDesignEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final Relation<FlowSourceDesign, EventDesign, EventDesign> startEvent
		= new SimpleRelation<FlowSourceDesign, EventDesign, EventDesign>(
			"startEvent", INSTANCE, EventDesignEntity.INSTANCE, EventDesign.class, EventDesignEntity.startEventInSources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceDesign, EventDesign> get(
					FlowSourceDesign instance) {
				return instance.startEvent;
			}
			
		};
	
	public static final Relation<FlowSourceDesign, FlowNodeBaseDesign, FlowNodeBaseDesign> endNode
		= new SimpleRelation<FlowSourceDesign, FlowNodeBaseDesign, FlowNodeBaseDesign>(
			"endNode", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowNodeBaseDesign.class, FlowNodeBaseDesignEntity.incomingSources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceDesign, FlowNodeBaseDesign> get(
					FlowSourceDesign instance) {
				return instance.endNode;
			}
			
		};
	
	public static final Relation<FlowSourceDesign, EventDesign, EventDesign> endEvent
		= new SimpleRelation<FlowSourceDesign, EventDesign, EventDesign>(
			"endEvent", INSTANCE, EventDesignEntity.INSTANCE, EventDesign.class, EventDesignEntity.endEventInSources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceDesign, EventDesign> get(
					FlowSourceDesign instance) {
				return instance.endEvent;
			}
			
		};
	
	// Reverse relations
	
	public static final Relation<FlowSourceDesign, FlowDesign, FlowDesign> owner
		= new SimpleRelation<FlowSourceDesign, FlowDesign, FlowDesign>(
			"owner", INSTANCE, FlowSourceDesignEntity.INSTANCE, FlowDesign.class, FlowDesignEntity.sources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceDesign, FlowDesign> get(
					FlowSourceDesign instance) {
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

	private FlowSourceDesignEntity() {
		super("FlowSourceDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowSourceDesign(caseInstance, id);
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
