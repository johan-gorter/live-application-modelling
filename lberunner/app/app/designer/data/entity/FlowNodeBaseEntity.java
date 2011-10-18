package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowNodeBaseEntity extends SimpleEntity {

	public static final FlowNodeBaseEntity INSTANCE = new FlowNodeBaseEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<FlowNodeBaseInstance, FlowInstance, FlowInstance> owner
		= new SimpleRelation<FlowNodeBaseInstance, FlowInstance, FlowInstance>(
			"owner", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowInstance.class, FlowEntity.nodes
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowNodeBaseInstance, FlowInstance> get(
					FlowNodeBaseInstance instance) {
				return instance.owner;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<FlowNodeBaseInstance, List<FlowEdgeInstance>, FlowEdgeInstance> outgoingEdges
		= new SimpleRelation<FlowNodeBaseInstance, List<FlowEdgeInstance>, FlowEdgeInstance>(
			"outgoingEdges", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowEdgeInstance.class, FlowEdgeEntity.from
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowNodeBaseInstance, FlowEdgeInstance> get(
					FlowNodeBaseInstance instance) {
				return instance.outgoingEdges;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowNodeBaseInstance, List<FlowEdgeInstance>, FlowEdgeInstance> incomingEdges
		= new SimpleRelation<FlowNodeBaseInstance, List<FlowEdgeInstance>, FlowEdgeInstance>(
			"incomingEdges", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowEdgeInstance.class, FlowEdgeEntity.to
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowNodeBaseInstance, FlowEdgeInstance> get(
					FlowNodeBaseInstance instance) {
				return instance.incomingEdges;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		owner,
		outgoingEdges,
		incomingEdges,
	};

	private FlowNodeBaseEntity() {
		super("FlowNodeBase");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowNodeBaseInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return ConceptEntity.INSTANCE;
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
