package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributeEntity extends SimpleEntity {

	public static final AttributeEntity INSTANCE = new AttributeEntity();
	
	// Attributes
	
	public static final Attribute<AttributeInstance, java.lang.String, java.lang.String> className 
		= new SimpleAttribute<AttributeInstance, java.lang.String, java.lang.String>(
			"className", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeInstance, java.lang.String> get(AttributeInstance instance) {
				return instance.className;
			}
		};
	
	// Relations
	
	public static final Relation<AttributeInstance, TextInstance, TextInstance> question
		= new SimpleRelation<AttributeInstance, TextInstance, TextInstance>(
			"question", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.questionOnAttribute
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeInstance, TextInstance> get(
					AttributeInstance instance) {
				return instance.question;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	public static final Relation<AttributeInstance, TextInstance, TextInstance> explanation
		= new SimpleRelation<AttributeInstance, TextInstance, TextInstance>(
			"explanation", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.explanationOnAttribute
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeInstance, TextInstance> get(
					AttributeInstance instance) {
				return instance.explanation;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	public static final Relation<AttributeInstance, List<DomainEntryInstance>, DomainEntryInstance> domain
		= new SimpleRelation<AttributeInstance, List<DomainEntryInstance>, DomainEntryInstance>(
			"domain", INSTANCE, DomainEntryEntity.INSTANCE, DomainEntryInstance.class, DomainEntryEntity.attribute
		) {
	
			@Override
			public ReadOnlyRelationValues<AttributeInstance, DomainEntryInstance> get(
					AttributeInstance instance) {
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
	
	public static final Relation<AttributeInstance, EntityInstance, EntityInstance> entity
		= new SimpleRelation<AttributeInstance, EntityInstance, EntityInstance>(
			"entity", INSTANCE, AttributeEntity.INSTANCE, EntityInstance.class, EntityEntity.attributes
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeInstance, EntityInstance> get(
					AttributeInstance instance) {
				return instance.entity;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<AttributeInstance, List<FieldInstance>, FieldInstance> fields
		= new SimpleRelation<AttributeInstance, List<FieldInstance>, FieldInstance>(
			"fields", INSTANCE, AttributeEntity.INSTANCE, FieldInstance.class, FieldEntity.attribute
		) {
	
			@Override
			public ReadOnlyRelationValues<AttributeInstance, FieldInstance> get(
					AttributeInstance instance) {
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

	private AttributeEntity() {
		super("Attribute");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new AttributeInstance(caseInstance, id);
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
