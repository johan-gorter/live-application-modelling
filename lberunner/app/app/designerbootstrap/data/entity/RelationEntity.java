package app.designerbootstrap.data.entity;

import java.util.List;

import app.designerbootstrap.data.instance.AttributeInstance;
import app.designerbootstrap.data.instance.EntityInstance;
import app.designerbootstrap.data.instance.RelationInstance;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleAttribute;
import lbe.model.impl.SimpleEntity;
import lbe.model.impl.SimpleRelation;

public class RelationEntity extends SimpleEntity {

	public static final RelationEntity INSTANCE = new RelationEntity();

	// Attributes
	public static Attribute<RelationInstance, Boolean, Boolean> owner =
		new SimpleAttribute<RelationInstance, Boolean, Boolean>("owner", INSTANCE, Boolean.class) {

		@Override
		public AttributeValue<RelationInstance, Boolean> get(
				RelationInstance instance) {
			return instance.owner;
		}
	};
		

	// Relations
	public static final Relation<RelationInstance, EntityInstance, EntityInstance> to = 
		new SimpleRelation<RelationInstance, EntityInstance, EntityInstance>(
			"to", INSTANCE, EntityEntity.INSTANCE,
			EntityInstance.class, null) {

		@Override
		public RelationValue<RelationInstance, EntityInstance> get(
				RelationInstance instance) {
			return instance.to;
		}
	};
	
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{};
	private static final Relation[] RELATIONS = new Relation[]{
		to
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{};

	private RelationEntity() {
		super("Relation");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new RelationInstance(caseInstance);
	}

	@Override
	public Entity extendsEntity() {
		return AttributeEntity.INSTANCE;
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
