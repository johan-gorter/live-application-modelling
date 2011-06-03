package lbe.model.impl;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;

public abstract class SimpleEntity extends Entity {

	private final Attribute<? extends Instance, ? extends Object, ? extends Object>[] attributes;
	private final Relation<? extends Instance, ? extends Object, ? extends Instance>[] relations;
	private final Relation<? extends Instance, ? extends Object, ? extends Instance>[] reverseRelations;
	private final String name;
	
	public SimpleEntity(
			String name,
			Attribute<? extends Instance, ? extends Object, ? extends Object>[] attributes,
			Relation<? extends Instance, ? extends Object, ? extends Instance>[] relations,
			Relation<? extends Instance, ? extends Object, ? extends Instance>[] reverseRelations) {
		this.name = name;
		this.attributes = attributes;
		this.relations = relations;
		this.reverseRelations = reverseRelations;
	}

	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getAttributes() {
		return attributes;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getRelations() {
		return relations;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getReverseRelations() {
		return reverseRelations;
	}

	@Override
	public String getName() {
		return name;
	}

}
