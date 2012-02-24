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
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> extendsFrom
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"extendsFrom", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.extensions
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getExtendsFromRelation();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> attributes
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
			"attributes", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.belongsToEntity
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getAttributesRelation();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> relations
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
			"relations", INSTANCE, org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE, org.instantlogic.designer.RelationDesign.class, org.instantlogic.designer.entity.RelationDesignEntity.from
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.RelationDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getRelationsRelation();
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
				return instance.getApplicationRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> caseEntityInApplication
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"caseEntityInApplication", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.caseEntity
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getCaseEntityInApplicationRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> extensions
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
			"extensions", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getExtensionsRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> reverseRelations
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
			"reverseRelations", INSTANCE, org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE, org.instantlogic.designer.RelationDesign.class, org.instantlogic.designer.entity.RelationDesignEntity.to
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.RelationDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getReverseRelationsRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.SelectedInstanceDeductionDesign>, org.instantlogic.designer.SelectedInstanceDeductionDesign> entityInSelectedInstanceDeductions
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.SelectedInstanceDeductionDesign>, org.instantlogic.designer.SelectedInstanceDeductionDesign>(
			"entityInSelectedInstanceDeductions", INSTANCE, org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.INSTANCE, org.instantlogic.designer.SelectedInstanceDeductionDesign.class, org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.ofEntity
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.SelectedInstanceDeductionDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getEntityInSelectedInstanceDeductionsRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.CastInstanceDeductionDesign>, org.instantlogic.designer.CastInstanceDeductionDesign> entityInCastDeductions
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.CastInstanceDeductionDesign>, org.instantlogic.designer.CastInstanceDeductionDesign>(
			"entityInCastDeductions", INSTANCE, org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.INSTANCE, org.instantlogic.designer.CastInstanceDeductionDesign.class, org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.toEntity
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.CastInstanceDeductionDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getEntityInCastDeductionsRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> parameterInEvent
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
			"parameterInEvent", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, org.instantlogic.designer.entity.EventDesignEntity.parameters
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getParameterInEventRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> parameterInFlows
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, java.util.List<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
			"parameterInFlows", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.parameters
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.EntityDesign instance) {
				return instance.getParameterInFlowsRelation();
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
		extendsFrom,
		attributes,
		relations,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		caseEntityInApplication,
		extensions,
		reverseRelations,
		entityInSelectedInstanceDeductions,
		entityInCastDeductions,
		parameterInEvent,
		parameterInFlows,
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
