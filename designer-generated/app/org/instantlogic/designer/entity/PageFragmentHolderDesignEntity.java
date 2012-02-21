package org.instantlogic.designer.entity;

public class PageFragmentHolderDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PageFragmentHolderDesign> {

	public static final PageFragmentHolderDesignEntity INSTANCE = new PageFragmentHolderDesignEntity();
	
	protected PageFragmentHolderDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.PageFragmentHolderDesign createInstance() {
		return new org.instantlogic.designer.PageFragmentHolderDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PageFragmentHolderDesign> getInstanceClass() {
		return org.instantlogic.designer.PageFragmentHolderDesign.class;
	}
	
	@Override
	public String getName() {
		return "PageFragmentHolderDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageFragmentDesign> pageFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageFragmentDesign>(
			"pageFragment", INSTANCE, org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE, org.instantlogic.designer.PageFragmentDesign.class, org.instantlogic.designer.entity.PageFragmentDesignEntity.holder
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.PageFragmentDesign> get(
					org.instantlogic.designer.PageFragmentHolderDesign instance) {
				return instance.getPageFragmentRelation();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> shared
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"shared", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.sharedPageFragments
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.PageFragmentHolderDesign instance) {
				return instance.getSharedRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageFragmentHolderDesign, java.util.List<org.instantlogic.designer.SharedFragmentDesign>, org.instantlogic.designer.SharedFragmentDesign> usages
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageFragmentHolderDesign, java.util.List<org.instantlogic.designer.SharedFragmentDesign>, org.instantlogic.designer.SharedFragmentDesign>(
			"usages", INSTANCE, org.instantlogic.designer.entity.SharedFragmentDesignEntity.INSTANCE, org.instantlogic.designer.SharedFragmentDesign.class, org.instantlogic.designer.entity.SharedFragmentDesignEntity.pageFragmentHolder
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.SharedFragmentDesign> get(
					org.instantlogic.designer.PageFragmentHolderDesign instance) {
				return instance.getUsagesRelation();
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
		pageFragment,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		shared,
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
