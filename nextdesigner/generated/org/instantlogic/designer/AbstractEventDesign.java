package org.instantlogic.designer;


public abstract class AbstractEventDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.EventDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.getValue();
	}
	
	public EventDesign addToParameters(EntityDesign item) {
		parameters.addValue(item);
		return (EventDesign)this;
	}
	
	public EventDesign addToParameters(EntityDesign item, int index) {
		parameters.insertValue(item, index);
		return (EventDesign)this;
	}
	
	public EventDesign removeFromParameters(EntityDesign item) {
		parameters.removeValue(item);
		return (EventDesign)this;
	}
	
	public EventDesign removeFromParameters(int index) {
		parameters.removeValue(index);
		return (EventDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EventDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public EventDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (EventDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, FlowEdgeDesign> eventInEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.eventInEdges);

	public org.instantlogic.fabric.value.RelationValues<EventDesign, FlowEdgeDesign> getEventInEdgesRelationValue() {
		return eventInEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getEventInEdges() {
		return eventInEdges.getValue();
	}

    public EventDesign addToEventInEdges(FlowEdgeDesign item) {
        eventInEdges.addValue(item);
        return (EventDesign)this;
    }

    public EventDesign removeFromEventInEdges(FlowEdgeDesign item) {
        eventInEdges.removeValue(item);
        return (EventDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, FragmentTemplateDesign> triggeredByFragment
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.triggeredByFragment);

	public org.instantlogic.fabric.value.RelationValues<EventDesign, FragmentTemplateDesign> getTriggeredByFragmentRelationValue() {
		return triggeredByFragment;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign> getTriggeredByFragment() {
		return triggeredByFragment.getValue();
	}

    public EventDesign addToTriggeredByFragment(FragmentTemplateDesign item) {
        triggeredByFragment.addValue(item);
        return (EventDesign)this;
    }

    public EventDesign removeFromTriggeredByFragment(FragmentTemplateDesign item) {
        triggeredByFragment.removeValue(item);
        return (EventDesign)this;
    }


}
