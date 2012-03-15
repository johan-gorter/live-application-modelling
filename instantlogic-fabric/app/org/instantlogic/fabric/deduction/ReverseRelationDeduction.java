package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class ReverseRelationDeduction<From extends Instance, To extends Instance> extends AttributeDeduction<From, To> {

	public static <From extends Instance, To extends Instance> ReverseRelationDeduction<From, To> create(Relation<From, ? extends Object, To> relation, Deduction<To> input) {
		return new ReverseRelationDeduction<From, To>(relation, input);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ReverseRelationDeduction(Relation<From,? extends Object,To> relation, Deduction<To> input) {
		super((Relation)relation.getReverseRelation(), input);
	}
	
	@Override
	public ValueAndLevel<From> deduct(DeductionContext context) {
		return super.deduct(context);
	}
}
