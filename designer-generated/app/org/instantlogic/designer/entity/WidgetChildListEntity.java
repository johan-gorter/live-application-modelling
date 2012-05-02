package org.instantlogic.designer.entity;

public class WidgetChildListEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.WidgetChildList> {

	public static final WidgetChildListEntity INSTANCE = new WidgetChildListEntity();
	
	protected WidgetChildListEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.WidgetChildList createInstance() {
		return new org.instantlogic.designer.WidgetChildList();
	}
	
	@Override
	public Class<org.instantlogic.designer.WidgetChildList> getInstanceClass() {
		return org.instantlogic.designer.WidgetChildList.class;
	}
	
	@Override
	public String getName() {
		return "WidgetChildList";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetChildList, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> children
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetChildList, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
			"children", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childrenForWidget
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.WidgetChildList, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.WidgetChildList instance) {
				return instance.getChildrenRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.WidgetChildList, org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetTemplateDesign> widget
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.WidgetChildList, org.instantlogic.designer.WidgetTemplateDesign, org.instantlogic.designer.WidgetTemplateDesign>(
			"widget", INSTANCE, org.instantlogic.designer.entity.WidgetTemplateDesignEntity.INSTANCE, org.instantlogic.designer.WidgetTemplateDesign.class, org.instantlogic.designer.entity.WidgetTemplateDesignEntity.childLists
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.WidgetChildList, org.instantlogic.designer.WidgetTemplateDesign> get(
					org.instantlogic.designer.WidgetChildList instance) {
				return instance.getWidgetRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		children,
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
