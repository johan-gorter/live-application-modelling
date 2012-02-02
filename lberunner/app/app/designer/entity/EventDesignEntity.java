package app.designer.entity;

import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.ReadOnlyRelationValues;

import app.designer.ApplicationDesign;
import app.designer.EntityDesign;
import app.designer.EventDesign;
import app.designer.FlowEdgeDesign;
import app.designer.FlowSourceDesign;
import app.designer.LinkDesign;

public class EventDesignEntity extends SimpleEntity {

	public static final EventDesignEntity INSTANCE = new EventDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<EventDesign, List<EntityDesign>, EntityDesign> parameters
		= new SimpleRelation<EventDesign, List<EntityDesign>, EntityDesign>(
			"parameters", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.parameterInEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventDesign, EntityDesign> get(
					EventDesign instance) {
				return instance.parameters;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<EventDesign, ApplicationDesign, ApplicationDesign> application
		= new SimpleRelation<EventDesign, ApplicationDesign, ApplicationDesign>(
			"application", INSTANCE, EventDesignEntity.INSTANCE, ApplicationDesign.class, ApplicationDesignEntity.events
		) {
	
			@Override
			public ReadOnlyRelationValue<EventDesign, ApplicationDesign> get(
					EventDesign instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<EventDesign, List<LinkDesign>, LinkDesign> firesFromButtons
		= new SimpleRelation<EventDesign, List<LinkDesign>, LinkDesign>(
			"firesFromButtons", INSTANCE, EventDesignEntity.INSTANCE, LinkDesign.class, LinkDesignEntity.event
		) {
	
			@Override
			public ReadOnlyRelationValues<EventDesign, LinkDesign> get(
					EventDesign instance) {
				return instance.firesFromButtons;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventDesign, List<FlowSourceDesign>, FlowSourceDesign> startEventInSources
		= new SimpleRelation<EventDesign, List<FlowSourceDesign>, FlowSourceDesign>(
			"startEventInSources", INSTANCE, EventDesignEntity.INSTANCE, FlowSourceDesign.class, FlowSourceDesignEntity.startEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventDesign, FlowSourceDesign> get(
					EventDesign instance) {
				return instance.startEventInSources;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventDesign, List<FlowSourceDesign>, FlowSourceDesign> endEventInSources
		= new SimpleRelation<EventDesign, List<FlowSourceDesign>, FlowSourceDesign>(
			"endEventInSources", INSTANCE, EventDesignEntity.INSTANCE, FlowSourceDesign.class, FlowSourceDesignEntity.endEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventDesign, FlowSourceDesign> get(
					EventDesign instance) {
				return instance.endEventInSources;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventDesign, List<FlowEdgeDesign>, FlowEdgeDesign> startEventInEdges
		= new SimpleRelation<EventDesign, List<FlowEdgeDesign>, FlowEdgeDesign>(
			"startEventInEdges", INSTANCE, EventDesignEntity.INSTANCE, FlowEdgeDesign.class, FlowEdgeDesignEntity.startEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> get(
					EventDesign instance) {
				return instance.startEventInEdges;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EventDesign, List<FlowEdgeDesign>, FlowEdgeDesign> endEventInEdges
		= new SimpleRelation<EventDesign, List<FlowEdgeDesign>, FlowEdgeDesign>(
			"endEventInEdges", INSTANCE, EventDesignEntity.INSTANCE, FlowEdgeDesign.class, FlowEdgeDesignEntity.endEvent
		) {
	
			@Override
			public ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> get(
					EventDesign instance) {
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

	private EventDesignEntity() {
		super("EventDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new EventDesign(caseInstance, id);
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
