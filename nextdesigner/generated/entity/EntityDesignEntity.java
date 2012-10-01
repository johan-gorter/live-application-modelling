package org.instantlogic.designer.entity;

public class EntityDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.EntityDesign> {

	public static final EntityDesignEntity INSTANCE = new EntityDesignEntity();
	
	
	protected EntityDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.EntityDesign createInstance() {
		return new org.instantlogic.designer.EntityDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.EntityDesign> getInstanceClass() {
		return org.instantlogic.designer.EntityDesign.class;
	}
	
	@Override
	public String getName() {
		return "EntityDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> attributes
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
			"attributes", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, 
			org.instantlogic.designer.entity.AttributeDesignEntity.attributeOf
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getAttributesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
			"dataType", INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.DataTypeDesign.class, 
			org.instantlogic.designer.entity.DataTypeDesignEntity.forEntity
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getDataTypeRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> extendsFrom
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"extendsFrom", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			org.instantlogic.designer.entity.EntityDesignEntity.extensions
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getExtendsFromRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> relations
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
			"relations", INSTANCE, org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE, org.instantlogic.designer.RelationDesign.class, 
			org.instantlogic.designer.entity.RelationDesignEntity.from
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.RelationDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getRelationsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> staticInstances
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign>(
			"staticInstances", INSTANCE, org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE, org.instantlogic.designer.StaticInstanceDesign.class, 
			org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.StaticInstanceDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getStaticInstancesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"application", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.entities
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getApplicationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> extensions
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
			"extensions", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getExtensionsRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> reverseRelations
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
			"reverseRelations", INSTANCE, org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE, org.instantlogic.designer.RelationDesign.class, org.instantlogic.designer.entity.RelationDesignEntity.to
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.RelationDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getReverseRelationsRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributes,
		dataType,
		extendsFrom,
		relations,
		staticInstances,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		extensions,
		reverseRelations,
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
