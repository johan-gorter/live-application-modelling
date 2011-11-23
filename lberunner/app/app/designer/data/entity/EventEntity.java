package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class EventEntity extends SimpleEntity {

	public static final EventEntity INSTANCE = new EventEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<EventInstance, List<EntityInstance>, EntityInstance> parameters
		= new SimpleRelation<EventInstance, List<EntityInstance>, EntityInstance>(
			"parameters", INSTANCE, EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.parameterInEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventInstance, EntityInstance> get(
					EventInstance instance) {
				return instance.parameters;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<EventInstance, ApplicationInstance, ApplicationInstance> application
		= new SimpleRelation<EventInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, EventEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.events
		) {
	
			@Override
			public ReadOnlyRelationValue<EventInstance, ApplicationInstance> get(
					EventInstance instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<EventInstance, List<ButtonInstance>, ButtonInstance> firesFromButtons
		= new SimpleRelation<EventInstance, List<ButtonInstance>, ButtonInstance>(
			"firesFromButtons", INSTANCE, EventEntity.INSTANCE, ButtonInstance.class, ButtonEntity.event
		) {
	
			@Override
			public ReadOnlyRelationValues<EventInstance, ButtonInstance> get(
					EventInstance instance) {
				return instance.firesFromButtons;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventInstance, List<FlowSourceInstance>, FlowSourceInstance> startEventInSources
		= new SimpleRelation<EventInstance, List<FlowSourceInstance>, FlowSourceInstance>(
			"startEventInSources", INSTANCE, EventEntity.INSTANCE, FlowSourceInstance.class, FlowSourceEntity.startEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventInstance, FlowSourceInstance> get(
					EventInstance instance) {
				return instance.startEventInSources;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventInstance, List<FlowSourceInstance>, FlowSourceInstance> endEventInSources
		= new SimpleRelation<EventInstance, List<FlowSourceInstance>, FlowSourceInstance>(
			"endEventInSources", INSTANCE, EventEntity.INSTANCE, FlowSourceInstance.class, FlowSourceEntity.endEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventInstance, FlowSourceInstance> get(
					EventInstance instance) {
				return instance.endEventInSources;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventInstance, List<FlowEdgeInstance>, FlowEdgeInstance> startEventInEdges
		= new SimpleRelation<EventInstance, List<FlowEdgeInstance>, FlowEdgeInstance>(
			"startEventInEdges", INSTANCE, EventEntity.INSTANCE, FlowEdgeInstance.class, FlowEdgeEntity.startEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventInstance, FlowEdgeInstance> get(
					EventInstance instance) {
				return instance.startEventInEdges;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventInstance, List<FlowEdgeInstance>, FlowEdgeInstance> endEventInEdges
		= new SimpleRelation<EventInstance, List<FlowEdgeInstance>, FlowEdgeInstance>(
			"endEventInEdges", INSTANCE, EventEntity.INSTANCE, FlowEdgeInstance.class, FlowEdgeEntity.endEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventInstance, FlowEdgeInstance> get(
					EventInstance instance) {
				return instance.endEventInEdges;
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
		parameters,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
		firesFromButtons,
		startEventInSources,
		endEventInSources,
		startEventInEdges,
		endEventInEdges,
	};

	private EventEntity() {
		super("Event");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new EventInstance(caseInstance, id);
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
