package org.instantlogic.designer.entity;

public class FragmentTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTemplateDesign> {

	public static final FragmentTemplateDesignEntity INSTANCE = new FragmentTemplateDesignEntity();
	
	protected FragmentTemplateDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.FragmentTemplateDesign createInstance() {
		return new org.instantlogic.designer.FragmentTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FragmentTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.FragmentTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "FragmentTemplateDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> fragmentTypeName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String>(
			"fragmentTypeName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String> get(org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getFragmentTypeNameAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionSchemeDesign>, org.instantlogic.designer.DeductionSchemeDesign> selections
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionSchemeDesign>, org.instantlogic.designer.DeductionSchemeDesign>(
			"selections", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.compositeTemplate
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getSelectionsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.usedInField
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getAttributeRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"entity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.usedInField
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getEntityRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"event", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.triggeredByFragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getEventRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentValue>, org.instantlogic.designer.FragmentValue> values
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentValue>, org.instantlogic.designer.FragmentValue>(
			"values", INSTANCE, org.instantlogic.designer.entity.FragmentValueEntity.INSTANCE, org.instantlogic.designer.FragmentValue.class, org.instantlogic.designer.entity.FragmentValueEntity.fragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentValue> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getValuesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentText>, org.instantlogic.designer.FragmentText> texts
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentText>, org.instantlogic.designer.FragmentText>(
			"texts", INSTANCE, org.instantlogic.designer.entity.FragmentTextEntity.INSTANCE, org.instantlogic.designer.FragmentText.class, org.instantlogic.designer.entity.FragmentTextEntity.fragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentText> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getTextsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentChildList>, org.instantlogic.designer.FragmentChildList> childLists
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentChildList>, org.instantlogic.designer.FragmentChildList>(
			"childLists", INSTANCE, org.instantlogic.designer.entity.FragmentChildListEntity.INSTANCE, org.instantlogic.designer.FragmentChildList.class, org.instantlogic.designer.entity.FragmentChildListEntity.fragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentChildList> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getChildListsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> sharedTemplateDefinition
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign>(
			"sharedTemplateDefinition", INSTANCE, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign.class, org.instantlogic.designer.entity.SharedFragmentTemplateDefinitionDesignEntity.fragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getSharedTemplateDefinitionRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> contentOfPage
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
			"contentOfPage", INSTANCE, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE, org.instantlogic.designer.PlaceTemplateDesign.class, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getContentOfPageRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentChildList, org.instantlogic.designer.FragmentChildList> childrenForFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentChildList, org.instantlogic.designer.FragmentChildList>(
			"childrenForFragment", INSTANCE, org.instantlogic.designer.entity.FragmentChildListEntity.INSTANCE, org.instantlogic.designer.FragmentChildList.class, org.instantlogic.designer.entity.FragmentChildListEntity.children
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentChildList> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getChildrenForFragmentRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		fragmentTypeName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		selections,
		attribute,
		entity,
		event,
		values,
		texts,
		childLists,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		sharedTemplateDefinition,
		contentOfPage,
		childrenForFragment,
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
