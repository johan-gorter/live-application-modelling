package org.instantlogic.designer.entity;

public class CompositeTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.CompositeTemplateDesign> {

	public static final CompositeTemplateDesignEntity INSTANCE = new CompositeTemplateDesignEntity();
	
	protected CompositeTemplateDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.CompositeTemplateDesign createInstance() {
		return new org.instantlogic.designer.CompositeTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.CompositeTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.CompositeTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "CompositeTemplateDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> children
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
			"children", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childOf
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.CompositeTemplateDesign instance) {
				return instance.getChildrenRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionSchemeDesign>, org.instantlogic.designer.DeductionSchemeDesign> selections
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionSchemeDesign>, org.instantlogic.designer.DeductionSchemeDesign>(
			"selections", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.compositeTemplate
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.CompositeTemplateDesign instance) {
				return instance.getSelectionsRelationValue();
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
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		children,
		selections,
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
