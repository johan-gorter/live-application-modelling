package org.instantlogic.designer.entity;

public class FlowSourceDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FlowSourceDesign> {

	public static final FlowSourceDesignEntity INSTANCE = new FlowSourceDesignEntity();
	
	protected FlowSourceDesignEntity() {
	}


	@Override
	public org.instantlogic.designer.FlowSourceDesign createInstance() {
		return new org.instantlogic.designer.FlowSourceDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FlowSourceDesign> getInstanceClass() {
		return org.instantlogic.designer.FlowSourceDesign.class;
	}
	
	@Override
	public String getName() {
		return "FlowSourceDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> startEvent
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"startEvent", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.startEventInSources
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.FlowSourceDesign instance) {
				return instance.getStartEventRelation();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign> endNode
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign>(
			"endNode", INSTANCE, org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE, org.instantlogic.designer.FlowNodeBaseDesign.class, org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.incomingSources
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.FlowNodeBaseDesign> get(
					org.instantlogic.designer.FlowSourceDesign instance) {
				return instance.getEndNodeRelation();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> endEvent
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"endEvent", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.endEventInSources
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.FlowSourceDesign instance) {
				return instance.getEndEventRelation();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> owner
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
			"owner", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.sources
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowSourceDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.FlowSourceDesign instance) {
				return instance.getOwnerRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		startEvent,
		endNode,
		endEvent,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		owner,
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
