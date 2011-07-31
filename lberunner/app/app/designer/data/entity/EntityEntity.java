package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class EntityEntity extends SimpleEntity {

	public static final EntityEntity INSTANCE = new EntityEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<EntityInstance, EntityInstance, EntityInstance> extendsFrom
		= new SimpleRelation<EntityInstance, EntityInstance, EntityInstance>(
			"extendsFrom", INSTANCE, EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.extensions
		) {
	
			@Override
			public ReadOnlyRelationValue<EntityInstance, EntityInstance> get(
					EntityInstance instance) {
				return instance.extendsFrom;
			}
		};
	
	public static final Relation<EntityInstance, List<AttributeInstance>, AttributeInstance> attributes
		= new SimpleRelation<EntityInstance, List<AttributeInstance>, AttributeInstance>(
			"attributes", INSTANCE, AttributeEntity.INSTANCE, AttributeInstance.class, AttributeEntity.entity
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityInstance, AttributeInstance> get(
					EntityInstance instance) {
				return instance.attributes;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EntityInstance, List<RelationInstance>, RelationInstance> relations
		= new SimpleRelation<EntityInstance, List<RelationInstance>, RelationInstance>(
			"relations", INSTANCE, RelationEntity.INSTANCE, RelationInstance.class, RelationEntity.entity
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityInstance, RelationInstance> get(
					EntityInstance instance) {
				return instance.relations;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<EntityInstance, ApplicationInstance, ApplicationInstance> application
		= new SimpleRelation<EntityInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, EntityEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.entities
		) {
	
			@Override
			public ReadOnlyRelationValue<EntityInstance, ApplicationInstance> get(
					EntityInstance instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<EntityInstance, ApplicationInstance, ApplicationInstance> caseEntityInApplication
		= new SimpleRelation<EntityInstance, ApplicationInstance, ApplicationInstance>(
			"caseEntityInApplication", INSTANCE, EntityEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.caseEntity
		) {
	
			@Override
			public ReadOnlyRelationValue<EntityInstance, ApplicationInstance> get(
					EntityInstance instance) {
				return instance.caseEntityInApplication;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<EntityInstance, List<EntityInstance>, EntityInstance> extensions
		= new SimpleRelation<EntityInstance, List<EntityInstance>, EntityInstance>(
			"extensions", INSTANCE, EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.extendsFrom
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityInstance, EntityInstance> get(
					EntityInstance instance) {
				return instance.extensions;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<EntityInstance, List<RelationInstance>, RelationInstance> reverseRelations
		= new SimpleRelation<EntityInstance, List<RelationInstance>, RelationInstance>(
			"reverseRelations", INSTANCE, EntityEntity.INSTANCE, RelationInstance.class, RelationEntity.to
		) {
	
			@Override
			public ReadOnlyRelationValues<EntityInstance, RelationInstance> get(
					EntityInstance instance) {
				return instance.reverseRelations;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		extendsFrom,
		attributes,
		relations,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
		caseEntityInApplication,
		extensions,
		reverseRelations,
	};

	private EntityEntity() {
		super("Entity");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new EntityInstance(caseInstance, id);
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
