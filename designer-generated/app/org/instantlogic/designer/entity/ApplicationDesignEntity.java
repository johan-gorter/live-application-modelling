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
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> name 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getNameAttribute();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> _package 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"_package", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.get_packageAttribute();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> sourcePath 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"sourcePath", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getSourcePathAttribute();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> customization 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"customization", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getCustomizationAttribute();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> entities
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
			"entities", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getEntitiesRelation();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> caseEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"caseEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.caseEntityInApplication
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getCaseEntityRelation();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> flows
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
			"flows", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getFlowsRelation();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> events
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
			"events", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getEventsRelation();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> exposedFlows
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
			"exposedFlows", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.exposedFlowInApplication
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getExposedFlowsRelation();
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.PageFragmentHolderDesign>, org.instantlogic.designer.PageFragmentHolderDesign> sharedPageFragments
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, java.util.List<org.instantlogic.designer.PageFragmentHolderDesign>, org.instantlogic.designer.PageFragmentHolderDesign>(
			"sharedPageFragments", INSTANCE, org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.INSTANCE, org.instantlogic.designer.PageFragmentHolderDesign.class, org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.shared
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.PageFragmentHolderDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getSharedPageFragmentsRelation();
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
		name,
		_package,
		sourcePath,
		customization,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		entities,
		caseEntity,
		flows,
		events,
		exposedFlows,
		sharedPageFragments,
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
