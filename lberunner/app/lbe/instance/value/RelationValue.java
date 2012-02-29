package lbe.instance.value;

import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Relation;

public interface RelationValue<I extends Instance, Value extends Object> 
	extends ReadOnlyRelationValue<I, Value>, AttributeValue<I, Value> {

}
