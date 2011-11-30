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
	
	public static final Attribute<AttributeBaseInstance, java.lang.Boolean, java.lang.Boolean> readOnly 
		= new SimpleAttribute<AttributeBaseInstance, java.lang.Boolean, java.lang.Boolean>(
			"readOnly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeBaseInstance, java.lang.Boolean> get(AttributeBaseInstance instance) {
				return instance.readOnly;
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
	
	public static final Relation<AttributeBaseInstance, FormattedValueInstance, FormattedValueInstance> valueInTemplatedText
		= new SimpleRelation<AttributeBaseInstance, FormattedValueInstance, FormattedValueInstance>(
			"valueInTemplatedText", INSTANCE, AttributeBaseEntity.INSTANCE, FormattedValueInstance.class, FormattedValueEntity.value
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeBaseInstance, FormattedValueInstance> get(
					AttributeBaseInstance instance) {
				return instance.valueInTemplatedText;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		readOnly,
		multivalue,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		valueInTemplatedText,
	};

	private AttributeBaseEntity() {
		super("AttributeBase");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new AttributeBaseInstance(caseInstance, id);
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
