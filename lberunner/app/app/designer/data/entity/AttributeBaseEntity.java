package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributeBaseEntity extends SimpleEntity {

	public static final AttributeBaseEntity INSTANCE = new AttributeBaseEntity();
	
	// Attributes
	
	public static final Attribute<AttributeBaseInstance, java.lang.Boolean, java.lang.Boolean> readonly 
		= new SimpleAttribute<AttributeBaseInstance, java.lang.Boolean, java.lang.Boolean>(
			"readonly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeBaseInstance, java.lang.Boolean> get(AttributeBaseInstance instance) {
				return instance.readonly;
			}
		};
	
	public static final Attribute<AttributeBaseInstance, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new SimpleAttribute<AttributeBaseInstance, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeBaseInstance, java.lang.Boolean> get(AttributeBaseInstance instance) {
				return instance.multivalue;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		readonly,
		multivalue,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private AttributeBaseEntity() {
		super("AttributeBase");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new AttributeBaseInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return ConceptEntity.INSTANCE;
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
