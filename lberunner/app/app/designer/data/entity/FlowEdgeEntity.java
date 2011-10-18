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
	
	public static final Attribute<FlowEdgeInstance, java.lang.String, java.lang.String> entryName 
		= new SimpleAttribute<FlowEdgeInstance, java.lang.String, java.lang.String>(
			"entryName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<FlowEdgeInstance, java.lang.String> get(FlowEdgeInstance instance) {
				return instance.entryName;
			}
		};
	
	public static final Attribute<FlowEdgeInstance, java.lang.String, java.lang.String> exitName 
		= new SimpleAttribute<FlowEdgeInstance, java.lang.String, java.lang.String>(
			"exitName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<FlowEdgeInstance, java.lang.String> get(FlowEdgeInstance instance) {
				return instance.exitName;
			}
		};
	
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
		entryName,
		exitName,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		from,
		to,
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
