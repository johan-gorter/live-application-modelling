package org.instantlogic.designer.entity;

public class SharedTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedTemplateDesign> {

	public static final SharedTemplateDesignEntity INSTANCE = new SharedTemplateDesignEntity();
	
	protected SharedTemplateDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.SharedTemplateDesign createInstance() {
		return new org.instantlogic.designer.SharedTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "SharedTemplateDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedTemplateDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> definition
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedTemplateDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign>(
			"definition", INSTANCE, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign.class, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.usages
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedTemplateDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> get(
					org.instantlogic.designer.SharedTemplateDesign instance) {
				return instance.getDefinitionRelationValue();
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		definition,
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
