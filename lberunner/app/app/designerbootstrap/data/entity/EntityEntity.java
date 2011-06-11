package app.designerbootstrap.data.entity;

import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.ReadOnlyRelationValues;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleEntity;
import lbe.model.impl.SimpleRelation;
import app.designerbootstrap.data.instance.ApplicationInstance;
import app.designerbootstrap.data.instance.AttributeInstance;
import app.designerbootstrap.data.instance.ConceptInstance;
import app.designerbootstrap.data.instance.EntityInstance;
import app.designerbootstrap.data.instance.RelationInstance;

public class EntityEntity extends SimpleEntity {

	public static final Entity INSTANCE = new EntityEntity();

	public static final Relation<EntityInstance, EntityInstance, EntityInstance> extendsFrom
		= new SimpleRelation<EntityInstance, EntityInstance, EntityInstance>("extendsFrom", INSTANCE, 
				EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.extensions) {

		@Override
		public RelationValue<EntityInstance, EntityInstance> get(
				EntityInstance instance) {
			return instance.extendsFrom;
		}
	
	};

	public static final Relation<EntityInstance, List<EntityInstance>, EntityInstance> extensions
		= new SimpleRelation<EntityInstance, List<EntityInstance>, EntityInstance>("extensions", INSTANCE, 
				EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.extendsFrom) {
	
			@Override
			public ReadOnlyRelationValues<EntityInstance, EntityInstance> get(
					EntityInstance instance) {
				return instance.extensions;
			}
			
			public boolean isMultivalue() {
				return true;
			};
		
		};
	
	
	// Relations
	
	public static final Relation<EntityInstance, List<AttributeInstance>, AttributeInstance> attributes = 
		new SimpleRelation<EntityInstance, List<AttributeInstance>, AttributeInstance>(
			"attributes", INSTANCE, AttributeEntity.INSTANCE,
			AttributeInstance.class, AttributeEntity.entity) {

		@Override
		public RelationValues<EntityInstance, AttributeInstance> get(
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
	
	public static final Relation<EntityInstance, List<RelationInstance>, RelationInstance> relations = 
		new SimpleRelation<EntityInstance, List<RelationInstance>, RelationInstance>(
			"relations", INSTANCE, RelationEntity.INSTANCE,
			RelationInstance.class, RelationEntity.entity) {

		@Override
		public RelationValues<EntityInstance, RelationInstance> get(
				EntityInstance instance) {
			return instance.relations;
		}

		public boolean isOwner() {
			return true;
		};
		
		public boolean isMultivalue() {
			return true;
		};
	};
	
	// Reverse relations

	public static final Relation<EntityInstance, List<RelationInstance>, RelationInstance> reverseRelations = 
		new SimpleRelation<EntityInstance, List<RelationInstance>, RelationInstance>(
			"reverseRelations", INSTANCE, RelationEntity.INSTANCE,
			RelationInstance.class, RelationEntity.to) {

		@Override
		public ReadOnlyRelationValues<EntityInstance, RelationInstance> get(
				EntityInstance instance) {
			return instance.reverseRelations;
		}

		public boolean isOwner() {
			return true;
		};
		
		public boolean isMultivalue() {
			return true;
		};
		
		public boolean isReverse() {
			return true;
		};
	};
	
	public static final Relation<EntityInstance, ApplicationInstance, ApplicationInstance> application = 
		new SimpleRelation<EntityInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, ApplicationEntity.INSTANCE,
			ApplicationInstance.class, ApplicationEntity.entities) {

		@Override
		public ReadOnlyRelationValue<EntityInstance, ApplicationInstance> get(
				EntityInstance instance) {
			return instance.application;
		}

		public boolean isReverse() {
			return true;
		};
		
	};
	
	public static Relation<EntityInstance, ApplicationInstance, ApplicationInstance> caseEntityInApplication = 
		new SimpleRelation<EntityInstance, ApplicationInstance, ApplicationInstance>(
			"caseEntityInApplication", INSTANCE, ApplicationEntity.INSTANCE,
			ApplicationInstance.class, ApplicationEntity.caseEntity) {

		@Override
		public ReadOnlyRelationValue<EntityInstance, ApplicationInstance> get(
				EntityInstance instance) {
			return instance.caseEntityInApplication;
		}

		public boolean isReverse() {
			return true;
		};
		
	};

	
	private static final Attribute[] ATTRIBUTES = new Attribute[] {};
	private static final Relation[] RELATIONS = new Relation[] {
		extendsFrom,
		attributes,
		relations
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[] {
		reverseRelations,
		extensions,
		application,
		caseEntityInApplication
	};

	private EntityEntity() {
		super("Entity");
	}

	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new EntityInstance(caseInstance);
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
