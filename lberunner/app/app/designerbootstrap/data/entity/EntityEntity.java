package app.designerbootstrap.data.entity;

import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleEntity;
import lbe.model.impl.SimpleRelation;
import app.designerbootstrap.data.instance.ApplicationInstance;
import app.designerbootstrap.data.instance.AttributeInstance;
import app.designerbootstrap.data.instance.EntityInstance;
import app.designerbootstrap.data.instance.RelationInstance;

public class EntityEntity extends SimpleEntity {

	public static final Entity INSTANCE = new EntityEntity();

	
	// Relations
	
	public static final Relation<EntityInstance, List<AttributeInstance>, AttributeInstance> attributes = 
		new SimpleRelation<EntityInstance, List<AttributeInstance>, AttributeInstance>(
			"attributes", INSTANCE, AttributeEntity.INSTANCE,
			AttributeInstance.class, null) {

		@Override
		public RelationValues<EntityInstance, AttributeInstance> get(
				EntityInstance instance) {
			return instance.attributes;
		}

		public boolean isOwner() {
			return true;
		};
	};
	
	public static final Relation<EntityInstance, List<RelationInstance>, RelationInstance> relations = 
		new SimpleRelation<EntityInstance, List<RelationInstance>, RelationInstance>(
			"relations", INSTANCE, RelationEntity.INSTANCE,
			RelationInstance.class, null) {

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
	
	public static final Relation<EntityInstance, ApplicationInstance, ApplicationInstance> application = 
		new SimpleRelation<EntityInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, ApplicationEntity.INSTANCE,
			ApplicationInstance.class, null) {

		@Override
		public RelationValue<EntityInstance, ApplicationInstance> get(
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
			ApplicationInstance.class, null) {

		@Override
		public RelationValue<EntityInstance, ApplicationInstance> get(
				EntityInstance instance) {
			return instance.caseEntityInApplication;
		}

		public boolean isReverse() {
			return true;
		};
		
	};

	
	private static final Attribute[] ATTRIBUTES = new Attribute[] {};
	private static final Relation[] RELATIONS = new Relation[] {
		attributes,
		relations
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[] {
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
