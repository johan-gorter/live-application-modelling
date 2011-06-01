package lbe.model.impl;

import lbe.instance.Instance;
import lbe.model.Entity;
import lbe.model.Relation;

public abstract class SimpleRelation<I extends Instance, To extends Instance> extends Relation<I, To> {

	private final String name;
	private final Entity entity;
	private final Entity to;
	private final Class<To> valueClass;
	private final Relation<To, I> reverseRelation;
	
	
	public SimpleRelation(String name, Entity entity, Entity to,
			Class<To> valueClass, Relation<To, I> reverseRelation) {
		this.name = name;
		this.entity = entity;
		this.to = to;
		this.valueClass = valueClass;
		this.reverseRelation = reverseRelation;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Entity getTo() {
		return to;
	}

	@Override
	public boolean isOwner() {
		return false;
	}

	@Override
	public boolean isMultivalue() {
		return false;
	}

	@Override
	public Relation<To, I> getReverseRelation() {
		return reverseRelation;
	}


	@Override
	public Entity getEntity() {
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public To createTo(I from) {
		To result = (To)getTo().createInstance(from.getCase());
		getReverseRelation().get(result).set(from);
		return result;
	};
}
