package app.designerbootstrap.data.entity;

import java.util.List;

import app.designerbootstrap.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributeEntity extends SimpleEntity {

	public static final AttributeEntity INSTANCE = new AttributeEntity();
	
	// Attributes
	
	public static final Attribute<AttributeInstance, java.lang.Boolean, java.lang.Boolean> readonly 
		= new SimpleAttribute<AttributeInstance, java.lang.Boolean, java.lang.Boolean>(
			"readonly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeInstance, java.lang.Boolean> get(AttributeInstance instance) {
				return instance.readonly;
			}
		};
	
	public static final Attribute<AttributeInstance, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new SimpleAttribute<AttributeInstance, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeInstance, java.lang.Boolean> get(AttributeInstance instance) {
				return instance.multivalue;
			}
		};
	
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

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		readonly,
		multivalue,
		className,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		entity,
	};

	private AttributeEntity() {
		super("Attribute");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new AttributeInstance(caseInstance);
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
