package org.instantlogic.designer.entity;

public class FragmentChildListEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentChildList> {

	public static final FragmentChildListEntity INSTANCE = new FragmentChildListEntity();
	
	protected FragmentChildListEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.FragmentChildList createInstance() {
		return new org.instantlogic.designer.FragmentChildList();
	}
	
	@Override
	public Class<org.instantlogic.designer.FragmentChildList> getInstanceClass() {
		return org.instantlogic.designer.FragmentChildList.class;
	}
	
	@Override
	public String getName() {
		return "FragmentChildList";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentChildList, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> children
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentChildList, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
			"children", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childrenForFragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FragmentChildList, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.FragmentChildList instance) {
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
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentChildList, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> fragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentChildList, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
			"fragment", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childLists
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentChildList, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.FragmentChildList instance) {
				return instance.getFragmentRelationValue();
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
		fragment,
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
