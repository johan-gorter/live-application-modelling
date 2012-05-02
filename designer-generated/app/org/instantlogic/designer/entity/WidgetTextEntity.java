package org.instantlogic.designer.entity;

public class WidgetTextEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.WidgetText> {

	public static final WidgetTextEntity INSTANCE = new WidgetTextEntity();
	
	protected WidgetTextEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.WidgetText createInstance() {
		return new org.instantlogic.designer.WidgetText();
	}
	
	@Override
	public Class<org.instantlogic.designer.WidgetText> getInstanceClass() {
		return org.instantlogic.designer.WidgetText.class;
	}
	
	@Override
	public String getName() {
		return "WidgetText";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetText, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign> text
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetText, org.instantlogic.designer.TextDesign, org.instantlogic.designer.TextDesign>(
			"text", INSTANCE, org.instantlogic.designer.entity.TextDesignEntity.INSTANCE, org.instantlogic.designer.TextDesign.class, org.instantlogic.designer.entity.TextDesignEntity.textForWidget
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetText, org.instantlogic.designer.TextDesign> get(
					org.instantlogic.designer.WidgetText instance) {
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
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetText, org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetTemplateDesign> widget
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetText, org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetTemplateDesign>(
			"widget", INSTANCE, org.instantlogic.designer.entity.WidgetTemplateDesignEntity.INSTANCE, org.instantlogic.designer.WidgetTemplateDesign.class, org.instantlogic.designer.entity.WidgetTemplateDesignEntity.texts
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetText, org.instantlogic.designer.WidgetTemplateDesign> get(
					org.instantlogic.designer.WidgetText instance) {
				return instance.getWidgetRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		text,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		widget,
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
