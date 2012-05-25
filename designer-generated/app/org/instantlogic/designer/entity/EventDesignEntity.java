package org.instantlogic.designer.entity;

public class EventDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.EventDesign> {

	public static final EventDesignEntity INSTANCE = new EventDesignEntity();
	
	protected EventDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.EventDesign createInstance() {
		return new org.instantlogic.designer.EventDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.EventDesign> getInstanceClass() {
		return org.instantlogic.designer.EventDesign.class;
	}
	
	@Override
	public String getName() {
		return "EventDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> parameters
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
			"parameters", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.parameterInEvent
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EventDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.EventDesign instance) {
				return instance.getParametersRelationValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"application", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.events
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.EventDesign instance) {
				return instance.getApplicationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> endEventInEdges
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
			"endEventInEdges", INSTANCE, org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE, org.instantlogic.designer.FlowEdgeDesign.class, org.instantlogic.designer.entity.FlowEdgeDesignEntity.endEvent
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EventDesign, org.instantlogic.designer.FlowEdgeDesign> get(
					org.instantlogic.designer.EventDesign instance) {
				return instance.getEndEventInEdgesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign>, org.instantlogic.designer.FlowSourceDesign> endEventInSources
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign>, org.instantlogic.designer.FlowSourceDesign>(
			"endEventInSources", INSTANCE, org.instantlogic.designer.entity.FlowSourceDesignEntity.INSTANCE, org.instantlogic.designer.FlowSourceDesign.class, org.instantlogic.designer.entity.FlowSourceDesignEntity.endEvent
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EventDesign, org.instantlogic.designer.FlowSourceDesign> get(
					org.instantlogic.designer.EventDesign instance) {
				return instance.getEndEventInSourcesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> startEventInEdges
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
			"startEventInEdges", INSTANCE, org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE, org.instantlogic.designer.FlowEdgeDesign.class, org.instantlogic.designer.entity.FlowEdgeDesignEntity.startEvent
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EventDesign, org.instantlogic.designer.FlowEdgeDesign> get(
					org.instantlogic.designer.EventDesign instance) {
				return instance.getStartEventInEdgesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign>, org.instantlogic.designer.FlowSourceDesign> startEventInSources
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign>, org.instantlogic.designer.FlowSourceDesign>(
			"startEventInSources", INSTANCE, org.instantlogic.designer.entity.FlowSourceDesignEntity.INSTANCE, org.instantlogic.designer.FlowSourceDesign.class, org.instantlogic.designer.entity.FlowSourceDesignEntity.startEvent
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EventDesign, org.instantlogic.designer.FlowSourceDesign> get(
					org.instantlogic.designer.EventDesign instance) {
				return instance.getStartEventInSourcesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> triggeredByFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
			"triggeredByFragment", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.event
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EventDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.EventDesign instance) {
				return instance.getTriggeredByFragmentRelationValue();
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
		parameters,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		endEventInEdges,
		endEventInSources,
		startEventInEdges,
		startEventInSources,
		triggeredByFragment,
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
