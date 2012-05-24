package org.instantlogic.designer.entity;

public class ApplicationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> {

	public static final ApplicationDesignEntity INSTANCE = new ApplicationDesignEntity();
	
	protected ApplicationDesignEntity() {
	}


	@Override
	public org.instantlogic.designer.ApplicationDesign createInstance() {
		return new org.instantlogic.designer.ApplicationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ApplicationDesign> getInstanceClass() {
		return org.instantlogic.designer.ApplicationDesign.class;
	}
	
	@Override
	public String getName() {
		return "ApplicationDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> isCustomized 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean>(
			"isCustomized", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getIsCustomizedAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> name 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getNameAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> rootPackageName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"rootPackageName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getRootPackageNameAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> sourcePath 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"sourcePath", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getSourcePathAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> caseEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"caseEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.caseEntityInApplication
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getCaseEntityRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> entities
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
			"entities", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getEntitiesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> events
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
			"events", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getEventsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> exposedFlows
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
			"exposedFlows", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.exposedFlowInApplication
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getExposedFlowsRelationValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> flows
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
			"flows", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getFlowsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign>, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> sharedTemplates
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign>, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign>(
			"sharedTemplates", INSTANCE, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign.class, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getSharedTemplatesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		isCustomized,
		name,
		rootPackageName,
		sourcePath,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		caseEntity,
		entities,
		events,
		exposedFlows,
		flows,
		sharedTemplates,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
