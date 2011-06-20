package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FieldEntity extends SimpleEntity {

	public static final FieldEntity INSTANCE = new FieldEntity();
	
	// Attributes
	
	public static final Attribute<FieldInstance, java.lang.Boolean, java.lang.Boolean> required 
		= new SimpleAttribute<FieldInstance, java.lang.Boolean, java.lang.Boolean>(
			"required", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<FieldInstance, java.lang.Boolean> get(FieldInstance instance) {
				return instance.required;
			}
		};
	
	public static final Attribute<FieldInstance, java.lang.Boolean, java.lang.Boolean> readOnly 
		= new SimpleAttribute<FieldInstance, java.lang.Boolean, java.lang.Boolean>(
			"readOnly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<FieldInstance, java.lang.Boolean> get(FieldInstance instance) {
				return instance.readOnly;
			}
		};
	
	// Relations
	
	public static final Relation<FieldInstance, AttributeInstance, AttributeInstance> attribute
		= new SimpleRelation<FieldInstance, AttributeInstance, AttributeInstance>(
			"attribute", INSTANCE, AttributeEntity.INSTANCE, AttributeInstance.class, AttributeEntity.fields
		) {
	
			@Override
			public ReadOnlyRelationValue<FieldInstance, AttributeInstance> get(
					FieldInstance instance) {
				return instance.attribute;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		required,
		readOnly,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		attribute,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private FieldEntity() {
		super("Field");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new FieldInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return PageElementBaseEntity.INSTANCE;
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
