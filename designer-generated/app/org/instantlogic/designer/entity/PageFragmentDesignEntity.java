package org.instantlogic.designer.entity;

public class PageFragmentDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PageFragmentDesign> {

	public static final PageFragmentDesignEntity INSTANCE = new PageFragmentDesignEntity();
	
	protected PageFragmentDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.PageFragmentDesign createInstance() {
		return new org.instantlogic.designer.PageFragmentDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PageFragmentDesign> getInstanceClass() {
		return org.instantlogic.designer.PageFragmentDesign.class;
	}
	
	@Override
	public String getName() {
		return "PageFragmentDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PageFragmentDesign, java.lang.String, java.lang.String> presentation 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PageFragmentDesign, java.lang.String, java.lang.String>(
			"presentation", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.PageFragmentDesign, java.lang.String> get(org.instantlogic.designer.PageFragmentDesign instance) {
				return instance.getPresentationAttributeValue();
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.PageFragmentHolderDesign> holder
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.PageFragmentHolderDesign>(
			"holder", INSTANCE, org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.INSTANCE, org.instantlogic.designer.PageFragmentHolderDesign.class, org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.pageFragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageFragmentHolderDesign> get(
					org.instantlogic.designer.PageFragmentDesign instance) {
				return instance.getHolderRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.PageCompositionDesign> composedIn
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.PageCompositionDesign>(
			"composedIn", INSTANCE, org.instantlogic.designer.entity.PageCompositionDesignEntity.INSTANCE, org.instantlogic.designer.PageCompositionDesign.class, org.instantlogic.designer.entity.PageCompositionDesignEntity.pageFragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageCompositionDesign> get(
					org.instantlogic.designer.PageFragmentDesign instance) {
				return instance.getComposedInRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		presentation,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		holder,
		composedIn,
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
