package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowEntity extends SimpleEntity {

	public static final FlowEntity INSTANCE = new FlowEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<FlowInstance, List<FlowSourceInstance>, FlowSourceInstance> sources
		= new SimpleRelation<FlowInstance, List<FlowSourceInstance>, FlowSourceInstance>(
			"sources", INSTANCE, FlowSourceEntity.INSTANCE, FlowSourceInstance.class, FlowSourceEntity.owner
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowInstance, FlowSourceInstance> get(
					FlowInstance instance) {
				return instance.sources;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowInstance, List<FlowSinkInstance>, FlowSinkInstance> sinks
		= new SimpleRelation<FlowInstance, List<FlowSinkInstance>, FlowSinkInstance>(
			"sinks", INSTANCE, FlowSinkEntity.INSTANCE, FlowSinkInstance.class, FlowSinkEntity.owner
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowInstance, FlowSinkInstance> get(
					FlowInstance instance) {
				return instance.sinks;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowInstance, List<FlowNodeBaseInstance>, FlowNodeBaseInstance> nodes
		= new SimpleRelation<FlowInstance, List<FlowNodeBaseInstance>, FlowNodeBaseInstance>(
			"nodes", INSTANCE, FlowNodeBaseEntity.INSTANCE, FlowNodeBaseInstance.class, FlowNodeBaseEntity.owner
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowInstance, FlowNodeBaseInstance> get(
					FlowInstance instance) {
				return instance.nodes;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowInstance, List<FlowEdgeInstance>, FlowEdgeInstance> edges
		= new SimpleRelation<FlowInstance, List<FlowEdgeInstance>, FlowEdgeInstance>(
			"edges", INSTANCE, FlowEdgeEntity.INSTANCE, FlowEdgeInstance.class, FlowEdgeEntity.owner
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowInstance, FlowEdgeInstance> get(
					FlowInstance instance) {
				return instance.edges;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowInstance, List<EntityInstance>, EntityInstance> parameters
		= new SimpleRelation<FlowInstance, List<EntityInstance>, EntityInstance>(
			"parameters", INSTANCE, EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.parameterInFlows
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowInstance, EntityInstance> get(
					FlowInstance instance) {
				return instance.parameters;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<FlowInstance, ApplicationInstance, ApplicationInstance> application
		= new SimpleRelation<FlowInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, FlowEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.flows
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowInstance, ApplicationInstance> get(
					FlowInstance instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<FlowInstance, ApplicationInstance, ApplicationInstance> exposedFlowInApplication
		= new SimpleRelation<FlowInstance, ApplicationInstance, ApplicationInstance>(
			"exposedFlowInApplication", INSTANCE, FlowEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.exposedFlows
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowInstance, ApplicationInstance> get(
					FlowInstance instance) {
				return instance.exposedFlowInApplication;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<FlowInstance, SubFlowInstance, SubFlowInstance> subFlowIn
		= new SimpleRelation<FlowInstance, SubFlowInstance, SubFlowInstance>(
			"subFlowIn", INSTANCE, FlowEntity.INSTANCE, SubFlowInstance.class, SubFlowEntity.flow
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowInstance, SubFlowInstance> get(
					FlowInstance instance) {
				return instance.subFlowIn;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		sources,
		sinks,
		nodes,
		edges,
		parameters,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
		exposedFlowInApplication,
		subFlowIn,
	};

	private FlowEntity() {
		super("Flow");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowInstance(caseInstance, id);
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
