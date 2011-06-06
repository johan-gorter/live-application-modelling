package app.designerbootstrap.data.entity;

import app.designerbootstrap.data.instance.AttributeInstance;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleEntity;

public class AttributeEntity extends SimpleEntity {

	public static final AttributeEntity INSTANCE = new AttributeEntity();
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{};
	private static final Relation[] RELATIONS = new Relation[]{};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{};
	
	private AttributeEntity() {
		super("Attribute", ATTRIBUTES, RELATIONS, REVERSE_RELATIONS);
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new AttributeInstance(caseInstance);
	}

	@Override
	public Entity extendsEntity() {
		return ConceptEntity.INSTANCE;
	}
}
