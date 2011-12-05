package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class EntityDesignEntity extends SimpleEntity {

	public static final EntityDesignEntity INSTANCE = new EntityDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<EntityDesign, EntityDesign, EntityDesign> extendsFrom
		= new SimpleRelation<EntityDesign, EntityDesign, EntityDesign>(
			"extendsFrom", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.extensions
		) {
	
			@Override
			public ReadOnlyRelationValue<EntityDesign, EntityDesign> get(
					EntityDesign instance) {
				return instance.extendsFrom;
			}
		};
	
	public static final Relation<EntityDesign, List<AttributeDesign>, AttributeDesign> attributes
		= new SimpleRelation<EntityDesign, List<AttributeDesign>, AttributeDesign>(
			"attributes", INSTANCE, AttributeDesignEntity.INSTANCE, AttributeDesign.class, AttributeDesignEntity.entity
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityDesign, AttributeDesign> get(
					EntityDesign instance) {
				return instance.attributes;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EntityDesign, List<RelationDesign>, RelationDesign> relations
		= new SimpleRelation<EntityDesign, List<RelationDesign>, RelationDesign>(
			"relations", INSTANCE, RelationDesignEntity.INSTANCE, RelationDesign.class, RelationDesignEntity.entity
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityDesign, RelationDesign> get(
					EntityDesign instance) {
				return instance.relations;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<EntityDesign, ApplicationDesign, ApplicationDesign> application
		= new SimpleRelation<EntityDesign, ApplicationDesign, ApplicationDesign>(
			"application", INSTANCE, EntityDesignEntity.INSTANCE, ApplicationDesign.class, ApplicationDesignEntity.entities
		) {
	
			@Override
			public ReadOnlyRelationValue<EntityDesign, ApplicationDesign> get(
					EntityDesign instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<EntityDesign, ApplicationDesign, ApplicationDesign> caseEntityInApplication
		= new SimpleRelation<EntityDesign, ApplicationDesign, ApplicationDesign>(
			"caseEntityInApplication", INSTANCE, EntityDesignEntity.INSTANCE, ApplicationDesign.class, ApplicationDesignEntity.caseEntity
		) {
	
			@Override
			public ReadOnlyRelationValue<EntityDesign, ApplicationDesign> get(
					EntityDesign instance) {
				return instance.caseEntityInApplication;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<EntityDesign, List<EntityDesign>, EntityDesign> extensions
		= new SimpleRelation<EntityDesign, List<EntityDesign>, EntityDesign>(
			"extensions", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.extendsFrom
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityDesign, EntityDesign> get(
					EntityDesign instance) {
				return instance.extensions;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EntityDesign, List<RelationDesign>, RelationDesign> reverseRelations
		= new SimpleRelation<EntityDesign, List<RelationDesign>, RelationDesign>(
			"reverseRelations", INSTANCE, EntityDesignEntity.INSTANCE, RelationDesign.class, RelationDesignEntity.to
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityDesign, RelationDesign> get(
					EntityDesign instance) {
				return instance.reverseRelations;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EntityDesign, List<EventDesign>, EventDesign> parameterInEvent
		= new SimpleRelation<EntityDesign, List<EventDesign>, EventDesign>(
			"parameterInEvent", INSTANCE, EntityDesignEntity.INSTANCE, EventDesign.class, EventDesignEntity.parameters
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityDesign, EventDesign> get(
					EntityDesign instance) {
				return instance.parameterInEvent;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EntityDesign, List<FlowDesign>, FlowDesign> parameterInFlows
		= new SimpleRelation<EntityDesign, List<FlowDesign>, FlowDesign>(
			"parameterInFlows", INSTANCE, EntityDesignEntity.INSTANCE, FlowDesign.class, FlowDesignEntity.parameters
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityDesign, FlowDesign> get(
					EntityDesign instance) {
				return instance.parameterInFlows;
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
		extendsFrom,
		attributes,
		relations,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
		caseEntityInApplication,
		extensions,
		reverseRelations,
		parameterInEvent,
		parameterInFlows,
	};

	private EntityDesignEntity() {
		super("EntityDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new EntityDesign(caseInstance, id);
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
