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
	
	public static final Relation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance> from
		= new SimpleRelation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance>(
			"from", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowNodeBaseInstance.class, FlowNodeBaseEntity.outgoingEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, FlowNodeBaseInstance> get(
					FlowEdgeInstance instance) {
				return instance.from;
			}
		};
	
	public static final Relation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance> to
		= new SimpleRelation<FlowEdgeInstance, FlowNodeBaseInstance, FlowNodeBaseInstance>(
			"to", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowNodeBaseInstance.class, FlowNodeBaseEntity.incomingEdges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, FlowNodeBaseInstance> get(
					FlowEdgeInstance instance) {
				return instance.to;
			}
		};
	
	// Reverse relations
	
	public static final Relation<FlowEdgeInstance, FlowInstance, FlowInstance> flow
		= new SimpleRelation<FlowEdgeInstance, FlowInstance, FlowInstance>(
			"flow", INSTANCE, FlowEdgeEntity.INSTANCE, FlowInstance.class, FlowEntity.edges
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowEdgeInstance, FlowInstance> get(
					FlowEdgeInstance instance) {
				return instance.flow;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		from,
		to,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		flow,
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
