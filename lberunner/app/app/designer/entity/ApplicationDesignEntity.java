package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ApplicationDesignEntity extends SimpleEntity {

	public static final ApplicationDesignEntity INSTANCE = new ApplicationDesignEntity();
	
	// Attributes
	
	public static final Attribute<ApplicationDesign, java.lang.String, java.lang.String> name 
		= new SimpleAttribute<ApplicationDesign, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ApplicationDesign, java.lang.String> get(ApplicationDesign instance) {
				return instance.name;
			}
		};
	
	public static final Attribute<ApplicationDesign, java.lang.String, java.lang.String> customization 
		= new SimpleAttribute<ApplicationDesign, java.lang.String, java.lang.String>(
			"customization", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ApplicationDesign, java.lang.String> get(ApplicationDesign instance) {
				return instance.customization;
			}
		};
	
	// Relations
	
	public static final Relation<ApplicationDesign, List<EntityDesign>, EntityDesign> entities
		= new SimpleRelation<ApplicationDesign, List<EntityDesign>, EntityDesign>(
			"entities", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.application
		) {
	
			@Override
			public ReadOnlyRelationValues<ApplicationDesign, EntityDesign> get(
					ApplicationDesign instance) {
				return instance.entities;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<ApplicationDesign, EntityDesign, EntityDesign> caseEntity
		= new SimpleRelation<ApplicationDesign, EntityDesign, EntityDesign>(
			"caseEntity", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.caseEntityInApplication
		) {
	
			@Override
			public ReadOnlyRelationValue<ApplicationDesign, EntityDesign> get(
					ApplicationDesign instance) {
				return instance.caseEntity;
			}
		};
	
	public static final Relation<ApplicationDesign, List<FlowDesign>, FlowDesign> flows
		= new SimpleRelation<ApplicationDesign, List<FlowDesign>, FlowDesign>(
			"flows", INSTANCE, FlowDesignEntity.INSTANCE, FlowDesign.class, FlowDesignEntity.application
		) {
	
			@Override
			public ReadOnlyRelationValues<ApplicationDesign, FlowDesign> get(
					ApplicationDesign instance) {
				return instance.flows;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<ApplicationDesign, List<EventDesign>, EventDesign> events
		= new SimpleRelation<ApplicationDesign, List<EventDesign>, EventDesign>(
			"events", INSTANCE, EventDesignEntity.INSTANCE, EventDesign.class, EventDesignEntity.application
		) {
	
			@Override
			public ReadOnlyRelationValues<ApplicationDesign, EventDesign> get(
					ApplicationDesign instance) {
				return instance.events;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<ApplicationDesign, List<FlowDesign>, FlowDesign> exposedFlows
		= new SimpleRelation<ApplicationDesign, List<FlowDesign>, FlowDesign>(
			"exposedFlows", INSTANCE, FlowDesignEntity.INSTANCE, FlowDesign.class, FlowDesignEntity.exposedFlowInApplication
		) {
	
			@Override
			public ReadOnlyRelationValues<ApplicationDesign, FlowDesign> get(
					ApplicationDesign instance) {
				return instance.exposedFlows;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<ApplicationDesign, List<PageFragmentHolderDesign>, PageFragmentHolderDesign> sharedPageFragments
		= new SimpleRelation<ApplicationDesign, List<PageFragmentHolderDesign>, PageFragmentHolderDesign>(
			"sharedPageFragments", INSTANCE, PageFragmentHolderDesignEntity.INSTANCE, PageFragmentHolderDesign.class, PageFragmentHolderDesignEntity.shared
		) {
	
			@Override
			public ReadOnlyRelationValues<ApplicationDesign, PageFragmentHolderDesign> get(
					ApplicationDesign instance) {
				return instance.sharedPageFragments;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		name,
		customization,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		entities,
		caseEntity,
		flows,
		events,
		exposedFlows,
		sharedPageFragments,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ApplicationDesignEntity() {
		super("ApplicationDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new custom.designer.ApplicationDesignCustomization();
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
