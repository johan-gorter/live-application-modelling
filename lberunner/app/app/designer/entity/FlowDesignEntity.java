package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowDesignEntity extends SimpleEntity {

	public static final FlowDesignEntity INSTANCE = new FlowDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<FlowDesign, List<FlowSourceDesign>, FlowSourceDesign> sources
		= new SimpleRelation<FlowDesign, List<FlowSourceDesign>, FlowSourceDesign>(
			"sources", INSTANCE, FlowSourceDesignEntity.INSTANCE, FlowSourceDesign.class, FlowSourceDesignEntity.owner
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowDesign, FlowSourceDesign> get(
					FlowDesign instance) {
				return instance.sources;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowDesign, List<FlowNodeBaseDesign>, FlowNodeBaseDesign> nodes
		= new SimpleRelation<FlowDesign, List<FlowNodeBaseDesign>, FlowNodeBaseDesign>(
			"nodes", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowNodeBaseDesign.class, FlowNodeBaseDesignEntity.owner
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowDesign, FlowNodeBaseDesign> get(
					FlowDesign instance) {
				return instance.nodes;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowDesign, List<FlowEdgeDesign>, FlowEdgeDesign> edges
		= new SimpleRelation<FlowDesign, List<FlowEdgeDesign>, FlowEdgeDesign>(
			"edges", INSTANCE, FlowEdgeDesignEntity.INSTANCE, FlowEdgeDesign.class, FlowEdgeDesignEntity.owner
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowDesign, FlowEdgeDesign> get(
					FlowDesign instance) {
				return instance.edges;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowDesign, List<EntityDesign>, EntityDesign> parameters
		= new SimpleRelation<FlowDesign, List<EntityDesign>, EntityDesign>(
			"parameters", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.parameterInFlows
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowDesign, EntityDesign> get(
					FlowDesign instance) {
				return instance.parameters;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<FlowDesign, ApplicationDesign, ApplicationDesign> application
		= new SimpleRelation<FlowDesign, ApplicationDesign, ApplicationDesign>(
			"application", INSTANCE, FlowDesignEntity.INSTANCE, ApplicationDesign.class, ApplicationDesignEntity.flows
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowDesign, ApplicationDesign> get(
					FlowDesign instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<FlowDesign, ApplicationDesign, ApplicationDesign> exposedFlowInApplication
		= new SimpleRelation<FlowDesign, ApplicationDesign, ApplicationDesign>(
			"exposedFlowInApplication", INSTANCE, FlowDesignEntity.INSTANCE, ApplicationDesign.class, ApplicationDesignEntity.exposedFlows
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowDesign, ApplicationDesign> get(
					FlowDesign instance) {
				return instance.exposedFlowInApplication;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<FlowDesign, SubFlowDesign, SubFlowDesign> subFlowIn
		= new SimpleRelation<FlowDesign, SubFlowDesign, SubFlowDesign>(
			"subFlowIn", INSTANCE, FlowDesignEntity.INSTANCE, SubFlowDesign.class, SubFlowDesignEntity.flow
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowDesign, SubFlowDesign> get(
					FlowDesign instance) {
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
		nodes,
		edges,
		parameters,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
		exposedFlowInApplication,
		subFlowIn,
	};

	private FlowDesignEntity() {
		super("FlowDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return DesignEntity.INSTANCE;
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
