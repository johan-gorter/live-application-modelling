package org.instantlogic.core.model;

import org.instantlogic.core.Instance;
import org.instantlogic.core.text.Text;


public abstract class Relation<I extends Instance<I>, Value extends Object, To extends Instance<To>> extends Attribute<I, Value, To> {
	
	public abstract Entity<To> getTo();
	
	public abstract boolean isOwner(); // Delete cascades

	public abstract boolean isAutoCreate(); // Create cascades also (only valid if isOwner and !isMultivalue)
	
	public abstract boolean isMultivalue();
	
	public abstract boolean isReverse();
	
	public abstract void setReverseRelation(Relation<To, ? extends Object, I> reverse);
	
	public abstract Relation<To, ? extends Object, I> getReverseRelation();
	
	public abstract To createTo(I from);
	
	@Override
	public Text getQuestion() {
		return null;
	}
	
}
