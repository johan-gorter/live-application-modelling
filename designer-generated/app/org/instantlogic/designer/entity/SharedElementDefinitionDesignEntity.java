package org.instantlogic.designer.entity;

public class SharedElementDefinitionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedElementDefinitionDesign> {

	public static final SharedElementDefinitionDesignEntity INSTANCE = new SharedElementDefinitionDesignEntity();
	
	
	protected SharedElementDefinitionDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.SharedElementDefinitionDesign createInstance() {
		return new org.instantlogic.designer.SharedElementDefinitionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedElementDefinitionDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedElementDefinitionDesign.class;
	}
	
	@Override
	public String getName() {
		return "SharedElementDefinitionDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> fragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
			"fragment", INSTANCE, org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE, org.instantlogic.designer.ElementDesign.class, 
			org.instantlogic.designer.entity.ElementDesignEntity.partOfSharedElementDefinition
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign> get(
					org.instantlogic.designer.SharedElementDefinitionDesign instance) {
				return instance.getFragmentRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"application", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.sharedElements
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.SharedElementDefinitionDesign instance) {
				return instance.getApplicationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign> usages
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign>(
			"usages", INSTANCE, org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE, org.instantlogic.designer.SharedElementDesign.class, org.instantlogic.designer.entity.SharedElementDesignEntity.definition
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDesign> get(
					org.instantlogic.designer.SharedElementDefinitionDesign instance) {
				return instance.getUsagesRelationValue();
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
		fragment,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		usages,
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
