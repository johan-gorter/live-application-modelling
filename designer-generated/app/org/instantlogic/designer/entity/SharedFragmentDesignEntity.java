package org.instantlogic.designer.entity;

public class SharedFragmentDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedFragmentDesign> {

	public static final SharedFragmentDesignEntity INSTANCE = new SharedFragmentDesignEntity();
	
	protected SharedFragmentDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.SharedFragmentDesign createInstance() {
		return new org.instantlogic.designer.SharedFragmentDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedFragmentDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedFragmentDesign.class;
	}
	
	@Override
	public String getName() {
		return "SharedFragmentDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedFragmentDesign, org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.PageFragmentHolderDesign> pageFragmentHolder
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedFragmentDesign, org.instantlogic.designer.PageFragmentHolderDesign, org.instantlogic.designer.PageFragmentHolderDesign>(
			"pageFragmentHolder", INSTANCE, org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.INSTANCE, org.instantlogic.designer.PageFragmentHolderDesign.class, org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.usages
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedFragmentDesign, org.instantlogic.designer.PageFragmentHolderDesign> get(
					org.instantlogic.designer.SharedFragmentDesign instance) {
				return instance.getPageFragmentHolderRelation();
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		pageFragmentHolder,
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
