package org.instantlogic.designer.entity;

public class PageDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PageDesign> {

	public static final PageDesignEntity INSTANCE = new PageDesignEntity();
	
	protected PageDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.PageDesign createInstance() {
		return new org.instantlogic.designer.PageDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PageDesign> getInstanceClass() {
		return org.instantlogic.designer.PageDesign.class;
	}
	
	@Override
	public String getName() {
		return "PageDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageDesign, org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.CompositePageFragmentDesign> content
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageDesign, org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.CompositePageFragmentDesign>(
			"content", INSTANCE, org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.INSTANCE, org.instantlogic.designer.CompositePageFragmentDesign.class, org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.contentOfPage
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageDesign, org.instantlogic.designer.CompositePageFragmentDesign> get(
					org.instantlogic.designer.PageDesign instance) {
				return instance.getContentRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		content,
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
