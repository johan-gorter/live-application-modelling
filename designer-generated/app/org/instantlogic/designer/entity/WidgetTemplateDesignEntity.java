package org.instantlogic.designer.entity;

public class WidgetTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.WidgetTemplateDesign> {

	public static final WidgetTemplateDesignEntity INSTANCE = new WidgetTemplateDesignEntity();
	
	protected WidgetTemplateDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.WidgetTemplateDesign createInstance() {
		return new org.instantlogic.designer.WidgetTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.WidgetTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.WidgetTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "WidgetTemplateDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.WidgetTemplateDesign, java.lang.String, java.lang.String> widgetTypeName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.WidgetTemplateDesign, java.lang.String, java.lang.String>(
			"widgetTypeName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.WidgetTemplateDesign, java.lang.String> get(org.instantlogic.designer.WidgetTemplateDesign instance) {
				return instance.getWidgetTypeNameAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.usedInField
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.WidgetTemplateDesign instance) {
				return instance.getAttributeRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"entity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.usedInField
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.WidgetTemplateDesign instance) {
				return instance.getEntityRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"event", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.triggeredByWidget
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.WidgetTemplateDesign instance) {
				return instance.getEventRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetValue>, org.instantlogic.designer.WidgetValue> values
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetValue>, org.instantlogic.designer.WidgetValue>(
			"values", INSTANCE, org.instantlogic.designer.entity.WidgetValueEntity.INSTANCE, org.instantlogic.designer.WidgetValue.class, org.instantlogic.designer.entity.WidgetValueEntity.widget
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetValue> get(
					org.instantlogic.designer.WidgetTemplateDesign instance) {
				return instance.getValuesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetText>, org.instantlogic.designer.WidgetText> texts
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetText>, org.instantlogic.designer.WidgetText>(
			"texts", INSTANCE, org.instantlogic.designer.entity.WidgetTextEntity.INSTANCE, org.instantlogic.designer.WidgetText.class, org.instantlogic.designer.entity.WidgetTextEntity.widget
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetText> get(
					org.instantlogic.designer.WidgetTemplateDesign instance) {
				return instance.getTextsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetChildList>, org.instantlogic.designer.WidgetChildList> childLists
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetChildList>, org.instantlogic.designer.WidgetChildList>(
			"childLists", INSTANCE, org.instantlogic.designer.entity.WidgetChildListEntity.INSTANCE, org.instantlogic.designer.WidgetChildList.class, org.instantlogic.designer.entity.WidgetChildListEntity.widget
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetChildList> get(
					org.instantlogic.designer.WidgetTemplateDesign instance) {
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

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		widgetTypeName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
		entity,
		event,
		values,
		texts,
		childLists,
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
