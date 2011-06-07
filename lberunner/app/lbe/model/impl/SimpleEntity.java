package lbe.model.impl;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;

public abstract class SimpleEntity extends Entity {

	private final String name;
	
	public SimpleEntity(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Entity extendsEntity() {
		return null;
	}
}
