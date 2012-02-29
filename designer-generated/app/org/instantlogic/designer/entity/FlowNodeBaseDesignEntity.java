package org.instantlogic.designer.entity;

public class FlowNodeBaseDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FlowNodeBaseDesign> {

	public static final FlowNodeBaseDesignEntity INSTANCE = new FlowNodeBaseDesignEntity();
	
	protected FlowNodeBaseDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.FlowNodeBaseDesign createInstance() {
		return new org.instantlogic.designer.FlowNodeBaseDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FlowNodeBaseDesign> getInstanceClass() {
		return org.instantlogic.designer.FlowNodeBaseDesign.class;
	}
	
	@Override
	public String getName() {
		return "FlowNodeBaseDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> owner
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
			"owner", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.nodes
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.FlowNodeBaseDesign instance) {
				return instance.getOwnerRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign>, org.instantlogic.designer.FlowSourceDesign> incomingSources
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign>, org.instantlogic.designer.FlowSourceDesign>(
			"incomingSources", INSTANCE, org.instantlogic.designer.entity.FlowSourceDesignEntity.INSTANCE, org.instantlogic.designer.FlowSourceDesign.class, org.instantlogic.designer.entity.FlowSourceDesignEntity.endNode
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowSourceDesign> get(
					org.instantlogic.designer.FlowNodeBaseDesign instance) {
				return instance.getIncomingSourcesRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> outgoingEdges
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
			"outgoingEdges", INSTANCE, org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE, org.instantlogic.designer.FlowEdgeDesign.class, org.instantlogic.designer.entity.FlowEdgeDesignEntity.startNode
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowEdgeDesign> get(
					org.instantlogic.designer.FlowNodeBaseDesign instance) {
				return instance.getOutgoingEdgesRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> incomingEdges
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
			"incomingEdges", INSTANCE, org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE, org.instantlogic.designer.FlowEdgeDesign.class, org.instantlogic.designer.entity.FlowEdgeDesignEntity.endNode
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowEdgeDesign> get(
					org.instantlogic.designer.FlowNodeBaseDesign instance) {
				return instance.getIncomingEdgesRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		owner,
		incomingSources,
		outgoingEdges,
		incomingEdges,
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
}
