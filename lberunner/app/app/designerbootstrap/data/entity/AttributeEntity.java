package app.designerbootstrap.data.entity;

import app.designerbootstrap.data.instance.AttributeInstance;
import app.designerbootstrap.data.instance.ConceptInstance;
import app.designerbootstrap.data.instance.EntityInstance;
import app.designerbootstrap.data.instance.RelationInstance;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.RelationValue;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleAttribute;
import lbe.model.impl.SimpleEntity;
import lbe.model.impl.SimpleRelation;

public class AttributeEntity extends SimpleEntity {

	public static final AttributeEntity INSTANCE = new AttributeEntity();
	
	// Attributes
	
	public static final Attribute<AttributeInstance, String, String> className 
		= new SimpleAttribute<AttributeInstance, String, String>("className", INSTANCE, String.class) {
	
		@Override
		public AttributeValue<AttributeInstance, String> get(
				AttributeInstance instance) {
			return instance.className;
		}
	};

	public static Attribute<AttributeInstance, Boolean, Boolean> multivalue =
		new SimpleAttribute<AttributeInstance, Boolean, Boolean>("multivalue", INSTANCE, Boolean.class) {

		@Override
		public AttributeValue<AttributeInstance, Boolean> get(
				AttributeInstance instance) {
			return instance.multivalue;
		}
	};
	
	// Reverse relations
	
	public static final Relation<AttributeInstance, EntityInstance, EntityInstance> entity = 
		new SimpleRelation<AttributeInstance, EntityInstance, EntityInstance>(
			"entity", INSTANCE, EntityEntity.INSTANCE,
			EntityInstance.class, EntityEntity.attributes) {

		@Override
		public ReadOnlyRelationValue<AttributeInstance, EntityInstance> get(
				AttributeInstance instance) {
			return instance.entity;
		}
		
		public boolean isReverse() {
			return true;
		};
	};
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		className,
		multivalue
	};
	private static final Relation[] RELATIONS = new Relation[]{};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{};
	
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
