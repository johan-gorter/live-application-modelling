package org.instantlogic.designer.entity;

public class WidgetValueEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.WidgetValue> {

	public static final WidgetValueEntity INSTANCE = new WidgetValueEntity();
	
	protected WidgetValueEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.WidgetValue createInstance() {
		return new org.instantlogic.designer.WidgetValue();
	}
	
	@Override
	public Class<org.instantlogic.designer.WidgetValue> getInstanceClass() {
		return org.instantlogic.designer.WidgetValue.class;
	}
	
	@Override
	public String getName() {
		return "WidgetValue";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetValue, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> deduction
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetValue, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"deduction", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.valueForWidget
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetValue, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.WidgetValue instance) {
				return instance.getDeductionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetValue, org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetTemplateDesign> widget
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetValue, org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetTemplateDesign>(
			"widget", INSTANCE, org.instantlogic.designer.entity.WidgetTemplateDesignEntity.INSTANCE, org.instantlogic.designer.WidgetTemplateDesign.class, org.instantlogic.designer.entity.WidgetTemplateDesignEntity.values
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetValue, org.instantlogic.designer.WidgetTemplateDesign> get(
					org.instantlogic.designer.WidgetValue instance) {
				return instance.getWidgetRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deduction,
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
