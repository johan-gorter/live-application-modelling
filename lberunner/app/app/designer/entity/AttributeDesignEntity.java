package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributeDesignEntity extends SimpleEntity {

	public static final AttributeDesignEntity INSTANCE = new AttributeDesignEntity();
	
	// Attributes
	
	public static final Attribute<AttributeDesign, java.lang.Boolean, java.lang.Boolean> readOnly 
		= new SimpleAttribute<AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
			"readOnly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeDesign, java.lang.Boolean> get(AttributeDesign instance) {
				return instance.readOnly;
			}
		};
	
	public static final Attribute<AttributeDesign, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new SimpleAttribute<AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeDesign, java.lang.Boolean> get(AttributeDesign instance) {
				return instance.multivalue;
			}
		};
	
	public static final Attribute<AttributeDesign, java.lang.String, java.lang.String> className 
		= new SimpleAttribute<AttributeDesign, java.lang.String, java.lang.String>(
			"className", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeDesign, java.lang.String> get(AttributeDesign instance) {
				return instance.className;
			}
		};
	
	// Relations
	
	public static final Relation<AttributeDesign, TextDesign, TextDesign> question
		= new SimpleRelation<AttributeDesign, TextDesign, TextDesign>(
			"question", INSTANCE, TextDesignEntity.INSTANCE, TextDesign.class, TextDesignEntity.questionOnAttribute
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeDesign, TextDesign> get(
					AttributeDesign instance) {
				return instance.question;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	public static final Relation<AttributeDesign, TextDesign, TextDesign> explanation
		= new SimpleRelation<AttributeDesign, TextDesign, TextDesign>(
			"explanation", INSTANCE, TextDesignEntity.INSTANCE, TextDesign.class, TextDesignEntity.explanationOnAttribute
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeDesign, TextDesign> get(
					AttributeDesign instance) {
				return instance.explanation;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	public static final Relation<AttributeDesign, List<DomainEntryDesign>, DomainEntryDesign> domain
		= new SimpleRelation<AttributeDesign, List<DomainEntryDesign>, DomainEntryDesign>(
			"domain", INSTANCE, DomainEntryDesignEntity.INSTANCE, DomainEntryDesign.class, DomainEntryDesignEntity.attribute
		) {
	
			@Override
			public ReadOnlyRelationValues<AttributeDesign, DomainEntryDesign> get(
					AttributeDesign instance) {
				return instance.domain;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<AttributeDesign, DeductionSchemeDesign, DeductionSchemeDesign> relevance
		= new SimpleRelation<AttributeDesign, DeductionSchemeDesign, DeductionSchemeDesign>(
			"relevance", INSTANCE, DeductionSchemeDesignEntity.INSTANCE, DeductionSchemeDesign.class, DeductionSchemeDesignEntity.relevanceOfAttribute
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeDesign, DeductionSchemeDesign> get(
					AttributeDesign instance) {
				return instance.relevance;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	public static final Relation<AttributeDesign, DeductionSchemeDesign, DeductionSchemeDesign> rule
		= new SimpleRelation<AttributeDesign, DeductionSchemeDesign, DeductionSchemeDesign>(
			"rule", INSTANCE, DeductionSchemeDesignEntity.INSTANCE, DeductionSchemeDesign.class, DeductionSchemeDesignEntity.ruleOfAttribute
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeDesign, DeductionSchemeDesign> get(
					AttributeDesign instance) {
				return instance.rule;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	public static final Relation<AttributeDesign, DeductionSchemeDesign, DeductionSchemeDesign> _default
		= new SimpleRelation<AttributeDesign, DeductionSchemeDesign, DeductionSchemeDesign>(
			"default", INSTANCE, DeductionSchemeDesignEntity.INSTANCE, DeductionSchemeDesign.class, DeductionSchemeDesignEntity.defaultOfAttribute
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeDesign, DeductionSchemeDesign> get(
					AttributeDesign instance) {
				return instance._default;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<AttributeDesign, EntityDesign, EntityDesign> entity
		= new SimpleRelation<AttributeDesign, EntityDesign, EntityDesign>(
			"entity", INSTANCE, AttributeDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.attributes
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeDesign, EntityDesign> get(
					AttributeDesign instance) {
				return instance.entity;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<AttributeDesign, List<AttributeDeductionDesign>, AttributeDeductionDesign> attributeInDeductions
		= new SimpleRelation<AttributeDesign, List<AttributeDeductionDesign>, AttributeDeductionDesign>(
			"attributeInDeductions", INSTANCE, AttributeDesignEntity.INSTANCE, AttributeDeductionDesign.class, AttributeDeductionDesignEntity.attribute
		) {
	
			@Override
			public ReadOnlyRelationValues<AttributeDesign, AttributeDeductionDesign> get(
					AttributeDesign instance) {
				return instance.attributeInDeductions;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<AttributeDesign, List<FieldDesign>, FieldDesign> fields
		= new SimpleRelation<AttributeDesign, List<FieldDesign>, FieldDesign>(
			"fields", INSTANCE, AttributeDesignEntity.INSTANCE, FieldDesign.class, FieldDesignEntity.attribute
		) {
	
			@Override
			public ReadOnlyRelationValues<AttributeDesign, FieldDesign> get(
					AttributeDesign instance) {
				return instance.fields;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		readOnly,
		multivalue,
		className,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		question,
		explanation,
		domain,
		relevance,
		rule,
		_default,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		entity,
		attributeInDeductions,
		fields,
	};

	private AttributeDesignEntity() {
		super("AttributeDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new AttributeDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return DesignEntity.INSTANCE;
	}
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
