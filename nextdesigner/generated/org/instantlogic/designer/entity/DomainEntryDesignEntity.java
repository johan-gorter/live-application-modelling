package org.instantlogic.designer.entity;

public class DomainEntryDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DomainEntryDesign> {

	public static final DomainEntryDesignEntity INSTANCE = new DomainEntryDesignEntity();
	
	
	protected DomainEntryDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.DomainEntryDesign createInstance() {
		return new org.instantlogic.designer.DomainEntryDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DomainEntryDesign> getInstanceClass() {
		return org.instantlogic.designer.DomainEntryDesign.class;
	}
	
	@Override
	public String getName() {
		return "DomainEntryDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> display
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
			"display", INSTANCE, org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE, org.instantlogic.designer.TextTemplateDesign.class, 
			org.instantlogic.designer.entity.TextTemplateDesignEntity.displayOnDomainEntry
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.TextTemplateDesign> get(
					org.instantlogic.designer.DomainEntryDesign instance) {
				return instance.getDisplayRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attributes
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attributes", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.domain
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DomainEntryDesign instance) {
				return instance.getAttributesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		display,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributes,
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
