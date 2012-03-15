package org.instantlogic.designer.entity;

public class LinkDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.LinkDesign> {

	public static final LinkDesignEntity INSTANCE = new LinkDesignEntity();
	
	protected LinkDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.LinkDesign createInstance() {
		return new org.instantlogic.designer.LinkDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.LinkDesign> getInstanceClass() {
		return org.instantlogic.designer.LinkDesign.class;
	}
	
	@Override
	public String getName() {
		return "LinkDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.LinkDesign, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign> caption
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.LinkDesign, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign>(
			"caption", INSTANCE, org.instantlogic.designer.entity.TextDesignEntity.INSTANCE, org.instantlogic.designer.TextDesign.class, org.instantlogic.designer.entity.TextDesignEntity.captionOnButton
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.LinkDesign, org.instantlogic.designer.TextDesign> get(
					org.instantlogic.designer.LinkDesign instance) {
				return instance.getCaptionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.LinkDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.LinkDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"event", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.firesFromButtons
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.LinkDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.LinkDesign instance) {
				return instance.getEventRelationValue();
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		caption,
		event,
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
