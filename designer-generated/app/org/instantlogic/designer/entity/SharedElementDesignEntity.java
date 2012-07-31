package org.instantlogic.designer.entity;

public class SharedElementDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedElementDesign> {

	public static final SharedElementDesignEntity INSTANCE = new SharedElementDesignEntity();
	
	protected SharedElementDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.SharedElementDesign createInstance() {
		return new org.instantlogic.designer.SharedElementDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedElementDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedElementDesign.class;
	}
	
	@Override
	public String getName() {
		return "SharedElementDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> definition
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign>(
			"definition", INSTANCE, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign.class, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.usages
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> get(
					org.instantlogic.designer.SharedElementDesign instance) {
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