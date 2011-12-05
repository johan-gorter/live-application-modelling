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
		className,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		question,
		explanation,
		domain,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		entity,
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
		return AttributeBaseEntity.INSTANCE;
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
