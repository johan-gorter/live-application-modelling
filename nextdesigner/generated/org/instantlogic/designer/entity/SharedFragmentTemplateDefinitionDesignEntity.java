package org.instantlogic.designer.entity;

public class SharedFragmentTemplateDefinitionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> {

	public static final SharedFragmentTemplateDefinitionDesignEntity INSTANCE = new SharedFragmentTemplateDefinitionDesignEntity();
	
	protected SharedFragmentTemplateDefinitionDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign createInstance() {
		return new org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign.class;
	}
	
	@Override
	public String getName() {
		return "SharedFragmentTemplateDefinitionDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> fragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
			"fragment", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.sharedTemplateDefinition
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign instance) {
				return instance.getFragmentRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"application", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.sharedTemplates
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign instance) {
				return instance.getApplicationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedTemplateDesign>, org.instantlogic.designer.SharedTemplateDesign> usages
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedTemplateDesign>, org.instantlogic.designer.SharedTemplateDesign>(
			"usages", INSTANCE, org.instantlogic.designer.entity.SharedTemplateDesignEntity.INSTANCE, org.instantlogic.designer.SharedTemplateDesign.class, org.instantlogic.designer.entity.SharedTemplateDesignEntity.definition
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedTemplateDesign> get(
					org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign instance) {
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
