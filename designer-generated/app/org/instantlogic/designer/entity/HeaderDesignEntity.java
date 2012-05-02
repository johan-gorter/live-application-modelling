package org.instantlogic.designer.entity;

public class HeaderDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.HeaderDesign> {

	public static final HeaderDesignEntity INSTANCE = new HeaderDesignEntity();
	
	protected HeaderDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.HeaderDesign createInstance() {
		return new org.instantlogic.designer.HeaderDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.HeaderDesign> getInstanceClass() {
		return org.instantlogic.designer.HeaderDesign.class;
	}
	
	@Override
	public String getName() {
		return "HeaderDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.HeaderDesign, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign> text
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.HeaderDesign, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign>(
			"text", INSTANCE, org.instantlogic.designer.entity.TextDesignEntity.INSTANCE, org.instantlogic.designer.TextDesign.class, org.instantlogic.designer.entity.TextDesignEntity.textOnHeader
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.HeaderDesign, org.instantlogic.designer.TextDesign> get(
					org.instantlogic.designer.HeaderDesign instance) {
				return instance.getTextRelationValue();
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
		text,
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
