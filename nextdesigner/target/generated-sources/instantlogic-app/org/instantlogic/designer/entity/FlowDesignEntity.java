package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FlowDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FlowDesign> {

	public static final FlowDesignEntity INSTANCE = new FlowDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.FlowDesign createInstance() {
		return new org.instantlogic.designer.FlowDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FlowDesign> getInstanceClass() {
		return org.instantlogic.designer.FlowDesign.class;
	}
	
	@Override
	public String getName() {
		return "FlowDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> edges
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
			"edges", INSTANCE, org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE, org.instantlogic.designer.FlowEdgeDesign.class, 
			org.instantlogic.designer.entity.FlowEdgeDesignEntity.owner
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowEdgeDesign> get(
					org.instantlogic.designer.FlowDesign instance) {
				return instance.getEdgesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>, org.instantlogic.designer.FlowNodeBaseDesign> nodes
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>, org.instantlogic.designer.FlowNodeBaseDesign>(
			"nodes", INSTANCE, org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE, org.instantlogic.designer.FlowNodeBaseDesign.class, 
			org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.owner
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowNodeBaseDesign> get(
					org.instantlogic.designer.FlowDesign instance) {
				return instance.getNodesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> parameters
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
			"parameters", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.FlowDesign instance) {
				return instance.getParametersRelationValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"application", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.flows
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.FlowDesign instance) {
				return instance.getApplicationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.SubFlowDesign> subFlowIn
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.SubFlowDesign>(
			"subFlowIn", INSTANCE, org.instantlogic.designer.entity.SubFlowDesignEntity.INSTANCE, org.instantlogic.designer.SubFlowDesign.class, org.instantlogic.designer.entity.SubFlowDesignEntity.flow
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.SubFlowDesign> get(
					org.instantlogic.designer.FlowDesign instance) {
				return instance.getSubFlowInRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		edges,
		nodes,
		parameters,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		subFlowIn,
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
	};
	

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
	@Override
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, org.instantlogic.designer.FlowDesign> getStaticInstances() {
		return org.instantlogic.designer.FlowDesign.getStaticFlowDesignInstances();
	}
}
