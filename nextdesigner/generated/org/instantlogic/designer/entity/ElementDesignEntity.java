package org.instantlogic.designer.entity;

public class ElementDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ElementDesign> {

	public static final ElementDesignEntity INSTANCE = new ElementDesignEntity();
	
	protected ElementDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.ElementDesign createInstance() {
		return new org.instantlogic.designer.ElementDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ElementDesign> getInstanceClass() {
		return org.instantlogic.designer.ElementDesign.class;
	}
	
	@Override
	public String getName() {
		return "ElementDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> childrenForFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
			"childrenForFragment", INSTANCE, org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE, org.instantlogic.designer.PropertyDesign.class, org.instantlogic.designer.entity.PropertyDesignEntity.children
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign> get(
					org.instantlogic.designer.ElementDesign instance) {
				return instance.getChildrenForFragmentRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> contentOfPage
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
			"contentOfPage", INSTANCE, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE, org.instantlogic.designer.PlaceTemplateDesign.class, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign> get(
					org.instantlogic.designer.ElementDesign instance) {
				return instance.getContentOfPageRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> sharedTemplateDefinition
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign>(
			"sharedTemplateDefinition", INSTANCE, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign.class, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.fragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> get(
					org.instantlogic.designer.ElementDesign instance) {
				return instance.getSharedTemplateDefinitionRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		childrenForFragment,
		contentOfPage,
		sharedTemplateDefinition,
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
