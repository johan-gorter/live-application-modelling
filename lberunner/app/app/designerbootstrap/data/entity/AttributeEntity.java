package app.designerbootstrap.data.entity;

import app.designerbootstrap.data.instance.AttributeInstance;
import app.designerbootstrap.data.instance.RelationInstance;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleAttribute;
import lbe.model.impl.SimpleEntity;

public class AttributeEntity extends SimpleEntity {

	public static final AttributeEntity INSTANCE = new AttributeEntity();
	
	// Attributes
	public static Attribute<AttributeInstance, Boolean, Boolean> multivalue =
		new SimpleAttribute<AttributeInstance, Boolean, Boolean>("multivalue", INSTANCE, Boolean.class) {

		@Override
		public AttributeValue<AttributeInstance, Boolean> get(
				AttributeInstance instance) {
			return instance.multivalue;
		}
	};
	
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{
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
